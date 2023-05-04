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

import com.escalafon.proyecto_escalafon.app.infraestructures.services.IEstadoCivilService;
import com.escalafon.proyecto_escalafon.app.models.responses.Response;
import com.escalafon.proyecto_escalafon.app.models.resquests.EstadoCivilResquest;

@RestController
@SessionAttributes("estadocivil")
@RequestMapping(path = "api/estadocivil")
public class EstadoCivilController {
    @Autowired
    @Qualifier("IEstadoCivilServiceImp")
    private IEstadoCivilService estadoCivilService;

    @GetMapping
    public Response<List<EstadoCivilResquest>> getCargos() {
        return new Response<>("SUCCESS", String.valueOf(HttpStatus.OK), "ESTADO CIVIL SUCCESSFULLY READED",
                estadoCivilService.finAllEstadoCivil());
    }

    @GetMapping(value = "/{id}")
    public Response<EstadoCivilResquest> getEstadoCivilById(@PathVariable Integer id) {
        return new Response<>("SUCCESS", String.valueOf(HttpStatus.OK), "ESTADO CIVIL ID: " + id + " SUCCESSFULLY READED",
                estadoCivilService.findOneEstadoCivil(id));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Response<EstadoCivilResquest> saveEstadoCivil(@Valid @RequestBody EstadoCivilResquest estadocivil) {
        return new Response<>("SUCCESS", String.valueOf(HttpStatus.CREATED), "ESTADO CIVIL SUCCESSFULLY SAVED",
                estadoCivilService.saveEstadoCivil(estadocivil));
    }
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Response<EstadoCivilResquest> updateEstadoCivil(@PathVariable Integer id, @Valid @RequestBody EstadoCivilResquest EstadoCivilResquest){
        return new Response<>("SUCCESS", String.valueOf(HttpStatus.OK), "ESTADO CIVIL ID: "+id+" SUCCESSFULLY UPDATED",
                estadoCivilService.updateEstadoCivil(id, EstadoCivilResquest));
    }

    @DeleteMapping(value = "/{id}")
    public Response<String> deleteEstadoCivilById(@PathVariable Integer id){
        estadoCivilService.deleteEstadoCivil(id);
        return new Response<>("DELETED", String.valueOf(HttpStatus.NO_CONTENT), "ESTADO CIVIL ID: "+id+" SUCCESSFULLY DELETED");
    }
}
