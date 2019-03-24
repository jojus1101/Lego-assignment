
package Model;

/**
 *
 * @author jojus1101
 */
public class Order {
    
    public Order(int id, int length, int width, int height, boolean isSent) {
        this.id = id;
        this.length = length;
        this.width = width;
        this.height = height;
        this.isSent = isSent;
    }

    public Order(int length, int width, int height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }
    
    private int id, length, width, height;
    private boolean isSent;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public boolean isIsSent() {
        return isSent;
    }

    public void setIsSent(boolean isSent) {
        this.isSent = isSent;
    }
}
