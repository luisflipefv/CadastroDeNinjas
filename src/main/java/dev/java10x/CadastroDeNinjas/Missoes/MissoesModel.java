package dev.java10x.CadastroDeNinjas.Missoes;

import dev.java10x.CadastroDeNinjas.Ninjas.NinjaModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tb_missoes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MissoesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nomeMissao;
    private String rank;

    //@OneToMany Uma missão pode ter mais de um ninja
    @OneToMany(mappedBy = "missoes")
    private List <NinjaModel> ninjas;

}
