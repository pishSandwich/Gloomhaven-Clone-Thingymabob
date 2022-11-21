package gloomhaven.clone.cs401;

import Deck.Deck;

public class Player {
	private String name;
	private String job;
	private Deck deck;
	
	private int level;
	private int exp;
	private int levelUpPoint;

	private int maxHP;
	private int currentHP;
	private boolean alive;
	
	private int gold;
	
	Player(String newName, int newJob){
		name = newName;
		alive = true;
		level = 1;
		exp = 0;
		levelUpPoint = 45;
		gold = 0;
		
		//Hard coded jobs.
		if(newJob == 1) {//Scoundrel, hand = 9
			job = "Scoundrel";
			maxHP = 8;
			currentHP = maxHP;
		}
		else if(newJob == 2) {//Brute, hand = 10
			job = "Brute";
			maxHP = 10;
			currentHP = maxHP;
		}
		else if(newJob == 3) {//Spellweaver, hand = 8 + reviving ether
			job = "Spellweaver";
			maxHP = 6;
			currentHP = maxHP;
		}
		else if(newJob == 4) {//Tinkerer, hand = 12
			job = "Tinkerer";
			maxHP = 8;
			currentHP = maxHP;
		}
	}
	
	void AddExp(int x){//MUST be in town to level-up.
		exp += x;
		while(exp >= levelUpPoint) {//Add new perks.
			levelUpPoint += 45 + (5 * level);
			level++;
			
			//Hard coded jobs.
			if(job == "Scoundrel") {
				maxHP = (int) Math.floor(6.5+(1.5*level));
				currentHP = maxHP;//Restore health on level-up?
			}
			else if(job == "Brute") {
				maxHP = 8+(2*level);
				currentHP = maxHP;
			}
			else if(job == "Spellweaver") {
				maxHP = 5+(1*level);
				currentHP = maxHP;
			}
			else if(job == "Tinkerer") {
				maxHP = (int) Math.floor(6.5+(1.5*level));
				currentHP = maxHP;
			}
		}
	}
	
	void takeDmg(int x) {
		currentHP -= x;
		if(currentHP <= 0) {
			alive = false;
		}
	}
	
	void healDmg(int x) {
		currentHP += x;
		if(currentHP > maxHP)
			currentHP = maxHP;
	}
	
	void fullHeal() {
		currentHP = maxHP;
	}
	
	void shortRest() {
		//deck.shuffle();
		//deck.lose();
	}
	
	void longRest() {
		//deck.shuffle();
		//deck.lose();
		//deck.refreshItems();
		healDmg(2);
	}
	
	public void printPlayer() {
		System.out.println(this.name + "(Lvl:" + level + " - " + job + "): " + "HP(" + currentHP + "/" + maxHP + ")");
	}

	public String getName() {
		return name;
	}

	public String getJob() {
		return job;
	}

	public int getLevel() {
		return level;
	}

	public int getExp() {
		return exp;
	}

	public int getmaxHP() {
		return maxHP;
	}

	public int getcurrentHP() {
		return currentHP;
	}
	
	public boolean isAlive() {//At the beginning of every round check if alive.
		return alive;
	}

	public int getGold() {
		return gold;
	}
}
