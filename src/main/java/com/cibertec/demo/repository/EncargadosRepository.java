package com.cibertec.demo.repository;

import com.cibertec.demo.model.Encargado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EncargadosRepository extends JpaRepository <Encargado, Long> {
}
