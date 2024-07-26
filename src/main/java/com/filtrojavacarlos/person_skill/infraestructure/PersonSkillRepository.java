package com.filtrojavacarlos.person_skill.infraestructure;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.filtrojavacarlos.person_skill.domain.entity.PersonSkill;
import com.filtrojavacarlos.person_skill.domain.service.Person_skillService;

public class PersonSkillRepository implements  Person_skillService{

    private Connection connection;
        
    public PersonSkillRepository(){
        
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
    public void assignHabilidad(PersonSkill personSkill) {
        
        try{
            String query= "INSERT INTO persons_skill (registration_date, idperson, idskill) VALUES(?, ? , ?)";
            PreparedStatement ps=connection.prepareStatement(query,
            PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, personSkill.getRegistrationDate());
            ps.setInt(2, personSkill.getIdPerson());
            ps.setInt(3, personSkill.getIdSkill());

            ps.executeUpdate();

            try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    personSkill.setId(generatedKeys.getInt(1));
                }
            }
        }catch(SQLException e){
            e.printStackTrace();
            
        }
        

    }


}
