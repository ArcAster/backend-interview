package ai.brace;

import java.util.List;

public class JsonResource
{

    public String version;
    public String uuid;
    public Integer lastModified;
    public String title;
    public String author;
    public String translator;
    public String lanugage;
    public List<TextArrayMember> textArray;

    @Override
    public String toString() {
        return "JsonResource [version=" + version + ", uuid=" + uuid;
    }
}
