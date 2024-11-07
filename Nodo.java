import java.util.ArrayList;
import java.util.List;


public class Nodo {

    // Atributos de la clase
    private String nombre; // Nombre del nodo
    private List<Nodo> vecinos; // Lista de nodos vecinos conectados a este nodo
  
    
    //Constructor de la clase Nodo.
    
    public Nodo(String nombre ) {
        this.nombre = nombre;  // Asigna el nombre pasado como parámetro al atributo "nombre"
        this.vecinos = new ArrayList<>();  // Inicializa la lista de vecinos vacía
      
    }

    /**
     * Método que retorna el nombre del nodo.
     
     */
    public String getNombre() {
        return nombre;  // Retorna el nombre del nodo
    }

    /**
     * Método que retorna la lista de vecinos del nodo.
     
     */
    public List<Nodo> getVecinos() {
        return vecinos;  // Retorna la lista de nodos vecinos
    }

    /**
     * Método que agrega un nodo vecino a la lista de vecinos.
    
     */
    public void agregarVecino(Nodo vecino) {
        vecinos.add(vecino);  // Añade un nodo vecino a la lista de vecinos
    }
}
