package org.example.Desenvolvedor;

import jakarta.persistence.*;
import org.example.Atualização.AtualizacaoModel;
import org.example.Chamado.ChamadoModel;

import java.util.List;

@Entity
@Table(name = "Desenvolvedor")
public class DesenvolvedorModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Dev")
    private Integer id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String email;

    @OneToMany(mappedBy = "desenvolvedor")
    private List<ChamadoModel> chamados;

    @OneToMany(mappedBy = "desenvolvedor")
    private List<AtualizacaoModel> atualizacoes;

    // Getters e Setters
}
