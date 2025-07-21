import java.util.*;

class Solution {
    int MAX = 10001; // max value for arr[i]

    int cntCoprime(int[] arr) {
        int[] freq = new int[MAX];

        for (int num : arr) {
            freq[num]++;
        }

        // Count total pairs
        int n = arr.length;
        long totalPairs = (1L * n * (n - 1)) / 2;

        // Count non-coprime pairs using a sieve-style GCD check
        long[] gcdCount = new long[MAX];

        for (int i = 1; i < MAX; i++) {
            int cnt = 0;
            for (int j = i; j < MAX; j += i) {
                cnt += freq[j];
            }
            // number of pairs with GCD divisible by i
            gcdCount[i] = (1L * cnt * (cnt - 1)) / 2;
        }

        // Inclusion-Exclusion principle using Mobius function
        int[] mobius = new int[MAX];
        Arrays.fill(mobius, 1);
        boolean[] isPrime = new boolean[MAX];
        Arrays.fill(isPrime, true);

        for (int i = 2; i < MAX; i++) {
            if (isPrime[i]) {
                for (int j = i; j < MAX; j += i) {
                    isPrime[j] = false;
                    mobius[j] *= -1;
                }
                long square = 1L * i * i;
                for (int j = (int)square; j < MAX; j += square) {
                    mobius[j] = 0;
                }
            }
        }

        // Calculate number of coprime pairs
        long coprimePairs = 0;
        for (int i = 1; i < MAX; i++) {
            coprimePairs += mobius[i] * gcdCount[i];
        }

        return (int)coprimePairs;
    }
}
