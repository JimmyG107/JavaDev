

public class Time {
	int hour = 0;
	int min = 0;
	int sec = 0;
	public String timeCheck(){
		String time = String.format("%2s:%2s:%2s", this.hour,this.min,this.sec);
		return time;
	}

}
