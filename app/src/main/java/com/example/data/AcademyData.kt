package com.example.data

object AcademyData {
    val arabicLetters: List<ArabicLetter> = listOf(
        ArabicLetter(1, "Alif", "ا", "ا", "ـا", "ـا", "ā / a", "Al-Jawf (Empty Space)", "Long open vowel sound originating smoothly from the empty space in the throat and mouth.", "اللَّه", "Allah"),
        ArabicLetter(2, "Ba", "ب", "بـ", "ـبـ", "ـب", "b", "Ash-Shafatan (Lips)", "Press both moist lips together lightly as in 'book'.", "بِسْمِ", "In the name"),
        ArabicLetter(3, "Ta", "ت", "تـ", "ـتـ", "ـت", "t", "Al-Lisan (Tongue)", "Touch the tip of the tongue to the base of the upper front teeth softly.", "تَقْوَى", "God-consciousness"),
        ArabicLetter(4, "Tha", "ث", "ثـ", "ـثـ", "ـث", "th", "Al-Lisan (Tongue)", "Place the tip of the tongue gently at the edge of the upper front teeth, like 'think'.", "ثَوَاب", "Reward"),
        ArabicLetter(5, "Jeem", "ج", "جـ", "ـجـ", "ـج", "j", "Al-Lisan (Tongue)", "Raise the middle of the tongue to the hard palate clearly, as in 'jam'.", "جَنَّة", "Paradise"),
        ArabicLetter(6, "Ha", "ح", "حـ", "ـحـ", "ـح", "ḥ", "Al-Halq (Throat)", "A crisp, breathy 'h' released cleanly from the middle of the throat.", "حَمْد", "Praise"),
        ArabicLetter(7, "Kha", "خ", "خـ", "ـخـ", "ـخ", "kh", "Al-Halq (Throat)", "Produced from the upper throat near the soft palate with a gentle friction sound.", "خَيْر", "Goodness"),
        ArabicLetter(8, "Dal", "د", "د", "ـد", "ـد", "d", "Al-Lisan (Tongue)", "Touch the tip of the tongue to the roots of the upper front teeth.", "دُعَاء", "Supplication"),
        ArabicLetter(9, "Dhal", "ذ", "ذ", "ـذ", "ـذ", "dh", "Al-Lisan (Tongue)", "Tip of the tongue touches the edge of the upper teeth with voice, like 'this'.", "ذِكْر", "Remembrance"),
        ArabicLetter(10, "Ra", "ر", "ر", "ـر", "ـر", "r", "Al-Lisan (Tongue)", "Light single tap of the tongue tip against the upper gum ridge.", "رَحْمَة", "Mercy"),
        ArabicLetter(11, "Zay", "ز", "ز", "ـز", "ـز", "z", "Al-Lisan (Tongue)", "Voiced buzzing sound between the tongue tip and lower front teeth.", "زَكَاة", "Purifying charity"),
        ArabicLetter(12, "Seen", "س", "سـ", "ـسـ", "ـس", "s", "Al-Lisan (Tongue)", "Crisp, light 's' sound from the tip of the tongue near the lower teeth.", "سَلَام", "Peace"),
        ArabicLetter(13, "Sheen", "ش", "شـ", "ـشـ", "ـش", "sh", "Al-Lisan (Tongue)", "Soft spreading air from the middle of the tongue, like 'shine'.", "شُكْر", "Gratitude"),
        ArabicLetter(14, "Sad", "ص", "صـ", "ـصـ", "ـص", "ṣ", "Al-Lisan (Tongue)", "Heavy, full-mouthed 's' with the back of the tongue raised.", "صَبْر", "Patience"),
        ArabicLetter(15, "Dad", "ض", "ضـ", "ـضـ", "ـض", "ḍ", "Al-Lisan (Tongue)", "Heavy emphatic sound formed by pressing the side of the tongue against upper molars.", "ضُحَى", "Morning light"),
        ArabicLetter(16, "Ta (Heavy)", "ط", "طـ", "ـطـ", "ـط", "ṭ", "Al-Lisan (Tongue)", "Deep, emphatic 't' with the back of the tongue elevated.", "طَيِّب", "Pure & good"),
        ArabicLetter(17, "Dha (Heavy)", "ظ", "ظـ", "ـظـ", "ـظ", "ẓ", "Al-Lisan (Tongue)", "Heavy 'dh' at the edge of the upper front teeth with full-mouth resonance.", "ظِلّ", "Shade"),
        ArabicLetter(18, "Ayn", "ع", "عـ", "ـعـ", "ـع", "'", "Al-Halq (Throat)", "Deep voiced sound gently constricted in the middle of the throat.", "عِلْم", "Knowledge"),
        ArabicLetter(19, "Ghayn", "غ", "غـ", "ـغـ", "ـغ", "gh", "Al-Halq (Throat)", "Smooth voiced uvular sound from the top of the throat.", "غَفُور", "Most Forgiving"),
        ArabicLetter(20, "Fa", "ف", "فـ", "ـفـ", "ـف", "f", "Ash-Shafatan (Lips)", "Edge of the upper front teeth touches the inside of the lower lip.", "فَجْر", "Dawn"),
        ArabicLetter(21, "Qaf", "ق", "قـ", "ـقـ", "ـق", "q", "Al-Lisan (Tongue)", "Deep resonant 'k' articulated from the very back of the tongue against the soft palate.", "قُرْآن", "Quran"),
        ArabicLetter(22, "Kaf", "ك", "كـ", "ـكـ", "ـك", "k", "Al-Lisan (Tongue)", "Light 'k' slightly forward of Qaf, similar to English 'kind'.", "كَرِيم", "Noble"),
        ArabicLetter(23, "Lam", "ل", "لـ", "ـلـ", "ـل", "l", "Al-Lisan (Tongue)", "Front edge of the tongue rests gently against the upper gums.", "لَيْل", "Night"),
        ArabicLetter(24, "Meem", "م", "مـ", "ـمـ", "ـم", "m", "Ash-Shafatan (Lips)", "Close both lips gently while letting soft resonance pass through the nose.", "مَسْجِد", "Mosque"),
        ArabicLetter(25, "Noon", "ن", "نـ", "ـنـ", "ـن", "n", "Al-Lisan & Khayshum", "Tip of the tongue against upper gums with gentle nasal resonance.", "نُور", "Light"),
        ArabicLetter(26, "Ha (Soft)", "ه", "هـ", "ـهـ", "ـه", "h", "Al-Halq (Throat)", "Gentle, airy 'h' originating from the deepest part of the throat.", "هُدَى", "Guidance"),
        ArabicLetter(27, "Waw", "و", "و", "ـو", "ـو", "w / ū", "Ash-Shafatan (Lips)", "Round both lips forward smoothly without closing them.", "وَحْي", "Revelation"),
        ArabicLetter(28, "Ya", "ي", "يـ", "ـيـ", "ـي", "y / ī", "Al-Lisan (Tongue)", "Raise the middle of the tongue lightly toward the roof of the mouth.", "يَقِين", "Certainty")
    )

