package com.algaworks.junit.utilidade;

import java.math.BigDecimal;

public class ContaBancaria {

    private BigDecimal saldo;

    public BigDecimal getSaldo() {
        return saldo;
    }
    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public ContaBancaria(BigDecimal saldo) {
        //TODO 1 - validar saldo: não pode ser nulo, caso seja, deve lançar uma IllegalArgumentException
        //TODO 2 - pode ser zero ou negativo
    }

    public void saque(BigDecimal valor) {
        //TODO 1 - validar valor: não pode ser nulo, zero ou menor que zero, caso seja, deve lançar uma IllegalArgumentException
        //TODO 2 - Deve subtrair o valor do saldo
        //TODO 3 - Se o saldo for insuficiente deve lançar uma RuntimeException
    }

    public void deposito(BigDecimal valor) {
        //TODO 1 - validar valor: não pode ser nulo, zero ou menor que zero, caso seja, deve lançar uma IllegalArgumentException
        //TODO 2 - Deve adicionar o valor ao saldo
    }

    public BigDecimal saldoConta() {
        //TODO 1 - retornar saldo
        return null;
    }
}
