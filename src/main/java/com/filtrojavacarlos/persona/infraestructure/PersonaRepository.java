package com.filtrojavacarlos.persona.infraestructure;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.filtrojavacarlos.persona.domain.entity.Persona;
import com.filtrojavacarlos.persona.domain.service.personaService;



public class PersonaRepository implements personaService{
    private Connection connection;

    public PersonaRepository() {
        try {
            Properties props = new Properties();
            props.load(getClass().getClassLoader().getResourceAsStream("dbconfig.properties"));
            String url = props.getProperty("url");
            String user = props.getProperty("user");
            String password = props.getProperty("password");

            System.out.println("URL: " + url);
            System.out.println("User: " + user);
        
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Conexión exitosa!");
            
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void createPersona(Persona persona) {
        
        try{
            String query= "INSERT INTO persons (name, lastname, idcity, address, age, email, idgender) VALUES(?,?,?,?,?,?,?)";
            PreparedStatement ps=connection.prepareStatement(query,
            PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, persona.getName());
            ps.setString(2, persona.getLastname());
            ps.setInt(3, persona.getIdcity());
            ps.setString(4, persona.getAddress());
            ps.setInt(5, persona.getAge());
            ps.setString(6, persona.getEmail());
            ps.setInt(7, persona.getIdgender());

            ps.executeUpdate();

            try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    persona.setId(generatedKeys.getInt(1));
                }
            }
        }catch(SQLException e){
            e.printStackTrace();

        }


    }

}
