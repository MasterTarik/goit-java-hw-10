import java.util.stream.Stream;

/*
 * Используя Stream.iterate сделайте бесконечный стрим рандомных чисел, но не используя Math.random.
 * Реализуйте свой "линейный конгруэнтный генератор". Для этого начните с x[0] = seed
 * и затем каждый следующий элемент x[n + 1] = 1 (a x[n] + c) % m, для корректных значений a, c, и m.
 * Необходимо имплементировать метод, который принимает на вход параметры a, c, m и seed и возвращает Stream<Long>.
 * Для теста используйте данные a = 25214903917, c = 11 и m = 2^48 (2 в степени 48).*/

public class StremExemple {
    public static void main(String[] args) {

        long a = 25214903917l;
        long c = 11l;
        long m = (long) Math.pow(2, 48);
        long seed = 0l;

        new StremExemple().randomGenerator(123l);
    }


    public static void randomGenerator(Long seed) {

        long a = 25214903917l;
        long c = 11l;
        long m = (long)Math.pow(2, 48);

        Stream.iterate(new long[]{0, seed},  x -> new long[]{ x[1], (1 * ((a * x[0] + c) % m))})
                .limit(20)
                .mapToLong( x -> x[0])
                .forEach(x -> System.out.println("random value: " + x));
    }

}
