package entity;

public class FormulaEntity {
    private String formula;
    private String answer;

    public FormulaEntity(String formula, String answer) {
        this.formula = formula;
        this.answer = answer;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public String getFormula() {
        return formula;
    }

    public void setFormula(String formula) {
        this.formula = formula;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
