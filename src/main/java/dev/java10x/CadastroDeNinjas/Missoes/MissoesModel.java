package dev.java10x.CadastroDeNinjas.Missoes;

import dev.java10x.CadastroDeNinjas.Ninjas.NinjaModel;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_missoes")
public class MissoesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nomeMissao;
    private String rank;

    //@OneToMany Uma missão pode ter mais de um ninja
    @OneToMany(mappedBy = "missoes")
    private List <NinjaModel> ninjas;

    public MissoesModel() {
    }

    public MissoesModel(String nomeMissao, String rank) {
        this.nomeMissao = nomeMissao;
        this.rank = rank;
    }

    public String getNomeMissao() {
        return nomeMissao;
    }

    public void setNomeMissao(String nomeMissao) {
        this.nomeMissao = nomeMissao;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }


}
