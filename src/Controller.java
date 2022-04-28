import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class Controller{
	// private JFrame win;
	private compFile cFile;
	// private JButton menuBtns[];
	// private final String password = "fuckroot@123";
    View launcher;

	public Controller() {
		String tmpPath = System.getProperty("java.io.tmpdir");
        cFile = new compFile(tmpPath + "comps.txt");
		launcher = new View(cFile);
	}

	public void acceptRegister(Complaint newComplaint){
		cFile.addComp(newComplaint);
	}

	public JTable returnData(){
		return cFile.returnTable();
	}

	public boolean findComplaint(int complaintNo){
		return cFile.findComp(complaintNo);
	}

	public void addSolution(int complaintNo, String solution){
		try{
			cFile.addSoln(complaintNo, solution);
		} catch(Exception e){
			e.printStackTrace();
		}
	}

	public void updateSolution(int complaintNo, String solution){
		cFile.overwriteSoln(complaintNo,solution);
	}

	public String giveSolution(int complaintNo){
		return cFile.getSoln(complaintNo);
	}	
	// @Override
	// public void actionPerformed(ActionEvent e) {
	// 	if (menuBtns[1] == e.getSource()) {
	// 		launcher.compRegister(cFile);
	// 	} else if (menuBtns[2] == e.getSource()) {
	// 		launcher.compStatus(cFile);
	// 	} else if (menuBtns[3] == e.getSource()) {
	// 		String pwdEntered = JOptionPane.showInputDialog(win, "Enter Password : ");
	// 		if (pwdEntered == null) {
	// 			// do nothing
	// 		} else if (pwdEntered.equals(password)) {
	// 			launcher.compCheck(cFile);
	// 		} else {
	// 			JOptionPane.showMessageDialog(win, "Wrong password");
	// 		}
	// 	} else if (menuBtns[4] == e.getSource()) {
	// 		launcher.compReport(cFile);
	// 	}
	// }
     
}
