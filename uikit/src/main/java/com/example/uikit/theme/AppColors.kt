package com.example.uikit.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

class AppColors(
    primary: Color,
    secondary: Color,
    background: Color,
    surface: Color,
    onPrimary: Color,
    onSecondary: Color,
    onBackground: Color,
    error: Color,
    onPrimaryBlue: Color,
    onPrimaryGray: Color,
    isLight: Boolean ,
    onSecondaryGray: Color,
    onPrimaryGreen: Color,
    onPrimaryRed: Color,
    onSecondaryGreen: Color,
    onSecondaryGrey: Color,
    onPrimaryDarkGrey: Color,
    onPrimaryDarkRed: Color
) {
    var primary by mutableStateOf(primary)
        private set
    var secondary by mutableStateOf(secondary)
        private set
    var background by mutableStateOf(background)
        private set
    var surface by mutableStateOf(surface)
        private set
    var onPrimary by mutableStateOf(onPrimary)
        private set
    var onSecondary by mutableStateOf(onSecondary)
        private set
    private var onBackground by mutableStateOf(onBackground)
    var error by mutableStateOf(error)
        private set
    var onPrimaryBlue by mutableStateOf(onPrimaryBlue)
        private set
    var onPrimaryGray by mutableStateOf(onPrimaryGray)
        private set
    var isLight by mutableStateOf(isLight)
        internal set
    var onSecondaryGray by mutableStateOf(onSecondaryGray)
        private set
    var onPrimaryGreen by mutableStateOf(onPrimaryGreen)
        private set
    var onPrimaryRed by mutableStateOf(onPrimaryRed)
        private set
    var onSecondaryGreen by mutableStateOf(onSecondaryGreen)
        private set
    var onSecondaryGrey by mutableStateOf(onSecondaryGrey)
        private set
    var onPrimaryDarkGrey by mutableStateOf(onPrimaryDarkGrey)
        private set
    var onPrimaryDarkRed by mutableStateOf(onPrimaryDarkRed)
        private set

    fun copy(): AppColors = AppColors(
        this.primary,
        this.secondary,
        this.background,
        this.surface,
        this.onPrimary,
        this.onSecondary,
        this.background,
        this.error,
        this.onPrimaryBlue,
        this.onPrimaryGray,
        this.isLight,
        this.onSecondaryGray,
        this.onPrimaryGreen,
        this.onPrimaryRed,
        this.onSecondaryGreen,
        this.onSecondaryGrey,
        this.onPrimaryDarkGrey,
        this.onPrimaryDarkRed
    )

    fun updateColorsFrom(other: AppColors) {
        primary = other.primary
        secondary = other.secondary
        background = other.background
        surface = other.surface
        onPrimary = other.onPrimary
        onSecondary = other.onSecondary
        onBackground = other.onBackground
        error = other.error
        onPrimaryBlue = other.onPrimaryBlue
        onPrimaryGray = other.onPrimaryGray
        isLight = other.isLight
        onSecondaryGray = other.onSecondaryGray
        onPrimaryGreen = other.onPrimaryGreen
        onPrimaryRed = other.onPrimaryRed
        onSecondaryGreen = other.onSecondaryGreen
        onSecondaryGrey = other.onSecondaryGrey
        onPrimaryDarkGrey = other.onPrimaryDarkGrey
        onPrimaryDarkRed = other.onPrimaryDarkRed
    }
}

