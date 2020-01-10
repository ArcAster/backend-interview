package ai.brace;

public class TextArrayMember {

    public Integer id;
    public String textdata;

    public Integer getId() {
        return id;
    }

    public String getTextData() {
        return textdata;
    }

    @Override
    public String toString() {
        return "id=" + id + ", textdata=" + textdata;
    }
}
