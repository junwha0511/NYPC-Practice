import java.util.Scanner;

public class Chap_01 {
	private String[][] screen = new String[20][20]; //inputs will be converted to screen
	private int size = 0, dCount = 0, cCount = 0; 
	private Scanner s = new Scanner(System.in); 

	public static void main(String[] args) {
		Chap_01 ch = new Chap_01(); 
		ch.InputAndCount(); //get input and count there is how many daramG and players.
		ch.PlaceDaramG(); //place daramG to be twice than players.
		ch.PrintScreen(); //output result.
	}			

	private void InputAndCount() {
		size = s.nextInt(); //get mapsize
		s.nextLine(); //to prevent error from Enter
		String input;
		for (int i = 0; i < size; i++) {
			input = s.nextLine();
			String[] buf = input.split(""); //split Lines to Arragement
			for (int j = 0; j < size; j++) {
				screen[i][j] = buf[j];
				switch (screen[i][j]) { //Count daramG and player
				case "D":
					dCount++;
					break;
				case "C":
					cCount++;
					break;
				}
			}
		}
	}

	private void PlaceDaramG() {
		int howPlace = cCount * 2 - dCount; //save daramG count that we need  
		if (dCount < cCount * 2) {
			for (int i = 0; i < size; i++) {
				if (howPlace != 0) { 
					for (int j = 0; j < size; j++) {
						if (howPlace == 0) {
							break;
						}
						switch (screen[i][j]) {
						case "D":
							break;
						case "C":
							break;
						case ".":
							screen[i][j] = "D";
							howPlace--;
							break;
						}
					}
				} else {
					break;
				}
			}
		}

	}

	private void PrintScreen() {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				System.out.print(screen[i][j]);
			}
			System.out.println();
		}
	}
}
