package com.example.jan.repository;


import com.example.jan.model.Delegate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface DelegateRepository extends JpaRepository<Delegate, Long> {
    boolean existsByRequisiteAndDtBegAndDtEnd(String requisite, LocalDate dtBeg, LocalDate dtEnd);
}

