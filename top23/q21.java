import java.util.*;

class Book {
    private String title;
    private String author;
    private String ISBN;
    private boolean available;

    public Book(String title, String author, String ISBN) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.available = true;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getISBN() {
        return ISBN;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author + ", ISBN: " + ISBN + ", Available: " + available;
    }
}

class Library {
    private List<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void borrowBook(String ISBN) {
        for (Book book : books) {
            if (book.getISBN().equals(ISBN)) {
                if (book.isAvailable()) {
                    book.setAvailable(false);
                    System.out.println("Book borrowed successfully: " + book.getTitle());
                } else {
                    System.out.println("Book is not available for borrowing.");
                }
                return;
            }
        }
        System.out.println("Book with ISBN " + ISBN + " not found in the library.");
    }

    public void returnBook(String ISBN) {
        for (Book book : books) {
            if (book.getISBN().equals(ISBN)) {
                if (!book.isAvailable()) {
                    book.setAvailable(true);
                    System.out.println("Book returned successfully: " + book.getTitle());
                } else {
                    System.out.println("Book is already available.");
                }
                return;
            }
        }
        System.out.println("Book with ISBN " + ISBN + " not found in the library.");
    }

    public void searchByTitle(String title) {
        boolean found = false;
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                System.out.println(book);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No books found with title: " + title);
        }
    }

    public void searchByAuthor(String author) {
        boolean found = false;
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                System.out.println(book);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No books found with author: " + author);
        }
    }

    public void displayAvailableBooks() {
        System.out.println("Available Books:");
        for (Book book : books) {
            if (book.isAvailable()) {
                System.out.println(book);
            }
        }
    }
}

public class q21 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Borrow Book");
            System.out.println("3. Return Book");
            System.out.println("4. Search by Title");
            System.out.println("5. Search by Author");
            System.out.println("6. Display Available Books");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter ISBN: ");
                    String ISBN = scanner.nextLine();
                    library.addBook(new Book(title, author, ISBN));
                    System.out.println("Book added successfully.");
                    break;
                case 2:
                    System.out.print("Enter ISBN of book to borrow: ");
                    String borrowISBN = scanner.nextLine();
                    library.borrowBook(borrowISBN);
                    break;
                case 3:
                    System.out.print("Enter ISBN of book to return: ");
                    String returnISBN = scanner.nextLine();
                    library.returnBook(returnISBN);
                    break;
                case 4:
                    System.out.print("Enter title to search: ");
                    String searchTitle = scanner.nextLine();
                    library.searchByTitle(searchTitle);
                    break;
                case 5:
                    System.out.print("Enter author to search: ");
                    String searchAuthor = scanner.nextLine();
                    library.searchByAuthor(searchAuthor);
                    break;
                case 6:
                    library.displayAvailableBooks();
                    break;
                case 7:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
