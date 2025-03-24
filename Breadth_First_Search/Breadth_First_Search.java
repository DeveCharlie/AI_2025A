import java.util.*;

public class Breadth_First_Search {

    Scanner scanner = new Scanner(System.in);
    Node origen, destino;
    Grafo grafo;
    Queue<Node> openListBreath = new LinkedList<>(); // Cambiamos ArrayList a Queue para BFS
    ArrayList<Node> closeListBreath = new ArrayList<>();
    Map<Node, Node> apuntadores = new HashMap<>();

    Breadth_First_Search(Node origen, Node destino, Grafo grafo) {
        this.origen = origen;
        this.destino = destino;
        this.grafo = grafo;
        this.openListBreath.offer(origen); // Usamos offer() en lugar de add() para la cola
    }

    public boolean compararNodoFinal() {
        Node nodoActual = openListBreath.peek(); // Obtener el primer nodo de la cola sin sacarlo
        if (nodoActual != null && nodoActual.data.equals(destino.data)) {
            // System.out.println("Se alcanzó el estado final...");
            return true;
        } else {
            // System.out.println("No se alcanzó el estado final...");
            return false;
        }
    }

    public void imprimirListas() {
        System.out.println("\n\t---- Lista Abierta ----");
        for (Node nodo : openListBreath) {
            System.out.print(nodo.data + " ");
        }
        System.out.println("\n\t---- Lista Cerrada ----");
        for (Node nodo : closeListBreath) {
            System.out.print(nodo.data + " ");
        }
        System.out.println();
    }

    public List<Node> busquedaAnchura() {
        while (!openListBreath.isEmpty() && !compararNodoFinal()) {
            //3.1.1 y 3.1.2 investigar los descencietes inmediatos del nodo y agregarlos a la lista cerrada
            Node nodoActual = openListBreath.poll(); //sacar de nodo de la cola
            closeListBreath.add(nodoActual); //NO VOLVER A PROCESAR NODOS Y EVITAR CICLOS
            List<Node> descendientes = grafo.obtenerVecinos(nodoActual);

            // 3.1.3 Establecer apuntador al nodo padre
            // System.out.println("\t---- Apuntadores a nodos padres ----");
            for (Node hijo : descendientes) {
                if (!closeListBreath.contains(hijo) && !openListBreath.contains(hijo)) {
                    openListBreath.offer(hijo); // Se agregan al final de la cola
                    apuntadores.put(hijo, nodoActual); // Establecer apuntador a padre
                    // System.out.println("hijo: " + hijo.data + " padre: " + nodoActual.data);
                }
            }
            // Funcion para ir viendo las transiciones de las listas
            //imprimirListas();
        }

        return construirCamino();
    }

    public List<Node> construirCamino() {
        List<Node> camino = new ArrayList<>();
        Node actual = destino;

        // Retroceder en el mapa de apuntadores hasta llegar al origen
        while (actual != null) {
            camino.add(actual);
            actual = apuntadores.get(actual);
        }

        Collections.reverse(camino); // Invertir para comenzar de inicio a final
        return camino;
    }

    public void imprimirBusquedaAnchura(List<Node> camino) {
        System.out.println("Orden para llegar al Destino: ");
        for (Node n : camino) {
            System.out.print(n.data + " -> ");
        }
    }
}
