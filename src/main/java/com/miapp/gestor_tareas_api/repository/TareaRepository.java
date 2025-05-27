package com.miapp.gestor_tareas_api.repository;

import com.miapp.gestor_tareas_api.model.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TareaRepository extends JpaRepository<Tarea, Long> {
}
