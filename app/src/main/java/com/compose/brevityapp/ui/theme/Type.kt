package com.compose.brevityapp.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.compose.brevityapp.R

// Set of Material typography styles to start with
val Typography = Typography(
    body1 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    )
    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)

//声明字体包
val NUnitSansFamily = FontFamily(
    Font(R.font.nunitosans_light, FontWeight.Light),
    Font(R.font.nunitosans_semibold, FontWeight.SemiBold),
    Font(R.font.nunitosans_bold, FontWeight.Bold)
)

val h1 = TextStyle(
    fontSize = 18.sp,
    fontFamily = NUnitSansFamily,
    fontWeight = FontWeight.Bold
)

val h2 = TextStyle(
    fontSize = 14.sp,
    letterSpacing = 0.15.sp,
    fontFamily = NUnitSansFamily,
    fontWeight = FontWeight.Bold
)

val subtitle = TextStyle(
    fontSize = 16.sp,
    fontFamily = NUnitSansFamily,
    fontWeight = FontWeight.Light
)

val body1 = TextStyle(
    fontSize = 14.sp,
    fontFamily = NUnitSansFamily,
    fontWeight = FontWeight.Light
)

val body2 = TextStyle(
    fontSize = 12.sp,
    fontFamily = NUnitSansFamily,
    fontWeight = FontWeight.Light
)

val button = TextStyle(
    fontSize = 14.sp,
    letterSpacing = 1.sp,
    fontFamily = NUnitSansFamily,
    fontWeight = FontWeight.SemiBold
)

val caption = TextStyle(
    fontSize = 12.sp,
    fontFamily = NUnitSansFamily,
    fontWeight = FontWeight.SemiBold
)
