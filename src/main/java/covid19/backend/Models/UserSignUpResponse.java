package covid19.backend.Models;

public class UserSignUpResponse {

    private String uuid;
    private String email;

    public UserSignUpResponse() {
    }

    public UserSignUpResponse(String uuid, String email) {
        this.uuid = uuid;
        this.email = email;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}