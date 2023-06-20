package com.groupeisi.examen_java.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
@Entity
@Table(name = "cvs")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AppUser implements Serializable {
    @Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
    @Column(length = 100, nullable = false)
    private String nom;
    @Column(length = 150, nullable = false)
    private String prenom;
    @Column(length = 150, nullable = false)
    private String age;
    @Column(length = 150, nullable = false)
    private String adresse;
    @Column(length = 100, nullable = false)
    private String email;
    @Column(length = 150, nullable = false)
    private String telephone;
    @Column(length = 150, nullable = false)
    private String specialite;
    @Column(length = 150, nullable = false)
    private String niveauEtude;
    @Column(length = 150, nullable = false)
    private String experiencePro ;
    @Column(length = 200, nullable = false)
    private String password;
}
