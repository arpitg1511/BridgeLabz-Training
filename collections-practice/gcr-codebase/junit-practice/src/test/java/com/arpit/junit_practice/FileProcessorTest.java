package com.arpit.junit_practice;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.nio.file.*;

import org.junit.jupiter.api.*;

class FileProcessorTest {

    private FileProcessor fileProcessor;
    private Path tempFile;

    @BeforeEach
    void setUp() throws IOException {
        fileProcessor = new FileProcessor();
        tempFile = Files.createTempFile("junit-test", ".txt");
    }

    @AfterEach
    void tearDown() throws IOException {
        Files.deleteIfExists(tempFile);
    }

    // ✅ Content written & read correctly
    @Test
    void testWriteAndReadFile() throws IOException {
        String content = "Hello JUnit";

        fileProcessor.writeToFile(tempFile.toString(), content);
        String result = fileProcessor.readFromFile(tempFile.toString());

        assertEquals(content, result);
    }

    // ✅ File exists after writing
    @Test
    void testFileExistsAfterWriting() throws IOException {
        fileProcessor.writeToFile(tempFile.toString(), "Test content");

        assertTrue(Files.exists(tempFile));
    }

    // ✅ IOException when file does not exist
    @Test
    void testReadFromNonExistingFileThrowsException() {
        assertThrows(IOException.class, () -> {
            fileProcessor.readFromFile("non_existing_file.txt");
        });
    }
}

