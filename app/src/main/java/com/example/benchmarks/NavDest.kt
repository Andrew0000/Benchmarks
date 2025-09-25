package com.example.benchmarks

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

sealed interface NavDest : NavKey {

    @Serializable
    data object Home : NavDest

    @Serializable
    data object NoShadowsWithScroll : NavDest

    @Serializable
    data object ElevationShadowsWithScroll : NavDest

    @Serializable
    data object SimpleShadowsWithScroll : NavDest

    @Serializable
    data object RealisticShadowsWithScroll : NavDest

    @Serializable
    data object NeuromorphicShadowsWithScroll : NavDest

}
