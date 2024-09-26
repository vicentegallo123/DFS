

public class Main {
    public static void main(String[] args) {
        Grafo grafo = new Grafo();

        // Definimos algunos estados de ejemplo
        Nodo california = new Nodo("California");
        Nodo nevada = new Nodo("Nevada");
        Nodo arizona = new Nodo("Arizona");
        Nodo oregon = new Nodo("Oregon");

        // Añadimos vecinos 
        california.agregarVecino(nevada);
        california.agregarVecino(arizona);
        nevada.agregarVecino(oregon);

        // Añadimos nodos al grafo
        grafo.agregarNodo(california);
        grafo.agregarNodo(nevada);
        grafo.agregarNodo(arizona);
        grafo.agregarNodo(oregon);

        // Ejecutar DFS
        DFS dfs = new DFS();
        Nodo inicio = grafo.buscarNodo("California");
        Nodo fin = grafo.buscarNodo("Oregon");
       // Buscando un nodo que no está conectado

        if (!dfs.buscar(inicio, fin)) {
            System.out.println("No se encontro destino");
        }
    }
}
