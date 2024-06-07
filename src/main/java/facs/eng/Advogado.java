package facs.eng;

import java.util.List;
import java.util.ArrayList;

public class Advogado {
	private String nome;
	private String numeroRegistro;
	private String endereco;

	public Advogado(String nome, String numeroRegistro, String endereco) {
		this.nome = nome;
		this.numeroRegistro = numeroRegistro;
		this.endereco = endereco;
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

}
