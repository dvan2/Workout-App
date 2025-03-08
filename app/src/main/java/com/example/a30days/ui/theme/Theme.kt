package com.example.compose
import android.os.Build
import android.util.Log
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import com.example.a30days.ui.theme.backgroundDark
import com.example.a30days.ui.theme.backgroundDarkHighContrast
import com.example.a30days.ui.theme.backgroundDarkMediumContrast
import com.example.a30days.ui.theme.backgroundLight
import com.example.a30days.ui.theme.backgroundLightHighContrast
import com.example.a30days.ui.theme.backgroundLightMediumContrast
import com.example.a30days.ui.theme.errorContainerDark
import com.example.a30days.ui.theme.errorContainerDarkHighContrast
import com.example.a30days.ui.theme.errorContainerDarkMediumContrast
import com.example.a30days.ui.theme.errorContainerLight
import com.example.a30days.ui.theme.errorContainerLightHighContrast
import com.example.a30days.ui.theme.errorContainerLightMediumContrast
import com.example.a30days.ui.theme.errorDark
import com.example.a30days.ui.theme.errorDarkHighContrast
import com.example.a30days.ui.theme.errorDarkMediumContrast
import com.example.a30days.ui.theme.errorLight
import com.example.a30days.ui.theme.errorLightHighContrast
import com.example.a30days.ui.theme.errorLightMediumContrast
import com.example.a30days.ui.theme.inverseOnSurfaceDark
import com.example.a30days.ui.theme.inverseOnSurfaceDarkHighContrast
import com.example.a30days.ui.theme.inverseOnSurfaceDarkMediumContrast
import com.example.a30days.ui.theme.inverseOnSurfaceLight
import com.example.a30days.ui.theme.inverseOnSurfaceLightHighContrast
import com.example.a30days.ui.theme.inverseOnSurfaceLightMediumContrast
import com.example.a30days.ui.theme.inversePrimaryDark
import com.example.a30days.ui.theme.inversePrimaryDarkHighContrast
import com.example.a30days.ui.theme.inversePrimaryDarkMediumContrast
import com.example.a30days.ui.theme.inversePrimaryLight
import com.example.a30days.ui.theme.inversePrimaryLightHighContrast
import com.example.a30days.ui.theme.inversePrimaryLightMediumContrast
import com.example.a30days.ui.theme.inverseSurfaceDark
import com.example.a30days.ui.theme.inverseSurfaceDarkHighContrast
import com.example.a30days.ui.theme.inverseSurfaceDarkMediumContrast
import com.example.a30days.ui.theme.inverseSurfaceLight
import com.example.a30days.ui.theme.inverseSurfaceLightHighContrast
import com.example.a30days.ui.theme.inverseSurfaceLightMediumContrast
import com.example.a30days.ui.theme.onBackgroundDark
import com.example.a30days.ui.theme.onBackgroundDarkHighContrast
import com.example.a30days.ui.theme.onBackgroundDarkMediumContrast
import com.example.a30days.ui.theme.onBackgroundLight
import com.example.a30days.ui.theme.onBackgroundLightHighContrast
import com.example.a30days.ui.theme.onBackgroundLightMediumContrast
import com.example.a30days.ui.theme.onErrorContainerDark
import com.example.a30days.ui.theme.onErrorContainerDarkHighContrast
import com.example.a30days.ui.theme.onErrorContainerDarkMediumContrast
import com.example.a30days.ui.theme.onErrorContainerLight
import com.example.a30days.ui.theme.onErrorContainerLightHighContrast
import com.example.a30days.ui.theme.onErrorContainerLightMediumContrast
import com.example.a30days.ui.theme.onErrorDark
import com.example.a30days.ui.theme.onErrorDarkHighContrast
import com.example.a30days.ui.theme.onErrorDarkMediumContrast
import com.example.a30days.ui.theme.onErrorLight
import com.example.a30days.ui.theme.onErrorLightHighContrast
import com.example.a30days.ui.theme.onErrorLightMediumContrast
import com.example.a30days.ui.theme.onPrimaryContainerDark
import com.example.a30days.ui.theme.onPrimaryContainerDarkHighContrast
import com.example.a30days.ui.theme.onPrimaryContainerDarkMediumContrast
import com.example.a30days.ui.theme.onPrimaryContainerLight
import com.example.a30days.ui.theme.onPrimaryContainerLightHighContrast
import com.example.a30days.ui.theme.onPrimaryContainerLightMediumContrast
import com.example.a30days.ui.theme.onPrimaryDark
import com.example.a30days.ui.theme.onPrimaryDarkHighContrast
import com.example.a30days.ui.theme.onPrimaryDarkMediumContrast
import com.example.a30days.ui.theme.onPrimaryLight
import com.example.a30days.ui.theme.onPrimaryLightHighContrast
import com.example.a30days.ui.theme.onPrimaryLightMediumContrast
import com.example.a30days.ui.theme.onSecondaryContainerDark
import com.example.a30days.ui.theme.onSecondaryContainerDarkHighContrast
import com.example.a30days.ui.theme.onSecondaryContainerDarkMediumContrast
import com.example.a30days.ui.theme.onSecondaryContainerLight
import com.example.a30days.ui.theme.onSecondaryContainerLightHighContrast
import com.example.a30days.ui.theme.onSecondaryContainerLightMediumContrast
import com.example.a30days.ui.theme.onSecondaryDark
import com.example.a30days.ui.theme.onSecondaryDarkHighContrast
import com.example.a30days.ui.theme.onSecondaryDarkMediumContrast
import com.example.a30days.ui.theme.onSecondaryLight
import com.example.a30days.ui.theme.onSecondaryLightHighContrast
import com.example.a30days.ui.theme.onSecondaryLightMediumContrast
import com.example.a30days.ui.theme.onSurfaceDark
import com.example.a30days.ui.theme.onSurfaceDarkHighContrast
import com.example.a30days.ui.theme.onSurfaceDarkMediumContrast
import com.example.a30days.ui.theme.onSurfaceLight
import com.example.a30days.ui.theme.onSurfaceLightHighContrast
import com.example.a30days.ui.theme.onSurfaceLightMediumContrast
import com.example.a30days.ui.theme.onSurfaceVariantDark
import com.example.a30days.ui.theme.onSurfaceVariantDarkHighContrast
import com.example.a30days.ui.theme.onSurfaceVariantDarkMediumContrast
import com.example.a30days.ui.theme.onSurfaceVariantLight
import com.example.a30days.ui.theme.onSurfaceVariantLightHighContrast
import com.example.a30days.ui.theme.onSurfaceVariantLightMediumContrast
import com.example.a30days.ui.theme.onTertiaryContainerDark
import com.example.a30days.ui.theme.onTertiaryContainerDarkHighContrast
import com.example.a30days.ui.theme.onTertiaryContainerDarkMediumContrast
import com.example.a30days.ui.theme.onTertiaryContainerLight
import com.example.a30days.ui.theme.onTertiaryContainerLightHighContrast
import com.example.a30days.ui.theme.onTertiaryContainerLightMediumContrast
import com.example.a30days.ui.theme.onTertiaryDark
import com.example.a30days.ui.theme.onTertiaryDarkHighContrast
import com.example.a30days.ui.theme.onTertiaryDarkMediumContrast
import com.example.a30days.ui.theme.onTertiaryLight
import com.example.a30days.ui.theme.onTertiaryLightHighContrast
import com.example.a30days.ui.theme.onTertiaryLightMediumContrast
import com.example.a30days.ui.theme.outlineDark
import com.example.a30days.ui.theme.outlineDarkHighContrast
import com.example.a30days.ui.theme.outlineDarkMediumContrast
import com.example.a30days.ui.theme.outlineLight
import com.example.a30days.ui.theme.outlineLightHighContrast
import com.example.a30days.ui.theme.outlineLightMediumContrast
import com.example.a30days.ui.theme.outlineVariantDark
import com.example.a30days.ui.theme.outlineVariantDarkHighContrast
import com.example.a30days.ui.theme.outlineVariantDarkMediumContrast
import com.example.a30days.ui.theme.outlineVariantLight
import com.example.a30days.ui.theme.outlineVariantLightHighContrast
import com.example.a30days.ui.theme.outlineVariantLightMediumContrast
import com.example.a30days.ui.theme.primaryContainerDark
import com.example.a30days.ui.theme.primaryContainerDarkHighContrast
import com.example.a30days.ui.theme.primaryContainerDarkMediumContrast
import com.example.a30days.ui.theme.primaryContainerLight
import com.example.a30days.ui.theme.primaryContainerLightHighContrast
import com.example.a30days.ui.theme.primaryContainerLightMediumContrast
import com.example.a30days.ui.theme.primaryDark
import com.example.a30days.ui.theme.primaryDarkHighContrast
import com.example.a30days.ui.theme.primaryDarkMediumContrast
import com.example.a30days.ui.theme.primaryLight
import com.example.a30days.ui.theme.primaryLightHighContrast
import com.example.a30days.ui.theme.primaryLightMediumContrast
import com.example.a30days.ui.theme.scrimDark
import com.example.a30days.ui.theme.scrimDarkHighContrast
import com.example.a30days.ui.theme.scrimDarkMediumContrast
import com.example.a30days.ui.theme.scrimLight
import com.example.a30days.ui.theme.scrimLightHighContrast
import com.example.a30days.ui.theme.scrimLightMediumContrast
import com.example.a30days.ui.theme.secondaryContainerDark
import com.example.a30days.ui.theme.secondaryContainerDarkHighContrast
import com.example.a30days.ui.theme.secondaryContainerDarkMediumContrast
import com.example.a30days.ui.theme.secondaryContainerLight
import com.example.a30days.ui.theme.secondaryContainerLightHighContrast
import com.example.a30days.ui.theme.secondaryContainerLightMediumContrast
import com.example.a30days.ui.theme.secondaryDark
import com.example.a30days.ui.theme.secondaryDarkHighContrast
import com.example.a30days.ui.theme.secondaryDarkMediumContrast
import com.example.a30days.ui.theme.secondaryLight
import com.example.a30days.ui.theme.secondaryLightHighContrast
import com.example.a30days.ui.theme.secondaryLightMediumContrast
import com.example.a30days.ui.theme.surfaceBrightDark
import com.example.a30days.ui.theme.surfaceBrightDarkHighContrast
import com.example.a30days.ui.theme.surfaceBrightDarkMediumContrast
import com.example.a30days.ui.theme.surfaceBrightLight
import com.example.a30days.ui.theme.surfaceBrightLightHighContrast
import com.example.a30days.ui.theme.surfaceBrightLightMediumContrast
import com.example.a30days.ui.theme.surfaceContainerDark
import com.example.a30days.ui.theme.surfaceContainerDarkHighContrast
import com.example.a30days.ui.theme.surfaceContainerDarkMediumContrast
import com.example.a30days.ui.theme.surfaceContainerHighDark
import com.example.a30days.ui.theme.surfaceContainerHighDarkHighContrast
import com.example.a30days.ui.theme.surfaceContainerHighDarkMediumContrast
import com.example.a30days.ui.theme.surfaceContainerHighLight
import com.example.a30days.ui.theme.surfaceContainerHighLightHighContrast
import com.example.a30days.ui.theme.surfaceContainerHighLightMediumContrast
import com.example.a30days.ui.theme.surfaceContainerHighestDark
import com.example.a30days.ui.theme.surfaceContainerHighestDarkHighContrast
import com.example.a30days.ui.theme.surfaceContainerHighestDarkMediumContrast
import com.example.a30days.ui.theme.surfaceContainerHighestLight
import com.example.a30days.ui.theme.surfaceContainerHighestLightHighContrast
import com.example.a30days.ui.theme.surfaceContainerHighestLightMediumContrast
import com.example.a30days.ui.theme.surfaceContainerLight
import com.example.a30days.ui.theme.surfaceContainerLightHighContrast
import com.example.a30days.ui.theme.surfaceContainerLightMediumContrast
import com.example.a30days.ui.theme.surfaceContainerLowDark
import com.example.a30days.ui.theme.surfaceContainerLowDarkHighContrast
import com.example.a30days.ui.theme.surfaceContainerLowDarkMediumContrast
import com.example.a30days.ui.theme.surfaceContainerLowLight
import com.example.a30days.ui.theme.surfaceContainerLowLightHighContrast
import com.example.a30days.ui.theme.surfaceContainerLowLightMediumContrast
import com.example.a30days.ui.theme.surfaceContainerLowestDark
import com.example.a30days.ui.theme.surfaceContainerLowestDarkHighContrast
import com.example.a30days.ui.theme.surfaceContainerLowestDarkMediumContrast
import com.example.a30days.ui.theme.surfaceContainerLowestLight
import com.example.a30days.ui.theme.surfaceContainerLowestLightHighContrast
import com.example.a30days.ui.theme.surfaceContainerLowestLightMediumContrast
import com.example.a30days.ui.theme.surfaceDark
import com.example.a30days.ui.theme.surfaceDarkHighContrast
import com.example.a30days.ui.theme.surfaceDarkMediumContrast
import com.example.a30days.ui.theme.surfaceDimDark
import com.example.a30days.ui.theme.surfaceDimDarkHighContrast
import com.example.a30days.ui.theme.surfaceDimDarkMediumContrast
import com.example.a30days.ui.theme.surfaceDimLight
import com.example.a30days.ui.theme.surfaceDimLightHighContrast
import com.example.a30days.ui.theme.surfaceDimLightMediumContrast
import com.example.a30days.ui.theme.surfaceLight
import com.example.a30days.ui.theme.surfaceLightHighContrast
import com.example.a30days.ui.theme.surfaceLightMediumContrast
import com.example.a30days.ui.theme.surfaceVariantDark
import com.example.a30days.ui.theme.surfaceVariantDarkHighContrast
import com.example.a30days.ui.theme.surfaceVariantDarkMediumContrast
import com.example.a30days.ui.theme.surfaceVariantLight
import com.example.a30days.ui.theme.surfaceVariantLightHighContrast
import com.example.a30days.ui.theme.surfaceVariantLightMediumContrast
import com.example.a30days.ui.theme.tertiaryContainerDark
import com.example.a30days.ui.theme.tertiaryContainerDarkHighContrast
import com.example.a30days.ui.theme.tertiaryContainerDarkMediumContrast
import com.example.a30days.ui.theme.tertiaryContainerLight
import com.example.a30days.ui.theme.tertiaryContainerLightHighContrast
import com.example.a30days.ui.theme.tertiaryContainerLightMediumContrast
import com.example.a30days.ui.theme.tertiaryDark
import com.example.a30days.ui.theme.tertiaryDarkHighContrast
import com.example.a30days.ui.theme.tertiaryDarkMediumContrast
import com.example.a30days.ui.theme.tertiaryLight
import com.example.a30days.ui.theme.tertiaryLightHighContrast
import com.example.a30days.ui.theme.tertiaryLightMediumContrast
import com.example.ui.theme.AppTypography

