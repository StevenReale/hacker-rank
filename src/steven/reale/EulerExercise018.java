package steven.reale;

public class EulerExercise018 {

    private static int trianglePath(int[][] triangle) {
        int pathSum = 0;
        for (int i  = triangle.length-1; i > 0; i--) {
            int[] resultantSum = new int[i];
            for (int j = 0; j < i; j++) {
                int currentNum = triangle[i-1][j];
                resultantSum[j] = Math.max(currentNum + triangle[i][j], currentNum + triangle[i][j+1]);
            }
            triangle[i-1] = resultantSum;
        }
        return triangle[0][0];
    }

    public static void main(String[] args) {
        int[][] triangle = new int[4][];
        triangle[0] = new int[] {3};
        triangle[1] = new int[] {7, 4};
        triangle[2] = new int[] {2, 4, 6};
        triangle[3] = new int[] {8, 5, 9, 3};

        System.out.print(trianglePath(triangle));
    }

}
