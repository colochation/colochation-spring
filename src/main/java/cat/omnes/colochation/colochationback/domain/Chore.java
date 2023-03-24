package cat.omnes.colochation.colochationback.domain;

public class Chore {
    public final String title;
    public final String status;
    public final String assigned;

    public Chore(String title, String status, String assigned) {
        this.title = title;
        this.status = status;
        this.assigned = assigned;
    }
}
