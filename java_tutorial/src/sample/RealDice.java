package sample;

public class RealDice implements DiceIF {

	java.util.Random r = new java.util.Random();
	
	@Override
	public int roll() {
		return r.nextInt(6)+1;
	}

}
