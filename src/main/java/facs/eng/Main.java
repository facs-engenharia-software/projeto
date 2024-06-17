package facs.eng;

import facs.db.DAOCliente;
import facs.db.DAOContrato;
import facs.db.DbPoolDeConexoes;

import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        DbPoolDeConexoes dbPoolDeConexoes = DbPoolDeConexoes.criar();

        Connection connectionCliente;
        DAOCliente daoCliente;
        String clienteNome, clienteEndereco, clienteTelefone;

        Connection connectionContrato;
        DAOContrato daoContrato;
        long contratoIdContrato;
        String contratoTipoContrato, contratoValidade, contratoStatus;
        Date contratoDataCelebracao;
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");

        String opcaoMenu;

        System.out.println("Bem-vindo ao miParalegal!");
        do {
            System.out.println("\nMENU PRINCIPAL");
            System.out.println("Digite 1 para cadastrar um novo cliente.");
            System.out.println("Digite 2 para buscar um cliente existente.");
            System.out.println("Digite 3 para editar os dados de um cliente.");
            System.out.println("Digite 4 para cadastrar um novo contrato.");
            System.out.println("Digite 5 para buscar um contrato existente.");
            System.out.println("Digite 6 para editar os dados de um contrato.");
            System.out.println("Digite 0 para encerrar o programa.");
            System.out.println("Digite a sua opção: ");
            opcaoMenu = sc.nextLine();
            switch (opcaoMenu) {
                case "0":
                    System.out.println("Encerrando programa...");
                    break;
                case "1":
                    connectionCliente = dbPoolDeConexoes.receberConexao();
                    daoCliente = DAOCliente.criarDAO(connectionCliente);
                    do {
                        System.out.println("Digite 1 para cadastrar um cliente PF.");
                        System.out.println("Digite 2 para cadastrar um cliente PJ.");
                        System.out.println("Digite 3 para retornar ao menu anterior.");
                        System.out.println("Digite a sua opção: ");
                        opcaoMenu = sc.nextLine();
                        switch (opcaoMenu) {
                            case "1":
                                System.out.println("Digite o CPF do cliente: ");
                                String cpf = sc.nextLine();
                                System.out.println("Digite o nome do cliente: ");
                                clienteNome = sc.nextLine();
                                System.out.println("Digite o endereço do cliente: ");
                                clienteEndereco = sc.nextLine();
                                System.out.println("Digite o telefone do cliente: ");
                                clienteTelefone = sc.nextLine();
                                daoCliente.inserir(new PessoaFisica(clienteNome, clienteEndereco, clienteTelefone, cpf));
                                opcaoMenu = "";
                                break;
                            case "2":
                                System.out.println("Digite o CNPJ do cliente: ");
                                String cnpj = sc.nextLine();
                                System.out.println("Digite o nome da empresa do cliente: ");
                                clienteNome = sc.nextLine();
                                System.out.println("Digite o nome do responsável: ");
                                String responsavel = sc.nextLine();
                                System.out.println("Digite o endereço do cliente: ");
                                clienteEndereco = sc.nextLine();
                                System.out.println("Digite o telefone do cliente: ");
                                clienteTelefone = sc.nextLine();
                                daoCliente.inserir(new PessoaJuridica(clienteNome, clienteEndereco, clienteTelefone, cnpj, responsavel));
                                opcaoMenu = "";
                                break;
                            case "3":
                                // retorna ao menu anterior
                                opcaoMenu = "";
                                break;
                            default:
                                System.out.println("Opção inválida.");
                        }
                    } while (!opcaoMenu.isEmpty());
                    dbPoolDeConexoes.liberarConexao(connectionCliente);
                    break;
                case "2":
                    connectionCliente = dbPoolDeConexoes.receberConexao();
                    daoCliente = DAOCliente.criarDAO(connectionCliente);
                    do {
                        System.out.println("Digite 1 para buscar um cliente PF.");
                        System.out.println("Digite 2 para buscar um cliente PJ.");
                        System.out.println("Digite 3 para retornar ao menu anterior.");
                        System.out.println("Digite a sua opção: ");
                        opcaoMenu = sc.nextLine();
                        switch (opcaoMenu) {
                            case "1":
                                System.out.println("Digite o CPF do cliente: ");
                                String cpf = sc.nextLine();
                                Cliente pessoaFisica = daoCliente.selecionar(cpf);
                                System.out.println("Resultado da busca:");
                                if (pessoaFisica == null) {
                                    System.out.println("Cliente não encontrado.");
                                } else {
                                    System.out.println("CPF: " + pessoaFisica.getIdReceitaFederal());
                                    System.out.println("Nome: " + pessoaFisica.getNome());
                                    System.out.println("Endereço: " + pessoaFisica.getEndereco());
                                    System.out.println("Telefone: " + pessoaFisica.getTelefone());
                                }
                                opcaoMenu = "";
                                break;
                            case "2":
                                System.out.println("Digite o CNPJ do cliente: ");
                                String cnpj = sc.nextLine();
                                Cliente pessoaJuridica = daoCliente.selecionar(cnpj);
                                System.out.println("Resultado da busca:");
                                if (pessoaJuridica == null) {
                                    System.out.println("Cliente não encontrado.");
                                } else {
                                    System.out.println("CNPJ: " + pessoaJuridica.getIdReceitaFederal());
                                    System.out.println("Nome: " + pessoaJuridica.getNome());
                                    System.out.println("Endereço: " + pessoaJuridica.getEndereco());
                                    System.out.println("Telefone: " + pessoaJuridica.getTelefone());
                                }
                                opcaoMenu = "";
                                break;
                            case "3":
                                // retorna ao menu anterior
                                opcaoMenu = "";
                                break;
                            default:
                                System.out.println("Opção inválida.");
                        }
                    } while (!opcaoMenu.isEmpty());
                    dbPoolDeConexoes.liberarConexao(connectionCliente);
                    break;
                case "3":
                    connectionCliente = dbPoolDeConexoes.receberConexao();
                    daoCliente = DAOCliente.criarDAO(connectionCliente);
                    do {
                        System.out.println("Digite 1 para editar os dados um cliente PF.");
                        System.out.println("Digite 2 para editar os dados um cliente PJ.");
                        System.out.println("Digite 3 para retornar ao menu anterior.");
                        System.out.println("Digite a sua opção: ");
                        opcaoMenu = sc.nextLine();
                        switch (opcaoMenu) {
                            case "1":
                                System.out.println("Digite o CPF do cliente: ");
                                String cpf = sc.nextLine();
                                if (daoCliente.selecionar(cpf) == null) {
                                    System.out.println("Cliente não encontrado.");
                                } else {
                                    do {
                                        System.out.println("Digite 1 para atualizar o nome do cliente.");
                                        System.out.println("Digite 2 para atualizar o endereço do cliente.");
                                        System.out.println("Digite 3 para atualizar o telefone do cliente.");
                                        System.out.println("Digite a sua opção: ");
                                        opcaoMenu = sc.nextLine();
                                        if (!opcaoMenu.equals("1") && !opcaoMenu.equals("2") && !opcaoMenu.equals("3")) {
                                            System.out.println("Opção inválida.");
                                        }
                                    } while (!opcaoMenu.equals("1") && !opcaoMenu.equals("2") && !opcaoMenu.equals("3"));
                                    System.out.println("Digite o novo valor: ");
                                    String novoValor = sc.nextLine();
                                    daoCliente.atualizar(Integer.parseInt(opcaoMenu), cpf, novoValor);
                                }
                                opcaoMenu = "";
                                break;
                            case "2":
                                System.out.println("Digite o CNPJ do cliente: ");
                                String cnpj = sc.nextLine();
                                if (daoCliente.selecionar(cnpj) == null) {
                                    System.out.println("Cliente não encontrado.");
                                } else {
                                    do {
                                        System.out.println("Digite 1 para atualizar o nome do cliente.");
                                        System.out.println("Digite 2 para atualizar o endereço do cliente.");
                                        System.out.println("Digite 3 para atualizar o telefone do cliente.");
                                        System.out.println("Digite 4 para atualizar o nome do responsável do cliente.");
                                        System.out.println("Digite a sua opção: ");
                                        opcaoMenu = sc.nextLine();
                                        if (!opcaoMenu.equals("1") && !opcaoMenu.equals("2") && !opcaoMenu.equals("3") && !opcaoMenu.equals("4")) {
                                            System.out.println("Opção inválida.");
                                        }
                                    } while (!opcaoMenu.equals("1") && !opcaoMenu.equals("2") && !opcaoMenu.equals("3") && !opcaoMenu.equals("4"));
                                    System.out.println("Digite o novo valor: ");
                                    String novoValor = sc.nextLine();
                                    daoCliente.atualizar(Integer.parseInt(opcaoMenu), cnpj, novoValor);
                                }
                                opcaoMenu = "";
                                break;
                            case "3":
                                // retorna ao menu anterior
                                opcaoMenu = "";
                                break;
                            default:
                                System.out.println("Opção inválida.");
                        }
                    } while (!opcaoMenu.isEmpty());
                    dbPoolDeConexoes.liberarConexao(connectionCliente);
                    break;
                case "4":
                    connectionContrato = dbPoolDeConexoes.receberConexao();
                    daoContrato = DAOContrato.criarDAO(connectionContrato);
                    connectionCliente = dbPoolDeConexoes.receberConexao();
                    daoCliente = DAOCliente.criarDAO(connectionCliente);
                    System.out.println("Digite o CPF ou CNPJ do cliente: ");
                    String cpfCnpj = sc.nextLine();
                    if (daoCliente.selecionar(cpfCnpj) == null) {
                        System.out.println("Cliente não encontrado. O contrato necessita de um cliente anteriormente cadastrado.");
                    } else {
                        System.out.println("Digite o identificador do contrato: ");
                        contratoIdContrato = Long.parseLong(sc.nextLine());
                        System.out.println("Digite o tipo do contrato (apenas no êxito, mensal fixo, inicial fixo, parcelas por etapa, misto): ");
                        contratoTipoContrato = sc.nextLine();
                        System.out.println("Digite a data de celebração do contrato (formato dd-mm-yyyy): ");
                        contratoDataCelebracao = df.parse(sc.nextLine());
                        System.out.println("Digite a validade do contrato: ");
                        contratoValidade = sc.nextLine();
                        System.out.println("Digite o status do contrado (válido, vencido, rescindido): ");
                        contratoStatus = sc.nextLine();
                        Contrato contrato = new Contrato(contratoIdContrato, contratoTipoContrato, contratoDataCelebracao, contratoValidade, contratoStatus, cpfCnpj);
                        daoContrato.inserir(contrato);
                    }
                    opcaoMenu = "";
                    dbPoolDeConexoes.liberarConexao(connectionContrato);
                    dbPoolDeConexoes.liberarConexao(connectionCliente);
                    break;
                case "5":
                    connectionContrato = dbPoolDeConexoes.receberConexao();
                    daoContrato = DAOContrato.criarDAO(connectionContrato);
                    System.out.println("Digite o identificador do contrato: ");
                    contratoIdContrato = Long.parseLong(sc.nextLine());
                    Contrato contrato = daoContrato.selecionar(contratoIdContrato);
                    System.out.println("Resultado da busca:");
                    if (contrato == null) {
                        System.out.println("Contrato não encontrado.");
                    } else {
                        System.out.println("Número do contrato: " + contrato.getIdContrato());
                        System.out.println("Tipo do contrato: " + contrato.getTipoContrato());
                        System.out.println("Data de celebração: " + df.format(contrato.getDataCelebracao()));
                        System.out.println("Validade: " + contrato.getValidade());
                        System.out.println("Status do contrato: " + contrato.getStatus());
                        System.out.println("Cliente: " + contrato.getCpfCnpjCliente());
                    }
                    opcaoMenu = "";
                    dbPoolDeConexoes.liberarConexao(connectionContrato);
                    break;
                case "6":
                    connectionContrato = dbPoolDeConexoes.receberConexao();
                    daoContrato = DAOContrato.criarDAO(connectionContrato);
                    System.out.println("Digite o identificador do contrato: ");
                    contratoIdContrato = Long.parseLong(sc.nextLine());
                    if (daoContrato.selecionar(contratoIdContrato) == null) {
                        System.out.println("Contrato não encontrado.");
                    } else {
                        do {
                            System.out.println("Digite 1 para atualizar o tipo do contrato.");
                            System.out.println("Digite 2 para atualizar a data de celebração do contrato.");
                            System.out.println("Digite 3 para atualizar a validade do contrato.");
                            System.out.println("Digite 4 para atualizar o status do contrato.");
                            System.out.println("Digite a sua opção: ");
                            opcaoMenu = sc.nextLine();
                            if (!opcaoMenu.equals("1") && !opcaoMenu.equals("2") && !opcaoMenu.equals("3") && !opcaoMenu.equals("4")) {
                                System.out.println("Opção inválida.");
                            }
                        } while (!opcaoMenu.equals("1") && !opcaoMenu.equals("2") && !opcaoMenu.equals("3") && !opcaoMenu.equals("4"));
                        System.out.println("Digite o novo valor: ");
                        String novoValor = sc.nextLine();
                        daoContrato.atualizar(Integer.parseInt(opcaoMenu), Long.toString(contratoIdContrato), novoValor);
                    }
                    opcaoMenu = "";
                    dbPoolDeConexoes.liberarConexao(connectionContrato);
                    break;
                default:
                    System.out.println("Opção inválida.");
                    continue;
            }
            if (!opcaoMenu.equals("0")) {
                System.out.println("Operação concluída.");
                System.out.println("Aperte qualquer botão para retornar ao menu inicial...");
                sc.nextLine();
            }
        } while (!opcaoMenu.equals("0"));

        sc.close();
        System.out.println("Programa encerrado.");
    }
}