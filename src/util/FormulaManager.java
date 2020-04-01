package util;

public class FormulaManager {

    /**
     * 把假分数化简为真分数
     * @param num 需要化简的假分数
     * @return 返回真分数 （2'8/9)
     */
    public static String getSimpleNum(String num) throws Exception{
        //判断分母是否为1
        String[] strings = num.split("/");
        int firstNum = Integer.parseInt(strings[0]);
        int secondNum = Integer.parseInt(strings[1]);
        if (secondNum==1) return String.valueOf(firstNum);

        //判断是否整除
        int thirdNum = firstNum/secondNum;
        firstNum = firstNum%secondNum;
        if (firstNum == 0) return String.valueOf(thirdNum);

        //化简
        int divisor = gcd(firstNum,secondNum);
        firstNum = firstNum/divisor;
        secondNum = secondNum/divisor;

        if (thirdNum ==0) return firstNum +"/"+ secondNum;
        else return thirdNum+"'"+firstNum +"/"+ secondNum;
    }

    /**
     * 化简来自txt的数据
     * @param formulaP 格式：1. 1+1 =
     * @return 返回规格化的算术式
     */
    public static String simplifyFormulaFromTxt(String formulaP){
        String formula = formulaP.replaceAll("(\\d+\\.\\s+)|( =)","");
        String[] strings = formula.split("\\s+");
        StringBuilder stringBuilder = new StringBuilder();
        for (String s:strings){
            if (!s.matches("[×÷+\\-()]")){
                if (s.contains("/")) stringBuilder.append(s);
                else stringBuilder.append(s).append("/1");
            }else{
                if (s.equals("(")) stringBuilder.append(s).append(" ");
                else if (s.equals(")")) stringBuilder.append(" ").append(s);
                else stringBuilder.append(" ").append(s).append(" ");
            }
        }
        formula = stringBuilder.toString();
        return formula;
    }


    //辗转相除求最大公约数
    private static int gcd(int firstNum,int secondNum){
        int remainder = secondNum%firstNum;
        int maxNum;
        int minNum = firstNum;
        while (remainder!=0){
            maxNum = firstNum;
            minNum = remainder;
            remainder = maxNum%minNum;
        }
        return minNum;
    }

}
