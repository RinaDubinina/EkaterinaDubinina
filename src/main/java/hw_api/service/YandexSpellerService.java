package hw_api.service;

import com.google.gson.Gson;
import hw_api.builder.SpellerBuilder;
import hw_api.dto.SpellerDto;

import java.util.HashMap;
import java.util.Map;

import static hw_api.enums.SpellerKeys.*;

public class YandexSpellerService {
    public SpellerDto[] getCheckText(SpellerBuilder builder) {
        Map<String, Object> params = new HashMap<>();
        params.put(TEXT.getValue(), builder.getText());
        params.put(LANGUAGE.getValue(), builder.getLanguage());
        params.put(OPTIONS.getValue(), builder.getOptions());

        return
                new Gson().fromJson(
                        new CommonService()
                                .getWithParams(URI.CHECK_TEXT, params)
                                .getBody().asString(), SpellerDto[].class);
    }

    public SpellerDto[][] getCheckTexts(String[] texts) {
        Map<String, Object> params = new HashMap<>();
        params.put(TEXT.getValue(), texts);
        return
                new Gson().fromJson(
                        new CommonService()
                                .getWithParams(URI.CHECK_TEXTS, params)
                                .getBody().asString(), SpellerDto[][].class);
    }
}
