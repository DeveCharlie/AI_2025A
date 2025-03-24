import java.util.*;

public class Grafo {
    private Map<Node, List<Node>> listaNodosAdyacentes;
    private Map<Node, Map<Node, Integer>> distancias; // Nuevo mapa para distancias

    public Grafo(){
        listaNodosAdyacentes = new HashMap<>();
        distancias = new HashMap<>();
    }

    public void agregarNodo(Node nodo){
        listaNodosAdyacentes.putIfAbsent(nodo, new ArrayList<>());
        distancias.putIfAbsent(nodo, new HashMap<>());
    }

    public void agregarArista(Node origen, Node destino, int distancia){
        listaNodosAdyacentes.get(origen).add(destino);
        distancias.get(origen).put(destino, distancia);

        // Si el grafo es bidireccional, agrega también la inversa
        listaNodosAdyacentes.get(destino).add(origen);
        distancias.get(destino).put(origen, distancia);
    }

    public List<Node> obtenerVecinos(Node nodo) {
        return listaNodosAdyacentes.getOrDefault(nodo, new ArrayList<>());
    }

    public int obtenerDistancia(Node origen, Node destino) {
        return distancias.getOrDefault(origen, new HashMap<>()).getOrDefault(destino, Integer.MAX_VALUE);
    }

    public void mostrarGrafo() {
        for (Node node : listaNodosAdyacentes.keySet()) {
            System.out.print(node.data + " -> ");
            for (Node vecino : listaNodosAdyacentes.get(node)) {
                int distancia = distancias.get(node).get(vecino);
                System.out.print(vecino.data + "(" + distancia + ") ");
            }
            System.out.println();
        }
    }
}