private val lightScheme = lightColorScheme(
    primary = primaryLight,
    onPrimary = onPrimaryLight,
    primaryContainer = primaryContainerLight,
    onPrimaryContainer = onPrimaryContainerLight,
    secondary = secondaryLight,
    onSecondary = onSecondaryLight,
    secondaryContainer = secondaryContainerLight,
    onSecondaryContainer = onSecondaryContainerLight,
    tertiary = tertiaryLight,
    onTertiary = onTertiaryLight,
    tertiaryContainer = tertiaryContainerLight,
    onTertiaryContainer = onTertiaryContainerLight,
    error = errorLight,
    onError = onErrorLight,
    errorContainer = errorContainerLight,
    onErrorContainer = onErrorContainerLight,
    background = backgroundLight,
    onBackground = onBackgroundLight,
    surface = surfaceLight,
    onSurface = onSurfaceLight,
    surfaceVariant = surfaceVariantLight,
    onSurfaceVariant = onSurfaceVariantLight,
    outline = outlineLight,
    outlineVariant = outlineVariantLight,
    scrim = scrimLight,
    inverseSurface = inverseSurfaceLight,
    inverseOnSurface = inverseOnSurfaceLight,
    inversePrimary = inversePrimaryLight,
    surfaceDim = surfaceDimLight,
    surfaceBright = surfaceBrightLight,
    surfaceContainerLowest = surfaceContainerLowestLight,
    surfaceContainerLow = surfaceContainerLowLight,
    surfaceContainer = surfaceContainerLight,
    surfaceContainerHigh = surfaceContainerHighLight,
    surfaceContainerHighest = surfaceContainerHighestLight,
)

