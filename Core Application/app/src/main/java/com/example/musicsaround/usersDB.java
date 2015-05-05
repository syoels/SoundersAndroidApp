package com.example.musicsaround;

import android.util.Log;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by raazherzberg on 4/8/15.
 */
public class usersDB {
    static User r = new User("raazh", "raaz.herzberg@gmail.com", "passr");
    static User n = new User("noamp", "noam.palombo@gmail.com", "passn");
    static User o = new User("omerz", "omer.zacks@gmail.com", "passo");
    static User y = new User("yoels", "yoel.simch@gmail.com", "passy");
    private Map<String, User> users = new HashMap<String, User>();
    private Map<String, User> devices = new HashMap<String, User>();

    public usersDB(){
        r.setAbout("23, CS student");
        r.setStationName("Tired morning..");
        r.setStationIcon("station_01");
        n.setAbout("24, Climber, enjoy listening non-stop to Uptown Funk");
        n.setStationName("Yow hommies!!11..");
        n.setStationIcon("station_02");
        o.setAbout("25, CS second year student, into Rock music and oldies");
        o.setStationName("Celebrate summer");
        o.setStationIcon("station_04");
        y.setAbout("26, mostly into pop music");
        y.setStationName("no hurry here :)");
        y.setStationIcon("station_05");
        // Create users DB Map
        users.put("raazh", r);
        users.put("noamp", n);
        users.put("omerz", o);
        users.put("yoels", y);
        devices.put("Raaz",r);
        devices.put("XT1095_9a98",n);
        devices.put("Omer_Z",o);
        devices.put("Android_93c0",y);
        // Add user pics
        r.setUserPic("raaz");
        n.setUserPic("noam");
        o.setUserPic("omer");
        y.setUserPic("yoel");
    }

    public  Map<String, User> getUsersMap(){
        return this.users;
    }

    // Returns a user by username
    public User getUser(String username){
        return users.get(username);
    }

    // Returns a user by devicename
    public User getUserbyDevice(String deviceName){

        //if no device
        if (deviceName == null) {
            Log.i("usersDB","tried to fetch User with NULL devicename");
            return null;
        }
        return devices.get(deviceName);
    }
}

