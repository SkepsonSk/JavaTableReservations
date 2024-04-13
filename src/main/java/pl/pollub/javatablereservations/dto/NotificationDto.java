package pl.pollub.javatablereservations.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NotificationDto {

    @JsonProperty(value = "user_id")
    private String userId;

    private String title;
    private String body;

    public String getUserId() {
        return userId;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }
}
