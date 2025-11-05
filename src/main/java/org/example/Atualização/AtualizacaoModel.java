package org.example.Atualização;

import jakarta.persistence.*;
import org.example.Categoria.CategoriaModel;
import org.example.Chamado.ChamadoModel;
import org.example.Desenvolvedor.DesenvolvedorModel;
import org.example.Fiel.FielModel;

import java.time.LocalDate;

@Entity
@Table(name = "Atualização")
public class AtualizacaoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Atualizacao")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "ID_Dev_FK")
    private DesenvolvedorModel desenvolvedor;

    @ManyToOne
    @JoinColumn(name = "ID_Fiel_FK")
    private FielModel fiel;

    @ManyToOne
    @JoinColumn(name = "ID_Categoria_FK")
    private CategoriaModel categoria;

    @ManyToOne
    @JoinColumn(name = "ID_Chamado_FK")
    private ChamadoModel chamado;

    @Column(nullable = false)
    private String descricao;

    @Column(name = "Data_Fechamento")
    private LocalDate dataFechamento;

    // Getters e Setters
}
