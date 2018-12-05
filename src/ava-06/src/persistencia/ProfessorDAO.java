package persistencia;

import java.sql.Date;

import java.sql.ResultSet;

import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import cobaia.Genero;
import modelo.Professor;

import modelo.Professor.Formacao;


public class ProfessorDAO extends AbstractDao<Professor> {


	public void insert(Professor professor) { // create, save
		// não inserir um aluno salvo anteriormente
		if (professor.getId() != null) {
			throw new RegistroDuplicadoException();
		}
		// o nome é NOT NULL no banco, logo o objeto deve ter nome
		if (professor.getNome() == null) {
			throw new NullPointerException("o nome não pode ser nulo");
		}

		try {
			// abrir a conexão
			openConnection();
			// preparar o comando
			String sql = "INSERT INTO Professores (nome, data_nascimento, formacao, genero) " + "VALUES (?, ?, ?, ?);"; // ?
																													// placeholder
																													// (reserva
			preparado(sql);																										// lugar)
			
			comando.setString(1, professor.getNome()); // sempre tem um nome (NOT NULL)

			if (professor.getDataNascimento() == null) {
				comando.setNull(2, Types.DATE);
			} else {
				comando.setDate(2, Date.valueOf(professor.getDataNascimento()));
			}

			if (professor.getFormacao() == null) {
				comando.setNull(3, Types.INTEGER);
			} else {
				comando.setInt(3, professor.getFormacao().ordinal());
			}

			if (professor.getGenero() == null) {
				comando.setNull(4, Types.CHAR);
			} else {
				comando.setString(4, professor.getGenero().LETRA);
			}
			// executar o comando
			comando.execute();
			// pegar o retorno (pegando o id gerado)
			ResultSet resultado = comando.getGeneratedKeys();
			if (resultado.next()) {
				int idGerado = resultado.getInt(1); // 1ra coluna
				professor.setId(idGerado);
			}
			// fechar a conexão
			conexao.close();
		} catch (Exception e) {
			throw new RuntimeException(e); // relançar excep
		}
	}

	public Professor select(Integer id) { // read, load, search
		Professor p = null;
		try {
			openConnection();
			// NÃO CONCATENE SQL! use o ? (place holder)
			String sql = "SELECT * FROM professores WHERE id = ?";
			preparado(sql);
			comando.setInt(1, id); // sempre tem um nome (NOT NULL)
			// executar uma query!
			ResultSet resultado = comando.executeQuery();
			if (resultado.next()) { // encontrou!
				p = new Professor();
				p.setId(id);
				p.setNome(resultado.getString("nome"));
				if (resultado.getDate("data_nascimento") != null) {
					p.setDataNascimento(resultado.getDate("data_nascimento").toLocalDate());
				}
				if (resultado.getString("genero") != null) {
					p.setGenero(Genero.fromString(resultado.getString("genero")));
				}
				if (resultado.getObject("formacao") != null) {
					p.setFormacao(Formacao.values()[resultado.getInt("formacao")]);
				}
			}
			conexao.close();
			return p;
		} catch (Exception e) {
			throw new RuntimeException(e); // relançar excep
		}
	}
	
	public List<Professor> select() {
		List<Professor> professores = new ArrayList<>();
		try {
			openConnection();
			String sql = "SELECT * FROM professores";
			preparado(sql);
			ResultSet resultado = comando.executeQuery();
			while (resultado.next()) {
		        Professor p = new Professor();
				professores.add(p);
				p.setId(resultado.getInt("id"));
				p.setNome(resultado.getString("nome"));
				if (resultado.getDate("data_nascimento") != null) {
					p.setDataNascimento(resultado.getDate("data_nascimento").toLocalDate());
				}
				if (resultado.getString("genero") != null) {
					p.setGenero(Genero.fromString(resultado.getString("genero")));
				}
				if (resultado.getObject("formacao") != null) {
					p.setFormacao(Formacao.values()[resultado.getInt("formacao")]);
				}
			}
			conexao.close();
			return professores;
		} catch (Exception e) {
			throw new RuntimeException(e); // relançar excep
		}
	}

	public void delete(int id) { // remove, exclui, destroy
		try { // autoclose
			openConnection();
			String sql = "DELETE FROM Professores WHERE id = ?";
			preparado(sql);
			comando.setInt(1, id);
			comando.execute();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public void update(Professor professor) {

	}

	
}
