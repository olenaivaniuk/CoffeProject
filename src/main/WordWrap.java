package main;

public class WordWrap {

    public static String wrap(final String inputLine, final int lineLenght) {
        final StringBuilder accumulator = new StringBuilder();

        final int lenght = inputLine.length();
        accumulator.append(inputLine, 0, Math.min(lenght,lineLenght));

        if(inputLine.length() > lineLenght) {
            accumulator.append('\n');
            accumulator.append(inputLine, lineLenght, lenght);
        }

        return accumulator.toString();
    }
}
