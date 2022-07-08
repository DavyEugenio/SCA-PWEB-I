package DAO;

import static DAO.Conexao.getPreparedStatement;
import modelo.Frequencia;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FrequenciaDAO {

    public FrequenciaDAO() {

    }

    public boolean Inserir(Frequencia frequencia) {
        Boolean retorno = false;
        String sql = "INSERT INTO frequencia (entrada,sage_aluno) VALUES(?,?)";
        PreparedStatement prepara = getPreparedStatement(sql);
        try {
            prepara.setString(1, frequencia.getEntrada());
            prepara.setString(2, frequencia.getSage_aluno());
            if (prepara.executeUpdate() > 0) {
                retorno = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(FrequenciaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }
       
    public boolean Alterar(Frequencia frequencia) {
        Boolean retorno = false;
        String sql = "UPDATE frequencia set entrada=?,saida=?,sage_aluno=? WHERE id=?";
        PreparedStatement prepara = getPreparedStatement(sql);
        try {
            prepara.setString(1, frequencia.getEntrada());
            prepara.setString(2, frequencia.getSaida());
            prepara.setString(3, frequencia.getSage_aluno());
            prepara.setInt(4, frequencia.getId());
            if (prepara.executeUpdate() > 0) {
                retorno = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }
    
    public List<Frequencia> Listar() {
        String sql = "select `id`,`sage_aluno`, DATE_FORMAT(`entrada`, '%H:%i:%s - %m/%d/%Y') AS `entrada`, DATE_FORMAT(`saida`, '%H:%i:%s - %m/%d/%Y') AS `saida` from frequencia";
        List<Frequencia> lista;
        lista = new ArrayList<Frequencia>();
        PreparedStatement prepara = getPreparedStatement(sql);
        try {
            ResultSet rs = prepara.executeQuery();
            while (rs.next()) {
                Frequencia frequencia = new Frequencia();
                frequencia.setId(Integer.parseInt(rs.getString("id")));
                frequencia.setEntrada(rs.getString("entrada"));
                frequencia.setSaida(rs.getString("saida"));
                frequencia.setSage_aluno(rs.getString("sage_aluno"));
                lista.add(frequencia);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FrequenciaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public Frequencia Buscar(Frequencia frequencia) {
        String sql = "SELECT * FROM frequencia WHERE id=?";
        Frequencia freq = null;
        PreparedStatement prepara = getPreparedStatement(sql);
        try {
            prepara.setInt(1, frequencia.getId());
            ResultSet rs = prepara.executeQuery();
            while (rs.next()) {
                freq = new Frequencia();
                freq.setId(Integer.parseInt(rs.getString("id")));
                freq.setEntrada(rs.getString("entrada"));
                freq.setSaida(rs.getString("saida"));
                freq.setSage_aluno(rs.getString("sage_aluno"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(FrequenciaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return freq;
    }
    public boolean Excluir(Frequencia frequencia) {
        Boolean retorno = false;
        String sql = "DELETE from frequencia WHERE id=?";
        PreparedStatement prepara = getPreparedStatement(sql);
        try {
            prepara.setInt(1, frequencia.getId());
            if (prepara.executeUpdate() > 0) {
                retorno = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(TurmaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }
    
    public Frequencia BuscarUltima(String sage_aluno) {
        String sql = "SELECT * FROM frequencia WHERE id = (SELECT MAX(id) FROM frequencia WHERE sage_aluno = ?) AND saida is null";
        Frequencia freq = null;
        PreparedStatement prepara = getPreparedStatement(sql);
        try {
            prepara.setString(1, sage_aluno);
            ResultSet rs = prepara.executeQuery();
            while (rs.next()) {
                freq = new Frequencia();
                freq.setId(Integer.parseInt(rs.getString("id")));
                freq.setEntrada(rs.getString("entrada"));
                freq.setSaida(rs.getString("saida"));
                freq.setSage_aluno(rs.getString("sage_aluno"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(FrequenciaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return freq;
    }
    public List ListarPorAluno(String sage_aluno) {
        String sql = "select `id`,`sage_aluno`, DATE_FORMAT(`entrada`, '%H:%i:%s - %m/%d/%Y') AS `entrada`, DATE_FORMAT(`saida`, '%H:%i:%s - %m/%d/%Y') AS `saida` from frequencia WHERE sage_aluno=?";
        List<Frequencia> lista;
        lista = new ArrayList<>();
        PreparedStatement prepara = getPreparedStatement(sql);
        try {
            prepara.setString(1, sage_aluno);
            ResultSet rs = prepara.executeQuery();
            while (rs.next()) {
                Frequencia frequencia = new Frequencia();
                frequencia.setId(Integer.parseInt(rs.getString("id")));
                frequencia.setEntrada(rs.getString("entrada"));
                frequencia.setSaida(rs.getString("saida"));
                frequencia.setSage_aluno(rs.getString("sage_aluno"));
                lista.add(frequencia);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TurmaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
}
