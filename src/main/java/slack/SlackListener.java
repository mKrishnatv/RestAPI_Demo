package slack;

import clients.slack.Entities;
import clients.slack.SlackClient;
import clients.slack.SlackNotificationBuilder;
import io.restassured.response.Response;
import org.testng.ITestContext;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;
import properties.BaseProperties;

public class SlackListener extends TestListenerAdapter {
    @Override
    public void onFinish(ITestContext testContext) {

        String slackChannel = BaseProperties.slackNotification;

        Reporter.log(slackChannel, true);

        if (!slackChannel.isEmpty()) {
            Reporter.log("Send Notification to slack", true);

            int passTests = testContext.getPassedTests().size();
            int failedTests = testContext.getFailedTests().size();
            String tags = BaseProperties.tags;
            String status = failedTests > 0 ? "#FF0000" : "#36a64f";
            String pipelineUrl = "{your_master_pipeline_url}";

            Entities attachments = new SlackNotificationBuilder()
                    .withFallback(tags)
                    .withColor(status)
                    .withTitle(pipelineUrl, tags)
                    .withPassValue(String.valueOf(passTests))
                    .withFailedValue(String.valueOf(failedTests))
                    .build();

            Response response = new SlackClient().sendSlackNotifications(attachments, SlackWebhook.HOOKS.get(slackChannel));
            Reporter.log("Response: " + response.asString(), true);
            Reporter.log(String.format("%s", response.getStatusCode()), true);

        }

    }
}
