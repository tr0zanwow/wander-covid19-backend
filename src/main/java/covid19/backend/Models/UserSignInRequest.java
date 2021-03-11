package covid19.backend.Models;

public class UserSignInRequest {
    private String email;
    private String password;

    public UserSignInRequest() {
    }

    public UserSignInRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getemail() {
        return email;
    }

    public void setemail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
