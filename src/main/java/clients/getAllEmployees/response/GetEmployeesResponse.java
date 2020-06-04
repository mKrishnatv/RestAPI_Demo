package clients.getAllEmployees.response;

import clients.BaseResponse;
import static org.testng.Assert.assertEquals;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.testng.Assert;

import java.util.List;

@Getter
@Setter
public class GetEmployeesResponse extends BaseResponse {

    @JsonProperty("data")
    private List<Data> data;
    private String status;

    public GetEmployeesResponse assertBasicInfoNotNull(){
        assertEquals(getHttpStatusCode(), 200);
        Assert.assertNotNull(data.stream().map(Data::getId));
        Assert.assertNotNull(data.stream().map(Data::getEmployee_name));
        Assert.assertNotNull(data.stream().map(Data::getEmployee_salary));
        Assert.assertNotNull(data.stream().map(Data::getEmployee_age));
        return this;
    }
}
