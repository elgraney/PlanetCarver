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

        //1. temp
        surfaceTemperature = (int) calcSurfaceTemp(distance, sunType);
        //2. planet size
        //3. planet type
        //4. planet colour
        //5. planet POIs
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
        BufferedImage newSkin=null;
        try {
            BufferedImage img = ImageIO.read(new File("Continents V1 small.png"));
            newSkin =PlanetCarver.carve(img ,500);
            newSkin = setColour(newSkin);
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return newSkin;
    }

    private double calcSurfaceTemp(int distance, char sunType){
        int sunMod = 1;
        switch (sunType){
            case 's':
                sunMod =150;
                break;
            case 'o':
                sunMod =120;
                break;
            case 'b':
                sunMod =100;
                break;
            case 'a':
                sunMod =90;
                break;
            case 'f':
                sunMod =80;
                break;
            case 'g':
                sunMod =72;
                break;
            case 'k':
                sunMod =65;
                break;
            case 'm':
                sunMod =60;
                break;
            case 'd':
                sunMod =20;
                break;
        }


        double temp = -sunMod*Math.log(distance/ 10000000);
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

        from = Color.decode("#FF0000"); //red
        to = new Color(0xFF00DC, false);
        lookup = new LookupOp(new ColourMapper(from, to), null);
        convertedImage = lookup.filter(convertedImage, null);

        from = Color.decode("#00FF00"); //green
        to = new Color(0xFF8800, false);
        lookup = new LookupOp(new ColourMapper(from, to), null);
        convertedImage = lookup.filter(convertedImage, null);

        return convertedImage;
    }
}