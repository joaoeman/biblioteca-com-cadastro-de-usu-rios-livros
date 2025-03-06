import java.util.ArrayList;

public class biblioteca {
    ArrayList<livro> acervo = new ArrayList<>();
    ArrayList<usuario> usuarios = new ArrayList<>();

    private void adicionarUsuario(usuario humano) {
        usuarios.add(humano);
    }

    private void cadastrarLivro(livro livrinho) {
        acervo.add(livrinho);
    }

    private int catalivro(int id) {
        boolean existencia = false;
        int i = 0;

        for (; i < acervo.size(); i++) {
            if (acervo.get(i).id == id)
                existencia = true;
        }
        if (existencia)
            return i;
        else
            return -1;

    }

    private int catausuario(int id) {
        boolean existencia = false;
        int i = 0;

        for (; i < usuarios.size(); i++) {
            if (usuarios.get(i).id == id)
                existencia = true;
        }
        if (existencia)
            return i;
        else
            return -1;
    }

    private void alugar(int idlivro, int idusuario) {
        boolean existe = acervo.stream().anyMatch(livro -> livro.id == idlivro);
        boolean existe2 = usuarios.stream().anyMatch(usuario -> usuario.id == idusuario);

        if (existe && existe2) {
            int indice = catalivro(idlivro);
            int indice2 = catausuario(idusuario);

            if (!acervo.get(indice).emprestimo) {
                acervo.get(indice).emprestimo = true;
                usuarios.get(indice2).LivrosEmprestados.add(acervo.get(indice));
            } else
                System.out.println("Livro ja alugado");
        } else {
            System.out.println("O livro ou o usuario nao existe(m)");
        }
    }

    private void devolverLivro(int idlivro, int idusuario) {
        boolean existe = acervo.stream().anyMatch(livro -> livro.id == idlivro);
        boolean existe2 = usuarios.stream().anyMatch(usuario -> usuario.id == idusuario);

        if (existe && existe2) {
            int indice = catalivro(idlivro);
            int indice2 = catausuario(idusuario);
            boolean emprestou = usuarios.stream().anyMatch(usuario -> usuario.getLivrosEmprestados().stream().anyMatch(livro -> livro.getid() == idlivro));

            if (indice >= 0 && indice2 >= 0) {
                if (acervo.get(indice).emprestimo && emprestou) {
                    acervo.get(indice).emprestimo = false;
                    usuarios.get(indice2).LivrosEmprestados.remove(idlivro);
                } else {
                    System.out.println("Livro não alugado ainda");
                }
            } else
                System.out.println("Livro e/ou usuario não encontrado");

        }
    }
        public void listarlivroslivres(){
            System.out.println("Livros disponiveis para aluguel:");
            for(int i = 0; i<acervo.size();i++){
                if(!acervo.get(i).emprestimo){
                    System.out.printf("%d: %s\n",i,acervo.get(i).nome);
                }
            }
        }
    public void listalivrosemprestados(){
        System.out.println("Livros indisponiveis/alugados:");
        for(int i = 0; i<acervo.size();i++){
            if(!acervo.get(i).emprestimo){
                System.out.printf("%d: %s\n",i,acervo.get(i).nome);
            }
        }
    }


}

