import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MesoInherit extends MesoAbstract
{
	private String stID; //creating a class variable for the passed in stID
	private String[] stationData = new String[10]; //array that stores all station ID's
	private int numStations = 0; //counter for the stationData array starting at zero
	
	/*
	 * This constructor takes in an ID input as a parameter and uses a reader to extract the data from 
	 * Mesonet.txt
	 */
	public MesoInherit(String stID) throws IOException {
		this.stID = stID; //updating class variable with parameter ID
		
		//creating the BufferedReader to read in the file
		BufferedReader br = new BufferedReader(new FileReader("Mesonet.txt"));
		for (int i = 0; i < 3; ++i) {
			br.readLine();	//reading through first 3 lines of the file that don't contain data
		}
		String dataLine = br.readLine(); //first line that actually contains data stored in String
		while (br.ready()) { //while file still has data to be read
			if (numStations == stationData.length) {
				expandArray(); //expanding the array if capacity is full
			}
			/*
			 *splitting the dataLine String by white spaces and storing the second element into info because
			 *the first index is a white space
			*/
			String info = dataLine.split("\\s+")[1];
			stationData[numStations++] = info; //storing all the stID's into the stationData array
			dataLine = br.readLine(); //reading the next line for the next iteration of the loop
		} br.close(); //closing the reading when finished
	}
	
	/*
	 * This method simply expands the stationData array length when the capacity becomes full
	 */
	public void expandArray() {
		int newSize = stationData.length * 2;
		String[] newArray = new String[newSize];
		for (int i = 0; i < stationData.length; ++i) {
			newArray[i] = stationData[i];	//copying over the old array contents to new array
		} this.stationData = newArray;	//updating class reference
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

