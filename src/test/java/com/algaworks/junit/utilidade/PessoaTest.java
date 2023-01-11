package com.algaworks.junit.utilidade;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PessoaTest {

    @Test
    void groupedAssertion() {
        Pessoa pessoa = new Pessoa("Fabio", "Aquino");

        assertAll("Asserções de pessoa",
                ()-> assertEquals("Fabio", pessoa.getNome()),
                ()-> assertEquals("Aquino", pessoa.getSobrenome())
                );
    }

}