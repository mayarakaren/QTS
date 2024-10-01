package com.example.plugins

import com.example.caixa.CaixaAPI
import com.example.calculadora.sum
import com.example.calculadora.sub
import com.example.calculadora.div
import com.example.calculadora.mult
import com.example.notas.NotasAPI

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    CalculadoraAPI()
    CaixaAPI()
    NotasAPI()
}

fun formatParameters(number: Double?):String{
    return number?.toDouble().toString()
}