package Models;

import java.util.ArrayList;

public class ViewerState extends User {
    public ViewerState() {
    }

    public ViewerState(String name, String country, String email) {
        super(name, country, email);
    }

    public ViewerState(String id, String name, String country, String email, boolean banned, ArrayList<String> warnings) {
        super(id, name, country, email, banned, warnings);
    }

    public void becomeCreator() {}

    public void follow(Creator creator) {}

    public void subscribe(Creator creator) {}

    public void reportCreator(Creator creator) {}
}
