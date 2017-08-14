import java.util.Scanner;

public class Chap_05 {
	private String[] expression = new String[100];
	private int size;
	private Scanner s;

	private int[] addMatchstick(int num) {
		int[][] returnNumbers = { { 8 }, { 7 }, null, { 9 }, null, { 6, 9 }, { 8 }, null, { 8 } };
		for (int i = 0; i < 10; i++) {
			if (num == i) {
				return returnNumbers[i];
			}
		}
		return null;
	}

	private String addMatchstick(String op) {
		if (op.equals("+")) {
			return "-";
		} else if (op.equals("-")) {
			return "+";
		}
		return null;
	}

	private int[] moveMatchstick(String expression2) {
		int[][] returnNumbers = { { 6, 9 }, null, { 3 }, null, { 7 }, { 3 }, { 0, 9 }, null, null, { 0, 6 } };
		for (int i = 0; i < 10; i++) {
			if (Integer.parseInt(expression2) == i) {
				return returnNumbers[i];
			}
		}
		return null;
	}

	private int[] removeMatchstick(int num) {
		int[][] returnNumbers = { null, null, null, null, null, null, { 5 }, null, { 0 }, { 5 } };
		for (int i = 0; i < 10; i++) {
			if (num == i) {
				return returnNumbers[i];
			}
		}
		return null;
	}

	private String removeMatchstick(String op) {
		if (op.equals("+")) {
			return "-";
		} else if (op.equals("-")) {
			return "+";
		}
		return null;
	}

	private int operating(int a, int b, String operate) {
		if (operate.equals("+")) {
			return a + b;
		} else if (operate.equals("-")) {
			return a - b;
		}
		return 0;
	}

	private int getSum(String[] ex) {
		int sum = Integer.parseInt(ex[0]);
		for (int k = 1; k < size; k += 2) {
			sum = operating(sum, Integer.parseInt(ex[k + 1]), ex[k]);
		}
		return sum;

	}

	public static void main(String[] args) {
		// System.out.println(addMatchstick(0)[0]);
		Chap_05 ch = new Chap_05();
		ch.getExpression();
		ch.printExpression();
	}

	private boolean findZeroPoint_MOVE() {
		for (int i = 0; i < size; i += 2) {
			int[] num = moveMatchstick(expression[i]);
			if (num != null) {
				String temp[] = expression;
				for (int j = 0; j < num.length; j++) {
					temp[i] = String.valueOf(num[j]);
					if (getSum(temp) == 0) {
						expression = temp;
						return true;
					}
				}
			}
		}
		return false;
	}

	private boolean findZeroPoint() {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (i % 2 == 0 && j % 2 == 0) { // ��� ������ ���
					int[] first = addMatchstick(Integer.parseInt(expression[i]));
					int[] second = removeMatchstick(Integer.parseInt(expression[j]));
					String[] temp = expression;
					if (first != null && second != null) {
						for (int k = 0; k < first.length; k++) {
							for (int l = 0; l < second.length; l++) {
								temp[i] = String.valueOf(first[k]);
								temp[j] = String.valueOf(second[l]);
								if (getSum(temp) == 0) {
									expression = temp;
									return true;
								}
							}
						}
					}
				} else if (i % 2 == 1 && j % 2 == 0) { // first�� ������, second�� ������ ���
					String[] temp = expression;
					temp[i] = addMatchstick(expression[i]);
					int[] second = removeMatchstick(Integer.parseInt(expression[j]));
					if (second != null) {
						for (int l = 0; l < second.length; l++) {
							temp[j] = String.valueOf(second[l]);
							if (getSum(temp) == 0) {
								expression = temp;
								return true;
							}
						}
					}
				} else if (i % 2 == 0 && j % 2 == 1) { // second�� ������, first�� ������ ���
					String[] temp = expression;

					int[] first = addMatchstick(Integer.parseInt(expression[i]));
					temp[j] = removeMatchstick(expression[j]);

					if (first != null) {
						for (int k = 0; k < first.length; k++) {
							temp[i] = String.valueOf(first[k]);
							if (getSum(temp) == 0) {
								expression = temp;
								return true;
							}
						}
					}
				} else if (i % 2 == 1 && j % 2 == 1) {// ��� �������� ���
					String[] temp = expression;

					temp[i] = addMatchstick(expression[i]);
					temp[j] = removeMatchstick(expression[j]);

					if (getSum(temp) == 0) {
						expression = temp;
						return true;
					}
				}
			}
		}
		return false;
	}

	private void getExpression() {
		s = new Scanner(System.in);
		expression = s.nextLine().split("");
		size = expression.length;
	}

	private void printExpression() {
		if (findZeroPoint_MOVE()) {
			for (int i = 0; i < size; i++) {
				System.out.print(expression[i]);

			}
			System.out.println();
		} else if (findZeroPoint()) {
			for (int i = 0; i < size; i++) {
				System.out.print(expression[i]);

			}
			System.out.println();
		}
	}

}

/*
 * 0�� ���ɰ��� �ϳ� �߰�:8 0�� ���ɰ��� �ϳ� �ű�: 6 9
 * 
 * 1�� ���ɰ��� �ϳ� �߰�: 7
 * 
 * 2�� ���ɰ��� �ϳ� �ű�: 3
 * 
 * 3�� ���ɰ��� �ϳ� �߰�: 9
 * 
 * 4�� ���ɰ��� �ϳ� �ű�: 7
 * 
 * 5�� ���ɰ��� �ϳ� �߰�: 9 6 5�� ���ɰ��� �ϳ� �ű�: 3
 *
 * 6�� ���ɰ��� �ϳ� �߰�: 8 6�� ���ɰ��� �ϳ� �ű�: 9 0 6�� ���ɰ��� �ϳ� ����: 5
 * 
 * 7�� ȥ��
 * 
 * 8�� ���ɰ��� �ϳ� ����: 0
 * 
 * 9�� ���ɰ��� �ϳ� �߰�: 8 9�� ���ɰ��� �ϳ� �ű�: 0 6 9�� ���ɰ��� �ϳ� ����: 5
 * 
 */
