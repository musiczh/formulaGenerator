package inter;

import entity.FormulaEntity;

import java.util.HashSet;
import java.util.List;

public interface IOInter {

    /**
     * @param set 算式集合
     * @return 返回生成文件是否成功
     */
    boolean outputSetToTxt(HashSet<FormulaEntity> set);

    /**
     * 读取txt文件并生成List对象；对象不存在返回null
     * @param  url 文件地址;可以相对路径也可以是绝对路径
     * @return 按行生成一个List；对象不存在返回null
     */
    List<String> inputListFromTxt(String url);


}
