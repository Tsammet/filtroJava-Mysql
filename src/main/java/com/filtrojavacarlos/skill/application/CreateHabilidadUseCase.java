package com.filtrojavacarlos.skill.application;

import com.filtrojavacarlos.skill.domain.entity.Habilidad;
import com.filtrojavacarlos.skill.domain.service.HabilidadService;

public class CreateHabilidadUseCase {

    private final HabilidadService habilidadService;

    public CreateHabilidadUseCase(HabilidadService habilidadService) {
        this.habilidadService = habilidadService;
    }

    public void execute(Habilidad habilidad){
        habilidadService.createHabilidad(habilidad);
    }

}
