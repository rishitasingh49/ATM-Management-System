package ASimulatorSystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class MiniStatement extends JFrame implements ActionListener {

    JButton b1;
    JLabel l1;

    MiniStatement(String pin) {
        super("Mini Statement");

        // Background color setup
        getContentPane().setBackground(Color.WHITE);
        setSize(400, 600);
        setLocation(20, 20);

        l1 = new JLabel();
        l1.setBounds(20, 140, 360, 200); // Adjusted the width to fit properly
        add(l1);

        JLabel l2 = new JLabel("Indian Bank");
        l2.setFont(new Font("System", Font.BOLD, 16));
        l2.setBounds(150, 20, 200, 20); // Increased width to center properly
        add(l2);

        JLabel l3 = new JLabel();
        l3.setBounds(20, 80, 300, 20);
        add(l3);

        JLabel l4 = new JLabel();
        l4.setBounds(20, 400, 300, 20);
        add(l4);

        // Fetching card number
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from login where pin = '" + pin + "'");
            while (rs.next()) {
                l3.setText("Card Number:    " + rs.getString("cardno").substring(0, 4) + "XXXXXXXX" + rs.getString("cardno").substring(12));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Fetching transactions and calculating balance
        try {
            int balance = 0;
            Conn c1 = new Conn();
            ResultSet rs = c1.s.executeQuery("SELECT * FROM bank where pin = '" + pin + "'");
            StringBuilder transactions = new StringBuilder("<html>");

            while (rs.next()) {
                // Replace "mode" with "type" if the column name is different in the database
                String transactionType = rs.getString("type");
                transactions.append(rs.getString("date")).append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;")
                        .append(transactionType).append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;")
                        .append(rs.getString("amount")).append("<br><br>");

                if (transactionType.equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }

            transactions.append("</html>");
            l1.setText(transactions.toString()); // Setting the formatted transactions
            l4.setText("Your total Balance is Rs " + balance);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Exit button setup
        b1 = new JButton("Exit");
        b1.setBounds(20, 500, 100, 25);
        add(b1);

        b1.addActionListener(this);

        // Setting layout
        setLayout(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        this.dispose(); // Dispose the frame when exit button is clicked
    }

    public static void main(String[] args) {
        new MiniStatement("").setVisible(true);
    }
}
