package math;

public class CompatibleRelation extends Relation {
    //判断是否为相容关系
    public String isConsistentRelation(Relation r) {
        boolean temp1 = r.isReflexivity();
        boolean temp2 = r.isSymmetry();
        if (temp1 && temp2) {
            return "该关系是相容关系！";
        } else {
            return "该关系不是相容关系！";
        }
    }
}
