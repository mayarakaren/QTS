package com.example.banco

import com.example.caixa.ContaBancaria
import kotlin.test.Test
import kotlin.test.assertEquals

class BancoTeste {

    @Test
    fun testDepositar() {
        val conta = ContaBancaria(12345, 100.0) // Ordem dos parâmetros ajustada
        conta.depositar(50.0)
        val saldoAtual = conta.consultarSaldo().replace("Saldo atual: R$", "").toDouble() // Extrair saldo da string
        assertEquals(150.0, saldoAtual)
    }

    @Test
    fun testSacar() {
        val conta = ContaBancaria(12345, 100.0)
        conta.sacar(30.0)
        val saldoAtual = conta.consultarSaldo().replace("Saldo atual: R$", "").toDouble()
        assertEquals(70.0, saldoAtual)
    }

    @Test
    fun testConsultarSaldo() {
        val conta = ContaBancaria(12345, 200.0)
        val saldoAtual = conta.consultarSaldo().replace("Saldo atual: R$", "").toDouble()
        assertEquals(200.0, saldoAtual)
    }
}
