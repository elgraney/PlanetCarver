package com.RD;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by Matthew on 11/02/2018.
 */
public class PlanetCharacter {
    private BufferedImage skin;
    private int surfaceTemperature;
    public PlanetCharacter(int distance, char sunType){

        surfaceTemperature = calcSurfaceTemp(distance, sunType);

        this.skin = chooseSkin(distance, surfaceTemperature);
        try {
            ImageIO.write(this.skin, "png", new File("colour test.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private BufferedImage chooseSkin(int distance, int surfaceTemperature){
        //determine canvas to use
        //not testable yet so just import default
        try {
            BufferedImage img = ImageIO.read(new File("Test canvas.png"));
            BufferedImage skin =PlanetCarver.carve(img ,500);
            skin = setColour(skin);
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return skin;
    }

    private int calcSurfaceTemp(int distance, char sunType){
        int sunMod = 1;
        switch (sunType){
            case 's':
                sunMod =1;
                break;
            case 'o':
                sunMod =1;
                break;
            case 'b':
                sunMod =1;
                break;
            case 'a':
                sunMod =1;
                break;
            case 'f':
                sunMod =1;
                break;
            case 'g':
                sunMod =1;
                break;
            case 'k':
                sunMod =1;
                break;
            case 'm':
                sunMod =1;
                break;
            case 'd':
                sunMod =1;
                break;
        }


        int temp = (1/(distance*distance))*sunMod;
        return temp;
    }

    private BufferedImage setColour(BufferedImage skin){
        Color from = Color.decode("#FFFFFF"); //white
        Color to = new Color(0x008EEA, false);
        BufferedImageOp lookup = new LookupOp(new ColourMapper(from, to), null);
        BufferedImage convertedImage = lookup.filter(skin, null);

        from = Color.decode("#000000"); //black
        to = new Color(0x0EB600, false);
        lookup = new LookupOp(new ColourMapper(from, to), null);
        convertedImage = lookup.filter(convertedImage, null);

        from = Color.decode("#7F7F7F"); //grey
        to = new Color(9843455, false);
        lookup = new LookupOp(new ColourMapper(from, to), null);
        convertedImage = lookup.filter(convertedImage, null);

        return convertedImage;
    }
}