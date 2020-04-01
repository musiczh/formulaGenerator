package entity;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 算数式实体类
 * 包括算术式字符串 答案字符串
 * 获取时会自动化简
 */
public class FormulaEntity {
    private String formula;
    private String answer;

    public FormulaEntity(String formula, String answer) {
        this.formula = formula;
        this.answer = answer;
    }

    //重写相等的方法
    @Override
    public boolean equals(Object obj) {
        FormulaEntity other;
        if (obj instanceof FormulaEntity)
        other = (FormulaEntity)obj;
        else return super.equals(obj);

        if (!this.answer.equals(other.answer)) return false;
        if (!(this.formula.matches("[×+]")&&other.formula.matches("[×+]"))) return false;

        String[] mStrings = this.formula.split("\\s+");
        String[] oStrings = other.formula.split("\\s+");
        HashSet<String> set = new HashSet<>(Arrays.asList(mStrings));
        return set.addAll(Arrays.asList(oStrings));
    }

    //获取算术式；自动进行去除分母1；添加等于号
    public String getFormula() {
        return formula;
    }

    //获取答案；自动进行化简
    public String getAnswer() {
        return answer;
    }






}
