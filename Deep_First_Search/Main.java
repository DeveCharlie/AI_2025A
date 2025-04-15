import java.security.KeyStore;
import java.util.List;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {

        Grafo grafo = new Grafo();

        /*
        Creacion de los nodos del problema del airopuerto
         */

        Node new_york = new Node("New_York");
        Node toronto = new Node("Toronto");
        Node calgari = new Node("Calgari");
        Node chicago = new Node("Chicago");
        Node denver = new Node("Denver");
        Node houston = new Node("Houston");
        Node urd = new Node("Urd");
        Node los_angeles = new Node("Los_Angeles");

        /*
        Agregacion de los nodos al grafo
         */

        grafo.agregarNodo(new_york);
        grafo.agregarNodo(toronto);
        grafo.agregarNodo(chicago);
        grafo.agregarNodo(denver);
        grafo.agregarNodo(calgari);
        grafo.agregarNodo(los_angeles);
        grafo.agregarNodo(houston);
        grafo.agregarNodo(urd);


        /*
        Agregacion de los vertices para hacer el grafo
        */

        //Nota para despues: Agregar la distancias a los nodos para la busqueda heuristica
        grafo.agregarArista(new_york, chicago, 3);
        grafo.agregarArista(new_york, toronto, 5);
        grafo.agregarArista(new_york, denver, 5);
        grafo.agregarArista(toronto, calgari, 3);
        grafo.agregarArista(toronto, los_angeles, 8);
        grafo.agregarArista(chicago, denver, 3);
        grafo.agregarArista(denver, houston, 4);
        grafo.agregarArista(denver, los_angeles, 10);
        grafo.agregarArista(houston, los_angeles, 10);
        grafo.agregarArista(houston, urd, 4);

        System.out.println("Mostrando Grafo y sus conexiones");
        grafo.mostrarGrafo();

        /*
        Busqueda con algoritmo general de busqueda
        */
        System.out.println("\n\n\n\t---- Busqueda en Profundidad ----");
        Deep_First_Search profundidad = new Deep_First_Search(new_york, los_angeles, grafo);
        List<Node> deep_result = profundidad.busquedaProfundidad();
        System.out.println("\n\n\t---- Resultados -----");
        profundidad.imprimirBusquedaProfundidad(deep_result);

    }
}