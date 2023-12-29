package com.projet.springboot.repository;

import com.projet.springboot.entity.ProjetData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjetDataRepository extends JpaRepository<ProjetData, Long> {
}
