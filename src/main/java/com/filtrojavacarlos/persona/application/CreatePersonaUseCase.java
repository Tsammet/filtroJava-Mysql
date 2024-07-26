package com.filtrojavacarlos.persona.application;

import com.filtrojavacarlos.persona.domain.entity.Persona;
import com.filtrojavacarlos.persona.domain.service.personaService;



public class CreatePersonaUseCase {

    private final personaService personaService;

    public CreatePersonaUseCase(personaService personaService) {
        this.personaService = personaService;
    }

    public void execute(Persona persona){
        personaService.createPersona(persona);
    }

}
