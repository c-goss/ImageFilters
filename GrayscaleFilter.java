import java.awt.Color;
/**
 * Converts image to grayscale
 * 
 * @author Colin P. Goss
 * @version 1.0
 */
public class GrayscaleFilter extends Filter
{

    /**
     * Constructor for objects of class GrayscaleFilter.
     * @param name The name of the filter.
     */
    public GrayscaleFilter(String name)
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
                int average = (int)  ((float) (image.getPixel(x,y).getRed() +
                                      image.getPixel(x,y).getGreen() +
                                      image.getPixel(x,y).getBlue())/3);
                image.setPixel(x,y, new Color(average, average, average));
            }
        }
    }

}
