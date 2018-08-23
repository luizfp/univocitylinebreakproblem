import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;
import org.junit.Test;

import java.io.File;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created on 22/08/2018
 *
 * @author Luiz Felipe (https://github.com/luizfp)
 */
public class LineBreakProblemTest {
    private static final String TARGET_PATH = System.getProperty("user.dir");
    private static final String FILE_NAME = "file_test.csv";

    @Test
    public void testLineBreak() {
        final File file = new File(TARGET_PATH, FILE_NAME);
        final CsvParserSettings settings = new CsvParserSettings();
        settings.setDelimiterDetectionEnabled(true);
        settings.setHeaderExtractionEnabled(true);
        final CsvParser parser = new CsvParser(settings);
        final List<String[]> rows = parser.parseAll(file);
        assertEquals(1, rows.size());
        assertEquals(8, rows.get(0).length);
    }
}
