import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import io.hsar.joinedupthinking.ui.AppState
import io.hsar.joinedupthinking.ui.ThoughtEditor
import io.hsar.joinedupthinking.ui.ThoughtEditorWindow
import io.hsar.joinedupthinking.ui.rememberAppState

fun main() = application {
    val state = rememberAppState()

    ThoughtEditorWindow(state, ::exitApplication)
}