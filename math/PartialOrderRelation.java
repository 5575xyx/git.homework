package math;

public class PartialOrderRelation extends Relation {
    //判断是否为偏序关系
    public String isPartialOrderingRelation(Relation r) {
        boolean temp1 = r.isReflexivity();
        boolean temp2 = r.isAntisymmetry();
        boolean temp3 = r.isTransitivity();
        if (temp1 && temp2 && temp3) {
            return "该关系是偏序关系！";
        } else {
            return "该关系不是偏序关系！";
        }
    }

    //根据偏序关系得出偏序集


    //根据偏序集获取哈斯图求极值
}
