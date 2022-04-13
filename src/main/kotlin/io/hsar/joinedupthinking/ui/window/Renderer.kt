package io.hsar.joinedupthinking.ui.window

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.halilibo.richtext.markdown.Markdown
import com.halilibo.richtext.ui.RichText
import io.hsar.joinedupthinking.ui.AppState

@Composable
fun RendererColumn(appState: AppState, modifier: Modifier = Modifier) {
    RichText(
        modifier = modifier.height(50.dp).padding(10.dp),
    ) {
        Markdown(appState.editorText.value)
    }
}