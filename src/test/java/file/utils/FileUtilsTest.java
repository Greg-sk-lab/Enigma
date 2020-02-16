package file.utils;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FileUtilsTest {
    private final int NUMBER_OF_FILE_LINES = 2;
    final String pathToFile = this.getClass().getResource("/FileUtils/test.txt").getPath();
    private final String firstLine = "Ala ma kota";

    @Test
    protected void testOFNumberofLineAreEquals() {
        String fileContent = FileTool.getFileContent(pathToFile);
        String[] split = fileContent.split("\n");

        Assertions.assertEquals(NUMBER_OF_FILE_LINES, split.length);

    }

    @Test
    protected void howDoesSplitWorks() {
        String textToSplit = "1,2,3,4,5";
        String[] split = textToSplit.split(",");
        for (String s : split) {
            System.out.println(s);
        }
        System.out.println(split.length);
    }

    @Test
    protected void testOFfirstLine() {
        String fileContent = FileTool.getFileContent(pathToFile);
        String[] split = fileContent.split("\n");

        Assertions.assertEquals(firstLine, split[0]);
    }

}
