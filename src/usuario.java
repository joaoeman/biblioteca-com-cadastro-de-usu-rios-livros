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
    int cataLivroU(int id) {
        boolean existencia = false;
        int i = 0;

        for (; i < this.LivrosEmprestados.size(); i++) {
            if (this.LivrosEmprestados.get(i).id == id){
                existencia = true;
                break;
            }
        }
        return (existencia)? (i) : (-1);
    }
}
