package model.entities;

import java.util.Date;

public class Gerente extends Pessoa{

	private String email;
	
	public Gerente(Integer id, String nome, String cpf, String telefone, Date data_nascimento, String email) {
		super(id, nome, cpf, telefone, data_nascimento);
		this.email = email;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}