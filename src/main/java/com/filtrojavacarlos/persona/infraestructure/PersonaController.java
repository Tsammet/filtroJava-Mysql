
package com.filtrojavacarlos.persona.infraestructure;

import java.util.Scanner;

import com.filtrojavacarlos.persona.application.CreatePersonaUseCase;
import com.filtrojavacarlos.persona.application.DeletePersonaUseCase;
import com.filtrojavacarlos.persona.domain.entity.Persona;

public class PersonaController {

    private final CreatePersonaUseCase createPersonaUseCase;
    private final DeletePersonaUseCase deletePersonaUseCase;

    public PersonaController(CreatePersonaUseCase createPersonaUseCase, DeletePersonaUseCase deletePersonaUseCase) {
        this.createPersonaUseCase = createPersonaUseCase;
        this.deletePersonaUseCase = deletePersonaUseCase;
    }


    Scanner scanner = new Scanner(System.in);

    public void gestionPersonas(){
        while (true) {
            System.out.println("1. Crear Persona");
            System.out.println("2. Eliminar Persona");
            System.out.println("3. Salir");

            System.out.println("Escoja su opción");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    createPersona();
                    break;

                case 2:
                    deletePersona();
                    break;

                case 3:
                    System.out.println("Saliendo...");
                    return;

                default:
                    System.out.println("Escoja una opción valida");
                    break;
            }
        }
    }

    public void createPersona(){

            System.out.println("Cuál es su nombre");
            String nombre = scanner.nextLine();

            System.out.println("Cuál es su apellido: ");
            String apellido = scanner.nextLine();

            System.out.println("Cuál es el id de su ciudad: ");
            int idCiudad = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Cuál es su dirección: ");
            String direccion = scanner.nextLine();

            System.out.println("Cuál es su edad: ");
            int edad = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Cuál es su email: ");
            String email = scanner.nextLine();

            System.out.println("Cuál es su género: ");
            int idgender = scanner.nextInt();
            scanner.nextLine();


            Persona persona = new Persona();
            persona.setName(nombre);
            persona.setLastname(apellido);
            persona.setIdcity(idCiudad);
            persona.setAddress(direccion);
            persona.setAge(edad);
            persona.setEmail(email);
            persona.setIdgender(idgender);

            createPersonaUseCase.execute(persona);

            System.out.println("Persona creada correctamente. ");

    }

    public void deletePersona(){

        System.out.println("Ingrese el id de la persona que desea eliminar: ");
        int idPersona = scanner.nextInt();
        scanner.nextLine();

        deletePersonaUseCase.execute(idPersona);

        System.out.println("Persona eliminada correctamente. ");

    }

    public void updatePersona(){

        System.out.println("Ingrese el id de la persona que desea actualizar: ");
        int idPersona = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Ingrese el nombre de la persona");
        String nombreUpdate = scanner.nextLine();

        System.out.println("Ingrese el apellido de la persona: ");
        String apellidoUpdate = scanner.nextLine();

        System.out.println("Ingrese el id de la ciudad: ");
        int idCiudadUpdate = scanner.nextInt();

        System.out.println("Cuál es la dirección");
        String direccionUpdate = scanner.nextLine();

        System.out.println("Cuál es la edad: ");
        int edadUpdate = scanner.nextInt();

        System.out.println("");

    }

}
