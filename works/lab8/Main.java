import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        DataManager dataManager = new DataManager();
        dataManager.registerDataProcessor(new DataProcessors());


        dataManager.loadData("C:\\Users\\elik1\\OneDrive\\Рабочий стол\\лабы\\ИТиП\\Лабы\\Лабораторная работа №8\\lab8\\input.txt");

        dataManager.processData();

        dataManager.saveData("C:\\Users\\elik1\\OneDrive\\Рабочий стол\\лабы\\ИТиП\\Лабы\\Лабораторная работа №8\\lab8\\output.txt");
    }
}