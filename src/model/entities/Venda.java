package model.entities;

import java.util.Date;

public class Venda {

	private Integer id;
	private Integer id_cliente;
	private Integer id_produto;
	private Date data_venda;
	private Double valor;
	private Integer num_itens_vendidos;

	public Venda(Integer id, Integer id_cliente, Integer id_produto, Date data_venda, Double valor,
			Integer num_itens_vendidos) {
		this.id = id;
		this.id_cliente = id_cliente;
		this.id_produto = id_produto;
		this.data_venda = data_venda;
		this.valor = valor;
		this.num_itens_vendidos = num_itens_vendidos;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(Integer id_cliente) {
		this.id_cliente = id_cliente;
	}

	public Integer getId_produto() {
		return id_produto;
	}

	public void setId_produto(Integer id_produto) {
		this.id_produto = id_produto;
	}

	public Date getData_venda() {
		return data_venda;
	}

	public void setData_venda(Date data_venda) {
		this.data_venda = data_venda;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Integer getNum_itens_vendidos() {
		return num_itens_vendidos;
	}

	public void setNum_itens_vendidos(Integer num_itens_vendidos) {
		this.num_itens_vendidos = num_itens_vendidos;
	}

}