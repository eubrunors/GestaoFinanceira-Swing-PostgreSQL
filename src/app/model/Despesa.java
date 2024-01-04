package app.model;

import java.util.Date;

import app.dao.DespesaDAO;
import app.dao.ExceptionDAO;

public class Despesa {
	
	private Integer codDespesa;
	private String descricao;
	private String categoria;
	private float valor;
	private Date data;
	private Pessoa pessoa;
	
	public Despesa(String descricao, String categoria, float valor, Date data) {
	    setDescricao(descricao);
	    setCategoria(categoria);
	    setValor(valor);
	    setData(data);
	}
	
	public Integer getCodDespesa() {
		return codDespesa;
	}
	public void setCodDespesa(Integer codDespesa) {
		this.codDespesa = codDespesa;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
	public void cadastrarDespesa(Despesa despesa) throws ExceptionDAO {
		new DespesaDAO().cadastrarDespesa(despesa);
	}
	
}
