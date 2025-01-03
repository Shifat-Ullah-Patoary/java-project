import java.util.ArrayList;
import java.util.Scanner;

public class LibraryManagementSystem {
    private static ArrayList<Book> books = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n=== Library Management System ===");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Search Book");
            System.out.println("4. Borrow Book");
            System.out.println("5. Return Book");
            System.out.println("6. Remove Book");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    addBook(scanner);
                    break;
                case 2:
                    viewBooks();
                    break;
                case 3:
                    searchBook(scanner);
                    break;
                case 4:
                    borrowBook(scanner);
                    break;
                case 5:
                    returnBook(scanner);
                    break;
                case 6:
                    removeBook(scanner);
                    break;
                case 7:
                    System.out.println("Exiting... Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void addBook(Scanner scanner) {
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter book author: ");
        String author = scanner.nextLine();
        books.add(new Book(title, author));
        System.out.println("Book added successfully!");
    }

    private static void viewBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in the library.");
        } else {
            System.out.println("\n=== List of Books ===");
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }

    private static void searchBook(Scanner scanner) {
        System.out.print("Enter title or author to search: ");
        String query = scanner.nextLine().toLowerCase();
        boolean found = false;

        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(query) || book.getAuthor().toLowerCase().contains(query)) {
                System.out.println(book);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No books found matching the search criteria.");
        }
    }

    private static void borrowBook(Scanner scanner) {
        System.out.print("Enter the title of the book to borrow: ");
        String title = scanner.nextLine();
        Book book = findBookByTitle(title);

        if (book != null) {
            book.borrowBook();
        } else {
            System.out.println("Book not found.");
        }
    }

    private static void returnBook(Scanner scanner) {
        System.out.print("Enter the title of the book to return: ");
        String title = scanner.nextLine();
        Book book = findBookByTitle(title);

        if (book != null) {
            book.returnBook();
        } else {
            System.out.println("Book not found.");
        }
    }

    private static void removeBook(Scanner scanner) {
        System.out.print("Enter the title of the book to remove: ");
        String title = scanner.nextLine();
        Book book = findBookByTitle(title);

        if (book != null) {
            books.remove(book);
            System.out.println("Book removed successfully!");
        } else {
            System.out.println("Book not found.");
        }
    }

    private static Book findBookByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }
}
