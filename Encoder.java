import java.util.Scanner;

public class Encoder {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter text for encoding");
        String input = sc.nextLine();
        String encodedString = encode(input);
        String appendOffSet = Character.toString(input.charAt(0));
        String decodeString = decode(appendOffSet+encodedString);

        System.out.println(encodedString);
        System.out.println(decodeString);

    }



    public static String encode (String plainText){

        String s = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789()*+,-./";
        String encode = new String();
        int offset = s.indexOf(plainText.charAt(0)) ;

        for(int i=0; i<plainText.length()-1; i++){

           if(s.contains( Character.toString(plainText.charAt(i+1)))){
               int pos = s.indexOf(plainText.charAt(i+1)) - offset;
               if(pos < 0){
                  String reversed = new StringBuilder(s).reverse().toString();
                   char str = reversed.charAt( Math.abs(pos) - 1);
                   encode += str;
               }else{
                   char str =  s.charAt( s.indexOf(plainText.charAt(i+1)) - offset)  ;
                   encode += str;
               }

           }else{
               encode += plainText.charAt(i+1);
           }

        }

        return encode;

    }


    public static String decode (String encodedText){
        String s = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789()*+,-./";
        String decode = new String();
        int offset = s.indexOf(encodedText.charAt(0)) ;

        for(int i=0; i<encodedText.length()-1; i++){

            if(s.contains( Character.toString(encodedText.charAt(i+1)))){

                int pos = s.indexOf(encodedText.charAt(i+1)) + offset;
                if(pos > 44){
                    int tempOffSet = offset;

                    String reversed = new StringBuilder(s).reverse().toString();
                    int addBackToOffSet = reversed.indexOf(encodedText.charAt(i+1)) + 1;
                    tempOffSet -= addBackToOffSet;

                    char str =  s.charAt(tempOffSet)  ;
                    decode += str;
                }else{
                    char str =  s.charAt( s.indexOf(encodedText.charAt(i+1)) + offset)  ;
                    decode += str;
                }

            }else{
                decode += encodedText.charAt(i+1);
            }

        }
        return decode;
    }

}
