package io.hsar.joinedupthinking.model

class ThoughtRegistry(private val internalMap: MutableMap<String, Thought> = mutableMapOf()) {

    fun put(value: Thought) {
        val key = value.id
        return if (key in internalMap) {
            throw IllegalArgumentException("Could not add thought with ID '$key' to registry. Already available keys are: ${internalMap.keys}")
        } else {
            internalMap[key] = value
        }
    }
}