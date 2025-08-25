package DOS;

import javax.swing.*;

public abstract class tank {
    protected float tank = 0;
    protected float gas_lvl = 0;
    protected float tank_limit;

    public tank(float tank_limit) {
        this.tank_limit = tank_limit;
    }

    public void fill() {
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

    public void use() {
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

    public void check() {
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
}
