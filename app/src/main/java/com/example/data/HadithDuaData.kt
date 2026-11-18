package com.example.data

object HadithDuaData {
    val hadiths: List<Hadith> = listOf(
        Hadith(
            id = "h1",
            title = "The Best Among You",
            arabic = "خَيْرُكُمْ مَنْ تَعَلَّمَ الْقُرْآنَ وَعَلَّمَهُ",
            translation = "The best among you are those who learn the Quran and teach it.",
            narrator = "Uthman ibn Affan (RA)",
            source = "Sahih al-Bukhari 5027",
            category = HadithCategory.KNOWLEDGE,
            reflection = "Every moment spent studying even a single letter of the Quran — and sharing that light with others — elevates a believer to the highest rank."
        ),
        Hadith(
            id = "h2",
            title = "Actions Are By Intentions",
            arabic = "إِنَّمَا الأَعْمَالُ بِالنِّيَّاتِ، وَإِنَّمَا لِكُلِّ امْرِئٍ مَا نَوَى",
            translation = "Indeed, actions are judged only by intentions, and every person shall have only what they intended.",
            narrator = "Umar ibn al-Khattab (RA)",
            source = "Sahih al-Bukhari 1 • Sahih Muslim 1907",
            category = HadithCategory.FAITH,
            reflection = "Sincere intention transforms ordinary daily work, study, and kindness into lasting acts of worship."
        ),
        Hadith(
            id = "h3",
            title = "The Path to Knowledge",
            arabic = "مَنْ سَلَكَ طَرِيقًا يَلْتَمِسُ فِيهِ عِلْمًا سَهَّلَ اللَّهُ لَهُ بِهِ طَرِيقًا إِلَى الْجَنَّةِ",
            translation = "Whoever treads a path in search of knowledge, Allah will make easy for him the path to Paradise.",
            narrator = "Abu Hurairah (RA)",
            source = "Sahih Muslim 2699",
            category = HadithCategory.KNOWLEDGE,
            reflection = "Seeking sacred and beneficial knowledge with humility is itself a journey of spiritual ease and Divine mercy."
        ),
        Hadith(
            id = "h4",
            title = "A Smile Is Charity",
            arabic = "تَبَسُّمُكَ فِي وَجْهِ أَخِيكَ لَكَ صَدَقَةٌ",
            translation = "Your smiling in the face of your brother is charity.",
            narrator = "Abu Dharr (RA)",
            source = "Jami' at-Tirmidhi 1956",
            category = HadithCategory.KINDNESS,
            reflection = "Generosity does not require wealth; warmth, gentleness, and a welcoming face heal hearts every day."
        ),
        Hadith(
            id = "h5",
            title = "Excellence of Character",
            arabic = "إِنَّ مِنْ خِيَارِكُمْ أَحْسَنَكُمْ أَخْلَاقًا",
            translation = "Indeed, among the best of you are those who have the best manners and character.",
            narrator = "Abdullah ibn Amr (RA)",
            source = "Sahih al-Bukhari 3559",
            category = HadithCategory.CHARACTER,
            reflection = "True spiritual growth is always visible in patience, honesty, courtesy, and forbearance toward others."
        ),
        Hadith(
            id = "h6",
            title = "Two Light Phrases",
            arabic = "كَلِمَتَانِ خَفِيفَتَانِ عَلَى اللِّسَانِ، ثَقِيلَتَانِ فِي الْمِيزَانِ، حَبِيبَتَانِ إِلَى الرَّحْمَنِ: سُبْحَانَ اللَّهِ وَبِحَمْدِهِ، سُبْحَانَ اللَّهِ الْعَظِيمِ",
            translation = "Two phrases are light on the tongue, heavy on the Scale, and beloved to the Most Merciful: 'SubhanAllahi wa bihamdihi' (Glory and praise be to Allah) and 'SubhanAllahil-Azim' (Glory be to Allah the Supreme).",
            narrator = "Abu Hurairah (RA)",
            source = "Sahih al-Bukhari 6406",
            category = HadithCategory.WORSHIP,
            reflection = "Keeping the tongue moist with gentle remembrance brings calm to the heart throughout busy routines."
        ),
        Hadith(
            id = "h7",
            title = "Mercy Brings Mercy",
            arabic = "الرَّاحِمُونَ يَرْحَمُهُمُ الرَّحْمَنُ، ارْحَمُوا مَنْ فِي الأَرْضِ يَرْحَمْكُمْ مَنْ فِي السَّمَاءِ",
            translation = "The merciful will be shown mercy by the Most Merciful. Show mercy to those on the earth, and the One above the heavens will show mercy to you.",
            narrator = "Abdullah ibn Amr (RA)",
            source = "Sunan Abi Dawud 4941 • Jami' at-Tirmidhi 1924",
            category = HadithCategory.KINDNESS,
            reflection = "Compassion extends to family, neighbors, strangers, and all living creatures sharing this earth."
        ),
        Hadith(
            id = "h8",
            title = "Speak Good or Remain Silent",
            arabic = "مَنْ كَانَ يُؤْمِنُ بِاللَّهِ وَالْيَوْمِ الآخِرِ فَلْيَقُلْ خَيْرًا أَوْ لِيَصْمُتْ",
            translation = "Whoever believes in Allah and the Last Day should speak what is good or remain silent.",
            narrator = "Abu Hurairah (RA)",
            source = "Sahih al-Bukhari 6018 • Sahih Muslim 47",
            category = HadithCategory.CHARACTER,
            reflection = "Mindful speech protects dignity, prevents regret, and fosters peace in every conversation."
        ),
        Hadith(
            id = "h9",
            title = "Consistency in Good Deeds",
            arabic = "أَحَبُّ الأَعْمَالِ إِلَى اللَّهِ أَدْوَمُهَا وَإِنْ قَلَّ",
            translation = "The most beloved deeds to Allah are those that are most consistent, even if they are small.",
            narrator = "Aisha (RA)",
            source = "Sahih al-Bukhari 6464 • Sahih Muslim 783",
            category = HadithCategory.WORSHIP,
            reflection = "Reading just five verses or memorizing one short dua every single day builds lifelong transformation."
        ),
        Hadith(
            id = "h10",
            title = "Love for Others What You Love",
            arabic = "لَا يُؤْمِنُ أَحَدُكُمْ حَتَّى يُحِبَّ لِأَخِيهِ مَا يُحِبَّ لِنَفْسِهِ",
            translation = "None of you truly believes until he loves for his brother what he loves for himself.",
            narrator = "Anas ibn Malik (RA)",
            source = "Sahih al-Bukhari 13 • Sahih Muslim 45",
            category = HadithCategory.FAITH,
            reflection = "Empathy and wishing goodness for others purify the heart from envy and selfishness."
        ),
        Hadith(
            id = "h11",
            title = "True Strength Is Self-Control",
            arabic = "لَيْسَ الشَّدِيدُ بِالصُّرَعَةِ، إِنَّمَا الشَّدِيدُ الَّذِي يَمْلِكُ نَفْسَهُ عِنْدَ الْغَضَبِ",
            translation = "The strong person is not the one who overcomes others by physical force, rather the strong person is the one who controls himself in anger.",
            narrator = "Abu Hurairah (RA)",
            source = "Sahih al-Bukhari 6114",
            category = HadithCategory.CHARACTER,
            reflection = "Mastering one's temper with calm dignity is a hallmark of Prophetic strength."
        ),
        Hadith(
            id = "h12",
            title = "Reward of Striving in Recitation",
            arabic = "الْمَاهِرُ بِالْقُرْآنِ مَعَ السَّفَرَةِ الْكِرَامِ الْبَرَرَةِ، وَالَّذِي يَقْرَأُ الْقُرْآنَ وَيَتَتَعْتَعُ فِيهِ وَهُوَ عَلَيْهِ شَاقٌّ لَهُ أَجْرَانِ",
            translation = "The one who is proficient in reciting the Quran will be with the noble and righteous scribes, and the one who recites it with difficulty while striving gets a double reward.",
            narrator = "Aisha (RA)",
            source = "Sahih al-Bukhari 4937 • Sahih Muslim 798",
            category = HadithCategory.KNOWLEDGE,
            reflection = "Beginners learning Arabic letters and Tajweed should feel deeply encouraged: every effortful syllable earns double reward."
        )
    )

