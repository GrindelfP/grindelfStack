package me.grindelf.stack

import org.junit.Assert
import org.junit.Test
import kotlin.test.assertEquals

class StackTest {

    @Test
    fun `GIVEN stack with elements WHEN applying map THEN modified elements returned in reverse order`() {
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
    }

    @Test
    fun `GIVEN stack with size 10 and 3 elements WHEN pop elements THEN elements returned in reverse order`() {
        val stack = Stack<Int>(10)
        stack.push(1)
        stack.push(2)
        stack.push(3)

        assertEquals(stack.pop(), 3)
        assertEquals(stack.pop(), 2)
        assertEquals(stack.pop(), 1)
        assertEquals(stack.pop(), null)
    }

    @Test
    fun `GIVEN stack default size WHEN pop element ones THEN returned null`() {
        val stack = Stack<Int>()
        assertEquals(stack.pop(), null)
    }

    @Test
    fun `GIVEN stack with size 1 and 1 element WHEN top element and pop element THEN element returned wothout removing and same element returned`() {
        val stack = Stack<Int>(1)
        stack.push(10)
        assertEquals(stack.top(), 10)
        assertEquals(stack.pop(), 10)
    }

    @Test
    fun `GIVEN stack default size WHEN top element and pop element THEN returned null and returned null`() {
        val stack = Stack<Int>()
        assertEquals(stack.top(), null)
        assertEquals(stack.pop(), null)
    }

    @Test
    fun `GIVEN stack size 3 and 2 elements WHEN setSize to 4 THEN returned elemnts in reverse with try to return one more element which returnes null`() {
        val stack = Stack<Int>(3)
        stack.push(1)
        stack.push(2)
        stack.setSize(4)
        assertEquals(stack.pop(), 2)
        assertEquals(stack.pop(), 1)
        assertEquals(stack.pop(), null)
    }

    @Test
    fun `GIVEN stack default size WHEN push element THEN exception is thrown`() {
        val stack = Stack<Int>()
        Assert.assertThrows(IllegalArgumentException::class.java) {
            stack.push(1)
        }
    }

    @Test
    fun `GIVEN stack default size WHEN setSIze to -4 THEN exception is thrown`() {
        val stack = Stack<Int>()
        Assert.assertThrows(IllegalArgumentException::class.java) {
            stack.setSize(-4)
        }
    }

    @Test
    fun `GIVEN stack size and 3 elements WHEN setSIze to 1 THEN exception is thrown`() {
        val stack = Stack<Int>(3)
        stack.push(1)
        stack.push(2)
        stack.push(3)
        Assert.assertThrows(IllegalArgumentException::class.java) {
            stack.setSize(1)
        }
    }

    @Test
    fun `GIVEN stack with elements WHEN passed elements divided by null THEN exception is thrown`() {
        Assert.assertThrows(IllegalArgumentException::class.java) {
            Stack(arrayListOf(1, null, 2))
        }
    }

    @Test
    fun `GIVEN stack with size WHEN create stack of size -5 THEN exception is thrown`() {
        Assert.assertThrows(IllegalArgumentException::class.java) {
            Stack<Int>(-5)
        }
    }
}