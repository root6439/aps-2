package model.entities;

import java.util.Date;

public class Vendedor extends Pessoa{

	private Integer id_setor;
	
	public Vendedor() {
	}
	
	public Vendedor(Integer id, String nome, String cpf, String telefone, Date data_nascimento, Integer id_setor) {
		super(id, nome, cpf, telefone, data_nascimento);
		this.id_setor = id_setor;
	}

	public Integer getId_setor() {
		return id_setor;
	}

	public void setId_setor(Integer id_setor) {
		this.id_setor = id_setor;
	}

	@Override
	public String toString() {
		return super.toString() + " [id_setor=" + id_setor + "]";
	}
	
	
	
}