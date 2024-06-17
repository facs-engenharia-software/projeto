package facs.eng;


public abstract class Cliente {

	private String nome;
	private String endereco;
	private String telefone;
	private ListaContratos listaContratos;

	protected Cliente(String nome, String endereco, String telefone) {
		this.setNome(nome);
		this.setEndereco(endereco);
		this.setTelefone(telefone);
		this.listaContratos = new ListaContratos();
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return this.endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return this.telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public abstract String getIdReceitaFederal();

	public abstract void setIdReceitaFederal(String idReceitaFederal);

}
