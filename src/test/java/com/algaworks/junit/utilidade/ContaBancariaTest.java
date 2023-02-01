package com.algaworks.junit.utilidade;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertThrows;

class ContaBancariaTest {

    private final static String SALDO_NULO = ContaBancaria.getSaldoNulo();

    @Test
    void saldoNaoPodeSerNulo() {
        assertThrows(IllegalArgumentException.class, () -> new ContaBancaria(null),
                SALDO_NULO);
    }

    @Test
    void saqueNaoPodeSerNulo() {
        ContaBancaria conta = new ContaBancaria(new BigDecimal(100));
        assertThrows(IllegalArgumentException.class, () -> {
                    conta.saque(null);
                },
                SALDO_NULO);
    }

    @Test
    void depositoNaoPodeSerNulo() {
        ContaBancaria contaBancaria = new ContaBancaria(new BigDecimal(100));
        assertThrows(IllegalArgumentException.class, () -> {
            contaBancaria.deposito(null);
        },
        SALDO_NULO);
    }
}