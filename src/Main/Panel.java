package Main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JPanel;

public class Panel extends JPanel implements ActionListener{
	
	public static JComboBox<String> drawTool;
	private JButton clear , undo , changeColor;
	public static DrawingArea dr;
	public static Color selectedColor = Color.black;
	
	Panel(){
		setLayout(null);
		setPreferredSize(new Dimension(600,600));
		String drawToolItem []= {"Line" , "Rectangle" , "Filled rectangle" , "Circle" , "Filled circle"};
		drawTool = new JComboBox<>(drawToolItem);
		drawTool.setBounds(10,10,245,30);
		add(drawTool);
		clear = new JButton("Clear");
		undo = new JButton("undo");
		changeColor = new JButton("Change Color");
		clear.setBounds(510,10,80,30);
		undo.setBounds(415,10,80,30);
		changeColor.setBounds(265,10,140,30);
		add(clear);
		add(undo);
		add(changeColor);
		dr = new DrawingArea();
		dr.setBounds(10, 50, 580, 540);
		add(dr);
		clear.addActionListener(this);
		undo.addActionListener(this);
		changeColor.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == clear)
			Shapes.clear();
		if(e.getSource() == undo)
			Shapes.undo();
		if(e.getSource() == changeColor)
			selectedColor = new JColorChooser().showDialog(this,"Choose Color" , selectedColor);
		dr.repaint();
	}
}
