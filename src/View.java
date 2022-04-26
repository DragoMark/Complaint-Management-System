import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class View {
    // private JFrame win;
	// private JButton menuBtns[];
	// private final String password = "fuckroot@123";
    compRegister Register;
    compStatus Status;
    compCheck Check;
    compReport Report;

    public View(compFile cFile){
        // win = new JFrame();
        // win.setTitle("Complaint Box");
        // win.setSize(500, 600);
        // win.addWindowListener(this);
        // win.setLayout(new GridLayout(5, 1));

        // menuBtns = new JButton[5];
        // for (int i = 0; i < menuBtns.length; ++i) {
        //     menuBtns[i] = new JButton();
        //     win.add(menuBtns[i]);
        //     menuBtns[i].addActionListener(this);
        // }
        // menuBtns[0].setText("MAIN MENU");
        // menuBtns[1].setText("1. Register a Complaint");
        // menuBtns[2].setText("2. Status of Complaint");
        // menuBtns[3].setText("3. Check Complaint Filed");
        // menuBtns[4].setText("4. Report");
        // menuBtns[0].setEnabled(false);
        // win.setVisible(true);

        // Register = new compRegister(cFile);
        // Status = new compStatus(cFile);
        // Check = new compCheck(cFile);
        // Report = new compReport(cFile);
    }
    public void compRegister(compFile cFile){
        Register = new compRegister(cFile);
    }
    public void compStatus(compFile cFile){
        Status = new compStatus(cFile);
    }
    public void compCheck(compFile cFile){
        Check = new compCheck(cFile);
    }
    public void compReport(compFile cFile){
        Report = new compReport(cFile);
    }


}
