package facs.eng;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Processo {

	private List<String> numProcesso = new ArrayList<>();
	private Orgao orgaoJulgador;
	private String faseProcessual;
	private String natureza;
	private Cliente cliente;
	private String posicaoCliente;
	private List<ParteContraria> parteContraria;
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
					ParteContraria parteContraria,
					Advogado advogado,
					String status,
					Date dataAjuizamento,
					Contrato contrato) {

		this.adicionarNumProcesso(numero);
		this.orgaoJulgador = orgaoJulgador;
		this.faseProcessual = faseProcessual;
		this.natureza = natureza;
		this.cliente = cliente;
		this.posicaoCliente = posicaoCliente;
		this.parteContraria.add(parteContraria);
		this.advogado = advogado;
		this.status = status;
		this.dataAjuizamento = dataAjuizamento;
		this.contrato = contrato;
	}

	public void adicionarNumProcesso(String novoNumero){
		if(numProcesso.size() >= 5) {
			System.out.println("Ação não permitida: Número máximo de processos alcançado!");
			return;
		}
		numProcesso.add(novoNumero);
	}

	public void removerNumProcesso(String numero){
		numProcesso.remove(numero);
	}

	public void setOrgaoJulgador(Orgao orgaoJulgador) {
		this.orgaoJulgador = orgaoJulgador;
	}

	public void setFaseProcessual(String faseProcessual) {

		if(this.natureza.equals("procedimento administrativo")){
			setFaseAdministrativa(faseProcessual);
		} else setFaseJudicial(faseProcessual);
	}

	private void setFaseJudicial(String faseProcessual) {
		String primeiro = "1ª Grau";
		String segundo = "2º Grau";
		String superior = "Superior Tribunal de Justiça";
		String supremo = "Supremo Tribunal Federal";

		switch (faseProcessual.toLowerCase()) {
			case "1º grau":
				this.faseProcessual = primeiro;
			case "primeiro grau":
				this.faseProcessual = primeiro;
			case "1 grau":
				this.faseProcessual = primeiro;
			case "2º grau":
				this.faseProcessual = segundo;
			case "segundo grau":
				this.faseProcessual = segundo;
			case "2 grau":
				this.faseProcessual = segundo;
			case "stj":
				this.faseProcessual = superior;
			case "superior tribunal de justiça":
				this.faseProcessual = superior;
			case "superior tribunal de justica":
				this.faseProcessual = superior;
			case "stf":
				this.faseProcessual = supremo;
			case "supremo tribunal federal":
				this.faseProcessual = supremo;
			default:
				throw new IllegalArgumentException("Argumento inválido! Por favor, tente novamente");
		}
	}

	private void setFaseAdministrativa(String faseProcessual) {
		String primeiro = "1ª Grau";
		String segundo = "2º Grau";
		String especial = "Especial";

		switch (faseProcessual.toLowerCase()) {
			case "1º grau":
				this.faseProcessual = primeiro;
			case "primeiro grau":
				this.faseProcessual = primeiro;
			case "1 grau":
				this.faseProcessual = primeiro;
			case "2º grau":
				this.faseProcessual = segundo;
			case "segundo grau":
				this.faseProcessual = segundo;
			case "2 grau":
				this.faseProcessual = segundo;
			case "especial":
				this.faseProcessual = especial;
			case "3º grau":
				this.faseProcessual = especial;
			case "terceiro grau":
				this.faseProcessual = especial;
			case "3 grau":
				this.faseProcessual = especial;
			default:
				throw new IllegalArgumentException("Argumento inválido! Por favor, tente novamente");
		}
	}

	public void setNatureza(String natureza) {

			switch (natureza.toLowerCase()){
			case "civel":
				this.natureza = "cível comum";
			case "cível":
				this.natureza = "cível comum";
			case "civil":
				this.natureza = "cível comum";
			case "consumidor":
				this.natureza = natureza;
			case "familia":
				this.natureza = natureza;
			case "família":
				this.natureza = natureza;
			case "empresarial":
				this.natureza = natureza;
			case "tributario":
				this.natureza = natureza;
			case "tributário":
				this.natureza = natureza;
			case "penal":
				this.natureza = natureza;
			case "previdenciario":
				this.natureza = natureza;
			case "previdenciário":
				this.natureza = natureza;
			case "trabalhista":
				this.natureza = natureza;
			case "ambiental":
				this.natureza = natureza;
			case "eleitoral":
				this.natureza = natureza;
			case "publico":
				this.natureza = natureza;
			case "público":
				this.natureza = natureza;
			case "procedimento administrativo":
				this.natureza = natureza;
			case "outros":
				this.natureza = natureza;
			default:
				throw new IllegalArgumentException("Natureza processual inválida! Tente novamente");
		}

	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public void setPosicaoCliente(String posicaoCliente) {
		this.posicaoCliente = posicaoCliente;
	}

	public void adicionarParteContraria(ParteContraria parteContraria) {
		this.parteContraria.add(parteContraria);
	}

	public void removerParteContraria(ParteContraria parteContraria) {
		this.parteContraria.remove(parteContraria);
	}

	public void setAdvogado(Advogado advogado) {
		this.advogado = advogado;
	}

	public void setStatus(String status) {
		if(status.equalsIgnoreCase("em andamento") ||
				status.equalsIgnoreCase("suspenso") ||
				status.equalsIgnoreCase("arquivado temporariamente") ||
				status.equalsIgnoreCase("finalizado")) {
			this.status = status;
		} else throw new IllegalArgumentException("Argumento inválido! Por favor, tente novamente");
	}

	public void setDataAjuizamento(Date dataAjuizamento) {
		this.dataAjuizamento = dataAjuizamento;
	}

	public void setContrato(Contrato contrato) {
		this.contrato = contrato;
	}

	public List<String> getNumeroProcesso(){
		return this.numProcesso;
	}

	public Orgao getOrgaoJulgador() {
		return this.orgaoJulgador;
	}

	public String getFaseProcessual() {
		return this.faseProcessual;
	}

	public String getNatureza() {
		return this.natureza;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public String getPosicaoCliente() {
		return this.posicaoCliente;
	}

	public List<ParteContraria> getParteContraria() {
		return this.parteContraria;
	}

	public Advogado getAdvogado() {
		return this.advogado;
	}

	public String getStatus() {
		return this.status;
	}

	public Date getDataAjuizamento() {
		return this.dataAjuizamento;
	}

	public Contrato getContrato() {
		return this.contrato;
	}

}