package com.ferradesign.server.dao;

import com.ferradesign.server.requests.JsonSessionRequest;
import lombok.Synchronized;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Repository
public class SessionsRepository {

    public static Map<String, UUID> sessionsMap;

    static {
        sessionsMap = new HashMap<>();
    }

    @Synchronized
    public JsonSessionRequest getSessionId(String login) {
        if (sessionsMap != null && sessionsMap.containsKey(login)) {
            return new JsonSessionRequest(login, sessionsMap.get(login));
        }
        UUID uniqueID = UUID.randomUUID();
        sessionsMap.put(login, uniqueID);

        return new JsonSessionRequest(login, sessionsMap.get(login));
    }

    @Synchronized
    public Boolean isValidSessionId(String sessionId) {
        if (sessionId != null && sessionsMap != null) {
            try {
                return sessionsMap.containsValue(UUID.fromString(sessionId));
            } catch (IllegalArgumentException e) {
                return false;
            }
        }
        return false;
    }

    @Synchronized
    public void removeSessionId(String login) {
        sessionsMap.remove(login);
    }


}
