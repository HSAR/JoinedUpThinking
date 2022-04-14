package io.hsar.joinedupthinking.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.awt.SwingPanel
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import io.hsar.joinedupthinking.ui.view.ImageButton
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea
import org.fife.ui.rsyntaxtextarea.SyntaxConstants
import org.fife.ui.rtextarea.RTextScrollPane
import javax.swing.BoxLayout
import javax.swing.JPanel

var rtCodeEditor: RTextScrollPane? = null

@Composable
fun Editor(state: AppState, onEditorTextChange: (String) -> Unit = {}, modifier: Modifier = Modifier) {
    if (rtCodeEditor == null) {
        // create the scrollpane only once. Otherwise when text area value is
        // changed, the compose function is called from addCaretListener,
        // and a new code editor is created, with invalid caret position.
        val textArea = RSyntaxTextArea(20, 60);
        textArea.syntaxEditingStyle = SyntaxConstants.SYNTAX_STYLE_MARKDOWN
        // TODO: Set custom font here via https://stackoverflow.com/questions/5652344/how-can-i-use-a-custom-font-in-java
        textArea.font = textArea.font
        textArea.isCodeFoldingEnabled = true
        textArea.antiAliasingEnabled = true

        val sp = RTextScrollPane(textArea)
        sp.textArea.text = state.currentEditorText
        sp.textArea.addCaretListener { state.currentEditorText = sp.textArea.text }
        updateCurrentThought(state, sp.textArea.text)
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
fun EditorColumn(state: AppState, modifier: Modifier = Modifier) {
    Column(
        modifier.fillMaxWidth().padding(10.dp)
    ) {
        Row(
            modifier = Modifier.height(50.dp),
            horizontalArrangement = Arrangement.End
        ) {
            ImageButton("run.png", state.run)
            Spacer(Modifier.size(10.dp))
            ImageButton("settings.png") { state.showSettings = true }
        }

        Editor(state, onEditorTextChange = { editorText -> updateCurrentThought(state, editorText) }, modifier = modifier.fillMaxSize())
    }
}