package com.escalafon.proyecto_escalafon.app.controllers;


import com.escalafon.proyecto_escalafon.app.infraestructures.services.IUsuarioService;
import com.escalafon.proyecto_escalafon.app.utils.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthController {
    @Autowired
    @Qualifier("IUsuarioServiceImp")
    private IUsuarioService usuarioService;

    @Autowired
    @Qualifier("JWTUtils")
    private JWTUtils jwtUtils;

   /* @PostMapping(value = "api/login")
    public String login(@RequestBody Usuario usuario) {

        Usuario usuarioLogueado= usuarioDAO.obtnerUsuarioXcredenciales(usuario);

        if (usuarioLogueado!=null) {

            String tokenJWT=jwtUtils.create(String.valueOf(usuarioLogueado.getId()),
                    usuarioLogueado.getEmail());

            return tokenJWT;
        }
        return "FAIL";
    }*/

}
