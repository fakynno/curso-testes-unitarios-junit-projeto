package com.algaworks.junit.utilidade;

import org.junit.jupiter.api.Test;

import static com.algaworks.junit.utilidade.SaudacaoUtil.saudar;
import static org.junit.jupiter.api.Assertions.*;

class SaudacaoUtilTest {

    @Test
    public void saudarComBomDia() {
        int horaValida = 9;
        String saudacao = saudar(horaValida);
        assertEquals("Bom dia", saudacao);
    }

    @Test
    public void saudarComBomDiaAPartir5h() {
        int horaValida = 5;
        String saudacao = saudar(horaValida);
        assertEquals("Bom dia", saudacao);
    }

    @Test
    public void saudarComBoaTarde() {
        String saudacao = saudar(13);
        assertEquals("Boa tarde", saudacao, "Saudação incorreta!");
    }

    @Test
    void saudarComBoaNoite() {
        String saudacao = saudar(20);
        assertEquals("Boa noite", saudacao, "Saudação incorreta!");
    }

    @Test
    void saudarComBoaNoiteAPartir4h() {
        int horaValida = 4;
        String saudacao = saudar(horaValida);
        assertEquals("Boa noite", saudacao, "saudação inválida!");
    }

    @Test
    public void shouldThrowException() {
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class,
                () -> saudar(-10));
        assertEquals("Hora inválida", illegalArgumentException.getMessage());
    }


    @Test
    public void shouldNotThrowException() {
        assertDoesNotThrow(()-> saudar(0));
    }
}