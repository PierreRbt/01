package com.projet.springboot.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "projet_recentchange")
@Getter
@Setter
public class ProjetData {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;
    @Lob
    private String projetEventData;

    public void setProjetEventData(String eventMessage) {
    }
}
