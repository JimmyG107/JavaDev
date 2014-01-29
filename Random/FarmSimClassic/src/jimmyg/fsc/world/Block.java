package jimmyg.fsc.world;

import jimmyg.fsc.machines.Plow;


public class Block {
	int elevation = 0;
	String crop = "grass";
	int state = 0;
	String[] states = {"wild","plowed","cultivated","planted","harvestable","afterharvest"};
	public void plow(Plow plower) {
		if((state==0&&plower.willMakeField()==true)) {
			state=1;
		}
	}
	public void cultivate() {
		if(state==1) {
			state=2;
			crop="nothing";
		}
	}
	public void plant(String crop) {
		if (state==1||state==2)
			this.crop = crop;
		this.grow();
	}
	
	public void grow() {
		try {
			this.wait(0);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
