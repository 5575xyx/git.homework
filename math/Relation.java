package math;

public class Relation {
    //创建一个二维数组以存储矩阵
    public int[][] matrix;

    //关系闭包的输出方法
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                str.append(matrix[i][j] == 1 ? 1 + " " : 0 + " ");
            }
            str.append("\n");
        }
        return str.toString();
    }

    //构造方法，创建关系
    public Relation() {
    }

    //创建对象作为返回值，输出矩阵
    public Relation(int[][] matrix) {
        this.matrix = matrix;
    }

    //自反性的判断
    public boolean isReflexivity() {
        //遍历数组
        for (int i = 0; i < matrix.length; i++) {
            //判断主对角线元素是否为1
            if (matrix[i][i] != 1) {
                return false;
            }
        }
        return true;
    }

    //反自反性的判断
    public boolean isIrreflexivity() {
        //遍历数组
        for (int i = 0; i < matrix.length; i++) {
            //判断主对角线元素是否为0
            if (matrix[i][i] != 0) {
                return false;
            }
        }
        return true;
    }

    //对称性的判断
    public boolean isSymmetry() {
        //遍历数组
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                //判断对称位置元素是否一致
                if (matrix[i][j] != matrix[j][i] && i != j) {
                    return false;
                }
            }
        }
        return true;
    }

    //反对称性的判断
    public boolean isAntisymmetry() {
        //遍历数组
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix.length; j++) {
                //判断对称位置元素是否一致
                if (matrix[i][j] == matrix[j][i] && i != j) {
                    return false;
                }
            }
        }
        return true;
    }

    //传递性的判断
    public boolean isTransitivity() {
        int[][] temp = new int[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                temp[i][j] = 0;
                for (int z = 0; z < matrix.length; z++) {
                    temp[i][j] += matrix[i][z] * matrix[z][j];
                }
            }
        }
        boolean flag = true;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (temp[i][j] == 1 && matrix[i][j] == 0) {
                    flag = false;
                    break;
                }
            }
        }
        return flag;
    }

    //自反闭包的计算
    public static Relation reflexiveClosure(Relation r) {
        if (r.isReflexivity()) {
            return r;
        } else {
            for (int i = 0; i < r.matrix.length; i++) {
                r.matrix[i][i] = 1;
            }
        }
        return r;
    }

    //对称闭包的计算
    public static Relation symmetricClosure(Relation r) {
        if (r.isSymmetry()) {
            return r;
        } else {
            for (int i = 0; i < r.matrix.length; i++) {
                for (int j = 0; j < r.matrix.length; j++) {
                    if ((r.matrix[i][j] == 1 || r.matrix[j][i] == 1) && i != j) {
                        r.matrix[i][j] = r.matrix[j][i] = 1;
                    }
                }
            }
        }
        return r;
    }

    //传递闭包的计算
    public static Relation transitiveClosure(Relation r) {
        if (r.isTransitivity()) {
            return r;
        } else {
            for (int k = 0; k < r.matrix.length; k++) {
                for (int i = 0; i < r.matrix.length; i++) {
                    for (int j = 0; j < r.matrix.length; j++) {
                        if (r.matrix[i][j] == 1 || r.matrix[i][k] == 1 && r.matrix[k][j] == 1) {
                            r.matrix[i][j] = 1;
                        }

                    }
                }
            }
        }
        return r;
    }

    //交集计算
    public static Relation intersection(Relation r1, Relation r2) {
        //先判断是否能进行交集运算
        if (r1.matrix.length != r2.matrix.length) {
            System.out.println("两个矩阵阶数不同，无法进行交集运算");
        }
        int[][] m = new int[r1.matrix.length][r1.matrix.length];
        for (int i = 0; i < r1.matrix.length; i++) {
            for (int j = 0; j < r1.matrix.length; j++) {
                if (r1.matrix[i][j] == 1 && r2.matrix[i][j] == 1) {
                    m[i][j] = 1;
                }else{
                    m[i][j] = 0;
                }
            }
        }
        return new Relation(m);
    }

    //并集计算
    public static Relation union(Relation r1, Relation r2) {
        //判断是否能进行并集运算
        if (r1.matrix.length != r2.matrix.length) {
            System.out.println("两个矩阵阶数不同，无法做并集运算！");
        }
        int[][] m = new int[r1.matrix.length][r1.matrix.length];
        for (int i = 0; i < r1.matrix.length; i++) {
            for (int j = 0; j < r1.matrix.length; j++) {
                if (r1.matrix[i][j] == 1 || r2.matrix[i][j] == 1) {
                    m[i][j] = 1;
                }
            }
        }
        return new Relation(m);
    }

    //逆运算
    public static Relation inverse(Relation r) {
        int index = r.matrix.length;
        int[][] m = new int[index][index];
        for (int i = 0; i < index; i++) {
            for (int j = 0; j < index; j++) {
                m[i][j] = r.matrix[j][i];
            }
        }
        return new Relation(m);
    }

    //复合运算
    public static Relation compound(Relation r1, Relation r2) {
        if (r1.matrix.length != r2.matrix.length) {
            System.out.println("两个矩阵阶数不同，无法复合运算！");
        }
        int[][] m = new int[r1.matrix.length][r1.matrix.length];
        for (int i = 0; i < r1.matrix.length; i++) {
            for (int j = 0; j < r1.matrix.length; j++) {
                for (int k = 0; k < r1.matrix.length; k++) {
                    if (r1.matrix[i][k] == 1 && r1.matrix[k][j] == 1) {
                        m[i][j] = 1;
                        break;
                    }
                }
            }
        }
        return new Relation(m);
    }
}
