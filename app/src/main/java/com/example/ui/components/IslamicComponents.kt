package com.example.ui.components

import android.content.Context
import android.content.Intent
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Refresh
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.R
import com.example.ui.theme.AmiriArabicFontFamily

/**
 * Geometric 8-pointed Rub el Hizb star emblem framing Surah and Ayah numbers.
 */
@Composable
fun RubElHizbBadge(
    numberText: String,
    modifier: Modifier = Modifier,
    size: Dp = 42.dp,
    strokeColor: Color = MaterialTheme.colorScheme.primary,
    fillColor: Color = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.55f),
    textColor: Color = MaterialTheme.colorScheme.primary
) {
    Box(
        modifier = modifier.size(size),
        contentAlignment = Alignment.Center
    ) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            val side = this.size.minDimension * 0.68f
            val topLeft = Offset((this.size.width - side) / 2f, (this.size.height - side) / 2f)
            val squareSize = Size(side, side)
            val stroke = Stroke(width = 1.6.dp.toPx())

            drawRect(color = fillColor, topLeft = topLeft, size = squareSize)
            drawRect(color = strokeColor, topLeft = topLeft, size = squareSize, style = stroke)

            rotate(degrees = 45f) {
                drawRect(color = fillColor, topLeft = topLeft, size = squareSize)
                drawRect(color = strokeColor, topLeft = topLeft, size = squareSize, style = stroke)
            }
        }
        Text(
            text = numberText,
            style = MaterialTheme.typography.labelMedium,
            fontWeight = FontWeight.Bold,
            color = textColor,
            maxLines = 1
        )
    }
}

/**
 * Refined horizontal ornamental divider with a central diamond motif.
 */
@Composable
fun OrnamentalDivider(
    modifier: Modifier = Modifier,
    lineColor: Color = MaterialTheme.colorScheme.outlineVariant,
    accentColor: Color = MaterialTheme.colorScheme.tertiary
) {
    Canvas(
        modifier = modifier
            .fillMaxWidth()
            .height(14.dp)
    ) {
        val cy = size.height / 2f
        val cx = size.width / 2f
        val jewelRadius = 4.5.dp.toPx()

        drawLine(
            color = lineColor,
            start = Offset(0f, cy),
            end = Offset(cx - jewelRadius * 2.4f, cy),
            strokeWidth = 1.dp.toPx()
        )
        drawLine(
            color = lineColor,
            start = Offset(cx + jewelRadius * 2.4f, cy),
            end = Offset(size.width, cy),
            strokeWidth = 1.dp.toPx()
        )

        val diamond = Path().apply {
            moveTo(cx, cy - jewelRadius)
            lineTo(cx + jewelRadius, cy)
            lineTo(cx, cy + jewelRadius)
            lineTo(cx - jewelRadius, cy)
            close()
        }
        drawPath(path = diamond, color = accentColor)
    }
}

/**
 * Renders classical Arabic calligraphy in RTL layout with generous line height so diacritics never clip.
 */
@Composable
fun ArabicScriptText(
    text: String,
    modifier: Modifier = Modifier,
    fontSize: TextUnit = 26.sp,
    color: Color = MaterialTheme.colorScheme.onSurface,
    textAlign: TextAlign = TextAlign.End
) {
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
        Text(
            text = text,
            modifier = modifier,
            fontFamily = AmiriArabicFontFamily,
            fontSize = fontSize,
            lineHeight = (fontSize.value * 1.85f).sp,
            color = color,
            textAlign = textAlign
        )
    }
}

@Composable
fun BismillahBanner(modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier.fillMaxWidth(),
        shape = MaterialTheme.shapes.medium,
        color = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.45f),
        border = BorderStroke(
            width = 1.dp,
            color = MaterialTheme.colorScheme.outlineVariant
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ArabicScriptText(
                text = stringResource(R.string.bismillah_arabic),
                fontSize = 27.sp,
                color = MaterialTheme.colorScheme.primary,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = stringResource(R.string.bismillah_translation),
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                textAlign = TextAlign.Center
            )
        }
    }
}

private data class DhikrPreset(
    val shortLabel: String,
    val arabic: String,
    val transliteration: String,
    val meaning: String
)

