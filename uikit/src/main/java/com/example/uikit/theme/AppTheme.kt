package com.example.uikit.theme

import android.content.res.Configuration
/*
import androidx.compose.foundation.isSystemInDarkTheme
*/
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalConfiguration

object AppTheme {

    val colors: AppColors
        @Composable
        @ReadOnlyComposable
        get() = LocalColors.current

    val typography: AppTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalTypography.current

    val dimensions: AppDimensions
        @Composable
        @ReadOnlyComposable
        get() = LocalDimensions.current

    val shapes: Shapes = Shapes()
}

@Composable
fun AppTheme(
    colors: AppColors = AppTheme.colors,
    darkTheme: Boolean = false /*isSystemInDarkTheme()*/, // dark theme is not supported yet
    content: @Composable () -> Unit
) {
    val colorTheme = if (darkTheme) {
       darkColors()
    } else {
        lightColors()
    }

    val configuration = LocalConfiguration.current
    val dimensionsAndTypography: Pair<AppDimensions, AppTypography> =
        if (configuration.screenWidthDp <= 600)
            Pair(smallDimensions, smallTypography) else {
            if (configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
                Pair(sw600PortraitDimensions, sw600PortraitTypography)
            } else {
                Pair(sw600LandscapeDimensions, sw600LandscapeTypography)
            }
        }


    val rememberedColors = remember { colors.copy() }.apply { updateColorsFrom(colorTheme) }
    CompositionLocalProvider(
        LocalColors provides rememberedColors,
        LocalDimensions provides dimensionsAndTypography.first,
        LocalTypography provides dimensionsAndTypography.second
    ) {
        content()
    }
}