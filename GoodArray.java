/*For a number N, a goodArray is the smallest

possible array that consists of only powers of

two (2°, 21 .…. 2k) such that the sum of all the

numbers in the array is equal to N.

For each query that consists of three integers 1,

r, and m, find out the product of elements

goodArray/) through goodArray(r] modulo

m when goodArray is sorted in non-decreasing

order.

Example

For N= 26, querles = (I1, 2, 1009), [3, 3, 51

goodArray when sorted is (2,8,16),

For query /= 1, r= 2, m = 1009, ans=

goodAray(1] * goodArray(2) = (2 * 8) modulo

1009 = 16.

For query | = 3, r= 3, m = 5, ans = goodAray=

(16) modulo 5 = 1.

The answer is (16, 1).
*/

import java.io.*;

import java.math.*;

import java.security.*;

import java.text.*;

import java.util.*;

import java.util.concurrent.*;

import java.util.function.*;

import java.util.regex.*;

import java.util.stream.*;

import static java.util.stream.Collectors.joining;

import static java.util.stream.Collectors.toList;







class Result {



    /*

     * Complete the 'getQueryResults' function below.

     *

     * The function is expected to return an INTEGER_ARRAY.

     * The function accepts following parameters:

     *  1. LONG_INTEGER n

     *  2. 2D_INTEGER_ARRAY queries

     */



    public static List<Integer> getQueryResults(long n, List<List<Integer>> queries) {

        List<Integer> res = new ArrayList<>();

        for(List<Integer> query: queries){

            int l = query.get(0);

            int r = query.get(1);

            int m = query.get(2);

            long result = getSingleQueryResult(n, l,r,m)%m;

            int returnResult = (int)result%m;

            res.add(returnResult);

        }

        return res;

    }

    

    public static long getSingleQueryResult(long n, int l, int r, int m) {

        List<Long> goodArray = getGoodArray(n);

        System.out.println(goodArray);

        List<Long> modulusList = new ArrayList<>();

        for (int i = l; i <= r; ++i) {

            long modulus = goodArray.get(goodArray.size() - i) % m;

            modulusList.add(modulus);

        }

        int i = 0;

        long curProduct = 1;

        while (i < modulusList.size()) {

            curProduct *= modulusList.get(i++);

            if (curProduct > m) {

                curProduct %= m;

            }

        }

        return curProduct % m;

    }



    

    public static List<Long> getGoodArray(long n) {

        int largestPower = 0;

        long twoPower = 1;

        while (twoPower * 2 < n) {

            twoPower *= 2;

            largestPower++;

        }

        List<Long> goodArray = new ArrayList<>();

        while (n > 0 && largestPower >= 0) {

            long curTwoPower = getTwoPower(largestPower--);

            if (n - curTwoPower >= 0) {

                goodArray.add(curTwoPower);

                n -= curTwoPower;

            }

        }

        return goodArray;

    }

    

    public static long getTwoPower(int power) {

        long res = 1;

        for (int i = 0; i < power; ++i) {

            res *= 2;

        }

        return res;

    }



}



public class Solution {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));



        long n = Long.parseLong(bufferedReader.readLine().trim());



        int queriesRows = Integer.parseInt(bufferedReader.readLine().trim());

        int queriesColumns = Integer.parseInt(bufferedReader.readLine().trim());



        List<List<Integer>> queries = new ArrayList<>();



        IntStream.range(0, queriesRows).forEach(i -> {

            try {

                queries.add(

                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))

                        .map(Integer::parseInt)

                        .collect(toList())

                );

            } catch (IOException ex) {

                throw new RuntimeException(ex);

            }

        });



        List<Integer> result = Result.getQueryResults(n, queries);



        bufferedWriter.write(

            result.stream()

                .map(Object::toString)

                .collect(joining("\n"))

            + "\n"

        );



        bufferedReader.close();

        bufferedWriter.close();

    }

}