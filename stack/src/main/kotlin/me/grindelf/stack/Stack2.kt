package me.grindelf.stack

data class Stack2<T>(private val elements: ArrayList<T?>) {
    private var upperIndex: Int = elements.count { it != null }
    private var size: Int = elements.size

    constructor(size: Int) : this(ArrayList<T?>(size))
    constructor() : this(ArrayList<T?>(0))

    init {
        // You can validate here if elements was instantiated correctly
        // i.e. you don't have this situation [null, 3, 4, 5 null, null, 10, null, null]
    }
}
