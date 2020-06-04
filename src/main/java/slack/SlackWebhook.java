package slack;

import java.util.HashMap;

public class SlackWebhook {
    public static HashMap<String, String> HOOKS = new HashMap<String, String>() {
        {
            put("{your_channel_name}", "{your_channel_token}");
        }
    };
}