    val duas: List<Dua> = listOf(
        Dua(
            id = "d1",
            title = "Seeking Beneficial Knowledge",
            arabic = "رَبِّ زِدْنِي عِلْمًا",
            transliteration = "Rabbi zidnī 'ilmā",
            translation = "My Lord, increase me in knowledge.",
            occasion = "Before studying or starting a lesson",
            reference = "Quran 20:114",
            category = DuaCategory.KNOWLEDGE,
            recommendedCount = 3
        ),
        Dua(
            id = "d2",
            title = "Knowledge, Provision & Accepted Deeds",
            arabic = "اللَّهُمَّ إِنِّي أَسْأَلُكَ عِلْمًا نَافِعًا، وَرِزْقًا طَيِّبًا، وَعَمَلًا مُتَقَبَّلًا",
            transliteration = "Allāhumma innī as'aluka 'ilman nāfi'an, wa rizqan ṭayyiban, wa 'amalan mutaqabbalā",
            translation = "O Allah, I ask You for beneficial knowledge, pure provision, and deeds that are accepted.",
            occasion = "After Fajr prayer in the morning",
            reference = "Sunan Ibn Majah 925",
            category = DuaCategory.KNOWLEDGE,
            recommendedCount = 1
        ),
        Dua(
            id = "d3",
            title = "Ease in Understanding & Speech",
            arabic = "رَبِّ اشْرَحْ لِي صَدْرِي وَيَسِّرْ لِي أَمْرِي وَاحْلُلْ عُقْدَةً مِنْ لِسَانِي يَفْقَهُوا قَوْلِي",
            transliteration = "Rabbishraḥ lī ṣadrī, wa yassir lī amrī, waḥlul 'uqdatan min lisānī yafqahū qawlī",
            translation = "My Lord, expand for me my breast, ease for me my task, and untie the knot from my tongue so that they may understand my speech.",
            occasion = "Before exams, speaking, or teaching",
            reference = "Quran 20:25–28",
            category = DuaCategory.KNOWLEDGE,
            recommendedCount = 1
        ),
        Dua(
            id = "d4",
            title = "Morning Gratitude & Renewal",
            arabic = "أَصْبَحْنَا وَأَصْبَحَ الْمُلْكُ لِلَّهِ، وَالْحَمْدُ لِلَّهِ، لَا إِلَٰهَ إِلَّا اللَّهُ وَحْدَهُ لَا شَرِيكَ لَهُ",
            transliteration = "Aṣbaḥnā wa aṣbaḥal-mulku lillāh, wal-ḥamdu lillāh, lā ilāha illallāhu waḥdahū lā sharīka lah",
            translation = "We have reached the morning and at this very time all sovereignty belongs to Allah, and all praise is for Allah. None has the right to be worshipped except Allah alone, without partner.",
            occasion = "Upon greeting the morning",
            reference = "Sahih Muslim 2723",
            category = DuaCategory.MORNING_EVENING,
            recommendedCount = 1
        ),
        Dua(
            id = "d5",
            title = "Contentment in Faith",
            arabic = "رَضِيتُ بِاللَّهِ رَبًّا، وَبِالْإِسْلَامِ دِينًا، وَبِمُحَمَّدٍ صَلَّى اللَّهُ عَلَيْهِ وَسَلَّمَ نَبِيًّا",
            transliteration = "Raḍītu billāhi Rabban, wa bil-Islāmi dīnan, wa bi-Muḥammadin ṣallallāhu 'alayhi wa sallama nabiyyā",
            translation = "I am pleased with Allah as my Lord, with Islam as my religion, and with Muhammad (peace be upon him) as my Prophet.",
            occasion = "Morning and evening adhkar",
            reference = "Sunan Abi Dawud 5072",
            category = DuaCategory.MORNING_EVENING,
            recommendedCount = 3
        ),
        Dua(
            id = "d6",
            title = "Seeking Protection Morning & Evening",
            arabic = "بِسْمِ اللَّهِ الَّذِي لَا يَضُرُّ مَعَ اسْمِهِ شَيْءٌ فِي الْأَرْضِ وَلَا فِي السَّمَاءِ وَهُوَ السَّمِيعُ الْعَلِيمُ",
            transliteration = "Bismillāhil-ladhī lā yaḍurru ma'asmihī shay'un fil-arḍi wa lā fis-samā'i wa huwas-Samī'ul-'Alīm",
            translation = "In the name of Allah, with whose name nothing can harm on earth or in heaven, and He is the All-Hearing, the All-Knowing.",
            occasion = "Three times morning and evening",
            reference = "Sunan Abi Dawud 5088 • At-Tirmidhi 3388",
            category = DuaCategory.MORNING_EVENING,
            recommendedCount = 3
        ),
        Dua(
            id = "d7",
            title = "Goodness in Both Worlds",
            arabic = "رَبَّنَا آتِنَا فِي الدُّنْيَا حَسَنَةً وَفِي الْآخِرَةِ حَسَنَةً وَقِنَا عَذَابَ النَّارِ",
            transliteration = "Rabbanā ātinā fid-dunyā ḥasanatan wa fil-ākhirati ḥasanatan wa qinā 'adhāban-nār",
            translation = "Our Lord, grant us good in this world and good in the Hereafter, and protect us from the punishment of the Fire.",
            occasion = "Comprehensive daily supplication",
            reference = "Quran 2:201",
            category = DuaCategory.GUIDANCE,
            recommendedCount = 3
        ),
        Dua(
            id = "d8",
            title = "Steadfastness of the Heart",
            arabic = "يَا مُقَلِّبَ الْقُلُوبِ ثَبِّتْ قَلْبِي عَلَىٰ دِينِكَ",
            transliteration = "Yā Muqallibal-qulūbi thabbit qalbī 'alā dīnik",
            translation = "O Turner of hearts, keep my heart firm upon Your religion.",
            occasion = "When seeking spiritual steadfastness",
            reference = "Jami' at-Tirmidhi 2140",
            category = DuaCategory.GUIDANCE,
            recommendedCount = 3
        ),
        Dua(
            id = "d9",
            title = "Relief from Anxiety & Worry",
            arabic = "اللَّهُمَّ إِنِّي أَعُوذُ بِكَ مِنَ الْهَمِّ وَالْحَزَنِ، وَالْعَجْزِ وَالْكَسَلِ",
            transliteration = "Allāhumma innī a'ūdhu bika minal-hammi wal-ḥazan, wal-'ajzi wal-kasal",
            translation = "O Allah, I seek refuge in You from anxiety and sorrow, and from helplessness and laziness.",
            occasion = "During stressful moments",
            reference = "Sahih al-Bukhari 6369",
            category = DuaCategory.GUIDANCE,
            recommendedCount = 3
        ),
        Dua(
            id = "d10",
            title = "Entering the Mosque",
            arabic = "اللَّهُمَّ افْتَحْ لِي أَبْوَابَ رَحْمَتِكَ",
            transliteration = "Allāhummaf-taḥ lī abwāba raḥmatik",
            translation = "O Allah, open for me the doors of Your mercy.",
            occasion = "When entering the mosque",
            reference = "Sahih Muslim 713",
            category = DuaCategory.PRAYER,
            recommendedCount = 1
        ),
        Dua(
            id = "d11",
            title = "Help in Remembrance & Gratitude",
            arabic = "اللَّهُمَّ أَعِنِّي عَلَىٰ ذِكْرِكَ وَشُكْرِكَ وَحُسْنِ عِبَادَتِكَ",
            transliteration = "Allāhumma a'innī 'alā dhikrika wa shukrika wa ḥusni 'ibādatik",
            translation = "O Allah, help me to remember You, to give thanks to You, and to worship You in the best manner.",
            occasion = "After daily prayers",
            reference = "Sunan Abi Dawud 1522",
            category = DuaCategory.PRAYER,
            recommendedCount = 1
        ),
        Dua(
            id = "d12",
            title = "Leaving Home with Trust",
            arabic = "بِسْمِ اللَّهِ، تَوَكَّلْتُ عَلَى اللَّهِ، وَلَا حَوْلَ وَلَا قُوَّةَ إِلَّا بِاللَّهِ",
            transliteration = "Bismillāh, tawakkaltu 'alallāh, wa lā ḥawla wa lā quwwata illā billāh",
            translation = "In the name of Allah, I place my trust in Allah, and there is no might nor power except with Allah.",
            occasion = "When leaving home",
            reference = "Sunan Abi Dawud 5095",
            category = DuaCategory.DAILY_LIFE,
            recommendedCount = 1
        ),
        Dua(
            id = "d13",
            title = "Gratitude After a Meal",
            arabic = "الْحَمْدُ لِلَّهِ الَّذِي أَطْعَمَنِي هَٰذَا وَرَزَقَنِيهِ مِنْ غَيْرِ حَوْلٍ مِنِّي وَلَا قُوَّةٍ",
            transliteration = "Al-ḥamdu lillāhil-ladhī aṭ'amanī hādhā wa razaqanīhi min ghayri ḥawlin minnī wa lā quwwah",
            translation = "All praise is due to Allah who fed me this and provided it for me without any might or power from myself.",
            occasion = "Upon finishing a meal",
            reference = "Jami' at-Tirmidhi 3458",
            category = DuaCategory.DAILY_LIFE,
            recommendedCount = 1
        ),
        Dua(
            id = "d14",
            title = "Before Going to Sleep",
            arabic = "بِاسْمِكَ اللَّهُمَّ أَمُوتُ وَأَحْيَا",
            transliteration = "Bismikallāhumma amūtu wa aḥyā",
            translation = "In Your name, O Allah, I die (sleep) and I live (awaken).",
            occasion = "Before resting for the night",
            reference = "Sahih al-Bukhari 6324",
            category = DuaCategory.DAILY_LIFE,
            recommendedCount = 1
        ),
        Dua(
            id = "d15",
            title = "Dua for Parents",
            arabic = "رَبِّ ارْحَمْهُمَا كَمَا رَبَّيَانِي صَغِيرًا",
            transliteration = "Rabbir-ḥamhumā kamā rabbayānī ṣaghīrā",
            translation = "My Lord, have mercy upon them as they brought me up when I was small.",
            occasion = "Remembering parents with love",
            reference = "Quran 17:24",
            category = DuaCategory.DAILY_LIFE,
            recommendedCount = 3
        )
    )
}
