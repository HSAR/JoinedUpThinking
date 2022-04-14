package io.hsar.joinedupthinking.model

import io.hsar.joinedupthinking.ui.window.getThoughtLinks
import io.hsar.joinedupthinking.ui.window.getThoughtTitle

data class Thought(val id: String, val text: String, val links: List<String> = emptyList())

fun String.toThought(): Thought = Thought(id = this.getThoughtTitle(), text = this, links = this.getThoughtLinks())