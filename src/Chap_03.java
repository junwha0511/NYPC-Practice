import java.util.Scanner;

enum Direction {
	UP, DOWN, LEFT, RIGHT;
}

public class Chap_03 {
	private Scanner s = new Scanner(System.in);

	private int width, height; 

	private String[][] map = new String[30][30];

	private Direction d;

	public static void main(String[] args) {
		Chap_03 ch = new Chap_03();
		ch.getMap();
	}

	private void getMap() {
		int x = 0, y = 0;
		//get mapSize
		width = s.nextInt(); 
		height = s.nextInt();
		s.nextLine(); 
		String input;
		for (int i = 0; i < height; i++) {
			input = s.nextLine();
			String[] buf = input.split(""); // split Texts to Arragement
			for (int j = 0; j < width; j++) {
				map[i][j] = buf[j];
				if (map[i][j].equals("O")) { //set start point
					x = j;
					y = i;
				}
			}

		}
		findWay(d.DOWN, y, x);
	}

	private int findWay(Direction dir, int row, int col) {
		if (dir.equals(d.DOWN)) {
			for (row += 1; row < height; row++) {
				if (map[row][col].equals("/")) {
					findWay(d.LEFT, row, col);
					return 0;
				} else if (map[row][col].equals("\\")) {
					findWay(d.RIGHT, row, col);
					return 0;
				}
			}
			System.out.println("D " + col);
		} else if (dir.equals(d.UP)) {
			for (row += 1; row > height; row--) {
				if (map[row][col].equals("/")) {
					findWay(d.RIGHT, row, col);
					return 0;
				} else if (map[row][col].equals("\\")) {
					findWay(d.LEFT, row, col);
					return 0;
				}
			}
			System.out.println("U " + col);
		} else if (dir.equals(d.RIGHT)) {
			for (col += 1; col < width; col++) {
				if (map[row][col].equals("/")) {
					findWay(d.UP, row, col);
					return 0;
				} else if (map[row][col].equals("\\")) {
					findWay(d.DOWN, row, col);
					return 0;
				}
			}
			System.out.println("R " + row);
		} else if (dir.equals(d.LEFT)) {
			for (col += 1; col < width; col++) {
				if (map[row][col].equals("/")) {
					findWay(d.DOWN, row, col);
					return 0;
				} else if (map[row][col].equals("\\")) {
					findWay(d.UP, row, col);
					return 0;
				}
			}
			System.out.println("L " + row);
		}
		return 0;
	}
}
