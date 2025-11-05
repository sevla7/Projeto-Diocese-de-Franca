package org.example.Categoria;

import jakarta.persistence.*;
import org.example.Chamado.ChamadoModel;

import java.util.List;

@Entity
@Table(name = "Categoria")
public class CategoriaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Categoria")
    private Integer id;

    @Column(name = "Nome_Categoria", nullable = false, unique = true)
    private String nomeCategoria;

    @OneToMany(mappedBy = "categoria")
    private List<ChamadoModel> chamados;

    // Getters e Setters
}
