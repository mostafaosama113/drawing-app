package Main;

import java.awt.Color;
import java.util.ArrayList;

public class Shapes {
	private static int counter = 0;
	private static ArrayList<Integer> startX = new ArrayList<>()
			, startY = new ArrayList<>()
			, endX = new ArrayList<>()
			, endY= new ArrayList<>();
	private static ArrayList<SelectedItem> selected  = new ArrayList<>();
	private static ArrayList<Color> selectedColor  = new ArrayList<>();
	
	public static int getSize() {
		return startX.size();
	}
	
	public static void addNewShape(int x , int y , SelectedItem si) {
		startX.add(x);
		startY.add(y);
		selected.add(si);
		endX.add(x);
		endY.add(y);
		selectedColor.add(Panel.selectedColor);
	}
	
	public static void modifyShape(int x , int y) {
		endX.set(counter, x);
		endY.set(counter, y);
	}
	
	public static void endShape(int x , int y) {
		endX.set(counter, x);
		endY.set(counter, y);
		counter++;
	}
	
	public static void clear() {
		counter = 0;
		startX.clear();
		startY.clear();
		endX.clear();
		endY.clear();
		selected.clear();
		selectedColor.clear();
	}
	
	public static void undo() {
		if(counter > 0) {
			counter--;
			startX.remove(counter);
			startY.remove(counter);
			endX.remove(counter);
			endY.remove(counter);
			selected.remove(counter);
			selectedColor.remove(counter);
		}
	}
	
	public static int [] getPaintCor(int index) {
		int r [] = {startX.get(index) , startY.get(index) , endX.get(index) , endY.get(index)};
		return r;
	}
	public static SelectedItem getSelectedItem(int index) {
		return selected.get(index);
	}
	
	public static Color getColor(int index) {
		return selectedColor.get(index);
	}
}