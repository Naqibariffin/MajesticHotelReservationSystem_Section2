//Muhammad Mazizi bin Mazlan's Page

//PROGRAM DESCRIPTION: TO PRINT A RECEIPT FOR MAJESTIC HOTEL RESERVATION SYSTEM

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class Receipt extends JFrame {
    JFrame frame;

    public Receipt(String bookingDetails, String FirstName, String Email, String NumPhone, String cardType , String BankName) {
        frame = new JFrame();
        frame.setSize(700,500);
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        frame.add(panel);
        JTextArea receipt = new JTextArea("----------------Receipt-------------------\n");
        receipt.setEditable(false);
        receipt.setFont(new Font("Arial", Font.PLAIN, 15));
        panel.add(receipt);
        if (FirstName != null)
            receipt.append("\nFirst Name: " + FirstName + "\nEmail:" + Email + "\nPhone Number:" + NumPhone + "\nPayment Method:" + cardType +"\nBank Name:" + BankName);
        receipt.append("\n\n" + bookingDetails);
        
        JButton close = new JButton("Close");
        close.addActionListener(new ActionListener() 
            {
                public void actionPerformed(ActionEvent e) {
                    frame.dispose();
                    

                }
            });
        panel.add(close, BorderLayout.SOUTH);
        

        setSize(500, 400);
        frame.setVisible(true);
    }

    
    
}