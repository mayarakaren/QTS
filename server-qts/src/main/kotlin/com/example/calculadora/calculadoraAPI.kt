package com.example.plugins

import com.example.calculadora.div
import com.example.calculadora.mult
import com.example.calculadora.sub
import com.example.calculadora.sum
import io.ktor.server.application.Application
import io.ktor.server.application.call
import io.ktor.server.response.respondText
import io.ktor.server.routing.get
import io.ktor.server.routing.routing

fun Application.CalculadoraAPI() {
    routing{
        get("/") {
            call.respondText("Teste")
        }
        get("/sum/{val1}/{val2}") {
            val val1 = call.parameters["val1"]?.toDoubleOrNull() ?: 0.0
            val val2 = call.parameters["val2"]?.toDoubleOrNull() ?: 0.0
            call.respondText(sum(val1=val1, val2=val2).toString())
        }
        get("/sub/{val1}/{val2}") {
            val val1 = call.parameters["val1"]?.toDoubleOrNull() ?: 0.0
            val val2 = call.parameters["val2"]?.toDoubleOrNull() ?: 0.0
            call.respondText(sub(val1=val1, val2=val2).toString())
        }
        get("/div/{val1}/{val2}") {
            val val1 = call.parameters["val1"]?.toDoubleOrNull() ?: 0.0
            val val2 = call.parameters["val2"]?.toDoubleOrNull() ?: 0.0
            call.respondText(div(val1=val1, val2=val2).toString())
        }
        get("/mult/{val1}/{val2}") {
            val val1 = call.parameters["val1"]?.toDoubleOrNull() ?: 0.0
            val val2 = call.parameters["val2"]?.toDoubleOrNull() ?: 0.0
            call.respondText(mult(val1=val1, val2=val2).toString())
        }
        fun formatParameters(number: Double): String {
            return number?.toDouble().toString()
        }

        fun Double.formatDoubleToString(): String {
            return this.toString()
        }
    }
}