package com.campus.spendless.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val LightColorScheme = lightColorScheme(
    primary = Primary,
    primaryContainer = PrimaryContainer,
    inversePrimary = InversePrimary,
    onPrimary = OnPrimary,
    secondary = Secondary,
    secondaryContainer = SecondaryContainer,
    onSecondaryContainer = OnSecondaryContainer,
    onBackground = OnBackground,
    background = Background,
    surface = Surface,
    surfaceVariant = OnSurfaceVariant,
    onSurface = OnSurface,
    inverseSurface = InverseSurface,
    inverseOnSurface = InverseOnSurface,
    surfaceContainerLowest = SurfContainerLowest,
    surfaceContainerLow = SurfContainerLow,
    surfaceContainer = SurfContainer,
    surfaceContainerHighest = SurfContainerHighest,
    error = Error,
    onError = OnError,
    tertiaryContainer = TertiaryContainer,
    outline = Outline,
)

@Composable
fun SpendLessTheme(
    content: @Composable () -> Unit
) {
    val colorScheme = LightColorScheme
    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}