    val tajweedLessons: List<TajweedLesson> = listOf(
        TajweedLesson(
            id = "t1",
            number = 1,
            title = "Makharij al-Huruf",
            arabicTerm = "مَخَارِجُ الْحُرُوف",
            level = "Foundation",
            summary = "The five main articulation regions from which all 28 Arabic letters emerge clearly.",
            explanation = "Tajweed begins by giving every Arabic letter its proper birthplace (Makhraj). Quran recitation maps every letter to five physical areas: Al-Jawf (open vocal tract), Al-Halq (throat), Al-Lisan (tongue), Ash-Shafatan (lips), and Al-Khayshum (nasal passage).",
            keyRulePoints = listOf(
                "Al-Jawf produces the three natural long vowels: Alif, Waw, and Ya.",
                "Al-Halq (throat) holds six letters divided into bottom (ء ه), middle (ع ح), and top (غ خ).",
                "Al-Lisan (tongue) accounts for the largest group — 18 distinct letters.",
                "Ash-Shafatan (lips) articulate ف، ب، م، و.",
                "Al-Khayshum carries the warm nasal hum (Ghunnah) of Noon and Meem."
            ),
            examples = listOf(
                TajweedExample("الْحَمْدُ لِلَّهِ", "Al-ḥamdu lillāh", "Notice the crisp mid-throat ḥ (ح) contrasted with the soft deep-throat h (ه)."),
                TajweedExample("قُلْ هُوَ اللَّهُ أَحَدٌ", "Qul huwallāhu aḥad", "Compare deep back-tongue Qaf (ق) with throat letters Ha (ه) and Ha (ح).")
            )
        ),
        TajweedLesson(
            id = "t2",
            number = 2,
            title = "Qalqalah (Echoing Bounce)",
            arabicTerm = "الْقَلْقَلَة",
            level = "Foundation",
            summary = "A crisp echoing vibration applied to five letters when they carry a Sukoon.",
            explanation = "When five specific letters stop completely with a Sukoon (no vowel), the airflow is blocked. To keep the letter clear without adding a full vowel, a gentle elastic bounce — Qalqalah — is released.",
            keyRulePoints = listOf(
                "Remember the five Qalqalah letters with the phrase: قُطْبُ جَدٍّ (Qaf, Ta, Ba, Jeem, Dal).",
                "Qalqalah Sughra (Minor): occurs when the letter with Sukoon is in the middle of a word or continuous reading.",
                "Qalqalah Kubra (Major): stronger crisp echo when stopping at the end of an ayah."
            ),
            examples = listOf(
                TajweedExample("قُلْ هُوَ اللَّهُ أَحَدٌ", "Qul huwallāhu aḥad", "When stopping on أَحَدْ, the final Dal (د) gets a clear Major Qalqalah."),
                TajweedExample("لَمْ يَلِدْ وَلَمْ يُولَدْ", "Lam yalid wa lam yūlad", "Both Dal letters carry Sukoon — minor on يَلِدْ if continuing, major on يُولَدْ when stopping."),
                TajweedExample("قُلْ أَعُوذُ بِرَبِّ الْفَلَقِ", "Qul a'ūdhu bi-Rabbil-falaq", "Stopping on الفَلَقْ produces a resonant Qalqalah on Qaf (ق).")
            )
        ),
        TajweedLesson(
            id = "t3",
            number = 3,
            title = "Ghunnah (Nasal Resonance)",
            arabicTerm = "الْغُنَّة",
            level = "Foundation",
            summary = "The soothing two-beat nasal hum on Noon and Meem with Shaddah.",
            explanation = "Ghunnah is a warm, melodic sound flowing gently through the nasal passage (Al-Khayshum). Whenever you encounter Noon Mushaddadah (نّ) or Meem Mushaddadah (مّ), hold the nasal hum steadily for two full counts (Harakat).",
            keyRulePoints = listOf(
                "Always hold نّ (Noon with Shaddah) and مّ (Meem with Shaddah) for 2 full beats.",
                "Keep the lips relaxed on مّ and the tongue tip softly anchored on نّ.",
                "Never rush past a Shaddah on Noon or Meem — it gives Quran recitation its calm cadence."
            ),
            examples = listOf(
                TajweedExample("إِنَّ مَعَ الْعُسْرِ يُسْرًا", "Inna ma'al-'usri yusrā", "Hold the nasal hum on إِنَّ for two gentle beats."),
                TajweedExample("مَلِكِ النَّاسِ", "Malikin-nās", "Hold the doubled Noon in النَّاسِ cleanly through the nose."),
                TajweedExample("فَأَمَّا الْيَتِيمَ", "Fa-ammal-yatīm", "Hold the doubled Meem in أَمَّا for two beats.")
            )
        ),
        TajweedLesson(
            id = "t4",
            number = 4,
            title = "Noon Sakinah & Tanween",
            arabicTerm = "أَحْكَامُ النُّونِ السَّاكِنَةِ وَالتَّنْوِين",
            level = "Intermediate",
            summary = "The four golden rules governing how a vowelless Noon (نْ) or Tanween meets the next letter.",
            explanation = "When a vowelless Noon (نْ) or a Tanween (ـً ـٍ ـٌ) is followed by another letter, recitation smoothly adapts in one of four ways to preserve clarity and harmony.",
            keyRulePoints = listOf(
                "Izhar (Clear): Pronounce the 'n' distinctly before the 6 throat letters (ء ه ع ح غ خ).",
                "Idgham (Merging): Blend into the 6 letters of يَرْمَلُون (y, r, m, l, w, n).",
                "Iqlab (Conversion): Turn 'n' into a hidden nasal 'm' before Ba (ب).",
                "Ikhfa (Concealing): Softly veil the 'n' with 2-beat nasal resonance before the remaining 15 letters."
            ),
            examples = listOf(
                TajweedExample("أَنْعَمْتَ عَلَيْهِمْ", "An'amta 'alayhim", "Izhar: نْ before ع is pronounced crisp and clear without extra nasal hold."),
                TajweedExample("مِنْ شَرِّ مَا خَلَقَ", "Min sharri mā khalaq", "Ikhfa: نْ before ش is softly veiled with a 2-beat nasal hum."),
                TajweedExample("خَيْرٌ مِنْ أَلْفِ شَهْرٍ", "Khayrun min alfi shahr", "Idgham with Ghunnah: Tanween merges smoothly into Meem (م).")
            )
        ),
        TajweedLesson(
            id = "t5",
            number = 5,
            title = "Madd (Elongation)",
            arabicTerm = "الْمَدّ",
            level = "Intermediate",
            summary = "Measuring natural and extended vowel stretches accurately in counts (Harakat).",
            explanation = "Madd means stretching a long vowel (Alif after Fathah, Waw after Dammah, Ya after Kasrah). Keeping natural stretches steady at two counts prevents words from distorting in meaning.",
            keyRulePoints = listOf(
                "Madd Tabi'i (Natural): 2 counts whenever no Hamzah or Sukoon follows the vowel.",
                "Madd Muttasil (Connected): 4–5 counts when Hamzah appears in the same word (e.g., جَاءَ).",
                "Madd Arid lis-Sukoon: 2, 4, or 6 counts when stopping at the end of an ayah (e.g., العَالَمِينْ)."
            ),
            examples = listOf(
                TajweedExample("الرَّحْمَٰنِ الرَّحِيمِ", "Ar-Raḥmānir-Raḥīm", "Natural 2-beat Madd in الرَّحْمَٰنِ; optional 2/4/6-beat stopping Madd in الرَّحِيمِ."),
                TajweedExample("إِذَا جَاءَ نَصْرُ اللَّهِ", "Idhā jā'a naṣrullāh", "Stretch جَاءَ for 4–5 counts because Hamzah follows Alif in the same word.")
            )
        ),
        TajweedLesson(
            id = "t6",
            number = 6,
            title = "Sun & Moon Letters",
            arabicTerm = "اللَّامُ الشَّمْسِيَّةُ وَالْقَمَرِيَّة",
            level = "Foundation",
            summary = "Knowing when to pronounce or assimilate the 'L' in the Arabic prefix 'Al-' (ال).",
            explanation = "Arabic nouns beginning with 'Al-' (ال) follow two harmonious patterns named after Ash-Shams (the Sun) and Al-Qamar (the Moon).",
            keyRulePoints = listOf(
                "Lam Qamariyyah (Moon): The Lam (لْ) is pronounced clearly before 14 letters (e.g., الْقَمَر, الْحَمْد).",
                "Lam Shamsiyyah (Sun): The Lam merges completely into the following letter, which takes a Shaddah (e.g., الشَّمْس, الرَّحْمَٰن).",
                "Visual tip: In the Mushaf, Moon Lam displays a Sukoon on لْ, while Sun Lam has no Sukoon and a Shaddah on the next letter."
            ),
            examples = listOf(
                TajweedExample("الشَّمْسُ وَالْقَمَرُ", "Ash-shamsu wal-qamar", "Surah Ar-Rahman 55:5 showcases both side by side: Ash-Shams (Sun) and Al-Qamar (Moon)."),
                TajweedExample("اهْدِنَا الصِّرَاطَ الْمُسْتَقِيمَ", "Ihdinaṣ-ṣirāṭal-mustaqīm", "Aṣ-Ṣirāṭ assimilates the Lam (Sun); Al-Mustaqīm pronounces it clearly (Moon).")
            )
        )
    )

