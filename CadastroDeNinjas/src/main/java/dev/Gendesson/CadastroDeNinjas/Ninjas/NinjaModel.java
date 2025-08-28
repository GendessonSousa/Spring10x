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
     private Long id;
     private String nome;
     @Column(unique = true)
     private String email;
     private int idade;

     @ManyToOne
     @JoinColumn(name = "missoes_id") //Foreign key
     private MissoesModel missoes;


}