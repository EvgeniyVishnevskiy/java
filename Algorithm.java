import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    private static String removeArticles(String text) {
        text = text.replaceAll("\\s*([Tt][h][e]|[Aa]|[Aa][n]|)\\s", " ");
        return text;
    }

      private static String removeLetterC(String text) {
        text = text.replaceAll("ci", "si");
            text = text.replaceAll("Ci", "Si");

        text = text.replaceAll("ce", "se");
          text = text.replaceAll("Ce", "Se");

        text = text.replaceAll("ck", "k");
          text = text.replaceAll("Ck", "K");

        text = text.replaceAll("C", "K");
            text = text.replaceAll("c", "k");
        return text;
    }

      private static String removeDoubleLetter(String text) {
          text = text.replaceAll("ee", "i");
          text = text.replaceAll("Ee", "I");
          text = text.replaceAll("oo", "u");
          text = text.replaceAll("Oo", "U");
          text = text.replaceAll("([a-z])\\1", "$1");
          return text;
      }

      private static String removeLetterE(String text) {
          Pattern pattern = Pattern.compile("\\S+[e](\\s|$|,|.|!|\\?)");
          Matcher matcher = pattern.matcher(text);
          while (matcher.find()) {
              text = text.replace("e", "");
          }
          return text;
      }

    public static void main(String[] args) {
        String output = "The Cacao and an coffee is the way to success. Check for Ooo, Oou, iee,  tttttte?";
        output = removeArticles(output);
        output = removeLetterC(output);
        output = removeDoubleLetter(output);
        output = removeLetterE(output);
        System.out.println(output);

    }

}
