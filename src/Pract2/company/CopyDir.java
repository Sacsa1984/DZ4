package Pract2.company;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class CopyDir extends Thread{
    private String SDir;
    private String TDir;

    CopyDir(String SDir, String TDir){
        this.SDir = SDir;
        this.TDir = TDir;
    }

    @Override
    public void run(){
        Copy(SDir,TDir);
    }

    private void Copy(String fold, String dir){
        File folder = new File(fold);

        File[] files = folder.listFiles();

        Path Dir = Paths.get(dir);

        if(files != null){
            for(File file: files){
                try {
                    Files.copy(file.toPath(), Dir.resolve(file.getName()), StandardCopyOption.REPLACE_EXISTING);
                    if(file.isDirectory()){
                        Copy(file.toPath().toString(),Dir.resolve(file.getName()).toString());
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