    val quizQuestions: List<QuizQuestion> = listOf(
        QuizQuestion(
            id = "q1",
            topic = "Quran",
            question = "Which Surah is known as 'The Opening' and is recited in every unit of daily prayer?",
            options = listOf("Surah Al-Ikhlas", "Surah Al-Fatihah", "Surah Al-Asr", "Surah An-Nas"),
            correctIndex = 1,
            explanation = "Surah Al-Fatihah (Chapter 1) means 'The Opening' and opens both the Noble Quran and every unit of Salah."
        ),
        QuizQuestion(
            id = "q2",
            topic = "Tajweed",
            question = "Which mnemonic phrase gathers all five letters of Qalqalah (echoing bounce)?",
            arabicPrompt = "قُطْبُ جَدٍّ",
            options = listOf("Qaf, Ta, Ba, Jeem, Dal", "Alif, Waw, Ya, Noon, Meem", "Seen, Sheen, Sad, Dad, Zay", "Lam, Ra, Ha, Ayn, Ghayn"),
            correctIndex = 0,
            explanation = "The five Qalqalah letters are ق، ط، ب، ج، د — famously remembered as 'Qutbu Jaddin'."
        ),
        QuizQuestion(
            id = "q3",
            topic = "Dua",
            question = "What is the meaning of the Quranic supplication 'Rabbi zidni ilma'?",
            arabicPrompt = "رَبِّ زِدْنِي عِلْمًا",
            options = listOf("My Lord, grant me patience", "My Lord, increase me in knowledge", "My Lord, forgive my parents", "My Lord, open the doors of mercy"),
            correctIndex = 1,
            explanation = "In Surah Ta-Ha (20:114), Allah teaches the Prophet (peace be upon him) to supplicate: 'My Lord, increase me in knowledge.'"
        ),
        QuizQuestion(
            id = "q4",
            topic = "Hadith",
            question = "According to the Hadith in Sahih al-Bukhari narrated by Uthman (RA), who are 'the best among you'?",
            options = listOf(
                "Those who travel the farthest",
                "Those who learn the Quran and teach it",
                "Those who speak the most eloquently",
                "Those who memorize poetry"
            ),
            correctIndex = 1,
            explanation = "The Prophet (peace be upon him) said: 'The best among you are those who learn the Quran and teach it.' (Sahih al-Bukhari 5027)."
        ),
        QuizQuestion(
            id = "q5",
            topic = "Tajweed",
            question = "How many beats (Harakat) should the nasal Ghunnah be held on Noon (نّ) or Meem (مّ) with Shaddah?",
            options = listOf("Half a beat", "2 full beats", "6 beats", "No nasal sound at all"),
            correctIndex = 1,
            explanation = "Both Noon Mushaddadah (نّ) and Meem Mushaddadah (مّ) always carry a steady two-count nasal resonance (Ghunnah)."
        ),
        QuizQuestion(
            id = "q6",
            topic = "Quran",
            question = "Which verse of Surah Al-Baqarah is praised as the greatest verse in the Quran?",
            options = listOf("Verse 1 (Alif-Lam-Meem)", "Verse 183 (Fasting)", "Verse 255 (Ayat al-Kursi)", "Verse 282 (Contracts)"),
            correctIndex = 2,
            explanation = "Ayat al-Kursi (2:255) affirms Allah's absolute life, sovereignty, knowledge, and tireless preservation of the heavens and earth."
        ),
        QuizQuestion(
            id = "q7",
            topic = "Tajweed",
            question = "In the phrase 'Ash-Shamsu wal-Qamar', why is the Lam silent in 'Ash-Shams'?",
            arabicPrompt = "الشَّمْسُ وَالْقَمَرُ",
            options = listOf(
                "Because Sheen (ش) is a Sun Letter (Shamsiyyah)",
                "Because Sheen is a Moon Letter (Qamariyyah)",
                "Because it is a Qalqalah letter",
                "Because it ends the verse"
            ),
            correctIndex = 0,
            explanation = "Sheen (ش) is a Lam Shamsiyyah (Sun Letter), so the Lam assimilates directly into Sheen with a Shaddah."
        ),
        QuizQuestion(
            id = "q8",
            topic = "Quran",
            question = "Which Surah repeats the comforting promise: 'Indeed, with hardship comes ease'?",
            arabicPrompt = "فَإِنَّ مَعَ الْعُسْرِ يُسْرًا",
            options = listOf("Surah Al-Fil", "Surah Ash-Sharh", "Surah Al-Kafirun", "Surah Quraysh"),
            correctIndex = 1,
            explanation = "Surah Ash-Sharh (Chapter 94, verses 5–6) assures every believer twice that ease accompanies hardship."
        ),
        QuizQuestion(
            id = "q9",
            topic = "Hadith",
            question = "Which deeds are described as 'most beloved to Allah' in the narration of Aisha (RA)?",
            options = listOf(
                "Only deeds done once a year",
                "Those performed only in public",
                "Those that are most consistent, even if small",
                "Only lengthy deeds"
            ),
            correctIndex = 2,
            explanation = "Steady, sustainable habits — even a few minutes of daily Quran study — are the most beloved to Allah."
        ),
        QuizQuestion(
            id = "q10",
            topic = "Dua",
            question = "Which Surah is equivalent to one-third of the Quran in meaning?",
            arabicPrompt = "قُلْ هُوَ اللَّهُ أَحَدٌ",
            options = listOf("Surah Al-Ikhlas", "Surah Al-Kawthar", "Surah Al-Asr", "Surah An-Nasr"),
            correctIndex = 0,
            explanation = "Surah Al-Ikhlas (Chapter 112) summarizes pure Tawhid (the absolute Oneness of Allah)."
        )
    )
}
