package Pract2.company;

public class Pros_Num implements Runnable{
int sum;


    @Override
    public void run() {


        boolean prime = true;
        for (int p = 2; p < sum; p++) {
            if (sum % p == 0) {
                prime = false;
                break;
            }
        }
        if (prime)
            System.out.println("The sum is a prime number.");
        else
            System.out.println("The sum is not a prime number.");

    }
}
