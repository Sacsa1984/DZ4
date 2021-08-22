package Pract2.company;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Zapol_File implements Runnable{
    int saiz;

    public Zapol_File() {
    }

    public Zapol_File(int saiz) {
        this.saiz = saiz;
    }

    @Override
    public void run() {

            String Dan = null;

            System.out.println("Введите путь к файлу");

            Scanner scan = new Scanner(System.in);
            Dan = scan.nextLine();
           String str_Rez = Dan.replaceAll("\\\\", "\\\\\\\\").trim();


        FileWriter FileEven = null;
        try {
            FileEven = new FileWriter(str_Rez);
        } catch (IOException e) {
            e.printStackTrace();
        }


        Random Ran=new Random(100);
        for (int i=0;i<saiz;i++)
        {
            try {
                FileEven.write(Integer.toString(Ran.nextInt(48)) + " ");
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
}
