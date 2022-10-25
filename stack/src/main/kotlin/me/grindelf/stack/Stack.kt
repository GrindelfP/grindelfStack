package me.grindelf.stack

class Stack<T> {
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

    /*fun map(mapper: (T?) -> T?) = Stack<T>(size).apply {
        stack.forEach {
            this.push(mapper(it))
        }
    }*/ // does not work

    fun map(mapper: (T?) -> T?): Stack<T> {
        val updatedStack = Stack<T>(size)
        stack.forEach {
            updatedStack.push(mapper(it))
        }

        return updatedStack
    }

    override fun toString(): String {
        var string = "["
        stack.forEach {
            string += if (stack.indexOf(it) == size - 1) it.toString() else it.toString() + ", "
        }

        return "$string]"
    }

    override fun hashCode() = stack.hashCode()
}