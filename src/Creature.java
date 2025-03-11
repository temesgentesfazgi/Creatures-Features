import java.util.concurrent.ThreadLocalRandom;

public class Creature {
    private String creatureType; //what is the nature of the creature, dragon, human, etc.
    private int hitPoints; //amount of damage a creature can withstand
    private int attackPoints; //how much damage creature could inflict
    private int gold; //material value of creature
    private boolean alive = true; //whether the creature is still alive or not

    public String getCreatureType() {
        return creatureType;
    }

    public void setCreatureType(String creatureType) {
        this.creatureType = creatureType;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public int getAttackPoints() {
        return attackPoints;
    }

    public void setAttackPoints(int attackPoints) {
        this.attackPoints = attackPoints;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public Creature(String creatureType, int hitPoints, int attackPoints, int gold) {
        this.creatureType = creatureType;
        this.hitPoints = hitPoints;
        this.attackPoints = attackPoints;
        this.gold = gold;
    }//end constructor

    public String getClassName() {
        String str = this.getClass().toString();
        int num = str.lastIndexOf(" ");
        str = str.substring(num + 1);
        return str;
    }

    public int attacks()
    {//will return a random number from zero to attackPoints
        int myReturn = ThreadLocalRandom.current().nextInt(0, this.attackPoints + 1);
        return myReturn;
    }//end attacks()

    public String defends(int damage) {// take the damage assessed to the current creature, and provide feedback
        String myReturn = "";

        if (this.assessDamage(damage)) {// still alive!
            myReturn += "The " + this.creatureType + " was attacked and took ";
            myReturn += damage + " damage and ";
            myReturn += "has " + this.hitPoints + " hit points left!\n";
        } else {// oh oh!
            myReturn += "The " + this.creatureType + " was attacked and took ";
            myReturn += damage + " damage and is dead!\n";
        }
        return myReturn;
    }// end defends()

    public boolean assessDamage(int ap)
    {
        //take the current hitPoints, and subtract the attackPoints
        this.hitPoints -= ap;
        //if HP goes below zero, creature is dead
        if (this.hitPoints < 1)
        {//game over!
            this.alive = false;
            this.hitPoints = 0;
            return false;
        }else {
            return true;
        }
    }//end assessDamage()



    public String toString() {
        String myReturn = this.getClassName();
        myReturn += " [creatureType=" + this.creatureType;
        myReturn += ", hitPoints=" + this.hitPoints;
        myReturn += ", attackPoints=" + this.attackPoints;
        myReturn += ", gold=" + this.gold;
        myReturn += ", alive=" + this.alive + "]";
        return myReturn;
    }

}//end Creature
