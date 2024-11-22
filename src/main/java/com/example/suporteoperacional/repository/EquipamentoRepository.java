package com.example.suporteoperacional.repository;

import com.example.suporteoperacional.model.Equipamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EquipamentoRepository extends JpaRepository<Equipamento, Long> {
    List<Equipamento> findByTipoEquipamento(String tipoEquipamento);
}
