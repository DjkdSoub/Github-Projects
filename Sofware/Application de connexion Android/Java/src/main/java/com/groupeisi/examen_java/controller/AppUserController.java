package com.groupeisi.examen_java.controller;

import com.groupeisi.examen_java.config.ApiMessage;
import com.groupeisi.examen_java.dao.IAppUser;
import com.groupeisi.examen_java.entities.AppUser;
import jakarta.websocket.server.PathParam;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@AllArgsConstructor
public class AppUserController {
    private IAppUser userdao;

    @PostMapping(path = "/cvs/save")
    public AppUser save(@RequestBody AppUser appUser) {
        return userdao.save(appUser);
    }

    @PutMapping(path = "/cvs/update/{id}")
    public AppUser update(@PathVariable int id, @RequestBody AppUser appUser) {
        appUser.setId(id);
        return userdao.save(appUser);
    }

    @GetMapping(path = "/cvs/get/{id}")
    public AppUser get(@PathVariable int id) {
        return userdao.findById(id).get();
    }

    @DeleteMapping(path = "/cvs/delete/{id}")
    public String delete(@PathVariable int id) {
        userdao.deleteById(id);
        return "cv " + id + " supprimé";
    }

    @GetMapping(path = "/cvs/getAll")
    public List<AppUser> getAll() {
        return userdao.findAll();
    }

    @GetMapping(path = "/login")
    public ApiMessage login(@PathParam("email") String email, @PathParam("password") String password) {
        AppUser appUser = userdao.findByEmailAndPassword(email, password);
        //Pour gerer les erreurs
        if (appUser != null) {
            return new ApiMessage("OK", email, appUser.getNom(), appUser.getId());
        } else {
            return new ApiMessage("NOK", email, null,0);
        }
    }
}
