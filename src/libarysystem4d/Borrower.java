package libarysystem4d;

import java.util.ArrayList;

public class Borrower {

    private String BorrowerName;
    private String Email;
    private static ArrayList<Book> BorrowedBooks = new ArrayList<>();

    //constructor
    public Borrower(String BorrowerName, String Email) {
        this.BorrowerName = BorrowerName;
        this.Email = Email;
    }

    public static void AddToBorrowedBooks(Book x) {
        BorrowedBooks.add(x);
    }
    
    public static void PrintBorrowedBooks() {
        for (int i = 0; i < BorrowedBooks.size(); i++) {
            System.out.println(BorrowedBooks.get(i) + ", ");
        }
    }

    //getter
    public String getBorrowerName() {
        return BorrowerName;
    }

    public String getEmail() {
        return Email;
    }

    public static ArrayList<Book> getBorrowedBooks() {
        return BorrowedBooks;
    }
    
    //setter
    public void setBorrowerName(String BorrowerName) {
        this.BorrowerName = BorrowerName;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

}
