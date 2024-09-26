import java.util.HashSet;
import java.util.Set;

public class DFS { 
    // Conjunto para guardar los nodos ya visitados
    // al usar set evitamos que haya duplicaciones
    private Set<Nodo> visitados;

    // Constructor que inicializa el conjunto de nodos visitados
    public DFS() {
        visitados = new HashSet<>(); // Usamos la clase HashSet para evitar duplicados
    }

    // Método que realiza la búsqueda en profundidad (DFS) desde el nodo inicial al objetivo
    public boolean buscar(Nodo inicial, Nodo objetivo) {
        // Si alguno de los nodos es nulo, no tiene sentido buscar
        if (inicial == null || objetivo == null) return false;

        // Marca el nodo inicial como visitado
        visitados.add(inicial);
        System.out.println("Visitando: " + inicial.getNombre());

        // Si el nodo actual es el que buscamos, terminamos
        if (inicial.getNombre().equals(objetivo.getNombre())) {
            System.out.println("Encontrado el objetivo: " + objetivo.getNombre());
            return true;
        }

        // Recorre los vecinos del nodo actual
        for (Nodo vecino : inicial.getVecinos()) {
            // Si el vecino no ha sido visitado, sigue buscando
            if (!visitados.contains(vecino)) {
                if (buscar(vecino, objetivo)) { // Llamada recursiva para seguir con el vecino
                    return true; // Si encuentra el objetivo en algún vecino, retorna true
                }
            }
        }

        // Si termina de revisar todos los vecinos y no lo encontró, retorna false
        return false;
    }
}
