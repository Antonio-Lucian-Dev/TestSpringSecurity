package com.asusoftware.testSecurity.model.dto;

import com.asusoftware.testSecurity.model.UserRole;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class UserDto {

   @NotBlank
   private String username;
   @NotBlank
    private String password;
   @NotNull
   @Enumerated(EnumType.STRING)
    private UserRole userRole;
}
