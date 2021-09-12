import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;


public class ParseCsvTest {


    @Test // Проверим, правильное ли количество сотрудников считывается из файла
    public void amountOfEmployeesCsv() throws IOException {
        // Assert
        final int correctNumberOfEmployees = 2;
        var sut = new Main();

        // Act
        final var result = sut.parseCSV(Main.columnMapping, Main.filename).size();

        // Arrange
        Assertions.assertEquals(correctNumberOfEmployees, result);
    }

    @Test // Проверим, что файл с исходными данными существует
    public void inputFileExists() {
        // Assert
        final boolean expected = true;

        // Act
        File inputData = new File("data.csv");
        final var result = inputData.exists();

        //Arrange
        Assertions.assertEquals(expected, result);
    }

    @Test // Проверим, что метод, делающий из листа JSON-строку возвращает не пустую строку
    public void jsonStringIsEmpty() throws IOException{
        // Assert
        final String emptyStr = "";
        final int unexpected = 0;
        List<Employee> testList = new LinkedList<>();
        testList.add(new Employee(12, "Groza", "Velikanov", "England", 27));
        testList.add(new Employee(12, "Povelitel", "Muh", "Czech", 10));
        var sut = new Main();

        // Act
        final var result = sut.listToJSON(testList).compareToIgnoreCase(emptyStr);

        // Arrange
        Assertions.assertNotEquals(unexpected, result);
    }
}
