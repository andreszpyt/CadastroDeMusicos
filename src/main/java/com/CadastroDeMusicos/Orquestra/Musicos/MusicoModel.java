package com.CadastroDeMusicos.Orquestra.Musicos;

import com.CadastroDeMusicos.Orquestra.Instrumentos.InstrumentoModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "instrumento")
@Table(name = "tb_musicos")
public class MusicoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String comum;
    private int idade;
    @ManyToOne
    @JoinColumn(name = "instrumento_id")
    private InstrumentoModel instrumento;
}