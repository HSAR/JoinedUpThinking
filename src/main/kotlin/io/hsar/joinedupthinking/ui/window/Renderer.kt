package io.hsar.joinedupthinking.ui.window

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import io.hsar.joinedupthinking.ui.AppState

@Composable
fun RendererColumn(appState: AppState, modifier: Modifier = Modifier) {
    Text(appState.currentThought.text, modifier) // TODO: Upgrade
}