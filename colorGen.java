/**
 * Random Color Generator - Generator
 * Generates colors to an array to be parsed by output
 * @author Tach Lehman
 * @version 1.0 - February 17, 2022
 */
import java.awt.Color;
import java.util.concurrent.ThreadLocalRandom; 
import javax.swing.*;

public class colorGen
{
    /*
      generateColor is the primary method of colorGen, it receives a string with
    */
    public static Color[] generateColor(String colorName, int colorNum) 
    {
      Color colArr[] = new Color[colorNum]; //Array to be populated with random colors
      switch(colorName) //case for each colorName defined by main, adds colorNum colors to the array
      {
        case "Red":
          for(int i = 0; i < colorNum; i++)
          {
            colArr[i] = randomRed();
          }
          break;
        case "Orange":
          for(int i = 0; i < colorNum; i++)
          {
            colArr[i] = randomOrange();
          }
          break;
        case "Yellow":
          for(int i = 0; i < colorNum; i++)
          {
            colArr[i] = randomYellow();
          }
          break;
        case "Green":
          for(int i = 0; i < colorNum; i++)
          {
            colArr[i] = randomGreen();
          }
          break;
        case "Blue":
          for(int i = 0; i < colorNum; i++)
          {
            colArr[i] = randomBlue();
          }
          break;
        case "Violet":
          for(int i = 0; i < colorNum; i++)
          {
            colArr[i] = randomViolet();
          }
          break;
        case "Pink":
          for(int i = 0; i < colorNum; i++)
          {
            colArr[i] = randomPink();
          }
          break;
        case "Brown":
          for(int i = 0; i < colorNum; i++)
          {
            colArr[i] = randomBrown();
          }
          break;
        case "Grey":
          for(int i = 0; i < colorNum; i++)
          {
            colArr[i] = randomGrayscale();
          }
          break;
      }
      return colArr;
    }
  public static Color[] sortColors(Color[] colorArr)
  {
    if (colorArr.length > 1)
    {
    for (int i = 0; i < colorArr.length; i++)
    {
      for (int j = 0; j < colorArr.length-1; j++)
      {
        int peakRGBa = 0;
        int peakRGBb = 0;
        //find highest RGB value for colors being compared
        if (colorArr[j].getRed() > peakRGBa)
          peakRGBa = colorArr[j].getRed();
        if (colorArr[j].getGreen() > peakRGBa)
          peakRGBa = colorArr[j].getGreen();
        if (colorArr[j].getGreen() > peakRGBa)
          peakRGBa = colorArr[j].getGreen();
        if (colorArr[j+1].getRed() > peakRGBb)
          peakRGBb = colorArr[j+1].getRed();
        if (colorArr[j+1].getGreen() > peakRGBb)
          peakRGBb = colorArr[j+1].getGreen();
        if (colorArr[j+1].getGreen() > peakRGBb)
          peakRGBb = colorArr[j+1].getGreen();
        //check if a swap is needed
        if(peakRGBa > peakRGBb)
        {
          Color temp = colorArr[j];
          colorArr[j] = colorArr[j+1];
          colorArr[j+1] = temp;
        }
      }
    }
    }
    return colorArr;
  }
  
    //Below are methods for each color space that is to be generated
    private static Color randomRed()
    {
        int redVal = ThreadLocalRandom.current().nextInt(100, 255); //Generate red value, minimum 90, max 255 for best hue
        int greenVal = ThreadLocalRandom.current().nextInt(0, 50); //Generate greenvalue, maximum 40. High values produce a very faded red
        int blueVal;
        if (greenVal > 5) //Blue and green should not vary too much to maintain a nice red hue, generally blue should be less than green
            blueVal = greenVal - ThreadLocalRandom.current().nextInt(0,5);
        else
            blueVal = greenVal;
        Color genColor = new Color(redVal, greenVal, blueVal); //color for hex conversion
        return genColor;
    }
    private static Color randomOrange()
    {
        int redVal = ThreadLocalRandom.current().nextInt(160, 255); 
        int greenVal = ThreadLocalRandom.current().nextInt(60, 100); 
        int blueVal = ThreadLocalRandom.current().nextInt(0, 50);
        Color genColor = new Color(redVal, greenVal, blueVal);
        return genColor;
    }
    private static Color randomYellow()
    {
        int redVal = ThreadLocalRandom.current().nextInt(100, 255); 
        int greenVal = redVal; //Yellows have same red and green value
        int blueVal = ThreadLocalRandom.current().nextInt(0, 50);
        Color genColor = new Color(redVal, greenVal, blueVal); 
        return genColor;
    }
    private static Color randomGreen()
    {
        int redVal = ThreadLocalRandom.current().nextInt(0, 50);
        int greenVal = ThreadLocalRandom.current().nextInt(100, 255);
        int blueVal = ThreadLocalRandom.current().nextInt(0, 50);
        Color genColor = new Color(redVal, greenVal, blueVal); 
        return genColor;
    }
    private static Color randomBlue()
    {
        int redVal = ThreadLocalRandom.current().nextInt(0, 50);
        int greenVal = ThreadLocalRandom.current().nextInt(0, 50);
        int blueVal = ThreadLocalRandom.current().nextInt(100, 255);
        Color genColor = new Color(redVal, greenVal, blueVal);
        return genColor;
    }
    private static Color randomViolet()
    {
        int redVal = ThreadLocalRandom.current().nextInt(149, 170);
        int greenVal = ThreadLocalRandom.current().nextInt(0, 100);
        int blueVal = ThreadLocalRandom.current().nextInt(180, 255);
        Color genColor = new Color(redVal, greenVal, blueVal); 
        return genColor;
    }
    private static Color randomPink()
    {
        int redVal = ThreadLocalRandom.current().nextInt(149, 255);
        int greenVal = ThreadLocalRandom.current().nextInt(0, 149);
        int blueVal = redVal;
        Color genColor = new Color(redVal, greenVal, blueVal); 
        return genColor;
    }
    private static Color randomBrown() 
    {
        int redVal = ThreadLocalRandom.current().nextInt(30, 100);
        int greenVal = (int) (redVal * .46); //roughly 46% green was working best for brown
        int blueVal = ThreadLocalRandom.current().nextInt(0, (int) (greenVal * .46));
        Color genColor = new Color(redVal, greenVal, blueVal); 
        return genColor;
    }
    private static Color randomGrayscale()
    {
        int grayVal = ThreadLocalRandom.current().nextInt(0, 255); //all 3 RGB values need to be the same
        Color genColor = new Color(grayVal, grayVal, grayVal); 
        return genColor;
    }
}
