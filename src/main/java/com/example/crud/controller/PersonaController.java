package com.example.crud.controller;

import java.util.List;
import com.example.crud.model.Persona;
import com.example.crud.repository.PersonaRepository;
import org.springframework.web.bind.annotation.*;

@RestController // Para comunicar a través de protocolo HTTP
@RequestMapping("/api/personas") // Para indicar cual es la ruta de la API
@CrossOrigin("*") //Permitir llamadas desde frontend al backend
public class PersonaController {
    private final  PersonaRepository repo;
    // Constructor para poder trabajar con el repositorio
    public PersonaController(PersonaRepository repo) {
        this.repo = repo;
    }

    //LISTAR
    @GetMapping
    public List<Persona> Listar(){
        return repo.findAll();
    }

    //GUARDAR
    @PostMapping
    public Persona guardar(@RequestBody Persona persona){
        return repo.save(persona);
    }

    //ELIMINAR
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id){
        repo.deleteById(id);
    }

}
