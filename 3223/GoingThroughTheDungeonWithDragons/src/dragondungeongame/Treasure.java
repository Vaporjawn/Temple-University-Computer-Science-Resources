/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dragondungeongame;

/**
 *
 * @author Jessica
 */
public class Treasure {
    
    String type;
    
    public Treasure(String dType){
        type = dType;
    }
    
    
    public void PowerUp(Player player, Dragon dragon){
        
        type.toLowerCase();
        
        if(type == "sleep"){
            System.out.println("Congrats! You got some sleep. Your health has been improved.");
            player.health = player.health + 10;
        }
        
        if(type == "food"){
            System.out.println("Congrats! You got some food! Your health has been improved.");
            player.health = player.health +15;
        }
        
        if(type == "treasure"){
            System.out.println("Congrats! You found some treasure! Your attack has been increased.");
            player.attackPower = player.attackPower + 10;
        }
        
        int defenseUp = dragon.Difficulty * 5;
        player.defense = player.defense + defenseUp;
        
    }
}
