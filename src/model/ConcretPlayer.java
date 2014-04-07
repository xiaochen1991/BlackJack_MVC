package model;
import java.util.Scanner;
/**
 * subclass for an implement of real player
 * @author xiaochen
 *
 */

public class ConcretPlayer extends Player{
	
	private int chip = 100;

	public ConcretPlayer(String aName) {
		super(aName);
	}
	
	//override isHitting
	public boolean isHitting(){
		
		//inti
		Scanner sc = new Scanner(System.in);
		String ans;
		
		System.out.print("Hit or Stand?(Enter H or S): ");
		ans = sc.next();
		System.out.println(); 
		
		//close scanner
		sc.close();
		
		return(ans.compareToIgnoreCase("H") == 0);
	}
	
	/**
	 * return the chip left
	 */
	public int getChip(){
		
		return this.chip;
	}
	
	/**
	 * win chips
	 */
	public void WinChip(int wager){
		
		this.chip += wager;
	}
	
	/**
	 * lose chips
	 */
	public void LoseChip(int wager){
		
		this.chip -= wager;
	}

}
