package com.filtrojavacarlos.skill.infraestructure;

import java.util.Scanner;

import com.filtrojavacarlos.skill.application.CreateHabilidadUseCase;
import com.filtrojavacarlos.skill.domain.entity.Habilidad;

public class HabilidadController {

    private final CreateHabilidadUseCase createHabilidadUseCase;

    public HabilidadController(CreateHabilidadUseCase createHabilidadUseCase){
        this.createHabilidadUseCase = createHabilidadUseCase;
    }

        Scanner scanner = new Scanner(System.in);

        public void gestionHabilidades(){
            while (true) {
                System.out.println("1. Crear Habilidad");
                System.out.println("2. Salir");
    
                System.out.println("Escoja su opción");
                int opcion = scanner.nextInt();
                scanner.nextLine();
    
                switch (opcion) {
                    case 1:
                        createHabilidad();
                        break;

    
                    case 2:
                        System.out.println("Saliendo...");
                        return;
    
                    default:
                        System.out.println("Escoja una opción valida");
                        break;
                }
            }
        }
    
    public void createHabilidad(){
        System.out.println("Ingrese el nombre de la habilidad");
        String nombre = scanner.nextLine();

        Habilidad habilidad = new Habilidad();
        habilidad.setName(nombre);

        createHabilidadUseCase.execute(habilidad);
        
        System.out.println("Habilidad creada correctamente");
    }

}
