package com.antoniok.feature.newentry

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.antoniok.core.designsystem.component.MmTopAppBar
import com.antoniok.core.designsystem.component.TopAppBarIconType
import com.antoniok.core.designsystem.icon.MmIcons

@Composable
fun NewEntryRoute(
    modifier: Modifier = Modifier,
    onBackPressed: () -> Unit
) {
    NewEntryScreen(
        modifier = modifier,
        onBackPressed = onBackPressed
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun NewEntryScreen(
    modifier: Modifier = Modifier,
    onBackPressed: () -> Unit = {}
) {
    Scaffold(
        topBar = {
            MmTopAppBar(
                titleRes = R.string.add_new_entry,
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color.Transparent
                ),
                icon = MmIcons.ArrowBack,
                iconContentDescription = null,
                onIconClick = onBackPressed,
                iconType = TopAppBarIconType.Navigation
            )
        },
        contentColor = MaterialTheme.colors.background,
        contentWindowInsets = WindowInsets(0, 0, 0, 0)
    ) {
        Box(modifier = modifier.padding(it)) {
            Text(text = "Hello new entry")
        }
    }
}