package model.entities;

import java.util.Date;

public class Venda {

	private Integer id;
	private Cliente venda_cliente;
	private Produto venda_produto;
	private Date data_venda;
	private Integer num_itens_vendidos;

	public Venda() {
	}

	public Venda(Integer id, Cliente venda_cliente, Produto venda_produto, Date data_venda,
			Integer num_itens_vendidos) {
		this.id = id;
		this.venda_cliente = venda_cliente;
		this.venda_produto = venda_produto;
		this.data_venda = data_venda;
		this.num_itens_vendidos = num_itens_vendidos;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Cliente getVenda_cliente() {
		return venda_cliente;
	}

	public void setVenda_cliente(Cliente venda_cliente) {
		this.venda_cliente = venda_cliente;
	}

	public Produto getVenda_produto() {
		return venda_produto;
	}

	public void setVenda_produto(Produto venda_produto) {
		this.venda_produto = venda_produto;
	}

	public Date getData_venda() {
		return data_venda;
	}

	public void setData_venda(Date data_venda) {
		this.data_venda = data_venda;
	}

	public Integer getNum_itens_vendidos() {
		return num_itens_vendidos;
	}

	public void setNum_itens_vendidos(Integer num_itens_vendidos) {
		this.num_itens_vendidos = num_itens_vendidos;
	}

	@Override
	public String toString() {
		return "Venda [id=" + id + ", venda_cliente=" + venda_cliente + ", venda_produto=" + venda_produto
				+ ", data_venda=" + data_venda + ", num_itens_vendidos=" + num_itens_vendidos + "]";
	}
	
}