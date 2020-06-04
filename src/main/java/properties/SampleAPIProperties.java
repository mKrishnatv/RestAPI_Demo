package properties;

public class SampleAPIProperties {
    private static final PropertiesReader propertiesReader = new PropertiesReader();
    private static final String punkHost = propertiesReader.getHost();

    //public static final String getAllBeersURL = String.format("%s/beers", punkHost);
}
