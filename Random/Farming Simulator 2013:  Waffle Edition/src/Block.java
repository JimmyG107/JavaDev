

public class Block {
	String state = "default";
	int elevation = 0;
	String crop = "grass";
	
	boolean isPlowed = false;
	boolean isCultivated = false;
	boolean hasCrop = true;
	public void plow() {
		isPlowed = true;
	}
	public boolean cultivate() {
		if(isPlowed&&!hasCrop) {
			isCultivated = true;
			return true;
		}
		else return false;
	}
	public void plant(String crop) {
		if (isCultivated&&!hasCrop)
			crop = this.crop;
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
