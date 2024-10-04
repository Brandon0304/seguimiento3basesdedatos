package org.brandon;

import com.google.protobuf.Empty;
import org.brandon.entity.Persona;
import org.brandon.service.PersonaService;

import javax.swing.*;
import java.util.List;
import java.util.Scanner;

public class App {
    private static final PersonaService personaService = new PersonaService();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean salir = false;
        int contraseñaprueba = 12345;
        int validacion = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese su contraseña"));
        if (validacion==contraseñaprueba){
            while (!salir) {
                System.out.println("\n--- PERSONAS ---");
                System.out.println("1. Crear persona");
                System.out.println("2. Leer persona");
                System.out.println("3. Actualizar persona");
                System.out.println("4. Eliminar persona");
                System.out.println("5. Listar todas las personas");
                System.out.println("6. Salir");
                System.out.print("Seleccione una opción: ");

                int opcion = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de línea

                switch (opcion) {
                    case 1 -> crearPersona();
                    case 2 -> leerPersona();
                    case 3 -> actualizarPersona();
                    case 4 -> eliminarPersona();
                    case 5 -> listarPersonas();
                    case 6 -> salir = true;
                    default -> System.out.println("Opción no válida");
                }
            }
            personaService.cerrar();
            scanner.close();
        }
    }

    private static void crearPersona() {
        System.out.print("Nombre de la persona: ");
        String nombre = scanner.nextLine();
        System.out.print("Apellido de la persona: ");
        String apellido = scanner.nextLine();
        System.out.println("Edad de la persona: ");
        int edad = scanner.nextInt();
        System.out.println("Contraseña de usuario");
        int contraseña = scanner.nextInt();

        Persona persona = new Persona();
        persona.setNombre(nombre);
        persona.setApellido(apellido);
        persona.setEdad(edad);
        persona.setContraseña(contraseña);

        personaService.crearPersona(persona);
        System.out.println("Persona creada con éxito");
    }

    private static void leerPersona() {
        System.out.print("ID de la persona: ");
        Long id = scanner.nextLong();
        Persona persona = personaService.obtenerPersona(id);
        if (persona != null) {
            System.out.println(persona);
        } else {
            System.out.println("Persona no encontrada");
        }
    }

    private static void actualizarPersona() {
        System.out.print("ID de la persona a actualizar: ");
        Long id = scanner.nextLong();
        scanner.nextLine(); // Consumir el salto de línea

        Persona persona = personaService.obtenerPersona(id);
        if (persona != null) {
            System.out.print("Nuevo nombre (deje en blanco para mantener el actual): ");
            String nombre = scanner.nextLine();
            if (!nombre.isEmpty()) {
                persona.setNombre(nombre);
            }

            System.out.print("Nuevo apellido (deje en blanco para mantener el actual): ");
            String apellido = scanner.nextLine();
            if (!apellido.isEmpty()) {
                persona.setApellido(apellido);
            }

            System.out.print("Nueva edad (0 para mantener la actual): ");
            int edad = scanner.nextInt();
            if (edad!= 0) {
                persona.setEdad(edad);
            }

            System.out.println("Nueva contraseña (0 para mantener la actual):");
            int contraseñanueva = scanner.nextInt();
            if (contraseñanueva!=persona.getContraseña()){
                persona.setContraseña(contraseñanueva);
            }else{
                System.out.println("La nueva contraseña no puede ser igual a la anterior");
            }

            personaService.actualizarPersona(persona);
            System.out.println("Persona actualizada con éxito");
        } else {
            System.out.println("Persona no encontrada");
        }
    }

    private static void eliminarPersona() {
        System.out.print("ID de la persona a eliminar: ");
        Long id = scanner.nextLong();
        personaService.eliminarPersona(id);
        System.out.println("Persona eliminada con éxito");
    }

    private static void listarPersonas() {
        List<Persona> personas = personaService.obtenerTodasLasPersonas();
        if (personas.isEmpty()) {
            System.out.println("No hay personas registrados");
        } else {
            for (Persona persona : personas) {
                System.out.println(persona);
            }
        }
    }
}