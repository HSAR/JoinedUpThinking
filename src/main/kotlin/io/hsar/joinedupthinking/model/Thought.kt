package io.hsar.joinedupthinking.model

data class Thought(val id: String, val text: String, val links: Thought)
