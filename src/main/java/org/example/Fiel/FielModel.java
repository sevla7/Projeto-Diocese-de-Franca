package org.example.Fiel;
import jakarta.persistence.*;
import org.example.Chamado.ChamadoModel;

import java.util.List;

@Entity
@Table (name= "Fiel")
public class FielModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Fiel")
    private Integer ID_Fiel;

    @Column(name = "Nome", length = 150, nullable = true)
    private String nome;

    @Column(name = "Email", length = 150, nullable = true, unique = true)
    private String email;

    @Column(name = "Paróquia", length = 100)
    private String paroquia;

    @Column(name = "Senha", columnDefinition = "text", nullable = true, unique = true)
    private String senha;


    public Integer getID_Fiel() {
        return ID_Fiel;
    }
    public void setID_Fiel(Integer idFiel) {
        this.ID_Fiel = idFiel;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getParoquia() {
        return paroquia;
    }

    public void setParoquia(String paroquia) {
        this.paroquia = paroquia;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @OneToMany(mappedBy = "fiel")
    private List<ChamadoModel> chamados;

}

