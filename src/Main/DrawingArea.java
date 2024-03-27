package Main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class DrawingArea extends JPanel implements MouseListener , MouseMotionListener{
	DrawingArea(){
		setBackground(Color.white);
		addMouseListener(this);
		addMouseMotionListener(this);
	}
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		for(int i = 0 ; i <Shapes.getSize() ; i++) {
			g.setColor(Shapes.getColor(i));
			if(Shapes.getSelectedItem(i) == SelectedItem.Line) 
				g.drawLine(Shapes.getPaintCor(i)[0], Shapes.getPaintCor(i)[1], Shapes.getPaintCor(i)[2], Shapes.getPaintCor(i)[3]);
			if(Shapes.getSelectedItem(i) == SelectedItem.Rectangle) 
				g.drawRect(Math.min(Shapes.getPaintCor(i)[0], Shapes.getPaintCor(i)[2]),
						Math.min(Shapes.getPaintCor(i)[1], Shapes.getPaintCor(i)[3]),
						Math.abs(Shapes.getPaintCor(i)[2]-Shapes.getPaintCor(i)[0]),
						Math.abs(Shapes.getPaintCor(i)[3]-Shapes.getPaintCor(i)[1]));
			if(Shapes.getSelectedItem(i) == SelectedItem.filledRectangle) 
				g.fillRect(Shapes.getPaintCor(i)[0], Shapes.getPaintCor(i)[1], Shapes.getPaintCor(i)[2]-Shapes.getPaintCor(i)[0],
						Shapes.getPaintCor(i)[3]-Shapes.getPaintCor(i)[1]);
			if(Shapes.getSelectedItem(i) == SelectedItem.circle) 
				g.drawOval(Math.min(Shapes.getPaintCor(i)[0], Shapes.getPaintCor(i)[2]),
						Math.min(Shapes.getPaintCor(i)[1], Shapes.getPaintCor(i)[3]),
						Math.abs(Shapes.getPaintCor(i)[2]-Shapes.getPaintCor(i)[0]),
						Math.abs(Shapes.getPaintCor(i)[3]-Shapes.getPaintCor(i)[1]));
			if(Shapes.getSelectedItem(i) == SelectedItem.filledCircle) 
				g.fillOval(Math.min(Shapes.getPaintCor(i)[0], Shapes.getPaintCor(i)[2]),
						Math.min(Shapes.getPaintCor(i)[1], Shapes.getPaintCor(i)[3]),
						Math.abs(Shapes.getPaintCor(i)[2]-Shapes.getPaintCor(i)[0]),
						Math.abs(Shapes.getPaintCor(i)[3]-Shapes.getPaintCor(i)[1]));
		}
	}
	@Override public void mouseClicked(MouseEvent arg0) {}
	@Override public void mouseEntered(MouseEvent arg0) {}
	@Override public void mouseExited(MouseEvent arg0) {}
	@Override
	public void mousePressed(MouseEvent e) {
		if(SwingUtilities.isLeftMouseButton(e)) {
		SelectedItem si = SelectedItem.Line;
		if(Panel.drawTool.getSelectedItem().equals("Line"))
			si = SelectedItem.Line;
		if(Panel.drawTool.getSelectedItem().equals("Rectangle"))
			si = SelectedItem.Rectangle;
		if(Panel.drawTool.getSelectedItem().equals("Filled rectangle"))
			si = SelectedItem.filledRectangle;
		if(Panel.drawTool.getSelectedItem().equals("Circle"))
			si = SelectedItem.circle;
		if(Panel.drawTool.getSelectedItem().equals("Filled circle"))
			si = SelectedItem.filledCircle;
		Shapes.addNewShape(e.getX(), e.getY(), si);	
		}
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		if(SwingUtilities.isLeftMouseButton(e)) {
		Shapes.endShape(e.getX(), e.getY());
		repaint();
		}
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		if(SwingUtilities.isLeftMouseButton(e)) {
		Shapes.modifyShape(e.getX(), e.getY());
		repaint();
		}
	}
	@Override public void mouseMoved(MouseEvent arg0) {}
}