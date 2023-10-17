package com.belemtour.model;

public class Destino {
	private int idDestino;
	private Pedido pedido;
	private String nomeDestino;
	private String categoriaDestino;
	private double valor;
		
		public enum Tempo{
			
			Dias,
			Semanas,
			Meses,
			
		}
		private Tempo tempo;
	
	
	public int getIdDestino() {
		return idDestino;
	}
	public void setIdDestino(int idDestino) {
		this.idDestino = idDestino;
	}
	public Pedido getPedido() {
		return pedido;
	}
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	public String getNomeDestino() {
		return nomeDestino;
	}
	public void setNomeDestino(String nomeDestino) {
		this.nomeDestino = nomeDestino;
	}
	public String getCategoriaDestino() {
		return categoriaDestino;
	}
	public void setCategoriaDestino(String categoriaDestino) {
		this.categoriaDestino = categoriaDestino;
	}
	
	
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getTempo() {
		return tempo.name();
	}  
	public void setTempo(String tempo) {
		if("Dias".equalsIgnoreCase(tempo)) {
			
			this.tempo = Tempo.Dias;
					
			
		} else if ("Semanas".equalsIgnoreCase(tempo)) {
			this.tempo = Tempo.Semanas;

		} else if ("Meses".equalsIgnoreCase(tempo)) {
			this.tempo= Tempo.Meses;

		
		} else {
			System.out.println(" Opção de tempo Invalida" + tempo);

			
			
		}
	}
	

}
