package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Conexao {
    private static final String banco = "jdbc:mysql://localhost/sca";
        private static final String driver = "com.mysql.jdbc.Driver";
        private static final String usuario = "root";
        private static final String senha = "";

        private static Connection con = null;
    
        public static java.sql.Connection getConexao(){
                // primeiro testo se o objeto con não foi inicializado
                if (con == null){
                    try {
                        // defino a classe do driver a ser usado
                        Class.forName(driver);
                        // criação da conexão com o BD
                        con = DriverManager.getConnection(banco, usuario, senha);
                    } catch (ClassNotFoundException ex) {
                        System.out.println("Não encontrou o driver");
                    } catch (SQLException ex) {
                        System.out.println("Erro ao conectar: "+ ex.getMessage());
                    }
                }
                return con;
         }
        public static PreparedStatement getPreparedStatement(String sql){
                // testo se a conexão já foi criada
                if (con == null){
                    // cria a conexão
                    con = getConexao();
                }
                try {
                    // retorna um objeto java.sql.PreparedStatement
                    return con.prepareStatement(sql);
                } catch (SQLException e){
                    System.out.println("Erro de sql: "+ e.getMessage());
                }
                return null;
          }

}
