package self.java.pane;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.BorderLayout;
import javax.swing.JTextField;

public class WrongPane extends JPanel {
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public WrongPane() {
		
		setBackground(Color.RED);
		setLayout(new BorderLayout(0, 0));
		setAlignmentX(CENTER_ALIGNMENT);
		textField = new JTextField();
		textField.setBackground(Color.ORANGE);
		textField.setText("’À∫≈ªÚ√‹¬Î¥ÌŒÛ,«Î÷ÿ–¬ ‰»Î");
		add(textField, BorderLayout.CENTER);
		textField.setColumns(10);

	}

}
