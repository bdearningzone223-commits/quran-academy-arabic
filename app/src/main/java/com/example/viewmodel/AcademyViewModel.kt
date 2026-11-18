package com.example.viewmodel

import android.app.Application
import android.speech.tts.TextToSpeech
import android.speech.tts.UtteranceProgressListener
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.AcademyPreferencesRepository
import com.example.data.Ayah
import com.example.data.Dua
import com.example.data.Hadith
import com.example.data.HadithDuaData
import com.example.data.QuranData
import com.example.data.Surah
import com.example.data.UserProgress
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.util.Calendar
import java.util.Locale

data class DailyInspiration(
    val surah: Surah,
    val ayah: Ayah,
    val hadith: Hadith,
    val dua: Dua
)

class AcademyViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = AcademyPreferencesRepository(application.applicationContext)

    val userProgress: StateFlow<UserProgress> = repository.userProgressFlow.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5_000),
        initialValue = UserProgress()
    )

    private val _speakingId = MutableStateFlow<String?>(null)
    val speakingId: StateFlow<String?> = _speakingId.asStateFlow()

    private val _duaSessionCounts = MutableStateFlow<Map<String, Int>>(emptyMap())
    val duaSessionCounts: StateFlow<Map<String, Int>> = _duaSessionCounts.asStateFlow()

    private var tts: TextToSpeech? = null
    private var ttsReady = false

    val dailyInspiration: DailyInspiration by lazy {
        val dayOfYear = Calendar.getInstance().get(Calendar.DAY_OF_YEAR)
        val allVerses = QuranData.surahs.flatMap { surah ->
            surah.ayahs.map { ayah -> surah to ayah }
        }
        val (dailySurah, dailyAyah) = allVerses[dayOfYear % allVerses.size]
        val dailyHadith = HadithDuaData.hadiths[dayOfYear % HadithDuaData.hadiths.size]
        val dailyDua = HadithDuaData.duas[dayOfYear % HadithDuaData.duas.size]
        DailyInspiration(dailySurah, dailyAyah, dailyHadith, dailyDua)
    }

    init {
        initTts()
    }

    private fun initTts() {
        tts = TextToSpeech(getApplication()) { status ->
            if (status == TextToSpeech.SUCCESS) {
                ttsReady = true
                tts?.language = Locale.US
                tts?.setOnUtteranceProgressListener(object : UtteranceProgressListener() {
                    override fun onStart(utteranceId: String?) {}
                    override fun onDone(utteranceId: String?) {
                        _speakingId.value = null
                    }
                    @Deprecated("Deprecated in Java")
                    override fun onError(utteranceId: String?) {
                        _speakingId.value = null
                    }
                })
            }
        }
    }

    fun speakText(id: String, text: String) {
        if (!ttsReady) return
        if (_speakingId.value == id) {
            stopSpeaking()
            return
        }
        val engine = tts ?: return
        engine.language = Locale.US
        engine.setSpeechRate(0.92f)
        _speakingId.value = id
        engine.speak(text, TextToSpeech.QUEUE_FLUSH, null, id)
    }

    fun stopSpeaking() {
        tts?.stop()
        _speakingId.value = null
    }

    fun openSurah(surahNumber: Int) {
        viewModelScope.launch { repository.setLastReadSurah(surahNumber) }
    }

    fun toggleAyahBookmark(surahNumber: Int, ayahNumber: Int) {
        viewModelScope.launch { repository.toggleAyahBookmark("$surahNumber:$ayahNumber") }
    }

    fun toggleHadithBookmark(hadithId: String) {
        viewModelScope.launch { repository.toggleHadithBookmark(hadithId) }
    }

    fun toggleDuaBookmark(duaId: String) {
        viewModelScope.launch { repository.toggleDuaBookmark(duaId) }
    }

    fun toggleSurahStudied(surahNumber: Int) {
        viewModelScope.launch { repository.toggleSurahStudied(surahNumber) }
    }

    fun toggleLessonCompleted(lessonId: String) {
        viewModelScope.launch { repository.toggleLessonCompleted(lessonId) }
    }

    fun incrementCounter() {
        viewModelScope.launch { repository.incrementCounter() }
    }

    fun resetCounter() {
        viewModelScope.launch { repository.resetCounter() }
    }

    fun setCounterTarget(target: Int) {
        viewModelScope.launch { repository.setCounterTarget(target) }
    }

    fun incrementDuaRepeat(duaId: String, recommendedCount: Int) {
        _duaSessionCounts.update { map ->
            val current = map[duaId] ?: 0
            val next = if (current >= recommendedCount) 0 else current + 1
            map + (duaId to next)
        }
    }

    fun recordQuizScore(score: Int) {
        viewModelScope.launch { repository.recordQuizScore(score) }
    }

    fun adjustArabicFontSize(deltaSp: Float) {
        val current = userProgress.value.arabicFontSizeSp
        viewModelScope.launch { repository.setArabicFontSize(current + deltaSp) }
    }

    fun toggleTransliteration() {
        val current = userProgress.value.showTransliteration
        viewModelScope.launch { repository.setShowTransliteration(!current) }
    }

    fun toggleDarkMode() {
        viewModelScope.launch { repository.toggleDarkMode() }
    }

    override fun onCleared() {
        tts?.stop()
        tts?.shutdown()
        super.onCleared()
    }
}
