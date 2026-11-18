package com.example.data

data class Ayah(
    val numberInSurah: Int,
    val arabic: String,
    val transliteration: String,
    val translation: String
)

enum class RevelationType(val label: String) {
    MAKKI("Makki"),
    MADANI("Madani")
}

data class Surah(
    val number: Int,
    val englishName: String,
    val meaning: String,
    val arabicName: String,
    val revelationType: RevelationType,
    val totalVersesInQuran: Int,
    val isCompleteInApp: Boolean = true,
    val showBismillahHeader: Boolean = true,
    val introduction: String,
    val ayahs: List<Ayah>
)

enum class HadithCategory(val label: String) {
    ALL("All"),
    FAITH("Faith"),
    CHARACTER("Character"),
    KNOWLEDGE("Knowledge"),
    WORSHIP("Worship"),
    KINDNESS("Kindness")
}

data class Hadith(
    val id: String,
    val title: String,
    val arabic: String,
    val translation: String,
    val narrator: String,
    val source: String,
    val category: HadithCategory,
    val reflection: String
)

enum class DuaCategory(val label: String) {
    ALL("All"),
    MORNING_EVENING("Morning & Evening"),
    PRAYER("Prayer & Mosque"),
    DAILY_LIFE("Daily Life"),
    GUIDANCE("Guidance & Peace"),
    KNOWLEDGE("Knowledge")
}

data class Dua(
    val id: String,
    val title: String,
    val arabic: String,
    val transliteration: String,
    val translation: String,
    val occasion: String,
    val reference: String,
    val category: DuaCategory,
    val recommendedCount: Int = 1
)

data class ArabicLetter(
    val order: Int,
    val name: String,
    val isolated: String,
    val initial: String,
    val medial: String,
    val finalForm: String,
    val transliteration: String,
    val makhrajGroup: String,
    val pronunciationTip: String,
    val exampleWord: String,
    val exampleMeaning: String
)

data class TajweedExample(
    val arabic: String,
    val transliteration: String,
    val note: String
)

data class TajweedLesson(
    val id: String,
    val number: Int,
    val title: String,
    val arabicTerm: String,
    val level: String,
    val summary: String,
    val explanation: String,
    val keyRulePoints: List<String>,
    val examples: List<TajweedExample>
)

data class QuizQuestion(
    val id: String,
    val topic: String,
    val question: String,
    val arabicPrompt: String? = null,
    val options: List<String>,
    val correctIndex: Int,
    val explanation: String
)

data class UserProgress(
    val lastReadSurahNumber: Int = 1,
    val bookmarkedAyahKeys: Set<String> = emptySet(),
    val bookmarkedHadithIds: Set<String> = emptySet(),
    val bookmarkedDuaIds: Set<String> = emptySet(),
    val studiedSurahNumbers: Set<Int> = emptySet(),
    val completedLessonIds: Set<String> = emptySet(),
    val counterValue: Int = 0,
    val counterTarget: Int = 33,
    val totalRemembranceCount: Int = 0,
    val bestQuizScore: Int = 0,
    val arabicFontSizeSp: Float = 27f,
    val showTransliteration: Boolean = true,
    val isDarkMode: Boolean = false
)
