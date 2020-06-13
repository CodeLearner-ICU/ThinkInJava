package algorithm.qinghua.chapterone;

public class CommonSubSequence {
    public static void main(String[] args) {
        String str1 = "abcdefgfdaaabbcsfwfbbbfdszcaallkhgfdfvzaa";
        String str2 = "efcdeabff";
        CommonSubSequence csq = new CommonSubSequence();
        long start = System.nanoTime();
        System.out.print(csq.find(str1.toCharArray(),str2.toCharArray()));
        long mid = System.nanoTime();
        System.out.println("  cost:"+String.valueOf(mid-start));
        System.out.print(csq.findDynamic(str1.toCharArray(),str2.toCharArray()));
        long end = System.nanoTime();
        System.out.println("  cost:"+String.valueOf(end-mid));
    }

    public StringBuilder find(char[] a,char b[]){
        return find(a,b,a.length-1,b.length-1);
    }

    //查找最大公共子串，普通递归。时间复杂度，如果n=m,则O(n)=2^n
    public StringBuilder find(char[] a,char b[],int lastA,int lastB){
        //递归基
        if(lastA<0 || lastB<0){
            return new StringBuilder();
        }
        //如果最末尾字符相同，拼接最末尾字符，前面字符继续递归
        if( a[lastA] == b[lastB]){
            char c = a[lastA];
            lastA--;
            lastB--;
            return find(a,b,lastA,lastB).append(c);
        }
        //如果末尾不相同，则分两种情况：1、A末尾字符无法匹配上，则去除A末尾字符后继续递归
        //2、B末尾字符无法匹配上，则去除B末尾字符后继续递归。最后取两者中匹配到的最长串
        else {
            StringBuilder sb1 = find(a,b,lastA-1,lastB);
            StringBuilder sb2 = find(a,b,lastA,lastB-1);
            return sb1.length()>sb2.length() ? sb1 : sb2;
        }
    }
    //采用动态规划策略，以迭代方式,时间复杂度，O = n*m
    public StringBuilder findDynamic(char[] a,char[] b){
        StringBuilder[][] result = new StringBuilder[a.length][b.length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                if(i == 0 && j ==0){
                    if(b[j] == a[i]){
                        result[i][j] = new StringBuilder().append(a[0]);
                    }else {
                        result[i][j] = new StringBuilder();
                    }
                }else if(i == 0 && j!=0){
                    if(b[j] == a[i]){
                        result[i][j] = new StringBuilder().append(a[0]);
                    }else {
                        result[i][j] = new StringBuilder().append(result[i][j-1]);
                    }
                }else if(j==0 && i!=0){
                    if(b[j] == a[i]){
                        result[i][j] = new StringBuilder().append(b[0]);
                    }else {
                        result[i][j] = new StringBuilder().append(result[i-1][j]);
                    }
                }else{
                    if(b[j] == a[i]){
                        result[i][j] = new StringBuilder().append(result[i-1][j-1]).append(a[i]);
                    }else {
                        result[i][j] = result[i-1][j].length()>result[i][j-1].length() ? new StringBuilder().append(result[i-1][j]) : new StringBuilder().append(result[i][j-1]);
                    }
                }
            }
        }
        return result[a.length-1][b.length-1];
    }

    //采用动态规划策略，以颠倒的方法进行递归,时间复杂度，O = n*m
    public StringBuilder findDynamicRecursion(char[] a,char[] b){
        //TODO 不会，待补充
        return null;
    }
}
