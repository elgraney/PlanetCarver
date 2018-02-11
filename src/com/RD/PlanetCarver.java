package com.RD;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * Created by Matthew on 10/02/2018.
 */
public class PlanetCarver {

    public static BufferedImage carve(BufferedImage canvas, int diameter){
        int w = canvas.getWidth();
        int h = canvas.getHeight();

        Random rand = new Random();
        int x = (rand.nextInt(w-(diameter)));
        int y = (rand.nextInt(h-(diameter)));

        BufferedImage reducedCanvas = canvas.getSubimage(x, y, diameter, diameter );

        BufferedImage output = new BufferedImage(diameter, diameter, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2 = output.createGraphics();

        g2.setComposite(AlphaComposite.Src);

        g2.setColor(Color.WHITE);
        //height, width, x, y
        g2.fill(new Ellipse2D.Double(0, 0, diameter, diameter));
        g2.setComposite(AlphaComposite.SrcAtop);
        g2.drawImage(reducedCanvas, 0,  0, null);

        g2.dispose();

        return output;
    }



}
