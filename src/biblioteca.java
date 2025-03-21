import java.util.ArrayList;

public class biblioteca {
    ArrayList<livro> acervo = new ArrayList<>();
    ArrayList<usuario> usuarios = new ArrayList<>();

    void adicionarUsuario(usuario humano) {
        this.usuarios.add(humano);
    }

     void cadastrarLivro(livro livrinho) {
        this.acervo.add(livrinho);
    }

    int cataLivro(int id) {
        boolean existencia = false;
        int i = 0;

        for (; i < this.acervo.size(); i++) {
            if (this.acervo.get(i).id == id){
                existencia = true;
                break;
            }
        }
        return (existencia)? (i) : (-1);
    }

    int catausuario(int id) {
        boolean existencia = false;
        int i = 0;

        for (; i < this.usuarios.size(); i++) {
            if (this.usuarios.get(i).id == id){
                existencia = true;
                break;
            }
        }
        return (existencia)? (i) : (-1);

    }

    void alugar(int idlivro, int idusuario) {
        boolean existe = acervo.stream().anyMatch(livro -> livro.id == idlivro);
        boolean existe2 = usuarios.stream().anyMatch(usuario -> usuario.id == idusuario);

        if (existe && existe2) {
            int indice = cataLivro(idlivro);
            int indice2 = catausuario(idusuario);

            if (!this.acervo.get(indice).estado.retornalogico()) {
                this.acervo.get(indice).estado = estadoemprestimo.EMPRESTADO;
                this.usuarios.get(indice2).LivrosEmprestados.add(acervo.get(indice));
            } else
                System.out.println("Livro ja alugado");
        } else {
            System.out.println("O livro ou o usuario nao existe(m)");
        }
    }

    void devolverLivro(int idlivro, int idusuario) {
        boolean existe = this.acervo.stream().anyMatch(livro -> livro.id == idlivro);
        boolean existe2 = this.usuarios.stream().anyMatch(usuario -> usuario.id == idusuario);

        if (existe && existe2) {
            int indice = cataLivro(idlivro);
            int indice2 = catausuario(idusuario);
            boolean emprestou = this.usuarios.stream().anyMatch(usuario -> usuario.getLivrosEmprestados().stream().anyMatch(livro -> livro.getid() == idlivro));

            if (indice >= 0 && indice2 >= 0) {
                if (this.acervo.get(indice).estado.retornalogico() && emprestou) {

                    this.acervo.get(indice).estado = estadoemprestimo.LIVRE;

                    int cata = this.cataLivro(idlivro);//pegar o indice na lista da biblioteca pelo id, caso um item seja removido numa posicao anterior
                    this.usuarios.get(indice2).LivrosEmprestados.remove(cata);

                    int cata2 = this.usuarios.get(indice2).cataLivroU(idlivro);//buscando o indice do livro dentro da lista no usuario
                    this.usuarios.get(indice2).LivrosEmprestados.remove(cata2);

                } else {
                    System.out.println("Livro não alugado ainda");
                }
            } else
                System.out.println("Livro e/ou usuario não encontrado");

        }
    }
        public void listarlivroslivres(){
            System.out.println("Livros disponiveis para aluguel:");

            for(int i = 0; i<this.acervo.size();i++){
                if(!this.acervo.get(i).estado.retornalogico()){
                    System.out.printf("%d: %s\n",i,this.acervo.get(i).nome);
                }
            }
        }
    public void listalivrosemprestados(){
        System.out.println("Livros indisponiveis/alugados:");

        for(int i = 0; i<this.acervo.size();i++){
            if(this.acervo.get(i).estado.retornalogico()){
                System.out.printf("%d: %s\n",i,this.acervo.get(i).nome);
            }
        }
    }
}

