package persistencia;

import java.sql.Date;

import java.sql.ResultSet;

import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import cobaia.Genero;
import modelo.Aluno;
import modelo.Aluno.EstadoCivil;

// Data Access Object: objeto de acesso a dados
// Um objeto que faz a persistência/interface com o "banco"
public class AlunoDAO extends AbstractDao<Aluno> {
	
	// CRUD: Create, Read, Update, Delete
	public void insert(Aluno aluno) { // create, save
		// não inserir um aluno salvo anteriormente
		if (aluno.getId() != null) {
			throw new RegistroDuplicadoException();
		}
		// o nome é NOT NULL no banco, logo o objeto deve ter nome
		if (aluno.getNome() == null) {
			throw new NullPointerException("o nome não pode ser nulo");
		}

		try {
			// abrir a conexão
			openConnection();
			// preparar o comando
			String sql = "INSERT INTO alunos (nome, data_nascimento, estado_civil, genero) " + "VALUES (?, ?, ?, ?);"; // ?
																														// placeholder
																														// (reserva
																														// lugar)
			preparado(sql);
			comando.setString(1, aluno.getNome()); // sempre tem um nome (NOT NULL)

			if (aluno.getDataNascimento() == null) {
				comando.setNull(2, Types.DATE);
			} else {
				comando.setDate(2, Date.valueOf(aluno.getDataNascimento()));
			}

			if (aluno.getEstadoCivil() == null) {
				comando.setNull(3, Types.INTEGER);
			} else {
				comando.setInt(3, aluno.getEstadoCivil().ordinal());
			}

			if (aluno.getGenero() == null) {
				comando.setNull(4, Types.CHAR);
			} else {
				comando.setString(4, aluno.getGenero().LETRA);
			}
			// executar o comando
			comando.execute();
			// pegar o retorno (pegando o id gerado)
			ResultSet resultado = comando.getGeneratedKeys();
			if (resultado.next()) {
				int idGerado = resultado.getInt(1); // 1ra coluna
				aluno.setId(idGerado);
			}
			// fechar a conexão
			conexao.close();
		} catch (Exception e) {
			throw new RuntimeException(e); // relançar excep
		}
	}

	public Aluno select(Integer id) { // read, load, search
		Aluno a = null;
		try {
			openConnection();
			// NÃO CONCATENE SQL! use o ? (place holder)
			String sql = "SELECT * FROM alunos WHERE id = ?";
			preparado(sql);
			comando.setInt(1, id); // sempre tem um nome (NOT NULL)
			// executar uma query!
			ResultSet resultado = comando.executeQuery();
			if (resultado.next()) { // encontrou!
				a = new Aluno();
				a.setId(id);
				a.setNome(resultado.getString("nome"));
				if (resultado.getDate("data_nascimento") != null) {
					a.setDataNascimento(resultado.getDate("data_nascimento").toLocalDate());
				}
				if (resultado.getString("genero") != null) {
					a.setGenero(Genero.fromString(resultado.getString("genero")));
				}
				if (resultado.getObject("estado_civil") != null) {
					a.setEstadoCivil(EstadoCivil.values()[resultado.getInt("estado_civil")]);
				}
			}
			conexao.close();
			return a;
		} catch (Exception e) {
			throw new RuntimeException(e); // relançar excep
		}
	}

	public List<Aluno> select() {
		List<Aluno> alunos = new ArrayList<>();
		try {
			openConnection();
			String sql = "SELECT * FROM alunos";
			preparado(sql);
			ResultSet resultado = comando.executeQuery();
			while (resultado.next()) {
				Aluno a = new Aluno();
				alunos.add(a);
				a.setId(resultado.getInt("id"));
				a.setNome(resultado.getString("nome"));
				if (resultado.getDate("data_nascimento") != null) {
					a.setDataNascimento(resultado.getDate("data_nascimento").toLocalDate());
				}
				if (resultado.getString("genero") != null) {
					a.setGenero(Genero.fromString(resultado.getString("genero")));
				}
				if (resultado.getObject("estado_civil") != null) {
					a.setEstadoCivil(EstadoCivil.values()[resultado.getInt("estado_civil")]);
				}
			}
			conexao.close();
			return alunos;
		} catch (Exception e) {
			throw new RuntimeException(e); // relançar excep
		}
	}

	/*
	 * public void delete(int[] ids) { try (Connection cnx =
	 * DriverManager.getConnection(url, user, password)) { // autoclose String sql =
	 * "DELETE FROM alunos WHERE id IN(?)"; PreparedStatement cmd =
	 * cnx.prepareStatement(sql); // cmd.setArray(1, ids); // TODO cmd.execute(); }
	 * catch (Exception e) { throw new RuntimeException(e); } }
	 */
	
	public void delete(int id) { // remove, exclui, destroy
		try  {
			openConnection();// autoclose
			String sql = "DELETE FROM alunos WHERE id = ?";
			preparado(sql);
			comando.setInt(1, id);
			comando.execute();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public void update(Aluno aluno) {

	}

	
	

}
