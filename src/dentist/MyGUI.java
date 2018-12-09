package dentist;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import dentist.Procedure.TypeOfOperation;

public class MyGUI {
	
	private String addFio;
	private String addCardNumber;
	private String operationNumber;
	private PatientInformation pi;
	private Procedure procedure;

	public MyGUI() {
		// TODO Auto-generated constructor stub

		JFrame frame = new JFrame();
		frame.setTitle("Dentist");
		frame.setSize(new Dimension(600, 400));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setLayout(new GridBagLayout());
		frame.setResizable(false);
		
		JButton addBtn = new JButton("Add patient");
		JButton remBtn = new JButton("Delete patient");
		JButton payForOpBtn = new JButton("Pay for operation");
		
		TableModel tb = new TableModel();
		JTable patientTable = new JTable(tb);
		JScrollPane scroll = new JScrollPane(patientTable);
		scroll.setPreferredSize(new Dimension(600, 400));
		
		//add button
		addBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				addFio = JOptionPane.showInputDialog("Enter name");
				addCardNumber = JOptionPane.showInputDialog("Enter card number");
				operationNumber = JOptionPane.showInputDialog("Enter operation type");
				
				int temp1 = Integer.parseInt(addCardNumber);
				int temp2 = Integer.parseInt(operationNumber);
				
				pi = new PatientInformation(addFio, temp1);
				procedure = new Procedure(temp2);
				
				String[] str = new String[5];
				
				str[0] = pi.toStringName();
				str[1] = pi.toStringCardNumber();
				str[2] = procedure.getOperationTypeToString();
				str[3] = procedure.toStringOpPrice();
				str[4] = pi.toStringIsPaid();
				
				tb.addDate(str);
				tb.fireTableDataChanged();
			}
		});
		
		//remove button
		remBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				tb.remData(patientTable.getSelectedRow());
                tb.fireTableDataChanged();
			}
		});
		
		//pay for operation button
		payForOpBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				tb.remData(patientTable.getSelectedRow());
                tb.fireTableDataChanged();
			}
		});
		
		
		PatientInformation pi = new PatientInformation("asdas", 1234);
		String[] str = new String[5];
		str[0] = pi.toStringName();
		str[1] = pi.toStringCardNumber();
		str[2] = pi.toStringIsPaid();
		
		tb.addDate(str);
		
		
		frame.add(scroll, new GridBagConstraints(0, 0, 3, 1, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.BOTH,
				new Insets(1, 1, 1, 1), 0, 0));
		
		frame.add(addBtn, new GridBagConstraints(0, 1, 1, 1, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
				new Insets(1, 1, 1, 1), 0, 0));
		
		frame.add(remBtn, new GridBagConstraints(1, 1, 1, 1, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
				new Insets(1, 1, 1, 1), 0, 0));
		
		frame.add(payForOpBtn, new GridBagConstraints(2, 1, 1, 1, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
				new Insets(1, 1, 1, 1), 0, 0));
		
		frame.setVisible(true);
		frame.pack();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MyGUI();
	}

}
