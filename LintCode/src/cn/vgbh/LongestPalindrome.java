package cn.vgbh;

/*
 * ������Ӵ���
 * 
 * ����
 * �����ַ��� "abcdzdcab"������������Ӵ�Ϊ "cdzdc"��
 * 
 */

public class LongestPalindrome {

	/**
	 * �ַ�����������Ӵ�
	 * @param str
	 * @return �����Ӵ�
	 */
	public int longestPalindrome (String str) {
		//Ԥ����
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
	
	//Demo,���ö�̬�滮
    public int longestPalindrome2 (String s) {
        int n=s.length();
        boolean[][] pal=new boolean[n][n];
        //pal[i][j] ��ʾs[i...j]�Ƿ��ǻ��Ĵ�
        
        int maxLen=0;
        for (int i=0;i<n;i++){  // i��Ϊ�յ�
            int j=i;    //j��Ϊ���
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
    #Ԥ����
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
        #������չ��ע�⴦��߽�
        while i-RL[i]>=0 and i+RL[i]<len(s) and s[i-RL[i]]==s[i+RL[i]]:
            RL[i]+=1
        #����MaxRight,pos
        if RL[i]+i-1>MaxRight:
            MaxRight=RL[i]+i-1
            pos=i
        #��������Ĵ��ĳ���
        MaxLen=max(MaxLen, RL[i])
    return MaxLen-1
    	
	 */
	
	
	public static void main(String[] args) {
		
		LongestPalindrome longest = new LongestPalindrome();
		int s = longest.longestPalindrome2("detartrated");//11
		System.out.println(s);
		
		
	}
	
	
}
