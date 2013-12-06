import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class RandomNumberGeneratorExaminer extends JFrame implements ActionListener
{
	private NumberStorageMap numberStorererer;
	
	private JTextField rangeField, numberTrialsField;
	private JButton runButton;
	
	private RandomNumberDataDisplay dataDisplay;
	
	public RandomNumberGeneratorExaminer()
	{
		super("Let's examine the notion of generating random numbers, shall we?");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1000,600);
		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());
		
		rangeField = new JTextField(6);
		rangeField.setText(""+6);
		numberTrialsField = new JTextField(6);
		numberTrialsField.setText(""+100);
		Box dataEntryBox = Box.createHorizontalBox();
		dataEntryBox.add(new JLabel("Enter Range:"));
		dataEntryBox.add(rangeField);
		dataEntryBox.add(new JLabel("Enter Number of Trials"));
		dataEntryBox.add(numberTrialsField);
		
		
		runButton = new JButton("Run");
		runButton.addActionListener(this);
		runButton.setActionCommand("run");
		runButton.setMnemonic('r');
		dataEntryBox.add(runButton);
		
		contentPane.add(dataEntryBox, BorderLayout.NORTH);
		
		dataDisplay = new RandomNumberDataDisplay(980, 500);
		contentPane.add(dataDisplay, BorderLayout.CENTER);
		
		numberStorererer = new NumberStorageMap();
		
		setVisible(true);
	}

	public void actionPerformed(ActionEvent evt)
	{
		String actionCmd = evt.getActionCommand();
		if(actionCmd.equals("run"))
		{
			try
			{
				int range = Integer.parseInt(rangeField.getText());
				int numTrials = Integer.parseInt(numberTrialsField.getText());
				RandomNumberGenerator randy = new RandomNumberGenerator(range);
				int currValue;
				numberStorererer.clear();
				for( int cntr = 0; cntr < numTrials; cntr++ )
				{
					currValue = randy.getNext();
					numberStorererer.addOccurence(currValue);
				}
				
				dataDisplay.setData(numberStorererer);
				dataDisplay.repaint();
				
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(this,
						"You must enter integers for range and number of trials");
				e.printStackTrace();
			}
		}
		
	}
	
	
	public static void main(String[] sheece)
	{
		new RandomNumberGeneratorExaminer();
	}
}
