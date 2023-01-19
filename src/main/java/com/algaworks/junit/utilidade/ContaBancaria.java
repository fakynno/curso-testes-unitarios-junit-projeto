package com.algaworks.junit.utilidade;

import java.math.BigDecimal;

public class ContaBancaria {

    private BigDecimal saldo;

    private final static String SALDO_NULO = "Saldo não pode ser nulo!";
    private final static String SALDO_INSUFICIENTE = "Saldo insuficiente para realizar esta operação!";
    private final static String SALDO_ZERADO = "Saldo não pode ser zerado!";
    private final static String SALDO_NEGATIVO = "Saldo não pode ser negativo!";

    public BigDecimal getSaldo() {
        return saldo;
    }
    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public ContaBancaria(BigDecimal saldo) {
        //TODO 1 - validar saldo: não pode ser nulo, caso seja, deve lançar uma IllegalArgumentException
        //TODO 2 - pode ser zero ou negativo
        saldo = this.getSaldo();
        if (saldo == null) {
            throw new IllegalArgumentException(SALDO_NULO);
        }
    }

    public void saque(BigDecimal valor) {
        //TODO 1 - validar valor: não pode ser nulo, zero ou menor que zero, caso seja, deve lançar uma IllegalArgumentException
        //TODO 2 - Deve subtrair o valor do saldo
        //TODO 3 - Se o saldo for insuficiente deve lançar uma RuntimeException

        BigDecimal resultado;

        valor = valor.subtract(this.getSaldo());
        resultado = valor;

        if (valor.compareTo(BigDecimal.ZERO) < 0) {
            throw new RuntimeException(SALDO_INSUFICIENTE);
        }

        if (resultado == null) {
            throw new IllegalArgumentException(SALDO_NULO);
        } else if (resultado.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException(SALDO_NEGATIVO);
        } else if (resultado.compareTo(BigDecimal.ZERO) == 0) {
            throw new IllegalArgumentException(SALDO_ZERADO);
        }
    }

    public void deposito(BigDecimal valor) {
        //TODO 1 - validar valor: não pode ser nulo, zero ou menor que zero, caso seja, deve lançar uma IllegalArgumentException
        //TODO 2 - Deve adicionar o valor ao saldo

        valor = valor.add(this.getSaldo());

        if (valor == null) {
            throw new IllegalArgumentException(SALDO_NULO);
        } else if (valor.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException(SALDO_NEGATIVO);
        } else if (valor.compareTo(BigDecimal.ZERO) == 0) {
            throw new IllegalArgumentException(SALDO_ZERADO);
        }
    }

    public BigDecimal saldoConta() {
        //TODO 1 - retornar saldo
        return this.getSaldo();
    }
}
