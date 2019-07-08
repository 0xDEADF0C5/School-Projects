// Erik Neu
public class HW2 {
  
  // method tests if all letters in a string are english letters
  public static boolean onlyEnglishLetters(String s) {
    if (s.length() == 0) {
      return false;
    }
    for (int i = 0; i < s.length(); i++) {
      if (!Character.isLetter(s.charAt(i))) {
        return false;
      }
    }
    return true;
  }
  
  // method replaces the kth occurence of a letter of a string with a different character
  public static String replaceKth(char a, char x, int k, String s) {
    // variable keeps track of how many letters of the type to be replaced there are
    int letterCount = 0;
    // StringBuilder to print the resulting string
    StringBuilder b = new StringBuilder();
    for (int i = 0; i < s.length(); i++) {
      if ((char)a != s.charAt(i)) {
        b.append(s.charAt(i));
      }
      if ((char)a == s.charAt(i)) {
        letterCount = letterCount + 1;
        if (letterCount == k) {
          b.append((char)x);
        }
        else {
          b.append(s.charAt(i));
        }
      }
    }
    return b.toString();
  }
  
  // method merges two strings merges two strings together, but not like concatenation. the strings are weaved together
  public static String interleave(String a, String b) {
    // StringBuilder to print resulting string
    StringBuilder build = new StringBuilder();
    // variable stores what the shortest string length is
    int shortestLength = 0;
    if (a.length() <= b.length()) {
      shortestLength = a.length();
    }
    else {
      shortestLength = b.length();
    }
    for (int i = 0; i < shortestLength; i++) {
      build.append(a.charAt(i));
      build.append(b.charAt(i));
    }
    if (a.length() == shortestLength) {
      for (int i = shortestLength; i < b.length(); i++) {
        build.append(b.charAt(i));
      }
    }
    else {
      for (int i = shortestLength; i < a.length(); i++) {
        build.append(a.charAt(i));
      }
    }
    return build.toString();
  }
  
  // method blanks out the middle of words
  public static String blankWords(String s) {
    // StringBuilder to print resulting string
    StringBuilder b = new StringBuilder();
    for (int i = 0; i < s.length(); i++) {
      if (Character.isLetter(s.charAt(i)) && (i > 0) && (i < s.length() - 1)) {
        if (Character.isLetter(s.charAt(i-1)) && Character.isLetter(s.charAt(i + 1))) {
          b.append("_");
        }
        else {
          b.append(s.charAt(i));
        }
      }
      else
        b.append(s.charAt(i));
    }
    return b.toString();
  }
  
  // method prints every nth word of a string
  public static String nthWord(int n, String s) {
    // StringBuilder to print new string
    StringBuilder b = new StringBuilder();
    // word count keeps track of how many words are in the string
    int wordCount = 0;
    for (int i = 0; i < s.length(); i++) {
      if (Character.isLetter(s.charAt(i)) && (i > 0)) {
        if (s.charAt(i - 1) == ' ') {
          wordCount = wordCount + 1;
        }
      }
      if ((wordCount % (n + 1)) == 0) {
        if (Character.isLetter(s.charAt(i))) {
          b.append(s.charAt(i));
        }
        if (s.charAt(i) == ' ' && Character.isLetter(s.charAt(i - 1))) {
          wordCount = wordCount + 1;
          b.append(s.charAt(i));
        }
      }
    }
    if (b.toString().charAt(b.toString().length() - 1) == ' ') {
      // this string builder only builds if there is a space at the end of b.toString()
      StringBuilder d = new StringBuilder();
      for (int i = 0; i < b.toString().length() - 1; i++) {
        d.append(b.toString().charAt(i));
      }
      return d.toString();
    }
    else 
      return b.toString();
  }
  
  // method truncates a string at a hyphen of end of word
  public static String truncateAfter(int n, String s) {
    // String Builder prints only letter string
    StringBuilder b = new StringBuilder();

    // builder build the final string
    StringBuilder d = new StringBuilder();
    for (int i = 0; i < n; i++) {
      b.append(s.charAt(i));
    }
    for (int i = 0; i < b.toString().length(); i++) {
      if (Character.isLetter(b.toString().charAt(i))) {
        d.append(b.toString().charAt(i));
      }
      if (i < b.toString().length() - 1) {
        if ((b.toString().charAt(i) == ' ') && (Character.isLetter(b.toString().charAt(i + 1)))) {
          d.append(b.toString().charAt(i));
        }
      }
    }
    if (s.charAt(n) == '-') {
      d.append(s.charAt(n));
    }
    return d.toString();
  }
}