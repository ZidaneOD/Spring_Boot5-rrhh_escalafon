package com.escalafon.proyecto_escalafon.app.controllers;

import java.util.List;

import javax.validation.Valid;

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

import com.escalafon.proyecto_escalafon.app.infraestructures.services.IAfpService;
import com.escalafon.proyecto_escalafon.app.infraestructures.services.IRegimenPensionService;
import com.escalafon.proyecto_escalafon.app.models.responses.Response;
import com.escalafon.proyecto_escalafon.app.models.resquests.AfpResquest;
import com.escalafon.proyecto_escalafon.app.models.resquests.RegimenPensionResquest;

@RestController
@SessionAttributes("afp")
@RequestMapping(path = "api/afp")

public class AfpController {
    private final IAfpService afpService;

    private final IRegimenPensionService regimenPensionService;

    public AfpController(@Qualifier("IAfpServiceImp") IAfpService afpService, @Qualifier("IRegimenPensionServiceImp") IRegimenPensionService regimenPensionService) {
        this.afpService = afpService;
        this.regimenPensionService = regimenPensionService;
    }
    
    @GetMapping
    public Response<List<AfpResquest>>getAfpes(){
        return new Response<>("SUCCESS", String.valueOf(HttpStatus.OK),"Afp SUCCESSFULLY READED",
                afpService.findAllAfp());
    }
    @GetMapping(value = "/{id}")
    public Response<AfpResquest>getAfpById(@PathVariable Integer id){
            return new Response<>("SUCCESS", String.valueOf(HttpStatus.OK),"Afp  ID: " + id + " SUCCESSFULLY READED",
                    afpService.findOneAfp(id));
    }
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Response<AfpResquest> saveAfp(@Valid @RequestBody AfpResquest Afp) {
        return new Response<>("SUCCESS", String.valueOf(HttpStatus.CREATED), "Afp SUCCESSFULLY SAVED",
                afpService.saveAfp(Afp));
    }
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Response<AfpResquest> updateAfp(@PathVariable Integer id, @Valid @RequestBody AfpResquest Afp){
        return new Response<>("SUCCESS", String.valueOf(HttpStatus.OK), "Afp ID: "+id+" SUCCESSFULLY UPDATED",
                afpService.updateAfp(id, Afp));
    }

    @DeleteMapping(value = "/{id}")
    public Response<String> deleteAfpById(@PathVariable Integer id){
        afpService.deleteAfp(id);
        return new Response<>("DELETED", String.valueOf(HttpStatus.NO_CONTENT), "Afp ID: "+id+" SUCCESSFULLY DELETED");
    }

    //TODO JUNTO YA ME DIO FLOJERA

    @GetMapping(value = "/RegimenPension")
    public Response<List<RegimenPensionResquest>>getRegimenPensions(){
        return new Response<>("SUCCESS", String.valueOf(HttpStatus.OK),"RegimenPension SUCCESSFULLY READED",
                regimenPensionService.findAllRegimenPension());
    }
    @GetMapping(value = "/RegimenPension/{id}")
    public Response<RegimenPensionResquest>getRegimenPensionById(@PathVariable Integer id){
        return new Response<>("SUCCESS", String.valueOf(HttpStatus.OK),"RegimenPension  ID: " + id + " SUCCESSFULLY READED",
                regimenPensionService.findOneRegimenPension(id));
    }
    @PostMapping(value = "/RegimenPension",consumes = MediaType.APPLICATION_JSON_VALUE)
    public Response<RegimenPensionResquest> saveRegimenPension(@Valid @RequestBody RegimenPensionResquest RegimenPension) {
        return new Response<>("SUCCESS", String.valueOf(HttpStatus.CREATED), "RegimenPension SUCCESSFULLY SAVED",
                regimenPensionService.saveRegimenPension(RegimenPension));
    }
    @PutMapping(value = "/RegimenPension/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Response<RegimenPensionResquest> updateRegimenPension(@PathVariable Integer id, @Valid @RequestBody RegimenPensionResquest RegimenPension){
        return new Response<>("SUCCESS", String.valueOf(HttpStatus.OK), "RegimenPension ID: "+id+" SUCCESSFULLY UPDATED",
                regimenPensionService.updateRegimenPension(id, RegimenPension));
    }

    @DeleteMapping(value = "/RegimenPension/{id}")
    public Response<String> deleteRegimenPensionById(@PathVariable Integer id){
        regimenPensionService.deleteRegimenPension(id);
        return new Response<>("DELETED", String.valueOf(HttpStatus.NO_CONTENT), "RegimenPension ID: "+id+" SUCCESSFULLY DELETED");
    }
}
