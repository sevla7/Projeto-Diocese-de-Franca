package org.example;
import org.example.Atualizacao.AtualizacaoDAO;
import org.example.Categoria.CategoriaDAO;
import org.example.Chamado.ChamadoDAO;
import org.example.Desenvolvedor.DesenvolvedorDAO;
import org.example.Fiel.FielDAO;

import java.util.List;
import java.util.Scanner;

public class App
{
    public static void main( String[] args )
    {
        DesenvolvedorDAO Devdao = new DesenvolvedorDAO();
        FielDAO Fieldao = new FielDAO();
        ChamadoDAO ChamadoDao = new ChamadoDAO();
        CategoriaDAO CategoriaDao = new CategoriaDAO();
        AtualizacaoDAO AtualizacaoDao = new AtualizacaoDAO();
        Scanner entrada  = new Scanner(System.in);
        String nome, email, paroquia, senha, titulo, descricao, status, prioridade, devolutiva;
        String data_fechamento;
        int id_chamado, id_fiel, id_dev, id_categoria;
        int opcao, opcaoDev, opcaoFiel, opcaoChamado, opcaoCategoria, opcaoAtualizacao, id;

        do {
            System.out.println("\n===== Menu Principal =====");
            System.out.println("1 - Gerenciar Desenvolvedores");
            System.out.println("2 - Gerenciar Fiéis");
            System.out.println("3 - Gerenciar Chamados");
            System.out.println("4 - Gerenciar Categorias");
            System.out.println("5 - Gerenciar Atualizações");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            opcao = entrada.nextInt();

            switch (opcao) {
                // ... (Case 1 - Menu Desenvolvedor - Inalterado) ...
                case 1:
                    // Submenu Desenvolvedor
                    do {
                        System.out.println("\n--- Menu Desenvolvedor ---");
                        System.out.println("1 - Cadastrar Desenvolvedor");
                        System.out.println("2 - Alterar Desenvolvedor");
                        System.out.println("3 - Excluir Desenvolvedor");
                        System.out.println("4 - Listar Desenvolvedores");
                        System.out.println("0 - Voltar ao Menu Principal");
                        System.out.print("Escolha: ");
                        opcaoDev = entrada.nextInt();


                        switch (opcaoDev) {
                            case 1:
                                System.out.print("\nDigite o nome do desenvolvedor: ");
                                nome = entrada.next(); // permite nome composto
                                System.out.print("Digite o Email: ");
                                email = entrada.nextLine();
                                entrada.next(); // limpa o ENTER
                                Devdao.inserir(nome, email);
                                break;

                            case 2:
                                System.out.print("\nDigite o ID do desenvolvedor para alterar: ");
                                id = entrada.nextInt();
                                entrada.nextLine(); // limpa o ENTER
                                System.out.print("Digite o NOVO nome do desenvolvedor: ");
                                nome = entrada.nextLine();
                                System.out.print("Digite o NOVO email: ");
                                email = entrada.nextLine();
                                Devdao.atualizar(id, nome, email);
                                break;

                            case 3:
                                System.out.print("\nDigite o ID do desenvolvedor para excluir: ");
                                id = entrada.nextInt();
                                entrada.nextLine(); // limpa o ENTER
                                Devdao.remover(id);
                                break;

                            case 4:
                                System.out.println("\nLista de desenvolvedores: ");
                                List<String> devs = Devdao.listar();
                                if (devs.isEmpty()) {
                                    System.out.println("Sem desenvolvedor cadastrado");
                                } else {
                                    for (String dev : devs) {
                                        System.out.println(dev);
                                    }
                                }
                                break;

                            case 0:
                                System.out.println("Voltando ao Menu Principal...");
                                break;

                            default:
                                System.out.println("Opção inválida!");
                        }
                    } while (opcaoDev != 0);
                    break;

                case 2:
                    // Submenu Fiel
                    do {
                        System.out.println("\n--- Menu Fiel ---");
                        System.out.println("1 - Cadastrar Fiel");
                        System.out.println("2 - Alterar Fiel");
                        System.out.println("3 - Excluir Fiel");
                        System.out.println("4 - Listar Fiéis");
                        System.out.println("0 - Voltar ao Menu Principal");
                        System.out.print("Escolha: ");
                        opcaoFiel = entrada.nextInt();
                        entrada.nextLine(); // limpa o ENTER

                        switch (opcaoFiel) {
                            case 1:
                                System.out.print("\nDigite o nome do fiel: ");
                                nome = entrada.nextLine();
                                System.out.print("Digite o Email: ");
                                email = entrada.nextLine();
                                System.out.print("Digite a Paróquia: ");
                                paroquia = entrada.nextLine();
                                System.out.print("Digite a Senha: ");
                                senha = entrada.nextLine();
                                Fieldao.inserir(nome, email, paroquia, senha);
                                break;

                            case 2:
                                System.out.print("\nDigite o ID do fiel para alterar: ");
                                id = entrada.nextInt();
                                entrada.nextLine(); // limpa o ENTER
                                System.out.print("Digite o NOVO nome do fiel: ");
                                nome = entrada.nextLine();
                                System.out.print("Digite o NOVO email: ");
                                email = entrada.nextLine();
                                System.out.print("Digite a NOVA Paróquia: ");
                                paroquia = entrada.nextLine();
                                Fieldao.atualizar(id, nome, email, paroquia);
                                break;

                            case 3:
                                System.out.print("\nDigite o ID do fiel para excluir: ");
                                id = entrada.nextInt();
                                entrada.nextLine(); // limpa o ENTER
                                Fieldao.remover(id);
                                break;

                            case 4:
                                System.out.println("\nLista de fiéis: ");
                                List<String> fieis = Fieldao.listar();
                                if (fieis.isEmpty()) {
                                    System.out.println("Sem fiel cadastrado");
                                } else {
                                    for (String fiel : fieis) {
                                        System.out.println(fiel);
                                    }
                                }
                                break;

                            case 0:
                                System.out.println("Voltando ao Menu Principal...");
                                break;

                            default:
                                System.out.println("Opção inválida!");
                        }
                    } while (opcaoFiel != 0);
                    break;

                case 3:
                    // Submenu Chamado
                    do {
                        System.out.println("\n--- Menu Chamado ---");
                        System.out.println("1 - Abrir Chamado");
                        System.out.println("2 - Alterar Chamado");
                        System.out.println("3 - Excluir Chamado");
                        System.out.println("4 - Listar Chamados");
                        System.out.println("0 - Voltar ao Menu Principal");
                        System.out.print("Escolha: ");
                        opcaoChamado = entrada.nextInt();
                        entrada.nextLine(); // limpa o ENTER

                        switch (opcaoChamado) {
                            case 1:
                                // Inserir Chamado
                                System.out.println("\nDigite o id do fiel: ");
                                id_fiel = entrada.nextInt();
                                entrada.nextLine(); // limpa o enter
                                System.out.println("\nDigite o id do desenvolvedor: ");
                                id_dev = entrada.nextInt();
                                System.out.println("\nDigite o id da categoria: ");
                                id_categoria = entrada.nextInt();
                                entrada.nextLine();
                                System.out.print("Digite o Título do Chamado: ");
                                titulo = entrada.nextLine();
                                System.out.print("Digite a Descrição: ");
                                descricao = entrada.nextLine();
                                System.out.print("Digite o Status (Ex: Aberto): ");
                                status = entrada.nextLine();
                                System.out.print("Digite a Prioridade (Ex: Alta, Baixa): ");
                                prioridade = entrada.nextLine();
                                System.out.println("Digite a data de fechamento: ");
                                data_fechamento = entrada.nextLine();
                                ChamadoDao.inserir(id_fiel, id_dev, id_categoria, titulo,
                                        descricao, status, prioridade, data_fechamento);
                                break;

                            case 2:
                                // Atualizar Chamado
                                System.out.print("\nDigite o ID do Chamado para alterar: ");
                                id = entrada.nextInt();
                                entrada.nextLine(); // limpa o ENTER
                                System.out.print("Digite o NOVO Título: ");
                                titulo = entrada.nextLine();
                                System.out.print("Digite a NOVA Descrição: ");
                                descricao = entrada.nextLine();
                                System.out.print("Digite o NOVO Status: ");
                                status = entrada.nextLine();
                                System.out.print("Digite a NOVA Prioridade: ");
                                prioridade = entrada.nextLine();
                                ChamadoDao.atualizar(id, titulo, descricao, status, prioridade);
                                break;

                            case 3:
                                // Remover Chamado
                                System.out.print("\nDigite o ID do Chamado para excluir: ");
                                id = entrada.nextInt();
                                entrada.nextLine(); // limpa o ENTER
                                ChamadoDao.remover(id);
                                break;

                            case 4:
                                // Listar Chamados
                                System.out.println("\nLista de Chamados: ");
                                List<String> chamados = ChamadoDao.listar();
                                if (chamados.isEmpty()) {
                                    System.out.println("Sem chamado cadastrado");
                                } else {
                                    for (String chamado : chamados) {
                                        System.out.println(chamado);
                                    }
                                }
                                break;

                            case 0:
                                System.out.println("Voltando ao Menu Principal...");
                                break;

                            default:
                                System.out.println("Opção inválida!");
                        }
                    } while (opcaoChamado != 0);
                    break;

                case 4:
                    // Submenu Categoria
                    do {
                        System.out.println("\n--- Menu Categoria ---");
                        System.out.println("1 - Cadastrar Categoria");
                        System.out.println("2 - Alterar Categoria");
                        System.out.println("3 - Excluir Categoria");
                        System.out.println("4 - Listar Categorias");
                        System.out.println("0 - Voltar ao Menu Principal");
                        System.out.print("Escolha: ");
                        opcaoCategoria = entrada.nextInt();
                        entrada.nextLine(); // limpa o ENTER

                        switch (opcaoCategoria) {
                            case 1:
                                System.out.print("\nDigite o nome da Categoria: ");
                                nome = entrada.next();
                                CategoriaDao.inserir(nome);
                                break;

                            case 2:
                                System.out.print("\nDigite o ID da Categoria para alterar: ");
                                id = entrada.nextInt();
                                System.out.print("Digite o NOVO nome da categoria: ");
                                nome = entrada.next();
                                CategoriaDao.atualizar(id, nome);
                                break;

                            case 3:
                                System.out.print("\nDigite o ID do categoria para excluir: ");
                                id = entrada.nextInt();
                                entrada.nextLine(); // limpa o ENTER
                                CategoriaDao.remover(id);
                                break;

                            case 4:
                                System.out.println("\nLista de Categorias: ");
                                List<String> categorias = CategoriaDao.listar();
                                if (categorias.isEmpty()) {
                                    System.out.println("Sem categoria cadastrada");
                                } else {
                                    for (String categoria : categorias) {
                                        System.out.println(categoria);
                                    }
                                }
                                break;

                            case 0:
                                System.out.println("Voltando ao Menu Principal...");
                                break;

                            default:
                                System.out.println("Opção inválida!");
                        }

                    } while (opcaoCategoria != 0);


                case 5:
                    // Submenu Atualização
                    do {
                        System.out.println("\n--- Menu Atualização ---");
                        System.out.println("1 - Cadastrar Atualização");
                        System.out.println("2 - Alterar Atualização");
                        System.out.println("3 - Excluir Atualização");
                        System.out.println("4 - Listar Atualizações");
                        System.out.println("0 - Voltar ao Menu Principal");
                        System.out.print("Escolha: ");
                        opcaoAtualizacao = entrada.nextInt();

                        switch (opcaoAtualizacao) {
                            case 1:
                                System.out.print("Digite o id do chamado: ");
                                id_chamado = entrada.nextInt();
                                System.out.println("Digite a devolutiva do chamado: ");
                                devolutiva = entrada.next();
                                AtualizacaoDao.inserir(id_chamado, devolutiva);
                                break;

                            case 2:
                                System.out.print("\nDigite o ID da atualização para alterar: ");
                                id = entrada.nextInt();
                                System.out.print("Digite a NOVA devolutiva da atualização: ");
                                devolutiva = entrada.next();
                                AtualizacaoDao.atualizar(id, devolutiva);
                                break;

                            case 3:
                                System.out.print("\nDigite o ID da atualização para excluir: ");
                                id = entrada.nextInt();
                                entrada.nextLine(); // limpa o ENTER
                                AtualizacaoDao.remover(id);
                                break;

                            case 4:
                                System.out.println("\nLista de atualizações: ");
                                List<String> atualizacoes = AtualizacaoDao.listar();
                                if (atualizacoes.isEmpty()) {
                                    System.out.println("Sem atualização cadastrada");
                                } else {
                                    for (String atualizacao : atualizacoes) {
                                        System.out.println(atualizacao);
                                    }
                                }
                                break;

                            case 0:
                                System.out.println("Voltando ao Menu Principal...");
                                break;

                            default:
                                System.out.println("Opção inválida!");
                        }
                    } while (opcaoAtualizacao != 0);
                    break;

                case 0:
                    System.out.println("Encerrando o programa...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);

        entrada.close();
    }
}