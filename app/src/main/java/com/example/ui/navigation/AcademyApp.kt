package com.example.ui.navigation

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.MenuBook
import androidx.compose.material.icons.automirrored.rounded.MenuBook
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.FormatQuote
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.School
import androidx.compose.material.icons.rounded.DarkMode
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.icons.rounded.FormatQuote
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.LightMode
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material.icons.rounded.School
import androidx.compose.material.icons.rounded.TouchApp
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.R
import com.example.data.HadithDuaData
import com.example.data.QuranData
import com.example.ui.components.OrnamentalDivider
import com.example.ui.components.RemembranceBottomSheet
import com.example.ui.screens.AcademyScreen
import com.example.ui.screens.DuaScreen
import com.example.ui.screens.HadithScreen
import com.example.ui.screens.HomeScreen
import com.example.ui.screens.QuranListScreen
import com.example.ui.screens.SurahDetailScreen
import com.example.viewmodel.AcademyViewModel
import kotlinx.coroutines.launch

object AcademyRoutes {
    const val ROUTE_HOME = "home"
    const val ROUTE_QURAN = "quran"
    const val ROUTE_SURAH_DETAIL = "surah/{surahNumber}"
    const val ROUTE_HADITH = "hadith"
    const val ROUTE_DUA = "dua"
    const val ROUTE_ACADEMY = "academy"

    fun surahDetail(surahNumber: Int) = "surah/$surahNumber"
}

private data class TopDestination(
    val route: String,
    val labelRes: Int,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val testTag: String,
    val drawerTestTag: String
)

