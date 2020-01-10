package ai.brace;

import java.io.FileNotFoundException;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws FileNotFoundException {
        JsonResource testObj = Utils.loadJsonFile("a1.json");

        Comparator<TextArrayMember> compareById = Comparator.comparing(TextArrayMember::getId);

        List<TextArrayMember> testList = testObj.textArray;

        Collections.sort(testList, compareById);

        for (TextArrayMember element : testList) {
            System.out.println(element.textdata);
        }

    }
}
