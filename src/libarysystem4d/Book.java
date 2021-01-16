
package libarysystem4d;

public class Book {
    
    private String name;
    private String ISBN;
    private double Price;
    private String Author;
    private String Genre;

    
    //constructor
    public Book(String name, String ISBN, double Price, String Author, String Genre) {
        this.name = name;
        this.ISBN = ISBN;
        this.Price = Price;
        this.Author = Author;
        this.Genre = Genre;
    }
    
    public String ToString(){
        return name+", "+ISBN+","+Price+", "+Author+", "+Genre;
    }
    
    //getter
    public String getName() {
        return name;
    }

    public String getISBN() {
        return ISBN;
    }

    public double getPrice() {
        return Price;
    }

    public String getAuthor() {
        return Author;
    }

    public String getGenre() {
        return Genre;
    }

    
    // setter
    public void setName(String name) {
        this.name = name;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public void setPrice(double Price) {
        this.Price = Price;
    }

    public void setAuthor(String Author) {
        this.Author = Author;
    }

    public void setGenre(String Genre) {
        this.Genre = Genre;
    }
    
    
    
}
