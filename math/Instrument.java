package math;

import java.util.Scanner;

public class Instrument {
    Scanner sc = new Scanner(System.in);

    public void show() {
        System.out.println("-----------------------------欢迎来到离散数学关系运算-------------------------------------");
        operation();
    }

    public void operation() {
        lood:
        while (true) {
            System.out.print("\n请输入所需进行的性质判断或运算：\n 1.性质判断 \n 2.闭包运算 \n 3.交、并、补、逆、复合运算 \n 4.关系判断 \n 5.映射判断 \n 6.退出 \n");
            System.out.println("---------------------------------------------------------------");
            System.out.print("请输入您的选择：");
            String choose = sc.next();

            switch (choose) {
                case "1" -> {
                    System.out.println("已进入性质判断");
                    natureJudge();
                }
                case "2" -> {
                    System.out.println("已进入闭包运算");
                    closureOperation();
                }
                case "3" -> {
                    System.out.println("已进入交、并、补、逆、复合运算");
                    jbnfOperation();
                }
                case "4" -> {
                    System.out.println("已进入关系判断");
                    relationJudge();
                }
                case "5" -> {
                    System.out.println("已进入映射判断");
                    mappingJudge();
                }
                case "6" -> {
                    break lood;
                }
                default -> System.out.println("无此选项");
            }
        }
    }

    //映射判断
    public void mappingJudge() {
        Relation r = new Relation(input(1));
        lood:
        while (true) {
            System.out.println("\n请输入要判断的映射类型：1.映射  2.单射  3.满射  4.双射  5.退出");
            String choose = sc.next();
            Mapping map = new Mapping();
            switch (choose) {
                case "1" -> {
                    System.out.println("已进入映射");
                    System.out.println("此矩阵: \n" + map.isMapping(r));
                }
                case "2" -> {
                    System.out.println("已进入单射");
                    System.out.println("此矩阵: \n" + map.isInjective(r));
                }
                case "3" -> {
                    System.out.println("已进入满射");
                    System.out.println("此矩阵: \n" + map.isSurjective(r));
                }
                case "4" -> {
                    System.out.println("已进入双射");
                    System.out.println("此矩阵: \n" + map.isBijection(r));
                }
                case "5" -> {
                    break lood;
                }
                default -> System.out.println("无此选项");
            }
        }
    }

    //关系判断
    public void relationJudge() {
        Relation r = new Relation(input(1));
        lood:
        while (true) {
            System.out.println("\n请输入要判断的关系类型：1.等价关系  2.相容关系  3.偏序关系  4.退出");
            String choose = sc.next();
            switch (choose) {
                case "1" -> {
                    System.out.println("已进入等价关系判断");
                    equivalOutput(r);
                }
                case "2" -> {
                    System.out.println("已进入相容关系判断");
                    compatibleOutput(r);
                }
                case "3" -> {
                    System.out.println("已进入偏序关系判断");
                    partialOutput(r);
                }
                case "4" -> {
                    break lood;
                }
                default -> System.out.println("无此选项");
            }
        }
    }

    //偏序关系
    public void partialOutput(Relation r) {
        //偏序关系判断输出
        PartialOrderRelation p = new PartialOrderRelation();
        System.out.println("此矩阵：" + p.isPartialOrderingRelation(r));
    }

    //相容关系
    public void compatibleOutput(Relation r) {
        //相容关系判断输出
        CompatibleRelation cbr = new CompatibleRelation();
        System.out.println("此矩阵：" + cbr.isConsistentRelation(r));
    }

    //等价关系
    public void equivalOutput(Relation r) {
        //等价关系判断输出
        EquivalenceRelation eqr = new EquivalenceRelation();
        System.out.println("此矩阵：" + eqr.isEquivalenceRelation(r));
    }


    //交、并、补、逆、复合运算
    public void jbnfOperation() {
        lood:
        while (true) {
            System.out.println("\n请输入所需的运算：1.交集  2.并集  3.逆运算  4.复合运算  5.退出");
            String choose = sc.next();
            switch (choose) {
                case "1" -> {
                    System.out.println("已进入交集运算");
                    Relation r1 = new Relation(input(1));
                    Relation r2 = new Relation(input(2));
                    intersectionOutput(r1, r2);
                }
                case "2" -> {
                    System.out.println("已进入并集运算");
                    Relation r1 = new Relation(input(1));
                    Relation r2 = new Relation(input(2));
                    unionOutput(r1, r2);
                }
                case "3" -> {
                    System.out.println("已进入逆运算");
                    Relation r = new Relation(input(1));
                    inverseOutput(r);
                }
                case "4" -> {
                    System.out.println("已进入复合运算");
                    Relation r1 = new Relation(input(1));
                    Relation r2 = new Relation(input(2));
                    compoundOutput(r1, r2);
                }
                case "5" -> {
                    break lood;
                }
                default -> System.out.println("无此选项");
            }
        }
    }

