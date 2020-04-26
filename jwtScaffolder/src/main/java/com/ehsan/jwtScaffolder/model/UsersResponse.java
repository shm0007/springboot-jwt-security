package com.ehsan.jwtScaffolder.model;

import com.ehsan.jwtScaffolder.domain.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UsersResponse {
    private List<User> users;
}
