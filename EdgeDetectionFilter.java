import java.awt.Color;
/**
 * Sets the red, green, and blue values of a pixel to the highest of its' neighbor's.
 * 
 * @author Colin P. Goss
 * @version 1.0
 */
public class EdgeDetectionFilter extends Filter
{
     /**
     * Constructor for objects of class DarkerFilter.
     * @param name The name of the filter.
     */
    public EdgeDetectionFilter(String name)
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
        OFImage imageCopy = new OFImage(image);
        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
               int[] highestValues = new int[3];
               compareColors(imageCopy.getPixel(x,y), highestValues);
               if (x > 0){ //if the pixel isn't on the left edge
                    compareColors(imageCopy.getPixel(x-1,y), highestValues);
                    //compare to pixel on the left
                    if(y > 0){ //if the pixel isn't on the bottom
                        compareColors(imageCopy.getPixel(x-1,y-1), highestValues);
                         //compare to pixel below and left
                    }
                    if(y < (height - 1)){ //if the pixel isn't on the top
                        compareColors(imageCopy.getPixel(x-1,y+1), highestValues);
                        //compare to pixel above and left
                    }
                }
               if (x < (width - 1)){//if the pixel isn't on the right edge
                    compareColors(imageCopy.getPixel(x+1,y), highestValues);
                   //compare to pixel on the left
                    if(y > 0){//if the pixel isn't on the bottom
                        compareColors(imageCopy.getPixel(x+1,y-1), highestValues);
                        //compare to pixel below and right
                    }
                    if(y < (height - 1)){//if the pixel isn't on the top
                        compareColors(imageCopy.getPixel(x+1,y+1), highestValues);
                   }//compare to pixel above and right
               }
               if(y > 0){//if the pixel isn't on the bottom
                   compareColors(imageCopy.getPixel(x,y-1), highestValues); 
                   //compare to pixel below
                }
               if(y < (height -1)){
                   compareColors(imageCopy.getPixel(x,y+1),highestValues);
                }
               image.setPixel(x,y, new Color(highestValues[0],
                                             highestValues[1],
                                             highestValues[2]));
                
            }//end for x
        }
    }//end apply
    
    private void compareColors(Color color, int[] highestColors)
    {
        if(color.getRed() > highestColors[0]){
            highestColors[0] = color.getRed();
        }
        if(color.getGreen() > highestColors[1]){
            highestColors[1] = color.getGreen();
        }
        if(color.getBlue() > highestColors[2]){
            highestColors[2] = color.getBlue();
        }
    }//end totalColors
}
