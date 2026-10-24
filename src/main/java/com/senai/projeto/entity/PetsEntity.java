package com.senai.projeto.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tab_pets")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PetsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String especie;
    private String raca;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private ClienteEntity cliente;


}
