import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int counterL=0;//contador para id de livros
        int counterU=0;//contador para id de usuarios
        biblioteca conjunto = new biblioteca();

        while(true) {
            int escolha;
            String nome,autor;
            boolean emprest=false;
            int choiceidL;
            int choiceidU;


            System.out.printf("Menu: \n1-cadastrar usuario/2-cadastrar livro\n3-alugar livro\n4-devolver livro\n5-consultar livros livres\n6-consultar livros alugados\n");
            escolha = input.nextInt();
            switch(escolha){

                case 1: System.out.println("Informe o nome do usuario:");
                    nome = input.nextLine();
                    usuario current = new usuario(nome,counterU);
                    conjunto.adicionarUsuario(current);
                    counterU++;
                break;
                case 2: System.out.println("Informe o nome e autor do livro:");
                    nome = input.nextLine();
                    autor = input.nextLine();
                    livro current2 = new livro(nome,autor,emprest,counterL);
                    conjunto.cadastrarLivro(current2);
                    counterL++;
                break;
                case 3: System.out.println("informe o id do usuario e livro para tentativa de aluguel:");
                    choiceidU = input.nextInt();
                    choiceidL = input.nextInt();
                    conjunto.alugar(choiceidL,choiceidU);
                break;
                case 4: System.out.println("informe o id do usuario e livro para tentativa de devolução:");
                    choiceidU = input.nextInt();
                    choiceidL = input.nextInt();
                    conjunto.devolverLivro(choiceidL,choiceidU);
                break;
                case 5: conjunto.listarlivroslivres();
                break;
                case 6: conjunto.listalivrosemprestados();
                break;
            }
            do {
                System.out.println("digite 1 para continuar ou 2 para sair");
                escolha = input.nextInt();
            }while(escolha != 1 || escolha !=2);
            if(escolha == 2)
                break;
        }
        }
    }
