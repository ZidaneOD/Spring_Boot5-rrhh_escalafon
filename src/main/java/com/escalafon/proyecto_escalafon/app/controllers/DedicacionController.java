package com.escalafon.proyecto_escalafon.app.controllers;

import com.escalafon.proyecto_escalafon.app.infraestructures.services.IDedicacionService;
import com.escalafon.proyecto_escalafon.app.models.responses.Response;
import com.escalafon.proyecto_escalafon.app.models.resquests.DedicacionResquest;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@SessionAttributes("dedicacion")
@RequestMapping(path = "api/dedicacion")
public class DedicacionController {
    private final IDedicacionService dedicacionService;

    public DedicacionController(@Qualifier("IDedicacionServiceImp") IDedicacionService dedicacionService) {
        this.dedicacionService = dedicacionService;
    }

    @GetMapping
    public Response<List<DedicacionResquest>> getCondiciones() {
        return new Response<>("SUCCESS", String.valueOf(HttpStatus.OK), "DEDICACION SUCCESSFULLY READED",
                dedicacionService.findAll());
    }

    @GetMapping(value = "/{id}")
    public Response<DedicacionResquest> getCondicionById(@PathVariable Integer id) {
        return new Response<>("SUCCESS", String.valueOf(HttpStatus.OK), "DEDICACION  ID: " + id + " SUCCESSFULLY READED",
                dedicacionService.findOne(id));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Response<DedicacionResquest> saveCondicion(@Valid @RequestBody DedicacionResquest dedicacion) {
        return new Response<>("SUCCESS", String.valueOf(HttpStatus.CREATED), "DEDICACION SUCCESSFULLY SAVED",
                dedicacionService.save(dedicacion));
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Response<DedicacionResquest> updateCondicion(@PathVariable Integer id, @Valid @RequestBody DedicacionResquest dedicacion) {
        return new Response<>("SUCCESS", String.valueOf(HttpStatus.OK), "DEDICACION ID: " + id + " SUCCESSFULLY UPDATED",
                dedicacionService.updateDedicacion(id, dedicacion));
    }

    @DeleteMapping(value = "/{id}")
    public Response<String> deleteCondicionById(@PathVariable Integer id) {
        dedicacionService.delete(id);
        return new Response<>("DELETED", String.valueOf(HttpStatus.NO_CONTENT), "DEDICACION ID: " + id + " SUCCESSFULLY DELETED");
    }
}
