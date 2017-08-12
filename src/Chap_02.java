import java.util.Scanner;
public class Chap_02 {
	private int num; //Deck count
	private Scanner s = new Scanner(System.in);
	private String[] deck = new String[12];
	private int[] resourceCount = {0,0,0,0,0}; //each attribute count
	public static void main(String[] args) {
		Chap_02 ch = new Chap_02();
		ch.getDeck();
		ch.isCorrect();
	}
	private void getDeck() {
		num = s.nextInt();
		s.nextLine();
		for(int i=0; i<num; i++) {
			deck[i] = s.nextLine();
			switch(deck[i]) {
			case "gold":
				resourceCount[0]++;
				break;
			case "mana":
				resourceCount[1]++;
				break;
			case "light":
				resourceCount[2]++;
				break;
			case "dark":
				resourceCount[3]++;
				break;
			case "nature":
				resourceCount[4]++;
				break;
			default:
				break;
			}
		}
	}
	private void isCorrect() {
		int temp=0;
		for(int i=0;i<5;i++) {
			if(resourceCount[i]>0) {
				temp++;
			}
		}
		if(temp<=3) {
			System.out.println("valid"); 
		}else if(temp>3){
			System.out.println("invalid");
		}
	}
}
