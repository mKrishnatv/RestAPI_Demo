package properties;

public class SampleAPIProperties {
    private static final PropertiesReader propertiesReader = new PropertiesReader();
    private static final String restHost = propertiesReader.getHost();

    public static final String getAllEmployees = String.format("%s/api/v1/employees", restHost);
}
