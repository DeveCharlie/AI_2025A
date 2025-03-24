import java.util.*;

public class HillClimbingSearch {
    private Grafo grafo;
    private Node inicio, destino, actual;
    private int distanciaTotal;

    public HillClimbingSearch(Grafo grafo, Node inicio, Node destino) {
        this.grafo = grafo;
        this.inicio = inicio;
        this.destino = destino;
        this.actual = inicio;
        this.distanciaTotal = 0;
    }

    public Stack<Node> busquedaEscaladaColina() {

        Stack<Node> camino = new Stack<>();
        Set<Node> visitados = new HashSet<>();

        System.out.println("Busqueda iniciada en: " + actual.data);
        visitados.add(actual);
        while (!actual.equals(destino)){
            List<Node> vecinos = grafo.obtenerVecinos(actual);
            vecinos.removeAll(visitados); // Eliminamos nodos ya visitados

            if (vecinos.isEmpty()) {
                // Si no hay vecinos disponibles, retrocedemos
                if (camino.isEmpty()) {
                    System.out.println("No hay más caminos. No se encontró una solución.");
                    break;
                }
                Node ultimo = actual;
                actual = camino.pop();
                distanciaTotal -= grafo.obtenerDistancia(actual, ultimo);
                System.out.println("Retrocediendo a: " + actual.data);
                continue;
            }

            // Ordenar nodos de menor a mayor distancia
            Collections.sort(vecinos, new Comparator<Node>() {
                @Override
                public int compare(Node v1, Node v2) {
                    return Integer.compare(grafo.obtenerDistancia(actual, v1), grafo.obtenerDistancia(actual, v2));
                }
            });


            boolean movido = false;
            for (Node vecino : vecinos) {
                if (!visitados.contains(vecino)) {
                    visitados.add(vecino);
                    camino.push(actual);
                    int distancia = grafo.obtenerDistancia(actual, vecino);
                    System.out.println("Moviéndose de " + actual.data + " a " + vecino.data + " (distancia " + distancia + ")");
                    distanciaTotal += distancia;
                    actual = vecino;
                    movido = true;
                    break;
                }
            }

            if (!movido) {
                // Retroceder si no hay vecinos
                if (camino.isEmpty()) {
                    System.out.println("No hay más caminos. No se encontró una solución.");
                    break;
                }
                actual = camino.pop();
                System.out.println("Retrocediendo a: " + actual.data);
            }
        }
        camino.add(actual);
        System.out.println("¡Se alcanzó el destino!");
        return camino;
    }

    void imprimirBusqeudaEscaladaColina(Stack<Node> hillClimbing){
        for(Node n: hillClimbing){
            System.out.print(n.data + " -> ");
        }
        System.out.println("\nDistancia total recorrida: " + distanciaTotal);

    }
}



