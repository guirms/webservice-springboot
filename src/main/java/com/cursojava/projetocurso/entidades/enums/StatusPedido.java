package com.cursojava.projetocurso.entidades.enums;

public enum StatusPedido {
	
	AGUARDANDO_PAGAMENTO(1),
	PAGO(2),
	ENVIADO(3),
	RECEBIDO(4),
	CANCELADO(5);
	
	private int codigoTipoEnum;
	
	private StatusPedido(int codigoTipoEnum) {
		this.codigoTipoEnum = codigoTipoEnum;
	}
	
	public int getCodigoTipoEnum() {
		return codigoTipoEnum;
	}
	
	public static StatusPedido valorDe(int valor) {
		for (StatusPedido codigo : StatusPedido.values()) {
			if (codigo.getCodigoTipoEnum() == valor) {
				return codigo;
			}
		}
		throw new IllegalArgumentException("Código de busca inválido");
	}
	
}
