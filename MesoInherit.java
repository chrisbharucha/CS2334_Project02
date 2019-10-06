import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MesoInherit extends MesoAbstract
{
	private String stID; //creating a class variable for the passed in stID
	private String[] stationData = new String[10];
	
	/*
	 * This constructor takes in an ID input as a parameter and uses a reader to extract the data from 
	 * Mesonet.txt
	 */
	public MesoInherit(String stID) throws IOException {
		this.stID = stID; //updating class variable with parameter ID
		
		//creating the bufferedreader to read in the file
		BufferedReader br = new BufferedReader(new FileReader("Mesonet.txt"));
		for (int i = 0; i < 3; ++i) {
			br.readLine();	//reading through first 3 lines of the file that dont contain data
		}
		String dataline = br.readLine(); //first line that actually contains data
		while (br.ready()) {
			
		}
		
		
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
}
