import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static String nomes[] = new String[100];
    static int idades[] = new int[100];
    static int opcao2;
    int opcao1;
    static int n = 0;

    public static void cadastrarAluno() {
        System.out.println("Cadastrando Aluno...");
        if (n > 100) {
            System.out.println("A escola esta cheia!!");
        } else {
            System.out.println("Insira o NOME e a IDADE do aluno.");
            System.out.println("----");
            System.out.println("Nome:");
            scanner.nextLine();
            String nome = scanner.nextLine();
            System.out.println("Idade:");
            int idade = Integer.parseInt(scanner.nextLine());
            nomes[n] = nome;
            idades[n] = idade;
            n++;
        }
    }

    public static int procurarPosicaoNomeAluno(String nomePesquisa) {
        int posicaoExcluir = -1;
        for (int i = 0; i < n; i++) {
            if (nomes[i].equalsIgnoreCase(nomePesquisa)) {
                posicaoExcluir = i;
            }
        }
        return posicaoExcluir;
    }

    public static void excluirAluno() {
        System.out.println("Excluindo Aluno...");
        System.out.println("====\nDigite o nome do aluno.");
        scanner.nextLine();
        String nomeExcluir = scanner.nextLine();
        int posicaoConsulta = procurarPosicaoNomeAluno(nomeExcluir);
        if (posicaoConsulta != -1) {
            for (int i = posicaoConsulta; i < n - 1; i++) {
                nomes[i] = nomes[i + 1];
                idades[i] = idades[i + 1];
            }
            n = n - 1;
            System.out.println("Exclusao realizada com sucesso!");
        } else {
            System.out.println("Ninguem para excluir com esse nome!");
        }
    }

    public static void editarAluno() {
        System.out.println("Editando Aluno...");
        System.out.println("====\nDigite o nome do aluno.");
        scanner.nextLine();
        String alterarNome = scanner.nextLine();
        System.out.println("====\nQual dado gostarias de editar?");
        System.out.println("1 - Nome");
        System.out.println("2 - Idade");
        int opcao3 = Integer.parseInt(scanner.nextLine());

        switch (opcao3) {
            case 1:
                for (int i = 0; i < n; i++) {
                    if (nomes[i].equalsIgnoreCase(alterarNome)) {
                        System.out.println("====\nEscreva o novo nome.");
                        System.out.println("----");
                        System.out.println("Nome:");
                        nomes[i] = scanner.nextLine();
                    }
                }
                break;

            case 2:
                for (int i = 0; i < n; i++) {
                    if (nomes[i].equalsIgnoreCase(alterarNome)) {
                        System.out.println("====\nEscreva a nova idade.");
                        System.out.println("----");
                        System.out.println("Idade:");
                        idades[i] = Integer.parseInt(scanner.nextLine());
                    }
                }
                break;

            default:
                System.out.println("AAAAAAAAAAAAAA");
                break;
        }
    }

    public static void main(String[] args) {

        // Entrada

        do {
            Library.menu(scanner);
            switch (opcao1) {
                case 1:
                    cadastrarAluno();
                    break;
                case 2:
                    Library.listarAlunos(n, nomes, idades);
                    break;
                case 3:
                    Library.consultarAluno(opcao2, n, scanner, idades, nomes);
                    break;
                case 4:
                    excluirAluno();
                    break;
                case 5:
                    editarAluno();
                    break;
                case 9:
                    System.out.println("Tchau-tchau! Ate mais!");
                    break;
                default:
                    System.out.println("Opcao invalida X_X");
                    break;
            }
        } while (opcao1 != 9);
        scanner.close();
    }
}