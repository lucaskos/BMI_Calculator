import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.Format;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class mainFrame extends JFrame {
	private JPanel mainPanel;
	private BottomPanel bottomPanel;
	private JLabel heightLabel;
	private JTextField heightField;
	private JLabel weightLabel;
	private JTextField weightField;
	private JButton okBtn;
	
	mainFrame() {
		setLayout(new BorderLayout());
		bottomPanel = new BottomPanel();

		add(setLayout(), BorderLayout.NORTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 250);
		setVisible(true);
		okBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int w = Integer.parseInt(weightField.getText());
				int h = Integer.parseInt(heightField.getText());
				double bmi = 0;
				bmi = w / (Math.pow(h, 2));
				bmi *= 10000;
				DecimalFormat df = new DecimalFormat("#.##");
				String number = df.format(bmi);
				bottomPanel.setText(number);

			}
		});

	}

	private Component setLayout() {
		mainPanel = new JPanel();
		heightField = new JTextField(5);
		weightField = new JTextField(5);
		heightLabel = new JLabel("height:");
		weightLabel = new JLabel("weight:");
		okBtn = new JButton("licz");

		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		mainPanel.setLayout(gbl);
		gbc.insets = new Insets(20, 0, 0, 0);
		gbc.anchor = GridBagConstraints.FIRST_LINE_START;
		gbc.gridy = 0;
		gbc.gridx = 0;

		gbl.setConstraints(heightLabel, gbc);
		mainPanel.add(heightLabel);

		gbc.gridy = 1;
		gbl.setConstraints(heightField, gbc);
		mainPanel.add(heightField);

		gbc.gridy = 0;
		gbc.gridx = 1;
		gbl.setConstraints(weightLabel, gbc);
		mainPanel.add(weightLabel);

		gbc.gridx = 1;
		gbc.gridy = 1;
		gbl.setConstraints(weightField, gbc);
		mainPanel.add(weightField);

		gbc.gridx = 0;
		gbc.gridy++;
		gbc.gridwidth = 2;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbl.setConstraints(okBtn, gbc);
		mainPanel.add(okBtn);

		gbc.gridx = 0;
		gbc.gridy++;
		gbc.gridy++;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbl.setConstraints(bottomPanel, gbc);
		mainPanel.add(bottomPanel);

		mainPanel.setVisible(true);
		return mainPanel;

	}

}
