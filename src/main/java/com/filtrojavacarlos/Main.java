package com.filtrojavacarlos;

import java.util.Scanner;

import com.filtrojavacarlos.persona.application.CreatePersonaUseCase;
import com.filtrojavacarlos.persona.application.DeletePersonaUseCase;
import com.filtrojavacarlos.persona.application.UpdatePersonaUseCase;
import com.filtrojavacarlos.persona.infraestructure.PersonaController;
import com.filtrojavacarlos.persona.infraestructure.PersonaRepository;
import com.filtrojavacarlos.skill.application.CreateHabilidadUseCase;
import com.filtrojavacarlos.skill.infraestructure.HabilidadController;
import com.filtrojavacarlos.skill.infraestructure.HabilidadRepository;

public class Main {
    public static void main(String[] args) {

        
        Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.println("1. Gestion Personas: ");
            System.out.println("2. Gestion habilidades: ");
            System.out.println("Escoja una opción");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:

                    PersonaRepository personaRepository =new PersonaRepository();
                    CreatePersonaUseCase createPersonaUseCase=new CreatePersonaUseCase(personaRepository);
                    DeletePersonaUseCase deletePersonaUseCase = new DeletePersonaUseCase(personaRepository);
                    UpdatePersonaUseCase updatePersonaUseCase = new UpdatePersonaUseCase(personaRepository);
                    PersonaController personaController = new PersonaController(createPersonaUseCase, deletePersonaUseCase, updatePersonaUseCase);
                    personaController.gestionPersonas();
                    break;
                
                case 2:
                    
                    HabilidadRepository habilidadRepository =new HabilidadRepository();
                    CreateHabilidadUseCase createHabilidadUseCase=new CreateHabilidadUseCase(habilidadRepository);
                    HabilidadController habilidadController = new HabilidadController(createHabilidadUseCase);
                    habilidadController.gestionHabilidades();

                default:
                    throw new AssertionError();
            }

        }
        

    }
}