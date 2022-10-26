package me.grindelf.stack

import org.junit.Test
import kotlin.test.assertEquals

class StackAsDataClassTest {

    @Test
    fun `GIVEN stack with elements WHEN applying map THEN new stack with modified elements returned`() {
        val stack = StackAsDataClass(arrayListOf(1, 2, 3))
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

}
