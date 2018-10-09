import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ComputerModel1 {
    public static void main(String[] args){

        double T = 0, lambda = 0;
        T = ComputerModel1.input(T, "T");
        lambda = ComputerModel1.input(lambda, "lambda");

        ArrayList<Double> result1 = new ArrayList<>();
        ArrayList<Double> result2 = new ArrayList<>();
        result1.addAll(Generator.gen1(T, lambda));
        result2.addAll(Generator.gen2(T,lambda));

        output(result1);
        output(result2);
    }

    private static double input(double num, String name){
        Scanner reader = new Scanner(System.in);
        System.out.print(name + " = ");
        num = reader.nextDouble();
        System.out.println();
        return num;
    }

    private static void output (ArrayList<Double> x){
        System.out.println("Однородный: " + x + '\n');
        System.out.println("Всего " + x.size() + " элементов.");
        System.out.println("Сумма элементов равна = " + x.stream().mapToDouble(i -> i).sum());
    }
}
