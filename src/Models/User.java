package Models;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Random;

public class User {
    private String id;
    private String name;
    private String country;
    private String email;
    private boolean banned;
    private ArrayList<String> warnings;
    private String password;

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

    public User(String name, String country, String email, String password) {
        byte[] array = new byte[7];
        new Random().nextBytes(array);
        this.id = new String(array, StandardCharsets.UTF_8);
        this.name = name;
        this.country = country;
        this.email = email;
        this.banned = false;
        this.warnings = new ArrayList<>();
        this.password = password;
        System.out.println(this.id);
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
