import java.util.LinkedList;
import java.util.Queue;
public class Grafo {
    private int numNodos;
    private int maxNodos;
    private int[][] matrizAdy;
    private Nodo[] nodos;

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
        this.nodos= new Nodo[this.maxNodos];
        for(int i=0; i<numero;i++){
            this.nodos[i]=null;
            for(int j=0; j<numero; j++){
                matrizAdy[i][j]=0;
            }
        }
    }
    public void imprimirArrayDeVertices(){
        for(int i=0;i<this.nodos.length;i++){
            if(this.nodos[i]!=null){
                System.out.print("V"+this.nodos[i].getValor() + ", " );
            }
        }
    }
    public void imprimirMatrizAd(){
        for(int i=0;i<this.matrizAdy.length;i++){
            System.out.println("");
            for(int j=0;j<this.matrizAdy.length;j++){
                if(this.nodos[i]!=null && this.nodos[j]!=null){
                    System.out.print(this.matrizAdy[i][j]+ "  ");
                }
                else{
                    System.out.print("*  ");
                }
                
            }
        }
        System.out.println("");
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
    public void addNodo(int valor){
        if((encontrarNodo(valor)!=-1) || this.numNodos==this.maxNodos ){
            System.out.println("El grafo ya tiene todos los vértices posibles o el valor ingresado es repetido.");
        }
        else{
            Nodo nuevo = new Nodo(valor);
            this.nodos[this.numNodos]=nuevo;
            this.numNodos++;
        }    
    }
    public void addArista(int valorSalida, int valorEntrada){
        int salida = encontrarNodo(valorSalida);
        int entrada = encontrarNodo(valorEntrada);
        if((entrada!=-1)&&(salida!=-1)&&(entrada!=salida)){
            this.matrizAdy[salida][entrada]=1;
        } else {
            System.out.println("Uno o ambos vertices ingresados no existen o se intentó ingresar un lazo.");
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
            System.out.println("Nodo n° "+this.nodos[w].getValor() +"");
            for (int i=0;i<this.numNodos;i++){
                if(this.matrizAdy[w][i]==1 && visitados[i]==false){
                    cola.add(i);
                    visitados[i]=true;
                }
            }
        }
    }
    
}
