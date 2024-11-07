import java.util.HashSet;
import java.util.List;
import java.util.Set;


class HillClimbing {
    // Conjunto de nodos visitados para evitar retrocesos o ciclos en el grafo.
    private Set<Nodo> visitados;

    // Constructor de la clase, inicializa el conjunto de nodos visitados.
    public HillClimbing() {
        visitados = new HashSet<>();
    }

    // Método principal de búsqueda que aplica el algoritmo de Hill Climbing.
    // Recibe un nodo inicial, el nodo objetivo, y una lista para almacenar la ruta.
    public boolean buscar(Nodo inicial, Nodo objetivo, List<Nodo> ruta) {
        // Verifica si los nodos inicial y objetivo no son nulos; en caso contrario, termina la búsqueda.
        if (inicial == null || objetivo == null) return false;

        // Inicializa el nodo actual como el nodo de inicio y lo agrega a la ruta y a los visitados.
        Nodo actual = inicial;
        ruta.add(actual);
        visitados.add(actual);

        // Ciclo principal de búsqueda hasta encontrar el nodo objetivo.
        while (!actual.getNombre().equals(objetivo.getNombre())) {
            // Variables para almacenar el mejor vecino y su costo (heurística).
            Nodo mejorVecino = null;
            int mejorCosto = Integer.MAX_VALUE;

            // Recorre cada vecino del nodo actual.
            for (Nodo vecino : actual.getVecinos()) {
                // Verifica que el vecino no haya sido visitado antes.
                if (!visitados.contains(vecino)) {
                    // Calcula el "costo" heurístico del vecino en relación con el objetivo.
                    int costo = heuristica(vecino, objetivo);

                    // Actualiza el mejor vecino si este tiene un costo menor que el mejor costo actual.
                    if (costo < mejorCosto) {
                        mejorCosto = costo;
                        mejorVecino = vecino;
                    }
                }
            }

            // Si no se encuentra un vecino mejor (sin opciones para avanzar), termina la búsqueda.
            if (mejorVecino == null) {
                System.out.println("No se encontró mejor ruta, búsqueda terminada.");
                return false;
            }

            // Actualiza la ruta y el nodo actual con el mejor vecino encontrado.
            ruta.add(mejorVecino);
            visitados.add(mejorVecino);
            actual = mejorVecino;
        }

        // Imprime la ruta completa cuando se alcanza el nodo objetivo.
        System.out.println("Ruta encontrada: " + imprimirRuta(ruta));
        return true;
    }

    // Método heurístico que calcula una "distancia" entre el nodo actual y el nodo objetivo.
    private int heuristica(Nodo nodo, Nodo objetivo) {
        // Ejemplo de heurística: diferencia en la longitud de los nombres de los nodos.
        return Math.abs(nodo.getNombre().length() - objetivo.getNombre().length());
    }

    // Método auxiliar que convierte la ruta encontrada en un formato legible.
    private String imprimirRuta(List<Nodo> ruta) {
        StringBuilder sb = new StringBuilder();
        // Construye una cadena con cada nodo en la ruta.
        for (Nodo nodo : ruta) {
            sb.append(nodo.getNombre()).append(" ---> ");
        }
        // Indica el final de la ruta.
        sb.append("Fin");
        return sb.toString();
    }
}