private val darkScheme = darkColorScheme(
    primary = primaryDark,
    onPrimary = onPrimaryDark,
    primaryContainer = primaryContainerDark,
    onPrimaryContainer = onPrimaryContainerDark,
    secondary = secondaryDark,
    onSecondary = onSecondaryDark,
    secondaryContainer = secondaryContainerDark,
    onSecondaryContainer = onSecondaryContainerDark,
    tertiary = tertiaryDark,
    onTertiary = onTertiaryDark,
    tertiaryContainer = tertiaryContainerDark,
    onTertiaryContainer = onTertiaryContainerDark,
    error = errorDark,
    onError = onErrorDark,
    errorContainer = errorContainerDark,
    onErrorContainer = onErrorContainerDark,
    background = backgroundDark,
    onBackground = onBackgroundDark,
    surface = surfaceDark,
    onSurface = onSurfaceDark,
    surfaceVariant = surfaceVariantDark,
    onSurfaceVariant = onSurfaceVariantDark,
    outline = outlineDark,
    outlineVariant = outlineVariantDark,
    scrim = scrimDark,
    inverseSurface = inverseSurfaceDark,
    inverseOnSurface = inverseOnSurfaceDark,
    inversePrimary = inversePrimaryDark,
    surfaceDim = surfaceDimDark,
    surfaceBright = surfaceBrightDark,
    surfaceContainerLowest = surfaceContainerLowestDark,
    surfaceContainerLow = surfaceContainerLowDark,
    surfaceContainer = surfaceContainerDark,
    surfaceContainerHigh = surfaceContainerHighDark,
    surfaceContainerHighest = surfaceContainerHighestDark,
)

