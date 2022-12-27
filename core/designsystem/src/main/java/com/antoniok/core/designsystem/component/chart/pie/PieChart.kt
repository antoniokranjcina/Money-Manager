package com.antoniok.core.designsystem.component.chart.pie

import android.graphics.Paint
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.graphics.drawscope.scale
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.antoniok.core.domain.model.CategoryWithValue
import com.antoniok.core.domain.model.previewCategoriesWithValues
import kotlin.math.roundToInt

@Composable
fun PieChart(
    modifier: Modifier = Modifier,
    radius: Float,
    innerRadius: Float,
    categoriesWithValue: List<CategoryWithValue>,
    onClick: () -> Unit
) {
    val value = LocalDensity.current.run {
        (radius * 2).toInt().toDp() + 10.dp
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(value),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = modifier
                .width(value)
                .height(value)
                .clip(CircleShape)
                .clickable {
                    onClick()
                },
            contentAlignment = Alignment.Center
        ) {
            PieChartCanvas(
                radius = radius,
                innerRadius = innerRadius,
                categoriesWithValue = categoriesWithValue
            )
        }
    }
}

@Composable
private fun PieChartCanvas(
    radius: Float,
    innerRadius: Float,
    categoriesWithValue: List<CategoryWithValue>
) {
    var circleCenter by remember {
        mutableStateOf(Offset.Zero)
    }

    val categories by remember {
        mutableStateOf(categoriesWithValue)
    }

    Canvas(modifier = Modifier) {
        val width = size.width
        val height = size.height

        circleCenter = Offset(x = width / 2f, y = height / 2f)

        val totalValue = categoriesWithValue.sumOf { it.value.toDouble() }.toFloat()
        val anglePerValue = 360f / totalValue
        var currentStartAngle = 0f

        categories.forEach { category ->
            val angleToDraw = category.value * anglePerValue
            scale(1.0f) {
                drawArc(
                    color = Color(category.category.colorHex),
                    startAngle = currentStartAngle,
                    sweepAngle = angleToDraw,
                    useCenter = true,
                    size = Size(
                        width = radius * 2f,
                        height = radius * 2f
                    ),
                    topLeft = Offset(
                        (width - radius * 2f) / 2f,
                        (height - radius * 2f) / 2f
                    )
                )
                currentStartAngle += angleToDraw
            }
            var rotateAngle = currentStartAngle - angleToDraw / 2f - 90f
            var factor = 1f
            if (rotateAngle > 90f) {
                rotateAngle = (rotateAngle + 180).mod(360f)
                factor = -0.92f
            }

            val percentage = (category.value / totalValue * 100)
            val roundedPercentage = (percentage * 100.0).roundToInt() / 100.0

            drawContext.canvas.nativeCanvas.apply {
                if (percentage > 3) {
                    rotate(rotateAngle) {
                        drawText(
                            "$roundedPercentage %",
                            circleCenter.x,
                            circleCenter.y + (radius - (radius - innerRadius) / 2f) * factor,
                            Paint().apply {
                                textSize = 14.sp.toPx()
                                textAlign = Paint.Align.CENTER
                                color = Color.White.toArgb()
                            }
                        )
                    }
                }
            }
        }
        drawContext.canvas.nativeCanvas.apply {
            drawCircle(
                circleCenter.x,
                circleCenter.y,
                innerRadius,
                Paint().apply {
                    color = Color.White.copy(alpha = 0.6f).toArgb()
                    setShadowLayer(10f, 0f, 0f, Color.Gray.toArgb())
                }
            )
        }
    }
}

@Preview
@Composable
fun PieChartCanvasPreview() {
    PieChart(
        radius = 500f,
        innerRadius = 0f,
        categoriesWithValue = previewCategoriesWithValues,
        onClick = {}
    )
}
