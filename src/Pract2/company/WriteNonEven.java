package Pract2.company;

import java.io.FileWriter;
import java.io.IOException;

public class WriteNonEven extends Thread{
    private int[][] Numbers;
    private int NonEvenCounter = 0;
    private int ROW = 0;

    public WriteNonEven(int[][] Numbers, int ROW){
        this.Numbers = Numbers;
        this.ROW = ROW;
    }

    @Override
    public void run() {
        FileWriter FileNonEven = null;

        try {
            FileNonEven = new FileWriter("FactorialNumbers.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        for(int i = 0; i < ROW;i++) {
            for(int num : Numbers[i]) {
                int factorial = 1;
                for(int j = 1; j <= num; j++){
                    factorial *= j;
                }
                try {
                    FileNonEven.write(factorial + " ");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            try {
                FileNonEven.write("\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            FileNonEven.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