private val mediumContrastLightColorScheme = lightColorScheme(
    primary = primaryLightMediumContrast,
    onPrimary = onPrimaryLightMediumContrast,
    primaryContainer = primaryContainerLightMediumContrast,
    onPrimaryContainer = onPrimaryContainerLightMediumContrast,
    secondary = secondaryLightMediumContrast,
    onSecondary = onSecondaryLightMediumContrast,
    secondaryContainer = secondaryContainerLightMediumContrast,
    onSecondaryContainer = onSecondaryContainerLightMediumContrast,
    tertiary = tertiaryLightMediumContrast,
    onTertiary = onTertiaryLightMediumContrast,
    tertiaryContainer = tertiaryContainerLightMediumContrast,
    onTertiaryContainer = onTertiaryContainerLightMediumContrast,
    error = errorLightMediumContrast,
    onError = onErrorLightMediumContrast,
    errorContainer = errorContainerLightMediumContrast,
    onErrorContainer = onErrorContainerLightMediumContrast,
    background = backgroundLightMediumContrast,
    onBackground = onBackgroundLightMediumContrast,
    surface = surfaceLightMediumContrast,
    onSurface = onSurfaceLightMediumContrast,
    surfaceVariant = surfaceVariantLightMediumContrast,
    onSurfaceVariant = onSurfaceVariantLightMediumContrast,
    outline = outlineLightMediumContrast,
    outlineVariant = outlineVariantLightMediumContrast,
    scrim = scrimLightMediumContrast,
    inverseSurface = inverseSurfaceLightMediumContrast,
    inverseOnSurface = inverseOnSurfaceLightMediumContrast,
    inversePrimary = inversePrimaryLightMediumContrast,
    surfaceDim = surfaceDimLightMediumContrast,
    surfaceBright = surfaceBrightLightMediumContrast,
    surfaceContainerLowest = surfaceContainerLowestLightMediumContrast,
    surfaceContainerLow = surfaceContainerLowLightMediumContrast,
    surfaceContainer = surfaceContainerLightMediumContrast,
    surfaceContainerHigh = surfaceContainerHighLightMediumContrast,
    surfaceContainerHighest = surfaceContainerHighestLightMediumContrast,
)

