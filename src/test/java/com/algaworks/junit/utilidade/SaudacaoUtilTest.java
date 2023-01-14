package com.algaworks.junit.utilidade;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SaudacaoUtilTest {

    @Test
    public void saudarComBomDia() {
        String saudacao = SaudacaoUtil.saudar(9);
        assertEquals("Bom dia", saudacao, "Saudação Incorreta!");
    }

    @Test
    public void saudarComBoaTarde() {
        String saudacao = SaudacaoUtil.saudar(13);
        assertEquals("Boa tarde", saudacao, "Saudação incorreta!");
    }

    @Test
    void saudarComBoaNoite() {
        String saudacao = SaudacaoUtil.saudar(20);
        assertEquals("Boa noite", saudacao, "Saudação incorreta!");
    }

    @Test
    public void shouldThrowException() {
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class,
                () -> SaudacaoUtil.saudar(-10));
        assertEquals("Hora inválida", illegalArgumentException.getMessage());
    }


    @Test
    public void shouldNotThrowException() {
        assertDoesNotThrow(()-> SaudacaoUtil.saudar(0));
    }
}