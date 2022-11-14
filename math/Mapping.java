package math;

public class Mapping extends Relation {

    /* 假设关系矩阵纵向为原象，横纵向为象 */
    int mapping = 0; // 映射判断
    int injective = 0; // 单射判断
    int bijection = 0; // 双射判断
    int surjective = 0; // 满射判断
    // 0为未知，1为有，-1为无

    /* 判断映射 */
    public String isMapping(Relation r) {
        int sum1 = 0; // 象计数器
        String str = null;
        loop:
        for (int i = 0; i < r.matrix.length; i++) {
            for (int j = 0; j < r.matrix.length; j++) {
                if (r.matrix[i][j] == 1) {
                    sum1++;
                }
            }
            if (sum1 > 1) {
                mapping = -1;
                str = "该关系不是映射！\n";
                break loop;
            }
            sum1 = 0;
        }
        if (sum1 <= 1) {
            mapping = 1;
            str = "该关系是映射！\n";
        }
        return str;
    }

    /* 判断单射 */
    public String isInjective(Relation r) {
        int sum = 0; // 单射计数
        String str = null;
        if (mapping == -1) {
            str = "该关系不是映射，无法判断单射！\n";
            return str;
        }
        if (mapping == 0) {
            isMapping(r);
            isInjective(r);
        }
        if (mapping == 1) {
            injective = -1;
            loop:
            for (int i = 0; i < r.matrix.length; i++) {
                for (int j = 0; j < r.matrix.length; j++) {
                    if (r.matrix[j][i] == 0) {
                        sum++;
                    }
                }
                if (sum == r.matrix.length) {
                    injective = 1;
                    str = "该关系是单射！\n";
                    break loop;
                } else {
                    str = "该关系不是单射！\n";
                }
                sum = 0;
            }
        }
        return str;
    }

    /* 判断满射 */
    public String isSurjective(Relation r) {

        int sum = 0; // 满射计数
        String str = null;
        if (mapping == -1) {
            str = "该关系不是映射，无法判断满射！\n";
            return str;
        }
        if (mapping == 0) {
            isMapping(r);
            isSurjective(r);
        }
        if (mapping == 1) {

            loop:
            for (int i = 0; i < r.matrix.length; i++) {
                for (int j = 0; j < r.matrix.length; j++) {
                    if (r.matrix[i][j] == 0) {
                        sum++;
                    }
                }
                if (sum == r.matrix.length) {
                    surjective = 1;
                    str = "该关系是满射！\n";
                    break loop;
                } else {
                    surjective = -1;
                    str = "该关系不是满射！\n";
                }
                sum = 0;
            }
        }
        return str;
    }

    /* 判断双射 */
    public String isBijection(Relation r) {

        String str;
        if (mapping == -1) {
            str = "该关系不是映射，无法判断双射！\n";
            return str;
        }
        if (mapping == 0) {
            isMapping(r);
            isBijection(r);
        }
        if (injective == -1 && surjective == -1) {
            bijection = 1;
            str = "该关系是双射\n";
        } else {
            bijection = -1;
            str = "该关系不是双射\n";
        }
        return str;
    }
}
