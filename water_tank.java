package DOS;
import javax.swing.*;


public class water_tank {

	 static float tank = 0, gas_lvl = 0;
	    static float tank_limit = 0;

	    static void fill() {
	        String input = JOptionPane.showInputDialog("Input liters to fill:");
	        if (input == null) return;

	        float num_gas = Float.parseFloat(input);

	        if (num_gas <= 0) {
	            JOptionPane.showMessageDialog(null, "Please enter a positive number.");
	            return;
	        }

	        if (tank + num_gas > tank_limit) {
	            JOptionPane.showMessageDialog(null, "Cannot fill beyond tank limit (" + tank_limit + " liters).");
	            return;
	        }

	        tank += num_gas;
	        gas_lvl = tank;
	        JOptionPane.showMessageDialog(null, num_gas + " liter/s added. Current level: " + gas_lvl + "/" + tank_limit);
	    }

	    static void use() {
	        String input = JOptionPane.showInputDialog("Input liters to use:");
	        if (input == null) return;

	        float use_gas = Float.parseFloat(input);

	        if (use_gas <= 0) {
	            JOptionPane.showMessageDialog(null, "Please enter a positive number.");
	            return;
	        }

	        if (use_gas > gas_lvl) {
	            JOptionPane.showMessageDialog(null, "Usage exceeds current level (" + gas_lvl + " liters).");
	            return;
	        }

	        tank -= use_gas;
	        gas_lvl = tank;
	        JOptionPane.showMessageDialog(null, use_gas + " liter/s used. Current level: " + gas_lvl + "/" + tank_limit);
	    }

	    static void check() {
	        String status;
	        if (tank <= 0) {
	            status = "_____EMPTY_____";
	        } else if (tank >= tank_limit) {
	            status = "_____FULL_____";
	        } else {
	            status = "_____IN USE_____";
	        }
	        JOptionPane.showMessageDialog(null, "=====TANK STATUS=====\n" + status);
	    }

	    public static void main(String[] args) {
	        while (true) {
	            Object[] options = {"Home Tank", "Building Tank", "Exit"};
	            int choice = JOptionPane.showOptionDialog(
	                    null,
	                    "Choose tank type:",
	                    "Tank Type",
	                    JOptionPane.DEFAULT_OPTION,
	                    JOptionPane.QUESTION_MESSAGE,
	                    null,
	                    options,
	                    options[0]
	            );

	            if (choice == 0) {
	                tank_limit = 200;
	                break;
	            } else if (choice == 1) {
	                tank_limit = 500;
	                break;
	            } else if (choice == 2 || choice == JOptionPane.CLOSED_OPTION) {
	                JOptionPane.showMessageDialog(null, "Exiting...");
	                System.exit(0);
	            }
	        }

	        while (true) {
	            Object[] options_2 = {"Fill", "Use", "Exit"};
	            int choice_2 = JOptionPane.showOptionDialog(
	                    null,
	                    "Choose an operation:",
	                    "Operation Menu",
	                    JOptionPane.DEFAULT_OPTION,
	                    JOptionPane.QUESTION_MESSAGE,
	                    null,
	                    options_2,
	                    options_2[0]
	            );

	            if (choice_2 == 0) {
	                if (tank >= tank_limit) {
	                    JOptionPane.showMessageDialog(null, "Unable to fill — Tank is full.");
	                } else {
	                    fill();
	                }
	            } else if (choice_2 == 1) {
	                if (tank <= 0) {
	                    JOptionPane.showMessageDialog(null, "Tank is empty! Please fill first.");
	                } else {
	                    use();
	                }
	            } else if (choice_2 == 2 || choice_2 == JOptionPane.CLOSED_OPTION) {
	                JOptionPane.showMessageDialog(null, "Exiting...");
	                break;
	            }

	            check();
	        }
	    }
	}