private val topDestinations = listOf(
    TopDestination(
        route = AcademyRoutes.ROUTE_HOME,
        labelRes = R.string.nav_home,
        selectedIcon = Icons.Rounded.Home,
        unselectedIcon = Icons.Outlined.Home,
        testTag = "nav_home",
        drawerTestTag = "drawer_item_home"
    ),
    TopDestination(
        route = AcademyRoutes.ROUTE_QURAN,
        labelRes = R.string.nav_quran,
        selectedIcon = Icons.AutoMirrored.Rounded.MenuBook,
        unselectedIcon = Icons.AutoMirrored.Outlined.MenuBook,
        testTag = "nav_quran",
        drawerTestTag = "drawer_item_quran"
    ),
    TopDestination(
        route = AcademyRoutes.ROUTE_HADITH,
        labelRes = R.string.nav_hadith,
        selectedIcon = Icons.Rounded.FormatQuote,
        unselectedIcon = Icons.Outlined.FormatQuote,
        testTag = "nav_hadith",
        drawerTestTag = "drawer_item_hadith"
    ),
    TopDestination(
        route = AcademyRoutes.ROUTE_DUA,
        labelRes = R.string.nav_dua,
        selectedIcon = Icons.Rounded.Favorite,
        unselectedIcon = Icons.Outlined.FavoriteBorder,
        testTag = "nav_dua",
        drawerTestTag = "drawer_item_dua"
    ),
    TopDestination(
        route = AcademyRoutes.ROUTE_ACADEMY,
        labelRes = R.string.nav_academy,
        selectedIcon = Icons.Rounded.School,
        unselectedIcon = Icons.Outlined.School,
        testTag = "nav_academy",
        drawerTestTag = "drawer_item_academy"
    )
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AcademyApp(
    viewModel: AcademyViewModel
) {
    val navController = rememberNavController()
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = backStackEntry?.destination?.route

    val userProgress by viewModel.userProgress.collectAsStateWithLifecycle()
    val speakingId by viewModel.speakingId.collectAsStateWithLifecycle()
    val duaSessionCounts by viewModel.duaSessionCounts.collectAsStateWithLifecycle()
    var showCounterSheet by remember { mutableStateOf(false) }

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val coroutineScope = rememberCoroutineScope()

    val showTopLevelNav = currentRoute != null && !currentRoute.startsWith("surah/")

    BackHandler(enabled = drawerState.isOpen) {
        coroutineScope.launch { drawerState.close() }
    }

    fun navigateTopLevel(route: String) {
        viewModel.stopSpeaking()
        navController.navigate(route) {
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }
    }

    fun openSurah(surahNumber: Int) {
        viewModel.stopSpeaking()
        viewModel.openSurah(surahNumber)
        navController.navigate(AcademyRoutes.surahDetail(surahNumber))
    }

    val topBarTitle = when (currentRoute) {
        AcademyRoutes.ROUTE_QURAN -> "Noble Quran"
        AcademyRoutes.ROUTE_HADITH -> "Prophetic Hadith"
        AcademyRoutes.ROUTE_DUA -> "Daily Duas"
        AcademyRoutes.ROUTE_ACADEMY -> "Learning Academy"
        else -> stringResource(R.string.academy_full_title)
    }

    ModalNavigationDrawer(
        drawerState = drawerState,
        gesturesEnabled = showTopLevelNav,
        drawerContent = {
            ModalDrawerSheet(
                modifier = Modifier
                    .width(304.dp)
                    .testTag("navigation_drawer_sheet"),
                drawerContainerColor = MaterialTheme.colorScheme.surface,
                drawerContentColor = MaterialTheme.colorScheme.onSurface,
                windowInsets = WindowInsets.safeDrawing
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState())
                        .padding(bottom = 20.dp)
                ) {
                    // Branded Emerald Drawer Header
                    Surface(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp, vertical = 12.dp),
                        shape = MaterialTheme.shapes.large,
                        color = MaterialTheme.colorScheme.primary
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(
                                    Brush.linearGradient(
                                        colors = listOf(
                                            MaterialTheme.colorScheme.primary,
                                            MaterialTheme.colorScheme.primary.copy(alpha = 0.84f)
                                        )
                                    )
                                )
                                .padding(20.dp)
                        ) {
                            Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                                Surface(
                                    shape = RoundedCornerShape(50),
                                    color = MaterialTheme.colorScheme.tertiary.copy(alpha = 0.28f),
                                    border = BorderStroke(
                                        1.dp,
                                        MaterialTheme.colorScheme.tertiary.copy(alpha = 0.65f)
                                    )
                                ) {
                                    Text(
                                        text = stringResource(R.string.academy_subtitle),
                                        style = MaterialTheme.typography.labelSmall,
                                        color = Color(0xFFFDF7E7),
                                        modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp)
                                    )
                                }
                                Spacer(modifier = Modifier.height(4.dp))
                                Text(
                                    text = stringResource(R.string.academy_full_title),
                                    style = MaterialTheme.typography.headlineSmall,
                                    color = MaterialTheme.colorScheme.onPrimary
                                )
                                Text(
                                    text = "${userProgress.studiedSurahNumbers.size} chapters studied • ${userProgress.completedLessonIds.size} guides completed",
                                    style = MaterialTheme.typography.bodySmall,
                                    color = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.82f)
                                )
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(6.dp))

                    Text(
                        text = "CORE SECTIONS",
                        style = MaterialTheme.typography.labelSmall,
                        color = MaterialTheme.colorScheme.tertiary,
                        modifier = Modifier.padding(horizontal = 24.dp, vertical = 8.dp)
                    )

                    val drawerOrder = listOf(
                        topDestinations[1], // Quran
                        topDestinations[2], // Hadith
                        topDestinations[3], // Dua
                        topDestinations[0], // Home
                        topDestinations[4]  // Academy
                    )

                    drawerOrder.forEach { dest ->
                        val selected = currentRoute == dest.route
                        val badgeText = when (dest.route) {
                            AcademyRoutes.ROUTE_QURAN -> "${QuranData.surahs.size}"
                            AcademyRoutes.ROUTE_HADITH -> "${HadithDuaData.hadiths.size}"
                            AcademyRoutes.ROUTE_DUA -> "${HadithDuaData.duas.size}"
                            else -> null
                        }

                        NavigationDrawerItem(
                            label = {
                                Text(
                                    text = stringResource(dest.labelRes),
                                    style = MaterialTheme.typography.titleSmall
                                )
                            },
                            selected = selected,
                            onClick = {
                                coroutineScope.launch { drawerState.close() }
                                navigateTopLevel(dest.route)
                            },
                            icon = {
                                Icon(
                                    imageVector = if (selected) dest.selectedIcon else dest.unselectedIcon,
                                    contentDescription = null
                                )
                            },
                            badge = badgeText?.let { count ->
                                {
                                    Text(
                                        text = count,
                                        style = MaterialTheme.typography.labelMedium,
                                        color = if (selected) {
                                            MaterialTheme.colorScheme.primary
                                        } else {
                                            MaterialTheme.colorScheme.onSurfaceVariant
                                        }
                                    )
                                }
                            },
                            colors = NavigationDrawerItemDefaults.colors(
                                selectedContainerColor = MaterialTheme.colorScheme.primaryContainer,
                                selectedIconColor = MaterialTheme.colorScheme.primary,
                                selectedTextColor = MaterialTheme.colorScheme.primary
                            ),
                            modifier = Modifier
                                .padding(horizontal = 12.dp, vertical = 2.dp)
                                .testTag(dest.drawerTestTag)
                        )
                    }

                    OrnamentalDivider(
                        modifier = Modifier.padding(horizontal = 24.dp, vertical = 12.dp)
                    )

                    Text(
                        text = "TOOLS & APPEARANCE",
                        style = MaterialTheme.typography.labelSmall,
                        color = MaterialTheme.colorScheme.tertiary,
                        modifier = Modifier.padding(horizontal = 24.dp, vertical = 6.dp)
                    )

                    NavigationDrawerItem(
                        label = { Text(stringResource(R.string.remembrance_title)) },
                        selected = false,
                        onClick = {
                            coroutineScope.launch { drawerState.close() }
                            showCounterSheet = true
                        },
                        icon = {
                            Icon(
                                imageVector = Icons.Rounded.TouchApp,
                                contentDescription = null
                            )
                        },
                        badge = {
                            Text(
                                text = "${userProgress.counterValue}/${userProgress.counterTarget}",
                                style = MaterialTheme.typography.labelMedium,
                                color = MaterialTheme.colorScheme.primary
                            )
                        },
                        modifier = Modifier
                            .padding(horizontal = 12.dp, vertical = 2.dp)
                            .testTag("drawer_item_tasbih")
                    )

                    NavigationDrawerItem(
                        label = {
                            Text(if (userProgress.isDarkMode) "Switch to Light Mode" else "Switch to Dark Mode")
                        },
                        selected = false,
                        onClick = { viewModel.toggleDarkMode() },
                        icon = {
                            Icon(
                                imageVector = if (userProgress.isDarkMode) Icons.Rounded.LightMode else Icons.Rounded.DarkMode,
                                contentDescription = null
                            )
                        },
                        modifier = Modifier
                            .padding(horizontal = 12.dp, vertical = 2.dp)
                            .testTag("drawer_item_theme_toggle")
                    )
                }
            }
        }
    ) {
        BoxWithConstraints(modifier = Modifier.fillMaxSize()) {
            val useNavRail = maxWidth >= 600.dp

            Scaffold(
                contentWindowInsets = WindowInsets.safeDrawing,
                containerColor = MaterialTheme.colorScheme.background,
                topBar = {
                    if (showTopLevelNav) {
                        TopAppBar(
                            title = {
                                Text(
                                    text = topBarTitle,
                                    style = MaterialTheme.typography.titleLarge,
                                    color = MaterialTheme.colorScheme.primary
                                )
                            },
                            navigationIcon = {
                                IconButton(
                                    onClick = { coroutineScope.launch { drawerState.open() } },
                                    modifier = Modifier.testTag("open_drawer_button")
                                ) {
                                    Icon(
                                        imageVector = Icons.Rounded.Menu,
                                        contentDescription = stringResource(R.string.cd_open_drawer),
                                        tint = MaterialTheme.colorScheme.primary
                                    )
                                }
                            },
                            actions = {
                                IconButton(
                                    onClick = { showCounterSheet = true },
                                    modifier = Modifier.testTag("topbar_tasbih_button")
                                ) {
                                    Icon(
                                        imageVector = Icons.Rounded.TouchApp,
                                        contentDescription = stringResource(R.string.remembrance_title),
                                        tint = MaterialTheme.colorScheme.primary
                                    )
                                }
                                IconButton(
                                    onClick = viewModel::toggleDarkMode,
                                    modifier = Modifier.testTag("topbar_dark_mode_toggle")
                                ) {
                                    Icon(
                                        imageVector = if (userProgress.isDarkMode) Icons.Rounded.LightMode else Icons.Rounded.DarkMode,
                                        contentDescription = stringResource(R.string.cd_dark_mode),
                                        tint = MaterialTheme.colorScheme.primary
                                    )
                                }
                            },
                            colors = TopAppBarDefaults.topAppBarColors(
                                containerColor = MaterialTheme.colorScheme.background,
                                scrolledContainerColor = MaterialTheme.colorScheme.surface
                            )
                        )
                    }
                },
                bottomBar = {
                    if (showTopLevelNav && !useNavRail) {
                        NavigationBar(
                            containerColor = MaterialTheme.colorScheme.surface,
                            tonalElevation = 2.dp
                        ) {
                            topDestinations.forEach { dest ->
                                val selected = currentRoute == dest.route
                                NavigationBarItem(
                                    selected = selected,
                                    onClick = { navigateTopLevel(dest.route) },
                                    icon = {
                                        Icon(
                                            imageVector = if (selected) dest.selectedIcon else dest.unselectedIcon,
                                            contentDescription = stringResource(dest.labelRes)
                                        )
                                    },
                                    label = {
                                        Text(
                                            text = stringResource(dest.labelRes),
                                            maxLines = 1
                                        )
                                    },
                                    colors = NavigationBarItemDefaults.colors(
                                        selectedIconColor = MaterialTheme.colorScheme.primary,
                                        selectedTextColor = MaterialTheme.colorScheme.primary,
                                        indicatorColor = MaterialTheme.colorScheme.primaryContainer
                                    ),
                                    modifier = Modifier.testTag(dest.testTag)
                                )
                            }
                        }
                    }
                }
            ) { innerPadding ->
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding)
                ) {
                    if (showTopLevelNav && useNavRail) {
                        NavigationRail(
                            containerColor = MaterialTheme.colorScheme.surface
                        ) {
                            topDestinations.forEach { dest ->
                                val selected = currentRoute == dest.route
                                NavigationRailItem(
                                    selected = selected,
                                    onClick = { navigateTopLevel(dest.route) },
                                    icon = {
                                        Icon(
                                            imageVector = if (selected) dest.selectedIcon else dest.unselectedIcon,
                                            contentDescription = stringResource(dest.labelRes)
                                        )
                                    },
                                    label = { Text(stringResource(dest.labelRes)) },
                                    modifier = Modifier.testTag(dest.testTag)
                                )
                            }
                        }
                    }

                    Box(modifier = Modifier.weight(1f)) {
                        NavHost(
                            navController = navController,
                            startDestination = AcademyRoutes.ROUTE_HOME
                        ) {
                            composable(AcademyRoutes.ROUTE_HOME) {
                                HomeScreen(
                                    userProgress = userProgress,
                                    dailyInspiration = viewModel.dailyInspiration,
                                    onOpenSurah = ::openSurah,
                                    onNavigateQuran = { navigateTopLevel(AcademyRoutes.ROUTE_QURAN) },
                                    onNavigateHadith = { navigateTopLevel(AcademyRoutes.ROUTE_HADITH) },
                                    onNavigateDua = { navigateTopLevel(AcademyRoutes.ROUTE_DUA) },
                                    onNavigateAcademy = { navigateTopLevel(AcademyRoutes.ROUTE_ACADEMY) },
                                    onOpenCounter = { showCounterSheet = true }
                                )
                            }

                            composable(AcademyRoutes.ROUTE_QURAN) {
                                QuranListScreen(
                                    userProgress = userProgress,
                                    onSelectSurah = ::openSurah
                                )
                            }

                            composable(
                                route = AcademyRoutes.ROUTE_SURAH_DETAIL,
                                arguments = listOf(navArgument("surahNumber") { type = NavType.IntType })
                            ) { entry ->
                                val surahNumber = entry.arguments?.getInt("surahNumber") ?: 1
                                SurahDetailScreen(
                                    surahNumber = surahNumber,
                                    userProgress = userProgress,
                                    speakingId = speakingId,
                                    onBack = {
                                        viewModel.stopSpeaking()
                                        navController.popBackStack()
                                    },
                                    onToggleAyahBookmark = viewModel::toggleAyahBookmark,
                                    onToggleSurahStudied = viewModel::toggleSurahStudied,
                                    onAdjustArabicFont = viewModel::adjustArabicFontSize,
                                    onToggleTransliteration = viewModel::toggleTransliteration,
                                    onSpeakAyah = viewModel::speakText
                                )
                            }

                            composable(AcademyRoutes.ROUTE_HADITH) {
                                HadithScreen(
                                    userProgress = userProgress,
                                    speakingId = speakingId,
                                    onToggleBookmark = viewModel::toggleHadithBookmark,
                                    onSpeakHadith = viewModel::speakText
                                )
                            }

                            composable(AcademyRoutes.ROUTE_DUA) {
                                DuaScreen(
                                    userProgress = userProgress,
                                    duaSessionCounts = duaSessionCounts,
                                    speakingId = speakingId,
                                    onToggleBookmark = viewModel::toggleDuaBookmark,
                                    onIncrementRepeat = viewModel::incrementDuaRepeat,
                                    onSpeakDua = viewModel::speakText,
                                    onOpenCounter = { showCounterSheet = true }
                                )
                            }

                            composable(AcademyRoutes.ROUTE_ACADEMY) {
                                AcademyScreen(
                                    userProgress = userProgress,
                                    onToggleLessonCompleted = viewModel::toggleLessonCompleted,
                                    onRecordQuizScore = viewModel::recordQuizScore,
                                    onSpeakText = viewModel::speakText
                                )
                            }
                        }
                    }
                }
            }
        }
    }

    if (showCounterSheet) {
        RemembranceBottomSheet(
            count = userProgress.counterValue,
            target = userProgress.counterTarget,
            totalLifetimeCount = userProgress.totalRemembranceCount,
            onIncrement = viewModel::incrementCounter,
            onReset = viewModel::resetCounter,
            onSelectTarget = viewModel::setCounterTarget,
            onDismiss = { showCounterSheet = false }
        )
    }
}
