package inter;

import java.util.Set;

public interface IOInter {
    /**
     *
     * @param set 算式集合
     * @return 返回生成文件是否成功
     */
    boolean generateTxt(Set set);
}
