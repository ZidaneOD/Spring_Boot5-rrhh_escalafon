package com.escalafon.proyecto_escalafon.app.controllers;
import com.escalafon.proyecto_escalafon.app.models.resquests.CargoResquest;
import com.escalafon.proyecto_escalafon.app.models.responses.Response;
import com.escalafon.proyecto_escalafon.app.infraestructures.services.ICargoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@SessionAttributes("cargo")
@RequestMapping(path = "api/cargo")
public class CargoController {
    @Autowired
    @Qualifier("ICargoServiceImp")
    private ICargoService cargoService;

    @GetMapping
    public Response<List<CargoResquest>> getCargos() {
        return new Response<>("SUCCESS", String.valueOf(HttpStatus.OK), "CARGO SUCCESSFULLY READED",
                cargoService.findAll());
    }

    @GetMapping(value = "/{id}")
    public Response<CargoResquest> getCargoById(@PathVariable Integer id) {
        return new Response<>("SUCCESS", String.valueOf(HttpStatus.OK), "CARGO ID: " + id + " SUCCESSFULLY READED",
                cargoService.findOne(id));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Response<CargoResquest> saveCargo(@Valid @RequestBody CargoResquest cargo) {
        return new Response<>("SUCCESS", String.valueOf(HttpStatus.CREATED), "CARGO SUCCESSFULLY SAVED",
                cargoService.save(cargo));
    }
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Response<CargoResquest> updateDoctor(@PathVariable Integer id, @Valid @RequestBody CargoResquest cargoResquest){
        return new Response<>("SUCCESS", String.valueOf(HttpStatus.OK), "USUARIO ID: "+id+" SUCCESSFULLY UPDATED",
                cargoService.updateCargo(id, cargoResquest));
    }

    @DeleteMapping(value = "/{id}")
    public Response<String> deleteCargoById(@PathVariable Integer id){
        cargoService.delete(id);
        return new Response<>("DELETED", String.valueOf(HttpStatus.NO_CONTENT), "CARGO ID: "+id+" SUCCESSFULLY DELETED");
    }
}

