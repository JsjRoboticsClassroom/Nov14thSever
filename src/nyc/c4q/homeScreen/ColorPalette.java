package nyc.c4q.homeScreen;

import nyc.c4q.JsonTools;

import java.util.Arrays;
import java.util.List;

public class ColorPalette {
    private final String mName;

    public String getName() {
        return mName;
    }

    public String getValue() {
        return mValue;
    }

    private final String mValue;

    public static List<ColorPalette> getColorPalettes(){
        return Arrays.asList(
                new ColorPalette("Crimson", "DC143C"),
                new ColorPalette("SkyBlue", "87CEEB"),
                new ColorPalette("SpringGreen", "00FF7F"),
                new ColorPalette("Banana", "E3CF57"),
                new ColorPalette("Wheat", "F5DEB3"),
                new ColorPalette("SaddleBrown", "8B4513"),
                new ColorPalette("DarkSalmon", "E9967A")
        );
    }

    public String getColorPaletteJsonArray(){
        String result = "[";
        for (ColorPalette c : getColorPalettes()){
            result += c.getJsonEntry();
        }
        return result + "]";
    }

    private ColorPalette(String name, String value) {
        this.mName = name;
        this.mValue = value;
    }

    public String getJsonEntry() {
        return "{" +
                JsonTools.quote("name")  + JsonTools.colon() + JsonTools.quote(mName) + "," +
                JsonTools.quote("value") + JsonTools.colon() + JsonTools.quote(mValue) +
                "}";
    }

}
