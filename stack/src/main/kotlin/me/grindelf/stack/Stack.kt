package me.grindelf.stack

data class Stack<T>(
    private var elements: ArrayList<T?>
    ) {
    private var length: Int = elements.size
    private var upperIndex: Int = elements.count { it != null }

    constructor(size: Int) : this(ArrayList<T?>()) {
        require (size >= 0) { "Negative size of stack provided!" }
        setSize(size)
    }
    
    constructor() : this(ArrayList<T?>())

    init {
        require(isMonotone(elements)) { "Collection has nulls inbetween non-null elements!" }
        upperIndex = getUpperIndex(elements)
    }

    fun push(element: T?) {
        require(upperIndex < length) { "Stack overflow!" }
        elements.add(upperIndex, element)
        upperIndex++
    }

    fun pop(): T? {
        return if (isEmpty()) null else elements[--upperIndex]
    }

    fun top(): T? {
        return if (isEmpty()) null else elements[upperIndex - 1]
    }

    fun isEmpty(): Boolean {
        return upperIndex == 0
    }

    fun setSize(value: Int) {
        require(value >= 0) { "Negative size of stack provided!" }
        require(value > upperIndex) { "Attempt to make stack smaller than its containment!" }
        length = value
    }

    fun map(mapper: (T?) -> T?) = Stack<T>(length).also { newStack ->
        elements.forEach { element ->
            newStack.push(mapper(element))
        }
    }

    private fun isMonotone(collection: ArrayList<T?>): Boolean {
        for (i in collection.indices) {
            if (collection[i] == null && collection[i + 1] != null) return false
        }

        return true
    }

    private fun getUpperIndex(collection: ArrayList<T?>): Int {
        collection.forEach {
            if (it == null) return collection.indexOf(it) + 1
        }
        return collection.size
    }
}