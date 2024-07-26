package com.filtrojavacarlos.persona.application;

import com.filtrojavacarlos.persona.domain.service.personaService;

public class DeletePersonaUseCase {


    private personaService personaService;

    public DeletePersonaUseCase(personaService personaService) {
        this.personaService = personaService;
    }

    public void execute(int id){
        personaService.deletePersona(id);
    }

}
