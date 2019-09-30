package model.entities;

import java.util.Date;

public class Cliente extends Pessoa {

	public Cliente(Integer id, String nome, String cpf, String telefone, Date data_nascimento) {
		super(id, nome, cpf, telefone, data_nascimento);
	}

}
