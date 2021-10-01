package com.fjoglar.composechallenge.bloom.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.fjoglar.composechallenge.bloom.R


private val NunitoSans = FontFamily(
    Font(R.font.nunito_sans_light, FontWeight.Light),
    Font(R.font.nunito_sans_semibold, FontWeight.SemiBold),
    Font(R.font.nunito_sans_bold, FontWeight.Bold),
)

val Typography = Typography(
    h1 = TextStyle(
        fontFamily = NunitoSans,
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp,
        letterSpacing = 0.sp,
    ),
    h2 = TextStyle(
        fontFamily = NunitoSans,
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp,
        letterSpacing = 0.15.sp,
    ),
    subtitle1 = TextStyle(
        fontFamily = NunitoSans,
        fontWeight = FontWeight.Light,
        fontSize = 16.sp,
        letterSpacing = 0.sp,
    ),
    body1 = TextStyle(
        fontFamily = NunitoSans,
        fontWeight = FontWeight.Light,
        fontSize = 14.sp,
        letterSpacing = 0.sp,
    ),
    body2 = TextStyle(
        fontFamily = NunitoSans,
        fontWeight = FontWeight.Light,
        fontSize = 12.sp,
        letterSpacing = 0.sp,
    ),
    button = TextStyle(
        fontFamily = NunitoSans,
        fontWeight = FontWeight.SemiBold,
        fontSize = 14.sp,
        letterSpacing = 1.sp,
    ),
    caption = TextStyle(
        fontFamily = NunitoSans,
        fontWeight = FontWeight.SemiBold,
        fontSize = 12.sp,
        letterSpacing = 0.sp,
    ),
)