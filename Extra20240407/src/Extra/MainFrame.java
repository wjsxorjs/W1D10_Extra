package Extra;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame {
	
	int x, y, wh;

	OvalClass oval;
	
	ArrayList<OvalClass> list = new ArrayList<OvalClass>();
	
	JPanel p = new JPanel() {

		@Override
		protected void paintComponent(Graphics g) {
			Image buf = createImage(this.getWidth(), this.getHeight());
			Graphics bufG = buf.getGraphics();
			for(int i=0; i< list.size();i++) {
				OvalClass tmpO = list.get(i);
				bufG.setColor(tmpO.c);
				bufG.fillOval(tmpO.x, tmpO.y, tmpO.wh, tmpO.wh);
			}
			g.drawImage(buf, 0, 0, this);
			
		}
		
	};
	
	
	
	public MainFrame() {
		
		this.add(p);
		
		this.setBounds(100, 100, 500, 600);
		this.setVisible(true);
		
		
		
		
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		p.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				int x = e.getX();
				int y = e.getY();
				
				oval = new OvalClass(x, y, MainFrame.this);
				list.add(oval);
				oval.thread.start();
				
			}
		});
		
	}
	
	

	public static void main(String[] args) {
		
		new MainFrame();

	}

}
