import java.util.ArrayList;
import java.util.Scanner;

public class ComputerModel1 {
    public static void main(String[] args){

        double T = 0, lambda = 0;
        T = ComputerModel1.input(T, "T");
        lambda = ComputerModel1.input(lambda, "lambda");

        ArrayList<Double> result1 = new ArrayList<>();
        ArrayList<Double> result2 = new ArrayList<>();
        result1.addAll(Generator.gen1(T, lambda));
        result2.addAll(Generator.gen2(T,lambda));

        System.out.println("Однородный: " + result1 + '\n');
        System.out.println("Неоднородный: " + result2 + '\n');
    }

    private static double input(double num, String name){
        Scanner reader = new Scanner(System.in);
        System.out.print(name + " = ");
        num = reader.nextDouble();
        System.out.println();
        return num;
    }
}
