package sample;

import java.time.LocalDateTime;

public class Video {
    private final String title;
    private int ads;
    private int views;

    public int getAds() {
        return ads;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public Video(String title) {
        this.title = title;
        ads=0;
    }

    public void setAds(int ads) {
        this.ads = ads;
    }

    public Double getAdRevenue(){
        if (views>=1000&&views<100000){
            return (ads * views)*0.05;
        }else if (views >= 100000){
            return (ads * 100000+((views-100000)*0.5))*0.05;
        }
        return 0D;
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

