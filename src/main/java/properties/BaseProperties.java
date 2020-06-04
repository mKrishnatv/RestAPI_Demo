package properties;

public class BaseProperties {
    public static final String env = null == System.getProperty("env") ? "" : System.getProperty("env").toLowerCase().trim();
    public static final String slackNotification = null == System.getProperty("slackNotif") ? "" : System.getProperty("slackNotif");
    public static final String tags = null == System.getProperty("tags") ? "" : System.getProperty("tags");
}
