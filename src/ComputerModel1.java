import java.lang.reflect.Array;
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

        output(result1, "Однородный");
        output(result2, "Неоднородный");
    }

    private static double input(double num, String name){
        Scanner reader = new Scanner(System.in);
        System.out.print(name + " = ");
        num = reader.nextDouble();
        System.out.println();
        return num;
    }

    private static void output (ArrayList<Double> x, String k){
        System.out.println(k + ": " + x + '\n');
        System.out.println("Всего " + x.size() + " элементов.");
        System.out.println("Число степеней свободы: " + (x.size()-2));
        System.out.println("Среднее квадратное разностей между эмпирическими и теоретическими частотами = " + calculate(x));
    }

    private static double calculate(ArrayList<Double> x){
        double sum = x.stream().mapToDouble(i -> i).sum();
        double average = 0;
        for (int i = 0; i < x.size(); i++) average += i * x.get(i);
        average = average / sum;

        double[] P = new double[x.size()], n = new double[x.size()], expectedfrequencies = new double[x.size()];
        for(int i = 0; i < x.size(); i++) {
            P[i] = (Math.pow(average, i)*Math.pow(Math.E, -average))/factorial(i);
            n[i] = (sum*P[i]);
            expectedfrequencies[i] = Math.pow((x.get(i) - n[i]),2)/n[i];
        }
        return Arrays.stream(expectedfrequencies).sum();
    }

    private static double factorial(int x){
        int fact = 1;
        for (; x > 0; fact *= x--);
        return fact;
    }
}
