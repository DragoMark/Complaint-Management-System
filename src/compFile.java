import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;

public class compFile {
	private String compFName;
	int totalComps;
	private List<Complaint> compList;

	public compFile(String compFName) {
		this.compFName = compFName;
		initList();
		this.totalComps = compList.size();
	}

	private void initList() {
		compList = new ArrayList<>();
		File f = new File(compFName);
		if (f.exists()) {
			ObjectInputStream ois = null;
			try {
				ois = new ObjectInputStream(new FileInputStream(compFName));
				while (true) {
					compList.add((Complaint) ois.readObject());
				}
			} catch (EOFException eof) {
				if (ois != null) {
					try {
						ois.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void addComp(Complaint comp) {
		compList.add(comp);
		this.totalComps++;
	}

	public void addSoln(int cNo, String soln) throws Exception {
		addSoln(cNo, soln, false);
	}

	public void overwriteSoln(int cNo, String soln) {
		try {
			addSoln(cNo, soln, true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void addSoln(int complaintNo, String solution, boolean overWrite) throws Exception {
		Complaint comp = getComp(complaintNo);
		if (comp.solution.isEmpty() || overWrite) {
			Complaint newComp = new Complaint(comp.department, comp.complaintNo, comp.complaint, solution);
			remove(comp);
			addComp(newComp);
		} else if (!comp.solution.isEmpty()) {
			throw new Exception("Solution Already Exists");
		}
	}

	public String getSoln(int complaintNo) {
		Complaint comp = getComp(complaintNo);
		if (comp != null) {
			return comp.solution;
		}
		return null;
	}

	public boolean findComp(int complaintNo) {
		return getComp(complaintNo) != null;
	}

	private Complaint getComp(int complaintNo) {
		for (Complaint comp : compList) {
			if (comp.complaintNo == complaintNo) {
				return comp;
			}
		}
		return null;
	}

	private void remove(Complaint compTbr) {
		compList.remove(compTbr);
	}

	public JTable returnTable() {
		JTable table;
		Object columnNames[] = { "C.No.", "Department", "Complaint", "Solution" };
		Object rowData[][] = new Object[totalComps][columnNames.length];
		int i = 0;
		for (Complaint comp : compList) {
			rowData[i][0] = comp.complaintNo;
			rowData[i][1] = comp.department;
			rowData[i][2] = comp.complaint;
			rowData[i][3] = comp.solution;
			++i;
		}
		table = new JTable(rowData, columnNames);
		return table;
	}

	public void exit() {
		try {
			FileWriter fw = new FileWriter(compFName);
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(compFName));
			oos.flush();
			for (Complaint comp : compList) {
				oos.writeObject(comp);
				oos.flush();
			}
			oos.close();
			fw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.exit(0);
	}
}