private val highContrastLightColorScheme = lightColorScheme(
    primary = primaryLightHighContrast,
    onPrimary = onPrimaryLightHighContrast,
    primaryContainer = primaryContainerLightHighContrast,
    onPrimaryContainer = onPrimaryContainerLightHighContrast,
    secondary = secondaryLightHighContrast,
    onSecondary = onSecondaryLightHighContrast,
    secondaryContainer = secondaryContainerLightHighContrast,
    onSecondaryContainer = onSecondaryContainerLightHighContrast,
    tertiary = tertiaryLightHighContrast,
    onTertiary = onTertiaryLightHighContrast,
    tertiaryContainer = tertiaryContainerLightHighContrast,
    onTertiaryContainer = onTertiaryContainerLightHighContrast,
    error = errorLightHighContrast,
    onError = onErrorLightHighContrast,
    errorContainer = errorContainerLightHighContrast,
    onErrorContainer = onErrorContainerLightHighContrast,
    background = backgroundLightHighContrast,
    onBackground = onBackgroundLightHighContrast,
    surface = surfaceLightHighContrast,
    onSurface = onSurfaceLightHighContrast,
    surfaceVariant = surfaceVariantLightHighContrast,
    onSurfaceVariant = onSurfaceVariantLightHighContrast,
    outline = outlineLightHighContrast,
    outlineVariant = outlineVariantLightHighContrast,
    scrim = scrimLightHighContrast,
    inverseSurface = inverseSurfaceLightHighContrast,
    inverseOnSurface = inverseOnSurfaceLightHighContrast,
    inversePrimary = inversePrimaryLightHighContrast,
    surfaceDim = surfaceDimLightHighContrast,
    surfaceBright = surfaceBrightLightHighContrast,
    surfaceContainerLowest = surfaceContainerLowestLightHighContrast,
    surfaceContainerLow = surfaceContainerLowLightHighContrast,
    surfaceContainer = surfaceContainerLightHighContrast,
    surfaceContainerHigh = surfaceContainerHighLightHighContrast,
    surfaceContainerHighest = surfaceContainerHighestLightHighContrast,
)

