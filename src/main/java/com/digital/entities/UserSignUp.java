package com.digital.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserSignUp {
    @JsonProperty("first_name")
   private String firstName;
    @JsonProperty("last_name")
   private String lastName;
   private String email;
   private String login;
   private String password;
}
