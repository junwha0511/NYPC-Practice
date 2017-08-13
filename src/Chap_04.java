import java.util.Scanner;

public class Chap_04 {
	private Scanner s = new Scanner(System.in);
	private int size = 0;
	private String[][] screen = new String[100][100];
	private String[][] temp = new String[100][100];

	public static void main(String[] args) {
		Chap_04 ch = new Chap_04();
		ch.spinAndSlide(ch.getScreen());
		ch.PrintScreen();
	}

	private int getScreen() {
		size = s.nextInt(); // get mapsize
		s.nextLine(); // to prevent error from Enter
		int turn = s.nextInt(); 
		s.nextLine();
		String input;
		for (int i = 0; i < size; i++) {
			input = s.nextLine();
			String[] buf = input.split(""); // split Lines to Arragement
			for (int j = 0; j < size; j++) {
				screen[i][j] = buf[j];
			}
		}
		return turn;
	}
	private void spinAndSlide(int turn) {
		for(int t=0; t<turn; t++) {
			rotateScreen();
			for(int col=0; col<size; col++) {
				slideBlock(col);
			}	
		}
	}
	private void rotateScreen() {
		for (int row = 0; row < size; row++) {
			for (int col = 0; col < size; col++) {//rotate counter-clockwise 
				temp[col][size - 1 -row] = screen[row][col]; 
			} 
		}
		for (int row = 0; row < size; row++) {
			for (int col = 0; col < size; col++) {
				screen[row][col] = temp[row][col]; 
			}
		}
	}

	private void slideBlock(int col) {
			for (int row = size-1; row >= 0; row--) {
				if(isAllSpace(row,col)){
					break;
				}else if(screen[row][col].equals(".")) {
					for(int i=row;i > 0;i--) {
						screen[i][col] = screen[i-1][col];
					}
					screen[0][col] = ".";
					slideBlock(col);
					break;
				}
			}
	}
	private boolean isAllSpace(int row, int col) {
		for(int i=0;i <= row;i++) {
			if(!screen[i][col].equals(".")) {
				return false;
			}
		}
		return true;
		
	}
	private void PrintScreen() {
		for (int row = 0; row < size; row++) {
			for (int col = 0; col < size; col++) {
				System.out.print(screen[row][col]);
			}
			System.out.println();
		}
	}
}
