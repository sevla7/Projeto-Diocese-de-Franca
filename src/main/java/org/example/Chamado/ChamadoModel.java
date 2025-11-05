package org.example.Chamado;

import jakarta.persistence.*;
import org.example.Atualização.AtualizacaoModel;
import org.example.Categoria.CategoriaModel;
import org.example.Desenvolvedor.DesenvolvedorModel;
import org.example.Fiel.FielModel;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Chamado")
public class ChamadoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Chamado")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "ID_Fiel_FK")
    private FielModel fiel;

    @ManyToOne
    @JoinColumn(name = "ID_Dev_FK")
    private DesenvolvedorModel desenvolvedor;

    @ManyToOne
    @JoinColumn(name = "ID_Categoria_FK")
    private CategoriaModel categoria;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    private String descricao;

    private String status;
    private String prioridade;

    @Column(name = "Data_Abertura")
    private LocalDate dataAbertura;

    @OneToMany(mappedBy = "chamado")
    private List<AtualizacaoModel> atualizacoes;

    // Getters e Setters
}
