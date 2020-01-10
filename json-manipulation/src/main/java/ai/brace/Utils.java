package ai.brace;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class Utils {

    public static Path getPathForResource(final String path)
    {
        try
        {
            return Paths.get(ClassLoader.getSystemResource(path).toURI());
        }
        catch (URISyntaxException e)
        {
            throw new RuntimeException(e);
        }
    }

    // load json file from filename and return JsonResource obj
    public static JsonResource loadJsonFile(String json_file_name) throws FileNotFoundException {

        String path = getPathForResource(json_file_name).toString();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));

        Gson gson = new Gson();
        JsonResource outp = gson.fromJson(bufferedReader, JsonResource.class);

        return outp;
    }
}
