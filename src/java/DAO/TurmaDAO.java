package DAO;

import static DAO.Conexao.getPreparedStatement;
import modelo.Turma;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Curso;

public class TurmaDAO {

    public TurmaDAO() {
    }

    public boolean Inserir(Turma turma) {
        Boolean retorno = false;
        String sql = "INSERT INTO turma (id_curso,ano,semestre,turno) VALUES(?,?,?,?)";
        PreparedStatement prepara = getPreparedStatement(sql);
        try {
            prepara.setInt(1, turma.getId_curso());
            prepara.setInt(2, turma.getAno());
            prepara.setInt(3, turma.getSemestre());
            prepara.setString(4, turma.getTurno());
            if (prepara.executeUpdate() > 0) {
                retorno = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(TurmaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

    public List<Turma> Listar() {
        String sql = "SELECT * FROM `turma`";
        List<Turma> lista;
        lista = new ArrayList<Turma>();
        PreparedStatement prepara = getPreparedStatement(sql);
        try {
            ResultSet rs = prepara.executeQuery();
            while (rs.next()) {
                Turma turma = new Turma();
                turma.setId(Integer.parseInt(rs.getString("id")));
                turma.setId_curso(Integer.parseInt(rs.getString("id_curso")));
                turma.setAno(Integer.parseInt(rs.getString("ano")));
                turma.setSemestre(Integer.parseInt(rs.getString("semestre")));
                turma.setTurno(rs.getString("turno"));
                lista.add(turma);
            }

        } catch (SQLException ex) {
            Logger.getLogger(TurmaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public boolean Excluir(Turma turma) {
        Boolean retorno = false;
        String sql = "DELETE from turma WHERE id=?";
        PreparedStatement prepara = getPreparedStatement(sql);
        try {
            prepara.setInt(1, turma.getId());
            if (prepara.executeUpdate() > 0) {
                retorno = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(TurmaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

    public boolean Alterar(Turma turma) {
        Boolean retorno = false;
        String sql = "UPDATE turma set id_curso=?,ano=?,semestre=?,turno=? WHERE id=?";
        PreparedStatement prepara = getPreparedStatement(sql);
        try {
            prepara.setInt(1, turma.getId_curso());
            prepara.setInt(2, turma.getAno());
            prepara.setInt(3, turma.getSemestre());
            prepara.setString(4, turma.getTurno());
            prepara.setInt(5, turma.getId());
            if (prepara.executeUpdate() > 0) {
                retorno = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(TurmaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

    public Turma Buscar(Turma turma) {
        String sql = "SELECT * FROM turma WHERE id=?";
        Turma turm = null;
        PreparedStatement prepara = getPreparedStatement(sql);
        try {
            prepara.setInt(1, turma.getId());
            ResultSet rs = prepara.executeQuery();
            while (rs.next()) {
                turm = new Turma();
                turm.setId(Integer.parseInt(rs.getString("id")));
                turm.setId_curso(Integer.parseInt(rs.getString("id_curso")));
                turm.setAno(Integer.parseInt(rs.getString("ano")));
                turm.setSemestre(Integer.parseInt(rs.getString("semestre")));
                turm.setTurno(rs.getString("turno"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(TurmaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return turm;
    }

    public List ListarPorCurso(int id_curso) {
        String sql = "SELECT * FROM turma WHERE id_curso=?";
        List<Turma> lista;
        lista = new ArrayList<Turma>();
        PreparedStatement prepara = getPreparedStatement(sql);
        try {
            prepara.setInt(1, id_curso);
            ResultSet rs = prepara.executeQuery();
            while (rs.next()) {
                Turma turma = new Turma();
                turma.setId(Integer.parseInt(rs.getString("id")));
                turma.setId_curso(Integer.parseInt(rs.getString("id_curso")));
                turma.setAno(Integer.parseInt(rs.getString("ano")));
                turma.setSemestre(Integer.parseInt(rs.getString("semestre")));
                turma.setTurno(rs.getString("turno"));
                lista.add(turma);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TurmaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public List ListarCursos() {
        List listat = Listar();
        List<Curso> lc = new ArrayList<>();
        CursoDAO dao = new CursoDAO();
        for (int i = 0; i < listat.size(); i++) {
            Turma turma = (Turma) listat.get(i);
            Curso curso = new Curso();
            curso.setId(turma.getId_curso());
            curso = dao.Buscar(curso);
            lc.add(curso);
        }
        for (int i = 0; i < lc.size(); i++) {
            for (int j = 1; j < lc.size() - 1; j++) {
                if (i != j) {
                    Curso curso = (Curso) lc.get(i);
                    Curso curso1 = (Curso) lc.get(j);
                    if (curso.getId() == curso1.getId()) {
                        lc.remove(j);
                    }
                }
            }
        }
        return lc;
    }
}
