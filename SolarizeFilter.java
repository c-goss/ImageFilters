import java.awt.Color;
/**
 * If a pixel has a color under 128, replaces that color with 255 - the initial color
 * 
 * @author Colin P. Goss
 * @version 1.0
 */
public class SolarizeFilter extends Filter
{

    /**
     * Constructor for objects of class SolarizeFilter
     * @param name The name of the filter.
     */
    public SolarizeFilter(String name)
    {
        super(name);
    }

    /**
     * Apply this filter to an image.
     * 
     * @param  image  The image to be changed by this filter.
     */
    public void apply(OFImage image)
    {
        int height = image.getHeight();
        int width = image.getWidth();
        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
                Color pixel = image.getPixel(x,y);
                int red = pixel.getRed();
                int blue = pixel.getBlue();
                int green = pixel.getGreen();
                if(green < 128){
                    green = 255 - green;
                }
                if(red < 128){
                    red = 255 - red;
                }
                if(blue < 128){
                    blue = 255 - blue;
                }
                image.setPixel(x,y, new Color(red,green,blue));
            }
        }
    }
}
