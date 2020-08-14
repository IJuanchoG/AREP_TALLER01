package edu.eci.arep.msc.mystatcal.LinkedList.Nodes.Impl;

import edu.eci.arep.msc.mystatcal.LinkedList.Nodes.Node;
import edu.eci.arep.msc.mystatcal.Persistence.Exceptions.NodesException;

public class StringNode implements Node {

    private static final String NODE_TYPE = "string";
    private String data;
    private StringNode rightNode;
    private StringNode leftNode;

    public StringNode(String data, StringNode rightNode ){
        this.data =  data;
        this.rightNode = rightNode;

    }

    public StringNode(String data, StringNode rightNode, StringNode leftNode ){
        this.data =  data;
        this.rightNode = rightNode;
        this.leftNode = leftNode;
    }

    public boolean setRightNode(StringNode rightNode) throws NodesException {
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
            return setRightNode((StringNode) rightNode);
        }catch(ClassCastException e){
            throw new NodesException(NodesException.NODE_UNEXPECTED);
        }

    }

    public StringNode getRightNode(){
        return rightNode;
    }

    @Override
    public boolean setLeftNode(Node leftNode) throws NodesException {
        StringNode aux = (StringNode) leftNode;
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

    public void setData(String data) {
        this.data = data;
    }

    public String getNodeType() {
        return NODE_TYPE;
    }

    public String toString(){
        return String.valueOf(data);
    }
}
