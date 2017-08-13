import java.util.Scanner;

enum Direction {
	UP, DOWN, LEFT, RIGHT;
}

public class Chap_03 {
	private Scanner s = new Scanner(System.in);

	private int width, height; 

	private String[][] map = new String[30][30];
<<<<<<< HEAD
	
=======

	private Direction d;

>>>>>>> 5d7c32858e44f10735bbdb425fbd921db98978ff
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
<<<<<<< HEAD
		Direction d = Direction.DOWN;
		while(!findWay(d, y, x)) {
			switch(d) {
			case DOWN:
				d = Direction.LEFT;
				break;
			case LEFT:
				d = Direction.UP;
				break;
			case UP: 
				d = Direction.RIGHT;
				break;
			default:
				System.out.println("there is no way to light");
				break;
			}
		}
	}

	private boolean findWay(Direction dir, int row, int col) {
		if (dir.equals(Direction.DOWN)) {
			for (row += 1; row < height; row++) {
				if (map[row][col].equals("/")) {
					if(findWay(Direction.LEFT, row, col)) {
						return true;
					}
					return false;
				} else if (map[row][col].equals("\\")) {
					if(findWay(Direction.RIGHT, row, col)) {
						return true;
					}
					return false;
				}
			}
			System.out.println("D " + col);
			return true;
		} else if (dir.equals(Direction.UP)) {
			for (row += 1; row > height; row--) {
				if (map[row][col].equals("/")) {
					if(findWay(Direction.RIGHT, row, col)) {
						return true;
					}
					return false;
				} else if (map[row][col].equals("\\")) {
					if(findWay(Direction.LEFT, row, col)) {
						return true;
					}
					return false;
				}
			}
			System.out.println("U " + col);
			return true;
		} else if (dir.equals(Direction.RIGHT)) {
			for (col += 1; col < width; col++) {
				if (map[row][col].equals("/")) {
					if(findWay(Direction.UP, row, col)) {
						return true;
					}
					return false;
				} else if (map[row][col].equals("\\")) {
					if(findWay(Direction.DOWN, row, col)) {
						return true;
					}
					return false;
				}
			}
			System.out.println("R " + row);
			return true;
		} else if (dir.equals(Direction.LEFT)) {
			for (col += 1; col < width; col++) {
				if (map[row][col].equals("/")) {
					if(findWay(Direction.DOWN, row, col)) {
						return true;
					}
					return false;
				} else if (map[row][col].equals("\\")) {
					findWay(Direction.UP, row, col);
					return false;
				}
			}
			System.out.println("L " + row);
			return true;
		}
		return false;
=======
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
>>>>>>> 5d7c32858e44f10735bbdb425fbd921db98978ff
		}
}
