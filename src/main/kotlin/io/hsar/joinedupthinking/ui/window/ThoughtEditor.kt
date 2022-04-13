package io.hsar.joinedupthinking.ui

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.awt.SwingPanel
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import io.hsar.joinedupthinking.ui.view.ImageButton
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea
import org.fife.ui.rsyntaxtextarea.SyntaxConstants
import org.fife.ui.rtextarea.RTextScrollPane
import javax.swing.BoxLayout
import javax.swing.JPanel

var rtCodeEditor: RTextScrollPane? = null

@Composable
fun ThoughtEditor(code: MutableState<String>, modifier: Modifier = Modifier) {
    if (rtCodeEditor == null) {
        // create the scrollpane only once. Otherwise when text area value is
        // changed, the compose function is called from addCaretListener,
        // and a new code editor is created, with invalid caret position.
        val textArea = RSyntaxTextArea(20, 60);
        textArea.syntaxEditingStyle = SyntaxConstants.SYNTAX_STYLE_NONE
        // TODO: Set custom font here via https://stackoverflow.com/questions/5652344/how-can-i-use-a-custom-font-in-java
        textArea.font = textArea.font
        textArea.isCodeFoldingEnabled = true
        textArea.antiAliasingEnabled = true

        val sp = RTextScrollPane(textArea)
        sp.textArea.text = code.value
        sp.textArea.addCaretListener { code.value = sp.textArea.text }

        rtCodeEditor = sp
    }

    Box(modifier = modifier) {
        SwingPanel(
            background = Color.White,
            factory = {
                JPanel().apply {
                    layout = BoxLayout(this, BoxLayout.Y_AXIS)
                    add(rtCodeEditor)
                }
            }
        )
    }
}

@Composable
fun ThoughtEditorWindow(state: AppState, onCloseRequest: () -> Unit = {}) {
    Window(onCloseRequest = onCloseRequest, title = "JoinedUpThinking") {
        Column {
            Row(
                modifier = Modifier.fillMaxWidth().height(50.dp).padding(10.dp),
                horizontalArrangement = Arrangement.End
            ) {
                ImageButton("run.png", state.run)
                Spacer(Modifier.size(10.dp))
                ImageButton("settings.png") { state.showSettings = true }
            }

            ThoughtEditor(state.editorText, modifier = Modifier.fillMaxSize().padding(10.dp))
        }
    }
}