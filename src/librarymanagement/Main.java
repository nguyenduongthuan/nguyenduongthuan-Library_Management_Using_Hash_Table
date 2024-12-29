package librarymanagement;

import java.util.Scanner;

public class Main {

    static final int MOD = 100000000;

    public static void main(String[] args) {
        Library library = new Library();
        String url;
        url = "D:\\Java\\Java-A-Diep\\LibraryManagement_F_Code_Challenge3\\bookList.txt";
        library.loadFromFile(url, "Đọc file không thành công");
        Scanner sc = new Scanner(System.in);
        library.report();
        // library.listBooks();
        // Tìm sách theo ISBN với hash table
        //Yêu cầu cilent nhâp ISBN
        System.out.println("\n- Enter ISBN you want to find: ");
        String isbnToFind = sc.nextLine();
        long start = System.nanoTime();
        Book book = library.findBookByIsbn(isbnToFind);
        if (book != null) {
            System.out.println("\nBook found by ISBN with hash table: \n" + "{\n" + "    " + book + "\n}");
            long end = System.nanoTime();
            System.out.println("Time of execution: " + (end - start) / 1e9);
        } else {
            System.out.println("\nNo book found with ISBN " + isbnToFind);
        }
        // Tìm sách bằng ISBN với ArrayList bằng sequential search
        start = System.nanoTime();
        book = library.findBookByIsbnByArrayList(isbnToFind);
        if (book != null) {
            System.out.println("\nBook found by ISBN with sequential search: \n" + "{\n" + "    " + book + "\n}");
            long end = System.nanoTime();
            System.out.println("Time of execution: " + (end - start) / 1e8);
        } else {
            System.out.println("\nNo book found with ISBN " + isbnToFind);
        }

    }
}
