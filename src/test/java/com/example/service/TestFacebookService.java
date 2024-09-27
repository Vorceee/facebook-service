package com.example.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestFacebookService {

    @Test
    public void testValidProfileWithFriends() {
        FacebookService service = new FacebookService();
        String profileLink = "https://www.facebook.com/profile.php?id=100012129017450";
        String[] friends = service.getFriendList(profileLink);

        assertNotNull(friends);
        assertEquals(5, friends.length);
        assertArrayEquals(new String[]{"Alice", "Bob", "Charlie", "David", "Eve"}, friends);
    }

    @Test
    public void testValidProfileNoFriends() {
        FacebookService service = new FacebookService();
        String profileLink = "https://www.facebook.com/nofriends";
        String[] friends = service.getFriendList(profileLink);

        assertNotNull(friends);
        assertEquals(0, friends.length);
    }

    @Test
    public void testProfileNotFound() {
        FacebookService service = new FacebookService();
        String profileLink = "https://www.facebook.com/unknownprofile";

        assertThrows(IllegalArgumentException.class, () -> {
            service.getFriendList(profileLink);
        });
    }

    @Test
    public void testNullProfileLink() {
        FacebookService service = new FacebookService();
        
        assertThrows(IllegalArgumentException.class, () -> {
            service.getFriendList(null);
        });
    }

    @Test
    public void testEmptyProfileLink() {
        FacebookService service = new FacebookService();
        
        assertThrows(IllegalArgumentException.class, () -> {
            service.getFriendList("");
        });
    }
}
