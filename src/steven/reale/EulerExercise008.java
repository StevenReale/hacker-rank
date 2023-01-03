package steven.reale;

/*
Returns the greatest product of K consecutive digits in a given N-digit number.
 */

public class EulerExercise008 {

    private static int largestProduct(int n, int k, String num) {
        int maxProduct = 0;
        int currentProduct;

        for (int i = 0; i < n-k-1; i++) {
            currentProduct = 1;
            for (int j = i; j < k + i; j++) {
                currentProduct *= Integer.parseInt(num.substring(j, j + 1));
            }
            maxProduct = Math.max(currentProduct, maxProduct);

        }
        return maxProduct;
    }

    public static void main(String[] args) {
        System.out.println(largestProduct(10, 5, "3675356291"));
    }
}
