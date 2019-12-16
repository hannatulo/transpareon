package htulowiecka.transpareon.io;

import java.io.*;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileDataReader implements DataReader {

    private Iterator<String> fileLines;

    public FileDataReader(String filepath) throws IOException {
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(filepath);
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))
        ) {
            fileLines = reader.lines()
                    .collect(Collectors.toList())
                    .iterator();
        }
    }

    @Override
    public boolean ready() {
        return fileLines.hasNext();
    }

    @Override
    public String readLine() {
        return fileLines.next();
    }
}
