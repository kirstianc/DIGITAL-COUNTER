package SIMPLE_COUNTER;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/** Creates a simple GUI for a counting application, for learning purposes
 * @author Ian Chavez
 */
public class SIMPLE_COUNTER implements ActionListener {

    // Fields
    private int count = 0;
    private JLabel label;
    private JFrame frame;
    private JPanel panel;
    private JButton incButton;
    private JButton decButton;

    public SIMPLE_COUNTER() {

        GridLayout countButtonLayout = new GridLayout(0,2);
        frame = new JFrame();

        incButton = new JButton("Increase");
        ActionEvent incAction = new ActionEvent(incButton, 0, "increment");

        decButton = new JButton("Decrease");
        ActionEvent decAction = new ActionEvent(decButton, 1, "decrement");

        incButton.addActionListener(this);
        decButton.addActionListener(this);

        label = new JLabel("Count: "+count);

        panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(new GridLayout(0, 1));
        panel.setBackground(Color.white);

        panel.setLayout(countButtonLayout);
        panel.add(incButton);
        panel.add(decButton);
        panel.add(label);

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Basic Counter");
        frame.pack();
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        new SIMPLE_COUNTER();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        if(action.equals("Increase")) {
            count++;
            label.setText("Count: " + count);
        }
        else if(action.equals("Decrease")){
            count--;
            label.setText("Count: " + count);
        }
    }
}
