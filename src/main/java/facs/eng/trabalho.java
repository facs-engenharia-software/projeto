package empresa;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

class Cliente {
    private String cpf;
    private String nome;
    private String cep;
    private String telefone;
    private List<Processo> processos;

    public Cliente(String cpf, String nome, String cep, String telefone) {
        this.cpf = cpf;
        this.nome = nome;
        this.cep = cep;
        this.telefone = telefone;
        this.processos = new ArrayList<>();
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public List<Processo> getProcessos() {
        return processos;
    }

    public void visualizarProcessos() {
        for (Processo processo : processos) {
            processo.mostrarDetalhes();
        }
    }

    public void adicionarProcesso(Processo processo) {
        processos.add(processo);
    }
}

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

class Processo {
    private Date data;
    private String tipo;
    private String status;
    private String descricao;
    private Date vencimento;

    public Processo(Date data, String tipo, String status, String descricao, Date vencimento) {
        this.data = data;
        this.tipo = tipo;
        this.status = status;
        this.descricao = descricao;
        this.vencimento = vencimento;
    }

    public void mostrarDetalhes() {
        System.out.println("Data: " + data);
        System.out.println("Tipo: " + tipo);
        System.out.println("Status: " + status);
        System.out.println("Descrição: " + descricao);
        System.out.println("Vencimento: " + vencimento);
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

class SistemaAdvocacia {
    private List<Cliente> clientes;
    private List<Advogado> advogados;
    private Object sessao;

    public SistemaAdvocacia() {
        this.clientes = new ArrayList<>();
        this.advogados = new ArrayList<>();
    }

    public void cadastrarCliente(String cpf, String nome, String cep, String telefone) {
        Cliente cliente = new Cliente(cpf, nome, cep, telefone);
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
        System.out.println("saida realizado com sucesso!");
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
            if (cliente.getCpf().equals(cpf)) {
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
                        System.out.println("Formato de data inválido.");
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
                    System.out.println("Opção inválida!");
            }
        }

        scanner.close();
    }
}