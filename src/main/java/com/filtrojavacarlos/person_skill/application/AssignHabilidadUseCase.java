package com.filtrojavacarlos.person_skill.application;

import com.filtrojavacarlos.person_skill.domain.entity.PersonSkill;
import com.filtrojavacarlos.person_skill.domain.service.Person_skillService;

public class AssignHabilidadUseCase {

    private final Person_skillService person_skillService;

    public AssignHabilidadUseCase(Person_skillService person_skillService) {
        this.person_skillService = person_skillService;
    }

    public void execute(PersonSkill personSkill){
        person_skillService.assignHabilidad(personSkill);
    }

}
