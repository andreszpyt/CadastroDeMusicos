package com.CadastroDeMusicos.Orquestra.Musicos;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MusicoRepository extends JpaRepository<MusicoModel, Long> {
}