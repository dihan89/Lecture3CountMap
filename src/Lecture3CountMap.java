import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.StringBuilder;
import java.nio.file.Files;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;


class CountMapMy<T>  implements CountMap<T>  {
    Map <T, Integer> elemsToCountsEntries;
    public void add(T elem){      
        Integer nEntries = elemsToCountsEntries.get(elem);
        Integer nEntriesNew = (nEntries == null) ? 1 : nEntries + 1;
        elemsToCountsEntries.put(elem, nEntriesNew);
    };

   public int getCount(T elem){
        Integer nEntries = elemsToCountsEntries.get(elem);
        return (nEntries == null) ? 0 : nEntries;
    };

    //current count
    public int remove(T elem){ 
        Integer result = elemsToCountsEntries.remove(elem);     
        return (result == null) ? 0 : result;
    };

    public int size(){
        return elemsToCountsEntries.size();
    };

    public void addAll(CountMap<T> source){
        for(Map.Entry<T, Integer> pair : source.toMap().entrySet()){
            Integer nEntries = elemsToCountsEntries.get(pair.getKey());
            Integer nEntriesNew = (nEntries == null) ? pair.getValue() : pair.getValue() + nEntries;
            elemsToCountsEntries.put(pair.getKey(), nEntriesNew);
        }
    };

    public Map<T, Integer> toMap(){
        return elemsToCountsEntries;
    };

    public void toMap(Map<T, Integer> destination){
        destination.putAll(elemsToCountsEntries);
    };
    CountMapMy(){
        elemsToCountsEntries = new HashMap<>();
    }
}

public class Lecture3CountMap 
{
    public static <T,K> void printMap(Map<T,K> map) {
        map.entrySet().forEach(System.out::println);
    }

    public static void main(String[] args) {
        CountMap<Integer> countMap = new CountMapMy<>();
        countMap.add(10);
        countMap.add(10);
        countMap.add(5);
        countMap.add(6);
        countMap.add(5);
        countMap.add(10);
        countMap.add(8);
        countMap.add(12);
        countMap.add(500);

        System.out.println("Count of \'5\' = " + countMap.getCount(5));        
        int tmp = countMap.remove(6);
        System.out.println("Count of \'6\' = " + tmp);
        System.out.println("size = " + countMap.size());
        printMap(countMap.toMap());
        tmp = countMap.remove(78);
        System.out.println(tmp);
    }
}