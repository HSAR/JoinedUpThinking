package io.hsar.joinedupthinking.ui

import WELCOME_THOUGHT
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.fasterxml.jackson.module.kotlin.readValue
import io.hsar.joinedupthinking.model.ThoughtRegistry
import io.hsar.joinedupthinking.ui.window.MAPPER
import io.hsar.joinedupthinking.ui.window.WRITER

@Composable
fun rememberAppState() = remember {
    AppState()
}


fun updateCurrentThought(appState: AppState, editorText: String) {
    try {
        appState.currentThought = MAPPER.readValue(editorText)
    } catch (e: Exception) { // TODO: React by making the UI red somewhere
//    } catch (e: InvalidDefinitionException) { // TODO: React by making the UI red somewhere
        e.printStackTrace()
    }
}

class AppState() {
    var currentThought by mutableStateOf(WELCOME_THOUGHT)
    var currentEditorText by mutableStateOf(WRITER.writeValueAsString(currentThought))

    val thoughtRegistry = ThoughtRegistry().also { it.put(currentThought) }

    var showSettings by mutableStateOf(true)

    val run = {
        println("run: ${currentEditorText}")
    }
}

