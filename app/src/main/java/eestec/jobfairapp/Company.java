package eestec.jobfairapp;

/**
 * Created by XMAN on 5.10.2016.
 */
public class Company {

    String name;
    String email;
    String web;

    public Company(String name, String email, String web) {
        super();
        this.name = name;
        this.email = email;
        this.web = web;
    }

    public Company() { super(); }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }
}
