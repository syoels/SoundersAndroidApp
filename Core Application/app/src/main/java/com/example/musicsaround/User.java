package com.example.musicsaround;

import java.util.ArrayList;

/**
 * Created by raazherzberg on 4/8/15.
 */
public class User {
    private String username;
    private String email;
    private String password = "";
    private String about = "";
    private String currStationName = "Hellooo Sounders :)"; //default status
    private String currStationIconFileName = "station_03.png"; //default icon
    private String userPic = ""; //default icon
    private String UserDeviceName;
    private ArrayList<String> followersArr=new ArrayList<String>();
    private ArrayList<String> followingArr=new ArrayList<String>();

    // Initial constructor
    public User(String username, String email, String password){
        this.username = username;
        this.email = email;
        this.password = password;
    }

    //setters
    public void setUserPic(String userPic) {
        this.userPic = userPic;
    }
    public void setAbout(String about) {
        this.about = about;
    }
    public void setStationName(String stationName) {
        this.currStationName = stationName;
    }
    public void setStationIcon(String stationIcon) {
        this.currStationIconFileName = stationIcon;
    }
    public void setDeviceName(String deviceName) { this.UserDeviceName = deviceName; }

    //getters
    public String getUserPic() {
        return this.userPic;
    }

    public String getAbout() {
        return this.about;
    }
    public String getStationName() {return this.currStationName;    }
    public String getStationIcon() {
        return this.currStationIconFileName;
    }
    public String getUsername() {return this.username;  }
    public String getPassword() {
        return this.password;
    }
    public String getDeviceName() {return this.UserDeviceName; }

    // Adds a follower to the users list of followers
    public void addFollower(String followerUsername) {
        followersArr.add(followerUsername);
    }

    // Removes a follower from the users list of followers
    public void removeFollower(String followerUsername) {
        followersArr.remove(followerUsername);
    }

    public ArrayList<String> getFollowersArray() {
        return this.followersArr;
    }

    // Adds someone this user is following to it's following list
    public void addFollowing(String followingUsername) {
        followingArr.add(followingUsername);
    }

    // Remove someone this user is following from it's following list
    public void removeFollowing(String followingUsername) {
        followingArr.remove(followingUsername);
    }

    public ArrayList<String> getFollowingArray() {
        return this.followingArr;
    }
}