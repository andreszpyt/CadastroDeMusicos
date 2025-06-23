package com.CadastroDeMusicos.Orquestra.Instrumentos;

import com.CadastroDeMusicos.Orquestra.Musicos.MusicoModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_instrumentos")
public class InstrumentoModel {
    @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    @OneToMany(mappedBy = "instrumento")
    List<MusicoModel> musico;
}
