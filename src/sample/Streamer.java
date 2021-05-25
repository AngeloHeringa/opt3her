package sample;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Streamer {
    private String name;
    private String wachtwoord;
    private boolean verifiedId;
    private LocalDate birthDay;
    private ArrayList<Video> videos;
    public static ArrayList<Streamer> streamers = new ArrayList<>();

    public Streamer(String name, Date birthDay) {
        this.name = name;
        this.birthDay = LocalDate.of(birthDay.getYear(), birthDay.getMonth(), birthDay.getDay());
    }

    public void addVideo(String title){
        this.videos.add(new Video(title));
    }

    public static ArrayList<Streamer> getStreamers() {
        return streamers;
    }

    private Streamer(String name, String wachtwoord, LocalDate birthDay, boolean verifiedId) {
        this.name = name;
        this.wachtwoord = wachtwoord;
        this.verifiedId = verifiedId;
        this.birthDay = birthDay;
    }

    public int getDif(){
        Period delta = Period.between(birthDay, LocalDate.now());
        return delta.getYears();
    }


    public String getName() {
        return name;
    }

    public static boolean nieuweStreamer(String name, String wachtwoord, LocalDate birthday, boolean verifiedId){
        Streamer streamer = new Streamer(name, wachtwoord, birthday, verifiedId);

        for (Streamer it : streamers) {
            if (it.getName().equals(name)) {
                return false;
            }
        }

        boolean wachtwoordCheck = wachtwoord.length()>6&&wachtwoord.length()<18;
        boolean result = wachtwoordCheck&&streamer.getDif()>=16;

        if (result){
            streamers.add(streamer);
        }

        return result;
    }
}
