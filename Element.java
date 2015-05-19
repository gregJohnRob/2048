public class Element {
  private int element;

  public Element(int element){
    this.element = element;
  }

  public void combine(Element e) {
    if (this.canCombine(e)) {
      element += e.getElement();
    }
  }

  public boolean canCombine(Element e) {
    return e.getElement() == element;
  }

  public int getElement(){ return element; }

  @Override
  public String toString(){
    if(element < 10) {
      return "000" + element;
    } else if (element < 100) {
      return "00" + element;
    } else if (element < 1000) {
      return "0" + element;
    } else {
      return "" + element;
    }
  }
}
