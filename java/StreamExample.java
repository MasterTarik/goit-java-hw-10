import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExample {
    public static void main(String[] args) {

        long a = 25214903917l;
        long c = 11l;
        long m = (long) Math.pow(2, 48);
        long seed = 0l;

       System.out.println( new StreamExample().randomGenerator(a, c, m, seed));
    }

    /**********    Task 4    **************************************************************/

    public List<Long> randomGenerator(long a, long c, long m, long seed) {
        Stream<Long> streamFromIterate = Stream.iterate(seed, x -> (a * x + c) % m);
        return streamFromIterate.limit(5).collect(Collectors.toList());
    }

    /**********    Task 5    **************************************************************/

    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {

        Iterator<T> firstIterator = first.iterator();
        Iterator<T> secondIterator = second.iterator();
        Stream<T> result = Stream.empty();

        while (firstIterator.hasNext() && secondIterator.hasNext()) {
            result = Stream.concat(result, Stream.of(firstIterator.next(), secondIterator.next()));
        }
        return result;
    }

}
