
import javax.swing.JLabel;

public class Element {

    private int element;
    private final JLabel label;

    public Element(int element, JLabel label) {
        this.label = label;
        this.element = element;
    }

    public void combine(Element e) {
        this.setElement(this.element + e.getElement());
        e.setElement(0);
    }

    public int getElement() {
        return this.element;
    }

    public void setElement(int element) {
        this.element = element;
    }

    public void updateLabel() {
        this.label.setText(this.toString());
    }

    public JLabel getLabel() {
        return this.label;
    }

    @Override
    public String toString() {
        if (this.element < 10) {
            return "000" + this.element;
        } else if (this.element < 100) {
            return "00" + this.element;
        } else if (this.element < 1000) {
            return "0" + this.element;
        } else {
            return "" + this.element;
        }
    }
}
