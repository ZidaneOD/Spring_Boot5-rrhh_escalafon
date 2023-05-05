package com.escalafon.proyecto_escalafon.app.controllers;


import com.escalafon.proyecto_escalafon.app.infraestructures.services.IUsuarioService;
import com.escalafon.proyecto_escalafon.app.models.responses.Response;
import com.escalafon.proyecto_escalafon.app.models.resquests.UsuarioResquest;
import com.escalafon.proyecto_escalafon.app.utils.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/login")
public class AuthController {
    private final IUsuarioService usuarioService;

    private final JWTUtils jwtUtils;

    public AuthController(@Qualifier("IUsuarioServiceImp") IUsuarioService usuarioService, @Qualifier("JWTUtils") JWTUtils jwtUtils) {
        this.usuarioService = usuarioService;
        this.jwtUtils = jwtUtils;
    }

    @PostMapping("")
    public String login(@RequestBody UsuarioResquest usuario) {

        UsuarioResquest usuarioLogueado= usuarioService.obtnerUsuarioXcredenciales(usuario);

        if (usuarioLogueado!=null) {

            String tokenJWT=jwtUtils.create(String.valueOf(usuarioLogueado.getLogin()),
                    usuarioLogueado.getPass());
            return tokenJWT;
            //return new Response<>("SUCCESS",String.valueOf(HttpStatus.OK), tokenJWT);
            //prueba de ramas
        }
       // return new Response<>("FAIL",String.valueOf(HttpStatus.UNAUTHORIZED), "Error");
        return "Error";
    }

}
