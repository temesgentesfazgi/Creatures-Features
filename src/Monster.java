public class Monster extends Creature {
    private String mode; // behavior of the monster, e.g., "fierce", "timid", "chaotic"

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public Monster(String creatureType, int hitPoints, int attackPoints, int gold, String mode) {
        super(creatureType, hitPoints, attackPoints, gold); // Calls the Creature constructor
        this.mode = mode;
    }

    // Override toString() method to include mode for the Monster class
    public String toString() {
        String myReturn = this.getClassName();
        myReturn += " [creatureType=" + this.getCreatureType();
        myReturn += ", hitPoints=" + this.getHitPoints();
        myReturn += ", attackPoints=" + this.getAttackPoints();
        myReturn += ", gold=" + this.getGold();
        myReturn += ", alive=" + this.isAlive();
        myReturn += ", mode=" + this.mode + "]";  // Add the mode to the string
        return myReturn;
    }
}
