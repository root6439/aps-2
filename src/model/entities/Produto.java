package model.entities;

public class Produto {

	private Integer id;
	private Setor produto_setor;
	private String nome;
	private String descricao;
	private Double valor;

	public Produto() {
	}
	
	public Produto(Integer id, String nome, String descricao, Double valor, Setor setor) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.valor = valor;
		this.produto_setor = setor;
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

	public Setor getProduto_setor() {
		return produto_setor;
	}

	public void setProduto_setor(Setor produto_setor) {
		this.produto_setor = produto_setor;
	}

	@Override
	public String toString() {
		return "Produto [id=" + id + ", produto_setor=" + produto_setor + ", nome=" + nome + ", descricao=" + descricao
				+ ", valor=" + valor + "]";
	}

}