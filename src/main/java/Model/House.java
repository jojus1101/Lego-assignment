
package Model;

/**
 *
 * @author jojus1101
 */
public class House {

    public Bricks makeHouse(int length, int width, int height) {
        Bricks bricksCalculated = new Bricks();
        int four, two, one;
        int l, w;
        for (int i = 1; i <= height; i++) {
            if (i % 2 == 1) {
                l = length;
                w = width - 4;
            }
            else {
                l = length - 4;
                w = width;
            }
            four = (l / 4) * 2 + (w / 4) * 2;
            two = ((l % 4) / 2) * 2 + ((w % 4) / 2) * 2;
            one = ((l % 4) % 2) * 2 + ((w % 4) % 2) * 2;
            bricksCalculated.addBricklayers(four, two, one);
        }
        return bricksCalculated;
    }
}
