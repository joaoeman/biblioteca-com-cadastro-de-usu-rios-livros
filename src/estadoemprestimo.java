public enum estadoemprestimo {
    EMPRESTADO("Emprestado"){
        @Override
        public boolean retornalogico() {
            return true;
        }
    },LIVRE("livre"){
        @Override
        public boolean retornalogico() {
            return false;
        }
    };
    private String estado;

    estadoemprestimo(String estado){
        this.estado = estado;
    }
    abstract public boolean retornalogico();
}
