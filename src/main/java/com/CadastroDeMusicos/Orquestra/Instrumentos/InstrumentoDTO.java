package com.CadastroDeMusicos.Orquestra.Instrumentos;

import com.CadastroDeMusicos.Orquestra.Musicos.MusicoModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InstrumentoDTO {
    private long id;
    private String nome;
}
