import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class LetterAvg 
{
	private String[] stationData = new String[10]; //array that stores all station ID's
	private int numStations = 0; //counter for the stationData array starting at zero
	private String[] same = new String[1]; //this array stores the stations that start with the letter average char
	private int numStationsSame = 0; //counter for the numStationsSame array starting at zero
	private char c; //the char used for the averages
	private String stationSame; //this String contains all stations that share the same first char 
	
	/*
	 * This constructor takes in a char from the MesoInherit letterAverage method for calculations
	 */
	public LetterAvg(char c) throws IOException
	{
			this.c = c; //updating the reference char c to the parameter value
			//creating the BufferedReader to read in the file
			BufferedReader br = new BufferedReader(new FileReader("Mesonet.txt"));
			for (int i = 0; i < 3; ++i) {
				br.readLine();	//reading through first 3 lines of the file that don't contain data
			}
			String dataLine = br.readLine(); //first line that actually contains data stored in String
			while (br.ready()) { //while file still has data to be read
				if (numStations == stationData.length) {
					expandArrayStation(); //expanding the array if capacity is full
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
	public void expandArrayStation() {
		int newSize = stationData.length * 2;
		String[] newArray = new String[newSize];
		for (int i = 0; i < stationData.length; ++i) {
			newArray[i] = stationData[i];	//copying over the old array contents to new array
		} this.stationData = newArray;	//updating class reference
	}
	
	/*
	 * This method simply expands the same array length when the capacity becomes full
	 */
	public void expandArraySame() {
		int newSize = same.length + 1;
		String[] newArray = new String[newSize];
		for (int i = 0; i < same.length; ++i) {
			newArray[i] = same[i];	//copying over the old array contents to new array
		} this.same = newArray;	//updating class reference
	}
	
	/*
	 * This method finds the number of stations in the text file that start with the same first letter as the letter average
	 */
	public int numberOfStationWithLetterAvg() {
		int result = 0;
		int i = 0;
		while (stationData[i] != null) { //only execute test when the index of the array has a station
			String station = stationData[i++];
			if (station.charAt(0) == c) {	//this for loop checks the first char of each station to compare
				++result;
				if (numStationsSame == same.length) { //calling the expand array method if same array is full
					expandArraySame();
				}
				same[numStationsSame++] = station; //adding that station to the array to print out in toString
			}
		} 
		/*
		 * This takes the same array and puts the contents into a String that is formatted correctly to 
		 * be used in the toString method
		 */
		stationSame = same[0];
		for (i = 1; i < same.length; ++i) {
			stationSame = stationSame + "\n" + same[i];
		}return result; 
	}

	/*
	 * This method returns the stations that start with the same first letter as the letter average
	 */
	public String toString() {
		return String.format("They are:\n%s",stationSame);
	}
}
