package DAO;

import static DAO.Conexao.getPreparedStatement;
import modelo.Curso;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CursoDAO {

    public CursoDAO() {
    }

    public boolean Inserir(Curso curso) {
        Boolean retorno = false;
        String sql = "INSERT INTO curso (nome, modalidade) VALUES(?,?)";
        PreparedStatement prepara = getPreparedStatement(sql);
        try {
            prepara.setString(1, curso.getNome());
            prepara.setString(2, curso.getModalidade());
            if (prepara.executeUpdate() > 0) {
                retorno = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CursoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

    public List<Curso> Listar() {
        String sql = "select * from curso";
        List<Curso> lista;
        lista = new ArrayList<Curso>();
        PreparedStatement prepara = getPreparedStatement(sql);
        try {
            ResultSet rs = prepara.executeQuery();
            while (rs.next()) {
                Curso curso = new Curso();
                curso.setId(Integer.parseInt(rs.getString("id")));
                curso.setNome(rs.getString("nome"));
                curso.setModalidade(rs.getString("modalidade"));
                lista.add(curso);
            }

        } catch (SQLException ex) {
            Logger.getLogger(CursoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public boolean Excluir(Curso curso) {
        Boolean retorno = false;
        String sql = "DELETE from curso WHERE id=?";
        PreparedStatement prepara = getPreparedStatement(sql);
        try {
            prepara.setInt(1, curso.getId());
            if (prepara.executeUpdate() > 0) {
                retorno = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CursoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

    public boolean Alterar(Curso curso) {
        Boolean retorno = false;
        String sql = "UPDATE curso set nome=?,modalidade=? WHERE id=?";
        PreparedStatement prepara = getPreparedStatement(sql);
        try {
            prepara.setString(1, curso.getNome());
            prepara.setString(2, curso.getModalidade());
            prepara.setInt(3, curso.getId());
            if (prepara.executeUpdate() > 0) {
                retorno = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CursoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

    public Curso Buscar(Curso curso) {
        String sql = "SELECT * FROM curso WHERE id=?";
        Curso curs = null;
        PreparedStatement prepara = getPreparedStatement(sql);
        try {
            prepara.setInt(1, curso.getId());
            ResultSet rs = prepara.executeQuery();
            while (rs.next()) {
                curs = new Curso();
                curs.setId(Integer.parseInt(rs.getString("id")));
                curs.setNome(rs.getString("nome"));
                curs.setModalidade(rs.getString("modalidade"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(CursoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return curs;
    }
}