private val colorLightPrimary = Color(0xFF000000)
private val colorLightSecondary = Color(0xFF000000)
private val colorLightBackground = Color(0xFFFFFFFF)
private val colorLightSurface = Color(0xFFFFFFFF)
private val colorLightOnPrimary = Color(0xFF464646)
private val colorLightOnSecondary = Color(0xFF748194)
private val colorLightOnBackground = Color(0xFFFFFFFF)
private val colorLightError = Color(0xFFD62222)
private val colorLightPrimaryBlue = Color(0xFF3678B7)
private val colorLightToPrimaryGray = Color(0xFFB1B1B1)
private val colorLightVictraBackground = Color(0xFFF0F0F0)
private val colorLightVictraDarkGreyBackground = Color(0xFF6D758D)
private val greyBackgroundDark = Color(0xFFE6E6E6)
private val greyDarkBackgroundDark = Color(0xFFB1B1B1)
private val selectBackGroundDark = Color(0xFFEBF2F8)
private val progressColorDark = Color(0xFF3678B7)
private val colorLightVictraDarkGreenBackground = Color(0xFF43A047)
private val colorLightVictraDarkRedBackground = Color(0xFFD32F2F)
private val colorLightSecondaryGreen = Color(0xFF2EA662)
private val colorLightSecondaryGrey = Color(0xFFD5D5D5)
private val onPrimaryLightGrey = Color(0xFF6D758D)
private val onPrimaryLightRed = Color(0xFFD32F2F)
private val colorLightStoreHoursText = Color(0xBFFFFFFF)
private val colorLightStoreHoursBreakBg = Color(0xFFD8534F)
private val colorLightContestStatus = Color(0xFF00D27B)
private val colorLightBreakSchedule = Color(0xFF4B5055)
private val textButtonDisableLightGrey = Color(0xFFA5A9AD)
private val colorLightDiscountCouponError = Color(0xFFEA1616)
private val colorLightContributionItemTextGrey = Color(0xFF495057)
private val colorLightContributionItemBackgroundBlue = Color(0xFFDAEAFD)
private val colorLightIconContributionDetails = Color(0xFF64696E)
private val timeCardBottomScheduleBg = Color(0xFFF0F1F4)
private val colorLightGreenTotalWorked = Color(0xFF2E7D32)
private val colorLightBlueWorkedDate = Color(0xFF2B6092)
private val colorLightBorderScheduleTodayExpand = Color(0xFF9BBCDB)
private val lightGreenLightBg = Color(0xFFE8F5E9)
private val colorLightProgressBackground = Color(0xFFA4A1A1)
private val colorLightProgressActive = Color(0xFF756E6E)
private val colorLightSCSelDate = Color(0xFF575E71)
private val colorLightSCSelDateBG = Color(0xFFEDEDED)
private val colorLightSCSummaryBorder = Color(0xFFD6D6D6)
private val colorLightViewMoreMetricsBG = Color(0xFFDFE0E3)
private val colorLightRankCompareMetrics = Color(0xFF6C6C6C)
private val alertLightColor = Color(0xFFFFF9E6)
private val alertTextLightColor = Color(0xFF806104)
private val alertHighLighterLightColor = Color(0xFFFFC107)
private val colorLightGreyColor = Color(0xFF848586)
private val faintGreyLightColor = Color(0xFFE8E6E6)
private val colorLightNewsBackBG= Color(0xFF4F4D51)
private val colorLightRedExCardBorder= Color(0xFFB6BAC6)
private val colorLightRedExCardBG= Color(0xFFFFFEFE)
private val colorFaintGreyLTColor = Color(0xFFF7F7F7)
private val colorSilverGreyLTColor = Color(0xFF94969A)
private val colorBlueLTColor = Color(0xFF1E81BF)
private val colorDarkSilverGreyLTColor = Color(0xFFBFC2CD)
private val colorLightChatSend = Color(0xFF2B6092)
private val colorLightChatBackground = Color(0xFFF0F1F4)
private val colorLightChatBotHint = Color(0xFFB6BAC6)
private val colorLightChatBotLoaderScaleUp = Color(0xFFA7A7A7)
private val whiteWith30Alpha = Color(0x4DFFFFFF)
private val grey1Light = Color(0xFFECEAEA)
private val colorLightTaskDueToday = Color(0xFFFED553)
private val colorLightTaskPastDue = Color(0xFFFB1C1C)
private val colorLightBlue1 = Color(0xFFE1F5FE)
private val colorLightBlue2 = Color(0xff01579B)

private val grey2Light = Color(0xFFFAFAFA)
private val grey3Light = Color(0xFFD9D9D9)
private val grey4Light = Color(0xFF979797)
private val grey5Light = Color(0xFF515050)

private val metallicBrownLight = Color(0xFFA74B1F)
private val veryPaleYellowLight = Color(0xFFFEF9C2)
private val aeroBlueLight = Color(0xFFDBFCE7)
private val pineGreenLight = Color(0xFF017B71)
private val lavenderBlushLight = Color(0xFFFEF2F2)
private val blackOliveLight = Color(0xFF3C3C3D)
private val colorLightMediumRed = Color(0xFFC7414D)
private val colorLightIconGray = Color(0xFF52565A)
private val colorLightMediumBlack = Color(0xFF131314)

