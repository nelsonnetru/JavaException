// 2. Если необходимо, исправьте данный код (задание 2)

public class Ex_02 {
    public static void main(String[] args) {
        try {
            int[] intArray = {1,2,3,4,5,6,7,8,9};
            int d = 0;
            double catchedRes1 = intArray[8] / d;
            System.out.println("catchedRes1 = " + catchedRes1);
        } catch (Exception e) {
                System.out.println("Catching exception: " + e);
        }
    }
}

