package Pract2.company;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {

    public static void main(String[] args)throws Exception {




                Scanner scanner = new Scanner(System.in);
                while ( true ) {
                    System.out.println("Вібор задания 1-4 выход 0 ");
                    int selection = scanner.nextInt();
                    switch (selection) {
                        case 1: {
                            Nev_arr arr = new Nev_arr(5);
                            Thread Thred_arr = new Thread(arr);
                            Sym sym = new Sym();
                            Thread Thread_Sym = new Thread(sym);
                            Sred_Aref sred = new Sred_Aref();
                            Thread Thread_sred = new Thread(sred);
                            Thred_arr.start();


                            try {
                                Thred_arr.join();
                                System.out.println("создан массив \n" + arr.toString());
                            } catch (InterruptedException ex) {
                                System.out.println(ex.getMessage());
                            }

                            sym.setArr(arr.getArr());
                            sred.setArr(arr.getArr());
                            Thread_Sym.start();
                            Thread_sred.start();
                            try {
                                Thread_Sym.join();
                                Thread_sred.join();
                            } catch (InterruptedException ex) {
                                System.out.println(ex.getMessage());
                            }
                            System.out.println("сумма всех елементов массива \n" + sym.getSym());
                            System.out.println("среднеарифмтическое елементов массива \n" + sred.getSred_Aref());
                            break;
                        }
                        case 2: {
                            scanner = new Scanner(System.in);

                            System.out.print("путь к файлу: ");
                            String path = scanner.nextLine();

                            Write write = new Write(path);

                            write.start();
                            write.join();

                            int[][] FileNumbers = write.Return();

                            WriteEven EvenThread = new WriteEven(FileNumbers, write.ROW());
                            WriteNonEven NonEvenThread = new WriteNonEven(FileNumbers, write.ROW());

                            EvenThread.start();
                            NonEvenThread.start();

                            try {
                                EvenThread.join();
                                NonEvenThread.join();
                            } catch (InterruptedException ex) {
                                ex.fillInStackTrace();
                            }


                            break;
                               }
                        case 3: {
                             scanner = new Scanner(System.in);

                            System.out.print("Dir1: ");
                            String Dir1 = scanner.nextLine();

                            System.out.print("Dir2: ");
                            String Dir2 = scanner.nextLine();

                            CopyDir copyDir = new CopyDir(Dir1, Dir2);

                            copyDir.start();

                            try{
                                copyDir.join();
                            }
                            catch (InterruptedException ex){
                                ex.fillInStackTrace();
                            }


                            break;
                        }
                        case 4: {
                             scanner = new Scanner(System.in);

                            ArrayList<String> words = new ArrayList<>();

                            System.out.print("Dir: ");
                            String path = scanner.nextLine();

                            System.out.print("Words path: ");
                            String data = scanner.nextLine();

                            FileReader reader = new FileReader(data);

                            scanner = new Scanner(reader);

                            while (scanner.hasNextLine()){
                                String[] line = scanner.nextLine().split(" ");

                                for(String str: line){
                                    words.add(str);
                                }
                            }

                            reader.close();

                            CopyDirWithWord copyDirWithWord = new CopyDirWithWord(path,path + "1", words);
                            copyDirWithWord.start();


                            try{
                                copyDirWithWord.join();
                            }
                            catch (InterruptedException ex){
                                ex.fillInStackTrace();
                            }

                            RemoveWord removeWord = new RemoveWord(path + "1", words);
                            removeWord.start();

                            try {
                                removeWord.join();
                            }catch (InterruptedException ex){
                                ex.fillInStackTrace();
                            }



                            break;
                        }
                        case 0: {
                            System.exit(1);
                            break;
                        }
                        default: {
                            System.out.println("не коректные данные");
                        }
                    }
                }
    }
}
