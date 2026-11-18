package com.example.data

object QuranData {
    val surahs: List<Surah> = listOf(
        Surah(
            number = 1,
            englishName = "Al-Fatihah",
            meaning = "The Opening",
            arabicName = "الفَاتِحَة",
            revelationType = RevelationType.MAKKI,
            totalVersesInQuran = 7,
            isCompleteInApp = true,
            showBismillahHeader = false,
            introduction = "The opening chapter of the Noble Quran, recited in every unit of daily prayer. It gathers praise of Allah, devotion, and a heartfelt prayer for steadfast guidance.",
            ayahs = listOf(
                Ayah(
                    1,
                    "بِسْمِ اللَّهِ الرَّحْمَٰنِ الرَّحِيمِ",
                    "Bismillāhir-Raḥmānir-Raḥīm",
                    "In the name of Allah, the Entirely Merciful, the Especially Merciful."
                ),
                Ayah(
                    2,
                    "الْحَمْدُ لِلَّهِ رَبِّ الْعَالَمِينَ",
                    "Al-ḥamdu lillāhi Rabbil-'ālamīn",
                    "All praise is due to Allah, Lord of all worlds."
                ),
                Ayah(
                    3,
                    "الرَّحْمَٰنِ الرَّحِيمِ",
                    "Ar-Raḥmānir-Raḥīm",
                    "The Entirely Merciful, the Especially Merciful."
                ),
                Ayah(
                    4,
                    "مَالِكِ يَوْمِ الدِّينِ",
                    "Māliki yawmid-dīn",
                    "Sovereign of the Day of Recompense."
                ),
                Ayah(
                    5,
                    "إِيَّاكَ نَعْبُدُ وَإِيَّاكَ نَسْتَعِينُ",
                    "Iyyāka na'budu wa iyyāka nasta'īn",
                    "It is You alone we worship, and You alone we ask for help."
                ),
                Ayah(
                    6,
                    "اهْدِنَا الصِّرَاطَ الْمُسْتَقِيمَ",
                    "Ihdinaṣ-ṣirāṭal-mustaqīm",
                    "Guide us to the straight path —"
                ),
                Ayah(
                    7,
                    "صِرَاطَ الَّذِينَ أَنْعَمْتَ عَلَيْهِمْ غَيْرِ الْمَغْضُوبِ عَلَيْهِمْ وَلَا الضَّالِّينَ",
                    "Ṣirāṭal-ladhīna an'amta 'alayhim ghayril-maghḍūbi 'alayhim wa laḍ-ḍāllīn",
                    "The path of those upon whom You have bestowed favor, not of those who have evoked anger or of those who are astray."
                )
            )
        ),
        Surah(
            number = 2,
            englishName = "Al-Baqarah (Selected Gems)",
            meaning = "Ayat al-Kursi & Closing Verse",
            arabicName = "البَقَرَة",
            revelationType = RevelationType.MADANI,
            totalVersesInQuran = 286,
            isCompleteInApp = false,
            showBismillahHeader = true,
            introduction = "Includes Ayat al-Kursi (2:255) — praised as the greatest verse in the Quran — alongside the deeply comforting closing supplication of Surah Al-Baqarah.",
            ayahs = listOf(
                Ayah(
                    255,
                    "اللَّهُ لَا إِلَٰهَ إِلَّا هُوَ الْحَيُّ الْقَيُّومُ ۚ لَا تَأْخُذُهُ سِنَةٌ وَلَا نَوْمٌ ۚ لَهُ مَا فِي السَّمَاوَاتِ وَمَا فِي الْأَرْضِ ۗ مَنْ ذَا الَّذِي يَشْفَعُ عِنْدَهُ إِلَّا بِإِذْنِهِ ۚ يَعْلَمُ مَا بَيْنَ أَيْدِيهِمْ وَمَا خَلْفَهُمْ ۖ وَلَا يُحِيطُونَ بِشَيْءٍ مِنْ عِلْمِهِ إِلَّا بِمَا شَاءَ ۚ وَسِعَ كُرْسِيُّهُ السَّمَاوَاتِ وَالْأَرْضَ ۖ وَلَا يَئُودُهُ حِفْظُهُمَا ۚ وَهُوَ الْعَلِيُّ الْعَظِيمُ",
                    "Allāhu lā ilāha illā huwal-Ḥayyul-Qayyūm. Lā ta'khudhuhū sinatun wa lā nawm. Lahū mā fis-samāwāti wa mā fil-arḍ. Man dhal-ladhī yashfa'u 'indahū illā bi-idhnih. Ya'lamu mā bayna aydīhim wa mā khalfahum, wa lā yuḥīṭūna bi-shay'in min 'ilmihī illā bi-mā shā'. Wasi'a kursiyyuhus-samāwāti wal-arḍ, wa lā ya'ūduhū ḥifẓuhumā, wa huwal-'Aliyyul-'Aẓīm.",
                    "Allah — there is no deity except Him, the Ever-Living, the Sustainer of all existence. Neither drowsiness overtakes Him nor sleep. To Him belongs whatever is in the heavens and whatever is on the earth. Who is it that can intercede with Him except by His permission? He knows what is before them and what will be after them, and they encompass not a thing of His knowledge except for what He wills. His Kursi extends over the heavens and the earth, and their preservation tires Him not. And He is the Most High, the Most Great."
                ),
                Ayah(
                    286,
                    "لَا يُكَلِّفُ اللَّهُ نَفْسًا إِلَّا وُسْعَهَا ۚ لَهَا مَا كَسَبَتْ وَعَلَيْهَا مَا اكْتَسَبَتْ ۗ رَبَّنَا لَا تُؤَاخِذْنَا إِنْ نَسِينَا أَوْ أَخْطَأْنَا ۚ رَبَّنَا وَلَا تَحْمِلْ عَلَيْنَا إِصْرًا كَمَا حَمَلْتَهُ عَلَى الَّذِينَ مِنْ قَبْلِنَا ۚ رَبَّنَا وَلَا تُحَمِّلْنَا مَا لَا طَاقَةَ لَنَا بِهِ ۖ وَاعْفُ عَنَّا وَاغْفِرْ لَنَا وَارْحَمْنَا ۚ أَنْتَ مَوْلَانَا فَانْصُرْنَا عَلَى الْقَوْمِ الْكَافِرِينَ",
                    "Lā yukallifullāhu nafsan illā wus'ahā. Lahā mā kasabat wa 'alayhā maktasabat. Rabbanā lā tu'ākhidhnā in nasīnā aw akhṭa'nā. Rabbanā wa lā taḥmil 'alaynā iṣran kamā ḥamaltahū 'alal-ladhīna min qablinā. Rabbanā wa lā tuḥammilnā mā lā ṭāqata lanā bih. Wa'fu 'annā waghfir lanā warḥamnā. Anta mawlānā fanṣurnā 'alal-qawmil-kāfirīn.",
                    "Allah does not charge a soul except with that within its capacity. It will have the good it has gained, and it will bear the consequence of what it has earned. Our Lord, do not impose blame upon us if we forget or err. Our Lord, lay not upon us a burden like that which You laid upon those before us. Our Lord, burden us not with that which we have no ability to bear. Pardon us, forgive us, and have mercy upon us. You are our Protector, so grant us victory."
                )
            )
        ),
        Surah(
            number = 55,
            englishName = "Ar-Rahman (Opening)",
            meaning = "The Most Merciful",
            arabicName = "الرَّحْمَٰن",
            revelationType = RevelationType.MADANI,
            totalVersesInQuran = 78,
            isCompleteInApp = false,
            showBismillahHeader = true,
            introduction = "A lyrical hymn of gratitude reminding humanity of Allah's boundless mercy — beginning with the supreme blessing of teaching the Quran.",
            ayahs = listOf(
                Ayah(1, "الرَّحْمَٰنُ", "Ar-Raḥmān", "The Most Merciful,"),
                Ayah(2, "عَلَّمَ الْقُرْآنَ", "'Allamal-Qur'ān", "Taught the Quran,"),
                Ayah(3, "خَلَقَ الْإِنْسَانَ", "Khalaqal-insān", "Created humanity,"),
                Ayah(4, "عَلَّمَهُ الْبَيَانَ", "'Allamahul-bayān", "And taught them eloquent expression."),
                Ayah(5, "الشَّمْسُ وَالْقَمَرُ بِحُسْبَانٍ", "Ash-shamsu wal-qamaru bi-ḥusbān", "The sun and the moon move by precise calculation,"),
                Ayah(6, "وَالنَّجْمُ وَالشَّجَرُ يَسْجُدَانِ", "Wan-najmu wash-shajaru yasjudān", "And the stars and trees prostrate in submission.")
            )
        ),
        Surah(
            number = 67,
            englishName = "Al-Mulk (Opening)",
            meaning = "The Sovereignty",
            arabicName = "المُلْك",
            revelationType = RevelationType.MAKKI,
            totalVersesInQuran = 30,
            isCompleteInApp = false,
            showBismillahHeader = true,
            introduction = "Traditionally recited before sleep, Surah Al-Mulk invites reflection upon the flawless creation of the heavens and the purpose of life.",
            ayahs = listOf(
                Ayah(
                    1,
                    "تَبَارَكَ الَّذِي بِيَدِهِ الْمُلْكُ وَهُوَ عَلَىٰ كُلِّ شَيْءٍ قَدِيرٌ",
                    "Tabārakal-ladhī bi-yadihil-mulku wa huwa 'alā kulli shay'in qadīr",
                    "Blessed is He in whose hand is dominion, and He is over all things competent —"
                ),
                Ayah(
                    2,
                    "الَّذِي خَلَقَ الْمَوْتَ وَالْحَيَاةَ لِيَبْلُوَكُمْ أَيُّكُمْ أَحْسَنُ عَمَلًا ۚ وَهُوَ الْعَزِيزُ الْغَفُورُ",
                    "Alladhī khalaqal-mawta wal-ḥayāta li-yabluwakum ayyukum aḥsanu 'amalā, wa huwal-'Azīzul-Ghafūr",
                    "He who created death and life to test you as to which of you is best in deed — and He is the Exalted in Might, the Forgiving —"
                ),
                Ayah(
                    3,
                    "الَّذِي خَلَقَ سَبْعَ سَمَاوَاتٍ طِبَاقًا ۖ مَا تَرَىٰ فِي خَلْقِ الرَّحْمَٰنِ مِنْ تَفَاوُتٍ ۖ فَارْجِعِ الْبَصَرَ هَلْ تَرَىٰ مِنْ فُطُورٍ",
                    "Alladhī khalaqa sab'a samāwātin ṭibāqā. Mā tarā fī khalqir-Raḥmāni min tafāwut. Farji'il-baṣara hal tarā min fuṭūr",
                    "And Who created seven heavens in layers. You do not see in the creation of the Most Merciful any inconsistency. So return your vision to the sky: do you see any breaks?"
                ),
                Ayah(
                    4,
                    "ثُمَّ ارْجِعِ الْبَصَرَ كَرَّتَيْنِ يَنْقَلِبْ إِلَيْكَ الْبَصَرُ خَاسِئًا وَهُوَ حَسِيرٌ",
                    "Thummarji'il-baṣara karratayni yanqalib ilaykal-baṣaru khāsi'an wa huwa ḥasīr",
                    "Then return your vision twice again; your vision will return to you humbled while it is fatigued."
                )
            )
        ),
        Surah(
            number = 93,
            englishName = "Ad-Duha",
            meaning = "The Morning Brightness",
            arabicName = "الضُّحَى",
            revelationType = RevelationType.MAKKI,
            totalVersesInQuran = 11,
            isCompleteInApp = true,
            showBismillahHeader = true,
            introduction = "Revealed to comfort the Prophet (peace be upon him) during a pause in revelation, assuring believers that Allah never forsakes them and that brighter days await.",
            ayahs = listOf(
                Ayah(1, "وَالضُّحَىٰ", "Waḍ-ḍuḥā", "By the morning brightness,"),
                Ayah(2, "وَاللَّيْلِ إِذَا سَجَىٰ", "Wal-layli idhā sajā", "And by the night when it grows still,"),
                Ayah(3, "مَا وَدَّعَكَ رَبُّكَ وَمَا قَلَىٰ", "Mā wadda'aka Rabbuka wa mā qalā", "Your Lord has not taken leave of you, nor has He detested you."),
                Ayah(4, "وَلَلْآخِرَةُ خَيْرٌ لَكَ مِنَ الْأُولَىٰ", "Wa lal-ākhiratu khayrul-laka minal-ūlā", "And the Hereafter is surely better for you than the first life."),
                Ayah(5, "وَلَسَوْفَ يُعْطِيكَ رَبُّكَ فَتَرْضَىٰ", "Wa la-sawfa yu'ṭīka Rabbuka fa-tarḍā", "And your Lord is going to give you, and you will be satisfied."),
                Ayah(6, "أَلَمْ يَجِدْكَ يَتِيمًا فَآوَىٰ", "Alam yajidka yatīman fa-āwā", "Did He not find you an orphan and give you refuge?"),
                Ayah(7, "وَوَجَدَكَ ضَالًّا فَهَدَىٰ", "Wa wajadaka ḍāllan fa-hadā", "And He found you lost and guided you,"),
                Ayah(8, "وَوَجَدَكَ عَائِلًا فَأَغْنَىٰ", "Wa wajadaka 'ā'ilan fa-aghnā", "And He found you in need and made you self-sufficient."),
                Ayah(9, "فَأَمَّا الْيَتِيمَ فَلَا تَقْهَرْ", "Fa-ammal-yatīma falā taqhar", "So as for the orphan, do not oppress him."),
                Ayah(10, "وَأَمَّا السَّائِلَ فَلَا تَنْهَرْ", "Wa ammas-sā'ila falā tanhar", "And as for the petitioner, do not repel him."),
                Ayah(11, "وَأَمَّا بِنِعْمَةِ رَبِّكَ فَحَدِّثْ", "Wa ammā bi-ni'mati Rabbika fa-ḥaddith", "But as for the favor of your Lord, report and proclaim it.")
            )
        ),
        Surah(
            number = 94,
            englishName = "Ash-Sharh",
            meaning = "The Relief",
            arabicName = "الشَّرْح",
            revelationType = RevelationType.MAKKI,
            totalVersesInQuran = 8,
            isCompleteInApp = true,
            showBismillahHeader = true,
            introduction = "A timeless message of hope and spiritual serenity, repeating the Divine promise that with every single hardship comes abundant ease.",
            ayahs = listOf(
                Ayah(1, "أَلَمْ نَشْرَحْ لَكَ صَدْرَكَ", "Alam nashraḥ laka ṣadrak", "Did We not expand for you your breast,"),
                Ayah(2, "وَوَضَعْنَا عَنْكَ وِزْرَكَ", "Wa waḍa'nā 'anka wizrak", "And remove from you your burden,"),
                Ayah(3, "الَّذِي أَنْقَضَ ظَهْرَكَ", "Alladhī anqaḍa ẓahrak", "Which had weighed upon your back,"),
                Ayah(4, "وَرَفَعْنَا لَكَ ذِكْرَكَ", "Wa rafa'nā laka dhikrak", "And raised high for you your repute?"),
                Ayah(5, "فَإِنَّ مَعَ الْعُسْرِ يُسْرًا", "Fa-inna ma'al-'usri yusrā", "For indeed, with hardship comes ease."),
                Ayah(6, "إِنَّ مَعَ الْعُسْرِ يُسْرًا", "Inna ma'al-'usri yusrā", "Indeed, with hardship comes ease."),
                Ayah(7, "فَإِذَا فَرَغْتَ فَانْصَبْ", "Fa-idhā faraghta fanṣab", "So when you have finished your duties, then stand up for worship,"),
                Ayah(8, "وَإِلَىٰ رَبِّكَ فَارْغَبْ", "Wa ilā Rabbika farghab", "And to your Lord direct your longing.")
            )
        ),
        Surah(
            number = 97,
            englishName = "Al-Qadr",
            meaning = "The Night of Decree",
            arabicName = "القَدْر",
            revelationType = RevelationType.MAKKI,
            totalVersesInQuran = 5,
            isCompleteInApp = true,
            showBismillahHeader = true,
            introduction = "Celebrates Laylat al-Qadr, the blessed night in Ramadan when the Quran was first sent down — better than a thousand months.",
            ayahs = listOf(
                Ayah(1, "إِنَّا أَنْزَلْنَاهُ فِي لَيْلَةِ الْقَدْرِ", "Innā anzalnāhu fī laylatil-qadr", "Indeed, We sent the Quran down during the Night of Decree."),
                Ayah(2, "وَمَا أَدْرَاكَ مَا لَيْلَةُ الْقَدْرِ", "Wa mā adrāka mā laylatul-qadr", "And what can make you know what is the Night of Decree?"),
                Ayah(3, "لَيْلَةُ الْقَدْرِ خَيْرٌ مِنْ أَلْفِ شَهْرٍ", "Laylatul-qadri khayrun min alfi shahr", "The Night of Decree is better than a thousand months."),
                Ayah(4, "تَنَزَّلُ الْمَلَائِكَةُ وَالرُّوحُ فِيهَا بِإِذْنِ رَبِّهِمْ مِنْ كُلِّ أَمْرٍ", "Tanazzalul-malā'ikatu war-rūḥu fīhā bi-idhni Rabbihim min kulli amr", "The angels and the Spirit descend therein by permission of their Lord for every matter."),
                Ayah(5, "سَلَامٌ هِيَ حَتَّىٰ مَطْلَعِ الْفَجْرِ", "Salāmun hiya ḥattā maṭla'il-fajr", "Peace it is until the emergence of dawn.")
            )
        ),
        Surah(
            number = 103,
            englishName = "Al-Asr",
            meaning = "The Declining Day",
            arabicName = "العَصْر",
            revelationType = RevelationType.MAKKI,
            totalVersesInQuran = 3,
            isCompleteInApp = true,
            showBismillahHeader = true,
            introduction = "Outlines the four enduring pillars of a meaningful life: faith, righteous action, encouraging truth, and encouraging patience.",
            ayahs = listOf(
                Ayah(1, "وَالْعَصْرِ", "Wal-'aṣr", "By time,"),
                Ayah(2, "إِنَّ الْإِنْسَانَ لَفِي خُسْرٍ", "Innal-insāna lafī khusr", "Indeed, mankind is in loss,"),
                Ayah(
                    3,
                    "إِلَّا الَّذِينَ آمَنُوا وَعَمِلُوا الصَّالِحَاتِ وَتَوَاصَوْا بِالْحَقِّ وَتَوَاصَوْا بِالصَّبْرِ",
                    "Illal-ladhīna āmanū wa 'amiluṣ-ṣāliḥāti wa tawāṣaw bil-ḥaqqi wa tawāṣaw biṣ-ṣabr",
                    "Except for those who have believed and done righteous deeds and advised each other to truth and advised each other to patience."
                )
            )
        ),
        Surah(
            number = 105,
            englishName = "Al-Fil",
            meaning = "The Elephant",
            arabicName = "الفِيل",
            revelationType = RevelationType.MAKKI,
            totalVersesInQuran = 5,
            isCompleteInApp = true,
            showBismillahHeader = true,
            introduction = "Recounts Allah's miraculous protection of the Sacred House (the Ka'bah) in the Year of the Elephant.",
            ayahs = listOf(
                Ayah(1, "أَلَمْ تَرَ كَيْفَ فَعَلَ رَبُّكَ بِأَصْحَابِ الْفِيلِ", "Alam tara kayfa fa'ala Rabbuka bi-aṣḥābil-fīl", "Have you not considered how your Lord dealt with the companions of the elephant?"),
                Ayah(2, "أَلَمْ يَجْعَلْ كَيْدَهُمْ فِي تَضْلِيلٍ", "Alam yaj'al kaydahum fī taḍlīl", "Did He not make their plan into misguidance?"),
                Ayah(3, "وَأَرْسَلَ عَلَيْهِمْ طَيْرًا أَبَابِيلَ", "Wa arsala 'alayhim ṭayran abābīl", "And He sent against them birds in flocks,"),
                Ayah(4, "تَرْمِيهِمْ بِحِجَارَةٍ مِنْ سِجِّيلٍ", "Tarmīhim bi-ḥijāratin min sijjīl", "Striking them with stones of hard clay,"),
                Ayah(5, "فَجَعَلَهُمْ كَعَصْفٍ مَأْكُولٍ", "Fa-ja'alahum ka-'aṣfin ma'kūl", "And He made them like eaten straw.")
            )
        ),
        Surah(
            number = 106,
            englishName = "Quraysh",
            meaning = "Quraysh",
            arabicName = "قُرَيْش",
            revelationType = RevelationType.MAKKI,
            totalVersesInQuran = 4,
            isCompleteInApp = true,
            showBismillahHeader = true,
            introduction = "Calls upon people to worship the Lord of the Sacred House in gratitude for sustenance from hunger and safety from fear.",
            ayahs = listOf(
                Ayah(1, "لِإِيلَافِ قُرَيْشٍ", "Li-īlāfi Quraysh", "For the accustomed security of the Quraysh —"),
                Ayah(2, "إِيلَافِهِمْ رِحْلَةَ الشِّتَاءِ وَالصَّيْفِ", "Īlāfihim riḥlatash-shitā'i waṣ-ṣayf", "Their accustomed security in the caravan of winter and summer —"),
                Ayah(3, "فَلْيَعْبُدُوا رَبَّ هَٰذَا الْبَيْتِ", "Fal-ya'budū Rabba hādhal-bayt", "Let them worship the Lord of this House,"),
                Ayah(4, "الَّذِي أَطْعَمَهُمْ مِنْ جُوعٍ وَآمَنَهُمْ مِنْ خَوْفٍ", "Alladhī aṭ'amahum min jū'in wa āmanahum min khawf", "Who has fed them, saving them from hunger, and made them safe from fear.")
            )
        ),
        Surah(
            number = 108,
            englishName = "Al-Kawthar",
            meaning = "The Abundance",
            arabicName = "الكَوْثَر",
            revelationType = RevelationType.MAKKI,
            totalVersesInQuran = 3,
            isCompleteInApp = true,
            showBismillahHeader = true,
            introduction = "The shortest surah in the Quran, promising abundant goodness and calling the believer to devotion through prayer and generosity.",
            ayahs = listOf(
                Ayah(1, "إِنَّا أَعْطَيْنَاكَ الْكَوْثَرَ", "Innā a'ṭaynākal-kawthar", "Indeed, We have granted you Al-Kawthar (abundance)."),
                Ayah(2, "فَصَلِّ لِرَبِّكَ وَانْحَرْ", "Fa-ṣalli li-Rabbika wanḥar", "So pray to your Lord and offer sacrifice."),
                Ayah(3, "إِنَّ شَانِئَكَ هُوَ الْأَبْتَرُ", "Inna shāni'aka huwal-abtar", "Indeed, your enemy is the one cut off.")
            )
        ),
        Surah(
            number = 109,
            englishName = "Al-Kafirun",
            meaning = "The Disbelievers",
            arabicName = "الكَافِرُون",
            revelationType = RevelationType.MAKKI,
            totalVersesInQuran = 6,
            isCompleteInApp = true,
            showBismillahHeader = true,
            introduction = "A clear declaration of pure monotheism and respectful clarity of faith.",
            ayahs = listOf(
                Ayah(1, "قُلْ يَا أَيُّهَا الْكَافِرُونَ", "Qul yā ayyuhal-kāfirūn", "Say, 'O disbelievers,"),
                Ayah(2, "لَا أَعْبُدُ مَا تَعْبُدُونَ", "Lā a'budu mā ta'budūn", "I do not worship what you worship."),
                Ayah(3, "وَلَا أَنْتُمْ عَابِدُونَ مَا أَعْبُدُ", "Wa lā antum 'ābidūna mā a'bud", "Nor are you worshippers of what I worship."),
                Ayah(4, "وَلَا أَنَا عَابِدٌ مَا عَبَدْتُمْ", "Wa lā ana 'ābidun mā 'abadtum", "Nor will I be a worshipper of what you worship."),
                Ayah(5, "وَلَا أَنْتُمْ عَابِدُونَ مَا أَعْبُدُ", "Wa lā antum 'ābidūna mā a'bud", "Nor will you be worshippers of what I worship."),
                Ayah(6, "لَكُمْ دِينُكُمْ وَلِيَ دِينِ", "Lakum dīnukum wa liya dīn", "For you is your religion, and for me is my religion.'")
            )
        ),
        Surah(
            number = 110,
            englishName = "An-Nasr",
            meaning = "The Divine Support",
            arabicName = "النَّصْر",
            revelationType = RevelationType.MADANI,
            totalVersesInQuran = 3,
            isCompleteInApp = true,
            showBismillahHeader = true,
            introduction = "Teaches that moments of triumph and achievement should be met with humility, praise of Allah, and seeking His forgiveness.",
            ayahs = listOf(
                Ayah(1, "إِذَا جَاءَ نَصْرُ اللَّهِ وَالْفَتْحُ", "Idhā jā'a naṣrullāhi wal-fatḥ", "When the victory of Allah has come and the conquest,"),
                Ayah(2, "وَرَأَيْتَ النَّاسَ يَدْخُلُونَ فِي دِينِ اللَّهِ أَفْوَاجًا", "Wa ra'aytan-nāsa yadkhulūna fī dīnillāhi afwājā", "And you see the people entering into the religion of Allah in multitudes,"),
                Ayah(3, "فَسَبِّحْ بِحَمْدِ رَبِّكَ وَاسْتَغْفِرْهُ ۚ إِنَّهُ كَانَ تَوَّابًا", "Fa-sabbiḥ bi-ḥamdi Rabbika wastaghfirh, innahū kāna tawwābā", "Then exalt Him with praise of your Lord and ask forgiveness of Him. Indeed, He is ever Accepting of repentance.")
            )
        ),
        Surah(
            number = 112,
            englishName = "Al-Ikhlas",
            meaning = "The Sincerity",
            arabicName = "الإِخْلَاص",
            revelationType = RevelationType.MAKKI,
            totalVersesInQuran = 4,
            isCompleteInApp = true,
            showBismillahHeader = true,
            introduction = "Described as equivalent to a third of the Quran in meaning, expressing the absolute Oneness and perfection of Allah.",
            ayahs = listOf(
                Ayah(1, "قُلْ هُوَ اللَّهُ أَحَدٌ", "Qul huwallāhu aḥad", "Say, 'He is Allah, who is One,"),
                Ayah(2, "اللَّهُ الصَّمَدُ", "Allāhuṣ-ṣamad", "Allah, the Eternal Refuge."),
                Ayah(3, "لَمْ يَلِدْ وَلَمْ يُولَدْ", "Lam yalid wa lam yūlad", "He neither begets nor is born,"),
                Ayah(4, "وَلَمْ يَكُنْ لَهُ كُفُوًا أَحَدٌ", "Wa lam yakul-lahū kufuwan aḥad", "Nor is there to Him any equivalent.'")
            )
        ),
        Surah(
            number = 113,
            englishName = "Al-Falaq",
            meaning = "The Daybreak",
            arabicName = "الفَلَق",
            revelationType = RevelationType.MAKKI,
            totalVersesInQuran = 5,
            isCompleteInApp = true,
            showBismillahHeader = true,
            introduction = "Recited morning, evening, and before sleep to seek Allah's protection from outer harms.",
            ayahs = listOf(
                Ayah(1, "قُلْ أَعُوذُ بِرَبِّ الْفَلَقِ", "Qul a'ūdhu bi-Rabbil-falaq", "Say, 'I seek refuge in the Lord of daybreak,"),
                Ayah(2, "مِنْ شَرِّ مَا خَلَقَ", "Min sharri mā khalaq", "From the evil of that which He created,"),
                Ayah(3, "وَمِنْ شَرِّ غَاسِقٍ إِذَا وَقَبَ", "Wa min sharri ghāsiqin idhā waqab", "And from the evil of darkness when it settles,"),
                Ayah(4, "وَمِنْ شَرِّ النَّفَّاثَاتِ فِي الْعُقَدِ", "Wa min sharrin-naffāthāti fil-'uqad", "And from the evil of the blowers in knots,"),
                Ayah(5, "وَمِنْ شَرِّ حَاسِدٍ إِذَا حَسَدَ", "Wa min sharri ḥāsidin idhā ḥasad", "And from the evil of an envier when he envies.'")
            )
        ),
        Surah(
            number = 114,
            englishName = "An-Nas",
            meaning = "Mankind",
            arabicName = "النَّاس",
            revelationType = RevelationType.MAKKI,
            totalVersesInQuran = 6,
            isCompleteInApp = true,
            showBismillahHeader = true,
            introduction = "The concluding surah of the Quran, seeking Allah's protection over the human heart against inner whispers and anxiety.",
            ayahs = listOf(
                Ayah(1, "قُلْ أَعُوذُ بِرَبِّ النَّاسِ", "Qul a'ūdhu bi-Rabbin-nās", "Say, 'I seek refuge in the Lord of mankind,"),
                Ayah(2, "مَلِكِ النَّاسِ", "Malikin-nās", "The Sovereign of mankind,"),
                Ayah(3, "إِلَٰهِ النَّاسِ", "Ilāhin-nās", "The God of mankind,"),
                Ayah(4, "مِنْ شَرِّ الْوَسْوَاسِ الْخَنَّاسِ", "Min sharril-waswāsil-khannās", "From the evil of the retreating whisperer —"),
                Ayah(5, "الَّذِي يُوَسْوِسُ فِي صُدُورِ النَّاسِ", "Alladhī yuwaswisu fī ṣudūrin-nās", "Who whispers into the breasts of mankind —"),
                Ayah(6, "مِنَ الْجِنَّةِ وَالنَّاسِ", "Minal-jinnati wan-nās", "From among the jinn and mankind.'")
            )
        )
    )

    fun getSurahByNumber(number: Int): Surah =
        surahs.firstOrNull { it.number == number } ?: surahs.first()
}
