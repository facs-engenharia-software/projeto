package facs.eng;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Processo {

	private List<String> numProcesso;
	private Orgao orgaoJulgador;
	private String faseProcessual;
	private String natureza;
	private Cliente cliente;
	private String posicaoCliente;
	private String parteContraria;
	private Advogado advogado;
	private String status;
	private Date dataAjuizamento;
	private Contrato contrato;
	private ListaAndamentos andamentos;
	private ListaPrazos prazos;


	public Processo(String numero,
					Orgao orgaoJulgador,
					String faseProcessual,
					String natureza,
					Cliente cliente,
					String posicaoCliente,
					String parteContraria,
					Advogado advogado,
					String status,
					Date dataAjuizamento,
					Contrato contrato) {

		this.adicionarProcesso(numero);
		this.orgaoJulgador = orgaoJulgador;
		this.faseProcessual = faseProcessual;
		this.natureza = natureza;
		this.cliente = cliente;
		this.posicaoCliente = posicaoCliente;
		this.parteContraria = parteContraria;
		this.advogado = advogado;
		this.status = status;
		this.dataAjuizamento = dataAjuizamento;
		this.contrato = contrato;
	}

	public void adicionarProcesso(String novoNumero){
		if(numProcesso.size() >= 5) {
			System.out.println("Ação não permitida: Número máximo de processos alcançado!");
			return;
		}
		numProcesso.add(novoNumero);
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