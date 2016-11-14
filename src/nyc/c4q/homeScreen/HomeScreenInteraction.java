package nyc.c4q.homeScreen;

import java.io.PrintWriter;
import java.util.*;
import java.util.function.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static nyc.c4q.JsonTools.colon;
import static nyc.c4q.JsonTools.quote;

public class HomeScreenInteraction {

    private final Display mDisplay;
    private final ColorPalette mColorPalette;
    private final List<ColorPalette> mColorOptions;
    Random mRandom = new Random();

    public HomeScreenInteraction(){
        List<ColorPalette> colors = new ArrayList<>();
        do {
            colors = ColorPalette.getColorPalettes();
            colors = colors.stream().filter(randomBoolean()).collect(Collectors.toList());
        } while (colors.isEmpty());

        mColorOptions = colors;
        mColorPalette = colors.get(mRandom.nextInt(colors.size()));
        mDisplay = new Display(getRandomText(), mColorPalette);
    }

    private String getRandomText() {
        List<String> options = Arrays.asList(
                "Boy this is easy",
                "Man this is difficult",
                "Shoot this is hard",
                "Will feel good when i'm done",
                "Can't believe this is what we are doing",
                "Who writes this stuff??"
        );

        return options.get(mRandom.nextInt(options.size()));
    }


    private Predicate<? super ColorPalette> randomBoolean() {
        return ignored -> mRandom.nextBoolean();
    }


    public void writeResponse(PrintWriter writer) {
        String result = "{" +
                mDisplay.getJson() + ",";

        String colorOptions = quote("colorPalette") + colon() + "[";
        for (int index = 0; index < mColorOptions.size(); index++){
            colorOptions = colorOptions + mColorOptions.get(index).getJsonEntry();
            if (index + 1 < mColorOptions.size()){
                colorOptions += ",";
            }
        }
        colorOptions += "]";

        result += colorOptions + "}";
        writer.println(result);
    }
}
