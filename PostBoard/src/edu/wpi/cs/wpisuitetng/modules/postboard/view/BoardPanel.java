package edu.wpi.cs.wpisuitetng.modules.postboard.view;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import edu.wpi.cs.wpisuitetng.modules.postboard.model.PostBoardModel;

/**
 * This class is a JPanel. It contains the actual post board, a text field
 * for entering a new message, and a submit button for submitting
 * a new message.
 * 
 * @author Chris Casola
 *
 */
@SuppressWarnings({"serial", "rawtypes", "unchecked" })
public class BoardPanel extends JPanel {

	/** A list box to display all the message on the board */
	private final JList lstBoard;
	
	/** A text field where the user can enter a new message */
	private final JTextField txtNewMessage;

	/** A button for submitting new messages */
	private final JButton btnSubmit;

	/**
	 * This is a model for the lstBoard component. Basically it
	 * contains the data to be displayed in the list box.
	 */
	private final PostBoardModel lstBoardModel;

	/**
	 * Construct the panel, the three components, and add the
	 * three components to the panel.
	 */
	public BoardPanel() {

		// Construct the list box model
		lstBoardModel = new PostBoardModel();
		lstBoardModel.addMessage("world");
		lstBoardModel.addMessage("hello");
		
		// Construct the components to be displayed
		lstBoard = new JList(lstBoardModel);
		txtNewMessage = new JTextField("Enter a message here.");
		btnSubmit = new JButton("Submit");

		// Set the layout manager of this panel that controls the positions of the components
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS)); // components will  be arranged vertically
		
		// Put the listbox in a scroll pane
		JScrollPane lstScrollPane = new JScrollPane(lstBoard);
		lstScrollPane.setPreferredSize(new Dimension(300,300));
		
		// Clear the contents of the text field when the user clicks on it
		txtNewMessage.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				txtNewMessage.setText("");
			}
		});
		
		// Adjust sizes and alignments
		btnSubmit.setAlignmentX(Component.CENTER_ALIGNMENT);

		// Add the components to the panel
		add(Box.createVerticalStrut(20)); // leave a 20 pixel gap
		add(lstScrollPane);
		add(Box.createVerticalStrut(20));
		add(txtNewMessage);
		add(Box.createVerticalStrut(20));
		add(btnSubmit);
	}
}
