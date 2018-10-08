import java.util.ArrayList;
import java.util.Random;

public class Generator {

    private static double log2( double a )
    {
        return Math.log(a) / Math.log(2);
    }

    private static double lambdas(double lamb){
        return 1 + 2/(lamb + 1);
    }

    public static ArrayList<Double> gen1(double T, double lambda){
        Random random = new Random();
        double t = 0;
        ArrayList<Double> S = new ArrayList<>();
        while (t < T) {
            double U = random.nextDouble();
            t -= log2(U) / lambda;
            if (t < T) S.add(t);
        }
        return S;
    }

    public static ArrayList<Double> gen2(double T, double lambda){
        Random random = new Random();
        double t = 0;
        ArrayList<Double> S = new ArrayList<>();
        while (t <= T) {
            double U1 = random.nextDouble();
            t -= 1 / lambda * log2(U1);
            if ( t<= T) {
                Random random1 = new Random();
                double U2 = random1.nextDouble();
                if (U2 <= lambdas(t) / lambda) S.add(t);
            }
        }
        return S;
    }
}
