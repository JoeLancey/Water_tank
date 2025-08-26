package JAV_PACKAGE;

import javax.swing.JOptionPane;

public class waterTankMain {

    public static void main(String[] args) {
        Tank my_tank = null; // declare outside so it's accessible

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
                my_tank = new Tank(200, "Home tank");
                break;
            } else if (choice == 1) {
                my_tank = new Tank(500, "Building tank");
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
                int liters = Integer.parseInt(JOptionPane.showInputDialog("Enter liters to fill:"));
                my_tank.fillTank(liters);
            } else if (op == 1) {
                int liters = Integer.parseInt(JOptionPane.showInputDialog("Enter liters to use:"));
                my_tank.useWater(liters);
            } else {
                JOptionPane.showMessageDialog(null, "Exiting...");
                break;
            }

            my_tank.checkStatus();
        }
    }
}
