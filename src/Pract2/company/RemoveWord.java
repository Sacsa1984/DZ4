package Pract2.company;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Scanner;

public class RemoveWord extends Thread{
    private String Dir;
    private ArrayList<String> words;

    private int NoNameDorectory = 0;
    private int NoNameFile = 0;

    RemoveWord(String Dir, ArrayList<String> words){
        this.Dir = Dir;
        this.words = words;
    }

    @Override
    public void run(){
        try {
            Check(Dir, Dir);
            Delete(Dir,Dir);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void Check(String dir, String to) throws IOException {
        File folder = new File(dir);

        File[] files = folder.listFiles();

        Path Dir = Paths.get(to);

        System.out.println("1\n" + dir + " " + to);

        if(files != null){
            for(File file: files){
                if(file.isDirectory()){
                    for(String word: words) {
                        if(file.getName().contains(word)){
                            File rename = new File((file.getName().replaceAll(word, "") != "") ? file.getPath().replaceAll(word, "") + file.getName().replaceAll(word, "") : file.getPath().replaceAll(word, "") + "NoNameDir" + NoNameDorectory);

                            if(rename.getName().contains("NoNameDir" + NoNameDorectory)){
                                NoNameDorectory++;
                            }


                            rename.mkdir();

                            Check(file.getPath(),rename.getPath());
                        }
                    }
                }
                if(file.isFile()){
                    FileReader reader = new FileReader(file.getPath());
                    Scanner scanner = new Scanner(reader);

                    ArrayList<String> txt = new ArrayList<>();

                    String name = file.getName();

                    while(scanner.hasNextLine()){
                        String[] line = scanner.nextLine().split(" ");

                        for(String str: line){
                            for(String word: words){
                                if(str.contains(word)){
                                    str = str.replaceAll(word, "");
                                }

                                if(name.contains(word)){
                                    name.replaceAll(word, "");
                                    if(name == ""){
                                        name = "NoNameFile" + NoNameFile;
                                        NoNameFile++;
                                    }
                                }
                            }
                            txt.add(str);
                        }
                    }

                    reader.close();

                    if(name != file.getName()){
                        file.delete();
                    }

                    FileWriter writer = new FileWriter(to + "/" + name);

                    for(String str: txt){
                        writer.write(str + "\n");
                    }

                    writer.close();
                }

                try {
                    if (file.toPath() != Dir.resolve(file.getName())) {
                        System.out.println(1);
                        Files.copy(file.toPath(), Dir.resolve(file.getName()), StandardCopyOption.REPLACE_EXISTING);
                    }
                }catch (NoSuchFileException ex){

                }
            }


        }
    }

    private void Delete(String fold, String dir) throws DirectoryNotEmptyException{
        File folder = new File(fold);

        File[] files = folder.listFiles();

        Path Dir = Paths.get(dir);

        if(files != null){
            for(File file: files){
                try {
                    for(String word: words) {
                        if (file.getName().contains(word)) {
                            file.delete();
                            if (file.isDirectory()) {
                                Delete(file.toPath().toString(), Dir.resolve(file.getName()).toString());
                            }
                        }
                    }
                    try{
                        FileReader reader = new FileReader(file.toPath().toString());

                        Scanner scanner = new Scanner(reader);

                        while(scanner.hasNextLine()){
                            String[] line = scanner.nextLine().split(" ");

                            for(String word: words) {

                                for (String str : line) {
                                    if (str.contains(word)){
                                        file.delete();
                                    }
                                }
                            }
                        }

                    }catch (Exception ex){}

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
