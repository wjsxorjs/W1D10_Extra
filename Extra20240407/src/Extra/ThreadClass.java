package Extra;

public class ThreadClass extends Thread {
	
	OvalClass oval;
	int xInc, yInc;
	int bounceLimit;
	
	public ThreadClass(OvalClass oval) {
		this.oval = oval;
		xInc = (int)(Math.random()*15+15);
		if( ( (int)(Math.random()*10 + 1)  % 2 ) == 0 ) {
			xInc *= -1;
		}
		yInc = (int)(Math.random()*15+15);
		if( ( (int)(Math.random()*10 + 1)  % 2 ) == 0 ) {
			yInc *= -1;
		}

//		bounceLimit = (int)(Math.random()*15+1);
		bounceLimit = 10;
		
	}
	
	
	@Override
	public void run() {
		int bounce= 0;
		while(true) {
			oval.x += xInc;
			oval.y += yInc;
			
			if(oval.x < 0) {
				oval.x = 0;
				xInc *= -1;
				bounce++;
			} else if(oval.x > oval.frame.p.getWidth()-oval.wh) {
				oval.x = oval.frame.p.getWidth()-oval.wh;
				xInc *= -1;
				bounce++;
			} 
			if(oval.y < 0) {
				oval.y = 0;
				yInc *= -1;
				bounce++;
			} else if(oval.y > oval.frame.p.getHeight()-oval.wh) {
				oval.y = oval.frame.p.getHeight()-oval.wh;
				yInc *= -1;
				bounce++;
			}
			
			if(bounce>=bounceLimit) {
				oval.frame.list.remove(oval);
				oval.frame.p.repaint();
				break;
			}
			oval.frame.p.repaint();
			
			try {
				Thread.sleep(oval.sleepTime);
			} catch (Exception e) {}
			
		}
		
	}
	
	
}
