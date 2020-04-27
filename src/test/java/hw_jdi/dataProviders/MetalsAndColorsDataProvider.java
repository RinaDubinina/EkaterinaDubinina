package hw_jdi.dataProviders;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import hw_jdi.entities.MetalsAndColors;
import org.testng.annotations.DataProvider;
import static hw_jdi.dataProviders.DataPath.DATA_PATH;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.Map;

public class MetalsAndColorsDataProvider {

    @DataProvider()
    public Object[][] testData() throws FileNotFoundException {
        JsonElement element = new JsonParser().parse(new FileReader(
                DATA_PATH.getValue()));

        Type mapType = new TypeToken<Map<String, MetalsAndColors>>(){}.getType();
        Map<String, MetalsAndColors> jsonData = new Gson().fromJson(element, mapType);
        Object[][] testData = new Object[jsonData.size()][1];
        int i = 0;
        for (String entry : jsonData.keySet()) {
            testData[i++][0] = jsonData.get(entry);
        }
        return testData;
    }


}


