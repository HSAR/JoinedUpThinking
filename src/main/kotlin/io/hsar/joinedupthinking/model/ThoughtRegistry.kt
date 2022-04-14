package io.hsar.joinedupthinking.model

class ThoughtRegistry(private val internalMap: MutableMap<String, Thought> = mutableMapOf()) : Iterable<Thought> by internalMap.values {

    fun put(value: Thought) {
        val key = value.id
        return if (key in internalMap) {
            throw IllegalArgumentException("Could not add thought with ID '$key' to registry. Already available keys are: ${internalMap.keys}")
        } else {
            internalMap[key] = value
        }
    }

    operator fun get(key: String): Thought {
        return if (key !in internalMap) {
            throw NoSuchElementException("No key '$key' in registry. Available keys are: ${internalMap.keys}")
        } else {
            internalMap[key]!!
        }
    }

    val keys: Set<String> get() = internalMap.keys

    operator fun contains(key: String) = keys.contains(key)
}