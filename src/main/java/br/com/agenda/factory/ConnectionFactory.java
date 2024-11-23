package br.com.agenda.factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
    //USUARIO DO BANCO DE DADOS
    private static final String USER = "root";

    //SENHA DO BANCO DE DADOS
    private static final String PASSWORD = "";

    private static final String URL = "jdbc:mysql://localhost:3306/agenda";

    public  static Connection createConnection () throws Exception{
        //VAI RENDERIZAR A CLASSE
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
        return connection;
    }

    public static void main(String[] args) throws Exception {
        Connection con = createConnection();

        if (con != null) {
            System.out.println("Conexão obtida com sucesso!");
            con.close();
        }
    }
}



