package Pract2.company;

import java.util.Arrays;
import java.util.Random;

public class Nev_arr implements Runnable{
    int []arr;
    int saiz;

    public Nev_arr() {
    }

    public Nev_arr(int saiz) {
        this.saiz = saiz;
    }

    public int[] getArr() {
        return arr;
    }

    public void setArr(int[] arr) {
        this.arr = arr;
    }

    public int getSaiz() {
        return saiz;
    }

    public void setSaiz(int saiz) {
        this.saiz = saiz;
    }

    @Override
    public String toString() {
        return "Nev_arr{" +
                "arr=" + Arrays.toString(arr) +
                ", saiz=" + saiz +
                '}';
    }

    @Override
    public void run() {
      this.arr=new int[this.saiz];
        Random Ran=new Random(100);
        for (int i=0;i<arr.length;i++)
        {


            this.arr[i]=Ran.nextInt(48);
        }
    }
}
