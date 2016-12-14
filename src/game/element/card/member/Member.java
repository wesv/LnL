package game.element.card.member;

import game.element.card.MDCard;

import java.util.List;

/**
 * Created by Squiggs on 12/14/2016.
 */
public abstract class Member extends MDCard {
    protected boolean isStanding;
    protected String cardTitle;
    protected int level;
    protected int cost;
    protected int territory;
    protected int power;
    protected int limit;
    protected int aura;

    protected Member covenanter;
    protected List<String> attributes;


    public Member getCovenanter() {
        return covenanter;
    }

    public void setCovenanter(Member covenanter) {
        this.covenanter = covenanter;
    }


    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getTerritory() {
        return territory;
    }

    public void setTerritory(int territory) {
        this.territory = territory;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getAura() {
        return aura;
    }

    public void setAura(int aura) {
        this.aura = aura;
    }

    public List<String> getAttributes() {
        return attributes;
    }


    public int getState() {
        return isStanding?State.STANDING:State.RESTING;
    }

    public void setState(int state) {
        switch(state) {
            case State.STANDING:
                this.isStanding = true;
                break;
            case State.RESTING:
                this.isStanding = false;
                break;
        }
    }

    public String getFullCardName() {
        return cardTitle + ", " + super.cardName;
    }


    class State {
        public static final int STANDING = 1;
        public static final int RESTING = 2;
    }

}
