package com.test.demo.repositories;

import com.test.demo.model.Experiencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperienciaRepository extends JpaRepository <Experiencia, Long> {
}
