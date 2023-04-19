package com.escalafon.proyecto_escalafon.app.controllers;
import com.escalafon.proyecto_escalafon.app.models.Res.CargoRes;
import com.escalafon.proyecto_escalafon.app.models.Responses.Response;
import com.escalafon.proyecto_escalafon.app.models.services.ICargoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@SessionAttributes("cargo")
@RequestMapping(path = "api/cargo")
public class CargoController {
    @Autowired
    @Qualifier("ICargoServiceImp")
    private ICargoService cargoService;

    @GetMapping
    public Response<List<CargoRes>> getCargos() {
        return new Response<>("SUCCESS", String.valueOf(HttpStatus.OK), "CARGO SUCCESSFULLY READED",
                cargoService.findAll());
    }

    @GetMapping(value = "/{id}")
    public Response<CargoRes> getCargoById(@PathVariable Integer id) {
        return new Response<>("SUCCESS", String.valueOf(HttpStatus.OK), "CARGO ID: " + id + " SUCCESSFULLY READED",
                cargoService.finOne(id));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Response<CargoRes> saveCargo(@Valid @RequestBody CargoRes cargo) {
        return new Response<>("SUCCESS", String.valueOf(HttpStatus.CREATED), "CARGO SUCCESSFULLY SAVED",
                cargoService.save(cargo));
    }

    @DeleteMapping(value = "/{id}")
    public Response<String> deleteCargoById(@PathVariable Integer id){
        cargoService.delete(id);
        return new Response<>("DELETED", String.valueOf(HttpStatus.NO_CONTENT), "CARGO ID: "+id+" SUCCESSFULLY DELETED");
    }
}

