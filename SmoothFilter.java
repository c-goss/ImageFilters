import java.awt.Color;
/**
 * Averages a pixel with its surrounding pixels
 * 
 * @author Colin P. Goss
 * @version 1.0
 */
public class SmoothFilter extends Filter
{
     /**
     * Constructor for objects of class DarkerFilter.
     * @param name The name of the filter.
     */
    public SmoothFilter(String name)
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
               double[] colorTotals = new double[3];
               int neighborCount = 1;
               addColors(imageCopy.getPixel(x,y), colorTotals);
               if (x > 0){ //if the pixel isn't on the left edge
                    addColors(imageCopy.getPixel(x-1,y), colorTotals);
                    neighborCount++;
                    //add pixel on the left
                    if(y > 0){ //if the pixel isn't on the bottom
                        addColors(imageCopy.getPixel(x-1,y-1), colorTotals);
                        neighborCount++;
                        //add pixel below and left
                    }
                    if(y < (height - 1)){ //if the pixel isn't on the top
                        addColors(imageCopy.getPixel(x-1,y+1), colorTotals);
                        neighborCount++;
                        //add pixel above and left
                    }
                }
               if (x < (width - 1)){//if the pixel isn't on the right edge
                    addColors(imageCopy.getPixel(x+1,y), colorTotals);
                    neighborCount++;
                    //add pixel on the left
                    if(y > 0){//if the pixel isn't on the bottom
                        addColors(imageCopy.getPixel(x+1,y-1), colorTotals);
                        neighborCount++;
                        //add pixel below and right
                    }
                    if(y < (height - 1)){//if the pixel isn't on the top
                        addColors(imageCopy.getPixel(x+1,y+1), colorTotals);
                        neighborCount++;
                    }//add pixel above and right
                }
               if(y > 0){//if the pixel isn't on the bottom
                   addColors(imageCopy.getPixel(x,y-1), colorTotals);
                   neighborCount++;
                   //add pixel below
                }
               if(y < (height -1)){
                   addColors(imageCopy.getPixel(x,y+1),colorTotals);
                   neighborCount++;
                }
               image.setPixel(x,y, new Color((int)colorTotals[0]/neighborCount,
                                            (int)colorTotals[1]/neighborCount,
                                            (int)colorTotals[2]/neighborCount));
                
            }//end for x
        }
    }//end apply
    
    private void addColors(Color color, double[] totals)
    {
        totals[0]+= color.getRed();
        totals[1]+= color.getGreen();
        totals[2]+= color.getBlue();
    }//end totalColors
}
