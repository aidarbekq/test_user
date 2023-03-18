package ts.user.test_user.dto;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class AuthDto {

    @NotBlank(message = "Email field is required")
    @Email(message = "Invalid email")
    private String email;

    @NotBlank(message = "Password is required")
    private String password;

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