    //复合运算
    public void compoundOutput(Relation r1, Relation r2) {
        //复合运算输出
        System.out.println("复合运算：\n第一个矩阵和第二个矩阵经复合运算后为：\n" + Relation.compound(r1, r2).toString());
    }

    //逆运算
    public void inverseOutput(Relation r) {
        //逆运算输出
        System.out.println("逆运算：\n" + Relation.inverse(r).toString());
    }

    //并集运算
    public void unionOutput(Relation r1, Relation r2) {
        //并集计算输出
        System.out.println("并集运算：\n第一个矩阵和第二个矩阵经并集计算后为：\n" + Relation.union(r1, r2).toString());
    }

    //交集运算
    public void intersectionOutput(Relation r1, Relation r2) {
        //交集计算输出
        System.out.println("交集运算：\n第一个矩阵和第二个矩阵经交集计算后为：\n" + Relation.intersection(r1, r2).toString());
    }

    //闭包运算
    public void closureOperation() {
        lood:
        while (true) {
            System.out.println("\n请输入所需计算的闭包：1.自反闭包  2.对称闭包  3.传递闭包  4.退出");
            String choose = sc.next();
            switch (choose) {
                case "1" -> {
                    System.out.println("已进入自反闭包");
                    Relation r = new Relation(input(1));
                    reflexiveClosureOutput(r);
                }
                case "2" -> {
                    System.out.println("已进入对称闭包");
                    Relation r = new Relation(input(1));
                    symmetricClosureOutput(r);
                }
                case "3" -> {
                    System.out.println("已进入传递闭包");
                    Relation r = new Relation(input(1));
                    transitiveClosureOutput(r);
                }
                case "4" -> {
                    break lood;
                }
                default -> System.out.println("无此选项");
            }
        }
    }

    //传递闭包
    public void transitiveClosureOutput(Relation r) {
        //传递闭包计算输出
        System.out.print("传递闭包：\n" + Relation.transitiveClosure(r).toString());
    }

    //对称闭包
    public void symmetricClosureOutput(Relation r) {
        //对称闭包计算输出
        System.out.print("对称闭包：\n" + Relation.symmetricClosure(r).toString());
    }

    //自反闭包
    public void reflexiveClosureOutput(Relation r) {
        //自反闭包计算输出
        System.out.print("自反闭包:\n" + Relation.reflexiveClosure(r).toString());
    }

    //性质判断
    public void natureJudge() {
        Relation r = new Relation(input(1));
        //自反性判断输出
        if (r.isReflexivity()) {
            System.out.println("该矩阵具有自反性");
        } else {
            System.out.println("该矩阵不具有自反性");
        }
        //反自反性判断输出
        if (r.isIrreflexivity()) {
            System.out.println("该矩阵具有反自反性");
        } else {
            System.out.println("该矩阵不具有反自反性");
        }
        //对称性判断输出
        if (r.isSymmetry()) {
            System.out.println("该矩阵具有对称性");
        } else {
            System.out.println("该矩阵不具有对称性");
        }
        //反对称性判断输出
        if (r.isAntisymmetry()) {
            System.out.println("该矩阵具有反对称性");
        } else {
            System.out.println("该矩阵不具有反对称性");
        }
        //传递性判断输出
        if (r.isTransitivity()) {
            System.out.println("该矩阵具有传递性");
        } else {
            System.out.println("该矩阵不具有传递性");
        }
    }

    //判断输入的元素是否符合规范,即输入的元素是否为0或1
    public static boolean judge(int[][] arr) {
        boolean flag = true;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i][j] != 1 && arr[i][j] != 0) {
                    flag = false;
                }
            }
        }
        return flag;
    }

    //矩阵的输入,num表示第几个矩阵
    public int[][] input(int num) {
        int n;
        while (true){
            System.out.println("请确定"+num+"个矩阵的阶数(正整数)：");
            n = sc.nextInt();
            if(n <= 0){
                System.out.println("输入的阶数不规范，请重新输入");
            }else{
                break;
            }
        }
        int[][] matrix = new int[n][n];
        int v;
        System.out.println("请输入第" + num + "个" + n + "×" + n + "的矩阵（0 | 1）：");
        while (true) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    v = sc.nextInt();
                    matrix[i][j] = v;
                }
                if ((n - (i + 1)) > 0) {
                    System.out.println("还剩下" + (n - (i + 1)) + "行可输入");
                }
            }
            if (!judge(matrix)) {
                System.out.println("您输入的矩阵不合规范，请重新输入矩阵（0 | 1）");
            } else {
                break;
            }
        }
        return matrix;
    }
}
