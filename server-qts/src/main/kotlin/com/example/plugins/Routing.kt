package com.example.plugins

import com.example.calculadora.sum
import com.example.calculadora.sub
import com.example.calculadora.div
import com.example.calculadora.mult

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {
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
    }
}