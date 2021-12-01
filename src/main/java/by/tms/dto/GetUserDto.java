package by.tms.dto;

import javax.validation.constraints.NotBlank;

public class GetUserDto {

    @NotBlank(message = "Empty field'")
    private String username;

    @NotBlank(message = "Empty field")
    private String password;

    public GetUserDto(String username, String password) {
        this.username = username;
        this.password = password;
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
}
