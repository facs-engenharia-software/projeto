package empresa2;

import java.util.List;
import java.util.ArrayList;

class Advogado {
	private String nome;
	private String numeroRegistro;
	private String cep;
	private List<Processo> processos;

	public Advogado(String nome, String numeroRegistro, String cep) {
		this.nome = nome;
		this.numeroRegistro = numeroRegistro;
		this.cep = cep;
		this.processos = new ArrayList<>();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNumeroRegistro() {
		return numeroRegistro;
	}

	public void setNumeroRegistro(String numeroRegistro) {
		this.numeroRegistro = numeroRegistro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public List<Processo> getProcessos() {
		return processos;
	}

	public void adicionarProcesso(Processo processo) {
		processos.add(processo);
	}

	public void editarProcesso(Processo processo, String novoStatus) {
		processo.setStatus(novoStatus);
	}
}
