package hw_jdi.dataProviders;

public enum DataPath {

    DATA_PATH("src/test/resources/hw_jdi/JDI_ex8_metalsColorsDataSet.json");

    final String value;

    DataPath(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
