package edu.eci.arep.msc.mystatcal.StatCal;

import edu.eci.arep.msc.mystatcal.LinkedList.MyOwnLinkedList;
import edu.eci.arep.msc.mystatcal.LinkedList.Nodes.Node;

public class StatCalculator {

    public static String Deviation(MyOwnLinkedList linkedList){
        int size = linkedList.getSize();
        double mean = Double.valueOf(StatCalculator.Mean(linkedList));
        double Expo = Double.valueOf(StatCalculator.DeviationSum(linkedList,mean));
        double sqrt = Math.sqrt(Expo/(size-1));
        return String.valueOf(StatCalculator.Round(sqrt,2));
    }

    public static String Mean(MyOwnLinkedList linkedList){
        int size = linkedList.getSize();
        String sum = StatCalculator.Sum(linkedList);
        String dataType = linkedList.getDataType();
        double mean;
        if(dataType == "double") {
            mean = Double.valueOf(sum)/size;
        } else if (dataType == "integer"){
            mean = Integer.valueOf(sum)/size;
        } else{ throw new IllegalStateException("Unexpected value: " + dataType); }
        return String.valueOf(StatCalculator.Round(mean,2));
    }


    public static String Sum(MyOwnLinkedList linkedList){
        String dataType = linkedList.getDataType();
        Node aux = linkedList.priorNode();
        if (dataType == "double"){
            double value = 0;
            while(aux!=null){
                value+= (Double) aux.getData();
                aux = aux.getRightNode();
            }
            return String.valueOf(value);
        }else if(dataType == "integer"){
            int value = 0;
            while(aux!=null){
                value+= (Integer) aux.getData();
                aux = aux.getRightNode();
            }
            return String.valueOf(value);
        }else{ throw new IllegalStateException("Unexpected value: " + dataType); }
    }

    private static String Round(double number, int nDigit) {
        double digits = Double.valueOf(Math.pow(10,nDigit));
        return String.valueOf((double)Math.round(number * digits) / digits);
    }

    private static String DeviationSum(MyOwnLinkedList linkedList, double mean){
        String dataType = linkedList.getDataType();
        Node aux = linkedList.priorNode();
        if (dataType == "double"){
            double value = 0;
            while(aux!=null){
                value+= Math.pow((Double) aux.getData() - mean, 2);
                aux = aux.getRightNode();
            }
            return String.valueOf(value);
        }else if(dataType == "integer"){
            int value = 0;
            while(aux!=null){
                value+= Math.pow((Integer) aux.getData() - mean,2);
                aux = aux.getRightNode();
            }
            return String.valueOf(value);
        }else{
            throw new IllegalStateException("Unexpected value: " + dataType);
        }
    }

}
