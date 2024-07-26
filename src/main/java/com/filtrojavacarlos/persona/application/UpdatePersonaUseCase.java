package com.filtrojavacarlos.persona.application;

import com.filtrojavacarlos.persona.domain.entity.Persona;
import com.filtrojavacarlos.persona.domain.service.personaService;

public class UpdatePersonaUseCase {


    private final personaService personaService;

    public UpdatePersonaUseCase(personaService personaService) {
        this.personaService = personaService;
    }

    public void execute(Persona persona){
        personaService.updatePersona(persona);
    }


}
