package com.example.suporteoperacional.service;

import com.example.suporteoperacional.model.Equipamento;
import com.example.suporteoperacional.repository.EquipamentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquipamentoService {

    private final EquipamentoRepository repository;

    public EquipamentoService(EquipamentoRepository repository) {
        this.repository = repository;
    }

    public List<Equipamento> listarEquipamentos() {
        return repository.findAll();
    }

    public Equipamento salvarEquipamento(Equipamento equipamento) {
        return repository.save(equipamento);
    }

    public Optional<Equipamento> obterEquipamentoPorId(Long id) {
        return repository.findById(id);
    }

    public List<Equipamento> buscarPorTipo(String tipoEquipamento) {
        return repository.findByTipoEquipamento(tipoEquipamento);
    }
}
