package Models;

public class Report {
    private String id;
    private User reporter;
    private User reportedUser;
    private String reportText;

    public Report(String id, User reporter, User reportedUser, String reportText) {
        this.id = id;
        this.reporter = reporter;
        this.reportedUser = reportedUser;
        this.reportText = reportText;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getReporter() {
        return reporter;
    }

    public void setReporter(User reporter) {
        this.reporter = reporter;
    }

    public User getReportedUser() {
        return reportedUser;
    }

    public void setReportedUser(User reportedUser) {
        this.reportedUser = reportedUser;
    }

    public String getReportText() {
        return reportText;
    }

    public void setReportText(String reportText) {
        this.reportText = reportText;
    }
}
