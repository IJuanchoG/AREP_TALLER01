package edu.eci.arep.msc.mystatcal.LinkedList;

import edu.eci.arep.msc.mystatcal.LinkedList.Nodes.Node;
import edu.eci.arep.msc.mystatcal.Persistence.Exceptions.MyOwnLinkedListException;
import edu.eci.arep.msc.mystatcal.Persistence.Exceptions.NodesException;

/**
 * @author Juan Carlos Garcia Garzon
 * Construccion del sistema de comunicacion de la LinkedList
 */
public class MyOwnLinkedList {
    private String dataType;
    private Node head;
    private Node tail;
    private int size = 0;

    public MyOwnLinkedList(String dataType){ this.dataType = dataType;}

    public MyOwnLinkedList(String data, String dataType) throws NodesException {
        start(data,dataType);
    }

    /**
     * Agrega un nuevo nodo a la LinkedList, lo conecta con los nodos subyacentes
     * @param data informacion a almancenar en el nodo
     * @param dataType tipo de informacion a almacenar
     * @return respuesta a exito en la adicion
     * @throws NodesException ausencia de implementaciones existentes
     * @throws MyOwnLinkedListException tipo de data no soportada o no implementada
     */
    public boolean addNode(String data, String dataType) throws NodesException, MyOwnLinkedListException {
        if((head == null && this.dataType != dataType) ) { throw new MyOwnLinkedListException(MyOwnLinkedListException.INVALID_DATATYPE);  }
        if(head == null && tail == null && this.dataType == dataType) {
            start(data,dataType);
            return true;
        }
        if(dataType != tail.getNodeType()) {throw new MyOwnLinkedListException(MyOwnLinkedListException.INVALID_DATATYPE);}
        Node aux = Node.BuildNode(data, dataType, tail);
        if (tail.setRightNode(aux)) {
            tail =  aux;
            size++;
            return true;
        }
        return false;
    }

    /**
     * Elimina el ultimo nodo puesto, es posible realizar implementaciones para eliminar de diferentes maneras
     * @return Nodo removido
     * @throws NodesException LinkedList vacia
     */
    public Node removeLastNode() throws NodesException {
        if (head == null && tail == null){ throw new NodesException(NodesException.LINKEDLIST_EMPTY);
        };
        if(head.equals(tail)) {
            Node aux = head;
            head = tail = null;
            size--;
            return aux;
        }
        Node aux = tail;
        //Node newTail = tail.getLeftNode();
        //newTail.setRightNode(tail.getRightNode()); Funcionaría en caso de que se borre un Nodo intermedio
        tail =  tail.getLeftNode();
        tail.setRightNode(null);
        size--;
        return aux;
    }

    /**
     * Muestra el nodo siguiente al posicionado
     * @param node Nodo desde el cual se quiere buscar la siguiente posicion
     * @return Nodo en siguiente posicion
     */
    public Node nextNode(Node node){
        return node.getRightNode() ;
    }

    /**
     * Muestra el nodo previo al que se ha posicionado
     * @param node Nodo desde el cual se quiere buscar la posicion previa
     * @return Nodo en posicion previa
     */
    public Node previousNode(Node node){
        return node.getLeftNode() ;
    }

    /**
     * Muestra el nodo HEAD de la linkedList
     * @return HEAD De la linkedlist
     */
    public Node priorNode(){
        return head;
    }

    /**
     * Muestra el nodo TAIL de la linkedList
     * @return TAIL de la linkedlist
     */
    public Node lastNode(){
        return tail;
    }

    /**
     * Muestra el tipo de informacion almacenada en la LinkedList
     * @return tipo de informacion
     */
    public String getDataType() {
        return dataType;
    }

    /**
     * Asigna un nuevo tipo de informacion a almacenar
     * @param dataType tipo de informacion a almacenar
     */
    public void setDataType(String dataType) {
        this.dataType = dataType;
    }


    /**
     * Presenta el tamanho presentado en la linkedList
     * @return tamanho de la linkedlist
     */
    public int getSize() {
        return size;
    }

    /**
     * Realiza la inializacion del primer nodo de la lista
     * @param data informacion que se quiere guardar
     * @param dataType tipo de informacion que se quiere guardar
     * @throws NodesException Excepciones a metodos no implementados aun
     */
    private void start(String data, String dataType) throws NodesException {
        Node aux = Node.BuildNode(data,dataType, null);
        this.dataType = dataType;
        this.head = aux;
        this.tail = aux;
        this.size = 1;
    }


    /**
     * Representa la linkedList de una manera amigable y sencilla
     * @return LinkedList en formato entendible
     */
    @Override
    public String toString() {
        Node aux  = head;
        String list = "Linked List:\n";
        while (aux != null){
            if(aux.equals(head)) list+="null <-> HEAD("+aux.toString()+") <-> ";
            else if(aux.equals(tail)) list+="TAIL("+aux.toString()+") <-> ";
            else list+="("+aux.toString()+") <-> ";
            aux = aux.getRightNode();
        }
        return list+"null\n -------------------\n";
    }
}
