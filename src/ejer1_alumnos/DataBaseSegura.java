/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejer1_alumnos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Usuario
 */
public class DataBaseSegura extends DataBase {
    
    public DataBaseSegura(String bd, String login, String password, String servidorMysql) {
        super(bd, login, password, servidorMysql);
    }
    @Override
    public boolean buscaRegistro(String nombreBuscar) {
        ResultSet rs;
        PreparedStatement st;
        //Sustituimos la variable por un ?
        String sentencia = "SELECT * from alumnos where nombre= ?";
        System.out.println(sentencia);
        try {
            st = conexion.prepareStatement(sentencia);
            //Pasamos los valores a cada uno de los interrogantes
            //comenzamos numerando por el 
            st.setString(1, nombreBuscar);
            //st.setInt(1, 20);
            rs = st.executeQuery();
            if (rs.isBeforeFirst()) {
                VentanaListado vL = new VentanaListado(rs);
            }else{
                return false;
            }
        }catch (SQLException ex) {
            System.out.println("Error con la base de datos: " + ex.getMessage());
        }
        return true;
    }
}
