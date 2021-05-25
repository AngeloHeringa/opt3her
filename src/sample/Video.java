package sample;

import java.time.LocalDateTime;

public class Video {
    private final String title;

    public Video(String title) {
        this.title = title;
    }

    public Integer maxAds(int minutes, boolean isVerified, boolean featured, boolean explicitContent){
        if (!isVerified||explicitContent){
            return 0;
        }else if (minutes>=30){
            return featured?4:2;
        }else if (minutes>=10){
            return featured?2:1;
        }else return 0;
    }
}

