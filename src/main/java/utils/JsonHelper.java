package utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

public class JsonHelper {
    public static String getJsonString(Object o) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            return objectMapper.writeValueAsString(o);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static Object getObject(String jsonString, Class responseClass) {

        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(jsonString, responseClass);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getFileContentsAsString(InputStream stream) {

        List<String> lines = Arrays.asList();


        try {
            lines = IOUtils.readLines(stream, StandardCharsets.UTF_8);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return StringUtils.join(lines, "");
    }
}
