package DAO;

import Controller.ConexionBD;
import VO.PersonaVO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PersonaDAO {

    public boolean NuevaPersona(PersonaVO persona) {

        StringBuilder sql = new StringBuilder();
        ConexionBD con = new ConexionBD();
        con.ConexionBD();

        System.out.println(persona.getPERS_NUMDOC() + "NUM DOCUMENTO");

        sql.append("INSERT INTO persona (");
        sql.append("PERS_ID,PERS_NUMDOC,PERS_TIPODOC,PERS_PRINOMBRE,PERS_SEGNOMBRE,PERS_PRIAPELLIDO,PERS_SEGAPELLIDO,PERS_USERNAME,PERS_PASSWORD)");
        sql.append(" VALUES ('");
        sql.append(persona.getPERS_ID());
        sql.append("','");
        sql.append(persona.getPERS_NUMDOC());
        sql.append("','");
        sql.append(persona.getPERS_TIPODOC());
        sql.append("','");
        sql.append(persona.getPERS_PRINOMBRE());
        sql.append("','");
        sql.append(persona.getPERS_SEGNOMBRE());
        sql.append("','");
        sql.append(persona.getPERS_PRIAPELLIDO());
        sql.append("','");
        sql.append(persona.getPERS_SEGAPELLIDO());
        sql.append("','");
        sql.append(persona.getPERS_USERNAME());
        sql.append("','");
        sql.append(persona.getPERS_PASSWORD());
        sql.append("')");
        System.out.println(sql.toString());
        con.ingresarDatos(sql.toString());

        return true;
    }

    public boolean llavesPrimarias(String PERS_ID) throws SQLException {

        ConexionBD con = new ConexionBD();
        boolean estado = false;
        con.ConexionBD();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT PERS_ID FROM PERSONA WHERE PERS_ID = '");
        sql.append(PERS_ID);
        sql.append("'");

        ResultSet rs = con.obtenerDatos(sql.toString());

        while (rs.next()) {
            if (rs.getString("PERS_ID") != null) {
                System.out.println(rs.getString("PERS_ID") + " NO ES NULO");
                estado = true;
            }

        }

        con.close();
        return estado;
    }

    public String obtenerIdPersona(PersonaVO lo) throws SQLException {
        String PERS_ID = "";

        String sql = "";

        ConexionBD cn = new ConexionBD();
        cn.ConexionBD();

        sql = "SELECT * FROM PERSONA WHERE PERS_USERNAME='" + lo.getPERS_USERNAME() + "' AND PERS_PASSWORD='" + lo.getPERS_PASSWORD() + "' ";
        ResultSet rs = cn.obtenerDatos(sql);
        System.out.println("CONSULTA: " + sql);
        while (rs.next()) {

            if (rs.getString("PERS_USERNAME").equals(lo.getPERS_USERNAME())) {

                if (rs.getString("PERS_PASSWORD").equals(lo.getPERS_PASSWORD())) {

                    PERS_ID = rs.getString("PERS_ID");
                }

            }

        }
        return PERS_ID;
    }
    
     public String obtenerNombre(String PERS_ID) throws SQLException {
        String NOMBRE = "";

        String sql = "";

        ConexionBD cn = new ConexionBD();
        cn.ConexionBD();

        sql = "SELECT * FROM PERSONA WHERE PERS_ID ='"+PERS_ID+"'  ";
        ResultSet rs = cn.obtenerDatos(sql);

        while (rs.next()) {


                    NOMBRE = rs.getString("PERS_PRINOMBRE")+" "+
                            rs.getString("PERS_SEGNOMBRE")+" "+
                            rs.getString("PERS_PRIAPELLIDO")+" "+
                            rs.getString("PERS_SEGAPELLIDO");
                }

            
      return NOMBRE;
        }
  
    }


