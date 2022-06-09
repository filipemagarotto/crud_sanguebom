package br.com.projeto_sanguebom.model;

public class Doador {
	
	private String nome;
	private String cpf;
	private String email;
	private String uf;
	private String dataNascimento;
	private int id;
	private String telefone;
	private String cidade;
	private String tipo_sanguineo;
	private String dataUltimaModificacao;
	private String dataCriacao;
	
	public Doador(){}

	public Doador(String nome, String cpf, String email, String uf, String dataNascimento, String telefone,
			String cidade, String tipo_sanguineo, String dataUltimaModificacao, String dataCriacao) {
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.uf = uf;
		this.dataNascimento = dataNascimento;
		this.telefone = telefone;
		this.cidade = cidade;
		this.tipo_sanguineo = tipo_sanguineo;
		this.dataUltimaModificacao = dataUltimaModificacao;
		this.dataCriacao = dataCriacao;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getTipo_sanguineo() {
		return tipo_sanguineo;
	}

	public void setTipo_sanguineo(String tipo_sanguineo) {
		this.tipo_sanguineo = tipo_sanguineo;
	}

	public String getDataUltimaModificacao() {
		return dataUltimaModificacao;
	}

	public void setDataUltimaModificacao(String dataUltimaModificacao) {
		this.dataUltimaModificacao = dataUltimaModificacao;
	}

	public String getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(String dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	
}
