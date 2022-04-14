package io.hsar.joinedupthinking.model

import com.fasterxml.jackson.annotation.JsonTypeInfo

data class Thought(val id: String, val sections: List<Section>)

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "sectionType")
sealed class Section {
    abstract val title: String
}

data class TextSection(override val title: String, val text: String) : Section()
data class LinkSection(override val title: String, val links: List<Thought>) : Section()