import java.util.*;

class Solution {
    //*****************list.size -> url************
    /*List<String> urls = new ArrayList<String>();
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        urls.add(longUrl);
        return String.valueOf(urls.size()-1);
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        int index = Integer.valueOf(shortUrl);
        return (index<urls.size())?urls.get(index):"";
    }*/


 //ctrl+clik -> java sources code.

//*****************hashCode()************
/*  Map<Integer, String> map = new HashMap();
    String host = "http://tinyurl.com/";

    public String encode(String longUrl) {
        int key = longUrl.hashCode();
        map.put(key, longUrl);
        return host+key;
    }

    public String decode(String shortUrl) {
        int key = Integer.parseInt(shortUrl.replace(host,""));
        return map.get(key);
    }*/

/**    Map<String, String> url2code = new HashMap();
    Map<String, String> code2url = new HashMap();
    Random random = new Random();
    String host = "http://tinyurl.com/";
    char[] charset = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
    int size = charset.length;

    public String encode(String longUrl) {
        String code;
        if(url2code.containsKey(longUrl)){
             code = url2code.get(longUrl);
        }
        else{
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < 6; i++){
                int randomidx = random.nextInt(size);
                sb.append(charset[randomidx]);
            }
            code = sb.toString();
            url2code.put(longUrl,code);
            code2url.put(code,longUrl);
        }
        return host+code;
    }

    public String decode(String shortUrl) {

        String key = String.valueOf(shortUrl.replace(host,""));
        if(code2url.containsKey(key)){
            return code2url.get(key);
        }
        else
            return "";
    }*/


    // *****************Using One Map:
    //Map< index, longUrl>   index <-> shortUrl，


        Map<Integer, String> shortToLong = new HashMap<Integer, String>();
        String mapTable = "abcdefghijklmnopqrstuvwxyz0123456789-";

        // Encodes a URL to a shortened URL.
        public String encode(String longUrl) {
            shortToLong.put(shortToLong.size(), longUrl);

            int index = shortToLong.size();
            StringBuilder sb = new StringBuilder();
            while(index > 0) {
                int r = index % 37;
                index = index / 37;
                sb.append(mapTable.charAt(r));
            }

            return sb.toString();
        }

        // Decodes a shortened URL to its original URL.
        public String decode(String shortUrl) {
            StringBuilder sb = new StringBuilder();
            int base = 1;
            int index = 0;
            for (char c : shortUrl.toCharArray()) {
                index += base * mapTable.indexOf(c);
                base *= 37;
            }
            return shortToLong.get(index-1);
        }



    public static void main(String[] args) {
        Solution obj = new Solution();
        String longurl = "https://leetcode.com/problems/design-tinyurl";
        String tinyurl = obj.encode("https://leetcode.com/problems/design-tinyurl");
        String longurl2 = obj.decode(tinyurl);
        System.out.println(tinyurl);
        System.out.println(longurl2);
        System.out.println(longurl.equals(longurl2));
    }

}

