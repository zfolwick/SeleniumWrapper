package SeleniumTools.Elements;

public class ElementDecorator extends Element {
    protected Element element;

    public ElementDecorator(Element element) {
        this.element = element;
        this.text = element.getText();
        this.by = element.by;
        this.enabled = element.isEnabled();
        this.displayed = element.isDisplayed();
    }

    @Override
    public boolean isEnabled() {
        return element.isEnabled();
    }

    @Override
    public boolean isDisplayed() {
        return element.isDisplayed();
    }

    @Override
    public void click() {
        element.click();
    }

    @Override
    public String getAttribute(String attributeName) {
        return element.getAttribute(attributeName);
    }

    @Override
    public void hover() {

    }

    @Override
    public void typeText(String text) {
        element.typeText(text);
    }
}