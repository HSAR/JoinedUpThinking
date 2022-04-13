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

fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        Column {
            ThoughtEditor(AppState().editorText, modifier = Modifier.fillMaxSize().padding(10.dp))
        }
    }
}