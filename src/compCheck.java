import java.awt.GridLayout;
import java.awt.Dialog.ModalityType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class compCheck implements ActionListener {
	private JDialog win;
	// private compFile cfile;
	private JTextArea taSoln;
	private JTextField tfCompNum;
	private JButton submitBtn;
	private Controller controller;

	public compCheck() {
		// this.cfile = cfile;
		win = new JDialog();
		win.setModalityType(ModalityType.APPLICATION_MODAL);
		win.setTitle("Complaints Filed");
		win.setSize(500, 500);
		win.setLayout(new GridLayout(2, 1));

		JTable tableAllComps = controller.returnData();
		tableAllComps.setEnabled(false);

		tfCompNum = new JTextField(40);

		taSoln = new JTextArea(7, 40);

		submitBtn = new JButton("Submit");
		submitBtn.addActionListener(this);

		JPanel panel = new JPanel();
		panel.add(new JLabel("Complaint No. "));
		panel.add(tfCompNum);
		panel.add(new JLabel("Solution "));
		panel.add(new JScrollPane(taSoln));
		panel.add(submitBtn);

		win.add(new JScrollPane(tableAllComps));
		win.add(panel);

		win.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (submitBtn == (JButton) e.getSource()) {
			boolean flag = true;
			int complaintNo = 0;
			String sol = taSoln.getText();
			try {
				complaintNo = Integer.parseInt(tfCompNum.getText());
			} catch (Exception exc) {
				flag = false;
				JOptionPane.showMessageDialog(null, "Invalid Complaint No");
			}
			if (flag) {
				if (!controller.findComplaint(complaintNo)) {
					JOptionPane.showMessageDialog(null, "No Complaint exist for given Complain No.");
				} else if (sol.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Solution cant be empty");
				} else // Everything right
				{
					try {
						controller.addSolution(complaintNo, sol);
						JOptionPane.showMessageDialog(null, "Successfully Added");
					} catch (Exception e1) {
						int opt = JOptionPane.showConfirmDialog(null, "Solution Already Exists. Overwrite?");
						if (opt == JOptionPane.YES_OPTION) {
							controller.updateSolution(complaintNo, sol);
							JOptionPane.showMessageDialog(null, "Successfully Overwrited");
						}
					}
				}
			}
			if (flag) {
				win.dispose();
			}
		}
	}
}
