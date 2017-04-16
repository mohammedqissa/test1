import java.util.Arrays;
import java.util.Scanner;

public class Bridge{


    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        int[] array = new int[n];
        for(int i = 0 ;i<n;i++)
            array[i] = scan.nextInt();

        Arrays.sort(array);

        System.out.print(TotalTime(array, n));
    }





    public static int TotalTime(int[] array, int n)
    {
        if (n < 3)
        {
            return array[n - 1];
        }
        else if (n == 3)
        {
            return array[0] + array[1] + array[2];
        }
        else
        {
            int temp1 = array[n - 1] + array[0] + array[n - 2] + array[0];
            int temp2 = array[1] + array[0] + array[n - 1] + array[1];

            if (temp1 < temp2)
            {
                return temp1 + TotalTime(array, n - 2);
            }
            else if (temp2 < temp1)
            {
                return temp2 + TotalTime(array, n - 2);
            }
            else
            {
                return temp2 + TotalTime(array, n - 2);
            }
        }
    }

}
