package com.test.demo.repositories;

import com.test.demo.model.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProyectoRepository extends JpaRepository<Proyecto,Long> {
}
