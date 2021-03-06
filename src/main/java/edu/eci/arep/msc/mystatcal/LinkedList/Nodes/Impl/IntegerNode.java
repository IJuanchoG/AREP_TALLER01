package edu.eci.arep.msc.mystatcal.LinkedList.Nodes.Impl;

import edu.eci.arep.msc.mystatcal.LinkedList.Nodes.Node;
import edu.eci.arep.msc.mystatcal.Persistence.Exceptions.NodesException;

/**
 * @author Juan Carlos García
 * Esta es la implementacion del nodo para la linkedlist enfocado especificamente para integer
 */
public class IntegerNode implements Node {

    private static final String NODE_TYPE = "integer";
    private int data;
    private IntegerNode rightNode;
    private IntegerNode leftNode;

    public IntegerNode(int data, IntegerNode rightNode ){
        this.data =  data;
        this.rightNode = rightNode;

    }


    public IntegerNode(int data, IntegerNode rightNode, IntegerNode leftNode ){
        this.data =  data;
        this.rightNode = rightNode;
        this.leftNode = leftNode;
    }

    /**
     * Asigna la configuracion correspondiente al nodo para reconocer quien le sigue
     * @param rightNode Nodo derecho con quien se hace relacion
     * @return estado de asignacion valido o invalido
     * @throws NodesException Excepcion por desarrollo incompleto a la implementacion
     */
    public boolean setRightNode(IntegerNode rightNode) throws NodesException {
        if (this.rightNode!=null) throw new NodesException(NodesException.NOT_EXTEND_YET);
        this.rightNode =  rightNode;
        return true;
    }

    /**
     * Sobrescritura del metodo perteneciente a la interfaz de nodos
     * @param rightNode Nodo derecho con quien se hace relacion
     * @return estado de asignacion valido o invalido
     * @throws NodesException Excepcion por desarrollo incompleto a la implementacion
     */
    @Override
    public boolean setRightNode(Node rightNode) throws NodesException {
        try{
            if(rightNode == null) {
                this.rightNode = null;
                return true;
            }
            return setRightNode((IntegerNode) rightNode);
        }catch(ClassCastException e){
            throw new NodesException(NodesException.NODE_UNEXPECTED);
        }

    }

    /**
     * Retorna el valor correspondiente al nodo de la derecha
     * @return nodo derecho
     */
    public IntegerNode getRightNode(){
        return rightNode;
    }

    /**
     * Asigna el nodo a la izquierda (Para futuras implementaciones del método a partir de asignaciones en ambas direcciones)
     * @param leftNode Nodo izquierdo con el cual se debe hacer la conexion
     * @return si el proceso fue exitoso
     * @throws NodesException Ausencia de implementacion completa en el proyecto
     */
    @Override
    public boolean setLeftNode(Node leftNode) throws NodesException {
        IntegerNode aux = (IntegerNode) leftNode;
        if (this.rightNode!=null) throw new NodesException(NodesException.NOT_EXTEND_YET);
        this.rightNode =  aux;
        return true;
    }

    /**
     * Retorna el nodo izquierdo
     * @return Nodo izquierdo
     */
    @Override
    public Node getLeftNode() {
        return leftNode;
    }

    /**
     * Retorna los datos contenidos en el nodo
     * @return informacion
     */
    public Object getData() {
        return data;
    }

    /**
     * Asigna el valor del nodo
     * @param data asignacion de datos
     */
    public void setData(int data) {
        this.data = data;
    }

    /**
     * retorna el tipo de nodo con el que se esta trabajando
     * @return tipo de nodo
     */
    public String getNodeType() {
        return NODE_TYPE;
    }

    public String toString(){
        return String.valueOf(data);
    }


}
