package Pract2.company;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Scanner;

public class CopyDirWithWord extends Thread {
    private String SDir;
    private String TDir;
    private ArrayList<String> words;

    CopyDirWithWord(String SDir, String TDir, ArrayList<String> words){
        this.SDir = SDir;
        this.TDir = TDir;
        this.words = words;

        File fold = new File(TDir);
        fold.mkdir();
    }

    @Override
    public void run(){
        try {
            Copy(SDir,TDir);
        } catch (DirectoryNotEmptyException e) {
            e.printStackTrace();
        }
    }

    private void Copy(String fold, String dir) throws DirectoryNotEmptyException {
        File folder = new File(fold);

        File[] files = folder.listFiles();

        Path Dir = Paths.get(dir);

        if (files != null) {
            for (File file : files) {
                try {
                    for (String word : words) {
                        if (file.getName().contains(word)) {
                            Files.copy(file.toPath(), Dir.resolve(file.getName()), StandardCopyOption.REPLACE_EXISTING);
                            if (file.isDirectory()) {
                                Copy(file.toPath().toString(), Dir.resolve(file.getName()).toString());
                            }
                        }
                    }
                    try {
                        FileReader reader = new FileReader(file.toPath().toString());

                        Scanner scanner = new Scanner(reader);

                        while (scanner.hasNextLine()) {
                            String[] line = scanner.nextLine().split(" ");

                            for (String word : words) {

                                for (String str : line) {
                                    if (str.contains(word)) {
                                        Files.copy(file.toPath(), Dir.resolve(file.getName()), StandardCopyOption.REPLACE_EXISTING);
                                    }
                                }
                            }
                        }

                    } catch (Exception ex) {
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
