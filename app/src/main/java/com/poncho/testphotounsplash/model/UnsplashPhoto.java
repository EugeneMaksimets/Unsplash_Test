package com.poncho.testphotounsplash.model;

public class UnsplashPhoto {
    private Urls urls;
    private User user;
    private String alt_description;

    public String getAltDescription() {
        return alt_description;
    }

    public Urls getUrls() {
        return urls;
    }

    public User getUser() {
        return user;
    }

    public static class User {
        private String name;

        public String getName() {
            return name;
        }
    }

    public static class Urls {
        private String full;
        private String small;

        public String getFull() {
            return full;
        }

        public String getSmall() {
            return small;
        }
    }

}