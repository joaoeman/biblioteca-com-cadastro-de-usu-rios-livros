public class livro {
    String nome;
    String autor;
    estadoemprestimo estado;
    int id;

    public livro(String nome, String autor, estadoemprestimo emprestimo, int id){
        this.id = id;
        this.nome = nome;
        this.autor = autor;
        this.estado = estadoemprestimo.LIVRE;
    }
    public int getid(){
        return id;
    }

}

