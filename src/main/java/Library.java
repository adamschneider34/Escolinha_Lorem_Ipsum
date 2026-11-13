import java.util.Scanner;

/**
 * 
 * Biblioteca principal da Escolinha Lorem Ipsum~
 * 
 * @author Adam!!
 */
public class Library {

    /**
     * Este método mostra o menu principal do sistema.
     * 
     * @param scanner Scanner para realizar a entrada de dados.
     * @param opcao1  Uma opção escolhida.
     */
    public static int menu(Scanner scanner) {
        System.out.println(
                "=================\nBem vindo ao sistema de cadastro e consulta da Escola LOREM IPSUM!\nQual operacao que gostarias de acionar?\n1-Cadastrar Aluno\n2-Listar Alunos\n3-Consultar Aluno\n4-Excluir Aluno\n5-Editar Aluno\n9-Sair\n===========");
        int opcao1 = scanner.nextInt();
        return opcao1;
    }

    public static void consultarAluno(int opcao2, int n, Scanner scanner, int[] idades, String[] nomes) {
        System.out.println("Consultando Aluno...");

        do {
            System.out.println(
                    "=================\nBem vindo ao sistema de consulta de alunos da Escola LOREM IPSUM!\nQual operacao que gostarias de acionar?\n1-Consultar por nome\n2-Consultar por idade\n3-Sair\n===========");
            opcao2 = scanner.nextInt();

            switch (opcao2) {
                case 1:
                    consultarNome(scanner, n, nomes, idades);
                    break;
                case 2:
                    consultarIdade(scanner, n, idades, nomes);
                    break;
                case 3:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opcao invalida X_X");
                    break;
            }
        } while (opcao2 != 3);

    }

    public static void listarAlunos(int n, String[] nomes, int[] idades) {
        System.out.println("Listando Alunos...");
        for (int i = 0; i < n; i++) {
            System.out.println("Nome: " + nomes[i] + " Idade: " + idades[i]);
        }
    }

    public static void consultarNome(Scanner scanner, int n, String[] nomes, int[] idades) {
        {
            System.out.println("Consultando Aluno por Nome...");
            System.out.println("====\nDigite o nome do aluno.");
            scanner.nextLine();
            String pesquisanome = scanner.nextLine();
            boolean flag = false;
            for (int i = 0; i < n; i++) {
                if (nomes[i].equalsIgnoreCase(pesquisanome)) {
                    System.out.println("Aluno achado!");
                    System.out.println("Nome: " + nomes[i] + " Idade: " + idades[i]);
                    flag = true;
                }
            }
            if (flag == false) {
                System.out.println("Nenhum aluno encontrado...");
            }
        }
    }

    public static void consultarIdade(Scanner scanner, int n, int[] idades, String[] nomes) {
        System.out.println("Consultando Aluno por Idade...");
        System.out.println("====\nDigite a idade do aluno.");
        scanner.nextLine();
        int pesquisaidade = Integer.parseInt(scanner.nextLine());
        boolean flag = false;
        for (int i = 0; i < n; i++) {
            if (idades[i] == pesquisaidade) {
                System.out.println("Aluno achado! " + nomes[i]);
                System.out.println("Nome: " + nomes[i] + " Idade: " + idades[i]);
                flag = true;
            }
        }
        if (flag == false) {
            System.out.println("Nenhum aluno encontrado...");
        }
    }
}