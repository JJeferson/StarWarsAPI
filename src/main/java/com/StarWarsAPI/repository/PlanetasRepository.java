package com.StarWarsAPI.repository;

import com.StarWarsAPI.models.Planetas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PlanetasRepository extends JpaRepository<Planetas,Long> {
    Planetas findById(long id);

    @Query("select p from Planetas p where p.nome like %:Nome%")
    public List<Planetas> findByNome(String Nome);

}
