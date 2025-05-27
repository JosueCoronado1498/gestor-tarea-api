package com.miapp.gestor_tareas_api.controller;

import com.miapp.gestor_tareas_api.model.Tarea;
import com.miapp.gestor_tareas_api.repository.TareaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tareas")
public class TareaController {

    @Autowired
    private TareaRepository tareaRepository;

    @GetMapping
    public List<Tarea> listar() {
        return tareaRepository.findAll();
    }

    @PostMapping
    public Tarea crear(@RequestBody Tarea tarea) {
        return tareaRepository.save(tarea);
    }

    @PutMapping("/{id}/completar")
    public Tarea marcarComoCompletada(@PathVariable Long id){
        Tarea tarea = tareaRepository.findById(id).orElseThrow();
        tarea.setEstado(true);
        return tareaRepository.save(tarea);
    }


    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        tareaRepository.deleteById(id);
    }


}
