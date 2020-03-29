import java.util.Random;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Generation generation = new Generation();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i=0;i<=100;i++){
            System.out.println(generation.getFormula(9));
        }


    }


}
