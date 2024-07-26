package com.filtrojavacarlos.person_skill.infraestructure;

import java.util.Scanner;

import com.filtrojavacarlos.person_skill.application.AssignHabilidadUseCase;
import com.filtrojavacarlos.person_skill.domain.entity.PersonSkill;

public class PersonSkillController {

    private final AssignHabilidadUseCase assignHabilidadUseCase;

    public PersonSkillController(AssignHabilidadUseCase assignHabilidadUseCase){
        this.assignHabilidadUseCase = assignHabilidadUseCase;
    }

        Scanner scanner = new Scanner(System.in);


    
    public void assignHabilidad(){
        System.out.println("Ingrese la fecha : (YYYY-MM-DD) ");
        String fecha = scanner.nextLine();

        System.out.println("Ingrese el id de la persona :");
        int idPersona = scanner.nextInt();
        scanner.nextLine();

        System.out.println("INgrese el id de la skill: ");
        int idSkill = scanner.nextInt();
        scanner.nextLine();

        PersonSkill personSkill = new PersonSkill();
        personSkill.setRegistrationDate(fecha);
        personSkill.setIdPerson(idPersona);
        personSkill.setIdSkill(idSkill);

        assignHabilidadUseCase.execute(personSkill);
        
        System.out.println("Habilidad asignada correctamente");
    }
}
