import java.io.Serializable;

@SuppressWarnings("serial")
public class Complaint implements Serializable{
    String department;
    int complainNo;
    String complaint;
    String solution;

    public Complaint(String department, int complainNo, String complaint, String solution) {
        this.department = department;
        this.complainNo = complainNo;
        this.complaint = complaint;
        this.solution = solution;
    }

    @Override
    public String toString(){
        return "Department: " + department + "\n" +
                "Complaint No: " + complainNo + "\n" +
                "Complaint: " + complaint + "\n" +
                "Solution: " + solution + "\n";
    }
}
