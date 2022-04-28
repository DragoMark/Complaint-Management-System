import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class View implements ActionListener, WindowListener{
    // private JFrame win;
	// private JButton menuBtns[];
	// private final String password = "fuckroot@123";
    private compRegister Register;
    private compStatus Status;
    private compCheck Check;
    private compReport Report;
    private JFrame win;
    private compFile cFile;
    private JButton menuBtns[];
    private final String password = "fuckroot@123";

    public View(compFile cFile){
        win = new JFrame();
		this.cFile = cFile;

		win.setTitle("Complaint Box");
		win.setSize(500, 600);
		win.addWindowListener(this);
		win.setLayout(new GridLayout(5, 1));

		menuBtns = new JButton[5];
		for (int i = 0; i < menuBtns.length; ++i) {
			menuBtns[i] = new JButton();
			win.add(menuBtns[i]);
			menuBtns[i].addActionListener(this);
		}
		menuBtns[0].setText("MAIN MENU");
		menuBtns[1].setText("1. Register a Complaint");
		menuBtns[2].setText("2. Status of Complaint");
		menuBtns[3].setText("3. Check Complaint Filed");
		menuBtns[4].setText("4. Report");
		menuBtns[0].setEnabled(false);
		win.setVisible(true);
    }

    @Override
	public void actionPerformed(ActionEvent e) {
		if (menuBtns[1] == e.getSource()) {
			compRegister(cFile);
		} else if (menuBtns[2] == e.getSource()) {
			compStatus(cFile);
		} else if (menuBtns[3] == e.getSource()) {
			String pwdEntered = JOptionPane.showInputDialog(win, "Enter Password : ");
			if (pwdEntered == null) {
				// do nothing
			} else if (pwdEntered.equals(password)) {
				compCheck();
			} else {
				JOptionPane.showMessageDialog(win, "Wrong password");
			}
		} else if (menuBtns[4] == e.getSource()) {
			compReport(cFile);
		}
	}
    
	@Override
	public void windowClosing(WindowEvent e) {
        win.dispose();
	}
    
	@Override
	public void windowClosed(WindowEvent e) {
        cFile.exit();
	}

    public void compRegister(compFile cFile){
        Register = new compRegister(cFile);
    }
    public void compStatus(compFile cFile){
        Status = new compStatus(cFile);
    }
    public void compCheck(){
        Check = new compCheck();
    }
    public void compReport(compFile cFile){
        Report = new compReport(cFile);
    }

    @Override
    public void windowOpened(WindowEvent e) {}

	@Override
	public void windowIconified(WindowEvent e) {}

	@Override
	public void windowDeiconified(WindowEvent e) {}

	@Override
	public void windowActivated(WindowEvent e) {}

	@Override
	public void windowDeactivated(WindowEvent e) {}

}
