package com.example.ui.screens

import androidx.compose.animation.AnimatedVisibility
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
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.VolumeUp
import androidx.compose.material.icons.rounded.CheckCircle
import androidx.compose.material.icons.rounded.EmojiEvents
import androidx.compose.material.icons.rounded.ExpandLess
import androidx.compose.material.icons.rounded.ExpandMore
import androidx.compose.material.icons.rounded.Refresh
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.R
import com.example.data.AcademyData
import com.example.data.ArabicLetter
import com.example.data.TajweedLesson
import com.example.data.UserProgress
import com.example.ui.components.ArabicScriptText
import com.example.ui.components.OrnamentalDivider
import com.example.ui.components.RubElHizbBadge

private enum class AcademySection(val label: String) {
    TAJWEED("Tajweed"),
    ALPHABET("28 Letters"),
    QUIZ("Quiz")
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AcademyScreen(
    userProgress: UserProgress,
    onToggleLessonCompleted: (String) -> Unit,
    onRecordQuizScore: (Int) -> Unit,
    onSpeakText: (String, String) -> Unit,
    modifier: Modifier = Modifier
) {
    var selectedSection by remember { mutableStateOf(AcademySection.TAJWEED) }
    var inspectedLetter by remember { mutableStateOf<ArabicLetter?>(null) }

    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .widthIn(max = 720.dp),
            contentPadding = PaddingValues(horizontal = 18.dp, vertical = 10.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(164.dp),
                    shape = MaterialTheme.shapes.large
                ) {
                    Box(modifier = Modifier.fillMaxSize()) {
                        Image(
                            painter = painterResource(id = R.drawable.img_learn_tajweed_1794957869073),
                            contentDescription = stringResource(R.string.cd_academy_banner),
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop
                        )
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(
                                    Brush.verticalGradient(
                                        0.0f to MaterialTheme.colorScheme.primary.copy(alpha = 0.35f),
                                        1.0f to MaterialTheme.colorScheme.primary.copy(alpha = 0.92f)
                                    )
                                )
                        )
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(18.dp),
                            verticalArrangement = Arrangement.Bottom
                        ) {
                            Text(
                                text = "Tajweed & Arabic Academy",
                                style = MaterialTheme.typography.headlineSmall,
                                color = Color.White
                            )
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                text = "Master the 28 Arabic letters, Tajweed rules with Quranic examples, and test your knowledge.",
                                style = MaterialTheme.typography.bodySmall,
                                color = Color(0xFFE5F2EB)
                            )
                        }
                    }
                }
            }

            item {
                SingleChoiceSegmentedButtonRow(
                    modifier = Modifier
                        .fillMaxWidth()
                        .testTag("academy_section_switcher")
                ) {
                    AcademySection.entries.forEachIndexed { index, section ->
                        SegmentedButton(
                            shape = SegmentedButtonDefaults.itemShape(
                                index = index,
                                count = AcademySection.entries.size
                            ),
                            onClick = { selectedSection = section },
                            selected = selectedSection == section,
                            modifier = Modifier.testTag("academy_tab_${section.name.lowercase()}")
                        ) {
                            Text(section.label, maxLines = 1)
                        }
                    }
                }
            }

            when (selectedSection) {
                AcademySection.TAJWEED -> {
                    item {
                        val done = userProgress.completedLessonIds.size
                        val total = AcademyData.tajweedLessons.size
                        Surface(
                            modifier = Modifier.fillMaxWidth(),
                            shape = MaterialTheme.shapes.medium,
                            color = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.55f)
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(14.dp),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = "Tajweed Foundations Progress",
                                    style = MaterialTheme.typography.titleSmall,
                                    color = MaterialTheme.colorScheme.primary
                                )
                                Text(
                                    text = "$done / $total completed",
                                    style = MaterialTheme.typography.labelLarge,
                                    color = MaterialTheme.colorScheme.primary
                                )
                            }
                        }
                    }

                    items(AcademyData.tajweedLessons, key = { it.id }) { lesson ->
                        TajweedLessonCard(
                            lesson = lesson,
                            isCompleted = lesson.id in userProgress.completedLessonIds,
                            onToggleComplete = { onToggleLessonCompleted(lesson.id) }
                        )
                    }
                }

                AcademySection.ALPHABET -> {
                    item {
                        Text(
                            text = "Tap any Arabic letter to study its 4 script forms, Makhraj articulation point, and Quranic example.",
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }

                    val rows = AcademyData.arabicLetters.chunked(4)
                    items(rows) { rowLetters ->
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(10.dp)
                        ) {
                            rowLetters.forEach { letter ->
                                Surface(
                                    modifier = Modifier
                                        .weight(1f)
                                        .height(94.dp)
                                        .clip(MaterialTheme.shapes.medium)
                                        .clickable { inspectedLetter = letter }
                                        .testTag("letter_tile_${letter.order}"),
                                    shape = MaterialTheme.shapes.medium,
                                    color = MaterialTheme.colorScheme.surface,
                                    border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant)
                                ) {
                                    Column(
                                        modifier = Modifier
                                            .fillMaxSize()
                                            .padding(8.dp),
                                        horizontalAlignment = Alignment.CenterHorizontally,
                                        verticalArrangement = Arrangement.Center
                                    ) {
                                        ArabicScriptText(
                                            text = letter.isolated,
                                            fontSize = 28.sp,
                                            color = MaterialTheme.colorScheme.primary,
                                            textAlign = TextAlign.Center
                                        )
                                        Text(
                                            text = letter.name,
                                            style = MaterialTheme.typography.labelMedium,
                                            color = MaterialTheme.colorScheme.onSurface,
                                            maxLines = 1
                                        )
                                        Text(
                                            text = letter.transliteration,
                                            style = MaterialTheme.typography.labelSmall,
                                            color = MaterialTheme.colorScheme.tertiary,
                                            maxLines = 1
                                        )
                                    }
                                }
                            }
                            repeat(4 - rowLetters.size) {
                                Spacer(modifier = Modifier.weight(1f))
                            }
                        }
                    }
                }

                AcademySection.QUIZ -> {
                    item {
                        AcademyQuizCard(
                            bestScore = userProgress.bestQuizScore,
                            onQuizFinished = onRecordQuizScore
                        )
                    }
                }
            }

            item { Spacer(modifier = Modifier.height(20.dp)) }
        }
    }

    inspectedLetter?.let { letter ->
        val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
        ModalBottomSheet(
            onDismissRequest = { inspectedLetter = null },
            sheetState = sheetState,
            containerColor = MaterialTheme.colorScheme.surface
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .navigationBarsPadding()
                    .padding(horizontal = 24.dp)
                    .padding(bottom = 28.dp),
                verticalArrangement = Arrangement.spacedBy(14.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        Text(
                            text = "Letter ${letter.order} of 28",
                            style = MaterialTheme.typography.labelMedium,
                            color = MaterialTheme.colorScheme.tertiary
                        )
                        Text(
                            text = "${letter.name} (${letter.transliteration})",
                            style = MaterialTheme.typography.headlineSmall,
                            color = MaterialTheme.colorScheme.primary
                        )
                    }
                    FilledTonalButton(
                        onClick = {
                            onSpeakText(
                                "letter_${letter.order}",
                                "${letter.name}. ${letter.pronunciationTip}"
                            )
                        }
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Rounded.VolumeUp,
                            contentDescription = null,
                            modifier = Modifier.size(18.dp)
                        )
                        Spacer(modifier = Modifier.width(6.dp))
                        Text("Guide")
                    }
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    LetterFormBox("Isolated", letter.isolated, Modifier.weight(1f))
                    LetterFormBox("Initial", letter.initial, Modifier.weight(1f))
                    LetterFormBox("Medial", letter.medial, Modifier.weight(1f))
                    LetterFormBox("Final", letter.finalForm, Modifier.weight(1f))
                }

                Surface(
                    modifier = Modifier.fillMaxWidth(),
                    shape = MaterialTheme.shapes.medium,
                    color = MaterialTheme.colorScheme.surfaceContainerLow
                ) {
                    Column(
                        modifier = Modifier.padding(14.dp),
                        verticalArrangement = Arrangement.spacedBy(6.dp)
                    ) {
                        Text(
                            text = "Articulation Point (Makhraj): ${letter.makhrajGroup}",
                            style = MaterialTheme.typography.titleSmall,
                            color = MaterialTheme.colorScheme.primary
                        )
                        Text(
                            text = letter.pronunciationTip,
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                    }
                }

                Surface(
                    modifier = Modifier.fillMaxWidth(),
                    shape = MaterialTheme.shapes.medium,
                    color = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.5f)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp, vertical = 12.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column {
                            Text(
                                text = "Quranic Word Example",
                                style = MaterialTheme.typography.labelSmall,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                            Text(
                                text = letter.exampleMeaning,
                                style = MaterialTheme.typography.titleMedium,
                                color = MaterialTheme.colorScheme.onSurface
                            )
                        }
                        ArabicScriptText(
                            text = letter.exampleWord,
                            fontSize = 30.sp,
                            color = MaterialTheme.colorScheme.primary
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun LetterFormBox(label: String, glyph: String, modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier,
        shape = MaterialTheme.shapes.small,
        color = MaterialTheme.colorScheme.surfaceContainer,
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant)
    ) {
        Column(
            modifier = Modifier.padding(vertical = 10.dp, horizontal = 6.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ArabicScriptText(
                text = glyph,
                fontSize = 26.sp,
                color = MaterialTheme.colorScheme.primary,
                textAlign = TextAlign.Center
            )
            Text(
                text = label,
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}

@Composable
private fun TajweedLessonCard(
    lesson: TajweedLesson,
    isCompleted: Boolean,
    onToggleComplete: () -> Unit
) {
    var expanded by remember { mutableStateOf(lesson.number == 1) }

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .testTag("tajweed_lesson_${lesson.id}"),
        shape = MaterialTheme.shapes.large,
        color = MaterialTheme.colorScheme.surface,
        border = BorderStroke(
            width = if (isCompleted) 1.5.dp else 1.dp,
            color = if (isCompleted) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.outlineVariant
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { expanded = !expanded }
                .padding(18.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.weight(1f)
                ) {
                    RubElHizbBadge(numberText = "${lesson.number}", size = 40.dp)
                    Spacer(modifier = Modifier.width(12.dp))
                    Column {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(
                                text = lesson.level.uppercase(),
                                style = MaterialTheme.typography.labelSmall,
                                color = MaterialTheme.colorScheme.tertiary,
                                fontWeight = FontWeight.Bold
                            )
                            if (isCompleted) {
                                Spacer(modifier = Modifier.width(6.dp))
                                Icon(
                                    imageVector = Icons.Rounded.CheckCircle,
                                    contentDescription = "Completed",
                                    tint = MaterialTheme.colorScheme.primary,
                                    modifier = Modifier.size(15.dp)
                                )
                            }
                        }
                        Text(
                            text = lesson.title,
                            style = MaterialTheme.typography.titleMedium,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                    }
                }
                Icon(
                    imageVector = if (expanded) Icons.Rounded.ExpandLess else Icons.Rounded.ExpandMore,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

            ArabicScriptText(
                text = lesson.arabicTerm,
                fontSize = 20.sp,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.fillMaxWidth()
            )

            Text(
                text = lesson.summary,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            AnimatedVisibility(visible = expanded) {
                Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                    OrnamentalDivider()
                    Text(
                        text = lesson.explanation,
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurface
                    )

                    Surface(
                        shape = MaterialTheme.shapes.medium,
                        color = MaterialTheme.colorScheme.surfaceContainerLow
                    ) {
                        Column(
                            modifier = Modifier.padding(14.dp),
                            verticalArrangement = Arrangement.spacedBy(6.dp)
                        ) {
                            Text(
                                text = "Key Rules",
                                style = MaterialTheme.typography.titleSmall,
                                color = MaterialTheme.colorScheme.primary
                            )
                            lesson.keyRulePoints.forEach { point ->
                                Text(
                                    text = "• $point",
                                    style = MaterialTheme.typography.bodySmall,
                                    color = MaterialTheme.colorScheme.onSurface
                                )
                            }
                        }
                    }

                    Text(
                        text = "Quranic Examples",
                        style = MaterialTheme.typography.titleSmall,
                        color = MaterialTheme.colorScheme.primary
                    )

                    lesson.examples.forEach { ex ->
                        Surface(
                            modifier = Modifier.fillMaxWidth(),
                            shape = MaterialTheme.shapes.small,
                            color = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.35f)
                        ) {
                            Column(
                                modifier = Modifier.padding(12.dp),
                                verticalArrangement = Arrangement.spacedBy(4.dp)
                            ) {
                                ArabicScriptText(
                                    text = ex.arabic,
                                    fontSize = 22.sp,
                                    color = MaterialTheme.colorScheme.primary,
                                    modifier = Modifier.fillMaxWidth()
                                )
                                Text(
                                    text = ex.transliteration,
                                    style = MaterialTheme.typography.labelMedium.copy(fontStyle = FontStyle.Italic),
                                    color = MaterialTheme.colorScheme.primary
                                )
                                Text(
                                    text = ex.note,
                                    style = MaterialTheme.typography.bodySmall,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            }
                        }
                    }

                    FilledTonalButton(
                        onClick = onToggleComplete,
                        modifier = Modifier
                            .fillMaxWidth()
                            .testTag("complete_lesson_button_${lesson.id}")
                    ) {
                        Icon(
                            imageVector = Icons.Rounded.CheckCircle,
                            contentDescription = null,
                            modifier = Modifier.size(18.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(if (isCompleted) "Lesson Completed (Tap to Undo)" else "Mark Lesson Complete")
                    }
                }
            }
        }
    }
}

@Composable
private fun AcademyQuizCard(
    bestScore: Int,
    onQuizFinished: (Int) -> Unit
) {
    val questions = AcademyData.quizQuestions
    var currentIndex by remember { mutableIntStateOf(0) }
    var selectedOption by remember { mutableStateOf<Int?>(null) }
    var score by remember { mutableIntStateOf(0) }
    var isFinished by remember { mutableStateOf(false) }

    if (isFinished) {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .testTag("quiz_result_card"),
            shape = MaterialTheme.shapes.large,
            color = MaterialTheme.colorScheme.surface,
            border = BorderStroke(1.5.dp, MaterialTheme.colorScheme.tertiary)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Icon(
                    imageVector = Icons.Rounded.EmojiEvents,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.tertiary,
                    modifier = Modifier.size(52.dp)
                )
                Text(
                    text = "Well Done!",
                    style = MaterialTheme.typography.headlineMedium,
                    color = MaterialTheme.colorScheme.primary
                )
                Text(
                    text = "You scored $score out of ${questions.size}",
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Text(
                    text = "Personal Best: ${maxOf(bestScore, score)} / ${questions.size}",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Spacer(modifier = Modifier.height(4.dp))
                Button(
                    onClick = {
                        currentIndex = 0
                        selectedOption = null
                        score = 0
                        isFinished = false
                    },
                    modifier = Modifier.testTag("quiz_restart_button")
                ) {
                    Icon(
                        imageVector = Icons.Rounded.Refresh,
                        contentDescription = null,
                        modifier = Modifier.size(18.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("Retake Quiz")
                }
            }
        }
        return
    }

    val question = questions[currentIndex]
    val answered = selectedOption != null

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .testTag("quiz_active_card"),
        shape = MaterialTheme.shapes.large,
        color = MaterialTheme.colorScheme.surface,
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Surface(
                    shape = RoundedCornerShape(50),
                    color = MaterialTheme.colorScheme.tertiaryContainer
                ) {
                    Text(
                        text = question.topic,
                        style = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.onTertiaryContainer,
                        modifier = Modifier.padding(horizontal = 12.dp, vertical = 4.dp)
                    )
                }
                Text(
                    text = "Question ${currentIndex + 1} of ${questions.size} • Best: $bestScore",
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

            LinearProgressIndicator(
                progress = { (currentIndex + 1).toFloat() / questions.size.toFloat() },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(6.dp)
                    .clip(RoundedCornerShape(50))
            )

            question.arabicPrompt?.let { arabic ->
                ArabicScriptText(
                    text = arabic,
                    fontSize = 26.sp,
                    color = MaterialTheme.colorScheme.primary,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
            }

            Text(
                text = question.question,
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onSurface
            )

            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                question.options.forEachIndexed { idx, option ->
                    val isSelected = selectedOption == idx
                    val isCorrect = idx == question.correctIndex

                    val containerColor = when {
                        !answered -> MaterialTheme.colorScheme.surfaceContainerLow
                        isCorrect -> MaterialTheme.colorScheme.primaryContainer
                        isSelected && !isCorrect -> MaterialTheme.colorScheme.errorContainer
                        else -> MaterialTheme.colorScheme.surfaceContainerLow.copy(alpha = 0.6f)
                    }
                    val borderColor = when {
                        !answered -> MaterialTheme.colorScheme.outlineVariant
                        isCorrect -> MaterialTheme.colorScheme.primary
                        isSelected && !isCorrect -> MaterialTheme.colorScheme.error
                        else -> MaterialTheme.colorScheme.outlineVariant
                    }

                    Surface(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(MaterialTheme.shapes.small)
                            .clickable(enabled = !answered) {
                                selectedOption = idx
                                if (idx == question.correctIndex) {
                                    score += 1
                                }
                            }
                            .testTag("quiz_option_$idx"),
                        shape = MaterialTheme.shapes.small,
                        color = containerColor,
                        border = BorderStroke(1.2.dp, borderColor)
                    ) {
                        Text(
                            text = option,
                            style = MaterialTheme.typography.bodyLarge,
                            color = MaterialTheme.colorScheme.onSurface,
                            modifier = Modifier.padding(horizontal = 16.dp, vertical = 14.dp)
                        )
                    }
                }
            }

            AnimatedVisibility(visible = answered) {
                Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                    Surface(
                        shape = MaterialTheme.shapes.small,
                        color = MaterialTheme.colorScheme.secondaryContainer.copy(alpha = 0.7f)
                    ) {
                        Text(
                            text = question.explanation,
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSecondaryContainer,
                            modifier = Modifier.padding(14.dp)
                        )
                    }
                    Button(
                        onClick = {
                            if (currentIndex < questions.lastIndex) {
                                currentIndex += 1
                                selectedOption = null
                            } else {
                                onQuizFinished(score)
                                isFinished = true
                            }
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .testTag("quiz_next_button")
                    ) {
                        Text(if (currentIndex < questions.lastIndex) "Next Question" else "Finish & See Score")
                    }
                }
            }

            if (!answered && currentIndex > 0) {
                OutlinedButton(
                    onClick = {
                        currentIndex = 0
                        selectedOption = null
                        score = 0
                    },
                    modifier = Modifier.align(Alignment.End)
                ) {
                    Text("Restart")
                }
            }
        }
    }
}
