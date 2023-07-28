public class NestedLoop {
    public static void main(String[] args) {

        // run for loop iterating 3 times starting from 1
        for (int i = 1; i <= 3; i++) {

            for (int j = 3; j >= i; j--) {
                System.out.print(i);
            }
            System.out.print("\n");
        }
    }
}