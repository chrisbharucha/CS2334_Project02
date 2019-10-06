import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PosAvg{
	private String stID; //creating a class variable for the passed in stID
	private String[] stationData = new String[10]; //array that stores all station ID's
	private int numStations = 0; //counter for the stationData array starting at zero
	
	/*
	 * This constructor takes in an ID input as a parameter and uses a reader to extract the data from 
	 * Mesonet.txt
	 */
	public PosAvg(String stID) throws IOException{
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
	 * This method finds the index number of the line that a given stationID is on and returns it
	 */
	public int indexOfStation() {
		int index = 1; //the file reader begins indexing at 1
		for (int i = 0; i < numStations - 1; i++) {
			String test = stationData[i];
			if (stID.equalsIgnoreCase(test)) {
				return index;
			}
			++index;
		} return index;
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
	 * This method is used to calculate the index average value of two station's indexes in stationData
	 * that equals the indexofStation() value
	 */
	public String[] indexAverage() {
		String[] average = new String[4]; //returning 2 sets of stations which have an average equal to index
		int index = indexOfStation(); //getting the index value of the stID in question
		
		String temp = stationData[index-1]; //first set of stations that share average
		average[0] = temp;
		temp = stationData[index+1];
		average[1] = temp;
		
		temp = stationData[index-2]; //second set of stations that share average
		average[2] = temp;
		temp = stationData[index+2];
		average[3] = temp;
		
		return average;
	}
	
	/*
	 * This method overrides the toString method to print out some more data about the averages
	 */
	public String toString() {
		return String.format("This index is the average of %s and %s, %s and %s, and so on.",indexAverage()[0],
							indexAverage()[1],indexAverage()[2],indexAverage()[3]);
	}
	
}
