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
        System.out.println("Сумма элементов равна = " + x.stream().mapToDouble(i -> i).sum());
        System.out.println("выборочная средняя равна = " + nixi(x));
        System.out.println("вероятности P = " + Pi(x));
        ArrayList<Double> p = new ArrayList<>();
        p.addAll(Pi(x));
        System.out.println("теор частоты = " + ni(p, x.size()));
        System.out.println("сумма частот = " + ni(p, x.size()).stream().mapToDouble(i -> i).sum());
    }

    private static double nixi(ArrayList<Double> x){
        double res = 0.0;
        for (int i = 0; i < x.size(); i++){
            res += x.get(i)*(i);
        }

        return res/x.size();
    }

    private static ArrayList<Double> Pi (ArrayList<Double> x){
        ArrayList<Double> P = new ArrayList<>();
        for (int i = 0; i < x.size(); i++) P.add((Math.pow(nixi(x), i) * Math.pow(Math.E, (-nixi(x))))/factorial(i));
        return P;
    }

    private static ArrayList<Double> ni(ArrayList<Double> x, int y){
        ArrayList<Double> n = new ArrayList<>();
        double ex = 0, sum = 0;
        for (int i = 0; i < x.size(); i++){
            ex = y * x.get(i);
            if (ex >= 5.0) n.add(ex);
            else{
                System.out.println("элемент " + i + " был объединен");
                sum += ex;
                if (sum >= 5.0 || (i + 1) == x.size()){
                    System.out.println("разъединение");
                    n.add(sum);
                    sum = 0.0;
                }
            }
        }
        return n;
    }

    public static double factorial(int x){
        int fact = 1;
        for (; x > 0; fact *= x--);
        return fact;
    }
}
