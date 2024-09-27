package com.example.service;

public class FacebookService {

    // Simulated method for fetching the list of friends
    public String[] getFriendList(String profileLink) {
        if (profileLink == null || profileLink.isEmpty()) {
            throw new IllegalArgumentException("Profile link cannot be null or empty");
        }

        if (profileLink.equals("https://www.facebook.com/profile.php?id=100012129017450")) {
            return new String[]{"Alice", "Bob", "Charlie", "David", "Eve"};
        } else if (profileLink.equals("https://www.facebook.com/nofriends")) {
            return new String[]{};
        } else {
            throw new IllegalArgumentException("Profile not found");
        }
    }
}
