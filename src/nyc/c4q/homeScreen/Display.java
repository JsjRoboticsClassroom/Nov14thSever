package nyc.c4q.homeScreen;

import static nyc.c4q.JsonTools.colon;
import static nyc.c4q.JsonTools.quote;

public class Display {
    private final String mText;
    private final ColorPalette mColor;

    public Display(String text, ColorPalette color) {
        this.mText = text;
        this.mColor = color;
    }

    public String getJson(){
        return quote("display") + colon() +
                "{" +
                quote("text") + colon() + quote(mText) + "," +
                quote("color") + colon() + quote(mColor.getName()) +
                "}";
    }
}
