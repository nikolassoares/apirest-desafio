package com.enquete.apirest.repository;

import com.enquete.apirest.models.Associado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssociadoRepository extends JpaRepository<Associado, Long> {
    Associado findById(long id);
}
