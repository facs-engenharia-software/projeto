package facs.eng;

import java.util.List;
import java.util.ArrayList;

public class Cliente {

	private String cpf;
	private String nome;
	private String cep;
	private String telefone;
	private List<Processo> processos;

	public void Cliente(String cpf, String nome, String cep, String telefone) {
		this.cpf = cpf;
		this.nome = nome;
		this.cep = cep;
		this.telefone = telefone;
		this.processos = new ArrayList<>();
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public List<Processo> getProcessos() {
		return processos;
	}

	public void setProcessos(List<Processo> processos) {
		this.processos = processos;
	}

	public void visualizarProcessos() {
		for (Processo processo : processos) {
			processo.mostrarDetalhes();
		}
	}

	public void adiconarProcesso(Processo processo) {
		processos.add(processo);
	}
	public void adicionarProcesso(Processo processo) {
		processos.add(processo);
	}

	public void editarProcesso(Processo processo, String novoStatus) {
		processo.setStatus(novoStatus);
	}

}
