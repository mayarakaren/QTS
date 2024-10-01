package com.example.notas

import java.util.concurrent.ConcurrentHashMap

val notasAlunos = ConcurrentHashMap<String, Double>()

class Notas {

    // Calcula a média das notas, verificando se há notas para evitar divisão por zero
    fun calcularMedia(): Double {
        return if (notasAlunos.isNotEmpty()) {
            notasAlunos.values.sum() / notasAlunos.size
        } else {
            0.0 // Retorna 0.0 se não houver notas
        }
    }

    // Retorna a nota máxima, ou null se não houver notas
    fun notaMaxima(): Double? {
        return notasAlunos.values.maxOrNull()
    }

    // Retorna a nota mínima, ou null se não houver notas
    fun notaMinima(): Double? {
        return notasAlunos.values.minOrNull()
    }

    // Adiciona uma nota para um aluno específico
    fun adicionarNota(aluno: String, nota: Double) {
        if (nota in 0.0..10.0) { // Verifica se a nota está entre 0 e 10
            notasAlunos[aluno] = nota
        } else {
            throw IllegalArgumentException("Nota inválida! Deve estar entre 0 e 10.")
        }
    }
}
