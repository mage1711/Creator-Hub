package Models;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Random;

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
        byte[] array = new byte[7]; // length is bounded by 7
        new Random().nextBytes(array);
        String generatedString = new String(array, Charset.forName("UTF-8"));
        this.id = generatedString;
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
}
