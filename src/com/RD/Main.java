package com.RD;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.Buffer;

public class Main {

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("Test canvas.png"));
            BufferedImage returnedImg = PlanetCarver.carve(img,500);
            /*
            ImageIO.write(returnedImg, "png", new File("New Sam's Face1.png"));


            returnedImg = PlanetCarver.carve(img,1000);
            ImageIO.write(returnedImg, "png", new File("New Sam's Face2.png"));
            returnedImg = PlanetCarver.carve(img,1000);
            ImageIO.write(returnedImg, "png", new File("New Sam's Face3.png"));
            returnedImg = PlanetCarver.carve(img,1000);
            ImageIO.write(returnedImg, "png", new File("New Sam's Face4.png"));
            returnedImg = PlanetCarver.carve(img,1000);
            ImageIO.write(returnedImg, "png", new File("New Sam's Face5.png"));
            returnedImg = PlanetCarver.carve(img,1000);
            ImageIO.write(returnedImg, "png", new File("New Sam's Face6.png"));
            returnedImg = PlanetCarver.carve(img,1000);
            ImageIO.write(returnedImg, "png", new File("New Sam's Face7.png"));
            returnedImg = PlanetCarver.carve(img,1000);
            ImageIO.write(returnedImg, "png", new File("New Sam's Face8.png"));
            returnedImg = PlanetCarver.carve(img,1000);
            ImageIO.write(returnedImg, "png", new File("New Sam's Face9.png"));
            returnedImg = PlanetCarver.carve(img,1000);
            ImageIO.write(returnedImg, "png", new File("New Sam's Face10.png"));
            */


            PlanetCharacter testPlanet = new PlanetCharacter(10000, 'f');
            long endTime   = System.nanoTime();
            long totalTime = endTime - startTime;
            System.out.println(totalTime);

        } catch (IOException e) {
        }
    }
}
