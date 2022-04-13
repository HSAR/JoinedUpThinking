import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import io.hsar.joinedupthinking.ui.AppState
import io.hsar.joinedupthinking.ui.EditorColumn
import io.hsar.joinedupthinking.ui.rememberAppState
import io.hsar.joinedupthinking.ui.window.RendererColumn

fun main() = application {
    val state = rememberAppState()

    MainWindow(state, ::exitApplication)
}

@Composable
fun MainWindow(state: AppState, onCloseRequest: () -> Unit = {}) {
    Window(onCloseRequest = onCloseRequest, title = "JoinedUpThinking") {
        Row(
            modifier = Modifier.fillMaxWidth().padding(5.dp)
        ) {
            EditorColumn(state, Modifier.weight(1f))
            RendererColumn(state, Modifier.weight(1f).fillMaxSize())
        }
    }
}