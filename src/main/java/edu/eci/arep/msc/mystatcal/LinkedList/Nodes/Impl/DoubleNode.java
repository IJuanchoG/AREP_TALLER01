package edu.eci.arep.msc.mystatcal.LinkedList.Nodes.Impl;

import edu.eci.arep.msc.mystatcal.LinkedList.Nodes.Node;
import edu.eci.arep.msc.mystatcal.Persistence.Exceptions.NodesException;

public class DoubleNode implements Node {

    private static final String NODE_TYPE = "double";
    private double data;
    private DoubleNode rightNode;
    private DoubleNode leftNode;

    public DoubleNode(double data, DoubleNode rightNode ){
        this.data =  data;
        this.rightNode = rightNode;
        this.leftNode = null;

    }

    public DoubleNode(double data, DoubleNode rightNode, DoubleNode leftNode ){
        this.data =  data;
        this.rightNode = rightNode;
        this.leftNode = leftNode;
    }

    public boolean setRightNode(DoubleNode rightNode) throws NodesException {
        if (this.rightNode!=null) throw new NodesException(NodesException.NOT_EXTEND_YET);
        this.rightNode =  rightNode;
        return true;
    }

    @Override
    public boolean setRightNode(Node rightNode) throws NodesException {
        try{
            if(rightNode == null) {
                this.rightNode = null;
                return true;
            }
            return setRightNode((DoubleNode) rightNode);
        }catch(ClassCastException e){
            throw new NodesException(NodesException.NODE_UNEXPECTED);
        }

    }

    public DoubleNode getRightNode(){
        return rightNode;
    }

    @Override
    public boolean setLeftNode(Node leftNode) throws NodesException {
        DoubleNode aux = (DoubleNode) leftNode;
        if (this.rightNode!=null) throw new NodesException(NodesException.NOT_EXTEND_YET);
        this.rightNode =  aux;
        return true;
    }

    @Override
    public Node getLeftNode() {
        return leftNode;
    }

    public Object getData() {
        return data;
    }

    public void setData(double data) {
        this.data = data;
    }

    public String getNodeType() {
        return NODE_TYPE;
    }

    public String toString(){
        return String.valueOf(data);
    }
}
