// import java.awt.event.WindowEvent;
// import java.awt.event.WindowListener;
// import javax.swing.JFrame;
// import javax.swing.JOptionPane;
import javax.swing.JTable;


public class Controller{
	private compFile cFile;
	private final String password = "root";
	private Controller controller;

    View launcher;

	public Controller() {
		String tmpPath = System.getProperty("java.io.tmpdir");
        cFile = new compFile(tmpPath + "comps.txt");
	}

	public void boot(){
		controller = new Controller();
		launcher = new View(cFile, password, controller);
	}

	public void acceptRegister(Complaint newComplaint){
		cFile.addComp(newComplaint);
		cFile.updateTotalComps();
		// JOptionPane.showMessageDialog(null, newComplaint);
	}

	public int getCurrentComplaint(){
		return cFile.totalComps + 1;
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
		// System.out.println(complaintNo);
		return cFile.getSoln(complaintNo);
	}

     
}
