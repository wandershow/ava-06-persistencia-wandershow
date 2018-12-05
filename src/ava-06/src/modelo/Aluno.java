package modelo;



// tabela alunos
public class Aluno extends AbstractModel {
	public enum EstadoCivil {
		Solteiro, Casado, Divorciado, Viuvo, Separado;
	}

	
	private EstadoCivil estadoCivil;

	
	public EstadoCivil getEstadoCivil() {
		return estadoCivil;
	}
	
	@Override
	public String toString() {
		return "Aluno [id=" + getId() + ", nome=" + getNome() + ", dataNascimento=" + getDataNascimento() + ", estadoCivil="
				+ estadoCivil + ", genero=" + getGenero() + "]";
	}

	public void setEstadoCivil(EstadoCivil estadoCivil) {
		this.estadoCivil = estadoCivil;
		
	}

}
