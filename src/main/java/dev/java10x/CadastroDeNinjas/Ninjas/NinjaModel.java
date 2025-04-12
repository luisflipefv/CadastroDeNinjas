package dev.java10x.CadastroDeNinjas.Ninjas;

import dev.java10x.CadastroDeNinjas.Missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

//o entity transforma uma classe em uma entidade no banco de dados
@Entity
@Table(name = "tb_cadastro")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NinjaModel {

    //vai usar o proximo atributo para gerar os IDs
    @Id
    //essa é a estratégia usada para gerar os números dos IDs
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @Column(unique = true)
    private String email;
    private int idade;

    //@ManyToOne um ninja tem apenas uma missao
    @ManyToOne
    @JoinColumn(name = "missoes_id") //Essa é a chave estrangeira(ou Foreign Key)
    private MissoesModel missoes;
}
