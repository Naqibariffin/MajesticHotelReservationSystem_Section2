//Muhammad Irham Firdaus bin Amran's Page

//PROGRAM DESCRIPTION: TO CREATE A PAYMENT SYSTEM FOR MAJESTIC HOTEL RESERVATION SYSTEM
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// Interface for Payment
interface Payment {
    void processPayment(); // Method to process payment
}

// Debit card payment class
class DebitCardPayment implements Payment {
    // Attributes for debit card payment
    private double amount;
    private String cardNumber;
    private String expirationDate;
    private int cvv;
    private String bankName;

    // Constructor for debit card payment
    public DebitCardPayment(double amount, String cardNumber, String expirationDate, int cvv, String bankName) {
        this.amount = amount;
        this.cardNumber = cardNumber;
        this.expirationDate = expirationDate;
        this.cvv = cvv;
        this.bankName = bankName;
    }

    @Override
    public void processPayment() {
        // Logic for processing debit card payment
        JOptionPane.showMessageDialog(null, "Debit card payment of RM" + amount + " processed successfully.");
    }
}

// Credit card payment class
class CreditCardPayment implements Payment {
    // Attributes for credit card payment
    private double amount;
    private String cardNumber;
    private String expirationDate;
    private int cvv;
    private String cardType;

    // Constructor for credit card payment
    public CreditCardPayment(double amount, String cardNumber, String expirationDate, int cvv, String cardType) {
        this.amount = amount;
        this.cardNumber = cardNumber;
        this.expirationDate = expirationDate;
        this.cvv = cvv;
        this.cardType = cardType;
    }

    @Override
    public void processPayment() {
        // Logic for processing credit card payment
        JOptionPane.showMessageDialog(null, "Credit card payment of RM" + amount + " processed successfully.");
    }
}

// Main payment system JFrame
public class PaymentSystem extends JFrame implements ActionListener {
    // Components for the payment system
    private JTextField amountField; // Field for entering amount
    private JRadioButton debitCardRadio, creditCardRadio; // Radio buttons for payment method
    private JTextField cardNumberField, expirationDateField, cvvField, bankNameField; // Fields for card information
    private JComboBox<String> cardTypeComboBox; // Combo box for credit card type
    private JButton payButton; // Button for payment
    String bookingDetails, FirstName, Email, NumPhone;
    double totalprice;

