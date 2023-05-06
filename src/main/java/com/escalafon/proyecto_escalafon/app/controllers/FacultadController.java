package com.escalafon.proyecto_escalafon.app.controllers;


import com.escalafon.proyecto_escalafon.app.infraestructures.services.IEscuelaService;
import com.escalafon.proyecto_escalafon.app.infraestructures.services.IFacultadService;
import com.escalafon.proyecto_escalafon.app.models.responses.Response;
import com.escalafon.proyecto_escalafon.app.models.resquests.EscuelaResquest;
import com.escalafon.proyecto_escalafon.app.models.resquests.FacultadResquest;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@SessionAttributes("facultad")
@RequestMapping(path = "api/facultad")
public class FacultadController {
    private final IFacultadService facultadService;

    private final IEscuelaService escuelaService;

    public FacultadController(@Qualifier("IFacultadServiceImp") IFacultadService facultadService, @Qualifier("IEscuelaServiceImp") IEscuelaService escuelaService) {
        this.facultadService = facultadService;
        this.escuelaService = escuelaService;
    }

    @GetMapping
    public Response<List<FacultadResquest>>getFacultades(){
        return new Response<>("SUCCESS", String.valueOf(HttpStatus.OK),"FACULTAD SUCCESSFULLY READED",
                facultadService.findAll());
    }
    @GetMapping(value = "/{id}")
    public Response<FacultadResquest>getFacultadById(@PathVariable Integer id){
            return new Response<>("SUCCESS", String.valueOf(HttpStatus.OK),"FACULTAD  ID: " + id + " SUCCESSFULLY READED",
                    facultadService.findOne(id));
    }
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Response<FacultadResquest> saveFacultad(@Valid @RequestBody FacultadResquest facultad) {
        return new Response<>("SUCCESS", String.valueOf(HttpStatus.CREATED), "FACULTAD SUCCESSFULLY SAVED",
                facultadService.save(facultad));
    }
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Response<FacultadResquest> updateFacultad(@PathVariable Integer id, @Valid @RequestBody FacultadResquest facultad){
        return new Response<>("SUCCESS", String.valueOf(HttpStatus.OK), "FACULTAD ID: "+id+" SUCCESSFULLY UPDATED",
                facultadService.updateFacultad(id, facultad));
    }

    @DeleteMapping(value = "/{id}")
    public Response<String> deleteFacultadById(@PathVariable Integer id){
        facultadService.delete(id);
        return new Response<>("DELETED", String.valueOf(HttpStatus.NO_CONTENT), "FACULTAD ID: "+id+" SUCCESSFULLY DELETED");
    }

    @GetMapping(value = "/escuela")
    public Response<List<EscuelaResquest>>getEscuelas(){
        return new Response<>("SUCCESS", String.valueOf(HttpStatus.OK),"ESCUELA SUCCESSFULLY READED",
                escuelaService.findAll());
    }
    @GetMapping(value = "/escuela/{id}")
    public Response<EscuelaResquest>getEscuelaById(@PathVariable Integer id){
        return new Response<>("SUCCESS", String.valueOf(HttpStatus.OK),"ESCUELA  ID: " + id + " SUCCESSFULLY READED",
                escuelaService.findOne(id));
    }
    @PostMapping(value = "/escuela",consumes = MediaType.APPLICATION_JSON_VALUE)
    public Response<EscuelaResquest> saveEscuela(@Valid @RequestBody EscuelaResquest escuela) {
        return new Response<>("SUCCESS", String.valueOf(HttpStatus.CREATED), "ESCUELA SUCCESSFULLY SAVED",
                escuelaService.save(escuela));
    }
    @PutMapping(value = "/escuela/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Response<EscuelaResquest> updateEscuela(@PathVariable Integer id, @Valid @RequestBody EscuelaResquest escuela){
        return new Response<>("SUCCESS", String.valueOf(HttpStatus.OK), "ESCUELA ID: "+id+" SUCCESSFULLY UPDATED",
                escuelaService.updateEscuela(id, escuela));
    }

    @DeleteMapping(value = "/escuela/{id}")
    public Response<String> deleteEscuelaById(@PathVariable Integer id){
        escuelaService.delete(id);
        return new Response<>("DELETED", String.valueOf(HttpStatus.NO_CONTENT), "ESCUELA ID: "+id+" SUCCESSFULLY DELETED");
    }
}
