public class Nodo {
    private int valor;
    private int numvertice;
    public int getValor() {
        return valor;
    }
    public void setValor(int valor) {
        this.valor = valor;
    }
    public int getNumVertice() {
        return this.numvertice;
    }
    public void setNumVertice(int numero) {
        this.numvertice = numero;
    }
    public Nodo(int valor){
        this.valor=valor;
        this.numvertice=-1;
    }
}
