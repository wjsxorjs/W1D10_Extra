package Extra;

import java.awt.Color;

public class OvalClass {
	
	MainFrame frame;
	
	Color c;
	int x, y, wh, sleepTime;

	ThreadClass thread;
	
	public OvalClass(int x, int y, MainFrame frame) {
		this.wh = (int)(Math.random()*150+50);
		
		this.x = x-(wh/2);
		this.y = y-(wh/2);
		
		
		this.sleepTime = (int)(Math.random()*80+10);

		int r = (int)(Math.random()*256);
		int g = (int)(Math.random()*256);
		int b = (int)(Math.random()*256);
		
		c = new Color(r, g, b);
		
		this.frame = frame;
		thread = new ThreadClass(this);
	}
	

}
