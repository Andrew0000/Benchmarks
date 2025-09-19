package com.example.benchmarks

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.benchmarks.ui.theme.BenchmarksTheme

@Composable
fun MainScreen(name: String) {
    Text(
        text = "Hello $name!",
    )
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    BenchmarksTheme {
        MainScreen("Android")
    }
}