package model.entities;

public class Produto {

	private Integer id;
	private Integer id_setor;
	private String nome;
	private String descricao;
	private Double valor;

	public Produto() {
	}
	
	public Produto(Integer id, Integer id_setor, String nome, String descricao, Double valor) {
		this.id = id;
		this.id_setor = id_setor;
		this.nome = nome;
		this.descricao = descricao;
		this.valor = valor;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId_setor() {
		return id_setor;
	}

	public void setId_setor(Integer id_setor) {
		this.id_setor = id_setor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "Produto [id=" + id + ", id_setor=" + id_setor + ", nome=" + nome + ", descricao=" + descricao
				+ ", valor=" + valor + "]";
	}
	
	

}