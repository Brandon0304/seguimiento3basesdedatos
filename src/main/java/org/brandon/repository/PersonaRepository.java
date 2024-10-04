package org.brandon.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.brandon.entity.Persona;

import java.util.List;

public class PersonaRepository {

    private final EntityManagerFactory emf;

    public PersonaRepository() {

        emf = Persistence.createEntityManagerFactory("personaPU");
    }

    public void crear(Persona persona) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(persona);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public Persona leer(Long id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Persona.class, id);
        } finally {
            em.close();
        }
    }

    public List<Persona> leerTodos() {
        try (EntityManager em = emf.createEntityManager()) {
            return em.createQuery("SELECT p FROM Persona p", Persona.class)
                    .getResultList();
        }
    }

    public void actualizar(Persona persona) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(persona);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public void eliminar(Long id) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Persona persona = em.find(Persona.class, id);
            if (persona != null) {
                em.remove(persona);
            }
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public void cerrar() {
        emf.close();
    }
}