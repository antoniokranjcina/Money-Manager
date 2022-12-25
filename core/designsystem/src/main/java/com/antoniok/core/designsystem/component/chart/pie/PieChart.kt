package com.antoniok.core.designsystem.component.chart.pie

import android.content.Context
import android.graphics.Paint
import android.widget.Toast
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.graphics.drawscope.scale
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.sp
import com.antoniok.core.domain.model.CategoryWithValue
import kotlin.math.PI
import kotlin.math.atan2
import kotlin.math.roundToInt

@Composable
fun PieChart(
    modifier: Modifier = Modifier,
    radius: Float,
    innerRadius: Float,
    categoriesWithValue: List<CategoryWithValue>,
    context: Context = LocalContext.current
) {

    var circleCenter by remember {
        mutableStateOf(Offset.Zero)
    }

    var categories by remember {
        mutableStateOf(categoriesWithValue)
    }
    var isCenterTapped by remember {
        mutableStateOf(false)
    }

    val value = LocalDensity.current.run {
        (radius * 2).toInt().toDp()
    }

    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(value),
        contentAlignment = Alignment.Center
    ) {
        Canvas(
            modifier = Modifier
                .pointerInput(true) {
                    detectTapGestures(
                        onTap = { offset ->
                            val tapAngleInDegrees = (-atan2(
                                x = circleCenter.y - offset.y,
                                y = circleCenter.x - offset.x
                            ) * (180f / PI).toFloat() - 90f).mod(360f)
                            val centerClicked = if (tapAngleInDegrees < 90) {
                                offset.x < circleCenter.x + innerRadius && offset.y < circleCenter.y + innerRadius
                            } else if (tapAngleInDegrees < 180) {
                                offset.x > circleCenter.x - innerRadius && offset.y < circleCenter.y + innerRadius
                            } else if (tapAngleInDegrees < 270) {
                                offset.x > circleCenter.x - innerRadius && offset.y > circleCenter.y - innerRadius
                            } else {
                                offset.x < circleCenter.x + innerRadius && offset.y > circleCenter.y - innerRadius
                            }

                            if (centerClicked) {
                                categories = categories.map {
                                    it.copy(isTapped = !isCenterTapped)
                                }
                                isCenterTapped = !isCenterTapped
                            } else {
                                val anglePerValue = 360f / categoriesWithValue.sumOf {
                                    it.value.toDouble()
                                }.toFloat()
                                var currAngle = 0f
                                categories.forEach { pieChartInput ->
                                    currAngle += pieChartInput.value * anglePerValue
                                    if (tapAngleInDegrees < currAngle) {
                                        val description = pieChartInput.category.title
                                        categories = categories.map {
                                            if (description == it.category.title) {
                                                it.copy(isTapped = !it.isTapped)
                                            } else {
                                                it.copy(isTapped = false)
                                            }
                                        }
                                        return@detectTapGestures
                                    }
                                }
                            }
                        }
                    )
                }
        ) {
            val width = size.width
            val height = size.height

            circleCenter = Offset(x = width / 2f, y = height / 2f)

            val totalValue = categoriesWithValue.sumOf {
                it.value.toDouble()
            }.toFloat()
            val anglePerValue = 360f / totalValue
            var currentStartAngle = 0f

            categories.forEach { category ->
                val scale = if (category.isTapped) 1.1f else 1.0f
                val angleToDraw = category.value * anglePerValue
                scale(scale) {
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
                if (category.isTapped) {
                    val tabRotation = currentStartAngle - angleToDraw - 90f
                    rotate(tabRotation) {
                        drawRoundRect(
                            topLeft = circleCenter,
                            size = Size(12f, radius * 1.2f),
                            color = Color.Gray,
                            cornerRadius = CornerRadius(15f, 15f)
                        )
                    }
                    rotate(tabRotation + angleToDraw) {
                        drawRoundRect(
                            topLeft = circleCenter,
                            size = Size(12f, radius * 1.2f),
                            color = Color.Gray,
                            cornerRadius = CornerRadius(15f, 15f)
                        )
                    }
                    rotate(rotateAngle) {
                        drawContext.canvas.nativeCanvas.apply {
                            Toast.makeText(context, category.toString(), Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            }

            if (categories.first().isTapped) {
                rotate(-90f) {
                    drawRoundRect(
                        topLeft = circleCenter,
                        size = Size(12f, radius * 1.2f),
                        color = Color.Gray,
                        cornerRadius = CornerRadius(15f, 15f)
                    )
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
}
