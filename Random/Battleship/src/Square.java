
public class Square {
	private boolean hasShip;
	private String shipType;
	public Square(boolean ship, String type){
		hasShip = ship;
		shipType = type;
	}
	public boolean getHasShip(){
		return hasShip;
	}
	public String getShipType(){
		return shipType;
	}
}
