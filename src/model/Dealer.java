package model;
/**
 * subclass for an implement of dealer
 * @author xiaochen
 *
 */
public class Dealer extends Player {

	public Dealer(String aName) {
		
		super(aName);
	}
	
	//override isHitting
	public boolean isHitting(){
		if(this.getHandSum() < 17){
			System.out.println("The dealer hits\n");
			return true;
		} else {
			System.out.println("The dealer stands\n");
			return false;
		}
	}

}
