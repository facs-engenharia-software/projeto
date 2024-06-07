package facs.eng;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class SistemaAdvocacia {
    private List<Cliente> clientes;
    private List<Advogado> advogados;
    private Object sessao;

    public SistemaAdvocacia() {
        this.clientes = new ArrayList<>();
        this.advogados = new ArrayList<>();
    }

    public void cadastrarPessoaFisica(String nome, String endereco, String telefone, String cpf) {
        Cliente cliente = new PessoaFisica(nome, endereco, telefone, cpf);
        clientes.add(cliente);
        System.out.println("Cliente " + nome + " cadastrado com sucesso!");
    }

    public void cadastrarAdvogado(String nome, String numeroRegistro, String cep) {
        Advogado advogado = new Advogado(nome, numeroRegistro, cep);
        advogados.add(advogado);
        System.out.println("Advogado " + nome + " cadastrado com sucesso!");
    }

    public void loginCliente(String cpf) {
        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equals(cpf)) {
                sessao = cliente;
                System.out.println("Cliente " + cliente.getNome() + " logado com sucesso!");
                return;
            }
        }
        System.out.println("CPF não encontrado.");
    }

    public void loginAdvogado(String numeroRegistro) {
        for (Advogado advogado : advogados) {
            if (advogado.getNumeroRegistro().equals(numeroRegistro)) {
                sessao = advogado;
                System.out.println("Advogado " + advogado.getNome() + " logado com sucesso!");
                return;
            }
        }
        System.out.println("Número de registro não encontrado.");
    }

    public void logout() {
        sessao = null;
        System.out.println("Saída realizada com sucesso!");
    }

    public void adicionarProcesso(String cpfCliente, String numeroRegistroAdvogado, Date data, String tipo, String status, String descricao, Date vencimento) {
        Cliente cliente = buscarCliente(cpfCliente);
        Advogado advogado = buscarAdvogado(numeroRegistroAdvogado);
        if (cliente != null && advogado != null) {
            Processo processo = new Processo(data, tipo, status, descricao, vencimento);
            cliente.adicionarProcesso(processo);
            advogado.adicionarProcesso(processo);
            System.out.println("Processo adicionado com sucesso ao cliente " + cliente.getNome() + " e advogado " + advogado.getNome() + "!");
        }
    }

    private Cliente buscarCliente(String cpf) {
        for (Cliente cliente : clientes) {
            if (cliente.getIdReceitaFederal().equals(cpf)) {
                return cliente;
            }
        }
        System.out.println("Cliente não encontrado.");
        return null;
    }

    private Advogado buscarAdvogado(String numeroRegistro) {
        for (Advogado advogado : advogados) {
            if (advogado.getNumeroRegistro().equals(numeroRegistro)) {
                return advogado;
            }
        }
        System.out.println("Advogado não encontrado.");
        return null;
    }

    public static void main(String[] args) {
        SistemaAdvocacia sistema = new SistemaAdvocacia();
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        boolean sair = false;

        while (!sair) {
            System.out.println("Sistema de Advocacia:");
            System.out.println("1. Cadastrar Cliente");
            System.out.println("2. Cadastrar Advogado");
            System.out.println("3. Login Cliente");
            System.out.println("4. Login Advogado");
            System.out.println("5. Adicionar Processo");
            System.out.println("6. Cancelar login");
            System.out.println("7. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consome a linha

            switch (opcao) {
                case 1:
                    System.out.print("CPF: ");
                    String cpf = scanner.nextLine();
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("CEP: ");
                    String cep = scanner.nextLine();
                    System.out.print("Telefone: ");
                    String telefone = scanner.nextLine();
                    sistema.cadastrarCliente(cpf, nome, cep, telefone);
                    break;
                case 2:
                    System.out.print("Nome: ");
                    String nomeAdvogado = scanner.nextLine();
                    System.out.print("Número de Registro: ");
                    String numeroRegistro = scanner.nextLine();
                    System.out.print("CEP: ");
                    String cepAdvogado = scanner.nextLine();
                    sistema.cadastrarAdvogado(nomeAdvogado, numeroRegistro, cepAdvogado);
                    break;
                case 3:
                    System.out.print("CPF do Cliente: ");
                    String cpfCliente = scanner.nextLine();
                    sistema.loginCliente(cpfCliente);
                    break;
                case 4:
                    System.out.print("Número de Registro do Advogado: ");
                    String numeroRegistroAdvogado = scanner.nextLine();
                    sistema.loginAdvogado(numeroRegistroAdvogado);
                    break;
                case 5:
                    System.out.print("CPF do Cliente: ");
                    String cpfCli = scanner.nextLine();
                    System.out.print("Número de Registro do Advogado: ");
                    String numRegAdv = scanner.nextLine();
                    System.out.print("Data (dd/MM/yyyy): ");
                    String dataStr = scanner.nextLine();
                    Date data = null;
                    try {
                        data = sdf.parse(dataStr);
                    } catch (ParseException e) {
                        System.out.println("Formato de data inválido.");
                        break;
                    }
                    System.out.print("Tipo: ");
                    String tipo = scanner.nextLine();
                    System.out.print("Status: ");
                    String status = scanner.nextLine();
                    System.out.print("Descrição: ");
                    String descricao = scanner.nextLine();
                    System.out.print("Vencimento (dd/MM/yyyy): ");
                    String vencimentoStr = scanner.nextLine();
                    Date vencimento = null;
                    try {
                    	vencimento = sdf.parse(vencimentoStr);
                    } catch (ParseException e) {
                    	System.out.println("Formato de data invalido.");
                    	break;
                    }
                    sistema.adicionarProcesso(cpfCli, numRegAdv, data, tipo, status, descricao, vencimento);
                    break;
                case 6:
                	sistema.logout();
                	break;
                case 7:
                	sair = true;
                	break;
                	default:
                		System.out.println("Opção invalida!");
                		
                		
            }
        }          
                   
         scanner.close();
    }
}          
                    
