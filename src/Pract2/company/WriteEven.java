package Pract2.company;

import java.io.FileWriter;
import java.io.IOException;
import java.util.stream.IntStream;

public class WriteEven extends Thread{
    private int[][] Numbers;
    private int EvenCounter = 0;

    private int ROW;

    public WriteEven(int[][] Numbers, int ROW){
        this.Numbers = Numbers;
        this.ROW = ROW;
    }

    @Override
    public void run() {
        FileWriter FileEven = null;

        try {
            FileEven = new FileWriter("SimpleNumbers.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        for(int i = 0; i < ROW; i++) {
            for (int num : Numbers[i]) {
                if (!isPrime(num) && num != 0 && num != 1) {
                    EvenCounter++;
                    try {
                        FileEven.write(num + " ");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                continue;
            }
            try {
                FileEven.write("\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            FileEven.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean isPrime(final int number) {
        return IntStream.rangeClosed(2, number / 2).anyMatch(i -> number % i == 0);
    }
}
