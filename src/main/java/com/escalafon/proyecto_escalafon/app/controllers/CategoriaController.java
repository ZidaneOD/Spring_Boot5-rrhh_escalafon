package com.escalafon.proyecto_escalafon.app.controllers;

import com.escalafon.proyecto_escalafon.app.infraestructures.services.ICategoriaService;
import com.escalafon.proyecto_escalafon.app.models.responses.Response;
import com.escalafon.proyecto_escalafon.app.models.resquests.CategoriaResquest;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@SessionAttributes("categoria")
@RequestMapping(path = "api/categoria")
public class CategoriaController {
    private final ICategoriaService categoriaService;

    public CategoriaController(@Qualifier("ICategoriaServiceImp") ICategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping
    public Response<List<CategoriaResquest>> getCategorias(){
        return new Response<>("SUCCESS", String.valueOf(HttpStatus.OK),"CATEGORIA SUCCESSFULLY READED",
                categoriaService.findAll());
    }
    @GetMapping(value = "/{id}")
    public Response<CategoriaResquest>getCategoriaById(@PathVariable Integer id){
        return new Response<>("SUCCESS", String.valueOf(HttpStatus.OK),"CATEGORIA  ID: " + id + " SUCCESSFULLY READED",
                categoriaService.findOne(id));
    }
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Response<CategoriaResquest> saveCategoria(@Valid @RequestBody CategoriaResquest categoria) {
        return new Response<>("SUCCESS", String.valueOf(HttpStatus.CREATED), "FACULTAD SUCCESSFULLY SAVED",
                categoriaService.save(categoria));
    }
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Response<CategoriaResquest> updateCategoria(@PathVariable Integer id, @Valid @RequestBody CategoriaResquest categoria){
        return new Response<>("SUCCESS", String.valueOf(HttpStatus.OK), "CATEGORIA ID: "+id+" SUCCESSFULLY UPDATED",
                categoriaService.updateCargo(id, categoria));
    }

    @DeleteMapping(value = "/{id}")
    public Response<String> deleteCategoriaById(@PathVariable Integer id){
        categoriaService.delete(id);
        return new Response<>("DELETED", String.valueOf(HttpStatus.NO_CONTENT), "CATEGORIA ID: "+id+" SUCCESSFULLY DELETED");
    }
}
