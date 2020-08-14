package edu.eci.arep.msc.mystatcal.LinkedList.Nodes;

import edu.eci.arep.msc.mystatcal.LinkedList.Nodes.Impl.DoubleNode;
import edu.eci.arep.msc.mystatcal.LinkedList.Nodes.Impl.IntegerNode;
import edu.eci.arep.msc.mystatcal.LinkedList.Nodes.Impl.StringNode;
import edu.eci.arep.msc.mystatcal.Persistence.Exceptions.NodesException;

public interface Node {

    public static Node BuildNode(String data, String dataType, Node tail) throws NodesException {
        dataType = dataType.toLowerCase();
        switch(dataType) {
            case ("double"):
                if (tail == null) return new DoubleNode(Double.valueOf(data), null);
                return new DoubleNode(Double.valueOf(data), null,(DoubleNode) tail);
            case("integer"):
                if (tail == null) return new IntegerNode(Integer.valueOf(data), null);
                return new IntegerNode(Integer.valueOf(data), null);
            case("string"):
                if (tail == null) return new StringNode(String.valueOf(data), null);
                return new StringNode(String.valueOf(data), null);
            default:
                throw new NodesException(NodesException.INCORRECT_DATATYPE);
        }
    }

    public boolean setRightNode(Node rightNode) throws NodesException;
    public Node getRightNode();
    public boolean setLeftNode(Node leftNode) throws NodesException;
    public Node getLeftNode();
    public Object getData();
    public String getNodeType();
    public String toString();



}
