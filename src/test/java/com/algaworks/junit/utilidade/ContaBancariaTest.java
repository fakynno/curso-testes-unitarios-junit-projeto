package com.algaworks.junit.utilidade;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ContaBancariaTest {

    private final static String SALDO_NULO = ContaBancaria.getSaldoNulo();
    private final static String SALDO_ZERADO = ContaBancaria.getSaldoZerado();
    private final static String SALDO_INSUFICENTE = ContaBancaria.getSaldoInsuficiente();
    private final static String SAQUE_NEGATIVO = ContaBancaria.getSaqueNegativo();
    private final static String DEPOSITO_NULO = ContaBancaria.getDepositoNulo();
    private final static String DEPOSITO_ZERADO = ContaBancaria.getDepositoZerado();
    private final static String DEPOSITO_NEGATIVO = ContaBancaria.getDepositoNegativo();


    @Test
    void saldoDaContaNaoPodeSerNulo() {
        assertThrows(IllegalArgumentException.class, () -> new ContaBancaria(null),
                SALDO_NULO);
    }

    @Test
    void saldoDaContaPodeSerZerado() {
        ContaBancaria conta = new ContaBancaria(new BigDecimal(0));
        assertEquals(BigDecimal.valueOf(0), conta.getSaldo());
    }

    @Test
    void saldoDaContaPodeSerNegativo() {
        ContaBancaria conta = new ContaBancaria(new BigDecimal(-12));
        assertEquals(BigDecimal.valueOf(-12), conta.getSaldo());
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
    void saqueNaoPodeSerZero2() {
        ContaBancaria conta = new ContaBancaria(new BigDecimal(0));
        assertThrows(IllegalArgumentException.class, () -> {
            conta.saque(BigDecimal.valueOf(0));
        },
          SALDO_ZERADO);
    }

    @Test
    void saqueNaoPodeSerNegativo() {
        ContaBancaria conta = new ContaBancaria(new BigDecimal(33));
        assertThrows(IllegalArgumentException.class, () -> {
            conta.saque(BigDecimal.valueOf(-15));
        },
          SAQUE_NEGATIVO);
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
        DEPOSITO_NULO);
    }

}