private val colorDarkPrimary = Color(0xFF000000)
private val colorDarkSecondary = Color(0xFF000000)
private val colorDarkBackground = Color(0xFFFFFFFF)
private val colorDarkSurface = Color(0xFFFFFFFF)
private val colorDarkOnPrimary = Color(0xFF464646)
private val colorDarkOnSecondary = Color(0xFF748194)
private val colorDarkOnBackground = Color(0xFFFFFFFF)
private val colorDarkError = Color(0xFFD62222)
private val colorDarkPrimaryBlue = Color(0xFF2A7BE4)
private val colorDarkPrimaryGray = Color(0xFFB1B1B1)
private val colorDarkVictraBackground = Color(0xFFF0F0F0)
private val colorDarkVictraDarkGreyBackground = Color(0xFF6D758D)
private val greyBackgroundLight = Color(0xFFE6E6E6)
private val greyBackgroundLight2 = Color(0xFFF5F5F5)
private val greyDarkBackgroundLight = Color(0xFFB1B1B1)
private val selectBackGroundLight = Color(0xFFEBF2F8)
private val progressColorLight = Color(0xFF3678B7)
private val colorDarkVictraDarkGreenBackground = Color(0xFF43A047)
private val colorDarkVictraDarkRedBackground = Color(0xFFD32F2F)
private val colorDarkSecondaryGreen = Color(0xFF2EA662)
private val colorDarkSecondaryGrey = Color(0xFFD5D5D5)
private val onPrimaryDarkGrey = Color(0xFF6D758D)
private val onPrimaryDarkRed = Color(0xFFD32F2F)
private val colorDarkStoreHoursText = Color(0xBFFFFFFF)
private val colorDarkStoreHoursBreakBg = Color(0xFFD8534F)
private val colorDarkContestStatus = Color(0xFF00D27B)
private val colorDarkBreakSchedule = Color(0xFF4B5055)
private val textButtonDisableDarkGrey = Color(0xFFA5A9AD)
private val colorDarkDiscountCouponError = Color(0xFFEA1616)
private val colorDarkContributionItemTextGrey = Color(0xFF495057)
private val colorDarkContributionItemBackgroundBlue = Color(0xFFDAEAFD)
private val colorDarkIconContributionDetails = Color(0xFF64696E)
private val timeCardBottomScheduleBgDark = Color(0xFFF0F1F4)
private val colorDarkGreenTotalWorked = Color(0xFF2E7D32)
private val colorDarkBlueWorkedDate = Color(0xFF2B6092)
private val colorDarkBorderScheduleTodayExpand = Color(0xFF9BBCDB)
private val lightGreenDarkBg = Color(0xFFE8F5E9)
private val colorDarkProgressBackground = Color(0xFFA4A1A1)
private val colorDarkProgressActive = Color(0xFF756E6E)
private val colorDarkSCSelDate = Color(0xFF575E71)
private val colorDarkSCSelDateBG = Color(0xFFEDEDED)
private val colorDarkSCSummaryBorder = Color(0xFFD6D6D6)
private val colorDarkViewMoreMetricsBG = Color(0xFFDFE0E3)
private val colorDarkRankCompareMetrics= Color(0xFF6C6C6C)
private val alertDarkColor = Color(0xFFFFF9E6)
private val alertTextDarkColor = Color(0xFF806104)
private val alertHighLighterDarkColor = Color(0xFFFFC107)
private val colorDarkGreyColor = Color(0xFF848586)
private val faintGreyDarkColor = Color(0xFFE8E6E6)
private val colorDarkNewsBackBG= Color(0xFF4F4D51)
private val colorDarkRedExCardBorder= Color(0xFFB6BAC6)
private val colorDarkRedExCardBG= Color(0xFFFFFEFE)
private val colorFaintGreyDTColor = Color(0xFFF7F7F7)
private val colorSilverGreyDTColor = Color(0xFF94969A)
private val colorBlueDTColor = Color(0xFF1E81BF)
private val colorDarkSilverGreyDTColor = Color(0xFFBFC2CD)
private val colorDarkChatSend = Color(0xFF2B6092)
private val colorDarkChatBackground = Color(0xFFF0F1F4)
private val colorDarkChatBotHint = Color(0xFFB6BAC6)
private val colorDarkChatBotLoaderScaleUp = Color(0xFFA7A7A7)
private val whiteWith30AlphaDark = Color(0x4DFFFFFF)

