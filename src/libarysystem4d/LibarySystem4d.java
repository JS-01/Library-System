package libarysystem4d;

import java.util.Scanner;
import java.util.ArrayList;

public class LibarySystem4d {

    private static Scanner input = new Scanner(System.in);
    private static ArrayList<Book> Booklist = new ArrayList<>();
    private static ArrayList<Borrower> Borrowers = new ArrayList<>();
    private static ArrayList<Book> BorrowedBooksList = new ArrayList<>();

    public static void main(String[] args) {
        Booklist = FileHandling.readFile();
        MainMenu();
    }

    public static void MainMenu() {
        while (true) {
            System.out.println("Welcome to my libary ^o^");
            System.out.println("What would you like to do?");
            System.out.println("1 - Add a new book");
            System.out.println("2 - View all books");
            System.out.println("3 - Edit a book");
            System.out.println("4 - Delete a book");
            System.out.println("5 - Borrowing menu");

            System.out.println("0 - Exit");

            int UserChoice = input.nextInt();

            switch (UserChoice) {
                case 1:
                    AddBook();
                    break;
                case 2:
                    ViewAllBooks();
                    break;
                case 3:
                    EditBook();
                    break;
                case 4:
                    DeleteBook();
                    break;
                case 5:
                    BorrowerMenu();
                    break;
                case 0:
                    FileHandling.writeFile(Booklist);
                    System.exit(0);
            }
        }
    }

    public static void AddBook() {
        //String name, String ISBN, double Price, String Author, String Genre
        System.out.println("Please type in a name");
        input.nextLine();   //stops from skipping a line
        String name = input.nextLine();
        System.out.println("Please type in a ISBN");
        String ISBN = input.nextLine();
        System.out.println("Please type in a Price");
        double Price = input.nextDouble();
        System.out.println("Please type in a Author");
        input.nextLine();
        String Author = input.nextLine();
        System.out.println("Please type in a Genre");
        String Genre = input.nextLine();

        Book MyBook = new Book(name, ISBN, Price, Author, Genre);
        Booklist.add(MyBook);
    }

    public static void ViewAllBooks() {
        if (Booklist.isEmpty()) {
            System.out.println("Sorry there are no books in the libary right now");
        } else {
            for (int i = 0; i < Booklist.size(); i++) {
                System.out.println(Booklist.get(i).ToString());
            }
        }
    }

    public static void EditBook() {
        int Index = GetBookIndex();

        if (Index == -1) {
            System.out.println("Sorry that is not a vaild book");
        } else {
            System.out.println("What would you like to edit?");
            //String name, String ISBN, double Price, String Author, String Genre
            System.out.println("1 - Name");
            System.out.println("2 - ISBN");
            System.out.println("3 - Price");
            System.out.println("4 - Author");
            System.out.println("5 - Genre");
            System.out.println("6 - none of these never mind :D");

            int UserChoice = input.nextInt();

            switch (UserChoice) {
                case 1:
                    System.out.println("Please type in new Name");
                    input.nextLine();
                    String NewName = input.nextLine();
                    Booklist.get(Index).setName(NewName);
                    break;
                case 2:
                    System.out.println("Please type in new ISBN");
                    input.nextLine();
                    String NewISBN = input.nextLine();
                    Booklist.get(Index).setISBN(NewISBN);
                    break;
                case 3:
                    System.out.println("Please type in new Price");
                    input.nextLine();
                    double NewPrice = input.nextDouble();
                    Booklist.get(Index).setPrice(NewPrice);
                    break;
                case 4:
                    System.out.println("Please type in new Author");
                    input.nextLine();
                    String NewAuthor = input.nextLine();
                    Booklist.get(Index).setAuthor(NewAuthor);
                    break;
                case 5:
                    System.out.println("Please type in new Genre");
                    input.nextLine();
                    String NewGenre = input.nextLine();
                    Booklist.get(Index).setGenre(NewGenre);
                    break;
                case 6:
                    break;
            }
        }
        System.out.println("Books successfully changed to " + Booklist.get(Index).ToString());
    }

    public static void DeleteBook() {
        int Index = GetBookIndex(); //uses the method to find the book index

        if (Index == -1) {
            System.out.println("Sorry that is not a vaild book");
        } else {
            Booklist.remove(Index);
        }
    }

    public static int GetBookIndex() {
        //find out what book they want
        System.out.println("Please type in the book name");
        input.nextLine();
        String name = input.nextLine();
        System.out.println("Please type in the ISBN");
        String ISBN = input.nextLine();

        for (int i = 0; i < Booklist.size(); i++) {
            if (Booklist.get(i).getName().equals(name) && Booklist.get(i).getISBN().equals(ISBN)) {
                return i;
            }
        }
        return -1;
    }

    //Borrowing Books
    public static void BorrowerMenu() {
        String name = GetName();
        String email = GetEmail();

        while (true) {
            System.out.println("What would you like to do?");
            System.out.println("1 - View Borrowed books");
            System.out.println("2 - Add a new borrower");
            System.out.println("3 - Borrow a book");

            System.out.println("0 - Exit");

            int UserInput = input.nextInt();

            switch (UserInput) {
                case 1:
                    VeiwBorrowedBooks(name, email);
                    break;
                case 2:
                    AddBorrower(name, email);
                    break;
                case 3:
                    BorrowBook(name, email);
                    break;
                case 0:
                    System.exit(0);
                    break;
            }
        }
    }

    public static void AddBorrower(String x, String y) {
        //check they aren't already a borrower
        boolean ExistingBorrower = CheckExistingBorrower(x, y);

        //Add the borrower
        if (ExistingBorrower == false) {
            Borrower NewBorrower = new Borrower(x, y);
            Borrowers.add(NewBorrower);
        } else {
            System.out.println("You are already a borrower");
        }
    }

    public static boolean CheckExistingBorrower(String x, String y) {
        boolean ExistingBorrower = false;
        for (int i = 0; i < Borrowers.size(); i++) {
            if (Borrowers.size() == 0) {
                break;
            } else {
                if (Borrowers.get(i).getBorrowerName().equals(x) && Borrowers.get(i).getEmail().equals(y)) {
                    ExistingBorrower = true;
                }
            }
        }
        return ExistingBorrower;
    }

    public static String GetName() {
        System.out.println("Please enter your name");
        String name = input.nextLine();

        return name;
    }

    public static String GetEmail() {
        System.out.println("Please enter your email");
        String email = input.nextLine();

        return email;
    }

    public static void BorrowBook(String x, String y) {
        //get the book that they want
        int BookIndex = GetBookIndex();

        //get the borrower index
        int BorrowerIndex = GetBorrowerIndex(x, y);

        //have that book be moved into the borrowed book list of that borrower
        Borrowers.get(BorrowerIndex).AddToBorrowedBooks(Booklist.get(BookIndex));
        
        //remove the book from the book list
        Booklist.remove(BookIndex);
    }

    public static void VeiwBorrowedBooks(String x, String y) {
        int BorrowerIndex = GetBorrowerIndex(x, y);
        
        Borrowers.get(BorrowerIndex).PrintBorrowedBooks();
    }

    public static int GetBorrowerIndex(String x, String y) {
        //find out what borrower they are
        for (int i = 0; i < Borrowers.size(); i++) {
            if (Borrowers.get(i).getBorrowerName().equals(x) && Borrowers.get(i).getEmail().equals(y)) {
                return i;
            }
        }
        return -1;
    }
    
    
    
}
