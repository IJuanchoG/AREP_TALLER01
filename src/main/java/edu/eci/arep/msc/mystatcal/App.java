package edu.eci.arep.msc.mystatcal;

import edu.eci.arep.msc.mystatcal.LinkedList.MyOwnLinkedList;
import edu.eci.arep.msc.mystatcal.Persistence.Exceptions.MyOwnLinkedListException;
import edu.eci.arep.msc.mystatcal.Persistence.Exceptions.NodesException;
import edu.eci.arep.msc.mystatcal.StatCal.StatCalculator;

/**
 * Hello world!
 *
 */
public class App 
{
    MyOwnLinkedList linkedList;

    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        new App();

    }


    public App(){
        linkedList = new MyOwnLinkedList("double");
        LlenarListaCaso1();
        //LlenarListaCaso2();
        MostrarLista();
        CalcularDesviacion();
    }

    public void LlenarListaCaso1(){
        try {
            linkedList.addNode("160", "double");
            linkedList.addNode("591","double");
            linkedList.addNode("114","double");
            linkedList.addNode("229","double");
            linkedList.addNode("230","double");
            linkedList.addNode("270","double");
            linkedList.addNode("128","double");
            linkedList.addNode("1657","double");
            linkedList.addNode("624","double");
            linkedList.addNode("1503","double");
        } catch (NodesException e) {
            e.printStackTrace();
        }catch (MyOwnLinkedListException e) {
            e.printStackTrace();
        }

    }

    public void LlenarListaCaso2(){
        try {
            linkedList.addNode("15", "double");
            linkedList.addNode("69.9","double");
            linkedList.addNode("6.5","double");
            linkedList.addNode("22.4","double");
            linkedList.addNode("28.4","double");
            linkedList.addNode("65.9","double");
            linkedList.addNode("19.4","double");
            linkedList.addNode("198.7","double");
            linkedList.addNode("38.8","double");
            linkedList.addNode("138.2","double");
        } catch (NodesException e) {
            e.printStackTrace();
        }catch (MyOwnLinkedListException e) {
            e.printStackTrace();
        }

    }

    public void CalcularDesviacion(){
        System.out.println("Sum: "+StatCalculator.Sum(linkedList));
        System.out.println("Mean: "+StatCalculator.Mean(linkedList));
        System.out.println("Deviation: "+StatCalculator.Deviation(linkedList));
    }
    public void MostrarLista(){
        System.out.println(linkedList);
    }
}
