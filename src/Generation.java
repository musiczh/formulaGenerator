import java.util.Random;

/**
 * 负责生成题目的类
 */
public class Generation {

    public String getFormula(int bound){
        int operatorNum = new Random().nextInt(2)+1;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i=0;i<2*operatorNum+1;i++){
            if (i%2==0){

            }else{

            }
        }
        return stringBuilder.toString();
    }



    private void addNum(StringBuilder stringBuilder, int bound){
        int numType = new Random().nextInt(2);
        if (numType<1){

        }else{

        }
    }

    private void addOperator(StringBuilder stringBuilder){

    }

}
