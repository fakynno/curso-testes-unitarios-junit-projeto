package com.algaworks.junit.utilidade;

import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class SimuladorEsperaTest {

    @Test
    void shouldAwaitAndDoNotThrowTimeout() {
        assertTimeout(Duration.ofSeconds(2), ()-> SimuladorEspera.esperar(Duration.ofSeconds(1)));
    }

    @Test
    void shouldAwaitAndDoNotThrowTimeout2() {
        assertTimeoutPreemptively(Duration.ofSeconds(1), ()-> SimuladorEspera.esperar(Duration.ofMillis(10)));
    }
}