package inter;

import java.util.List;

/**
 * 校对答案接口
 */
public interface CorrectAnswerInter {

    /**
     * 算式与答案要按照规范输入
     * @param formulas 算式
     * @param answers 答案
     * @return 返回校对信息
     */
    String correct(List<String> formulas, List<String> answers) throws Exception;
}
