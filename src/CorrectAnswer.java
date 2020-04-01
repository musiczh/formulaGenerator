import inter.CorrectAnswerInter;

import java.util.ArrayList;
import java.util.List;
import static util.FormulaManager.getSimpleNum;
import static util.FormulaManager.simplifyFormulaFromTxt;

public class CorrectAnswer implements CorrectAnswerInter {
    @Override
    public String correct(List<String> formulas, List<String> answers) throws Exception{
        List<Integer> correctList = new ArrayList<>();
        List<Integer> wrongList = new ArrayList<>();

        for (int i=0;i<formulas.size();i++){
            String formula = simplifyFormulaFromTxt(formulas.get(i));

            String mAnswer = getSimpleNum(util.Calculation.getResult(formula));
            String oAnswer = answers.get(i).replaceAll("\\d+\\. ","") ;

            if (mAnswer.equals(oAnswer)) correctList.add(i+1);
            else    wrongList.add(i+1);
        }

        return "correct " +
                correctList +
                "\n" +
                "wrong " +
                wrongList;
    }


}
