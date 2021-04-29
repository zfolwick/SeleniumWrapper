package SeleniumTools.Elements;

import org.openqa.selenium.By;

public abstract class Element {
    protected By by;
    protected String text;
    protected boolean enabled;
    protected boolean displayed;

    public abstract void hover();

    public abstract void typeText(String text);

    public abstract void click();

    public abstract String getAttribute(String attributeName);

    public By getBy() {
        return by;
    }

    public String getText() {
        return text;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public boolean isDisplayed() {
        return displayed;
    }
}