import java.util.Scanner;

enum Direction{
		UP,DOWN,LEFT,RIGHT;
}

public class Chap_03 {
	private Scanner s = new Scanner(System.in);
	
	private	int width, height;
	
	private String[][] map = new String[30][30];
	
	private Direction d;
	
	public static void main(String[] args) {
		Chap_03 ch = new Chap_03();
		ch.getMap();
		ch.findLaserPosition();
	}
	private void getMap() {
		width = s.nextInt();
		height = s.nextInt();
		s.nextLine();
		String input;
		for (int i = 0; i < height; i++) {
			input = s.nextLine();
			String[] buf = input.split(""); //split Texts to Arragement
			for (int j = 0; j < width; j++) {
				map[i][j] = buf[j];
			}
		}
		/*for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}*/
	}
	private void findLaserPosition() {
		boolean flag = true;
		//Top and Bottom
		if(flag) {
					for(int col=0; col<width; col++) {
						//Top line
						if(Laser(d.DOWN,col,0)) {
							System.out.println("U "+(col+1));
							flag=false;
							break;
						}
						if(Laser(d.UP,col,height-1)) {
							System.out.println("D "+(col+1));
							flag=false;
							break;
						}
					}
				}
		if(flag) {
			for(int row=0; row<height; row++) {
				//Left line
				if(Laser(d.RIGHT,0,row)) {
					System.out.println("L "+(row+1));
					flag=false;
					break;
				}
				if(Laser(d.LEFT,width-1,row)) {
					System.out.println("R "+(row+1));
					flag=false;
					break;
				}
			}
		}
	}
	//array[y][x]
	private boolean Laser(Direction dir,int x, int y) {
		
		if(dir.equals(d.DOWN)) {//From top
			for(int row = y; row < height; row++) {
					if(map[row][x].equals("/")) {
						if(Laser(d.LEFT,x,row)){
							return true;
						}else {
							return false;
						}
					}else if(map[row][x].equals("\\")) {
						if(Laser(d.RIGHT,x,row)) {
							return true;
						}else {
							return false;
						}
					}else if(map[row][x].equals("O")) {	
						return true;
					}
			}
			return false;
		}else if(dir.equals(d.UP)) {//From bottom
			for(int row = y; row>0; row--) {
					if(map[row][x].equals("/")) {
						if(Laser(d.RIGHT,x,row)) {
							return true;
						}else {
							return false;
						}
					}else if(map[row][x].equals("\\")) {
						if(Laser(d.LEFT,x,row)) {
							return true;
						}else {
							return false;
						}
					}else if(map[row][x].equals("O")) {
						return true;
					}
			}
			return false;
		}else if(dir.equals(d.RIGHT)) {//From LEFT
			for(int col = x; col < width; col++) {
				if(map[y][col].equals("/")) {
					if(Laser(d.UP,col,y)) {
						return true;
					}else {
						return false;
					}
				}else if(map[y][col].equals("\\")) {
					if(Laser(d.DOWN,col,y)) {
						return true;
					}else {
						return false;
					}
				}else if(map[y][col].equals("O")) {
					return true;
				}
			}
			return false;
		}else if(dir.equals(d.LEFT)) {//From RIGHT
			for(int col = x; col > 0; col--) {
				if(map[y][col].equals("/")) {
					if(Laser(d.DOWN,col,y)) {
						return true;
					}else {
						return false;
					}
				}else if(map[y][col].equals("\\")) {
					if(Laser(d.UP,col,y)) {
						return true;
					}else {
						return false;
					}
				}else if(map[y][col].equals("O")) {
					return true;
				}
			}
			return false;
		}
		return false;
	}
}
