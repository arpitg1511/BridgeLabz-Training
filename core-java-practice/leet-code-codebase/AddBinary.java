class Solution {
    public String addBinary(String a, String b) {
        String pre = "";

        if(a.length() < b.length()) {
            for(int i = 0; i < b.length() - a.length(); i++) {
                pre = pre + '0';
            }
            pre = pre + a;

            return helper(pre, b);
        }

    else{
        for(int i = 0; i < a.length() - b.length(); i++) {
            pre = pre + '0';
        }
        pre = pre + b;

        return helper(pre, a);
    }
    }

    public String helper(String a, String b) {
        StringBuilder sb = new StringBuilder();

        int i = a.length() - 1;

        int cy = 0;
        while(i >= 0) {
            int m = a.charAt(i) == '0' ? 0 : 1;
            int n = b.charAt(i) == '0' ? 0 : 1;

            if(m + n == 1) {
                if(cy == 1) {
                    sb.append(0);
                    cy = 1;
                }
                else {
                    sb.append(1);
                    cy = 0;
                }
            }

            else if(m + n == 2) {
                if(cy == 0) {
                    cy = 1;
                    sb.append(0);
                }
                else {
                    cy = 1;
                    sb.append(1);
                }
            }

            else {
                sb.append(cy);
                cy = 0;
            }
            i--;
        }
        if(cy == 1) sb.append(cy);

        return sb.reverse().toString();
    } 
}