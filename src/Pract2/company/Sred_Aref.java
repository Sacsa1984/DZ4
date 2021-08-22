package Pract2.company;

import java.util.Arrays;

public class Sred_Aref implements Runnable{
    public double Sred_Aref;
    public int []Arr;
    public int Sym;

    public double getSred_Aref() {
        return Sred_Aref;
    }

    public void setSred_Aref(double sred_Aref) {
        Sred_Aref = sred_Aref;
    }

    public int[] getArr() {
        return Arr;
    }

    public void setArr(int[] arr) {
        Arr = arr;
    }

    public int getSym() {
        return Sym;
    }

    public void setSym(int sym) {
        Sym = sym;
    }

    @Override
    public String toString() {
        return "Sred_Aref{" +
                "Sred_Aref=" + Sred_Aref +
                ", Arr=" + Arrays.toString(Arr) +
                ", Sym=" + Sym +
                '}';
    }

    @Override
    public void run() {
        this.Sym = Arrays.stream(this.Arr).sum();
            try {
                this.Sred_Aref = this.Sym / this.Arr.length;
            }
            catch (Exception e) {

                System.out.println(e.getMessage());
            }
        }

}
