import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

/**
 *
 * @author Tea
 */
public class BSTSortGUI extends JFrame {
    private static final int TEXT_FIELD_WIDTH = 25;
    
    public BSTSortGUI() {
        super("Binary Search Tree Sort");
        setLocationRelativeTo(null);        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Initialize JPanels
        setLayout(new BorderLayout(5, 10));
        JPanel inOutputFrame = new JPanel(new BorderLayout(2, 18));
        inOutputFrame.setBorder(new EmptyBorder(10, 15, 0, 15));
        
        JPanel inputPane = new JPanel(new BorderLayout());
        JPanel outputPane = new JPanel(new BorderLayout());
        
        JPanel optionsFrame = new JPanel(new GridLayout());
        JPanel orderFrame = new JPanel(new BorderLayout());
        JPanel typeFrame = new JPanel(new BorderLayout());
        optionsFrame.setBorder(new EmptyBorder(0, 40, 10, 0));
        
        //Initialize Components
        // Input / Output Area
        JLabel inputLabel = new JLabel("Input List: ");
        JTextField inputField = new JTextField(TEXT_FIELD_WIDTH);
        
        JLabel outputLabel = new JLabel("Sorted List: ");
        JTextField outputField = new JTextField(TEXT_FIELD_WIDTH);
        
        JButton submitButton = new JButton("Perform Sort");
        
        // Options Area
        JLabel orderLabel = new JLabel("Sort Order: ");
        JRadioButton ascButton = new JRadioButton ("Ascending", true);
        JRadioButton descButton = new JRadioButton ("Descending");
        ButtonGroup orderGroup = new ButtonGroup();
        orderGroup.add(ascButton);
        orderGroup.add(descButton);
        
        JLabel typeLabel = new JLabel("Numeric Type: ");
        JRadioButton intButton = new JRadioButton("Integers", true);
        JRadioButton fracButton = new JRadioButton("Fractions");
        ButtonGroup typeGroup = new ButtonGroup();
        typeGroup.add(intButton);
        typeGroup.add(fracButton);
        
        // Listener
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                Tree tree = new Tree();
                try {
                    if (intButton.isSelected()) {
                        tree.buildIntTree(inputField.getText());
                    }
                    else if (fracButton.isSelected()) {
                        tree.buildFracTree(inputField.getText());
                    }
                    
                    if (ascButton.isSelected()) {
                        outputField.setText(tree.getRoot().inOrder());
                    }
                    
                    else if (descButton.isSelected()) {
                        outputField.setText(tree.getRoot().reverseOrder());
                        
                    }
                }
                
                catch (NumberFormatException exc) {
                    JOptionPane.showMessageDialog(null, "Invalid input.", 
                            "Invalid Input", JOptionPane.ERROR_MESSAGE);                   
                }
                
            }
        });
        
        // Add Components to Panel
        inputPane.add(inputLabel, BorderLayout.WEST);
        inputPane.add(inputField, BorderLayout.EAST);
        
        outputPane.add(outputLabel, BorderLayout.WEST);
        outputPane.add(outputField, BorderLayout.EAST);
        
        inOutputFrame.add(inputPane, BorderLayout.NORTH);
        inOutputFrame.add(outputPane, BorderLayout.CENTER);
        inOutputFrame.add(submitButton, BorderLayout.SOUTH);
        
        
        orderFrame.add(orderLabel, BorderLayout.NORTH);
        orderFrame.add(ascButton, BorderLayout.CENTER);
        orderFrame.add(descButton, BorderLayout.SOUTH);
        
        typeFrame.add(typeLabel, BorderLayout.NORTH);
        typeFrame.add(intButton, BorderLayout.CENTER);
        typeFrame.add(fracButton, BorderLayout.SOUTH);
        
        optionsFrame.add(orderFrame, BorderLayout.WEST);
        optionsFrame.add(typeFrame, BorderLayout.EAST);
        
        add(inOutputFrame, BorderLayout.NORTH);
        add(optionsFrame, BorderLayout.SOUTH);
    }
    
    
    public static void main(String[] args) {
        BSTSortGUI gui = new BSTSortGUI();
        gui.pack();
        gui.setVisible(true);
    }
    
}
