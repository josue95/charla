package ejer1_alumnos;

public class Ejer1_Alumnos {

    public static void main(String[] args) {
        String servidor = "jdbc:mysql://localhost/";
        String bd = "Acme";
        String user = "user";
        String password = "1234";
        DataBase db = new DataBaseSegura(bd, user, password, servidor);
        if (db.abrirConexion()) {
            Ventana v=new Ventana(db);
        }
    }

}
