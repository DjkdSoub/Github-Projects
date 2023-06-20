package com.groupeisi.examen_java.dao;

import com.groupeisi.examen_java.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAppUser extends JpaRepository<AppUser,Integer> {
    public AppUser findByEmailAndPassword(String email, String password);
}
