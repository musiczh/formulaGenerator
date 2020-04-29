import entity.FormulaEntity;
import entity.Parent;
import entity.Son;
import util.Calculation;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class Main {

    static HashSet<FormulaEntity> hashSet = new HashSet<>();
    static int n,r;
    static int i;

    public static void main(String[] args) {

        while(true) {
            System.out.println("请输入指令：");
            System.out.println("-n 参数控制生成题目的个数，例如 -n 10");
            System.out.println("-r 参数控制题目中数值（自然数、真分数和真分数分母）的范围，例如-r 10");
            System.out.println("-e <exercisefile>.txt -a <answerfile>.txt 校队答案");
            System.out.println("-s 开始生成题目");
            Scanner input=new Scanner(System.in);//浠庨敭鐩樹笂杈撳叆鎸囦护骞舵墽琛�
            String command=input.nextLine();
            String[] strings=command.split("\\s+");
            switch(strings[0]){

                case "-n" :
                    try {
                        n=Integer.parseInt(strings[1]);
                        if(n<=0) {
                            throw new Exception();
                        }
                    }catch(Exception e) {
                        System.out.println("请设置大于0的自然数");
                    }

                    break;
                case "-r" :
                    try {
                        r=Integer.parseInt(strings[1]);
                        if(n<=0) {
                            throw new Exception();
                        }
                    }catch(Exception e) {
                        System.out.println("请设置大于0的自然数");
                    }
                    break;

                case "-s" :
                    if(n!=0&&r!=0) {
                        i=0;
                        hashSet.clear();
                        Generation generation = new Generation();
                        IOManager ioManager = new IOManager();
                        startThread();
                        while(hashSet.size()<n){
                            String formula = generation.getFormula(r);
//                            System.out.println(formula);
                            String answer = Calculation.getResult(formula);
                            if (answer!=null) hashSet.add(new FormulaEntity(formula,answer));
                        }
                        ioManager.outputSetToTxt(hashSet);
                    }else{
                        if(n==0) {
                            System.out.println("请先设置题目个数");
                        }
                        if(r==0) {
                            System.out.println("请先设置数字范围-");
                        }

                    }
                    break;
                case "-e" :
                    try {
                        IOManager ioManager = new IOManager();
                        List<String> exercise = ioManager.inputListFromTxt(strings[1]);
                        List<String> answer = ioManager.inputListFromTxt(strings[3]);
                        System.out.println(new CorrectAnswer().correct(exercise,answer));
                    }catch (Exception e){
                        System.out.println("文件格式不对");
                    }
                    break;
                default :
                    System.out.println("请输入正确指令");
                    break;
            }
        }
    }

    private static void startThread() {
        new Thread() {
            int curr_i=i;
            public void run(){
                boolean flag=true;
                while(flag) {
                    try {
                        sleep(500);
                        if(curr_i==i) {
                            i=n;
                            flag=false;
                        }else {
                            curr_i=i;
                        }
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }

                }
            }
        }.start();


    }









}
