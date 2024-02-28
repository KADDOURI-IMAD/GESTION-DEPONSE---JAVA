/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gidsys.frame;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author LENOVO
 */
public class ConnectionDB {
     Connection conn = null;
  public static Connection Conexion(){     
    try{
    
      Class.forName("com.mysql.cj.jdbc.Driver");
      Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/gid_system","root","");
      if(conn != null)
          System.out.println("Connexion à la base de données a été établie avec succès");
      else
          System.out.println("Problème de connexion à la base");
      return conn;
    }catch(Exception e){
          System.out.println("--> SQLException : "+e);
          return null;
    }
}
}
