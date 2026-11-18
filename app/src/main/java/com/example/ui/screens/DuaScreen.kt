package com.example.ui.screens

import androidx.compose.foundation.BorderStroke
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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.VolumeUp
import androidx.compose.material.icons.outlined.BookmarkBorder
import androidx.compose.material.icons.rounded.Bookmark
import androidx.compose.material.icons.rounded.CheckCircle
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material.icons.rounded.Stop
import androidx.compose.material.icons.rounded.TouchApp
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.R
import com.example.data.Dua
import com.example.data.DuaCategory
import com.example.data.HadithDuaData
import com.example.data.UserProgress
import com.example.ui.components.ArabicScriptText
import com.example.ui.components.OrnamentalDivider
import com.example.ui.components.ShareUtils

@Composable
fun DuaScreen(
    userProgress: UserProgress,
    duaSessionCounts: Map<String, Int>,
    speakingId: String?,
    onToggleBookmark: (String) -> Unit,
    onIncrementRepeat: (String, Int) -> Unit,
    onSpeakDua: (String, String) -> Unit,
    onOpenCounter: () -> Unit,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    var searchQuery by remember { mutableStateOf("") }
    var selectedCategory by remember { mutableStateOf(DuaCategory.ALL) }
    var showBookmarkedOnly by remember { mutableStateOf(false) }

    val filteredDuas = remember(searchQuery, selectedCategory, showBookmarkedOnly, userProgress.bookmarkedDuaIds) {
        HadithDuaData.duas.filter { dua ->
            val matchesQuery = searchQuery.isBlank() ||
                dua.title.contains(searchQuery, ignoreCase = true) ||
                dua.translation.contains(searchQuery, ignoreCase = true) ||
                dua.transliteration.contains(searchQuery, ignoreCase = true) ||
                dua.occasion.contains(searchQuery, ignoreCase = true)
            val matchesCategory = selectedCategory == DuaCategory.ALL || dua.category == selectedCategory
            val matchesBookmark = !showBookmarkedOnly || dua.id in userProgress.bookmarkedDuaIds
            matchesQuery && matchesCategory && matchesBookmark
        }
    }

    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .widthIn(max = 720.dp),
            contentPadding = PaddingValues(horizontal = 18.dp, vertical = 10.dp),
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Authentic supplications in Arabic with English pronunciation and meaning.",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        modifier = Modifier.weight(1f)
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    FilledTonalButton(
                        onClick = onOpenCounter,
                        modifier = Modifier.testTag("dua_open_tasbih_button")
                    ) {
                        Icon(
                            imageVector = Icons.Rounded.TouchApp,
                            contentDescription = null,
                            modifier = Modifier.size(18.dp)
                        )
                        Spacer(modifier = Modifier.width(6.dp))
                        Text("Tasbih")
                    }
                }
            }

            item {
                OutlinedTextField(
                    value = searchQuery,
                    onValueChange = { searchQuery = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .testTag("dua_search_input"),
                    placeholder = { Text(stringResource(R.string.search_dua)) },
                    leadingIcon = { Icon(Icons.Rounded.Search, contentDescription = null) },
                    trailingIcon = {
                        if (searchQuery.isNotEmpty()) {
                            IconButton(onClick = { searchQuery = "" }) {
                                Icon(Icons.Rounded.Close, contentDescription = "Clear search")
                            }
                        }
                    },
                    singleLine = true,
                    shape = MaterialTheme.shapes.medium,
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedContainerColor = MaterialTheme.colorScheme.surface,
                        unfocusedContainerColor = MaterialTheme.colorScheme.surface
                    )
                )
            }

            item {
                LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    item {
                        FilterChip(
                            selected = showBookmarkedOnly,
                            onClick = { showBookmarkedOnly = !showBookmarkedOnly },
                            label = { Text("Saved (${userProgress.bookmarkedDuaIds.size})") },
                            leadingIcon = {
                                Icon(
                                    imageVector = Icons.Rounded.Bookmark,
                                    contentDescription = null,
                                    modifier = Modifier.size(16.dp)
                                )
                            },
                            colors = FilterChipDefaults.filterChipColors(
                                selectedContainerColor = MaterialTheme.colorScheme.tertiary,
                                selectedLabelColor = MaterialTheme.colorScheme.onTertiary,
                                selectedLeadingIconColor = MaterialTheme.colorScheme.onTertiary
                            )
                        )
                    }
                    items(DuaCategory.entries) { category ->
                        FilterChip(
                            selected = selectedCategory == category,
                            onClick = { selectedCategory = category },
                            label = { Text(category.label) },
                            colors = FilterChipDefaults.filterChipColors(
                                selectedContainerColor = MaterialTheme.colorScheme.primary,
                                selectedLabelColor = MaterialTheme.colorScheme.onPrimary
                            )
                        )
                    }
                }
            }

            if (filteredDuas.isEmpty()) {
                item {
                    Surface(
                        modifier = Modifier.fillMaxWidth(),
                        shape = MaterialTheme.shapes.medium,
                        color = MaterialTheme.colorScheme.surfaceContainerLow
                    ) {
                        Column(
                            modifier = Modifier.padding(28.dp),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.spacedBy(6.dp)
                        ) {
                            Text(
                                text = "No duas match this filter",
                                style = MaterialTheme.typography.titleMedium
                            )
                            Text(
                                text = "Select another occasion category or bookmark your favorite duas.",
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.onSurfaceVariant,
                                textAlign = TextAlign.Center
                            )
                        }
                    }
                }
            } else {
                items(filteredDuas, key = { it.id }) { dua ->
                    val isBookmarked = dua.id in userProgress.bookmarkedDuaIds
                    val currentCount = duaSessionCounts[dua.id] ?: 0
                    val speechKey = "dua_${dua.id}"

                    DuaCard(
                        dua = dua,
                        currentRepeatCount = currentCount,
                        isBookmarked = isBookmarked,
                        isSpeaking = speakingId == speechKey,
                        onIncrementRepeat = { onIncrementRepeat(dua.id, dua.recommendedCount) },
                        onToggleBookmark = { onToggleBookmark(dua.id) },
                        onListen = {
                            onSpeakDua(speechKey, "${dua.title}. ${dua.translation}")
                        },
                        onShare = {
                            ShareUtils.shareText(
                                context,
                                dua.title,
                                "${dua.arabic}\n\n${dua.transliteration}\n\n\"${dua.translation}\"\n— ${dua.reference}"
                            )
                        }
                    )
                }
            }

            item { Spacer(modifier = Modifier.height(16.dp)) }
        }
    }
}

