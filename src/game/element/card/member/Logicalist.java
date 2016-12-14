package game.element.card.member;

/**
 * Created by Squiggs on 12/14/2016.
 */
public abstract class Logicalist extends Member {


    @Override
    public Member getCovenanter(){
        return null; //Logicalists don't have covenanter
    }

    @Override
    public void setCovenanter(Member m) {
        //Do nothing since you can't set covenanter
    }
}
