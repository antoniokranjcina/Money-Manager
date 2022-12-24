package com.antoniok.core.designsystem.component.balance

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle

@Composable
fun TextWithValue(
    modifier: Modifier = Modifier,
    text: String,
    textStyle: TextStyle,
    textColor: Color,
    value: String,
    valueStyle: TextStyle,
    valueColor: Color
) {
    Column(
        modifier = modifier
    ) {
        Text(
            text = text,
            style = textStyle,
            color = textColor
        )
        Text(
            text = value,
            style = valueStyle,
            color = valueColor
        )
    }
}
