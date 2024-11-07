import java.util.ArrayList;
import java.util.List;

public class Grafo {
    // Lista de nodos que forman parte del grafo
    private List<Nodo> nodos;

    // Constructor que inicializa un grafo vacío (lista de nodos vacía)
    public Grafo() {
        nodos = new ArrayList<>(); // Crea una lista vacía para los nodos
    }

    // Método para agregar un nodo al grafo
    public void agregarNodo(Nodo nodo) {
        nodos.add(nodo); // Añade el nodo a la lista de nodos
    }

    // Método para buscar un nodo en el grafo por su nombre
    public Nodo buscarNodo(String nombre) {
        // Recorre todos los nodos del grafo
        for (Nodo nodo : nodos) {
            // Si encuentra un nodo con el nombre dado, lo devuelve
            if (nodo.getNombre().equals(nombre)) {
                return nodo; // Devuelve el nodo encontrado
            }
        }
        // Si no encuentra ningún nodo con ese nombre, devuelve null
        return null;
    }
}