private val dhikrPresets = listOf(
    DhikrPreset("SubhanAllah", "سُبْحَانَ اللَّهِ", "SubḥānAllāh", "Glory be to Allah"),
    DhikrPreset("Alhamdulillah", "الْحَمْدُ لِلَّهِ", "Al-ḥamdu lillāh", "All praise is due to Allah"),
    DhikrPreset("Allahu Akbar", "اللَّهُ أَكْبَرُ", "Allāhu Akbar", "Allah is the Greatest"),
    DhikrPreset("Astaghfirullah", "أَسْتَغْفِرُ اللَّهَ", "Astaghfirullāh", "I seek Allah's forgiveness")
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RemembranceBottomSheet(
    count: Int,
    target: Int,
    totalLifetimeCount: Int,
    onIncrement: () -> Unit,
    onReset: () -> Unit,
    onSelectTarget: (Int) -> Unit,
    onDismiss: () -> Unit
) {
    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
    val haptic = LocalHapticFeedback.current
    var selectedPresetIndex by remember { mutableIntStateOf(0) }
    val preset = dhikrPresets[selectedPresetIndex]

    val progress by animateFloatAsState(
        targetValue = (count.toFloat() / target.coerceAtLeast(1).toFloat()).coerceIn(0f, 1f),
        animationSpec = spring(dampingRatio = 0.7f, stiffness = 300f),
        label = "tasbih_progress"
    )

    ModalBottomSheet(
        onDismissRequest = onDismiss,
        sheetState = sheetState,
        containerColor = MaterialTheme.colorScheme.surface
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .navigationBarsPadding()
                .padding(horizontal = 24.dp)
                .padding(bottom = 28.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(
                        text = stringResource(R.string.remembrance_title),
                        style = MaterialTheme.typography.headlineSmall,
                        color = MaterialTheme.colorScheme.primary
                    )
                    Text(
                        text = "Lifetime Dhikr: $totalLifetimeCount",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
                IconButton(
                    onClick = onReset,
                    modifier = Modifier.testTag("tasbih_reset_button")
                ) {
                    Icon(
                        imageVector = Icons.Rounded.Refresh,
                        contentDescription = stringResource(R.string.cd_reset_counter),
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
            }

            Spacer(modifier = Modifier.height(14.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                dhikrPresets.forEachIndexed { index, item ->
                    FilterChip(
                        selected = selectedPresetIndex == index,
                        onClick = { selectedPresetIndex = index },
                        label = {
                            Text(
                                text = item.shortLabel,
                                maxLines = 1,
                                style = MaterialTheme.typography.labelSmall
                            )
                        },
                        modifier = Modifier.weight(1f),
                        colors = FilterChipDefaults.filterChipColors(
                            selectedContainerColor = MaterialTheme.colorScheme.primary,
                            selectedLabelColor = MaterialTheme.colorScheme.onPrimary
                        )
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            ArabicScriptText(
                text = preset.arabic,
                fontSize = 32.sp,
                color = MaterialTheme.colorScheme.primary,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
            Text(
                text = "${preset.transliteration} • ${preset.meaning}",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(22.dp))

            val primaryColor = MaterialTheme.colorScheme.primary
            val trackColor = MaterialTheme.colorScheme.surfaceContainerHigh
            val goldColor = MaterialTheme.colorScheme.tertiary

            Box(
                modifier = Modifier
                    .size(188.dp)
                    .clip(CircleShape)
                    .background(
                        Brush.radialGradient(
                            colors = listOf(
                                MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.65f),
                                MaterialTheme.colorScheme.surfaceContainerLow
                            )
                        )
                    )
                    .border(1.dp, MaterialTheme.colorScheme.outlineVariant, CircleShape)
                    .clickable {
                        haptic.performHapticFeedback(HapticFeedbackType.TextHandleMove)
                        onIncrement()
                    }
                    .testTag("tasbih_tap_orb"),
                contentAlignment = Alignment.Center
            ) {
                Canvas(modifier = Modifier.fillMaxSize().padding(10.dp)) {
                    val strokeWidth = 8.dp.toPx()
                    drawArc(
                        color = trackColor,
                        startAngle = -90f,
                        sweepAngle = 360f,
                        useCenter = false,
                        style = Stroke(width = strokeWidth, cap = StrokeCap.Round)
                    )
                    drawArc(
                        color = if (count == target) goldColor else primaryColor,
                        startAngle = -90f,
                        sweepAngle = 360f * progress,
                        useCenter = false,
                        style = Stroke(width = strokeWidth, cap = StrokeCap.Round)
                    )
                }

                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = "$count",
                        style = MaterialTheme.typography.displaySmall.copy(fontSize = 46.sp),
                        color = MaterialTheme.colorScheme.primary
                    )
                    Text(
                        text = "of $target",
                        style = MaterialTheme.typography.labelLarge,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "Tap to count",
                        style = MaterialTheme.typography.labelSmall,
                        color = MaterialTheme.colorScheme.tertiary
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Row(
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Cycle Target:",
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                listOf(33, 99, 100).forEach { goal ->
                    FilterChip(
                        selected = target == goal,
                        onClick = { onSelectTarget(goal) },
                        label = { Text("$goal") }
                    )
                }
            }
        }
    }
}

object ShareUtils {
    fun shareText(context: Context, title: String, content: String) {
        val sendIntent = Intent(Intent.ACTION_SEND).apply {
            type = "text/plain"
            putExtra(Intent.EXTRA_SUBJECT, title)
            putExtra(Intent.EXTRA_TEXT, content)
        }
        context.startActivity(Intent.createChooser(sendIntent, "Share via"))
    }
}
