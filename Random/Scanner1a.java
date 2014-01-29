import java.util.Scanner;
public class Scanner1a {
	public static void main(String[] args) {
		for (int counter=1;counter<=5;counter++) {
			Scanner orange = new Scanner(System.in);
			System.out.println("You said:  "+ orange.nextLine());
		}
	}
}