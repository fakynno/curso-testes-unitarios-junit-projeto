package com.algaworks.junit.utilidade;

import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

class SimuladorEsperaTest {

    @Test
    void shouldAwaitAndDoNotThrowTimeout() {
        assertTimeout(Duration.ofSeconds(2), ()-> SimuladorEspera.esperar(Duration.ofSeconds(1)));
    }

    @Test
    void shouldAwaitAndDoNotThrowTimeout2() {
        assertTimeoutPreemptively(Duration.ofSeconds(1), ()-> SimuladorEspera.esperar(Duration.ofMillis(10)));
    }

    @Test
    void shouldAwaitAndDoNotThrowTimeout3() {
        assertTimeoutPreemptively(Duration.ofSeconds(1), ()-> SimuladorEspera.esperar(Duration.ofMillis(10)));
    }

    @Test
//    @Disabled("Não se aplica")
    void shouldAwaitAndDoNotThrowTimeout4() {
        Assumptions.assumeTrue("PROD".equals(System.getenv("ENV")),
                () -> "Teste será abortado; não pode ser executado em PRD");
        assertTimeoutPreemptively(Duration.ofSeconds(1), ()-> SimuladorEspera.esperar(Duration.ofMillis(10)));
    }
}