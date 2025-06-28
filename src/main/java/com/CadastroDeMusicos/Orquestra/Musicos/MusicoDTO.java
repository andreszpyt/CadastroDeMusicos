package com.CadastroDeMusicos.Orquestra.Musicos;

import com.CadastroDeMusicos.Orquestra.Instrumentos.InstrumentoModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class MusicoDTO {

    private long id;
    private String nome;
    private String comum;
    private int idade;
    private InstrumentoModel instrumento;

}
