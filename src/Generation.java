import inter.GenerateInter;

import java.util.Random;

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
        return addBrackets(stringBuilder.toString(),operatorNum);
    }

    private void addNum(StringBuilder stringBuilder, int bound){
        StringBuilder s = new StringBuilder();
        int numType = getNotZeroIntRandom(3);
        if (numType<=1){
            s.append(getNotZeroIntRandom(bound))
                    .append("/")
                    .append(getNotZeroIntRandom(bound));
        }else{
            s.append(getNotZeroIntRandom(bound))
                    .append("/1");
        }
        stringBuilder.append(s);
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

    private String addBrackets(String s,int operatorNum){
        //只有一个运算符直接返回
        if (operatorNum==1) return s;
        //两个运算符及以上的随机判断是否要进行加括号
        if (getNotZeroIntRandom(2)==1) return s;

        StringBuilder formulaString = new StringBuilder();
        String[] strings = s.split(" ");

        int indexLeft;  //左括号的位置
        int indexRight; //右括号的位置

        if (operatorNum == 2){
            indexLeft = getNotZeroIntRandom(2);
            indexRight = indexLeft + 1;
        }else{
            indexLeft = getNotZeroIntRandom(3);
            if (indexLeft==3) indexRight = 4;
            else if (indexLeft == 2) indexRight = getNotZeroIntRandom(2)+2;
            else  indexRight = getNotZeroIntRandom(2)+1;
        }

        for (int i=0;i<strings.length;i++){
            if (i%2==0){
                if (i==2*indexLeft-2) formulaString.append("( ");
                formulaString.append(strings[i]);
                if (i==2*indexRight-2) formulaString.append(" )");
            }
            else  formulaString.append(" ").append(strings[i]).append(" ");
        }

        return formulaString.toString();


//        if (operatorNum==2){
//
//            int index = getNotZeroIntRandom(2);
//            if (index==1){
//                stringBuilder.insert(0,"( ");
//                stringBuilder.insert(11," )");
//            }
//            else{
//                stringBuilder.insert(6,"( ");
//                stringBuilder.insert(stringBuilder.length()," )");
//            }
//
//        }else if(operatorNum==3){
//            int index = getNotZeroIntRandom(3);
//            switch (index){
//                case 1:
//                    stringBuilder.insert(0,"( ");
//                    switch (getNotZeroIntRandom(3)){
//                        case 1:stringBuilder.insert(11," )"); break;
//                        case 2:stringBuilder.insert(17," )"); break;
//                        case 3:stringBuilder.insert(stringBuilder.length()," )"); break;
//                    }
//                    break;
//                case 2:
//                    stringBuilder.insert(6,"( ");
//                    if (getNotZeroIntRandom(2)==1) stringBuilder.insert(17," )");
//                    else stringBuilder.insert(stringBuilder.length()," )");
//                    break;
//                case 3:
//                    stringBuilder.insert(12,"( ");
//                    stringBuilder.insert(stringBuilder.length()," )");
//                    break;
//                default:break;
//            }
//        }


    }

    private int getNotZeroIntRandom(int bound){
        return new Random().nextInt(bound)+1;
    }

}