    // Constructor for the payment system
    public PaymentSystem(String bookingDetails, String FirstName, String Email, String NumPhone, double totalprice) {
        setTitle("Majestic Hotel Payment System"); // Set title of the JFrame
        setSize(500, 400); // Set size of the JFrame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Set default close operation
        setLocationRelativeTo(null); // Center the JFrame on screen
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS)); // Set layout for the JFrame

        this.bookingDetails = bookingDetails;
        this.FirstName = FirstName;
        this.Email = Email;
        this.NumPhone = NumPhone;
        this.totalprice = totalprice;

        // Panel for selecting payment method
        JPanel paymentMethodPanel = new JPanel();
        paymentMethodPanel.setLayout(new FlowLayout());

        debitCardRadio = new JRadioButton("Debit Card");
        creditCardRadio = new JRadioButton("Credit Card");

        ButtonGroup paymentMethodGroup = new ButtonGroup();
        paymentMethodGroup.add(debitCardRadio);
        paymentMethodGroup.add(creditCardRadio);
        
        paymentMethodPanel.add(new JLabel("Select payment method:"));
        paymentMethodPanel.add(debitCardRadio);
        paymentMethodPanel.add(creditCardRadio);

        
        add(paymentMethodPanel);

        // Panel for entering card information
        JPanel cardInfoPanel = new JPanel();
        cardInfoPanel.setLayout(new GridLayout(6, 1)); // Set layout for card information panel

        bankNameField = new JTextField(); // Field for bank name
        cardNumberField = new JTextField(); // Field for card number
        expirationDateField = new JTextField(); // Field for expiration date
        cvvField = new JTextField(); // Field for CVV
        
        // Label and field for entering amount
        JLabel amountLabel = new JLabel("Total amount:");
        
        cardInfoPanel.add(amountLabel);

        amountField = new JTextField();
        amountField.setPreferredSize(new Dimension(100, 30)); // Set size for amount field
        cardInfoPanel.add(amountField);
        amountField.setText(String.valueOf(totalprice));
        amountField.setEditable(false);
        
        // Set size for card information fields
        bankNameField.setPreferredSize(new Dimension(200, 30));
        cardNumberField.setPreferredSize(new Dimension(200, 30));
        expirationDateField.setPreferredSize(new Dimension(200, 30));
        cvvField.setPreferredSize(new Dimension(200, 30));

        cardInfoPanel.add(new JLabel("Bank Name:")); // Label for bank name field
        cardInfoPanel.add(bankNameField); // Add bank name field to card information panel
        cardInfoPanel.add(new JLabel("Card Number:"));
        cardInfoPanel.add(cardNumberField); // Add card number field to card information panel
        cardInfoPanel.add(new JLabel("Expiration Date (MM/YY):"));
        cardInfoPanel.add(expirationDateField); // Add expiration date field to card information panel
        cardInfoPanel.add(new JLabel("CVV:"));
        cardInfoPanel.add(cvvField); // Add CVV field to card information panel

        // Add card type field for credit card
        cardTypeComboBox = new JComboBox<>(new String[]{"Visa", "MasterCard", "American Express"});
        cardInfoPanel.add(new JLabel("Card Type:")); // Label for card type field
        cardInfoPanel.add(cardTypeComboBox); // Add card type combo box to card information panel

        add(cardInfoPanel); // Add card information panel to JFrame

        // Create and add pay button
        payButton = new JButton("Pay");
        payButton.addActionListener(this); // Add action listener to pay button
        // Add pay button to bottom of JFrame
        JPanel bottomPanel = new JPanel();
        bottomPanel.setBounds(0, 400, 680, 50);
        bottomPanel.add(payButton);
        add(bottomPanel);
        
        setVisible(true); // Set JFrame visible
    }
    
    
    
    // ActionListener implementation for pay button
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == payButton) { // Check if pay button is clicked
            String BankName = bankNameField.getText();
            String cardTypestr = cardTypeComboBox.getSelectedItem().toString();
            new Receipt(bookingDetails, FirstName, Email, NumPhone, BankName, cardTypestr);
            double amount = Double.parseDouble(amountField.getText()); // Get amount from amount field
        
            if (debitCardRadio.isSelected()) { // Check if debit card radio button is selected
                String cardNumber = cardNumberField.getText(); // Get card number from card number field
                String expirationDate = expirationDateField.getText(); // Get expiration date from expiration date field
                int cvv = Integer.parseInt(cvvField.getText()); // Get CVV from CVV field
                String bankName = bankNameField.getText(); // Get bank name from bank name field

                Payment debitCardPayment = new DebitCardPayment(amount, cardNumber, expirationDate, cvv, bankName); // Create debit card payment instance
                debitCardPayment.processPayment(); // Process debit card payment
            } else if (creditCardRadio.isSelected()) { // Check if credit card radio button is selected
                String cardNumber = cardNumberField.getText(); // Get card number from card number field
                String expirationDate = expirationDateField.getText(); // Get expiration date from expiration date field
                int cvv = Integer.parseInt(cvvField.getText()); // Get CVV from CVV field
                String cardType = (String) cardTypeComboBox.getSelectedItem(); // Get card type from card type combo box

                Payment creditCardPayment = new CreditCardPayment(amount, cardNumber, expirationDate, cvv, cardType); // Create credit card payment instance
                creditCardPayment.processPayment(); // Process credit card payment
            } else {
                JOptionPane.showMessageDialog(null, "Please select a payment method."); // Show error message if no payment method is selected
            }
        }
    }
}