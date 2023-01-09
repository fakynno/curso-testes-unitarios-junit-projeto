package com.algaworks.junit.utilidade;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
class FiltroNumerosTest {

    @Test
    public void shouldReturnEvenNumbers() {

        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> numerosParesEsperados = Arrays.asList(2, 4, 6);
        List<Integer> resultadoFiltro = FiltroNumeros.numerosPares(numeros);
        assertIterableEquals(numerosParesEsperados, resultadoFiltro);
    }

    @Test
    public void shouldReturnEvenNumbers2() {

        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> numerosParesEsperados = Arrays.asList(2, 4, 6);
        List<Integer> resultadoFiltro = FiltroNumeros.numerosPares(numeros);
        assertArrayEquals(numerosParesEsperados.toArray(new Object[]{}),
                resultadoFiltro.toArray(new Object[]{}));
    }

}