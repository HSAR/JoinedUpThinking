package io.hsar.joinedupthinking.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

@Composable
fun rememberAppState() = remember {
    AppState()
}

class AppState() {
    val editorText: MutableState<String> = mutableStateOf("Hello! Welcome to JoinedUpThinking.")
    var showSettings by mutableStateOf(true)

    val run = {
        println("run: ${editorText.value}")
    }
}
