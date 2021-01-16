package libarysystem4d;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

public class FileHandling {

    public static String folderDirectory = System.getProperty("user.dir") + "\\BookList.txt";

    public static void writeFile(ArrayList<Book> BookList) {

        try {
            FileWriter writeToFile = new FileWriter(folderDirectory, false);
            PrintWriter printToFile = new PrintWriter(writeToFile);
            for (int i = 0; i < BookList.size(); i++) {
                printToFile.println(BookList.get(i).toString());
            }
            printToFile.close();
            writeToFile.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    public static ArrayList<Book> readFile() {
        ArrayList<Book> BookList = new ArrayList<>();
        String lineFromFile;
        try {
            BufferedReader read = new BufferedReader(new FileReader(folderDirectory));
            while ((lineFromFile = read.readLine()) != null) {
                String[] BookDetails = lineFromFile.split(", ");
                //String name, String ISBN, double Price, String Author, String Genre
                Book NewBook = new Book(BookDetails[0], BookDetails[1], Double.parseDouble(BookDetails[2]), BookDetails[3], BookDetails[4]);
                BookList.add(NewBook);
            }
            read.close();

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return BookList;
    }

}

