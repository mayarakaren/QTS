package com.example.notas

import io.ktor.server.application.Application
import io.ktor.server.application.call
import io.ktor.server.response.respondText
import io.ktor.server.routing.get
import io.ktor.server.routing.post
import io.ktor.server.routing.routing

fun Application.NotasAPI() {
    val notas = Notas()

    routing {

        // Rota para calcular a média das notas
        get("/notas/media") {
            if (notasAlunos.isEmpty()) {
                call.respondText("Não há notas disponíveis.")
            } else {
                val media = notas.calcularMedia()
                call.respondText("A média das notas é: %.2f".format(media))
            }
        }

        // Rota para retornar a nota máxima
        get("/notas/maxima") {
            val max = notas.notaMaxima()
            if (max != null) {
                call.respondText("A nota máxima é: $max")
            } else {
                call.respondText("Não há notas disponíveis.")
            }
        }

        // Rota para retornar a nota mínima
        get("/notas/minima") {
            val min = notas.notaMinima()
            if (min != null) {
                call.respondText("A nota mínima é: $min")
            } else {
                call.respondText("Não há notas disponíveis.")
            }
        }

        // Rota para adicionar uma nota para um aluno
        post("/notas/adicionar/{aluno}/{valor}") {
            val aluno = call.parameters["aluno"] ?: return@post call.respondText("Nome do aluno inválido.")
            val valor = call.parameters["valor"]?.toDoubleOrNull()

            if (valor == null) {
                call.respondText("Valor da nota inválido. Deve ser um número.")
            } else {
                try {
                    notas.adicionarNota(aluno, valor)
                    call.respondText("Nota de $valor adicionada para $aluno com sucesso!")
                } catch (e: IllegalArgumentException) {
                    call.respondText(e.message ?: "Erro ao adicionar a nota.")
                }
            }
        }
    }
}
