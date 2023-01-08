package com.antoniok.core.designsystem.component.time

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.antoniok.core.designsystem.R
import com.antoniok.core.toDate
import com.antoniok.core.toTime
import com.vanpra.composematerialdialogs.MaterialDialog
import com.vanpra.composematerialdialogs.datetime.date.datepicker
import com.vanpra.composematerialdialogs.datetime.time.timepicker
import com.vanpra.composematerialdialogs.rememberMaterialDialogState
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime

@Composable
fun DateTimePicker(
    modifier: Modifier = Modifier,
    dateTime: MutableState<LocalDateTime>
) {
    val dateDialogState = rememberMaterialDialogState()
    val timeDialogState = rememberMaterialDialogState()

    var date by remember {
        mutableStateOf(LocalDate.now())
    }
    var time by remember {
        mutableStateOf(LocalTime.now())
    }

    Column(
        modifier = modifier.height(56.dp)
    ) {
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            contentAlignment = Alignment.CenterStart
        ) {
            Text(
                textAlign = TextAlign.Center,
                text = stringResource(R.string.date),
                style = MaterialTheme.typography.labelLarge
            )
        }
        Row(
            modifier = Modifier
                .weight(1f)
                .height(IntrinsicSize.Max),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxSize()
                    .clickable {
                        dateDialogState.show()
                    },
                contentAlignment = Alignment.CenterStart,
            ) {
                Text(
                    textAlign = TextAlign.Center,
                    text = dateTime.value.toDate(),
                    style = MaterialTheme.typography.labelLarge
                )
            }
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxSize()
                    .clickable {
                        timeDialogState.show()
                    },
                contentAlignment = Alignment.CenterStart
            ) {
                Text(
                    textAlign = TextAlign.Center,
                    text = dateTime.value.toTime(),
                    style = MaterialTheme.typography.labelLarge
                )
            }
        }
    }


    MaterialDialog(
        dialogState = dateDialogState,
        buttons = {
            positiveButton(text = stringResource(R.string.ok))
            negativeButton(text = stringResource(R.string.cancel))
        }
    ) {
        datepicker(
            initialDate = LocalDate.now(),
            title = stringResource(R.string.pick_a_date)
        ) {
            date = it
            dateTime.value = LocalDateTime.of(date, time)
        }
    }

    MaterialDialog(
        dialogState = timeDialogState,
        buttons = {
            positiveButton(text = stringResource(R.string.ok))
            negativeButton(text = stringResource(R.string.cancel))
        }
    ) {
        timepicker(
            initialTime = LocalTime.now(),
            title = stringResource(R.string.pick_a_time)
        ) {
            time = it
            dateTime.value = LocalDateTime.of(date, time)
        }
    }
}

@Preview
@Composable
private fun TimePickerPreview() {
    DateTimePicker(
        dateTime = remember { mutableStateOf(LocalDateTime.now()) }
    )
}
