package org.brandon.entity;

import jakarta.persistence.*;

public class PersonaListener {

    @PrePersist
    public void prePersist(Persona persona) {
        System.out.println("Persona a ser persistida: " + persona);
    }

    @PostPersist
    public void postPersist(Persona persona) {
        System.out.println("Persona persistida: " + persona);
    }

    @PreUpdate
    public void preUpdate(Persona persona) {
        System.out.println("Persona a ser actualizada: " + persona);
    }

    @PostUpdate
    public void postUpdate(Persona persona) {
        System.out.println("Persona actualizada: " + persona);
    }

    @PreRemove
    public void preRemove(Persona persona) {
        System.out.println("Persona a ser eliminada: " + persona);
    }

    @PostRemove
    public void postRemove(Persona persona) {
        System.out.println("Persona eliminada: " + persona);
    }
}
