package com.example.suporteoperacional.controller;

import com.example.suporteoperacional.model.Equipamento;
import com.example.suporteoperacional.service.EquipamentoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/equipamentos")
public class EquipamentoController {

    private final EquipamentoService service;

    public EquipamentoController(EquipamentoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Equipamento> listarEquipamentos() {
        return service.listarEquipamentos();
    }

    @PostMapping
    public ResponseEntity<Equipamento> salvarEquipamento(@RequestBody Equipamento equipamento) {
        Equipamento salvo = service.salvarEquipamento(equipamento);
        return ResponseEntity.ok(salvo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Equipamento> obterEquipamento(@PathVariable Long id) {
        return service.obterEquipamentoPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/tipo/{tipoEquipamento}")
    public List<Equipamento> buscarPorTipo(@PathVariable String tipoEquipamento) {
        return service.buscarPorTipo(tipoEquipamento);
    }
}
