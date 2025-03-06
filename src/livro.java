public class livro {
    String nome;
    String autor;
    boolean emprestimo;
    int id;

    public livro(String nome, String autor, boolean emprestimo, int id){
        this.id= id;
        this.nome = nome;
        this.autor = autor;
        this.emprestimo = emprestimo;
        this.id = id;
    }
    public int getid(){
        return id;
    }

}

