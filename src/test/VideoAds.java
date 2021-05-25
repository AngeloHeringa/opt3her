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
}
