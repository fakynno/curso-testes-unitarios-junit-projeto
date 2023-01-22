package com.algaworks.junit.utilidade;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class ContaBancariaTest {

    private final static String SALDO_NULO = ContaBancaria.getSaldoNulo();

    @Test
    void saldoNaoPodeSerNulo() {
        assertThrows(IllegalArgumentException.class, () -> new ContaBancaria(null),
                SALDO_NULO);
    }
}