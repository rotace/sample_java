package sample;

public class Sample101 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Sample101 sample = new Sample101();
		System.out.println("FakeDice");
		sample.rolls(new FakeDice());
		System.out.println("RealDice");
		sample.rolls(new RealDice());
	}
	
	public void rolls(DiceIF dice){
		for (int i=0; i<6; i++){
			System.out.println(dice.roll());
		}
	}

}
