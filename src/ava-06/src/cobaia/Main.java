package cobaia;

import java.time.LocalDate;
import java.util.List;

import modelo.Aluno;
import modelo.Aluno.EstadoCivil;

import modelo.Professor;
import modelo.Professor.Formacao;
import persistencia.AlunoDAO;
import persistencia.ProfessorDAO;

public class Main {
	public static void main(String[] args) {
		// O/R M
		// Object/Relational Mapping
		// Mapeamento Objeto/Relacional
		// Tabela/Classe/Tabela
		
		Aluno aluno = new Aluno();
		aluno.setNome("Wanderson Silva");
		aluno.setDataNascimento(LocalDate.of(1986, 8, 29));
		aluno.setEstadoCivil(EstadoCivil.Solteiro);
		aluno.setGenero(Genero.Masculino);
		System.out.println(aluno); // id = null
		AlunoDAO dao = new AlunoDAO();
		dao.insert(aluno);
		System.out.println(aluno); // id = 2
		
		
		
		AlunoDAO dao1 = new AlunoDAO();
		Aluno aluno1 = dao1.select(1);
		System.out.println(aluno1); // 1, Márcio
		Aluno aluno82323 = dao.select(82323);
		System.out.println(aluno82323); // null
		
		List<Aluno> alunos = dao1.select();
		System.out.println(alunos); // toString
		for (Aluno a : alunos) { // foreach
			System.out.println(a.getNome());
		}

		dao.delete(5); // Márcio
		
		System.out.println(dao.select(1)); // null
		
		
		//dao.delete(new int[] {5, 6, 7, 8});
		
		Professor professor = new Professor();
		professor.setNome("roberto carlos");
		professor.setDataNascimento(LocalDate.of(1986, 8, 29));
		professor.setFormacao(Formacao.Mestrado);
		professor.setGenero(Genero.Masculino);
		System.out.println(professor); // id = null
		ProfessorDAO dao3 = new ProfessorDAO();
		dao3.insert(professor);
		System.out.println(professor); // id = 2
		
		
		ProfessorDAO dao2 = new ProfessorDAO();
		Professor professor1 = dao2.select(1);
		System.out.println(professor1); // 1, Márcio
		Professor professor82323 = dao2.select(82323);
		System.out.println(professor82323); // null
		
		List<Professor> professores = dao2.select();
		System.out.println(professores); // toString
		for (Professor p : professores) { // foreach
			System.out.println(p.getNome());
		}

		dao.delete(5); // Márcio
		
		System.out.println(dao.select(1));
		
		
		
		
		
		
		
		
		
		
		
	}
}
