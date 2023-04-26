package com.escalafon.proyecto_escalafon.app.controllers;

import com.escalafon.proyecto_escalafon.app.models.resquests.UsuarioResquest;
import com.escalafon.proyecto_escalafon.app.models.responses.Response;
import com.escalafon.proyecto_escalafon.app.infraestructures.services.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@SessionAttributes("usuario")
@RequestMapping(path = "api/usuario")
public class UsuarioController {
    @Autowired
    private IUsuarioService usuarioService;

    @GetMapping
    public Response<List<UsuarioResquest>> getUsuarios() {
        return new Response<>("SUCCESS", String.valueOf(HttpStatus.OK), "CARGO SUCCESSFULLY READED",
                usuarioService.findAll());
    }
    @GetMapping(value = "/{id}")
    public Response<UsuarioResquest> getUsuarioById(@PathVariable Integer id) {
        return new Response<>("SUCCESS", String.valueOf(HttpStatus.OK), "CARGO ID: " + id + " SUCCESSFULLY READED",
                usuarioService.findOne(id));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Response<UsuarioResquest> saveUsuario(@Valid @RequestBody UsuarioResquest usuario) {
        return new Response<>("SUCCESS", String.valueOf(HttpStatus.CREATED), "CARGO SUCCESSFULLY SAVED",
                usuarioService.save(usuario));
    }
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Response<UsuarioResquest> updateDoctor(@PathVariable Integer id, @Valid @RequestBody UsuarioResquest usuarioResquest){
        return new Response<>("SUCCESS", String.valueOf(HttpStatus.OK), "CARGO ID: "+id+" SUCCESSFULLY UPDATED",
                usuarioService.updateUsuario(id, usuarioResquest));
    }
    @DeleteMapping(value = "/{id}")
    public Response<String> deleteUsuarioById(@PathVariable Integer id){
        usuarioService.delete(id);
        return new Response<>("DELETED", String.valueOf(HttpStatus.NO_CONTENT), "USUARIO ID: "+id+" SUCCESSFULLY DELETED");
    }



}
