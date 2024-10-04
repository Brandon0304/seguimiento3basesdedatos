package org.brandon.service;

import org.brandon.entity.Persona;
import org.brandon.repository.PersonaRepository;

import java.util.List;

public class PersonaService {

    private final PersonaRepository repository;

    public PersonaService() {
        this.repository = new PersonaRepository();
    }

    public void crearPersona(Persona persona) {
        repository.crear(persona);
    }

    public Persona obtenerPersona(Long id) {
        return repository.leer(id);
    }

    public List<Persona> obtenerTodasLasPersonas() {
        return repository.leerTodos();
    }

    public void actualizarPersona(Persona persona) {
        repository.actualizar(persona);
    }

    public void eliminarPersona(Long id) {
        repository.eliminar(id);
    }

    public void cerrar() {
        repository.cerrar();
    }
}
