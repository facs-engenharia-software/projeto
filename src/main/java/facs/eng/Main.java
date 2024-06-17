package facs.eng;

import facs.db.DAOCliente;
import facs.db.DbPoolDeConexoes;

import java.sql.Connection;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DbPoolDeConexoes dbPoolDeConexoes = DbPoolDeConexoes.criar();
        Connection connection;

        DAOCliente daoCliente;
        String clienteNome, clienteEndereco, clienteTelefone;

        String opcaoMenu;

        System.out.println("Bem-vindo ao miParalegal!");
        do {
            System.out.println("\nMENU PRINCIPAL");
            System.out.println("Digite 1 para cadastrar um novo cliente.");
            System.out.println("Digite 2 para buscar um cliente existente.");
            System.out.println("Digite 3 para editar os dados de um cliente.");
            System.out.println("Digite 0 para encerrar o programa.");
            System.out.println("Digite a sua opção: ");
            opcaoMenu = sc.nextLine();
            switch (opcaoMenu) {
                case "0":
                    System.out.println("Encerrando programa...");
                    break;
                case "1":
                    connection = dbPoolDeConexoes.receberConexao();
                    daoCliente = DAOCliente.criarDAO(connection);
                    do {
                        System.out.println("Digite 1 para cadastrar um cliente PF.");
                        System.out.println("Digite 2 para cadastrar um cliente PJ.");
                        System.out.println("Digite 3 para retornar ao menu anterior.");
                        System.out.println("Digite a sua opção: ");
                        opcaoMenu = sc.nextLine();
                        switch (opcaoMenu) {
                            case "1":
                                PessoaFisica pessoaFisica;
                                System.out.println("Digite o CPF do cliente: ");
                                String cpf = sc.nextLine();
                                System.out.println("Digite o nome do cliente: ");
                                clienteNome = sc.nextLine();
                                System.out.println("Digite o endereço do cliente: ");
                                clienteEndereco = sc.nextLine();
                                System.out.println("Digite o telefone do cliente: ");
                                clienteTelefone = sc.nextLine();
                                pessoaFisica = new PessoaFisica(clienteNome, clienteEndereco, clienteTelefone, cpf);
                                daoCliente.inserir(pessoaFisica);
                                opcaoMenu = "";
                                break;
                            case "2":
                                PessoaJuridica pessoaJuridica;
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
                                pessoaJuridica = new PessoaJuridica(clienteNome, clienteEndereco, clienteTelefone, cnpj, responsavel);
                                daoCliente.inserir(pessoaJuridica);
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
                    dbPoolDeConexoes.liberarConexao(connection);
                    break;
                case "2":
                    connection = dbPoolDeConexoes.receberConexao();
                    daoCliente = DAOCliente.criarDAO(connection);
                    do {
                        System.out.println("Digite 1 para buscar um cliente PF.");
                        System.out.println("Digite 2 para buscar um cliente PJ.");
                        System.out.println("Digite 3 para retornar ao menu anterior.");
                        System.out.println("Digite a sua opção: ");
                        opcaoMenu = sc.nextLine();
                        switch (opcaoMenu) {
                            case "1":
                                Cliente pessoaFisica;
                                System.out.println("Digite o CPF do cliente: ");
                                String cpf = sc.nextLine();
                                pessoaFisica = daoCliente.selecionar(cpf);
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
                                Cliente pessoaJuridica;
                                System.out.println("Digite o CNPJ do cliente: ");
                                String cnpj = sc.nextLine();
                                pessoaJuridica = daoCliente.selecionar(cnpj);
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
                    dbPoolDeConexoes.liberarConexao(connection);
                    break;
                case "3":
                    connection = dbPoolDeConexoes.receberConexao();
                    daoCliente = DAOCliente.criarDAO(connection);
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
                    dbPoolDeConexoes.liberarConexao(connection);
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