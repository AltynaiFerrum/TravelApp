package com.jyldyzferr.travelapp.presentation.components

import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.StartOffset
import androidx.compose.animation.core.animate
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.keyframes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.Stable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.jyldyzferr.travelapp.presentation.theme.TravelAppTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlin.math.absoluteValue
import kotlin.math.cos
import kotlin.math.roundToInt
import kotlin.math.sin

private const val NumDots = 7
private const val AnimationDuration = 2000
private const val AnimationSegment = AnimationDuration / 10
private val MainDotSize = 8.15.dp

private val Float.alphaFromRadians: Float
    get() {
        val normalized = (this / (2f * Math.PI)).toFloat()
        return .5f + (normalized - .5f).absoluteValue
    }

@Stable
interface ProgressState {
    fun start(scope: CoroutineScope)
    operator fun get(index: Int): Float
}

class ProgressStateImpl : ProgressState {
    private val animationValues: List<MutableState<Float>> = List(NumDots) {
        mutableStateOf(0f)
    }

    override operator fun get(index: Int) = animationValues[index].value

    override fun start(scope: CoroutineScope) {
        repeat(NumDots) { index ->
            scope.launch {
                animate(
                    initialValue = 0f,
                    targetValue = (2f * Math.PI).toFloat(),
                    animationSpec = infiniteRepeatable(
                        animation = keyframes {
                            durationMillis = AnimationDuration
                            0f at 0
                            (.5 * Math.PI).toFloat() at 2 * AnimationSegment
                            Math.PI.toFloat() at 3 * AnimationSegment
                            (1.5 * Math.PI).toFloat() at 4 * AnimationSegment
                            (2f * Math.PI).toFloat() at 6 * AnimationSegment
                        },
                        repeatMode = RepeatMode.Restart,
                        initialStartOffset = StartOffset(offsetMillis = 100 * index)
                    ),
                ) { value, _ ->
                    animationValues[index].value = value
                }
            }
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ProgressStateImpl

        if (animationValues != other.animationValues) return false

        return true
    }

    override fun hashCode(): Int = animationValues.hashCode()
}

@Composable
fun rememberProgressState(): ProgressState = remember {
    ProgressStateImpl()
}


@Composable
fun ProgressIndicator(
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.primary,
    dotSize: Dp,
) {
    val state = rememberProgressState()
    LaunchedEffect(key1 = Unit) {
        state.start(this)
    }
    Layout(
        content = {
            val minFactor = 1f
            val step = minFactor / NumDots
            repeat(NumDots) { index ->
                Dot(
                    color = color,
                    modifier = Modifier,
                    size = dotSize
                )
            }
        },
        modifier = modifier,
    ) { measurables, constraints ->
        val looseConstraints = constraints.copy(
            minWidth = 0,
            minHeight = 0,
        )
        val placeables = measurables.map { measurable -> measurable.measure(looseConstraints) }
        layout(
            width = constraints.maxWidth,
            height = constraints.maxHeight,
        ) {
            val radius = Math.min(constraints.maxWidth, constraints.maxHeight) / 2f
            placeables.forEachIndexed { index, placeable ->
                val animatedValue = state[index]
                val x = (radius + radius * sin(animatedValue)).roundToInt()
                val y = (radius - radius * cos(animatedValue)).roundToInt()
                placeable.placeRelative(
                    x = x,
                    y = y,
                )
            }
        }
    }
}

@Composable
private fun Dot(
    color: Color,
    size: Dp,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .clip(shape = CircleShape)
            .size(size)
            .background(color = color)
    )
}


@Preview(widthDp = 360, showBackground = true)
@Composable
fun PreviewDot() {
    TravelAppTheme {
        Dot(
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier
                .padding(all = 32.dp)
                .requiredSize(32.dp),
            size = 8.dp
        )
    }
}

@Preview(widthDp = 360, showBackground = true)
@Composable
private fun PreviewProgressIndicator() {
    TravelAppTheme {
        ProgressIndicator(
            modifier = Modifier.padding(all = 32.dp),
            dotSize = 8.dp
        )
    }
}