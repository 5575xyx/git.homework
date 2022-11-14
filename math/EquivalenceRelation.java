package math;

public class EquivalenceRelation extends Relation {

    //判断是否为等价关系
    public String isEquivalenceRelation(Relation r) {
        boolean temp1 = r.isReflexivity();
        boolean temp2 = r.isSymmetry();
        boolean temp3 = r.isTransitivity();
        if (temp1 && temp2 && temp3) {
            return "该关系是等价关系！";
        } else {
            return "该关系不是等价关系！";
        }
    }

    //求商集

    //根据等价关系求划分
}
