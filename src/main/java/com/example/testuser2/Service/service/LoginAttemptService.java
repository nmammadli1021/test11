package com.example.testuser2.Service.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class LoginAttemptService {

    private static final int MAX_ATTEMPTS = 5;
    private static final long LOCK_DURATION = 30 * 1000; //

    private Map<String, Integer> attempts = new HashMap<>();
    private Map<String, Long> lockTimes = new HashMap<>();

    public Boolean loginFailed(String email) {
        int attemptsCount = attempts.getOrDefault(email, 0);
        attempts.put(email, attemptsCount + 1);

        if (attemptsCount + 1 >= MAX_ATTEMPTS) {
            lockAccount(email);
        }
        return true;
    }

    public boolean isAccountLocked(String username) {
        Long lockTime = lockTimes.get(username);
        if (lockTime == null) {
            return false;
        }

        long currentTime = System.currentTimeMillis();
        return currentTime - lockTime < LOCK_DURATION;
    }

    private void lockAccount(String username) {
        lockTimes.put(username, System.currentTimeMillis());
        attempts.remove(username);
    }

    public void resetFailedAttempts(String username) {
        attempts.remove(username);
        lockTimes.remove(username);
    }
}