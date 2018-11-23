package cobaia;

import java.time.LocalDate;
import java.util.List;

import modelo.Aluno;
import modelo.Aluno.EstadoCivil;
import modelo.Aluno.Genero;
import persistencia.AlunoDAO;

public class Main {
	public static void main(String[] args) {
		// O/R M
		// Object/Relational Mapping
		// Mapeamento Objeto/Relacional
		// Tabela/Classe/Tabela
		/*
		Aluno aluno = new Aluno();
		aluno.setNome("Wanderson Silva");
		aluno.setDataNascimento(LocalDate.of(1986, 8, 29));
		aluno.setEstadoCivil(EstadoCivil.Solteiro);
		aluno.setGenero(Genero.Masculino);
		System.out.println(aluno); // id = null
		AlunoDAO dao = new AlunoDAO();
		dao.insert(aluno);
		System.out.println(aluno); // id = 2
		*/
		
		
		AlunoDAO dao = new AlunoDAO();
		Aluno aluno = dao.select(1);
		System.out.println(aluno); // 1, Márcio
		Aluno aluno82323 = dao.select(82323);
		System.out.println(aluno82323); // null
		
		List<Aluno> alunos = dao.select();
		System.out.println(alunos); // toString
		for (Aluno a : alunos) { // foreach
			System.out.println(a.getNome());
		}

		dao.delete(5); // Márcio
		
		System.out.println(dao.select(1)); // null
		
		
		//dao.delete(new int[] {5, 6, 7, 8});
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
