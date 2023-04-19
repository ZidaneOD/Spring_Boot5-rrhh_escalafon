package com.escalafon.proyecto_escalafon.app.controllers;

import com.escalafon.proyecto_escalafon.app.models.Res.UsuarioRes;
import com.escalafon.proyecto_escalafon.app.models.Responses.Response;
import com.escalafon.proyecto_escalafon.app.models.services.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@SessionAttributes("usuario")
@RequestMapping(path = "api/usuario")
public class UsuarioController {
    @Autowired
    @Qualifier("IUsuarioServiceImp")
    private IUsuarioService usuarioService;

    @GetMapping
    public Response<List<UsuarioRes>> getUsuarios() {
        return new Response<>("SUCCESS", String.valueOf(HttpStatus.OK), "USUARIO SUCCESSFULLY READED",
                usuarioService.findAll());
    }
    @GetMapping(value = "/{id}")
    public Response<UsuarioRes> getUsuarioById(@PathVariable Integer id) {
        return new Response<>("SUCCESS", String.valueOf(HttpStatus.OK), "USUARIO ID: " + id + " SUCCESSFULLY READED",
                usuarioService.findOne(id));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Response<UsuarioRes> saveUsuario(@Valid @RequestBody UsuarioRes usuario) {
        return new Response<>("SUCCESS", String.valueOf(HttpStatus.CREATED), "DOCTOR SUCCESSFULLY SAVED",
                usuarioService.save(usuario));
    }
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Response<UsuarioRes> updateDoctor(@PathVariable Integer id, @Valid @RequestBody UsuarioRes usuarioRes){
        return new Response<>("SUCCESS", String.valueOf(HttpStatus.OK), "USUARIO ID: "+id+" SUCCESSFULLY UPDATED",
                usuarioService.updateUsuario(id, usuarioRes));
    }
    @DeleteMapping(value = "/{id}")
    public Response<String> deleteUsuarioById(@PathVariable Integer id){
        usuarioService.delete(id);
        return new Response<>("DELETED", String.valueOf(HttpStatus.NO_CONTENT), "USUARIO ID: "+id+" SUCCESSFULLY DELETED");
    }

}
