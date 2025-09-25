package com.example.benchmarks

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .safeDrawingPadding()
            .padding(32.dp),
        verticalArrangement = Arrangement.spacedBy(32.dp),
    ) {
        val backStack = LocalBackStack.current

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(32.dp),
        ) {
            Button(
                modifier = Modifier
                    .weight(1f)
                    .testTag("nav_to_simple_shadows"),
                onClick = { backStack.navigate(NavDest.SimpleShadowsWithScroll) }
            ) {
                Text("Simple\nshadows")
            }
            Button(
                modifier = Modifier
                    .weight(1f)
                    .testTag("nav_to_realistic_shadows"),
                onClick = { backStack.navigate(NavDest.RealisticShadowsWithScroll) }
            ) {
                Text("Realistic\nshadows")
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(32.dp),
        ) {
            Button(
                modifier = Modifier
                    .weight(1f)
                    .testTag("nav_to_no_shadows"),
                onClick = { backStack.navigate(NavDest.NoShadowsWithScroll) }
            ) {
                Text("No\nshadows")
            }
            Button(
                modifier = Modifier
                    .weight(1f)
                    .testTag("nav_to_elevation_shadows"),
                onClick = { backStack.navigate(NavDest.ElevationShadowsWithScroll) }
            ) {
                Text("Elevation\nshadows")
            }
        }
    }
}