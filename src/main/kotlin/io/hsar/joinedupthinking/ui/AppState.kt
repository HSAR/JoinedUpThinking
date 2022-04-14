package io.hsar.joinedupthinking.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import io.hsar.joinedupthinking.model.Thought
import io.hsar.joinedupthinking.model.ThoughtRegistry
import io.hsar.joinedupthinking.model.toThought

@Composable
fun rememberAppState() = remember {
    AppState()
}

class AppState() {
    val editorText = mutableStateOf("Hello! Welcome to JoinedUpThinking.")

    val currentThought: Thought get() = editorText.value.toThought()
    val thoughtRegistry = ThoughtRegistry() //TODO: Loading?

    var showSettings by mutableStateOf(true)

    val run = {
        println("run: ${editorText.value}")
    }
}
