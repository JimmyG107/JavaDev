package jimmyg.fsc.main;
import java.util.InputMismatchException;
import java.util.Scanner;

import jimmyg.fsc.world.Time;
import jimmyg.fsc.world.World;


public class Start {
	public static void main(String[] args){
		
		Time time = new Time();
		World world = new World("World1");
		world.plowAll();
		int x = 0;
		int timeMultiplier=1;
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		while(true){
			if (x!=0)	input.nextLine();
			try{
				timeMultiplier=input.nextInt();
				System.out.println(timeMultiplier);
				time.setMultiplier(timeMultiplier);
			} catch (InputMismatchException e){
				System.out.println("Not a valid input");
				e.printStackTrace();
			}
			x++;
		}
	}
}
