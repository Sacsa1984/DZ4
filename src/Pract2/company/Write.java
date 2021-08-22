package Pract2.company;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Write extends Thread{
    private int ROW = 4;
    private int COL = 5;

    private int[][] file = new int[ROW][COL];
    private String path;

    public Write(String path){
        this.path = path;
    }

    @Override
    public void run(){
        FileWriter writer = null;
        try {
            writer = new FileWriter(path);
        } catch (IOException e) {
            e.printStackTrace();
        }

        for(int i = 0; i < ROW; i++){
            for(int j = 0; j < COL;j++){
                file[i][j] = (new Random()).nextInt(10);

                try {
                    writer.write(file[i][j] + " ");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            try {
                writer.write("\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int[][] Return(){ return file; }
    public int ROW(){ return ROW; }
}
