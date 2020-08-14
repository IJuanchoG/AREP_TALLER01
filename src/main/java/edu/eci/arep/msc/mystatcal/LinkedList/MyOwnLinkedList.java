package edu.eci.arep.msc.mystatcal.LinkedList;

import edu.eci.arep.msc.mystatcal.LinkedList.Nodes.Node;
import edu.eci.arep.msc.mystatcal.Persistence.Exceptions.MyOwnLinkedListException;
import edu.eci.arep.msc.mystatcal.Persistence.Exceptions.NodesException;

public class MyOwnLinkedList {
    private String dataType;
    private Node head;
    private Node tail;
    private int size = 0;

    public MyOwnLinkedList(String dataType){ this.dataType = dataType;}

    public MyOwnLinkedList(String data, String dataType) throws NodesException {
        start(data,dataType);
    }

    public boolean addNode(String data, String dataType) throws NodesException, MyOwnLinkedListException {
        if(head == null && tail == null) {
            start(data,dataType);
            return true;
        }
        if(dataType != tail.getNodeType() || tail.getRightNode() != null) {throw new MyOwnLinkedListException(MyOwnLinkedListException.INVALID_DATATYPE);}
        Node aux = Node.BuildNode(data, dataType, tail);
        if (tail.setRightNode(aux)) {
            tail =  aux;
            size++;
            return true;
        }
        return false;
    }

    public Node removeLastNode() throws NodesException {
        if (head == null && tail == null){
            System.out.println("No hay Nodos");
            return null;
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

    public Node nextNode(Node node){
        return node.getRightNode() ;
    }

    public Node previousNode(Node node){
        return node.getLeftNode() ;
    }

    public Node priorNode(){
        return head;
    }

    public Node lastNode(){
        return tail;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public int getSize() {
        return size;
    }

    private void start(String data, String dataType) throws NodesException {
        Node aux = Node.BuildNode(data,dataType, null);
        this.dataType = dataType;
        this.head = aux;
        this.tail = aux;
        this.size = 1;
    }



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