@Composable
private fun DuaCard(
    dua: Dua,
    currentRepeatCount: Int,
    isBookmarked: Boolean,
    isSpeaking: Boolean,
    onIncrementRepeat: () -> Unit,
    onToggleBookmark: () -> Unit,
    onListen: () -> Unit,
    onShare: () -> Unit
) {
    val haptic = LocalHapticFeedback.current
    val isDone = currentRepeatCount >= dua.recommendedCount

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .testTag("dua_card_${dua.id}"),
        shape = MaterialTheme.shapes.large,
        color = MaterialTheme.colorScheme.surface,
        border = BorderStroke(
            width = if (isDone) 1.5.dp else 1.dp,
            color = if (isDone) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.outlineVariant
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(18.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Surface(
                    shape = RoundedCornerShape(50),
                    color = MaterialTheme.colorScheme.secondaryContainer
                ) {
                    Text(
                        text = dua.category.label,
                        style = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.onSecondaryContainer,
                        modifier = Modifier.padding(horizontal = 12.dp, vertical = 4.dp)
                    )
                }

                Row(verticalAlignment = Alignment.CenterVertically) {
                    IconButton(onClick = onListen) {
                        Icon(
                            imageVector = if (isSpeaking) Icons.Rounded.Stop else Icons.AutoMirrored.Rounded.VolumeUp,
                            contentDescription = stringResource(
                                if (isSpeaking) R.string.cd_stop_audio else R.string.cd_listen
                            ),
                            tint = if (isSpeaking) MaterialTheme.colorScheme.tertiary else MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                    IconButton(onClick = onToggleBookmark) {
                        Icon(
                            imageVector = if (isBookmarked) Icons.Rounded.Bookmark else Icons.Outlined.BookmarkBorder,
                            contentDescription = stringResource(R.string.cd_bookmark),
                            tint = if (isBookmarked) MaterialTheme.colorScheme.tertiary else MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                    IconButton(onClick = onShare) {
                        Icon(
                            imageVector = Icons.Rounded.Share,
                            contentDescription = stringResource(R.string.cd_share),
                            tint = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            }

            Text(
                text = dua.title,
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.primary
            )

            Text(
                text = dua.occasion,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.tertiary
            )

            ArabicScriptText(
                text = dua.arabic,
                fontSize = 25.sp,
                color = MaterialTheme.colorScheme.onSurface,
                modifier = Modifier.fillMaxWidth()
            )

            OrnamentalDivider()

            Text(
                text = dua.transliteration,
                style = MaterialTheme.typography.bodyMedium.copy(fontStyle = FontStyle.Italic),
                color = MaterialTheme.colorScheme.primary
            )

            Text(
                text = dua.translation,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurface
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = dua.reference,
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.weight(1f)
                )

                FilledTonalButton(
                    onClick = {
                        haptic.performHapticFeedback(HapticFeedbackType.TextHandleMove)
                        onIncrementRepeat()
                    },
                    colors = ButtonDefaults.filledTonalButtonColors(
                        containerColor = if (isDone) {
                            MaterialTheme.colorScheme.primary
                        } else {
                            MaterialTheme.colorScheme.primaryContainer
                        },
                        contentColor = if (isDone) {
                            MaterialTheme.colorScheme.onPrimary
                        } else {
                            MaterialTheme.colorScheme.onPrimaryContainer
                        }
                    ),
                    modifier = Modifier.testTag("dua_repeat_button_${dua.id}")
                ) {
                    if (isDone) {
                        Icon(
                            imageVector = Icons.Rounded.CheckCircle,
                            contentDescription = null,
                            modifier = Modifier.size(16.dp)
                        )
                        Spacer(modifier = Modifier.width(6.dp))
                    }
                    Text(
                        text = if (isDone) {
                            "Recited (${dua.recommendedCount}/${dua.recommendedCount})"
                        } else {
                            "Recite $currentRepeatCount/${dua.recommendedCount}"
                        }
                    )
                }
            }
        }
    }
}
