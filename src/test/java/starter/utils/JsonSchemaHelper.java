package starter.utils;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class JsonSchemaHelper {
    public String getPostResponseSchema() {
        String path = "schema/post_response_schema.json";
        try {
            InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(path);
            if (inputStream == null) throw new AssertionError();
            return IOUtils.toString(inputStream, StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException("Failed to read response schema file.", e);
        }
    }

    public String getGetResponseSchema() {
        String path = "schema/get_response_schema.json";
        try {
            InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(path);
            if (inputStream == null) throw new AssertionError();
            return IOUtils.toString(inputStream, StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException("Failed to read response schema file.", e);
        }
    }

    public String getPutResponseSchema() {
        String path = "schema/put_response_schema.json";
        try {
            InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(path);
            if (inputStream == null) throw new AssertionError();
            return IOUtils.toString(inputStream, StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException("Failed to read response schema file.", e);
        }
    }
}
