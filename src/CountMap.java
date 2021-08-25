import java.util.List;
import java.util.Map;

public interface CountMap <T> {
    void add(T elem);

    int getCount(T elem);

    //current count
    int remove(T elem);

    int size();

    void addAll(CountMap<T> source);

    Map<T, Integer> toMap();

    void toMap(Map<T, Integer> destination);
  
}