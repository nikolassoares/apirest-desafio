package com.enquete.apirest.repository;

import com.enquete.apirest.models.Voto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface VotoRepository extends JpaRepository<Voto, Long>{
    @Query("SELECT v FROM Voto v WHERE v.id = ?1")
    Voto buscarAssociado(long id );
}
