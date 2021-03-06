package top.linxixixiangxin.offer14_1;

public class solution01 {
    public static void main(String[] args) {
        System.out.println(new Solution14_01_01().cuttingRope(10));
    }
}
class Solution14_01_01 {
    public int cuttingRope(int n) {
        //处理特殊数据
        if(n < 2){
            return 0;
        }else if (n == 2){
            return 1;
        }else if(n == 3){
            return 2;
        }else {
            //先将特殊数据存入数组
            Integer[] results = new Integer[n+1];
            results[0] = 0;
            results[1] = 1;
            results[2] = 2;
            results[3] = 3;
            //获得最大值
            Integer max = 0;
            //递增 自下而上解决问题
            for(int i = 4;i<=n;i++){
                //切割绳子 同时根据之前得出的小问题的最优解来解决更大的问题，变切n刀为切1刀
                for(int j = 1;j<=i/2;++j){
                    int result = results[j] * results[i-j];
                    if(max < result) {
                        max = result;
                    }
                    results[i] = max;
                }
            }
            max = results[n];
            return max;
        }
    }
}