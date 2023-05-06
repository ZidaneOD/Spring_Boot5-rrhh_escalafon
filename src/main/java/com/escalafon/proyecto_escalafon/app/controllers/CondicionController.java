package com.escalafon.proyecto_escalafon.app.controllers;

import com.escalafon.proyecto_escalafon.app.infraestructures.services.ICondicionService;
import com.escalafon.proyecto_escalafon.app.models.responses.Response;
import com.escalafon.proyecto_escalafon.app.models.resquests.CondicionResquest;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@SessionAttributes("condicion")
@RequestMapping(path = "api/condicion")
public class CondicionController {
    private final ICondicionService condicionService;

    public CondicionController(@Qualifier("ICondicionServiceImp") ICondicionService condicionService) {
        this.condicionService = condicionService;
    }

    @GetMapping
    public Response<List<CondicionResquest>> getCondiciones() {
        return new Response<>("SUCCESS", String.valueOf(HttpStatus.OK), "CONDICION SUCCESSFULLY READED",
                condicionService.findAll());
    }

    @GetMapping(value = "/{id}")
    public Response<CondicionResquest> getCondicionById(@PathVariable Integer id) {
        return new Response<>("SUCCESS", String.valueOf(HttpStatus.OK), "CONDICION  ID: " + id + " SUCCESSFULLY READED",
                condicionService.findOne(id));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Response<CondicionResquest> saveCondicion(@Valid @RequestBody CondicionResquest condicion) {
        return new Response<>("SUCCESS", String.valueOf(HttpStatus.CREATED), "CONDICION SUCCESSFULLY SAVED",
                condicionService.save(condicion));
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Response<CondicionResquest> updateCondicion(@PathVariable Integer id, @Valid @RequestBody CondicionResquest condicion) {
        return new Response<>("SUCCESS", String.valueOf(HttpStatus.OK), "CONDICION ID: " + id + " SUCCESSFULLY UPDATED",
                condicionService.updateCondicion(id, condicion));
    }

    @DeleteMapping(value = "/{id}")
    public Response<String> deleteCondicionById(@PathVariable Integer id) {
        condicionService.delete(id);
        return new Response<>("DELETED", String.valueOf(HttpStatus.NO_CONTENT), "CONDICION ID: " + id + " SUCCESSFULLY DELETED");
    }
}
