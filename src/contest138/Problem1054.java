package contest138;

/**
 * Created by Diane on 2019-05-26.
 * Goal:
 */
public class Problem1054 {
    public int[] rearrangeBarcodes(int[] barcodes) {
        if(barcodes.length<=1) return barcodes;
        for(int i = 1;i<barcodes.length;i++){
            if(barcodes[i]==barcodes[i-1]){
                int j = i+1;
                while (j<barcodes.length&&barcodes[j]==barcodes[i]){
                    j++;
                }
                if(j<barcodes.length) {
                    int temp = barcodes[i];
                    barcodes[i] = barcodes[j];
                    barcodes[j] = temp;
                }else {
                    int swapIndex = 0;
                    for(int k = i;k>0;k--){
                        if(barcodes[k]!=barcodes[i]&&barcodes[k-1]!=barcodes[i]&&barcodes[k+1]!=barcodes[i]){
                            swapIndex = k;
                            break;
                        }
                    }
                    int temp = barcodes[i];
                    barcodes[i] = barcodes[swapIndex];
                    barcodes[swapIndex] = temp;
                }
            }
        }
        return barcodes;
    }
}
