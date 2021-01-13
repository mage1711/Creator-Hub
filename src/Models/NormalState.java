package Models;

import java.util.ArrayList;

public class NormalState extends ViewerState {
    public NormalState() {
    }

    public NormalState(String name, String country, String email) {
        super(name, country, email);
    }

    public NormalState(String id, String name, String country, String email, boolean banned, ArrayList<String> warnings) {
        super(id, name, country, email, banned, warnings);
    }

    public void follow(Creator creator) {}

    public void subscribe(Creator creator) {}
}