private val grey1Dark = Color(0xFFECEAEA)
private val grey2Dark = Color(0xFFFAFAFA)
private val grey3Dark = Color(0xFFD9D9D9)
private val colorDarkTaskDueToday = Color(0xFFFED553)
private val colorDarkTaskPastDue = Color(0xFFFB1C1C)
private val grey4Dark = Color(0xFF979797)
private val colorDarkBlue1 = Color(0xFFE1F5FE)
private val colorDarkBlue2 = Color(0xff01579B)

private val grey5Dark = Color(0xFF515050)
private val metallicBrownDark = Color(0xFFA74B1F)
private val veryPaleYellowDark = Color(0xFFFEF9C2)
private val aeroBlueDark = Color(0xFFDBFCE7)
private val pineGreenDark = Color(0xFF017B71)
private val lavenderBlushDark = Color(0xFFFEF2F2)
private val blackOliveDark = Color(0xFF3C3C3D)
private val colorDarkMediumRed = Color(0xFFC7414D)
private val colorDarkIconGray = Color(0xFF52565A)
private val colorDarkMediumBlack = Color(0xFF131314)
fun lightColors(): AppColors = AppColors(
    primary = colorLightPrimary,
    secondary = colorLightSecondary,
    background = colorLightBackground,
    surface = colorLightSurface,
    onPrimary = colorLightOnPrimary,
    onSecondary = colorLightOnSecondary,
    onBackground = colorLightOnBackground,
    error = colorLightError,
    onPrimaryBlue = colorLightPrimaryBlue,
    onPrimaryGray = colorLightToPrimaryGray,
    isLight = true,
    onSecondaryGray = colorDarkVictraDarkGreyBackground,
    onPrimaryGreen = colorLightVictraDarkGreenBackground,
    onPrimaryRed = colorLightVictraDarkRedBackground,
    onSecondaryGreen = colorLightSecondaryGreen,
    onSecondaryGrey = colorLightSecondaryGrey,
    onPrimaryDarkGrey = onPrimaryLightGrey,
    onPrimaryDarkRed = onPrimaryLightRed
)

fun darkColors(): AppColors = AppColors(
    primary = colorDarkPrimary,
    secondary = colorDarkSecondary,
    background = colorDarkBackground,
    surface = colorDarkSurface,
    onPrimary = colorDarkOnPrimary,
    onSecondary = colorDarkOnSecondary,
    onBackground = colorDarkOnBackground,
    error = colorDarkError,
    onPrimaryBlue = colorDarkPrimaryBlue,
    onPrimaryGray = colorDarkPrimaryGray,
    isLight = false,
    onSecondaryGray = colorDarkVictraDarkGreyBackground,
    onPrimaryGreen = colorDarkVictraDarkGreenBackground,
    onPrimaryRed = colorDarkVictraDarkRedBackground,
    onSecondaryGreen = colorDarkSecondaryGreen,
    onSecondaryGrey = colorDarkSecondaryGrey,
    onPrimaryDarkGrey = onPrimaryDarkGrey,
    onPrimaryDarkRed = onPrimaryDarkRed
)

val LocalColors = staticCompositionLocalOf { lightColors() }


@get:Composable
val AppColors.victraBackgroundColor: Color
    get() = if (isLight) colorLightVictraBackground else colorDarkVictraBackground

@get:Composable
val AppColors.victraBackgroundViewMoreColor: Color
    get() = if (isLight) colorLightVictraDarkGreyBackground else colorDarkVictraDarkGreyBackground

@get:Composable
val AppColors.greyBackground: Color
    get() = if (isLight) greyBackgroundLight else greyBackgroundDark

@get:Composable
val AppColors.greyBackground2: Color
    get() = if (isLight) greyBackgroundLight2 else greyBackgroundDark

@get:Composable
val AppColors.greyDarkBackground: Color
    get() = if (isLight) greyDarkBackgroundLight else greyDarkBackgroundDark

@get:Composable
val AppColors.selectBackGround: Color
    get() = if (isLight) selectBackGroundLight else selectBackGroundDark

@get:Composable
val AppColors.progressColor: Color
    get() = if (isLight) progressColorLight else progressColorDark


