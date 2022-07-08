package DAO;

import static DAO.Conexao.getPreparedStatement;
import modelo.Aluno;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AlunoDAO {

    public AlunoDAO() {
    }

    public boolean Inserir(Aluno aluno) {
        Boolean retorno = false;
        String sql = "INSERT INTO aluno (sage,nome,id_turma,senha,status) VALUES(?,?,?,?,?)";
        PreparedStatement prepara = getPreparedStatement(sql);
        try {
            prepara.setString(1, aluno.getSage());
            prepara.setString(2, aluno.getNome());
            prepara.setInt(3, aluno.getId_turma());
            prepara.setString(4, aluno.getSenha());
            prepara.setString(5, aluno.getStatus());
            if (prepara.executeUpdate() > 0) {
                retorno = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

    public List<Aluno> Listar() {
        String sql = "select * from aluno";
        List<Aluno> lista = new ArrayList<Aluno>();
        PreparedStatement prepara = getPreparedStatement(sql);
        try {
            ResultSet rs = prepara.executeQuery();
            while (rs.next()) {
                Aluno aluno = new Aluno();
                aluno.setSage(rs.getString("sage"));
                aluno.setNome(rs.getString("nome"));
                aluno.setId_turma(Integer.parseInt(rs.getString("id_turma")));
                aluno.setSenha(rs.getString("senha"));
                aluno.setStatus(rs.getString("status"));
                lista.add(aluno);
            }

        } catch (SQLException ex) {
            Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public boolean Excluir(Aluno aluno) {
        Boolean retorno = false;
        String sql = "DELETE from aluno WHERE sage=?";
        PreparedStatement prepara = getPreparedStatement(sql);
        try {
            prepara.setString(1, aluno.getSage());
            if (prepara.executeUpdate() > 0) {
                retorno = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

    public boolean Alterar(Aluno aluno) {
        Boolean retorno = false;
        String sql = "UPDATE aluno set nome=?,senha=?,status=? WHERE sage=?";
        PreparedStatement prepara = getPreparedStatement(sql);
        try {
            prepara.setString(1, aluno.getNome());
            prepara.setString(2, aluno.getSenha());
            prepara.setString(3, aluno.getStatus());
            prepara.setString(4, aluno.getSage());
            if (prepara.executeUpdate() > 0) {
                retorno = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

    public Aluno Buscar(Aluno aluno) {
        String sql = "SELECT * FROM aluno WHERE sage=?";
        Aluno alu = null;
        PreparedStatement prepara = getPreparedStatement(sql);
        try {
            prepara.setString(1, aluno.getSage());
            ResultSet rs = prepara.executeQuery();
            while (rs.next()) {
                alu = new Aluno();
                alu.setSage(rs.getString("sage"));
                alu.setSenha(rs.getString("senha"));
                alu.setNome(rs.getString("nome"));
                alu.setId_turma(Integer.parseInt(rs.getString("id_turma")));
                alu.setStatus(rs.getString("status"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return alu;
    }
    
    public List ListarPorTurma(int id_turma) {
        String sql = "SELECT * FROM aluno WHERE id_turma=?";
        List<Aluno> lista;
        lista = new ArrayList<>();
        PreparedStatement prepara = getPreparedStatement(sql);
        try {
            prepara.setInt(1, id_turma);
            ResultSet rs = prepara.executeQuery();
            while (rs.next()) {
                Aluno aluno = new Aluno();
                aluno.setSage(rs.getString("sage"));
                aluno.setNome(rs.getString("nome"));
                aluno.setId_turma(Integer.parseInt(rs.getString("id_turma")));
                aluno.setSenha(rs.getString("senha"));
                aluno.setStatus(rs.getString("status"));
                lista.add(aluno);
            }

        } catch (SQLException ex) {
            Logger.getLogger(TurmaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
    
    public Aluno Login(Aluno aluno) {
        String sql = "SELECT * FROM aluno WHERE sage=? and senha=?";
        Aluno alu = null;
        PreparedStatement prepara = Conexao.getPreparedStatement(sql);
        try {
            prepara.setString(1, aluno.getSage());
            prepara.setString(2, aluno.getSenha());
            ResultSet rs = prepara.executeQuery();
            if (rs.next()) {
                alu = new Aluno();
                alu.setSage(rs.getString("sage"));
                alu.setSenha(rs.getString("senha"));
                alu.setNome(rs.getString("nome"));
                alu.setId_turma(Integer.parseInt(rs.getString("id_turma")));
                alu.setStatus(rs.getString("status"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return alu;
    }
}
