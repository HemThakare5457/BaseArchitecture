package com.example.uikit.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.uikit.R

val neueHaasGroteskTextBold = FontFamily(
    Font(R.font.neue_haas_grotesk_text_pro_bold, FontWeight.Bold)
)

val neueHaasGroteskTextProMedium = FontFamily(
    Font(R.font.neue_haas_grotesk_text_pro_medium, FontWeight.Medium)
)

val neueHaasGroteskTextProRegular = FontFamily(
    Font(R.font.neue_haas_grotesk_text_pro_regular, FontWeight.Normal)
)

class AppTypography(

    private val displayLarge: TextStyle = TextStyle(
        fontFamily = neueHaasGroteskTextBold,
        fontSize = 57.sp,
        lineHeight = 64.sp
    ),

    val displayMedium: TextStyle = displayLarge.copy(
        fontFamily = neueHaasGroteskTextProMedium,
        fontSize = 45.sp,
        lineHeight = 52.sp
    ),

    val displaySmall: TextStyle = displayLarge.copy(
        fontFamily = neueHaasGroteskTextProRegular,
        fontSize = 36.sp,
        lineHeight = 44.sp
    ),

    val headlineLarge: TextStyle = displayLarge.copy(
        fontSize = 32.sp,
        lineHeight = 40.sp
    ),
    val headlineMedium: TextStyle = displayLarge.copy(
        fontFamily = neueHaasGroteskTextProMedium,
        fontSize = 28.sp,
        lineHeight = 36.sp
    ),
    val headlineSmall: TextStyle = displayLarge.copy(
        fontFamily = neueHaasGroteskTextProRegular,
        fontSize = 24.sp,
        lineHeight = 32.sp
    ),

    val titleLarge: TextStyle = displayLarge.copy(
        fontSize = 22.sp,
        lineHeight = 28.sp
    ),

    val titleMedium: TextStyle = displayLarge.copy(
        fontFamily = neueHaasGroteskTextProMedium,
        fontSize = 16.sp,
        lineHeight = 24.sp
    ),

    val titleSmall: TextStyle = displayLarge.copy(
        fontFamily = neueHaasGroteskTextProRegular,
        fontSize = 14.sp,
        lineHeight = 20.sp
    ),

    val bodyLarge: TextStyle = displayLarge.copy(
        fontSize = 16.sp,
        lineHeight = 24.sp
    ),
    val bodyMediumLarge: TextStyle = displayLarge.copy(
        fontFamily = neueHaasGroteskTextProMedium,
        fontSize = 18.sp,
        lineHeight = 24.sp
    ),
    val bodyMedium: TextStyle = displayLarge.copy(
        fontFamily = neueHaasGroteskTextProMedium,
        fontSize = 14.sp,
        lineHeight = 20.sp
    ),
    val bodySmall: TextStyle = displayLarge.copy(
        fontFamily = neueHaasGroteskTextProRegular,
        fontSize = 12.sp,
        lineHeight = 16.sp
    ),
    val bodySmallMedium: TextStyle = displayLarge.copy(
        fontFamily = neueHaasGroteskTextProRegular,
        fontSize = 13.sp,
        lineHeight = 18.sp
    ),

    val labelLarge: TextStyle = displayLarge.copy(
        fontSize = 14.sp,
        lineHeight = 20.sp
    ),
    val labelMedium: TextStyle = displayLarge.copy(
        fontFamily = neueHaasGroteskTextProMedium,
        fontSize = 12.sp,
        lineHeight = 16.sp
    ),
    val labelSmall: TextStyle = displayLarge.copy(
        fontFamily = neueHaasGroteskTextProRegular,
        fontSize = 11.sp,
        lineHeight = 16.sp
    ),
    val markdown: TextStyle = displayLarge.copy(
        fontFamily = neueHaasGroteskTextProRegular,
        fontSize = 13.sp,
        lineHeight = 16.sp
    )
)

val smallTypography = AppTypography(

)

val sw600PortraitTypography = AppTypography(

)

val sw600LandscapeTypography = AppTypography(


)

internal val LocalTypography = staticCompositionLocalOf { AppTypography() }