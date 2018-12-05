package modelo;

import java.time.LocalDate;

import cobaia.Genero;

public abstract class AbstractModel {
	
	private Integer id = null; // int
	private String nome; // varchar
	private LocalDate dataNascimento;
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
	
	 public Genero getGenero() {
		return genero;
		 
	 }
	
	public void setGenero(Genero genero) {	
	
	this.genero = genero;
	}
}