@get:Composable
val AppColors.selectedBackground: Color
    get() = if (isLight) selectBackGroundLight else selectBackGroundDark

@get:Composable
val AppColors.storeHoursText: Color
    get() = if (isLight) colorLightStoreHoursText else colorDarkStoreHoursText

@get:Composable
val AppColors.storeBreakHourBg: Color
    get() = if (isLight) colorLightStoreHoursBreakBg else colorDarkStoreHoursBreakBg

@get:Composable
val AppColors.contestStatusColor: Color
    get() = if (isLight) colorLightContestStatus else colorDarkContestStatus

@get:Composable
val AppColors.brkScheduleColor: Color
    get() = if (isLight) colorLightBreakSchedule else colorDarkBreakSchedule

@get:Composable
val AppColors.textButtonDisableColor: Color
    get() = if (isLight) textButtonDisableLightGrey else textButtonDisableDarkGrey

@get:Composable
val AppColors.discountCouponError: Color
    get() = if (isLight) colorLightDiscountCouponError else colorDarkDiscountCouponError

@get:Composable
val AppColors.contributionItemTextColor: Color
    get() = if (isLight) colorLightContributionItemTextGrey else colorDarkContributionItemTextGrey

@get:Composable
val AppColors.contributionItemBackgroundColor: Color
    get() = if (isLight) colorLightContributionItemBackgroundBlue else colorDarkContributionItemBackgroundBlue

@get:Composable
val AppColors.contributionDetailsIconColor: Color
    get() = if (isLight) colorLightIconContributionDetails else colorDarkIconContributionDetails


@get:Composable
val AppColors.textColorGreenTotalWork: Color
    get() = if (isLight) colorLightGreenTotalWorked else colorDarkGreenTotalWorked

@get:Composable
val AppColors.payPeriodColorBlue: Color
    get() = if (isLight) colorLightBlueWorkedDate else colorDarkBlueWorkedDate

@get:Composable
val AppColors.timeCardBottomScheduleViewBg: Color
    get() = if (isLight) timeCardBottomScheduleBg else timeCardBottomScheduleBgDark

@get:Composable
val AppColors.todayTimeBreakExpandViewBorderColor: Color
    get() = if (isLight) colorLightBorderScheduleTodayExpand else colorDarkBorderScheduleTodayExpand

@get:Composable
val AppColors.lightGreenBg: Color
    get() = if (isLight) lightGreenLightBg else lightGreenDarkBg

@get:Composable
val AppColors.progressBackground: Color
    get() = if (isLight) colorLightProgressBackground else colorDarkProgressBackground

@get:Composable
val AppColors.progressActive: Color
    get() = if (isLight) colorLightProgressActive else colorDarkProgressActive

@get:Composable
val AppColors.colorSCSelDateColor: Color
    get() = if (isLight) colorLightSCSelDate else colorDarkSCSelDate

@get:Composable
val AppColors.colorSCSelDateBGColor: Color
    get() = if (isLight) colorLightSCSelDateBG else colorDarkSCSelDateBG

@get:Composable
val AppColors.colorSCSummaryBorderColor: Color
    get() = if (isLight) colorLightSCSummaryBorder else colorDarkSCSummaryBorder

@get:Composable
val AppColors.colorViewMoreMetricsColor: Color
    get() = if (isLight) colorLightViewMoreMetricsBG else colorDarkViewMoreMetricsBG

@get:Composable
val AppColors.colorRankCompareMetricsColor: Color
    get() = if (isLight) colorLightRankCompareMetrics else colorDarkRankCompareMetrics

@get:Composable
val AppColors.alertColor: Color
    get() = if (isLight) alertLightColor else alertDarkColor

@get:Composable
val AppColors.alertTextColor: Color
    get() = if (isLight) alertTextLightColor else alertTextDarkColor

@get:Composable
val AppColors.alertHighLighterColor: Color
    get() = if (isLight) alertHighLighterLightColor else alertHighLighterDarkColor

@get:Composable
val AppColors.colorGreyColor: Color
    get() = if (isLight) colorLightGreyColor else colorDarkGreyColor


@get:Composable
val AppColors.faintGreyColor: Color
    get() = if (isLight) faintGreyLightColor else faintGreyDarkColor

@get:Composable
val AppColors.colorNewsBackArrowBGColor: Color
    get() = if (isLight) colorLightNewsBackBG else colorDarkNewsBackBG

