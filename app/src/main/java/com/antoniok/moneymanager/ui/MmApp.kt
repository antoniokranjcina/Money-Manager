package com.antoniok.moneymanager.ui

import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.consumedWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTagsAsResourceId
import androidx.compose.ui.zIndex
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import com.antoniok.core.designsystem.component.MmNavigationBar
import com.antoniok.core.designsystem.component.MmNavigationBarItem
import com.antoniok.core.designsystem.component.MmNavigationRail
import com.antoniok.core.designsystem.component.MmNavigationRailItem
import com.antoniok.core.designsystem.component.MmTopAppBar
import com.antoniok.core.designsystem.icon.Icon
import com.antoniok.core.designsystem.icon.MmIcons
import com.antoniok.core.designsystem.theme.MmTheme
import com.antoniok.moneymanager.navigation.MmNavHost
import com.antoniok.moneymanager.navigation.TopLevelDestination

@OptIn(
    ExperimentalComposeUiApi::class,
    ExperimentalMaterial3Api::class,
    ExperimentalLayoutApi::class
)
@Composable
fun MmApp(
    windowSizeClass: WindowSizeClass,
    appState: MmAppState = rememberMmAppState(windowSizeClass)
) {
    MmTheme {
        Scaffold(
            modifier = Modifier.semantics {
                testTagsAsResourceId = true
            },
            containerColor = Color.Transparent,
            contentColor = MaterialTheme.colors.background,
            contentWindowInsets = WindowInsets(0, 0, 0, 0),
            topBar = {
                // Show the same top bar on top level destinations
                val destination = appState.currentTopLevelDestination
                if (destination != null) {
                    MmTopAppBar(
                        // When the nav rail is displayed, the top app bar will, by default
                        // overlap it. This means that the top most item in the nav rail
                        // won't be tappable. A workaround is to position the top app bar
                        // behind the nav rail using zIndex.
                        modifier = Modifier.zIndex(-1F),
                        titleRes = destination.titleTextId,
                        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                            containerColor = Color.Transparent
                        )
                    )
                }
            },
            bottomBar = {
                if (appState.shouldShowBottomBar && appState.currentTopLevelDestination != null) {
                    MmBottomBar(
                        destinations = appState.topLevelDestinations,
                        onNavigateToDestination = appState::navigateToTopLevelDestination,
                        currentDestination = appState.currentDestination
                    )
                }
            },
            floatingActionButton = {
                if (appState.currentTopLevelDestination != null) {
                    FloatingActionButton(
                        onClick = appState::navigateToNewEntryDestination
                    ) {
                        Icon(imageVector = MmIcons.Add, contentDescription = null)
                    }
                }
            },
            floatingActionButtonPosition = FabPosition.End,
        ) { padding ->
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .windowInsetsPadding(
                        WindowInsets.safeDrawing.only(WindowInsetsSides.Horizontal)
                    )
            ) {
                if (appState.shouldShowNavRail && appState.currentTopLevelDestination != null) {
                    MmNavRail(
                        destinations = appState.topLevelDestinations,
                        onNavigateToDestination = appState::navigateToTopLevelDestination,
                        currentDestination = appState.currentDestination,
                        modifier = Modifier.safeDrawingPadding()
                    )
                }

                MmNavHost(
                    navController = appState.navController,
                    onBackClick = appState::onBackClick,
                    modifier = Modifier
                        .padding(padding)
                        .consumedWindowInsets(padding)
                )
            }
        }
    }
}


@Composable
private fun MmNavRail(
    destinations: List<TopLevelDestination>,
    onNavigateToDestination: (TopLevelDestination) -> Unit,
    currentDestination: NavDestination?,
    modifier: Modifier = Modifier,
) {
    MmNavigationRail(modifier = modifier) {
        destinations.forEach { destination ->
            val selected = currentDestination.isTopLevelDestinationInHierarchy(destination)
            MmNavigationRailItem(
                selected = selected,
                onClick = { onNavigateToDestination(destination) },
                icon = {
                    val icon = if (selected) {
                        destination.selectedIcon
                    } else {
                        destination.unselectedIcon
                    }
                    when (icon) {
                        is Icon.ImageVectorIcon -> Icon(
                            imageVector = icon.imageVector,
                            contentDescription = null
                        )
                        is Icon.DrawableResourceIcon -> Icon(
                            painter = painterResource(id = icon.id),
                            contentDescription = null
                        )
                    }
                },
                label = { Text(stringResource(destination.iconTextId)) }
            )
        }
    }
}

@Composable
private fun MmBottomBar(
    destinations: List<TopLevelDestination>,
    onNavigateToDestination: (TopLevelDestination) -> Unit,
    currentDestination: NavDestination?
) {
    MmNavigationBar {
        destinations.forEach { destination ->
            val selected = currentDestination.isTopLevelDestinationInHierarchy(destination)
            MmNavigationBarItem(
                selected = selected,
                onClick = { onNavigateToDestination(destination) },
                icon = {
                    val icon = if (selected) {
                        destination.selectedIcon
                    } else {
                        destination.unselectedIcon
                    }
                    when (icon) {
                        is Icon.ImageVectorIcon -> Icon(
                            imageVector = icon.imageVector,
                            contentDescription = null
                        )
                        is Icon.DrawableResourceIcon -> Icon(
                            painter = painterResource(id = icon.id),
                            contentDescription = null
                        )
                    }
                },
                label = { Text(stringResource(destination.iconTextId)) }
            )
        }
    }
}

private fun NavDestination?.isTopLevelDestinationInHierarchy(destination: TopLevelDestination) =
    this?.hierarchy?.any {
        it.route?.contains(destination.name, true) ?: false
    } ?: false
