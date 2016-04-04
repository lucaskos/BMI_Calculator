import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class BottomPanel extends JPanel {
	private JLabel bmi;

	public BottomPanel() {
		bmi = new JLabel("naciśnij licz");
		setLayout(new BorderLayout());
		add(bmi, BorderLayout.NORTH);
	}

	public void setText(String string) {
		bmi.setText(string);
	}
}
