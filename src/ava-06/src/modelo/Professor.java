package modelo;



public class Professor extends AbstractModel {

	public enum Formacao{
		Graduado, Mestrado, Doutorado, PHd;
	}

	
	
	private Formacao formacao;
	
	public Formacao getFormacao() {
		return formacao;
	}

	public void setFormacao(Formacao formacao) {
		this.formacao = formacao;
	}

	
	@Override
	public String toString() {
		return "Professor [id=" + getId() + ", nome=" + getNome() + ", dataNascimento=" + getDataNascimento() + ", formacao="
				+ formacao + ", genero=" + getGenero() + "]";
	}

	

	
}
