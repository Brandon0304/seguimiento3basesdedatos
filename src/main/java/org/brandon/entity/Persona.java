package org.brandon.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "personas")
@EntityListeners(PersonaListener.class)
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String apellido;

    @Column(nullable = false)
    private int edad;

    @Column(nullable = false)
    private int contraseña;

    // Getters y setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad(){return edad;}

    public void setEdad(int edad){this.edad = edad;}

    public int getContraseña(){return contraseña;}

    public void setContraseña(int contraseña){this.contraseña = contraseña;}

    @Override
    public String toString() {
        return "Persona{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido=" + apellido +
                ", edad=" + edad +
                ", contraseña=" + contraseña +
                '}';
    }
}
