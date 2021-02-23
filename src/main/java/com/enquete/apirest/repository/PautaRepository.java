package com.enquete.apirest.repository;

import com.enquete.apirest.models.Pauta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PautaRepository extends JpaRepository<Pauta, Long> {
    Pauta findById(long id);
}
