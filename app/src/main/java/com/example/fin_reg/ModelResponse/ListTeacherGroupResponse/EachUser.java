package com.example.fin_reg.ModelResponse.ListTeacherGroupResponse;

public class EachUser {
    int id;
    String username, usersurname, email, organization;

    public EachUser(int id, String username, String usersurname, String email, String organization){
        this.id = id;
        this.username = username;
        this.usersurname = usersurname;
        this.email = email;
        this.organization = organization;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsersurname() {
        return usersurname;
    }

    public void setUsersurname(String usersurname) {
        this.usersurname = usersurname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }
}
