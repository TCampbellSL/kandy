/*
* Copyright 2020-2023 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license.
*/

package org.jetbrains.kotlinx.kandy.echarts.layers.context

import org.jetbrains.kotlinx.kandy.dsl.internal.LayerCollectorContext
import org.jetbrains.kotlinx.kandy.echarts.features.animation.AnimationEasing
import org.jetbrains.kotlinx.kandy.echarts.features.animation.AnimationPie
import org.jetbrains.kotlinx.kandy.echarts.features.animation.AnimationType
import org.jetbrains.kotlinx.kandy.echarts.layers.PIE
import org.jetbrains.kotlinx.kandy.ir.geom.Geom

public class PieContext(parent: LayerCollectorContext) : EchartsLayerContext(parent) {
    override val geom: Geom
        get() = PIE

    /**
     * Animation options settings for [pie][org.jetbrains.kotlinx.kandy.echarts.layers.pie].
     * If a property isn't set or set to null, a default value will be used.
     *
     * * [enable][AnimationPie.enable] - responsible for enabling animation.
     * By default `true`.
     * * [type][AnimationPie.type] - initial [animation type][AnimationType].
     * By default `expansion`.
     * * [threshold][AnimationPie.threshold] - sets a graphic number threshold for animation.
     * Animation will be disabled when graphic number exceeds a threshold.
     * By default `2000`.
     * * [duration][AnimationPie.duration] - duration of the first animation.
     * By default `1000`.
     * * [easing][AnimationPie.easing] - [easing effect][AnimationEasing] used for the first animation.
     * By default `cubicOut`.
     * * [delay][AnimationPie.delay] - delay before updating the first animation.
     * By default `0`.
     *
     * ```kotlin
     * plot {
     *  pie {
     *      animation {
     *          enable = true
     *          type = AnimationType.EXPANSION
     *          threshold = 2000
     *          duration = 1000
     *          easing = AnimationEasing.CUBIC_OUT
     *          delay = 0
     *      }
     *  }
     * }
     * ```
     *
     * @see AnimationEasing
     */
    public val animation: AnimationPie = AnimationPie()
}