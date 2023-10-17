package com.belemtour.model;

import java.time.LocalDateTime;


public class Pedido {
	private int idPedido;
	private Cliente cliente;
	private LocalDateTime DataPedido;
	private String status;
	
	public enum FormaPagamento{
		
		Debito,
		credito,
		pix,
		boleto
	}
private FormaPagamento formaPagamento;
public int getIdPedido() {
	return idPedido;
}


public void setIdPedido(int idPedido) {
	this.idPedido = idPedido;
}
public Cliente getCliente() {
	return cliente;
}
public void setCliente(Cliente cliente) {
	this.cliente = cliente;
}


public LocalDateTime getDataPedido() {
	return DataPedido;
}


public void setDataPedido(LocalDateTime dataPedido) {
	DataPedido = dataPedido;
}


public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public String getFormaPagamento() {
	return formaPagamento.name();
}  
public void setFormaPagamento(String formaPagamento) {
	if("Debito".equalsIgnoreCase(formaPagamento)) {
		
		this.formaPagamento = FormaPagamento.Debito;
		
	} else if ("Credito".equalsIgnoreCase(formaPagamento)) {
		this.formaPagamento = FormaPagamento.credito;

	} else if ("Pix".equalsIgnoreCase(formaPagamento)) {
		this.formaPagamento = FormaPagamento.pix;

	} else if ("Boleto".equalsIgnoreCase(formaPagamento)) {
		this.formaPagamento = FormaPagamento.boleto;
		
	} else {
		System.out.println(" Opção de Pagamento Invalida" + formaPagamento);

		
		
	}
	
	
}


@Override
public String toString() {
	return "Pedido [idPedido=" + idPedido + ", cliente=" + cliente + ", dataPedido=" + DataPedido + ", status=" + status
			+ ", formaPagamento=" + formaPagamento + "]";
}







}
