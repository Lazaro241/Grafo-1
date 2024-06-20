import java.util.LinkedList;
import java.util.Queue;
public class Grafo {
    private int numNodos;
    private int maxNodos;
    private int[][] matrizAdy;
    Nodo[] nodos;

    public Nodo[] getNodos() {
        return nodos;
    }

    public void setNodos(Nodo[] nodos) {
        this.nodos = nodos;
    }

    public Grafo(int numero) {
        this.maxNodos=numero;
        this.numNodos=0;
        this.matrizAdy=new int[numero][numero];
        this.nodos= new Nodo[maxNodos];
        for(int i=0; i<numero;i++){
            nodos[i]=null;
            for(int j=0; j<numero; j++){
                matrizAdy[i][j]=0;
            }
        }
    }
    public int encontrarNodo(int valor){
        int resultado = -1;
        for(int i=0;i<this.maxNodos;i++){
            if(this.nodos[i]!=null){
                if(this.nodos[i].getValor()==valor){
                    resultado = i;
                    return resultado;
                }
            }
        }
        return resultado;
    }
    public void addNodo(int valor)throws Exception{
        if((encontrarNodo(valor)!=-1)){
            throw new Exception("No se puede añadir el nodo. Valor ya ocupado.");
        }
        if(this.numNodos<this.maxNodos){
            throw new Exception("No se puede añadir el nodo. Numero maximo de nodos alcanzado.");
        }
        Nodo nuevo = new Nodo(valor);
        this.nodos[numNodos]=nuevo;
    }
    public void addArista(int valor1, int valor2) throws Exception{
        int primero = encontrarNodo(valor1);
        int segundo = encontrarNodo(valor2);
        if((primero!=-1)&&(segundo!=-1)){
            this.matrizAdy[primero][segundo]=1;
            this.matrizAdy[segundo][primero]=1;
        } else {
            throw new Exception("Uno o ambos nodos no existen.");
        }
    }
    public void recorridoAnchura(int valorOrigen) throws Exception{
        int v, w;
        v=encontrarNodo(valorOrigen);
        if(v==-1) throw new Exception("Nodo de origen no existente");
        boolean[] visitados = new boolean[this.numNodos];
        visitados[v]=true;
        Queue<Integer> cola = new LinkedList<>();
        cola.add(v);
        while(!cola.isEmpty()){
            w=cola.poll();
            System.out.println("Nodo n° "+nodos+"");
        }
    }
    
}
