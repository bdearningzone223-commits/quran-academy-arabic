package com.example.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowForward
import androidx.compose.material.icons.automirrored.rounded.MenuBook
import androidx.compose.material.icons.rounded.AutoAwesome
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.icons.rounded.FormatQuote
import androidx.compose.material.icons.rounded.School
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material.icons.rounded.TouchApp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.R
import com.example.data.AcademyData
import com.example.data.HadithDuaData
import com.example.data.QuranData
import com.example.data.UserProgress
import com.example.ui.components.ArabicScriptText
import com.example.ui.components.OrnamentalDivider
import com.example.ui.components.RubElHizbBadge
import com.example.ui.components.ShareUtils
import com.example.viewmodel.DailyInspiration

@Composable
fun HomeScreen(
    userProgress: UserProgress,
    dailyInspiration: DailyInspiration,
    onOpenSurah: (Int) -> Unit,
    onNavigateQuran: () -> Unit,
    onNavigateHadith: () -> Unit,
    onNavigateDua: () -> Unit,
    onNavigateAcademy: () -> Unit,
    onOpenCounter: () -> Unit,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    val lastReadSurah = QuranData.getSurahByNumber(userProgress.lastReadSurahNumber)

    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .widthIn(max = 720.dp),
            contentPadding = PaddingValues(horizontal = 18.dp, vertical = 10.dp),
            verticalArrangement = Arrangement.spacedBy(18.dp)
        ) {
            item {
                Text(
                    text = "Peace be upon you • Welcome to your daily sanctuary of Quran & Sunnah",
                    style = MaterialTheme.typography.labelLarge,
                    color = MaterialTheme.colorScheme.tertiary
                )
            }

            // Hero Editorial Banner
            item {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(216.dp)
                        .testTag("home_hero_card"),
                    shape = MaterialTheme.shapes.large,
                    elevation = CardDefaults.cardElevation(defaultElevation = 3.dp)
                ) {
                    Box(modifier = Modifier.fillMaxSize()) {
                        Image(
                            painter = painterResource(id = R.drawable.img_hero_academy_1794957868225),
                            contentDescription = stringResource(R.string.cd_hero_banner),
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop
                        )
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(
                                    Brush.horizontalGradient(
                                        0.0f to MaterialTheme.colorScheme.primary.copy(alpha = 0.95f),
                                        0.62f to MaterialTheme.colorScheme.primary.copy(alpha = 0.80f),
                                        1.0f to Color.Transparent
                                    )
                                )
                        )
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(22.dp),
                            verticalArrangement = Arrangement.SpaceBetween
                        ) {
                            Surface(
                                shape = RoundedCornerShape(50),
                                color = MaterialTheme.colorScheme.tertiary.copy(alpha = 0.28f),
                                border = BorderStroke(1.dp, MaterialTheme.colorScheme.tertiary.copy(alpha = 0.7f))
                            ) {
                                Text(
                                    text = stringResource(R.string.academy_subtitle),
                                    style = MaterialTheme.typography.labelMedium,
                                    color = Color(0xFFFDF7E7),
                                    modifier = Modifier.padding(horizontal = 12.dp, vertical = 5.dp)
                                )
                            }

                            Column(modifier = Modifier.fillMaxWidth(0.78f)) {
                                Text(
                                    text = stringResource(R.string.academy_full_title),
                                    style = MaterialTheme.typography.headlineMedium,
                                    color = Color.White
                                )
                                Spacer(modifier = Modifier.height(6.dp))
                                Text(
                                    text = "Recite the Quran in Arabic with English translation, learn Tajweed, and practice daily Duas.",
                                    style = MaterialTheme.typography.bodySmall,
                                    color = Color(0xFFE4F2EB),
                                    maxLines = 3,
                                    overflow = TextOverflow.Ellipsis
                                )
                            }
                        }
                    }
                }
            }

            // Continue Reading Card
            item {
                Surface(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(MaterialTheme.shapes.medium)
                        .clickable { onOpenSurah(lastReadSurah.number) }
                        .testTag("home_continue_reading_card"),
                    shape = MaterialTheme.shapes.medium,
                    color = MaterialTheme.colorScheme.surface,
                    border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant),
                    tonalElevation = 1.dp
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.weight(1f)
                        ) {
                            RubElHizbBadge(
                                numberText = "${lastReadSurah.number}",
                                size = 46.dp
                            )
                            Spacer(modifier = Modifier.width(14.dp))
                            Column {
                                Text(
                                    text = stringResource(R.string.continue_reading).uppercase(),
                                    style = MaterialTheme.typography.labelSmall,
                                    color = MaterialTheme.colorScheme.tertiary,
                                    fontWeight = FontWeight.Bold
                                )
                                Text(
                                    text = lastReadSurah.englishName,
                                    style = MaterialTheme.typography.titleMedium,
                                    color = MaterialTheme.colorScheme.onSurface
                                )
                                Text(
                                    text = "${lastReadSurah.meaning} • ${lastReadSurah.ayahs.size} verses",
                                    style = MaterialTheme.typography.bodySmall,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            }
                        }
                        Spacer(modifier = Modifier.width(8.dp))
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            ArabicScriptText(
                                text = lastReadSurah.arabicName,
                                fontSize = 23.sp,
                                color = MaterialTheme.colorScheme.primary
                            )
                            Spacer(modifier = Modifier.width(6.dp))
                            Icon(
                                imageVector = Icons.AutoMirrored.Rounded.ArrowForward,
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.primary,
                                modifier = Modifier.size(20.dp)
                            )
                        }
                    }
                }
            }

            // 4 Learning Pillars Grid
            item {
                Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                    Text(
                        text = "Explore the Academy",
                        style = MaterialTheme.typography.titleLarge,
                        color = MaterialTheme.colorScheme.onBackground
                    )
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        PillarCard(
                            title = "Noble Quran",
                            subtitle = "${QuranData.surahs.size} Essential Surahs",
                            icon = Icons.AutoMirrored.Rounded.MenuBook,
                            containerColor = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.65f),
                            accentColor = MaterialTheme.colorScheme.primary,
                            onClick = onNavigateQuran,
                            modifier = Modifier
                                .weight(1f)
                                .testTag("pillar_quran_card")
                        )
                        PillarCard(
                            title = "Hadith",
                            subtitle = "${HadithDuaData.hadiths.size} Authentic Gems",
                            icon = Icons.Rounded.FormatQuote,
                            containerColor = MaterialTheme.colorScheme.tertiaryContainer.copy(alpha = 0.72f),
                            accentColor = MaterialTheme.colorScheme.tertiary,
                            onClick = onNavigateHadith,
                            modifier = Modifier
                                .weight(1f)
                                .testTag("pillar_hadith_card")
                        )
                    }
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        PillarCard(
                            title = "Daily Dua",
                            subtitle = "${HadithDuaData.duas.size} Supplications",
                            icon = Icons.Rounded.Favorite,
                            containerColor = MaterialTheme.colorScheme.secondaryContainer.copy(alpha = 0.8f),
                            accentColor = MaterialTheme.colorScheme.secondary,
                            onClick = onNavigateDua,
                            modifier = Modifier
                                .weight(1f)
                                .testTag("pillar_dua_card")
                        )
                        PillarCard(
                            title = "Tajweed & Quiz",
                            subtitle = "${AcademyData.tajweedLessons.size} Lessons • 28 Letters",
                            icon = Icons.Rounded.School,
                            containerColor = MaterialTheme.colorScheme.surfaceContainerHigh,
                            accentColor = MaterialTheme.colorScheme.primary,
                            onClick = onNavigateAcademy,
                            modifier = Modifier
                                .weight(1f)
                                .testTag("pillar_academy_card")
                        )
                    }
                }
            }

            // Ayah of the Day Card (Arabic + English Translation)
            item {
                val surah = dailyInspiration.surah
                val ayah = dailyInspiration.ayah
                Surface(
                    modifier = Modifier.fillMaxWidth(),
                    shape = MaterialTheme.shapes.large,
                    color = MaterialTheme.colorScheme.surface,
                    border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(20.dp)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Icon(
                                    imageVector = Icons.Rounded.AutoAwesome,
                                    contentDescription = null,
                                    tint = MaterialTheme.colorScheme.tertiary,
                                    modifier = Modifier.size(18.dp)
                                )
                                Spacer(modifier = Modifier.width(6.dp))
                                Text(
                                    text = stringResource(R.string.daily_ayah),
                                    style = MaterialTheme.typography.titleSmall,
                                    color = MaterialTheme.colorScheme.tertiary
                                )
                            }
                            IconButton(
                                onClick = {
                                    ShareUtils.shareText(
                                        context,
                                        "Ayah of the Day",
                                        "${ayah.arabic}\n\n\"${ayah.translation}\"\n— Surah ${surah.englishName} (${surah.number}:${ayah.numberInSurah})"
                                    )
                                }
                            ) {
                                Icon(
                                    imageVector = Icons.Rounded.Share,
                                    contentDescription = stringResource(R.string.cd_share),
                                    tint = MaterialTheme.colorScheme.onSurfaceVariant,
                                    modifier = Modifier.size(20.dp)
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(6.dp))

                        ArabicScriptText(
                            text = ayah.arabic,
                            fontSize = 26.sp,
                            color = MaterialTheme.colorScheme.primary,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.fillMaxWidth()
                        )

                        Spacer(modifier = Modifier.height(10.dp))
                        OrnamentalDivider()
                        Spacer(modifier = Modifier.height(10.dp))

                        Text(
                            text = "“${ayah.translation}”",
                            style = MaterialTheme.typography.bodyLarge,
                            color = MaterialTheme.colorScheme.onSurface,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.fillMaxWidth()
                        )

                        Spacer(modifier = Modifier.height(12.dp))

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "Surah ${surah.englishName} • ${surah.number}:${ayah.numberInSurah}",
                                style = MaterialTheme.typography.labelMedium,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                            TextButton(
                                onClick = { onOpenSurah(surah.number) },
                                modifier = Modifier.testTag("home_read_daily_surah_button")
                            ) {
                                Text("Read Surah")
                            }
                        }
                    }
                }
            }

            // Prophetic Wisdom Card (Arabic + English)
            item {
                val hadith = dailyInspiration.hadith
                Surface(
                    modifier = Modifier.fillMaxWidth(),
                    shape = MaterialTheme.shapes.large,
                    color = MaterialTheme.colorScheme.surfaceContainerLow,
                    border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(20.dp)
                    ) {
                        Text(
                            text = stringResource(R.string.daily_hadith).uppercase(),
                            style = MaterialTheme.typography.labelSmall,
                            color = MaterialTheme.colorScheme.primary,
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = hadith.title,
                            style = MaterialTheme.typography.titleLarge,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        ArabicScriptText(
                            text = hadith.arabic,
                            fontSize = 22.sp,
                            color = MaterialTheme.colorScheme.primary,
                            modifier = Modifier.fillMaxWidth()
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "“${hadith.translation}”",
                            style = MaterialTheme.typography.bodyLarge,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "${hadith.narrator} • ${hadith.source}",
                                style = MaterialTheme.typography.labelMedium,
                                color = MaterialTheme.colorScheme.onSurfaceVariant,
                                modifier = Modifier.weight(1f)
                            )
                            TextButton(onClick = onNavigateHadith) {
                                Text("Explore")
                            }
                        }
                    }
                }
            }

            // Study Progress Card
            item {
                val studiedCount = userProgress.studiedSurahNumbers.size
                val totalSurahs = QuranData.surahs.size
                val completedLessons = userProgress.completedLessonIds.size
                val totalLessons = AcademyData.tajweedLessons.size
                val overallProgress = ((studiedCount + completedLessons).toFloat() /
                    (totalSurahs + totalLessons).coerceAtLeast(1).toFloat()).coerceIn(0f, 1f)

                Surface(
                    modifier = Modifier.fillMaxWidth(),
                    shape = MaterialTheme.shapes.large,
                    color = MaterialTheme.colorScheme.surface,
                    border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(20.dp),
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "Your Study Progress",
                                style = MaterialTheme.typography.titleLarge,
                                color = MaterialTheme.colorScheme.onSurface
                            )
                            Text(
                                text = "${(overallProgress * 100).toInt()}%",
                                style = MaterialTheme.typography.titleMedium,
                                color = MaterialTheme.colorScheme.primary
                            )
                        }

                        LinearProgressIndicator(
                            progress = { overallProgress },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(8.dp)
                                .clip(RoundedCornerShape(50)),
                            color = MaterialTheme.colorScheme.primary,
                            trackColor = MaterialTheme.colorScheme.surfaceContainerHigh
                        )

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            ProgressMetric(
                                label = "Surahs",
                                value = "$studiedCount/$totalSurahs",
                                modifier = Modifier.weight(1f)
                            )
                            ProgressMetric(
                                label = "Tajweed",
                                value = "$completedLessons/$totalLessons",
                                modifier = Modifier.weight(1f)
                            )
                            ProgressMetric(
                                label = "Best Quiz",
                                value = "${userProgress.bestQuizScore}/${AcademyData.quizQuestions.size}",
                                modifier = Modifier.weight(1f)
                            )
                            ProgressMetric(
                                label = "Dhikr",
                                value = "${userProgress.totalRemembranceCount}",
                                modifier = Modifier.weight(1f)
                            )
                        }

                        FilledTonalButton(
                            onClick = onOpenCounter,
                            modifier = Modifier
                                .fillMaxWidth()
                                .testTag("home_open_tasbih_button")
                        ) {
                            Icon(
                                imageVector = Icons.Rounded.TouchApp,
                                contentDescription = null,
                                modifier = Modifier.size(18.dp)
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text("Open Digital Tasbih (${userProgress.counterValue}/${userProgress.counterTarget})")
                        }
                    }
                }
            }

            item { Spacer(modifier = Modifier.height(16.dp)) }
        }
    }
}

@Composable
private fun PillarCard(
    title: String,
    subtitle: String,
    icon: ImageVector,
    containerColor: Color,
    accentColor: Color,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier
            .clip(MaterialTheme.shapes.medium)
            .clickable(onClick = onClick),
        shape = MaterialTheme.shapes.medium,
        color = containerColor,
        border = BorderStroke(1.dp, accentColor.copy(alpha = 0.18f))
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(accentColor.copy(alpha = 0.14f)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    tint = accentColor,
                    modifier = Modifier.size(22.dp)
                )
            }
            Column {
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Text(
                    text = subtitle,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}

@Composable
private fun ProgressMetric(
    label: String,
    value: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = value,
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.primary
        )
        Text(
            text = label,
            style = MaterialTheme.typography.labelSmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}
