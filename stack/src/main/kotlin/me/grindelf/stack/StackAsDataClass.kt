package me.grindelf.stack

data class StackAsDataClass<T>(
    private var stackContainer: ArrayList<T?>,
    private var size: Int,
    private var upperIndex: Int = 0
) {

    constructor(size: Int) : this(ArrayList<T?>(size), size)
    constructor(collection: ArrayList<T?>) : this(collection, collection.size)
    constructor() : this(ArrayList<T?>(0), 0)

    fun push(element: T?) {
        require(upperIndex < size) { "Stack overflow!" }
        stackContainer.add(upperIndex, element)
        upperIndex++
    }

    fun pop(): T? {
        return if (isEmpty()) null else stackContainer[--upperIndex]
    }

    fun top(): T? {
        return if (isEmpty()) null else stackContainer[upperIndex - 1]
    }

    fun isEmpty(): Boolean {
        return upperIndex == 0
    }

    fun setSize(value: Int) {
        require(value > upperIndex) { "Attempt to make stack smaller than its containment!" }
        size = value
    }

    fun map(mapper: (T?) -> T?) = StackAsDataClass<T>(size).also { newStack ->
        stackContainer.forEach { element ->
            newStack.push(mapper(element))
        }
    }
}
