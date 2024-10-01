package com.example.caixa

import io.ktor.server.application.Application
import io.ktor.server.application.call
import io.ktor.server.response.respondText
import io.ktor.server.routing.get
import io.ktor.server.routing.post
import io.ktor.server.routing.routing

fun Application.CaixaAPI() {
    routing {
        get("/conta") {
            call.respondText("api conta")
        }

        post("/conta/{numeroConta}") {
            val numeroConta = call.parameters["numeroConta"]?.toIntOrNull() ?: 0
            if(contas[numeroConta] == null) {
                val conta = ContaBancaria(numeroConta, 0.0)
                contas[numeroConta] = conta
                call.respondText("Conta criada com sucesso")
            } else {
                call.respondText("Conta já existente")
            }
        }

        post("/conta/{numeroConta}/depositar/{valor}") {
            val numeroConta = call.parameters["numeroConta"]?.toIntOrNull() ?: 0
            val valor = call.parameters["valor"]?.toDoubleOrNull() ?: 0.0

            val conta = contas[numeroConta]
            if (conta != null) {
                val mensagem = conta.depositar(valor)
                call.respondText(mensagem)
            } else {
                call.respondText("Conta não encontrada.")
            }
        }

        post("/conta/{numeroConta}/sacar/{valor}") {
            val numeroConta = call.parameters["numeroConta"]?.toIntOrNull() ?: 0
            val valor = call.parameters["valor"]?.toDoubleOrNull() ?: 0.0

            val conta = contas[numeroConta]
            if (conta != null) {
                val mensagem = conta.sacar(valor)
                call.respondText(mensagem)
            } else {
                call.respondText("Conta não encontrada.")
            }
        }

        get("/conta/{numeroConta}/saldo") {
            val numeroConta = call.parameters["numeroConta"]?.toIntOrNull() ?: 0

            val conta = contas[numeroConta]
            if (conta != null) {
                val mensagem = conta.consultarSaldo()
                call.respondText(mensagem)
            } else {
                call.respondText("Conta não encontrada.")
            }
        }
    }
}