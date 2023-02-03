package com.algaworks.junit.utilidade;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ContaBancariaTest {

    private final static String SALDO_NULO = ContaBancaria.getSaldoNulo();
    private final static String SALDO_ZERADO = ContaBancaria.getSaldoZerado();
        private final static String SALDO_INSUFICENTE = ContaBancaria.getSaldoInsuficiente();

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
    void saqueNaoPodeSerZero() {
        ContaBancaria conta = new ContaBancaria(new BigDecimal(0));
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            conta.saque(BigDecimal.valueOf(0));
        });
        assertEquals(ContaBancaria.getSaldoZerado(), exception.getMessage());
    }

    @Test
    void saqueComSaldoInsuficiente() {
        ContaBancaria conta = new ContaBancaria(new BigDecimal(20));
        assertThrows(RuntimeException.class, () -> {
            conta.saque(BigDecimal.valueOf(25));
            },
              SALDO_INSUFICENTE);
    }

    @Test
    void saqueNormal() {
        ContaBancaria conta = new ContaBancaria(new BigDecimal(300));
        conta.saque(BigDecimal.valueOf(200));
        assertEquals(BigDecimal.valueOf(100), conta.saldoConta());
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