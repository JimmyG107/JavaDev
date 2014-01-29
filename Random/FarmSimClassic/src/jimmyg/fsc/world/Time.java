package jimmyg.fsc.world;

public class Time implements Runnable{
	Thread t;
	public Time(){
		t = new Thread(this, "Time Thread");
		t.start();
	}
	int multiplier = 1;
	boolean bool=true;
	int hour = 11;
	int min = 59;
	int sec = 55;
	int prevHour = hour;
	String period = "AM";
	@Override
	public void run() {
		try {
	         while(true) {
	        	 prevHour=hour;
	        	 System.out.println(timeCheck());
		         Thread.sleep(1000);
	        	 sec=sec+(1*multiplier);
	        	 while(bool){
	        		 bool = check();
	        	 }
	        	 bool=true;
	         }
	     } catch (InterruptedException e) {
	         System.out.println("Time interrupted.");
	     }
	     System.out.println("Exiting time thread.");
	}
	public void setMultiplier(int Mult){
		this.multiplier=Mult;
	}
	private boolean check(){
		if (sec >= 60) {
			sec=sec-60;
			min++;
			return true;
		}
		if (min >= 60) {
			min=min-60;
			hour++;
			return true;
		}
		if (prevHour < 12 && hour >=12) {
			period = (period == "AM")?"PM":"AM";
		}
		if (hour >= 13) {
			hour=1;
			return false;
		}
		return false;
		
	}
	
	public String timeCheck(){
		String time = String.format("%02d:%02d:%02d %s", this.hour,this.min,this.sec, this.period);
		return time;
	}
	
}
