package com.belemtour.model;

public class Cliente {
	
	private int idCliente;
	private String nome;
	private String cpf;
	private String telefone;
	private String endereco;
	private String email;
	
		// Criação dos Métodos
	
	// * Contrutores
	
	public Cliente(String nome, String cpf, String telefone, String endereco, String email,int id) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.endereco = endereco;
		this.email = email;
        this.idCliente = id;

		
				
	}

		public Cliente() {
			super();
		}
		
		// Criação  dos Métodos Acessores

		
		public int getIdCliente() {
			return idCliente;
		}

		public void setIdCliente(int idCliente) {
			this.idCliente = idCliente;
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

		public String getTelefone() {
			return telefone;
		}

		public void setTelefone(String telefone) {
			this.telefone = telefone;
		}

		public String getEndereco() {
			return endereco;
		}

		public void setEndereco(String endereco) {
			this.endereco = endereco;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		@Override
		public String toString() {
			return "Cliente [idCliente=" + idCliente + ", nome=" + nome + ", cpf=" + cpf + ", telefone=" + telefone
					+ ", endereco=" + endereco + ", email=" + email + "]";
		}

		public void setIdCliente() {
			// TODO Auto-generated method stub
			
		}
	
		
		
	
		
		
}



