package com.example.data

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.floatPreferencesKey
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringSetPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private val Context.academyDataStore: DataStore<Preferences> by preferencesDataStore(
    name = "quran_learning_academy_prefs"
)

class AcademyPreferencesRepository(private val context: Context) {

    private object Keys {
        val LAST_READ_SURAH = intPreferencesKey("last_read_surah")
        val BOOKMARKED_AYAHS = stringSetPreferencesKey("bookmarked_ayahs")
        val BOOKMARKED_HADITHS = stringSetPreferencesKey("bookmarked_hadiths")
        val BOOKMARKED_DUAS = stringSetPreferencesKey("bookmarked_duas")
        val STUDIED_SURAHS = stringSetPreferencesKey("studied_surahs")
        val COMPLETED_LESSONS = stringSetPreferencesKey("completed_lessons")
        val COUNTER_VALUE = intPreferencesKey("tasbih_count")
        val COUNTER_TARGET = intPreferencesKey("tasbih_target")
        val TOTAL_REMEMBRANCE = intPreferencesKey("total_dhikr")
        val BEST_QUIZ_SCORE = intPreferencesKey("best_quiz_score")
        val ARABIC_FONT_SIZE = floatPreferencesKey("arabic_font_size")
        val SHOW_TRANSLITERATION = booleanPreferencesKey("show_transliteration")
        val DARK_MODE = booleanPreferencesKey("dark_mode")
    }

    val userProgressFlow: Flow<UserProgress> = context.academyDataStore.data.map { prefs ->
        UserProgress(
            lastReadSurahNumber = prefs[Keys.LAST_READ_SURAH] ?: 1,
            bookmarkedAyahKeys = prefs[Keys.BOOKMARKED_AYAHS] ?: emptySet(),
            bookmarkedHadithIds = prefs[Keys.BOOKMARKED_HADITHS] ?: emptySet(),
            bookmarkedDuaIds = prefs[Keys.BOOKMARKED_DUAS] ?: emptySet(),
            studiedSurahNumbers = (prefs[Keys.STUDIED_SURAHS] ?: emptySet())
                .mapNotNull { it.toIntOrNull() }
                .toSet(),
            completedLessonIds = prefs[Keys.COMPLETED_LESSONS] ?: emptySet(),
            counterValue = prefs[Keys.COUNTER_VALUE] ?: 0,
            counterTarget = prefs[Keys.COUNTER_TARGET] ?: 33,
            totalRemembranceCount = prefs[Keys.TOTAL_REMEMBRANCE] ?: 0,
            bestQuizScore = prefs[Keys.BEST_QUIZ_SCORE] ?: 0,
            arabicFontSizeSp = prefs[Keys.ARABIC_FONT_SIZE] ?: 27f,
            showTransliteration = prefs[Keys.SHOW_TRANSLITERATION] ?: true,
            isDarkMode = prefs[Keys.DARK_MODE] ?: false
        )
    }

    suspend fun setLastReadSurah(surahNumber: Int) {
        context.academyDataStore.edit { prefs -> prefs[Keys.LAST_READ_SURAH] = surahNumber }
    }

    suspend fun toggleAyahBookmark(ayahKey: String) {
        context.academyDataStore.edit { prefs ->
            val current = prefs[Keys.BOOKMARKED_AYAHS] ?: emptySet()
            prefs[Keys.BOOKMARKED_AYAHS] = if (ayahKey in current) current - ayahKey else current + ayahKey
        }
    }

    suspend fun toggleHadithBookmark(hadithId: String) {
        context.academyDataStore.edit { prefs ->
            val current = prefs[Keys.BOOKMARKED_HADITHS] ?: emptySet()
            prefs[Keys.BOOKMARKED_HADITHS] = if (hadithId in current) current - hadithId else current + hadithId
        }
    }

    suspend fun toggleDuaBookmark(duaId: String) {
        context.academyDataStore.edit { prefs ->
            val current = prefs[Keys.BOOKMARKED_DUAS] ?: emptySet()
            prefs[Keys.BOOKMARKED_DUAS] = if (duaId in current) current - duaId else current + duaId
        }
    }

    suspend fun toggleSurahStudied(surahNumber: Int) {
        context.academyDataStore.edit { prefs ->
            val key = surahNumber.toString()
            val current = prefs[Keys.STUDIED_SURAHS] ?: emptySet()
            prefs[Keys.STUDIED_SURAHS] = if (key in current) current - key else current + key
        }
    }

    suspend fun toggleLessonCompleted(lessonId: String) {
        context.academyDataStore.edit { prefs ->
            val current = prefs[Keys.COMPLETED_LESSONS] ?: emptySet()
            prefs[Keys.COMPLETED_LESSONS] = if (lessonId in current) current - lessonId else current + lessonId
        }
    }

    suspend fun incrementCounter() {
        context.academyDataStore.edit { prefs ->
            val target = prefs[Keys.COUNTER_TARGET] ?: 33
            val current = prefs[Keys.COUNTER_VALUE] ?: 0
            val next = if (current + 1 > target) 1 else current + 1
            prefs[Keys.COUNTER_VALUE] = next
            prefs[Keys.TOTAL_REMEMBRANCE] = (prefs[Keys.TOTAL_REMEMBRANCE] ?: 0) + 1
        }
    }

    suspend fun resetCounter() {
        context.academyDataStore.edit { prefs -> prefs[Keys.COUNTER_VALUE] = 0 }
    }

    suspend fun setCounterTarget(target: Int) {
        context.academyDataStore.edit { prefs ->
            prefs[Keys.COUNTER_TARGET] = target
            prefs[Keys.COUNTER_VALUE] = 0
        }
    }

    suspend fun recordQuizScore(score: Int) {
        context.academyDataStore.edit { prefs ->
            val best = prefs[Keys.BEST_QUIZ_SCORE] ?: 0
            if (score > best) prefs[Keys.BEST_QUIZ_SCORE] = score
        }
    }

    suspend fun setArabicFontSize(sizeSp: Float) {
        context.academyDataStore.edit { prefs ->
            prefs[Keys.ARABIC_FONT_SIZE] = sizeSp.coerceIn(20f, 38f)
        }
    }

    suspend fun setShowTransliteration(show: Boolean) {
        context.academyDataStore.edit { prefs -> prefs[Keys.SHOW_TRANSLITERATION] = show }
    }

    suspend fun toggleDarkMode() {
        context.academyDataStore.edit { prefs ->
            val current = prefs[Keys.DARK_MODE] ?: false
            prefs[Keys.DARK_MODE] = !current
        }
    }
}
