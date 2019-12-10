package my.api.controller;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import my.api.models.Person;

@Controller("/persons")
public class MyApiController {

    @Get
    public Person index() {
        return new Person("たろう", 25);
    }

}
