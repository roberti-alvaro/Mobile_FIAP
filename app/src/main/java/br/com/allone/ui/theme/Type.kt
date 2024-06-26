package br.com.allone.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import br.com.allone.R

val Righteous = FontFamily(
        Font(R.font.righteous)
)
val Roboto = FontFamily(
        Font(R.font.roboto_bold)
)

val Coda = FontFamily(
        Font(R.font.coda_regular)
)

val PoppinsBold = FontFamily(
        Font(R.font.poppins_bold)
)

val Poppins = FontFamily(
        Font(R.font.poppins_regular)
)

val PoppinsBlack = FontFamily(
        Font(R.font.poppins_black)
)

// Set of Material typography styles to start with
val Typography = Typography(
        bodyLarge = TextStyle(
                fontFamily = FontFamily.Default,
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp,
                lineHeight = 24.sp,
                letterSpacing = 0.5.sp
        )
        /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)