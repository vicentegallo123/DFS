import java.util.HashSet;
import java.util.Set;
import java.util.List;


class DFS {
    // Conjunto de nodos visitados para evitar ciclos o revisitas durante la búsqueda.
    private Set<Nodo> visitados;

    // Constructor de la clase, inicializa el conjunto de nodos visitados.
    public DFS() {
        visitados = new HashSet<>();
    }

  
    // Recibe un nodo inicial, el nodo objetivo, y una lista para almacenar la ruta.
    public boolean buscar(Nodo inicial, Nodo objetivo, List<Nodo> ruta) {
        // Verifica si los nodos inicial y objetivo son válidos; si no, termina la búsqueda.
        if (inicial == null || objetivo == null) return false;

        // Agrega el nodo inicial a los visitados y lo añade a la ruta actual.
        visitados.add(inicial);
        ruta.add(inicial);

        // Si el nodo inicial coincide con el nodo objetivo, imprime la ruta encontrada.
        if (inicial.getNombre().equals(objetivo.getNombre())) {
            System.out.println("Ruta encontrada: " + imprimirRuta(ruta));
            return true; // Termina la búsqueda al encontrar el objetivo.
        }

        // Recorre cada vecino del nodo actual para aplicar la recursión de DFS.
        for (Nodo vecino : inicial.getVecinos()) {
            // Si el vecino aún no ha sido visitado, realiza la búsqueda en ese vecino.
            if (!visitados.contains(vecino)) {
                // Llama recursivamente al método `buscar` en el vecino.
                if (buscar(vecino, objetivo, ruta)) {
                    return true; // Si se encuentra el objetivo, termina la búsqueda.
                }
            }
        }

        // Si el nodo actual no lleva al objetivo, se elimina de la ruta actual (backtracking).
        ruta.remove(ruta.size() - 1);
        return false;
    }

    // Método para imprimir ruta
    private String imprimirRuta(List<Nodo> ruta) {
        StringBuilder sb = new StringBuilder();
        // Recorre cada nodo en la ruta y lo agrega a la cadena con formato "nodo --->".
        for (Nodo nodo : ruta) {
            sb.append(nodo.getNombre()).append(" ---> ");
        }
        // Indica el final de la ruta.
        sb.append("Fin");
        return sb.toString();
    }
}
