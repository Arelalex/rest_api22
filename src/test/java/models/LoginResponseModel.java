package models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class LoginResponseModel {

    String userId;
    String username;
    String password;
    String token;
    String expires;
    String isActive;

    @JsonProperty("created_date")
    String createdDate;

}
