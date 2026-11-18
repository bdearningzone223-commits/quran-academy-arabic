package com.example.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp

private val LightColorScheme = lightColorScheme(
    primary = EmeraldDeep,
    onPrimary = SurfaceWhite,
    primaryContainer = EmeraldContainer,
    onPrimaryContainer = OnEmeraldContainer,
    secondary = SageMuted,
    onSecondary = SurfaceWhite,
    secondaryContainer = SageContainer,
    onSecondaryContainer = OnSageContainer,
    tertiary = AntiqueGold,
    onTertiary = SurfaceWhite,
    tertiaryContainer = GoldContainer,
    onTertiaryContainer = OnGoldContainer,
    background = AlabasterCanvas,
    onBackground = InkDark,
    surface = SurfaceWhite,
    onSurface = InkDark,
    surfaceVariant = SurfaceSageContainer,
    onSurfaceVariant = InkSecondary,
    surfaceContainerLowest = SurfaceWhite,
    surfaceContainerLow = SurfaceSageLow,
    surfaceContainer = SurfaceSageContainer,
    surfaceContainerHigh = SurfaceSageHigh,
    outline = OutlineSage,
    outlineVariant = OutlineVariantSage,
    error = ErrorCrimson,
    errorContainer = ErrorContainerLight
)

private val DarkColorScheme = darkColorScheme(
    primary = JadeLuminous,
    onPrimary = OnJadeDark,
    primaryContainer = DarkEmeraldContainer,
    onPrimaryContainer = OnDarkEmeraldContainer,
    secondary = DarkSage,
    onSecondary = OnJadeDark,
    secondaryContainer = DarkSageContainer,
    onSecondaryContainer = OnDarkSageContainer,
    tertiary = WarmGoldDark,
    onTertiary = OnWarmGoldDark,
    tertiaryContainer = DarkGoldContainer,
    onTertiaryContainer = OnDarkGoldContainer,
    background = DarkCanvas,
    onBackground = DarkInk,
    surface = DarkSurfaceLow,
    onSurface = DarkInk,
    surfaceVariant = DarkSurfaceContainer,
    onSurfaceVariant = DarkInkSecondary,
    surfaceContainerLowest = DarkCanvas,
    surfaceContainerLow = DarkSurfaceLow,
    surfaceContainer = DarkSurfaceContainer,
    surfaceContainerHigh = DarkSurfaceHigh,
    outline = DarkOutline,
    outlineVariant = DarkOutlineVariant,
    error = ErrorDark,
    errorContainer = ErrorContainerDark
)

val AcademyShapes = Shapes(
    extraSmall = RoundedCornerShape(8.dp),
    small = RoundedCornerShape(12.dp),
    medium = RoundedCornerShape(18.dp),
    large = RoundedCornerShape(24.dp),
    extraLarge = RoundedCornerShape(32.dp)
)

@Composable
fun QuranAcademyTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        shapes = AcademyShapes,
        content = content
    )
}

@Composable
fun MyApplicationTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    QuranAcademyTheme(darkTheme = darkTheme, content = content)
}