private val mediumContrastDarkColorScheme = darkColorScheme(
    primary = primaryDarkMediumContrast,
    onPrimary = onPrimaryDarkMediumContrast,
    primaryContainer = primaryContainerDarkMediumContrast,
    onPrimaryContainer = onPrimaryContainerDarkMediumContrast,
    secondary = secondaryDarkMediumContrast,
    onSecondary = onSecondaryDarkMediumContrast,
    secondaryContainer = secondaryContainerDarkMediumContrast,
    onSecondaryContainer = onSecondaryContainerDarkMediumContrast,
    tertiary = tertiaryDarkMediumContrast,
    onTertiary = onTertiaryDarkMediumContrast,
    tertiaryContainer = tertiaryContainerDarkMediumContrast,
    onTertiaryContainer = onTertiaryContainerDarkMediumContrast,
    error = errorDarkMediumContrast,
    onError = onErrorDarkMediumContrast,
    errorContainer = errorContainerDarkMediumContrast,
    onErrorContainer = onErrorContainerDarkMediumContrast,
    background = backgroundDarkMediumContrast,
    onBackground = onBackgroundDarkMediumContrast,
    surface = surfaceDarkMediumContrast,
    onSurface = onSurfaceDarkMediumContrast,
    surfaceVariant = surfaceVariantDarkMediumContrast,
    onSurfaceVariant = onSurfaceVariantDarkMediumContrast,
    outline = outlineDarkMediumContrast,
    outlineVariant = outlineVariantDarkMediumContrast,
    scrim = scrimDarkMediumContrast,
    inverseSurface = inverseSurfaceDarkMediumContrast,
    inverseOnSurface = inverseOnSurfaceDarkMediumContrast,
    inversePrimary = inversePrimaryDarkMediumContrast,
    surfaceDim = surfaceDimDarkMediumContrast,
    surfaceBright = surfaceBrightDarkMediumContrast,
    surfaceContainerLowest = surfaceContainerLowestDarkMediumContrast,
    surfaceContainerLow = surfaceContainerLowDarkMediumContrast,
    surfaceContainer = surfaceContainerDarkMediumContrast,
    surfaceContainerHigh = surfaceContainerHighDarkMediumContrast,
    surfaceContainerHighest = surfaceContainerHighestDarkMediumContrast,
)

