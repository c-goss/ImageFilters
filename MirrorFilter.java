import java.awt.Color;
/**
 * Flips the image horizontally
 * 
 * @author Colin P. Goss
 * @version 1.0
 */
public class MirrorFilter extends Filter
{

    /**
     * Constructor for objects of class GrayscaleFilter.
     * @param name The name of the filter.
     */
    public MirrorFilter(String name)
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
            for(int x = 0; x < (width/2); x++) {
                Color leftPixel = image.getPixel(x,y);
                image.setPixel(x,y, image.getPixel(width - x - 1, y));
                image.setPixel(width - x - 1, y, leftPixel);
            }
        }
    }
}
