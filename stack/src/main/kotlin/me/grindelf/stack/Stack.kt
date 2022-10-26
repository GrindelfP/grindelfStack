package me.grindelf.stack

data class Stack<T> private constructor(
    private var elements: ArrayList<T?>,
    private var size: Int,
    private var upperIndex: Int = 0
    ) {


    constructor(size: Int) : this(ArrayList<T?>(size), size, 0) {
        if (size < 0) throw Exception("Negative size of stack provided!")
    }
    constructor(collection: ArrayList<T?>) : this(collection, collection.size) {
        if (!isMonotone(collection)) throw Exception("Collection has nulls inbetween non-null elements!")
        upperIndex = getUpperIndex(collection)
    }
    constructor() : this(ArrayList<T?>(0), 0)

    fun push(element: T?) {
        require(upperIndex < size) { "Stack overflow!" }
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
        require(value > upperIndex) { "Attempt to make stack smaller than its containment!" }
        size = value
    }

    fun map(mapper: (T?) -> T?) = Stack<T>(size).also { newStack ->
        elements.forEach { element ->
            newStack.push(mapper(element))
        }
    }

    private fun isMonotone(collection: ArrayList<T?>): Boolean {
        for (i in collection.indices - 1) {
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