private val highContrastDarkColorScheme = darkColorScheme(
    primary = primaryDarkHighContrast,
    onPrimary = onPrimaryDarkHighContrast,
    primaryContainer = primaryContainerDarkHighContrast,
    onPrimaryContainer = onPrimaryContainerDarkHighContrast,
    secondary = secondaryDarkHighContrast,
    onSecondary = onSecondaryDarkHighContrast,
    secondaryContainer = secondaryContainerDarkHighContrast,
    onSecondaryContainer = onSecondaryContainerDarkHighContrast,
    tertiary = tertiaryDarkHighContrast,
    onTertiary = onTertiaryDarkHighContrast,
    tertiaryContainer = tertiaryContainerDarkHighContrast,
    onTertiaryContainer = onTertiaryContainerDarkHighContrast,
    error = errorDarkHighContrast,
    onError = onErrorDarkHighContrast,
    errorContainer = errorContainerDarkHighContrast,
    onErrorContainer = onErrorContainerDarkHighContrast,
    background = backgroundDarkHighContrast,
    onBackground = onBackgroundDarkHighContrast,
    surface = surfaceDarkHighContrast,
    onSurface = onSurfaceDarkHighContrast,
    surfaceVariant = surfaceVariantDarkHighContrast,
    onSurfaceVariant = onSurfaceVariantDarkHighContrast,
    outline = outlineDarkHighContrast,
    outlineVariant = outlineVariantDarkHighContrast,
    scrim = scrimDarkHighContrast,
    inverseSurface = inverseSurfaceDarkHighContrast,
    inverseOnSurface = inverseOnSurfaceDarkHighContrast,
    inversePrimary = inversePrimaryDarkHighContrast,
    surfaceDim = surfaceDimDarkHighContrast,
    surfaceBright = surfaceBrightDarkHighContrast,
    surfaceContainerLowest = surfaceContainerLowestDarkHighContrast,
    surfaceContainerLow = surfaceContainerLowDarkHighContrast,
    surfaceContainer = surfaceContainerDarkHighContrast,
    surfaceContainerHigh = surfaceContainerHighDarkHighContrast,
    surfaceContainerHighest = surfaceContainerHighestDarkHighContrast,
)

@Immutable
data class ColorFamily(
    val color: Color,
    val onColor: Color,
    val colorContainer: Color,
    val onColorContainer: Color
)

val unspecified_scheme = ColorFamily(
    Color.Unspecified, Color.Unspecified, Color.Unspecified, Color.Unspecified
)

@Composable
fun _30DaysTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable() () -> Unit
) {
  val colorScheme = if (darkTheme) darkScheme else lightScheme

  MaterialTheme(
    colorScheme = colorScheme,
    typography = AppTypography,
    content = content
  )
}

