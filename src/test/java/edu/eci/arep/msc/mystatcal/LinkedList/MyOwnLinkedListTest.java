package edu.eci.arep.msc.mystatcal.LinkedList;

import edu.eci.arep.msc.mystatcal.LinkedList.MyOwnLinkedList;
import edu.eci.arep.msc.mystatcal.Persistence.Exceptions.MyOwnLinkedListException;
import edu.eci.arep.msc.mystatcal.Persistence.Exceptions.NodesException;
import edu.eci.arep.msc.mystatcal.StatCal.StatCalculator;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import static org.junit.Assert.fail;

public class MyOwnLinkedListTest {

    @Test
    public void deberiaAgregar(){
        MyOwnLinkedList linkedList = new MyOwnLinkedList("double");
        try {
            boolean aDouble = linkedList.addNode("4", "double");
            Assert.assertTrue("Se agrego correctamente", linkedList.getSize() == 1);
        } catch (NodesException e) {
            fail("Ha lanzado error en Nodos");
        } catch (MyOwnLinkedListException e) {
            fail("Ha lanzado error en MyOwnLinkedList");
        }

    }
    @Test
    public void noDeberiaAgregar(){
        MyOwnLinkedList linkedList = new MyOwnLinkedList("double");
        try {
            boolean aDouble = linkedList.addNode("4", "Lel");
            fail("Agrego");
        } catch (NodesException e) {
            fail("Excepcion incorrecta");
        } catch (MyOwnLinkedListException e) {
            Assert.assertTrue("Excepcion correcta", e.getMessage().matches(MyOwnLinkedListException.INVALID_DATATYPE));
        }

    }

}