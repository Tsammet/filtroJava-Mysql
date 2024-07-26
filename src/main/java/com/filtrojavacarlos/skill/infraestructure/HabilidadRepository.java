package com.filtrojavacarlos.skill.infraestructure;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.filtrojavacarlos.skill.domain.entity.Habilidad;
import com.filtrojavacarlos.skill.domain.service.HabilidadService;

public class HabilidadRepository implements HabilidadService {

        private Connection connection;
        
    public HabilidadRepository(){

        
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
    public void createHabilidad(Habilidad habilidad) {
        
        try{
            String query= "INSERT INTO skill (name) VALUES(?)";
            PreparedStatement ps=connection.prepareStatement(query,
            PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, habilidad.getName());

            ps.executeUpdate();

            try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    habilidad.setId(generatedKeys.getInt(1));
                }
            }
        }catch(SQLException e){
            e.printStackTrace();
            
        }
        

    }


    
}
