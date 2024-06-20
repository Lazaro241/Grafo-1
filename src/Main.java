import java.util.Scanner;
public class Main {
    public static void menu(){
        System.out.println("MENU DE OPCIONES");
        System.out.println("1. Añadir un vértice");
        System.out.println("2. Añadir una arista");
        System.out.println("3. Recorrer en anchura");
        System.out.println("4. Ver grafo(Matriz de adyacencia)");
        System.out.println("5. Salir");
    }
    public static void aniadirVertice( Grafo g, Scanner s){
        System.out.println("Ingrese el valor del nuevo vértice.");
        int valor = s.nextInt();
        g.addNodo(valor);      
    }
    public static void aniadirArista(Grafo g, Scanner s){
        int salida, entrada;
        g.imprimirArrayDeVertices();
        System.out.println("Ingrese el valor del vértice de salida o ida de la arista");
        salida= s.nextInt();
        System.out.println(("Ingrese el valor del vértice de entrada o llegada de la arista"));
        entrada = s.nextInt();
        g.addArista(salida, entrada);
    }
    public static void recorrerGrafoAnchura (Grafo g, Scanner s)throws Exception{
        System.out.println("Ingrese el valor del vertice de origen del recorrido");
        int valor= s.nextInt();
        g.recorridoAnchura(valor);
    }
    public static void main(String[] args) throws Exception {
        int menu=0, can;
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingresa la cantidad máxima de vertices que tendrá el grafo.");
        can= teclado.nextInt();
        Grafo g = new Grafo(can);
        do{
            menu();
            menu= teclado.nextInt();
            switch(menu){
                case 1:
                    aniadirVertice( g, teclado);
                    break;
                case 2:
                    aniadirArista(g, teclado);
                    break;
                case 3:
                    recorrerGrafoAnchura(g, teclado);
                break;
                case 4:
                    g.imprimirArrayDeVertices();
                    g.imprimirMatrizAd();
                    break;
                case 5:
                    
                break;
                default:
                break;
            }
        }while(menu!=5);
    }
}
