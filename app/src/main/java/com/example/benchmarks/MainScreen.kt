package com.example.benchmarks

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsBottomHeight
import androidx.compose.foundation.layout.windowInsetsTopHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.dropShadow
import androidx.compose.ui.draw.innerShadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.shadow.Shadow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.benchmarks.ui.theme.BenchmarksTheme

@Composable
fun MainScreen() {
    LazyColumn(
        modifier = Modifier.imePadding(),
    ) {
        item {
            Spacer(
                Modifier.windowInsetsTopHeight(
                    WindowInsets.systemBars
                )
            )
        }
        repeat(100) {
            item {
                RealisticShadows(
                    Modifier
                        .fillMaxWidth()
                        .height(120.dp)
                        .padding(bottom = 16.dp)
                )
            }
        }
        item {
            Spacer(
                Modifier.windowInsetsBottomHeight(
                    WindowInsets.systemBars
                )
            )
        }
    }
}

/*
https://developer.android.com/develop/ui/compose/graphics/draw/shadows#create-realistic
 */
@Composable
fun RealisticShadows(
    modifier: Modifier = Modifier,
) {
    Box(modifier) {
        val dropShadowColor1 = Color(0xB3000000)
        val dropShadowColor2 = Color(0x66000000)

        val innerShadowColor1 = Color(0xCC000000)
        val innerShadowColor2 = Color(0xFF050505)
        val innerShadowColor3 = Color(0x40FFFFFF)
        val innerShadowColor4 = Color(0x1A050505)
        Box(
            Modifier
                .width(300.dp)
                .height(200.dp)
                .align(Alignment.Center)
                .dropShadow(
                    shape = RoundedCornerShape(100.dp),
                    shadow = Shadow(
                        radius = 40.dp,
                        spread = 0.dp,
                        color = dropShadowColor1,
                        offset = DpOffset(x = 2.dp, 8.dp)
                    )
                )
                .dropShadow(
                    shape = RoundedCornerShape(100.dp),
                    shadow = Shadow(
                        radius = 4.dp,
                        spread = 0.dp,
                        color = dropShadowColor2,
                        offset = DpOffset(x = 0.dp, 4.dp)
                    )
                )
                // note that the background needs to be defined before defining the inner shadow
                .background(
                    color = Color.Black,
                    shape = RoundedCornerShape(100.dp)
                )
// //
                .innerShadow(
                    shape = RoundedCornerShape(100.dp),
                    shadow = Shadow(
                        radius = 12.dp,
                        spread = 3.dp,
                        color = innerShadowColor1,
                        offset = DpOffset(x = 6.dp, 6.dp)
                    )
                )
                .innerShadow(
                    shape = RoundedCornerShape(100.dp),
                    shadow = Shadow(
                        radius = 4.dp,
                        spread = 1.dp,
                        color = Color.White,
                        offset = DpOffset(x = 5.dp, 5.dp)
                    )
                )
                .innerShadow(
                    shape = RoundedCornerShape(100.dp),
                    shadow = Shadow(
                        radius = 12.dp,
                        spread = 5.dp,
                        color = innerShadowColor2,
                        offset = DpOffset(x = (-3).dp, (-12).dp)
                    )
                )
                .innerShadow(
                    shape = RoundedCornerShape(100.dp),
                    shadow = Shadow(
                        radius = 3.dp,
                        spread = 10.dp,
                        color = innerShadowColor3,
                        offset = DpOffset(x = 0.dp, 0.dp)
                    )
                )
                .innerShadow(
                    shape = RoundedCornerShape(100.dp),
                    shadow = Shadow(
                        radius = 3.dp,
                        spread = 9.dp,
                        color = innerShadowColor4,
                        offset = DpOffset(x = 1.dp, 1.dp)
                    )
                )

        ) {
            Text(
                "Realistic Shadows",
                modifier = Modifier.align(Alignment.Center),
                fontSize = 24.sp,
                color = Color.White
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    BenchmarksTheme {
        MainScreen()
    }
}
