package JAV_PACKAGE;

import javax.swing.JOptionPane;

public class building_tank extends allTanks{
	
	  public building_tank(int capacity, String type) {
	        super(capacity, type);
	        
	    }

	    @Override
	    public void fillTank(int liters) {
	        currentLevel = Math.min(currentLevel + liters, capacity);
	    }

	    @Override
	    public void useWater(int liters) {
	        currentLevel = Math.max(currentLevel - liters, 0);
	    }

	    @Override
	    public void checkStatus() {
	        if (currentLevel == 0) {
	            JOptionPane.showMessageDialog(null, type + " is EMPTY.");
	        } else if (currentLevel == capacity) {
	            JOptionPane.showMessageDialog(null, type + " is FULL.");
	        } else {
	            JOptionPane.showMessageDialog(null, type + " is IN USE. Current level: " + currentLevel + " liters");
	        }
	    }

}
