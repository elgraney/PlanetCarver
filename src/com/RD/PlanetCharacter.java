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
    private int size;
    private int type;
    private ColourPalette colourPalet;
    public PlanetCharacter(int distance, char sunType){

        //1. temp
        surfaceTemperature = (int) calcSurfaceTemp(distance, sunType);
        //2. planet size
        size = calcSize(distance);
        //3. planet type
        type = chooseType(distance, surfaceTemperature);
        //4. planet colour
        colourPalet = choosePalette(surfaceTemperature, type);
        //5. planet POIs
        this.skin = chooseSkin(distance, surfaceTemperature);
        try {
            ImageIO.write(this.skin, "png", new File("colour test.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //also include planet type? (continents would be icey, but gas would be hot colour)
    private ColourPalette choosePalette(int surfaceTemperature, int type){
        ColourPalette palette = new ColourPalette(Color.decode("#0F0000"),Color.decode("#FF0000"),
                Color.decode("#FFFF00"),Color.decode("#00FFFF"),Color.decode("#FF00FF"));
        if(surfaceTemperature < 100){

        }
        else if( 100 <= surfaceTemperature && surfaceTemperature<200){

        }

        return palette;
    }

    private int calcSize(int distance){

        int[] values = {1, 2, 3, 4, 5, 6};//babby rock, Mercury, Earth, neptune, Saturn, Jupiter
        int[] chance;

        if (distance < 100000) {//0 to 100,000
            chance = new int[]{40, 20, 10, 10, 5, 5};
        } else if (distance >= 100000 && distance < 1000000) {//100,000 to 1,000,000
            chance = new int[]{20, 20, 30, 10, 20, 10};
        } else if (distance >= 1000000 && distance < 2500000) {//1,000,000 to 2,500,000
            chance = new int[]{10, 20, 30, 10, 20, 10};
        } else if (distance >= 2500000 && distance < 5000000) {//2,500,000 to 5,000,000
            chance = new int[]{10, 20, 30, 10, 20, 10};
        } else if (distance >= 5000000 && distance < 7500000) {//5,000,000 to 7,500,000
            chance = new int[]{10, 20, 30, 10, 20, 10};
        } else {
            chance = new int[]{10, 20, 30, 10, 20, 10};//7,500,000 to 10,000,000 onwards
        }
        int returnValue = DRV.discreteRV(values, chance);

        return returnValue;
    }

    private BufferedImage chooseSkin(int distance, int surfaceTemperature){
        //determine canvas to use
        //not testable yet so just import default
        BufferedImage newSkin=null;
        try {
            BufferedImage img = ImageIO.read(new File("Archipelago.png"));
            newSkin =PlanetCarver.carve(img, 1000);
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
        to = new Color(0x1B9532, false);
        lookup = new LookupOp(new ColourMapper(from, to), null);
        convertedImage = lookup.filter(convertedImage, null);

        return convertedImage;
    }
}