package Pract2.company;

import java.util.Arrays;

public class Sym implements Runnable{
    public int Sym;
    public int []Arr;

    public Sym() {
    }

    public int getSym() {
        return Sym;
    }

    public void setSym(int sym) {
        Sym = sym;
    }


    public int[] getArr() {
        return Arr;
    }

    public void setArr(int[] arr) {
        Arr = arr;
    }

    @Override
    public String toString() {
        return "Sym{" +
                "Sym=" + Sym +
                ", Arr=" + Arrays.toString(Arr) +
                '}';
    }

    @Override
    public void run() {

          this.Sym = Arrays.stream(this.Arr).sum();



    }
}
