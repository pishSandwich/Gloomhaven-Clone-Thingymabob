/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gloomhaven.clone.cs401;

/**
 *
 * @author PishSama
 */
public class GloomhavenCloneCS401 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    	Player test = new Player("Jimmy", 1);
    	
    	test.printPlayer();
    	test.getDeck().showAbilityDeck();
    	test.getDeck().pickHand();
    	
    	AbilityCard card;
    	card = test.getDeck().getHand(0);
    	
    	card = test.getDeck().getHand(6);
    	
    	
    	test.getDeck().showHand();
    	test.getDeck().showDiscards();
    }
    
}
