import java.awt.GridLayout;
import java.awt.Dialog.ModalityType;

import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JOptionPane;

public class compReport {
	private JDialog win;
	private JTable tableAllComps;
	// private Controller controller;

	public compReport(Controller controller) {
		win = new JDialog();
		win.setModalityType(ModalityType.APPLICATION_MODAL);
		win.setTitle("Complaints Filed");
		win.setSize(500, 500);
		win.setLayout(new GridLayout(1, 1));

		tableAllComps = controller.returnData();
		// JOptionPane.showMessageDialog(null, cfile.returnTable());
		// JOptionPane.showMessageDialog(null, controller.returnData());
		tableAllComps.setEnabled(false);
		win.add(new JScrollPane(tableAllComps));
		win.setVisible(true);
	}

}
