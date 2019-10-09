# Project02_CS2334


* The problem:

The problem presented by Project02 requires a way to return the index of a given station from the same Mesonet.txt file from Project01. Additionally, two sets of stations that exhibit an average index that is the same as the index of the original station will be returned. Calculations will be done on the given station using the ASCII values. These calculations include Ceiling, Floor, and Average. After calculating the ASCII Average, the letter that corresponds to that average needs to be returned. Finally, the number of stations that begin with that letter average and the stations themselves will need to be returned.

- Problem-solving approach:

From the provided Driver.java, MesoStation.java and Mesonet.txt files, it is clear that we will need to use multiple classes in order to perform all of the calculations. The MesoAbstract.java class is responsible for providing the 'blueprint' of methods that any extended class must implement. In this case, the MesoInherit.java is extending MesoAbstract.java. The classes PosAvg.java and LetterAvg.java will be doing calculations that require the use of the text file. Therefore, both of those classes will have a BufferedReader to read in data. The output can therefore be broken down line-by-line between the different classes where:

Lines 1-2: PosAvg.java
Lines 3-6: MesoInherit.java
Lines 7-rest: MesoInherit.java and LetterAvg.java



* LetterAvg.java:

- Local class variables:

String[] stationData: this array holds all the station ID's after reading via a BufferedReader, initially set to size 10
String[] same: this array holds all the station ID's that begin with the letter average char

char c: the letter average char that is found in the MesoInherit class via the letterAverage() method

String output: this String is used to set up the correctly formatted toString output to be used in the toString method

This class takes in the letter average that is calculated by MesoInherit.java as its constructor value. The constructor in the updates the char c to the calculated char, and reads in info from Mesonet.txt to extract the stationID's. The stationID's are stored in the stationData[] array to be used for calculations in other methods. The numberofStationWithLetterAvg() method finds the number of stations in the stationData[] array that begin with char c using for loops and if statements. A counter is used to keep track of the number of stations that do begin with char c and that value is returned. The stringForToString() method does a similar test as numberOfStationWithLetterAvg(); however, this time instead of incrementing a counter, the stationID's themselves are stored into the same[] array. Then, the String output is updated to contain Lines 7-rest of the output. The toString method sets the String output to a value by calling the stringForToString() method. It then returns the String which will not only contain the correct value, but also the required formatting. Other class methods include two expand array methods which simply expand either the same[] or stationData[] array if they are full.



* MesoAbstract.java:

This class is responsible for setting up the methods that any MesoStation object must implement. Since every MesoInherit object is constructed using a MesoStation object, the MesoAbstract class is responsible for setting up the framework specifically for the MesoInherit class. The two methods defined: calAverage() and letterAverage() will be implemented and explained in the MesoInherit class.



* MesoInherit.java

- Local class variables:

int[] ascii: this array holds the ascii values for letters 'A' - 'Z' starting at A's value and ending at Z's
char[] letters: this array holds the letters 'A' - 'Z'

String stID: this String is the given stationID used for calculations

The constructor for this class takes in a MesoStation object as a parameter to use for the class's testing. The stID String is updated by calling MesoStation's getStID() method, since the parameter isn't a String directly. Additionally, the constructor fills the ascii[] and letters[] array with the correct values. The calAverage method breaks the String stID down into each of its chars, and finds the corresponding value of that char stepping through both the ascii[] and letters[] array in the same for loop, since the index of one array directly corresponds to the other. (I.e. if the letter was 'C' in the letters array, finding that index and using it for the ascii[index] array would return the corresponding ASCII value since both have the same length.) After testing each char to see if it matches the letter[i] char, all 4 char's will be given their correct ASCII value. The average is then calculated by taking the four ASCII value's and dividing by 4. The returned array that was initialized at the beginning is filled via the following way: 

result[0]: Math.ceil
result[1]: Math.floor
result[2]: average: either floor or ceil, depending on whether or not the decimal following the whole number is greater than or 						equal to 0.5 

The letterAverage() method takes the result[2] from calAverage() and uses it to step through the ascii[] array to find which index corresponds to that number. Then, using the index in the letters[index] array pulls the correct Letter Avg char and returns it. This char is the one used in the LetterAvg.java class.



* MesoStation.java

- Local class variables:

String stID: the given stationID String

This class is used to construct a MesoStation object by passing in a stationID String into the constructor. It has a getStID() method that MesoInherit.java accesses to get and store the String value.



* PosAvg.java

- Local class variables:

String stID: the given stationID String used for calculations

String stationData[]: this array holds all the station ID's after reading via a BufferedReader, initially set to size 10

This class's constructor takes in a stationID and updates the reference stID. This class also uses the BufferedReader in the same way that the LetterAvg.java class does. The stationID's are stored in stationData[] array for calculations in other methods. The indexOfStation() method begins with a counter set to 1, since the index of a file begins at 1 instead of 0 like arrays. The String stID is compared to each stationID in stationData until they are the same, in which the correct index value is returned. The expandArray() simply expands stationData[] when needed. The indexAverage() method returns an array of Strings that contain the two sets of stationID's that share an average index value equal to indexOfStation()'s returned index value. They are found by taking the stationData[] array and finding the station before the indexed station by subtracting 2 (the array's index start at 0 so instead of subtracting 1 and adding 1, we have to subtract 2 and add 0). The other two sets of stations can be found by simply subtracting 2 values to index and adding 2 more values to index. The toString then uses String.format and calls the indexAverage() method at specific indexes in the array. (I.e. indexAverage()[0],indexAverage()[1]...)







