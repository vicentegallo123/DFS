import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Grafo grafo = new Grafo();

        // Creación de los nodos
        Nodo california = new Nodo("california");
        Nodo nevada = new Nodo("nevada");
        Nodo oregon = new Nodo("oregon");
        Nodo washington = new Nodo("washington");
        Nodo idaho = new Nodo("idaho");
        Nodo utah = new Nodo("utah");
        Nodo arizona = new Nodo("arizona");
        Nodo colorado = new Nodo("colorado");
        Nodo virginia = new Nodo("virginia");

        // Conexiones entre nodos
        california.agregarVecino(nevada);
        nevada.agregarVecino(california);
        nevada.agregarVecino(oregon);
        oregon.agregarVecino(nevada);
        nevada.agregarVecino(idaho);
        nevada.agregarVecino(utah);
        utah.agregarVecino(virginia);
        nevada.agregarVecino(arizona);
        nevada.agregarVecino(colorado);
        virginia.agregarVecino(california);
        california.agregarVecino(california);
        idaho.agregarVecino(virginia);
        oregon.agregarVecino(virginia);
        arizona.agregarVecino(colorado);
        colorado.agregarVecino(oregon);

        // Agregar nodos al grafo
        grafo.agregarNodo(california);
        grafo.agregarNodo(nevada);
        grafo.agregarNodo(oregon);
        grafo.agregarNodo(washington);
        grafo.agregarNodo(idaho);
        grafo.agregarNodo(utah);
        grafo.agregarNodo(arizona);
        grafo.agregarNodo(colorado);
        grafo.agregarNodo(virginia);

        // Nodo de inicio y fin para la búsqueda
        Nodo inicio = grafo.buscarNodo("california");
        Nodo fin = grafo.buscarNodo("virginia");

        // Realizar DFS
        DFS dfs = new DFS();
        List<Nodo> rutaDFS = new ArrayList<>();
        System.out.println("Recorriendo DFS:");
        if (!dfs.buscar(inicio, fin, rutaDFS)) {
            System.out.println("No se encontro el destino con DFS.");
        }

        // Realizar BFS
        BFS bfs = new BFS();
        List<Nodo> rutaBFS = new ArrayList<>();
        System.out.println("\nRecorriendo BFS:");
        if (!bfs.buscar(inicio, fin, rutaBFS)) {
            System.out.println("No se encontro el destino con BFS.");
        }

        // Realizar Hill Climbing
        HillClimbing hillClimbing = new HillClimbing();
        List<Nodo> rutaHillClimbing = new ArrayList<>();
        System.out.println("\nRecorriendo Hill Climbing:");
        if (!hillClimbing.buscar(inicio, fin, rutaHillClimbing)) {
            System.out.println("No se encontro el destino con Hill Climbing.");
        }
    }
}