package frontend;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame implements ActionListener {
    JButton solveButton, clearButton;
    JLabel titleLabel, solutionLabel;
    JTextArea inputTextArea;
    JPanel panel;

    public MainWindow() {
        super("DPLL SAT solver");

        titleLabel = new JLabel("Enter a cnf as shown in the readme.");
        solutionLabel = new JLabel("UNSAT");

        solveButton = new JButton("Solve");
        solveButton.addActionListener(this);
        clearButton = new JButton("Clear");
        clearButton.addActionListener(this);

        panel = new JPanel(); // Create a panel to hold the components
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // Use BoxLayout to arrange components vertically (in a column)


        inputTextArea = new JTextArea(10, 30); // 10 lines, 40 columns
        inputTextArea.setLineWrap(true); // Allow line wrapping
        inputTextArea.setWrapStyleWord(true); // Word wrap for the text area

        panel.add(titleLabel);
        panel.add(Box.createVerticalStrut(10));
        panel.add(solutionLabel);
        panel.add(new JScrollPane(inputTextArea));
        panel.add(Box.createVerticalStrut(10));
        panel.add(solveButton);

        add(panel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(550, 300);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
