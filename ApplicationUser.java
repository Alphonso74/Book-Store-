package mobyDickensBookStore.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class ApplicationUser {

    //
    //
    protected Integer id;
    protected String username;
    protected String password;
    protected Boolean isAdmin;

    public ApplicationUser(Integer id, String userName, String password, Boolean isAdmin) {

        this.id = id;
        this.username= userName;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    public ApplicationUser() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getAdmin() {
        return isAdmin;
    }

    public void setAdmin(Boolean admin) {
        isAdmin = admin;
    }

    public Boolean getIsAdmin() {
        return isAdmin;
    }
}