@get:Composable
val AppColors.colorRedExCardBorderColor: Color
    get() = if (isLight) colorLightRedExCardBorder else colorDarkRedExCardBorder

@get:Composable
val AppColors.colorRedExCardBGColor: Color
    get() = if (isLight) colorLightRedExCardBG else colorDarkRedExCardBG

@get:Composable
val AppColors.colorFaintGreyColor: Color
    get() = if (isLight) colorFaintGreyLTColor else colorFaintGreyDTColor

@get:Composable
val AppColors.colorSilverGreyColor: Color
    get() = if (isLight) colorSilverGreyLTColor else colorSilverGreyDTColor

@get:Composable
val AppColors.colorBlueColor: Color
    get() = if (isLight) colorBlueLTColor else colorBlueDTColor

@get:Composable
val AppColors.colorDarkSilverGreyColor: Color
    get() = if (isLight) colorDarkSilverGreyLTColor else colorDarkSilverGreyDTColor

@get:Composable
val AppColors.chatSendColor: Color
    get() = if (isLight) colorLightChatSend else colorDarkChatSend

@get:Composable
val AppColors.chatBackgroundColor: Color
    get() = if (isLight) colorLightChatBackground else colorDarkChatBackground

@get:Composable
val AppColors.chatBotHintColor: Color
    get() = if (isLight) colorLightChatBotHint else colorDarkChatBotHint

@get:Composable
val AppColors.chatBotLoaderColor: Color
    get() = if (isLight) colorLightChatBotLoaderScaleUp else colorDarkChatBotLoaderScaleUp

@get:Composable
val AppColors.ActionBarBackGround1: Color
    get() = if (isLight) whiteWith30Alpha else whiteWith30AlphaDark

@get:Composable
val AppColors.grey1: Color
    get() = if (isLight) grey1Light else grey1Dark

@get:Composable
val AppColors.taskDueToday: Color
    get() = if (isLight) colorLightTaskDueToday else colorDarkTaskDueToday

@get:Composable
val AppColors.taskPastDue: Color
    get() = if (isLight) colorLightTaskPastDue else colorDarkTaskPastDue

@get:Composable
val AppColors.blue1: Color
    get() = if (isLight) colorLightBlue1 else colorDarkBlue1

@get:Composable
val AppColors.blue2: Color
    get() = if (isLight) colorLightBlue2 else colorDarkBlue2

@get:Composable
val AppColors.grey2: Color
    get() = if (isLight) grey2Light else grey2Dark

@get:Composable
val AppColors.grey3: Color
    get() = if (isLight) grey3Light else grey3Dark

@get:Composable
val AppColors.grey4: Color
    get() = if (isLight) grey4Light else grey4Dark

@get:Composable
val AppColors.grey5: Color
    get() = if (isLight) grey5Light else grey5Dark

@get:Composable
val AppColors.metallicBrown: Color
    get() = if (isLight) metallicBrownLight else metallicBrownDark

@get:Composable
val AppColors.veryPaleYellow: Color
    get() = if (isLight) veryPaleYellowLight else veryPaleYellowDark

@get:Composable
val AppColors.aeroBlue: Color
    get() = if (isLight) aeroBlueLight else aeroBlueDark

@get:Composable
val AppColors.pineGreen: Color
    get() = if (isLight) pineGreenLight else pineGreenDark

@get:Composable
val AppColors.lavenderBlush: Color
    get() = if (isLight) lavenderBlushLight else lavenderBlushDark

@get:Composable
val AppColors.blackOlive: Color
    get() = if (isLight) blackOliveLight else blackOliveDark

@get:Composable
val AppColors.mediumRedColor: Color
    get() = if (isLight) colorLightMediumRed else colorDarkMediumRed

@get:Composable
val AppColors.iconGray: Color
    get() = if (isLight) colorLightIconGray else colorDarkIconGray

@get:Composable
val AppColors.mediumBlack: Color
    get() = if (isLight) colorLightMediumBlack else colorDarkMediumBlack

//Tint Color
val blue = Color(0xFF1E81BF)
val grey = Color(0xFF94969A)
val yellow = Color(0xFFF7BA1D)
val red = Color(0xFFEB3223)
val green = Color(0xFF349D4C)
val red_1 = Color(0xFFB71C1C)
