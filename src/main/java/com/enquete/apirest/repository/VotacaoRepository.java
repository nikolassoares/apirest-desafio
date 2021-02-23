package com.enquete.apirest.repository;

import com.enquete.apirest.models.Votacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VotacaoRepository extends JpaRepository<Votacao, Long> {
    Votacao findById(long id);
}
