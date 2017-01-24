c class LicenseKeyFormatting {
    public String licenseKeyFormatting(String S, int K) {
        //remove all dash characters and turn to upper case
        String noDash = S.replaceAll("-", "").toUpperCase();
        //get current length 
        int len = noDash.length();
        //if (len==0) return null;
        
        //get the length of first group
        int FirLen = len % K;
        
        StringBuilder res = new StringBuilder();
        res.append(noDash.substring(0, FirLen));
        
        for (int i=FirLen; i <= len - K; i = i + K) {
            res.append("-");
            res.append(noDash.substring(i,i+K));
        }
        if (FirLen == 0 && res.length() > 0) {
            res.deleteCharAt(0);
        }
        return res.toString();
    }
}
