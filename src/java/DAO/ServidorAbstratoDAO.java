package DAO;

import static DAO.Conexao.getPreparedStatement;
import modelo.Servidor;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Servidor;
import modelo.Operador;
import modelo.ServidorAbstrato;

public class ServidorAbstratoDAO {

    public ServidorAbstratoDAO() {
    }

    public boolean Inserir(ServidorAbstrato servidor) {
        Boolean retorno = false;
        String sql = "INSERT INTO servidor (siape,nome,senha,funcao,classe) VALUES (?,?,?,?,?)";
        PreparedStatement prepara = getPreparedStatement(sql);
        try {
            prepara.setString(1, servidor.getSiape());
            prepara.setString(2, servidor.getNome());
            prepara.setString(3, servidor.getSenha());
            prepara.setString(4, servidor.getFuncao());
            if (servidor instanceof Servidor) {
                prepara.setString(5, "servidor");
            } else {
                prepara.setString(5, "operador");
            }
            if (prepara.executeUpdate() > 0) {
                retorno = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServidorAbstratoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

    public List<ServidorAbstrato> Listar() {
        String sql = "select * from servidor";
        List<ServidorAbstrato> lista;
        lista = new ArrayList<ServidorAbstrato>();
        PreparedStatement prepara = getPreparedStatement(sql);
        try {
            ResultSet rs = prepara.executeQuery();
            while (rs.next()) {
                ServidorAbstrato servidor = null;
                switch (rs.getString("classe")) {
                    case "servidor":
                        servidor = new Servidor();
                        break;
                    case "operador":
                        servidor = new Operador();
                        break;
                }
                servidor.setSiape(rs.getString("siape"));
                servidor.setNome(rs.getString("nome"));
                servidor.setSenha(rs.getString("senha"));
                servidor.setFuncao(rs.getString("funcao"));
                lista.add(servidor);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ServidorAbstratoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public boolean Excluir(ServidorAbstrato servidor) {
        Boolean retorno = false;
        String sql = "DELETE from servidor WHERE siape=?";
        PreparedStatement prepara = getPreparedStatement(sql);
        try {
            prepara.setString(1, servidor.getSiape());
            if (prepara.executeUpdate() > 0) {
                retorno = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServidorAbstratoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

    public boolean Alterar(ServidorAbstrato servidor) {
        Boolean retorno = false;
        String sql = "UPDATE servidor set nome=?,senha=?, funcao=?,classe=? WHERE siape=?";
        PreparedStatement prepara = getPreparedStatement(sql);
        try {
            prepara.setString(1, servidor.getNome());
            prepara.setString(2, servidor.getSenha());
            prepara.setString(3, servidor.getFuncao());
            if(servidor instanceof Servidor){
                prepara.setString(4, "servidor");
            } else {
                prepara.setString(4, "operador");
            }
            prepara.setString(5, servidor.getSiape());
            if (prepara.executeUpdate() > 0) {
                retorno = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServidorAbstratoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

    public ServidorAbstrato Buscar(String siape) {
        String sql = "SELECT * FROM servidor WHERE siape=?";
        ServidorAbstrato serv = null;
        PreparedStatement prepara = getPreparedStatement(sql);
        try {
            prepara.setString(1, siape);
            ResultSet rs = prepara.executeQuery();
            if (rs.next() == false) {
                prepara.close();
            } else {
                switch (rs.getString("classe")) {
                    case "servidor":
                        serv = new Servidor();
                        break;
                    case "operador":
                        serv = new Operador();
                        break;
                }
                serv.setSiape(rs.getString("siape"));
                serv.setNome(rs.getString("nome"));
                serv.setSenha(rs.getString("senha"));
                serv.setFuncao(rs.getString("funcao"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServidorAbstratoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return serv;
    }
    public ServidorAbstrato login(String siape, String senha) {
        String sql = "SELECT * FROM servidor WHERE siape=? and senha=?";
        ServidorAbstrato sa = null;
        PreparedStatement prepara = getPreparedStatement(sql);
        try {
            prepara.setString(1, siape);
            prepara.setString(2, senha);
            ResultSet rs = prepara.executeQuery();
            if (rs.next() == false) {
                prepara.close();
            } else {
                switch (rs.getString("classe")) {
                    case "servidor":
                        sa = new Servidor();
                        break;
                    case "operador":
                        sa = new Operador();
                        break;
                }
                sa.setSiape(rs.getString("siape"));
                sa.setNome(rs.getString("nome"));
                sa.setSenha(rs.getString("senha"));
                sa.setFuncao(rs.getString("funcao"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServidorAbstratoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sa;
    }
}
