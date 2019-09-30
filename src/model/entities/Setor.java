package model.entities;

public class Setor {

	private Integer id;
	private String nome;
	private Integer id_gerente;

	public Setor(Integer id, String nome, Integer id_gerente) {
		this.id = id;
		this.nome = nome;
		this.id_gerente = id_gerente;
	}

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

	public Integer getId_gerente() {
		return id_gerente;
	}

	public void setId_gerente(Integer id_gerente) {
		this.id_gerente = id_gerente;
	}

}