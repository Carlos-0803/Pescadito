package com.example.Pescadito.Controller;

import com.example.Pescadito.Model.Combinado;
import com.example.Pescadito.Service.CombinadoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/combinado")
public class CombinadoController {
    private final CombinadoService combinadoService;

    public CombinadoController(CombinadoService combinadoService) {
        this.combinadoService = combinadoService;
    }

    @GetMapping
    public List<Combinado> obtenerCombinado() {
        return combinadoService.listarTodas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Combinado>
    obtenerCombinadoPorId(@PathVariable Long id) {
        return combinadoService.buscarPorID(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> crearCombinado(@RequestBody Combinado combinado) {
        if (combinado.getNombre() == null || combinado.getNombre().trim().isEmpty()) {
            return ResponseEntity.badRequest().body("el campo nombre es obligatorio");
        }
        if (combinado.getPrecio() == 0) {
            return ResponseEntity.badRequest().body("el campo precio no debe ser 0");
        }

        if (combinado.getDescripcion() == null) {
            return ResponseEntity.badRequest().body("el campo descripcion es obligatorio");
        }

        return ResponseEntity.ok(combinadoService.crearCombinado(combinado));

    }
    @PutMapping("/{id}")
    public ResponseEntity<Combinado> actualizarCombinado(@PathVariable Long id, @RequestBody Combinado combinado) {
        if (combinadoService.findById(id).isPresent()) {
            return ResponseEntity.ok(combinadoService.actualizarCombinado(id, combinado));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCombinado(@PathVariable Long id) {
        if (combinadoService.findById(id).isPresent()) {
            combinadoService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

}
