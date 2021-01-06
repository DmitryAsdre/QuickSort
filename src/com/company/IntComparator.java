package com.company;
import java.util.Comparator;
public class IntComparator implements Comparator<Integer>{
    private long counter = 0;
    @Override
    public int compare(Integer v1, Integer v2){
        counter++;
        return v1 < v2 ? -1  : v1 > v2? +1 : 0;
    }
    public long getCounter(){
        return counter;
    }
    public void setZero(){
        counter = 0;
    }
}
