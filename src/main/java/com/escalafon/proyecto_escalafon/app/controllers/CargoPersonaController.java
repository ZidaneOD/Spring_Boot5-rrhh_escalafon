package com.escalafon.proyecto_escalafon.app.controllers;

import java.util.List;

import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.escalafon.proyecto_escalafon.app.infraestructures.services.ICargoPersonaServicie;
import com.escalafon.proyecto_escalafon.app.models.responses.Response;
import com.escalafon.proyecto_escalafon.app.models.resquests.CargoPersonaResquest;

@RestController
@SessionAttributes("cargopersona")
@RequestMapping(path = "api/cargopersona")
public class CargoPersonaController {
    @Autowired
    @Qualifier("ICargoPersonaServicieImp")
    private ICargoPersonaServicie cargoPersonaService;

    @GetMapping
    public Response<List<CargoPersonaResquest>> getCargoPersona() {
        return new Response<>("SUCCESS", String.valueOf(HttpStatus.OK), "CARGO PERSONA SUCCESSFULLY READED",
                cargoPersonaService.findAllCargoPersona());
    }

    @GetMapping(value = "/{id}")
    public Response<CargoPersonaResquest> getCargoPersonaById(@PathVariable Integer id) {
        return new Response<>("SUCCESS", String.valueOf(HttpStatus.OK), "CARGO PERSONA ID: " + id + " SUCCESSFULLY READED",
                cargoPersonaService.findOneCargoPersona(id));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Response<CargoPersonaResquest> saveCargoPersona(@Valid @RequestBody CargoPersonaResquest cargopersona) {
        return new Response<>("SUCCESS", String.valueOf(HttpStatus.CREATED), "CARGO PERSONA SUCCESSFULLY SAVED",
                cargoPersonaService.saveCargoPersona(cargopersona));
    }
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Response<CargoPersonaResquest> updateCargoPersona(@PathVariable Integer id, @Valid @RequestBody CargoPersonaResquest CargoPersonaResquest){
        return new Response<>("SUCCESS", String.valueOf(HttpStatus.OK), "CARGO PERSONA ID: "+id+" SUCCESSFULLY UPDATED",
                cargoPersonaService.updateCargoPersona(id, CargoPersonaResquest));
    }

    @DeleteMapping(value = "/{id}")
    public Response<String> deleteCargoPersonaById(@PathVariable Integer id){
        cargoPersonaService.deleteCargoPersona(id);
        return new Response<>("DELETED", String.valueOf(HttpStatus.NO_CONTENT), "CARGO PERSONA ID: "+id+" SUCCESSFULLY DELETED");
    }

}
