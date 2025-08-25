package DOS;

import javax.swing.*;

public class water_tank {
    public static void main(String[] args) {
        tank my_tank = null;

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
                my_tank = new home_tank();
                break;
            } else if (choice == 1) {
                my_tank = new building_tank();
                break;
            } else {
                JOptionPane.showMessageDialog(null, "Exiting...");
                System.exit(0);
            }
        }

        while (true) {
            Object[] options2 = {"Fill", "Use", "Exit"};
            int op = JOptionPane.showOptionDialog(
                    null,
                    "Choose an operation:",
                    "Operation Menu",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options2,
                    options2[0]
            );

            if (op == 0) {
                my_tank.fill();
            } else if (op == 1) {
                my_tank.use();
            } else {
                JOptionPane.showMessageDialog(null, "Exiting...");
                break;
            }

            my_tank.check();
        }
    }
}
