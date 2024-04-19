package com.agan.conditionalapp;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Testcontainers
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ConditionalAppApplicationTests {

    @Autowired
    private TestRestTemplate restTemplate;

    public static GenericContainer<?> devapp = new GenericContainer<>("devapp:latest")
            .withExposedPorts(8080);

    public static GenericContainer<?> prodapp = new GenericContainer<>("prodapp:latest")
            .withExposedPorts(8081);

    @BeforeAll
    public static void setUp() {
        devapp.start();
        prodapp.start();
    }

    @Test
    public void testDevProfile() {
        String response = restTemplate.getForObject("http://localhost:" + devapp.getMappedPort(8080)
                                                    + "/profile", String.class);
        assertEquals("Current profile is dev", response);
    }

    @Test
    public void testProdProfile() {
        String response = restTemplate.getForObject("http://localhost:" + prodapp.getMappedPort(8081)
                                                    + "/profile", String.class);
        assertEquals("Current profile is production", response);
    }

    @AfterAll
    public static void tearDown() {
        devapp.stop();
        prodapp.stop();
    }
}

