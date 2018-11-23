package modelo;

import java.time.LocalDate;

// tabela alunos
public class Aluno {
	public enum EstadoCivil {
		Solteiro, Casado, Divorciado, Viuvo, Separado;
	}

	public enum Genero {
		Feminino("f"), Masculino("m"), NaoBinario("n");
		
		public final String LETRA;

		Genero(String l) {
			this.LETRA = l;
		}
	
		public static Genero fromString(String str) {
			if (str == null) return null;
			char c = str.toLowerCase().charAt(0); // f, m, n
			switch (c) {
			case 'f': return Genero.Feminino;
			case 'm': return Genero.Masculino;
			case 'n': return Genero.NaoBinario;
			}
			return null;
		}
	}

	// mapeamento objeto/relacional
	private Integer id = null; // int
	private String nome; // varchar
	private LocalDate dataNascimento;
	private EstadoCivil estadoCivil;
	private Genero genero;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public EstadoCivil getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(EstadoCivil estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	@Override
	public String toString() {
		return "Aluno [id=" + id + ", nome=" + nome + ", dataNascimento=" + dataNascimento + ", estadoCivil="
				+ estadoCivil + ", genero=" + genero + "]";
	}
	
}
