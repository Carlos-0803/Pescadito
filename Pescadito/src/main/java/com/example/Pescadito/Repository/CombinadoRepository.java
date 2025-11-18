package com.example.Pescadito.Repository;

import com.example.Pescadito.Model.Combinado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CombinadoRepository extends JpaRepository<Combinado, Long> {
}
