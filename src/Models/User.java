package Models;

import java.util.ArrayList;

public class User {
    private String id;
    private String name;
    private String country;
    private String email;
    private boolean banned;
    private ArrayList<String> warnings;

    public User() {
    }

    public User(String name, String country, String email) {
        this.name = name;
        this.country = country;
        this.email = email;
        this.banned = false;
        this.warnings = new ArrayList<>();
    }

    public User(String id, String name, String country, String email, boolean banned, ArrayList<String> warnings) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.email = email;
        this.banned = banned;
        this.warnings = warnings;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isBanned() {
        return banned;
    }

    public void setBanned(boolean banned) {
        this.banned = banned;
    }

    public ArrayList<String> getWarnings() {
        return warnings;
    }

    public void setWarnings(ArrayList<String> warnings) {
        this.warnings = warnings;
    }

    public void addWarning(String warning) {
        this.warnings.add(warning);
    }
}
