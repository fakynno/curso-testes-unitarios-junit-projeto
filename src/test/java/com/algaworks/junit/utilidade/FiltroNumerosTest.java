package com.algaworks.junit.utilidade;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class FiltroNumerosTest {

    @Test
    public void shouldReturnEvenNumbers() {

        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> numerosParesEsperados = Arrays.asList(2, 4, 6);
        List<Integer> resultadoFiltro = FiltroNumeros.numerosPares(numeros);
        Assertions.assertIterableEquals(numerosParesEsperados, resultadoFiltro);
    }

}