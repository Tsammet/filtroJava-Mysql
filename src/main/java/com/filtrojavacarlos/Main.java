package com.filtrojavacarlos;

import java.util.Scanner;

import com.filtrojavacarlos.persona.application.CreatePersonaUseCase;
import com.filtrojavacarlos.persona.infraestructure.PersonaController;
import com.filtrojavacarlos.persona.infraestructure.PersonaRepository;

public class Main {
    public static void main(String[] args) {

        
        Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.println("1. Gestion Personas: ");

            System.out.println("Escoja una opción");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:

                    PersonaRepository personaRepository =new PersonaRepository();
                    CreatePersonaUseCase createPersonaUseCase=new CreatePersonaUseCase(personaRepository);
                    PersonaController personaController = new PersonaController(createPersonaUseCase, scanner);
                    personaController.gestionPersonas();
                    break;
                default:
                    throw new AssertionError();
            }

        }
        

    }
}