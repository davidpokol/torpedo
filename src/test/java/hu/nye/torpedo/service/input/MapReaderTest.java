package hu.nye.torpedo.service.input;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doThrow;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import hu.nye.torpedo.service.exception.FileReadException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class MapReaderTest {

    private static final List<String> FILE_CONTENT = List.of("0010", "1001", "1001", "0001");

    @Mock
    private MapReader underTest;

    @BeforeEach
    public void setUp() {

        underTest = new MapReader();
    }

    @Test
    public void testReadMapShouldReturnRawMapFromBufferedReader() throws FileReadException, IOException {
        //Given

        //When
        List<String> actual = underTest.getLinesFromFile();

        //Then
        Assertions.assertEquals(FILE_CONTENT, actual);
    }
}
