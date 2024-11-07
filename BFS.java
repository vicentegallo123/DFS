import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

// Declaración de la clase BFS (Breadth-First Search) para realizar una búsqueda en anchura en un grafo.
class BFS {
    // Conjunto de nodos visitados para evitar ciclos o visitas repetidas.
    private Set<Nodo> visitados;

    // Constructor de la clase BFS, inicializa el conjunto de nodos visitados.
    public BFS() {
        visitados = new HashSet<>();
    }

    // Método principal que realiza la búsqueda en anchura.
    // Recibe el nodo inicial, el nodo objetivo, y una lista para almacenar la ruta.
    public boolean buscar(Nodo inicial, Nodo objetivo, List<Nodo> ruta) {
        // Verificación de nodos inicial y objetivo. Si alguno es null, se devuelve false.
        if (inicial == null || objetivo == null) return false;

        // Cola utilizada para almacenar rutas parciales durante la búsqueda en anchura.
        Queue<List<Nodo>> cola = new LinkedList<>();

        // Inicializamos la primera ruta con el nodo inicial y la añadimos a la cola.
        List<Nodo> rutaInicial = new LinkedList<>();
        rutaInicial.add(inicial);
        cola.add(rutaInicial);

        // Ciclo principal que se ejecuta mientras haya rutas en la cola.
        while (!cola.isEmpty()) {
            // Extraemos la ruta actual de la cola.
            List<Nodo> actualRuta = cola.poll();
            // Obtenemos el último nodo de la ruta actual.
            Nodo actual = actualRuta.get(actualRuta.size() - 1);

            // Verificamos si el nodo actual ya ha sido visitado.
            if (!visitados.contains(actual)) {
                // Marcamos el nodo actual como visitado.
                visitados.add(actual);

                // Comprobamos si el nodo actual es el objetivo.
                if (actual.getNombre().equals(objetivo.getNombre())) {
                    // Si es el objetivo, agregamos la ruta completa a la lista de ruta final.
                    ruta.addAll(actualRuta);
                    // Imprimimos la ruta final encontrada.
                    System.out.println("Ruta encontrada: " + imprimirRuta(actualRuta));
                    return true; // Terminamos la búsqueda ya que encontramos el objetivo.
                }

                // Si no es el objetivo, exploramos cada nodo vecino no visitado.
                for (Nodo vecino : actual.getVecinos()) {
                    if (!visitados.contains(vecino)) {
                        // Creamos una nueva ruta basada en la ruta actual y agregamos el vecino.
                        List<Nodo> nuevaRuta = new LinkedList<>(actualRuta);
                        nuevaRuta.add(vecino);
                        // Añadimos la nueva ruta a la cola para procesarla después.
                        cola.add(nuevaRuta);
                    }
                }
            }
        }
        // Si no se encuentra el objetivo, devolvemos false.
        return false;
    }

    // Método auxiliar para convertir la ruta en un formato de cadena legible.
    private String imprimirRuta(List<Nodo> ruta) {
        StringBuilder sb = new StringBuilder();
        // Agrega cada nodo a la cadena en el formato "nodo --->".
        for (Nodo nodo : ruta) {
            sb.append(nodo.getNombre()).append(" ---> ");
        }
        // Indica el final de la ruta.
        sb.append("Fin");
        return sb.toString();
    }
}
