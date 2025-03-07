import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int counterL = 0; // Contador para id de livros
        int counterU = 0; // Contador para id de usuários
        biblioteca conjunto = new biblioteca();

        while (true) {
            int escolha;
            String nome, autor;
            boolean emprest = false;
            int choiceidL;
            int choiceidU;

            System.out.printf(
                    "Menu: \n1-cadastrar usuario\n2-cadastrar livro\n" +
                            "3-alugar livro\n4-devolver livro\n" +
                            "5-consultar livros livres\n6-consultar livros alugados\n"
            );

            try {
                escolha = input.nextInt();
                input.nextLine(); // Consome a quebra de linha após o nextInt()

                switch (escolha) {
                    case 1:
                        System.out.println("Informe o nome do usuario:");
                        nome = input.nextLine();
                        usuario current = new usuario(nome, counterU);
                        conjunto.adicionarUsuario(current);
                        counterU++;
                        break;

                    case 2:
                        System.out.println("Informe o nome e autor do livro:");
                        nome = input.nextLine();
                        autor = input.nextLine();
                        livro current2 = new livro(nome, autor, emprest, counterL);
                        conjunto.cadastrarLivro(current2);
                        counterL++;
                        break;

                    case 3:
                        System.out.println("Informe o id do usuario e livro para tentativa de aluguel:");
                        choiceidU = input.nextInt();
                        choiceidL = input.nextInt();
                        input.nextLine(); // Consome a quebra de linha
                        conjunto.alugar(choiceidL, choiceidU);
                        break;

                    case 4:
                        System.out.println("Informe o id do usuario e livro para tentativa de devolução:");
                        choiceidU = input.nextInt();
                        choiceidL = input.nextInt();
                        input.nextLine(); // Consome a quebra de linha
                        conjunto.devolverLivro(choiceidL, choiceidU);
                        break;

                    case 5:
                        conjunto.listarlivroslivres();
                        break;

                    case 6:
                        conjunto.listalivrosemprestados();
                        break;

                    default:
                        System.out.println("Número digitado não tem função.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Digite um número.");
                input.nextLine(); // Limpa o buffer do Scanner
                continue; // Volta ao início do loop
            }

            // Pergunta se o usuário deseja continuar
            int continuar;
            do {
                System.out.println("Digite 1 para continuar ou 2 para sair");
                continuar = input.nextInt();
                input.nextLine(); // Consome a quebra de linha
            } while (continuar != 1 && continuar != 2);

            if (continuar == 2) {
                break; // Sai do loop principal
            }
        }

        input.close(); // Fecha o Scanner
        System.out.println("Programa encerrado.");
    }
}