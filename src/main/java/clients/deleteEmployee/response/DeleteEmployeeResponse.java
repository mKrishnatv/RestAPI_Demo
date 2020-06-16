package clients.deleteEmployee.response;

import clients.BaseResponse;
import lombok.Getter;
import lombok.Setter;
import org.testng.Assert;

@Getter
@Setter
public class DeleteEmployeeResponse extends BaseResponse {
    private String message;
    private String status;

    public DeleteEmployeeResponse assertSuccess(){
        Assert.assertEquals(getHttpStatusCode(), 200);
        Assert.assertEquals(getStatus(), "success");
        Assert.assertEquals(getMessage(), "successfully! deleted Records");
        return this;
    }
}
