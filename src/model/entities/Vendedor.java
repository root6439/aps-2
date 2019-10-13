package model.entities;

import java.util.Date;

public class Vendedor extends Pessoa{

	private Setor setor_vendedor;
	
	public Vendedor() {
	}
	
	public Vendedor(Integer id, String nome, String cpf, String telefone, Date data_nascimento, Setor setor) {
		super(id, nome, cpf, telefone, data_nascimento);
		this.setor_vendedor = setor;
	}

	public Setor getSetor_vendedor() {
		return setor_vendedor;
	}

	public void setSetor_vendedor(Setor setor_vendedor) {
		this.setor_vendedor = setor_vendedor;
	}

	@Override
	public String toString() {
		return super.toString() + "Vendedor [setor_vendedor=" + setor_vendedor + "]";
	}

}