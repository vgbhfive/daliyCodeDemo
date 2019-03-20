package cn.vgbh;

/*
 * 最长回文子串：
 * 
 * 例：
 * 给出字符串 "abcdzdcab"，它的最长回文子串为 "cdzdc"。
 * 
 */

public class LongestPalindrome {

	/**
	 * 字符串的最长回文子串
	 * @param str
	 * @return 回文子串
	 */
	public int longestPalindrome (String str) {
		//预处理
		char[] arr = str.toCharArray();
		
		int[] RL = new int[arr.length];	
		int MaxRight = 0;
		int pos = 0;
		int MaxLen = 0;
		for (int i = 0; i < arr.length; i++) {
			if (i < MaxRight) {
				//RL[i]=getMinNum(RL[2*pos-i], MaxRight-i);
			} else {
				RL[i]=1;
			}
			while ((i-RL[i] > 0) && (i+RL[i] > arr.length) && (arr[i-RL[i]] == arr[i+RL[i]])) {
				RL[i] += 1;
			}
			if (RL[i] + i - 1 > MaxRight) {
				MaxRight = RL[i] + i - 1;
				pos = i;
			}
			//MaxLen = RL.getMaxNum();
		}
		
		return MaxLen;
	}
	
	//Demo,采用动态规划
    public int longestPalindrome2 (String s) {
        int n=s.length();
        boolean[][] pal=new boolean[n][n];
        //pal[i][j] 表示s[i...j]是否是回文串
        
        int maxLen=0;
        for (int i=0;i<n;i++){  // i作为终点
            int j=i;    //j作为起点
            while (j>=0){
                if (s.charAt(j)==s.charAt(i)&&(i-j<2||pal[j+1][i-1])){
                    pal[j][i]=true;
                   maxLen=Math.max(maxLen, i-j+1);
                }
                j--;
            }
        }
        
        return maxLen;
    }
	
	/*
	 * 
	#Python
	def manacher(s):
    #预处理
    s='#'+'#'.join(s)+'#'

    RL=[0]*len(s)
    MaxRight=0
    pos=0
    MaxLen=0
    for i in range(len(s)):
        if i<MaxRight:
            RL[i]=min(RL[2*pos-i], MaxRight-i)
        else:
            RL[i]=1
        #尝试扩展，注意处理边界
        while i-RL[i]>=0 and i+RL[i]<len(s) and s[i-RL[i]]==s[i+RL[i]]:
            RL[i]+=1
        #更新MaxRight,pos
        if RL[i]+i-1>MaxRight:
            MaxRight=RL[i]+i-1
            pos=i
        #更新最长回文串的长度
        MaxLen=max(MaxLen, RL[i])
    return MaxLen-1
    	
	 */
	
	
	public static void main(String[] args) {
		
		LongestPalindrome longest = new LongestPalindrome();
		int s = longest.longestPalindrome2("detartrated");//11
		System.out.println(s);
		
		
	}
	
	
}
