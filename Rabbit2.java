import java.util.*;

public class Rabbit2
{
    public static void main(String[] args)
    {
        //int[] x = {1,4,1};
        Random rng = new Random();
        int[] x = new int[(rng.nextInt(100)+2)];

        //System.out.println(x.length+"\n\n");

        for(int i=0; i<x.length; i++){
            x[i] = rng.nextInt(1000000);
        }//for
        System.out.println(answer(x));

        System.out.println(answer(x)+"\n\n");
        for(int i=0; i<x.length; i++){
            System.out.println(x[i]+" ");
        }
    }

    public static int answer(int[] x)
    {
        int[] temp = new int[x.length];
        int sum = 0;
        int avg = 0;

        for(int i=0; i<x.length; i++){
            sum += x[i];
        }//for
        avg = (sum/x.length);

        for(int i=1; i<x.length; i++){
            for (int j=x[i]; j>0; j--) {
                move(0, i, x);
            }//for
        }//for

        for(int i=1; i<x.length; i++){
            for(int j=x[i]; j<avg; j++){
                if(x[0]>avg){
                    move(i, 0, x);
                }
                if(x[0]>(avg+1) && x[x.length-1] == avg){
                    avg++;
                    i = 1;
                }

            }//for
        }//for

        return count(x, avg);
    }//answer

    public static int count(int[] arr, int avg)
    {
        int a1 = 0;
        int a2 = 0;
        int avg2 = 0;

        for(int i=0; i<arr.length; i++){
            if(arr[i] == avg){
                a1++;
            }else{
                a2++;
                avg2 = arr[i];
            }//if else
        }//for

        if(a1>=a2){
            return a1;
        }else{
            return a2;
        }
    }//count

    public static void move(int si, int li, int[] x){
        x[si]++;
        x[li]--;
    }//move
}//class
