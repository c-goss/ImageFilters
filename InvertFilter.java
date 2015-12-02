import java.awt.Color;
/**
 * Inverts the color of the image
 * 
 * @author Colin P. Goss
 * @version 1.0
 */
public class InvertFilter extends Filter
{

    /**
     * Constructor for objects of class InvertFilter
     * @param name The name of the filter.
     */
    public InvertFilter(String name)
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
                image.setPixel(x, y, new Color(255 - pixel.getRed(),
                                               255 - pixel.getGreen(),
                                               255 - pixel.getBlue()));
            }
        }
    }
}