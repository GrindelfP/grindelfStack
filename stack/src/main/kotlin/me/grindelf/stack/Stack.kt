package me.grindelf.stack

class Stack<T> {
    // It's better to name it as stackContainer etc.,
    // because it's bad practice when private field name clashes wih class name
    private var stack: ArrayList<T?>
    private var upperIndex: Int
    private var size: Int

    constructor(size: Int) {
        if (size < 0) throw Exception("Negative stack size!")
        this.size = size
        stack = ArrayList(this.size)
        upperIndex = 0
    }

    constructor(collection: ArrayList<T?>) {
        size = collection.size
        stack = collection
        upperIndex = size
    }

    constructor() {
        size = 0
        stack = ArrayList(size)
        upperIndex = 0
    }

    fun push(element: T?) {
        if (upperIndex >= size) throw Exception("Stack overflow!")
        stack.add(upperIndex, element)
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

    /**
     * We should use also here.
     * The problem with [apply] was following: inside apply we have access to the fields and functions of the object
     * we call apply on. So we do stack.forEach, we access stack of the new Stack, not the one we try to map. Of course,
     * it's empty and for each is not executed. When we use [also] we access the object using keyword `it` (I change
     * default it with newStack for better readability).
     */
    fun map(mapper: (T?) -> T?) = Stack<T>(size).also { newStack ->
        stack.forEach { element ->
            newStack.push(mapper(element))
        }
    }

    /*fun map(mapper: (T?) -> T?): Stack<T> {
        val updatedStack = Stack<T>(size)
        stack.forEach {
            updatedStack.push(mapper(it))
        }

        return updatedStack
    }*/

    override fun toString(): String {
        var string = "["
        stack.forEach {
            string += if (stack.indexOf(it) == size - 1) it.toString() else it.toString() + ", "
        }

        return "$string]"
    }

    override fun hashCode() = stack.hashCode()
}
