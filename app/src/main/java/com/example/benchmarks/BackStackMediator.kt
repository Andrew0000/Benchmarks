package com.example.benchmarks

import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.mutableStateListOf
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey

class BackStackMediator(
    private val list: NavBackStack<NavKey>,
) {

    fun back() {
        list.removeLastOrNull()
    }

    fun navigate(to: NavKey) {
        if (list.contains(to)) return
        list += to
    }
}

val LocalBackStack = compositionLocalOf {
    BackStackMediator(NavBackStack(mutableStateListOf()))
}
