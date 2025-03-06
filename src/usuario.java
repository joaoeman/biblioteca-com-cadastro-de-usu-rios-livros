import java.util.ArrayList;

public class usuario {
    String nome;
    int id;
    ArrayList<livro> LivrosEmprestados = new ArrayList<>();

    public usuario(String nome, int id){
        this.id = id;
        this.nome = nome;
    }
    public ArrayList<livro> getLivrosEmprestados(){
        return LivrosEmprestados;
    }
    public void addlivrosemprestados(livro livro){
        LivrosEmprestados.add(livro);
    }
}
