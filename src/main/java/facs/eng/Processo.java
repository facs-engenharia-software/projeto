package facs.eng;

import java.util.Date;

public class Processo {

	private Date data;
	private String tipo;
	private String status;
	private String descricao;
	private Date vencimento;

	public Processo(Date data, String tipo, String status, String descricao, Date vecimento) {
		this.data = data;
		this.tipo = tipo;
		this.status = status;
		this.descricao = descricao;
		this.vencimento = vencimento;

	}

	public void mostrarDetalhes() {
		System.out.println("Data + data");
		System.out.println("Tipo + tipo");
		System.out.println("Status + status");
		System.out.println("Descricao + descricao");
		System.out.println("Vencimento + vencimento");
	}
	public void setStatus(String status) {
		this.status = status;
	}
}