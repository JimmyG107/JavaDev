package jimmyg.fsc.world;

import jimmyg.fsc.machines.Plow;


public class World {
	String worldName;
	Block[][] world;
	public World(String name) {
		this.worldName=name;
		world=new Block[200][200];
		for(int counter1 = 0;counter1<200;counter1++){
			for(int counter2 = 0;counter2<200;counter2++){
				world[counter1][counter2] = new Block();
			}
		}
	}
	public void plowAll(){
		for(int counter1 = 0;counter1<200;counter1++){
			for(int counter2 = 0;counter2<200;counter2++){
				world[counter1][counter2].plow(new Plow());
			}
		}
		System.out.println("hello");
	}
	
}
