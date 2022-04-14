package io.hsar.joinedupthinking.ui.window

import io.hsar.joinedupthinking.model.ThoughtRegistry

/**
 * Given the editor text, returns the title of the thought - an alphanumeric string suitable for use as an ID.
 */
fun String.getThoughtTitle(): String {
    return this.lines().first()
        .filter { it.isLetterOrDigit() }
}

fun String.getThoughtLinks(): List<String> = emptyList()

fun String.replaceLinks(thoughtRegistry: ThoughtRegistry): String {
    return this // TODO finish this
}