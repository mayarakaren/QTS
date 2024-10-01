package com.example.notas

import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class NotasTest {

    @BeforeTest
    fun setup() {
        notasAlunos.clear() // Limpa as notas antes de cada teste
    }

    @Test
    fun testAdicionarNota() {
        val notas = Notas()

        // Adiciona nota válida para Alice
        notas.adicionarNota("Alice", 85.0)
        assertEquals(85.0, notasAlunos["Alice"])

        // Adiciona nota válida para Bob
        notas.adicionarNota("Bob", 90.0)
        assertEquals(90.0, notasAlunos["Bob"])

        // Testa adição de nota inválida (fora do intervalo 0-10)
        assertFailsWith<IllegalArgumentException> {
            notas.adicionarNota("Charlie", 11.0) // Deve lançar exceção
        }
    }

    @Test
    fun testCalcularMedia() {
        val notas = Notas()
        notas.adicionarNota("Alice", 85.0)
        notas.adicionarNota("Bob", 95.0)

        // Verifica se a média foi calculada corretamente
        val media = notas.calcularMedia()
        assertEquals(90.0, media)
    }

    @Test
    fun testNotaMaxima() {
        val notas = Notas()
        notas.adicionarNota("Alice", 85.0)
        notas.adicionarNota("Bob", 90.0)
        notas.adicionarNota("Charlie", 78.0)

        // Verifica a nota máxima
        val max = notas.notaMaxima()
        assertEquals(90.0, max)
    }

    @Test
    fun testNotaMinima() {
        val notas = Notas()
        notas.adicionarNota("Alice", 85.0)
        notas.adicionarNota("Bob", 90.0)
        notas.adicionarNota("Charlie", 78.0)

        // Verifica a nota mínima
        val min = notas.notaMinima()
        assertEquals(78.0, min)
    }

    @Test
    fun testCalcularMediaSemNotas() {
        val notas = Notas()

        // Verifica se a média é 0.0 quando não há notas
        val media = notas.calcularMedia()
        assertEquals(0.0, media)
    }

    @Test
    fun testNotaMaximaSemNotas() {
        val notas = Notas()

        // Verifica se a nota máxima é null quando não há notas
        val max = notas.notaMaxima()
        assertEquals(null, max)
    }

    @Test
    fun testNotaMinimaSemNotas() {
        val notas = Notas()

        // Verifica se a nota mínima é null quando não há notas
        val min = notas.notaMinima()
        assertEquals(null, min)
    }
}
