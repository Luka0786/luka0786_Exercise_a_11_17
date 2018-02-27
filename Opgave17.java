package Kap11Exercise17;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Opgave17
{
    /*
     Write a method called subMap that accepts two maps from strings
     to strings as its parameters and returns true if every key in the
     first map is also contained in the second map and maps to the same
     value in the second map.
     For example, {Smith=949–0504, Marty=206–9024} is a submap of
     {Marty=206–9024, Hawking=123–4567, Smith=949–0504, Newton=123–4567}.
     The empty map is a submap of every map
    */

    public static void main(String[] args)
    {
        Map<String, String> firstMap = new HashMap<>();
        firstMap.put("Smith", "949-0504");
        firstMap.put("Marty", "206-9024");
        //firstMap.put("x321", "100-1111");
        //firstMap.put("x123", "211-2222");

        Map<String, String> secondMap = new HashMap<>();
        secondMap.put("Marty", "206-9024");
        secondMap.put("Hawking", "123-4567");
        secondMap.put("Smith", "949-0504");
        secondMap.put("Newton", "123-4567");

        System.out.println(subMap(firstMap, secondMap));
    }

    public static boolean subMap(Map<String, String> mapOne, Map<String, String> mapTwo)
    {
        boolean temp = true;
        Set<String> setOfKeysOne = new HashSet<>(mapOne.keySet());
        Set<String> setOfKeysTwo = new HashSet<>(mapTwo.keySet());

        for (Map.Entry<String, String> mapEntry : mapOne.entrySet())
        {
            if (mapTwo.containsKey(mapEntry.getKey()) && mapTwo.containsValue(mapEntry.getValue()))
            {
                Set<String> tempSet = new HashSet<>(setOfKeysOne);
                tempSet.removeAll(setOfKeysTwo);
            }
            else
            {
                temp = false;
            }
        }
        return temp;
    }
}
