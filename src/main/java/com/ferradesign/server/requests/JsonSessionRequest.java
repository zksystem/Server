package com.ferradesign.server.requests;


import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

public class JsonSessionRequest {
    @Getter @Setter
    public String login;
    @Getter @Setter
    public UUID sessionId;

    public JsonSessionRequest(String login, UUID uuid) {
        this.login = login;
        this.sessionId = uuid;
    }
}
