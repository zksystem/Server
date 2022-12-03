package com.ferradesign.server.requests;

import lombok.Getter;

public class JsonLoginRequest {
    @Getter
    String login;
    @Getter
    String password;
}
