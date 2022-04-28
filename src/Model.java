public class Model {



    
    // private ArrayList<Complaint> compList;
    // private int totalComps;

    // public Model() {
    //     compList = new ArrayList<Complaint>();
    //     totalComps = 0;
    // }

    // public void addComp(Complaint comp) {
    //     compList.add(comp);
    //     totalComps++;
    // }

    // public void addSoln(int cNo, String soln) throws Exception {
    //     addSoln(cNo, soln, false);
    // }

    // public void overwriteSoln(int cNo, String soln) {
    //     try {
    //         addSoln(cNo, soln, true);
    //     } catch (Exception e) {
    //         e.printStackTrace();
    //     }
    // }

    // private void addSoln(int complaintNo, String solution, boolean overWrite) throws Exception {
    //     Complaint comp = getComp(complaintNo);
    //     if (comp.solution.isEmpty() || overWrite) {
    //         Complaint newComp = new Complaint(comp.department, comp.complaintNo, comp.complaint, solution);
    //         remove(comp);
    //         addComp(newComp);
    //     } else if (!comp.solution.isEmpty()) {
    //         throw new Exception("Solution Already Exists");
    //     }
    // }

    // public String getSoln(int complaintNo) {
    //     Complaint comp = getComp(complaintNo);
    //     if (comp != null) {
    //         return comp.solution;
    //     }
    //     return null;
    // }

    // public boolean findComp(int complaintNo) {
    //     return getComp(complaintNo) != null;
    // }

    // private Complaint getComp(int complaintNo) {
    //     for (Complaint comp : compList) {
    //         if (comp.complaintNo == complaintNo) {
    //             return comp;
    //         }
    //     }
    //     return null;
    // }

    // private void remove(Complaint compTbr) {
    //     compList.remove(compTbr);
}
