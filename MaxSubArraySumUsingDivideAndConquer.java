// "static void main" must be defined in a public class.
public class Main {
    public static void main(String[] args) {
        int[] a = {-1,3, 4,-5, 9, -2};
        int[] maxSubArrayContigousSumWithIndices = maxSubArraySumWithIndices(a,0,a.length-1);
        System.out.println("SUM = "+ maxSubArrayContigousSumWithIndices[0]);
        System.out.println("Start Index = "+maxSubArrayContigousSumWithIndices[1]);
        System.out.println("End Index = "+maxSubArrayContigousSumWithIndices[2]);
    }
    // THIS METHOD RETURNS THREE INTEGERS IN ARRAY IN SEQUENCE sum,startIndex,endIndex
    public static int[] maxSubArraySumWithIndices(int[] array, int p, int r)
    {
       // Terminating condition
        if(p == r)
            return new int[]{array[p], p, r};
        int q = (p+r)/2;
        int[] leftMaxSubArraySumWithIndices = maxSubArraySumWithIndices(array,p,q);
        int[] rightmaxSubArraySumWithIndices = maxSubArraySumWithIndices(array,q+1,r);
        int[] centerCrossingmaxSubArraySumWithIndices = centerCrossingMaxSubArraySumWithIndices(array, p, q, r);
        if(leftMaxSubArraySumWithIndices[0]> rightmaxSubArraySumWithIndices[0] && leftMaxSubArraySumWithIndices[0]> centerCrossingmaxSubArraySumWithIndices[0]){
            return leftMaxSubArraySumWithIndices;
        }
        else if(rightmaxSubArraySumWithIndices[0]>leftMaxSubArraySumWithIndices[0] && rightmaxSubArraySumWithIndices[0]> centerCrossingmaxSubArraySumWithIndices[0]) {
            return rightmaxSubArraySumWithIndices;
        }else{
            return centerCrossingmaxSubArraySumWithIndices;
        }
        
    }
    
    public static int[] centerCrossingMaxSubArraySumWithIndices(int[] arr, int p, int q, int r){
        int leftSum = Integer.MIN_VALUE;
        int rightSum = Integer.MIN_VALUE;
        int sum;
        int indexLeft=q, indexRight=q+1;
        sum=0;
        for(int i=q;i>=0;i--){
            sum+=arr[i];
            if(sum>leftSum){
                leftSum=sum;
                indexLeft=i;
            }
        }
        sum=0;
        for(int i=q+1;i<=r;i++){
            sum+=arr[i];
            if(sum>rightSum){
                rightSum=sum;
                indexRight = i;
            }
        }
        
        return new int[]{(leftSum+rightSum), indexLeft, indexRight};
    }
}
