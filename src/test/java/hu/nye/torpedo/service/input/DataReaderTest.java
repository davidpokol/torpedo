package hu.nye.torpedo.service.input;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doThrow;

import java.io.BufferedReader;
import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)


public class DataReaderTest {

    private static final String STRING_INPUT = "input";
    private static final int INTEGER_INPUT = 10;

    @Mock
    private BufferedReader bufferedReader;

    private DataReader underTest;

    @BeforeEach
    public void setUp() {
        underTest = new DataReader(bufferedReader);
    }

    @Test
    public void testReadInputShouldReturnStringInputReadByBufferedReader() throws IOException {

        //Given
        given(bufferedReader.readLine()).willReturn(STRING_INPUT);

        //When
        String result = underTest.readInput();

        //Then
        assertEquals(STRING_INPUT, result);

    }

    @Test
    public void testReadInputShouldReturnNullWhenBufferedReaderThrowsException() throws IOException {

        //Given
        doThrow(IOException.class).when(bufferedReader).readLine();

        //When
        String result = underTest.readInput();

        //Then
        assertNull(result);
    }
}
