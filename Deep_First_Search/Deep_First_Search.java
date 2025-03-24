import java.util.*;

public class Deep_First_Search {

    Scanner scanner = new Scanner(System.in);
    Node origen, destino;
    Grafo grafo;
    ArrayList<Node> openList = new ArrayList<>();
    ArrayList<Node> closeList = new ArrayList<>();
    Map<Node, Node> apuntadores = new HashMap<>();
    int tamopenList = 1;
    int tamcloseList = 0;

    Deep_First_Search(Node origen, Node destino, Grafo grafo){
        this.origen = origen;
        this.destino = destino;
        this.grafo = grafo;
        this.openList.add(origen);
    }


    public boolean compararNodoFinal(){
        String nodoOpenList = openList.get(tamopenList -1).data;
        String nodoDestino = destino.data;
        System.out.println("Abierta: " + nodoOpenList + " Destino: " + nodoDestino);
        if (nodoOpenList == nodoDestino){
            System.out.println("Se alcanzo el estado final...");
            return true;
        }
        else{
            System.out.println("No se alcanzo el estado final...");
            return false;
        }

    }

    public void imprimirListas(){
        System.out.println("\n\t---- Lista Abierta ----");
        for (Node nodo : openList){
            System.out.println(nodo.data);
        }
        System.out.println("\n\t---- Lista Cerrada ----");
        for (Node nodo : closeList){
            System.out.println(nodo.data);
        }
    }

    public List<Node> busquedaProfundidad(){

        int ultimoTamListaCerrada = 0;
        while(!compararNodoFinal()){
            //3.1.1 y 3.1.2 investigar los descencietes inmediatos del nodo y agregarlos a la lista cerrada
            tamopenList = openList.size();
            List<Node> descendientes = grafo.obtenerVecinos(openList.get(tamopenList -1));
            for (Node d : descendientes){
                System.out.println(d.data);
            }
            //REVISAR: EL NODO PADRE NO DEBERIA DE ESTAR EN LA LISTA DE DESCENDIENTES, ELIMINARLO!
            Node anterior = apuntadores.get(openList.get(tamopenList -1)); // Obtener el nodo padre
            descendientes.removeIf(nodo -> nodo.equals(anterior));
            
            Collections.reverse(descendientes); // invierte el orden de la coleccion para ir que izq -> der
            closeList.addAll(descendientes);
            tamcloseList = closeList.size();

            imprimirListas();

            //3.1.3 Establecer apuntador al nodo padre
            //System.out.println("\t---- Apuntadores a nodos padres ----");

            if(!descendientes.isEmpty()){
                for(int i = ultimoTamListaCerrada; i < tamcloseList; i++){
                    Node padre =  openList.get(tamopenList -1);
                    Node hijo = closeList.get(i);
                    //System.out.println("hijo: " + hijo.data + " padre: " + padre.data);
                    apuntadores.put(hijo, padre);
                }
                ultimoTamListaCerrada = apuntadores.size() -1;
            }
            else{// si el ultimo nodo de lista abierta no tiene descendientes y no es el estado final se elimina
                openList.remove(tamopenList -1);
                tamopenList = openList.size();
            }

            //3.1.4 sacar ultimo nodo de la lista cerrada y agregarlos a lista abierta
            Node sacarNodoListaCerrada = closeList.get(tamcloseList -1);
            closeList.remove(tamcloseList -1);
            openList.add(sacarNodoListaCerrada);
            tamopenList = openList.size();

            //imprimirListas();
        }
        return openList;
    }

    public void imprimirBusquedaProfundidad(List<Node> openList){
        System.out.println("Orden para llegar al Destino: ");
        for (Node n: openList){
            System.out.print(n.data + " -> ");
        }
    }

}
