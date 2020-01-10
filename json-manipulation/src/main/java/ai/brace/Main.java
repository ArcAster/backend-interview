package ai.brace;

import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main
{
    public static void main(String[] args) throws FileNotFoundException {
        JsonResource obj1 = Utils.loadJsonFile("a1.json");
        JsonResource obj2 = Utils.loadJsonFile("a2.json");
        
        List<TextArrayMember> textData1 = obj1.textArray;
        List<TextArrayMember> textData2 =  obj2.textArray;

        List<TextArrayMember> mergedList = Stream.concat(textData1.stream(), textData2.stream())
                .collect(Collectors.toList());

        List<TextArrayMember> outpList = sortListById(mergedList);

        for (TextArrayMember element : outpList) {
            System.out.println(element.textdata);
        }

    }

    public static List<TextArrayMember> sortListById(List<TextArrayMember> inpList) {
        List<TextArrayMember> tempList = inpList;

        Comparator<TextArrayMember> compareById = Comparator.comparing(TextArrayMember::getId);

        Collections.sort(tempList, compareById);

        return tempList;
    }
}
