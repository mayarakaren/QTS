package com.example.calculadora
import kotlin.test.*

class CalculadoraTeste {
    @Test
    fun testSum() {
        assertEquals(5.0, sum(2.0, 3.0))
        assertEquals(0.0, sum(-1.0, 1.0))
        assertEquals(-5.0, sum(-2.0, -3.0))
    }

    @Test
    fun testSub() {
        assertEquals(-1.0, sub(2.0, 3.0))
        assertEquals(-2.0, sub(-1.0, 1.0))
        assertEquals(1.0, sub(-2.0, -3.0))
    }

    @Test
    fun testMult() {
        assertEquals(6.0, mult(2.0, 3.0))
        assertEquals(-3.0, mult(-1.0, 3.0))
        assertEquals(6.0, mult(-2.0, -3.0))
    }

    @Test
    fun testDiv() {
        assertEquals(2.0, div(6.0, 3.0))
        assertEquals(-1.0, div(-3.0, 3.0))
        assertEquals(1.0, div(-3.0, -3.0))
    }
}