package me.grindelf.stack

class Stack<T> {
    private var stack: ArrayList<T>
    private var upperIndex: Int = 0
    private var size: Int

    constructor(size: Int) {
        if (size < 0) throw Exception("Negative stack size!")
        this.size = size
        stack = ArrayList(this.size)
    }

    constructor(collection: ArrayList<T>) {
        size = collection.size
        stack = collection
    }

    constructor() {
        size = 0
        stack = ArrayList(size)
    }

    fun push(element: T?) {
        if (upperIndex > size) throw Exception("Stack overflow!")
        if (element == null) throw Exception("Null was added!")
        stack[upperIndex] = element
        upperIndex++
    }

    fun pop(): T? {
        return if (isEmpty()) null else stack[--upperIndex]
    }

    fun top(): T? {
        return if (isEmpty()) null else stack[upperIndex - 1]
    }

    fun isEmpty(): Boolean {
        return upperIndex == 0
    }

    fun setSize(value: Int) {
        if (value < upperIndex) throw Exception("Attempt to make stack smaller than its containment!")
        size = value
    }
}