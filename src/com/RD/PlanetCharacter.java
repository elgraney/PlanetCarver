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

    public PlanetCharacter(BufferedImage skin){

        this.skin = setColour(skin);

        try {
            ImageIO.write(this.skin, "png", new File("colour test.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
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
