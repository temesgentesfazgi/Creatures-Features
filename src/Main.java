//Temesgen Tesfamichael
import java.io.*;
import java.lang.Thread;

public class Main {
    public static void main(String[] args) throws InterruptedException{
        Hero myHero = new Hero("Hero",23,5,0,"Conan","Barbarian");
        Monster myMonster = new Monster("Dragon",12,10,200,"fierce");
        boolean gameOn = true;//will become false once one creature is dead

        while(gameOn){//the fight continues
            if(!myHero.isAlive() || !myMonster.isAlive()){//spmeone is dead, game over
                if(myHero.isAlive()) {//time for gold!
                    myHero.setGold(myHero.getGold() + myMonster.getGold());
                    String output = "Our Hero " + myHero.getName() + " got " + myMonster.getGold() + " gold and now has a total of " + myHero.getGold() + " gold.";
                    System.out.println(output);
                }

                gameOn = false;
                break;
            }else{
                System.out.println(myHero.defends(myMonster.attacks()));
                System.out.println(myMonster.defends(myHero.attacks()));
                Thread.sleep(1000);
            }
        }

    }
}
