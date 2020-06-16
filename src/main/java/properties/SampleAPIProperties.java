package properties;

public class SampleAPIProperties {
    private static final PropertiesReader propertiesReader = new PropertiesReader();
    private static final String restHost = propertiesReader.getHost();

    public static final String getAllEmployeesUrl = String.format("%s/api/v1/employees", restHost);
    public static final String addEmployeeUrl = String.format("%s/api/v1/create", restHost);
    public static final String updateEmployeeUrl = String.format("%s/api/v1/update", restHost);
    public static final String deleteEmployeeUrl = String.format("%s/api/v1/delete", restHost);
}
