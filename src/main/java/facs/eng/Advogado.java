package facs.eng;

import java.util.List;
import java.util.ArrayList;

public class Advogado {
	private String nome;
	private String numeroRegistro;
	private String endereco;
	private List<Processo> processos;

	public Advogado(String nome, String numeroRegistro, String endereco) {
		this.nome = nome;
		this.numeroRegistro = numeroRegistro;
		this.endereco = endereco;
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

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
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
