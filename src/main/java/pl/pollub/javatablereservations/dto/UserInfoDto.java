package pl.pollub.javatablereservations.dto;

import pl.pollub.javatablereservations.session.UserInfo;

import java.util.UUID;

public class UserInfoDto {

    private final UUID id;
    private final String name;

    public UserInfoDto(UserInfo userInfo) {
        this.id = userInfo.getUserId();
        this.name = userInfo.getName();
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
