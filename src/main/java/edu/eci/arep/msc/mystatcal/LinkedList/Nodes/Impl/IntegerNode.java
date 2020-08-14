package edu.eci.arep.msc.mystatcal.LinkedList.Nodes.Impl;

import edu.eci.arep.msc.mystatcal.LinkedList.Nodes.Node;
import edu.eci.arep.msc.mystatcal.Persistence.Exceptions.NodesException;

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

    public boolean setRightNode(IntegerNode rightNode) throws NodesException {
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
            return setRightNode((IntegerNode) rightNode);
        }catch(ClassCastException e){
            throw new NodesException(NodesException.NODE_UNEXPECTED);
        }

    }

    public IntegerNode getRightNode(){
        return rightNode;
    }

    @Override
    public boolean setLeftNode(Node leftNode) throws NodesException {
        IntegerNode aux = (IntegerNode) leftNode;
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

    public void setData(int data) {
        this.data = data;
    }

    public String getNodeType() {
        return NODE_TYPE;
    }

    public String toString(){
        return String.valueOf(data);
    }
}
