package model.entities;

public class Setor {

	private Integer id;
	private String nome;
	private Gerente gerente_setor;

	public Setor() {
	}
	
	public Setor(Integer id, String nome, Gerente gerente) {
		this.id = id;
		this.nome = nome;
		this.gerente_setor = gerente;
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

	public Gerente getGerente_setor() {
		return gerente_setor;
	}

	public void setGerente_setor(Gerente gerente_setor) {
		this.gerente_setor = gerente_setor;
	}

	@Override
	public String toString() {
		return "Setor [id=" + id + ", nome=" + nome + ", gerente_setor=" + gerente_setor + "]";
	}

}