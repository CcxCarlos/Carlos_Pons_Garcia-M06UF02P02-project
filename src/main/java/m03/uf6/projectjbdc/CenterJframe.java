package m03.uf6.projectjbdc;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;

/**
 *
 * @author PC
 */
public class CenterJframe {
    private final static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private final static double widthScreen = screenSize.getWidth();
    private final static double heightScreen = screenSize.getHeight();

    public static Point getPoint(int widthJframe, int heightJframe){
        int x = (int) ((widthScreen - widthJframe) / 2);
        int y = (int) ((heightScreen - heightJframe) / 2);
        return new Point(x, y);
    }
}
