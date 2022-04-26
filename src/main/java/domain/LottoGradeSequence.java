package domain;

import java.util.LinkedList;


public class LottoGradeSequence extends LinkedList<LottoGrade> implements Cloneable {
    @Override
    public LottoGradeSequence clone() {
        return (LottoGradeSequence) super.clone();
    }
}