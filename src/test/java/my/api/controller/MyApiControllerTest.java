package my.api.controller;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.runtime.server.EmbeddedServer;
import io.micronaut.test.annotation.MicronautTest;
import my.api.models.Person;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@MicronautTest
class MyApiControllerTest {

    @Inject
    EmbeddedServer server;
    @Inject
    @Client("/")
    HttpClient client;

    @Test
    void index() {
        Person response = client.toBlocking().retrieve(HttpRequest.GET("/persons"), Person.class);
        assertEquals(response.getAge(), 25);
        assertEquals(response.getName(), "たろう");
    }
}