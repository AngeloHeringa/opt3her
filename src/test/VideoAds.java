package test;

import org.junit.Test;
import sample.Video;
import static org.junit.Assert.*;


public class VideoAds {

    @Test
    public void videoAdTest(){
        Video video =  new Video("title");

        assertEquals(0, (int) video.maxAds(2, true, true, true));
        assertEquals(0, (int) video.maxAds(2,false,false,false));

        assertEquals(1, (int) video.maxAds(10,true,false,false));
        assertEquals(0, (int) video.maxAds(10,false,true,true));

        assertEquals(0, (int) video.maxAds(30,true,false,true));
        assertEquals(0, (int) video.maxAds(30,false,true,false));

    }

    @Test
    public void adRevenueTest(){
        Video video =  new Video("title");

        assertEquals(1,(int)video.maxAds(10, true, false, false));
        video.setAds(video.maxAds(10, true, false, false)); //ads=1

        video.setViews(0);
        assertEquals((double) 0, video.getAdRevenue(), 0.0001);
        video.setViews(1);
        assertEquals((double) 0, video.getAdRevenue(), 0.0001);
        video.setViews(999);
        assertEquals((double) 0, video.getAdRevenue(), 0.0001);
        video.setViews(1000);
        assertEquals(50d, video.getAdRevenue(), 0.0001);
        video.setViews(1001);
        assertEquals(50.05, video.getAdRevenue(), 0.0001);
        video.setViews(99999);
        assertEquals(4999.95, video.getAdRevenue(), 0.0001);
        video.setViews(100000);
        assertEquals(5000d, video.getAdRevenue(), 0.0001);
        video.setViews(100001);
        assertEquals(5000.025, video.getAdRevenue(), 0.0001);
    }
}
