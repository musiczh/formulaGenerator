import entity.FormulaEntity;
import inter.IOInter;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import util.FormulaManager;


/**
 * 负责IO操作的类
 */
public class IOManager implements IOInter {

    @Override
    public boolean outputSetToTxt(HashSet<FormulaEntity> set) {
        try {
            //新建文件名
            File fileE = new File(System.getProperty("user.dir")+"/Exercises.txt");
            File fileA = new File(System.getProperty("user.dir")+"/Answers.txt");
            for (int i=1;fileA.exists()&&fileE.exists();i++){
                fileE = new File(System.getProperty("user.dir")+"/Exercises("+i+").txt");
                fileA = new File(System.getProperty("user.dir")+"/Answers("+i+").txt");
            }

            //开启流并把数据注入缓冲流
            BufferedWriter bufferedWriterA = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileA)));
            BufferedWriter bufferedWriterE = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileE)));
            Iterator<FormulaEntity> iterable = set.iterator();
            for (int i=1;iterable.hasNext();i++){
                FormulaEntity formulaEntity = iterable.next();

                bufferedWriterE.write(i+". "+formulaEntity.getFormula().replaceAll("/1 "," ")+" =");
                bufferedWriterA.write(i+". "+FormulaManager.getSimpleNum(formulaEntity.getAnswer()) );

                if (iterable.hasNext()){
                    bufferedWriterE.newLine();
                    bufferedWriterA.newLine();
                }
            }

            //写入数据并关闭流
            bufferedWriterA.flush();
            bufferedWriterE.flush();
            bufferedWriterA.close();
            bufferedWriterE.close();
            return true;
        }catch (Exception e){
            //出现异常返回false
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public List<String> inputListFromTxt(String url) {
        try {
            File file = new File(url);
            if (!file.exists()) file = new File(System.getProperty("user.dir"));
            if (!file.exists()) return null;

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            List<String> list = new ArrayList<>();
            String s = bufferedReader.readLine();

            while (s!=null){
                list.add(s);
                s = bufferedReader.readLine();
            }
            return list;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }


}
