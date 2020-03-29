import inter.GenerateInter;

import java.util.Random;
import java.util.regex.Pattern;

/**
 * 负责生成题目的类
 */
public class Generation implements GenerateInter {

    /**
     * 唯一的公共方法；返回一个随机算式String对象
     */
    @Override
    public String getFormula(int bound){
        int operatorNum = getNotZeroIntRandom(3);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i=0;i<2*operatorNum+1;i++){
            if (i%2==0){
                addNum(stringBuilder,bound);
            }else{
                addOperator(stringBuilder);
            }
        }
        addBrackets(stringBuilder,operatorNum);
        return stringBuilder.toString();
    }

    private void addNum(StringBuilder stringBuilder, int bound){
        int numType = getNotZeroIntRandom(3);
        if (numType<=1){
            stringBuilder.append(getNotZeroIntRandom(bound))
                    .append("/")
                    .append(getNotZeroIntRandom(bound));
        }else{
            stringBuilder.append(getNotZeroIntRandom(bound))
                    .append("/1");
        }
    }

    private void addOperator(StringBuilder stringBuilder){
        int type = getNotZeroIntRandom(4);
        switch (type){
            case 1: stringBuilder.append(" + "); break;
            case 2: stringBuilder.append(" - "); break;
            case 3: stringBuilder.append(" × "); break;
            case 4: stringBuilder.append(" ÷ "); break;
            default:break;
        }
    }

    private void addBrackets(StringBuilder stringBuilder,int operatorNum){
        if (operatorNum==2){

            int index = getNotZeroIntRandom(2);
            if (index==1){
                stringBuilder.insert(0,"( ");
                stringBuilder.insert(11," )");
            }
            else{
                stringBuilder.insert(6,"( ");
                stringBuilder.insert(stringBuilder.length()," )");
            }

        }else if(operatorNum==3){
            int index = getNotZeroIntRandom(3);
            switch (index){
                case 1:
                    stringBuilder.insert(0,"( ");
                    switch (getNotZeroIntRandom(3)){
                        case 1:stringBuilder.insert(11," )"); break;
                        case 2:stringBuilder.insert(17," )"); break;
                        case 3:stringBuilder.insert(stringBuilder.length()," )"); break;
                    }
                    break;
                case 2:
                    stringBuilder.insert(6,"( ");
                    if (getNotZeroIntRandom(2)==1) stringBuilder.insert(17," )");
                    else stringBuilder.insert(stringBuilder.length()," )");
                    break;
                case 3:
                    stringBuilder.insert(12,"( ");
                    stringBuilder.insert(stringBuilder.length()," )");
                    break;
                default:break;
            }
        }


    }

    private int getNotZeroIntRandom(int bound){
        return new Random().nextInt(bound)+1;
    }

}
