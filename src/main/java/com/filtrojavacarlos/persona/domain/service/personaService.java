package com.filtrojavacarlos.persona.domain.service;

import com.filtrojavacarlos.persona.domain.entity.Persona;

public interface personaService {

    void createPersona(Persona persona);
    Persona deletePersona(int id);
    // void deletePersona(Persona persona);
}
