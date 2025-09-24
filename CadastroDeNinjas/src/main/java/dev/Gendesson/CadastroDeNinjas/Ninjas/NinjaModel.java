package dev.Gendesson.CadastroDeNinjas.Ninjas;

import dev.Gendesson.CadastroDeNinjas.Missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tb_cadastro")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
     private Long id;
    @Column(name = "nome")
     private String nome;
     @Column(unique = true)
     private String email;
     @Column(name = "idade")
     private int idade;
     @Column(name = "img_url")
     private String imgUrl;

     @ManyToOne
     @JoinColumn(name = "missoes_id") //Foreign key
     private MissoesModel missoes;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
}