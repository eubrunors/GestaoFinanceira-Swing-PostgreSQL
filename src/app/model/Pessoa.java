package app.model;

import java.util.ArrayList;

public class Pessoa {
	private Integer codPessoa;
	private String nome;
	private Integer cpf;
	private String email;
	private float saldo;
	private ArrayList<Despesa> despesas = new ArrayList<Despesa>();
	public Integer getCodPessoa() {
		return codPessoa;
	}
	public void setCodPessoa(Integer codPessoa) {
		this.codPessoa = codPessoa;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getCpf() {
		return cpf;
	}
	public void setCpf(Integer cpf) {
		this.cpf = cpf;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public float getSaldo() {
		return saldo;
	}
	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
	public ArrayList<Despesa> getDespesas() {
		return despesas;
	}
	public void setDespesas(ArrayList<Despesa> despesas) {
		this.despesas = despesas;
	}
	
	
}
