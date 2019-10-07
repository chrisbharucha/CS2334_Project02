
public class MesoInherit extends MesoAbstract
{
	private int[] ascii = new int[26]; //array that contains the ASCII values of letters
	private char[] letters; //array that contains all of the letters
	private String stID; //the station ID that all the calculations will be done on
	
	/*
	 * This constructor takes in a MesoStation object as a parameter and also fills in the 
	 * ASCII values in the ascii array
	 */
	public MesoInherit(MesoStation stID){
		this.stID = stID.getStID(); //updating the reference of stID to the one in the parameter
		int startingVal = 65;
		for (int i = 0; i < ascii.length; ++i) { //using a for loop to fill in the ASCII values
			ascii[i] = startingVal++;
		}
		letters = new char[]{'A','B','C','D','E','F','G','H','I','J','K','L','M', //filling the letters array
							 'N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
	}
	
	/*
	 * This method calculates the ASCII Ceiling, ASCII Floor, and the ASCII Average
	 */
	public int[] calAverage() {
		int[] result = new int[3]; //array that holds the results of the method
		//getting all of the chars from stID
		char c1 = stID.charAt(0);
		char c2 = stID.charAt(1);
		char c3 = stID.charAt(2);
		char c4 = stID.charAt(3); //explosive
		double ascii1 = 0.0, ascii2 = 0.0, ascii3 = 0.0, ascii4 = 0.0; //variable to store all ASCII values in
		
		for(int i = 0; i < ascii.length; ++i) {	//this for loop finds all of the ASCII values for each char
			int asciiVal = ascii[i];
			char cTest = letters[i];
			if (c1 == cTest) {		//finds c1's ASCII if true
				ascii1 = asciiVal;
			}
			if (c2 == cTest) {	//finds c2's ASCII if true
				ascii2 = asciiVal;
			}
			if (c3 == cTest) {	//finds c3's ASCII if true
				ascii3 = asciiVal;
			}
			if (c4 == cTest) {	//finds c4's ASCII if true
				ascii4 = asciiVal;
			}
		}
		//finding the average after getting the ASCII values
		double average = (ascii1 + ascii2 + ascii3 + ascii4) / 4.0; //using 4.0 so that the ASCII values get casted to a double
		result[0] = (int)Math.ceil(average); //ASCII Ceiling
		result[1] = (int)Math.floor(average); //ASCII Floor
		/*
		 * testing whether the decimal is less than or greater than 0.5 in order to apply the correct function
		 */
		if ((average - (int)average) >= 0.5) {	
			result[2] = (int)Math.ceil(average);
		}
		else {
			result[2] = (int)Math.floor(average);
		}
		return result;
	}
	
	/*
	 * This method finds the letter average using ASCII values
	 */
	public char letterAverage() {
		int average = calAverage()[2]; //gets the average ASCII value: either floor or ceiling}
		int index = 0;
		for (int i = 0; i < ascii.length; ++i) { //finds the array index where the ASCII value is located
			if (average == ascii[i]) {
				index = i;
			}
		}
		char result = letters[index]; //using the array index to find the corresponding letter
		return result;
	}
	
}

