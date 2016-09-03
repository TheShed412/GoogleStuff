import java.util.*;

class Rabbit
{
    public static void main(String[] args)
    {
        int[] x = {1,4,1};
        Random rng = new Random();
        //int[] x = new int[(rng.nextInt(100)+2)];

        //System.out.println(x.length+"\n\n");

        /*for(int i=0; i<x.length; i++){
            x[i] = rng.nextInt(1000000);
        }//for*/
        //System.out.println(answer(x));

        System.out.println(answer(x)+"\n\n");
        for(int i=0; i<x.length; i++){
            System.out.println(x[i]+" ");
        }
    }

    public static int answer(int[] x)
    {
        int sum = 0;
        int avg = 0;
        int oldAvg = 0;
        int li = x.length - 1;
        int si = 0;

        for(int i=0; i<x.length; i++){
            sum += x[i];
        }//for

        avg = (sum/x.length);
        oldAvg = avg;

        quickSort(x, si, li);

        while(si != li && (si<x.length && li != 0)){
            while((x[si]<avg) && (x[li]>avg)){
                move(si, li, x);
            }//while

            if(x[si]==avg && x[li]==avg){
                si++;
                li--;
            }else if(x[si]==avg){
                si++;
            }else{
                li--;
            }//else if

            if(x[si]>=avg){
                if(avg==(oldAvg+1)){
                    si = li+1;
                }else{
                    avg++;
                    si = 0;
                    System.out.println("Avg incremented");
                }
            }
        }//while
        return count(x, avg);
    }//answer

    public static void move(int si, int li, int[] x){
        x[si]++;
        x[li]--;
    }//move

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

        public static void quickSort(int[] arr, int low, int high)
        {
            if (arr == null || arr.length == 0)
                return;

            if (low >= high)
                return;

            // pick the pivot
            int middle = low + (high - low) / 2;
            int pivot = arr[middle];

            // make left < pivot and right > pivot
            int i = low, j = high;
            while (i <= j) {
                while (arr[i] < pivot) {
                    i++;
                }

                while (arr[j] > pivot) {
                    j--;
                }

                if (i <= j) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                    i++;
                    j--;
                }
            }

            if (low < j)
                quickSort(arr, low, j);

            if (high > i)
                quickSort(arr, i, high);
    }//quickSort
}
