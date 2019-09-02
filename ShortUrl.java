import java.util.HashMap; 
import java.util.Random; 
import java.math.*; 
import java.lang.*; 
public class MyClass 
{ 
public static void main(String[] args) { 

shortURL toShortUrl = new shortURL("https://www.yahoo.com"); 
String shorturl=toShortUrl.getBase62From10(); 
System.out.println(shorturl); 
String originalURL =toShortUrl.getBase10From62("http://fkt.in/ABC"); 
System.out.println(originalURL); 

} 
} 
class shortURL{ 
final char[] corpus = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray(); 
HashMap<Integer, String> valueMap=new HashMap<Integer, String>(); 
String domain = "https://fkt.in"; 
String url = ""; 
Random rand=new Random(); 
int seed=101646; 

shortURL(String url){ 
valueMap.put(seed,url); 
url = url.substring(7); 
this.url = url; 

} 
public final String getBase62From10() 
{ 
String number = seed + ""; 
String code=""; 
char[] buf = new char[number.length()]; 
int charPos = number.length() - 1; 
BigInteger bigIntegerNumber = new BigInteger(number); 
BigInteger radix = BigInteger.valueOf(62); 

while (bigIntegerNumber.compareTo(radix) >= 0) 
{ 
buf[charPos--] = corpus[bigIntegerNumber.mod(radix).intValue()]; 
bigIntegerNumber = bigIntegerNumber.divide(radix); 
} 
buf[charPos] = corpus[bigIntegerNumber.intValue()]; 
code=new String(buf, charPos, (number.length() - charPos)); 

return domain + "/" +code; 
} 
public final String getBase10From62(String shortURL){ 

int i=0; 
int decimal=0; 
int pos = shortURL.lastIndexOf("/"); 
shortURL= shortURL.substring(pos+1); 

char[] url = shortURL.toCharArray(); 

for(int j=0;j<url.length;j++){ 
i=0; 
for(char c:corpus){ 
if(c==url[j]){ 

decimal+=i*Math.pow(62,url.length-j-1); 
} 
i=i+1; 
} 



} 



return valueMap.get(decimal); 
} 
}
