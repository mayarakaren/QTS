package com.example.caixa

import java.util.concurrent.ConcurrentHashMap

// Mapa para armazenar contas bancárias
val contas = ConcurrentHashMap<Int, ContaBancaria>()

// Classe ContaBancaria que define as operações
data class ContaBancaria(var numeroConta: Int, var saldo: Double) {

    // Método para depositar
    fun depositar(valor: Double): String {
        return if (valor > 0) {
            saldo += valor
            "Depósito de R$$valor realizado com sucesso! Novo saldo: R$$saldo"
        } else {
            "Valor inválido para depósito."
        }
    }

    // Método para sacar
    fun sacar(valor: Double): String {
        return if (valor > 0 && valor <= saldo) {
            saldo -= valor
            "Saque de R$$valor realizado com sucesso! Saldo restante: R$$saldo"
        } else if (valor > saldo) {
            "Saldo insuficiente para realizar o saque."
        } else {
            "Valor inválido para saque."
        }
    }

    // Método para consultar saldo
    fun consultarSaldo(): String {
        return "Saldo atual: R$$saldo"
    }
}
