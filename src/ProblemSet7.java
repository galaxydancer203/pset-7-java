import java.nio.charset.StandardCharsets;

public class ProblemSet7 {
    public static void main(String[] args) {

    }

    /*
     * Exercise 1.
     *
     * Given two strings, return a new string built by surrounding in with the first
     * and last two characters of out.
     */
    public String surroundMe(String in, String out) {
        if (in == null || out == null || out.length() != 4) {
            return in;
        }
        else {
            String firstHalf = out.substring(0,2);
            String secondHalf = out.substring(2,4);
            String newString = firstHalf + in + secondHalf;
            return newString;
        }
    }
    /*
     * Exercise 2.
     *
     * Given a string and an integer, return a new string that represents the first
     * and last n characters of text (overlapping, as needed).
     */
    public String endsMeet(String text, int n) {
        if (text == null || (text.length() > 10 || text.length() < 1) || (n<1 || n>text.length())) {
            return text;
        }
        else {
            String firstHalf = text.substring(0,n);
            String secondHalf = text.substring(text.length()-n, text.length());
            String outString = firstHalf + secondHalf;
            return outString;
        }
    }

    /*
     * Exercise 3.
     *
     * Given a string, return a new string using the middle three characters of text.
     */
    public String middleMan(String text) {
        if (text == null || text.length() % 2 != 1 || text.length() < 3) {
            return text;
        }
        else {
            String newString = text.substring((text.length()/2)-1, text.length()/2+2);
            return newString;
        }
    }
    /*
     * Exercise 4.
     *
     * Given two strings, determine whether or not target is equivalent to the middle
     * three characters of text.
     */
    public boolean isCentered(String text, String target) {
        if (text == null || text.length() % 2 != 1 || text.length() < 3 || target == null || target.length() != 3) {
            return false;
        }
        else {
            String middleString = text.substring((text.length()/2)-1, text.length()/2+2);
            if (middleString.equals(target)) {
                return true;
            }
            else {
                return false;
            }
        }
    }

    /*
     * Exercise 5.
     *
     * Given a string and a character, compute the number of words that end in suffix.
     */
    public int countMe(String text, char suffix) {
        String suffix1 = Character.toString(suffix);
        int counter = 0;
        if (text == null || !(Character.isLetter(suffix))) {
            return -1;
        } else {
            String [] words;
            words = text.split(" ", 1000);
            for (String word : words) {
                if (word.endsWith(suffix1)) {
                    counter++;
                }
            }
            return counter;
        }
    }
    /*
     * Exercise 6.
     *
     * Given a string, compute the number of triplets in text.
     */
    public int triplets(String text) {
        int count;
        if (text == null) {
            return -1;
        }
        else {
            count = 0;
            for (int k = 1; k < text.length()-1; k++) {
                if (text.charAt(k) == (text.charAt(k-1)) && text.charAt(k) == text.charAt(k+1)) {
                    count +=1;
                }
            }
            return count;
        }
    }

    /*
     * Exercise 7.
     *
     * Given a string, compute the sum of the digits in text.
     */
    public long addMe(String text) {
        long sum;
        if (text == null) {
            return -1;
        }
        else {
            sum = 0;
            for (int k = 0; k < text.length(); k ++) {
                if (Character.isDigit(text.charAt(k))) {
                    sum += Integer.parseInt(text.valueOf(text.charAt(k)));
                }
            }
            return sum;
        }
    }
    /*
     * Exercise 8.
     *
     * Given a string, compute the length of the longest sequence.
     */
    public long sequence(String text) {
        char character;
        char nextCharacter;
        int count = 1;
        int number = 1;
        if (text == null) {
            return -1;
        } else if (text.isEmpty() || text.isBlank()) {
            return 0;
        } else if (text.length() == 1) {
            return 1;
        } else {
            for (int n = 0; n < text.length(); n++) {
                character = text.charAt(n);
                if (n + 1 == text.length()) {
                    break;
                } else {
                    nextCharacter = text.charAt(n + 1);
                }
                if (character == nextCharacter) {
                    count++;
                }
                if (count > number) {
                    number = count;
                    count= 1;
                }
            }
            return number;
        }
    }

    /*
     * Exercise 9.
     *
     * Given two strings, return a new string built by intertwining each of the
     * characters of a and b.
     */
    public String intertwine(String a, String b) {
        char aChar;
        char bChar;
        String intertwine = "";
        int n = 0;
        if (a == null || b == null) {
            return null;
        } else {
            if (a.length() > b.length()) {
                for (n = 0; n < a.length(); n++) {
                    if (n != b.length()) {
                        aChar = a.charAt(n);
                        bChar = b.charAt(n);;

                        intertwine = intertwine + aChar + bChar;
                    } else {
                        break;
                    }
                }
                for (int j = n; j < a.length(); j++) {
                    aChar = a.charAt(j);
                    intertwine = intertwine + aChar;
                }
            } else if (b.length() > a.length()) {
                for (n = 0; n < b.length(); n++) {
                    if (n != a.length()) {
                        aChar = a.charAt(n);
                        bChar = b.charAt(n);;
                        intertwine = intertwine + aChar + bChar;
                    } else {
                        break;
                    }
                }
                for (int j = n; j < b.length(); j++) {
                    bChar= b.charAt(j);
                    intertwine = intertwine + bChar;
                }
            } else {
                for (n = 0; n < b.length(); n++) {
                    aChar = a.charAt(n);
                    bChar = b.charAt(n);;
                    intertwine = intertwine + aChar + bChar;
                }
            }
            return intertwine;
        }
    }

    /*
     * Exercise 10.
     *
     * Given a string, determine whether or not it is a palindrome.
     */
    public boolean isPalindrome(String text) {
        String firstHalf = "";
        String secondHalf = "";
        if (text == null) {
            return false;
        }
        else {
            if (text.length() % 2 == 0) {
                firstHalf = text.substring(0,text.length()/2);
                secondHalf = text.substring(text.length()/2, text.length());
            }
            else {
                firstHalf = text.substring(0,text.length()/2+1);
                secondHalf = text.substring(text.length()/2, text.length());
            }
            byte[] array = secondHalf.getBytes();
            byte[] reversed = new byte[array.length];
            for (int k = 0; k < reversed.length; k++) {
                reversed[k] = array[array.length - k -1];
            }
            String complete = new String(reversed, StandardCharsets.UTF_8);
            if (firstHalf.equals(complete)) {
                return true;
            }
            else {
                return false;
            }
        }
    }
}
