package me.grindelf.stack

import org.junit.Test
import kotlin.test.assertEquals

class StackTest {

    @Test
    fun `GIVEN stack with elements WHEN applying map THEN new stack with modified elements returned`() {
        val stack = Stack(arrayListOf(1, 2, 3))
        val newStack = stack.map {
            when (it) {
                null -> null
                else -> it + 3
            }
        }
        assertEquals(newStack.pop(), 6)
        assertEquals(newStack.pop(), 5)
        assertEquals(newStack.pop(), 4)

        println(newStack)
    }

    @Test
    fun `GIVEN stack with size WHEN applying push THEN return stack`() {
        val stack = Stack<Int>(3)
        stack.push(1)
        stack.push(2)
        stack.push(3)
        assertEquals(stack.pop(), 3)
        assertEquals(stack.pop(), 2)
        assertEquals(stack.pop(), 1)

        println(stack)
    }
}