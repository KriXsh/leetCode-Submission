class sumOfDigitOfStrings1945 {
    public int getLucky(String s, int k) {
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()){
            sb.append(String.valueOf(c-'a'+1));
        }
        String ans = sb.toString();
        for(int i=0; i<k; i++){
            int num = 0;
            for(char c : ans.toCharArray()){
                num +=(c-'0');
            }
            ans = String.valueOf(num);
        }
        return Integer.parseInt(ans);

    }
}