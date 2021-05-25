package test;

import org.junit.Before;
import org.junit.Test;
import sample.Streamer;

import java.time.LocalDate;

import static org.junit.Assert.*;


public class NieuweStreamer {
    String bestaandeNaam = "bestaatAl";

    LocalDate wel16=LocalDate.of(1999,10,24);
    LocalDate niet16 = LocalDate.of(2020,10,24);

    String teKortWachtwoord = "123456";
    String goedWachtwoord = "1234567";

    String naam = "nieuweNaam";
    int i=0;
    public String getNieuweNaam(){
        i++;
        return naam+i;
    }

    @Before
    public void init(){
        Streamer.nieuweStreamer(bestaandeNaam, goedWachtwoord, wel16, true);
    }

    @Test
    public void nieuweStreamerTest(){

        //verifiedIf is altijd true omdat het niet uitmaakt voor de return value
        assertTrue(Streamer.nieuweStreamer(getNieuweNaam(), goedWachtwoord, wel16, true));
        assertFalse(Streamer.nieuweStreamer(getNieuweNaam(), teKortWachtwoord, wel16, true));
        assertFalse(Streamer.nieuweStreamer(getNieuweNaam(), goedWachtwoord, niet16, true));
        assertFalse(Streamer.nieuweStreamer(bestaandeNaam, goedWachtwoord, wel16, true));


    }
}
