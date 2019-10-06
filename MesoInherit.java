
public class MesoInherit extends MesoAbstract
{
	private int[] ascii = new int[26]; //array that contains the ASCII values of letters
	
	/*
	 * This constructor takes in a MesoStation object as a parameter and also fills in the 
	 * ASCII values in the ascii array
	 */
	public MesoInherit(MesoStation stID){
		int startingVal = 65;
		for (int i = 0; i < ascii.length; ++i) { //using a for loop to fill in the ASCII values
			ascii[i] = startingVal++;
		}
	}
	
	/*
	 * This method calculates the ASCII Ceiling, ASCII Floor, and the ASCII Average
	 */
	public int[] calAverage() {
		return null;
	}
	
	/*
	 * This method finds the letter average using ASCII values
	 */
	public char letterAverage() {
		return 'x';
	}
	
}

