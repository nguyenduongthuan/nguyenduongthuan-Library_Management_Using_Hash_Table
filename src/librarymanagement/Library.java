package librarymanagement;

import enums.State;
import hashtable.HashTableADT;
import hashtable.SeparateChainingHashTable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.StringTokenizer;
import utils.HandleFile;

public class Library implements HandleFile<Book>{
    private HashTableADT<String, Book> books;
    private ArrayList<Book> booksByArrayList = new ArrayList<>();
    public int availableBooks = 0;
    public int borrowedBooks = 0;
    public HashMap<String, ArrayList<String>> bookGenres = new HashMap<>();
    public HashMap<String, ArrayList<String>> bookAuthors = new HashMap<>();
    public HashMap<String, ArrayList<String>> bookTitles = new HashMap<>();
    public HashMap<String, Integer> notAvailableBooks = new HashMap<>();
    public Library() {
        // books = new HashMap<>();
        books =  new SeparateChainingHashTable<>(Main.MOD);
        booksByArrayList = new ArrayList<>();
    }

    
    
    // Thêm sách vào thư viện
    public void addBook(Book book) {
        // books.put(book.getIsbn(), book);
        books.insert(book.getIsbn(), book);
    }

    // Thêm sách vào thư viện bằng ArrayList
    public void addBookByArrayList(Book book) {
        booksByArrayList.add(book);
    }
    // Phương thức tạo danh sách sách ngẫu nhiên
    public void generateBooks(int numBooks) {
        Random rand = new Random();
        // List<Book> books = new ArrayList<>();
        // Mảng dữ liệu tên sách, tác giả và ISBN mẫu
        String[] sampleTitles = {
            "The Great Gatsby", "To Kill a Mockingbird", "1984", "Pride and Prejudice", "Moby Dick", "War and Peace", "The Odyssey", "The Hobbit", "Fahrenheit 451", "Catch-22", 
            "The Catcher in the Rye", "The Lord of the Rings", "Animal Farm", "Brave New World", "The Brothers Karamazov", "Jane Eyre", "Wuthering Heights", "Crime and Punishment", "The Picture of Dorian Gray", "Great Expectations", 
            "The Chronicles of Narnia", "Les Misérables", "The Adventures of Huckleberry Finn", "Frankenstein", "The Grapes of Wrath", "Don Quixote", "Ulysses", "The Bell Jar", "The Shining", "The Road", 
            "The Book Thief", "War and Peace", "Dracula", "Slaughterhouse-Five", "The Alchemist", "Gone with the Wind", "The Hobbit", "A Tale of Two Cities", "Heart of Darkness", "The Scarlet Letter", 
            "The Divine Comedy", "Catch-22", "Of Mice and Men", "One Hundred Years of Solitude", "The Lord of the Flies", "The Secret Garden", "The Diary of a Young Girl", "The Outsiders", "The Color Purple", "The Fault in Our Stars", 
            "The Old Man and the Sea", "The Sun Also Rises", "1984", "The Book Thief", "The Road", "The Kite Runner", "Life of Pi", "The Great Gatsby", "To Kill a Mockingbird", "Pride and Prejudice", 
            "The Catcher in the Rye", "Frankenstein", "The Chronicles of Narnia", "War and Peace", "A Game of Thrones", "The Hunger Games", "The Fault in Our Stars", "The Shack", "The Lovely Bones", "The Night Circus", 
            "The Secret History", "A Tale of Two Cities", "Wuthering Heights", "The Time Traveler's Wife", "The Hobbit", "Moby Dick", "Les Misérables", "The Odyssey", "Fahrenheit 451", "Don Quixote", 
            "The Picture of Dorian Gray", "The Catcher in the Rye", "The Brothers Karamazov", "Brave New World", "To Kill a Mockingbird", "The Girl on the Train", "The Goldfinch", "The Nightingale", "Big Little Lies", "The Silent Patient", 
            "Educated", "Where the Crawdads Sing", "The Handmaid's Tale", "The Girl with the Dragon Tattoo", "The Help", "The Light We Lost", "The Woman in the Window", "The Couple Next Door", "The Seven Husbands of Evelyn Hugo", "The Paris Library", 
            "The Midnight Library", "The Four Agreements", "Becoming", "The Secret", "The Road Less Traveled", "The Art of War", "The 5th Wave", "The Maze Runner", "The Dark Tower", "The City of Ember", 
            "The Giver", "The House on Mango Street", "The Secret Garden", "The Hunger Games", "The Wizard of Oz", "The Fault in Our Stars", "The Night Circus", "The Tattooist of Auschwitz", "The Martian", "The Handmaid's Tale", 
            "The Invention of Wings", "The Silent Corner", "The Lying Game", "The Kiss Quotient", "The Water Dancer", "The Light Between Oceans", "The Rosie Project", "The Midnight Library", "The Wife Between Us", "The Couple Next Door", 
            "The Golden Compass", "The Tipping Point", "The Stranger", "The Secret Garden", "The Bell Jar", "The Girl on the Train", "The 5th Wave", "The Shining", "The Light We Lost", "The Girl with the Louding Voice", 
            "The Seven Husbands of Evelyn Hugo", "The Invisible Man", "The Ocean at the End of the Lane", "The Book Thief", "The Song of Achilles", "The Light Between Oceans", "The Silent Patient", "The Rosie Project", "The Wife Between Us", "The Giver", 
            "The Raven Boys", "The House of the Spirits", "The Outsiders", "The Unlikely Pilgrimage of Harold Fry", "The Girl Who Lived", "The Wife Between Us", "The Book Thief", "The Hundred-Year-Old Man Who Climbed Out the Window and Disappeared", "The Girl in the Spider's Web", "The Night Gardener", 
            "The 100-Year-Old Man Who Climbed Out the Window", "The Devil in the White City", "The Shadow of the Wind", "The Last Thing He Told Me", "The Tattooist of Auschwitz", "The Whisper Man", "The Silent Corner", "The Night Swim", "The Silent Sister", "The Housekeeper and the Professor", 
            "The Woman in the Window", "The Sisters", "The Girl with the Pearl Earring", "The Lying Game", "The Help", "The Kitchen House", "The Paper Palace", "The Ocean at the End of the Lane", "The Night Circus", "The Love Hypothesis", 
            "The Happiness Project", "The Fault in Our Stars", "The Rosie Project", "The Silent Patient", "The Wife Between Us", "The Unhoneymooners", "The Princess Bride", "The Hitchhiker's Guide to the Galaxy", "The Hobbit", "The Lion and the Wardrobe", 
            "The Call of the Wild", "The Secret Life of Bees", "The Penderwicks", "The Red Tent", "The Time Traveler's Wife", "The Shadow of the Wind", "The Devil Wears Prada", "The Great Alone", "The Hound of the Baskervilles", "The Night Watch", 
            "The Paris Wife", "The Help", "The Secret History", "The Book Thief", "The Girl with the Dragon Tattoo", "The Road", "The Hunger Games", "The Nightingale", "The Giver", "The Outsiders",
            "The Fault in Our Stars", "The 5th Wave", "The Maze Runner", "The Night Circus", "The Secret Garden", "The Little Prince", "The House on Mango Street", "The Perks of Being a Wallflower", "The Paper Palace", "The Rosie Project",
            "The Rosie Project", "The Paper Palace", "The Outsiders", "The House on Mango Street", "The Light We Lost", "The Book Thief", "The Midnight Library", "The Night Circus", "The Housekeeper and the Professor", "The Lying Game",
            "The Rosie Project", "The Secret Garden", "The Secret History", "The Fault in Our Stars", "The Help", "The Paper Palace", "The Girl Who Lived", "The Night Circus", "The Rosie Project", "The Midnight Library",
            "The House on Mango Street", "The Secret Garden", "The Paper Palace", "The Girl Who Lived", "The Secret History", "The Night Circus", "The Rosie Project", "The Housekeeper and the Professor", "The Light We Lost", "The Night Circus"
        };
        String[] sampleAuthors = {
            "F. Scott Fitzgerald", "Harper Lee", "George Orwell", "Jane Austen", "Herman Melville", "Leo Tolstoy", "Homer", "J.R.R. Tolkien", "Ray Bradbury", "Joseph Heller", 
            "J.D. Salinger", "J.R.R. Tolkien", "George Orwell", "Aldous Huxley", "Fyodor Dostoevsky", "Charlotte Brontë", "Emily Brontë", "Fyodor Dostoevsky", "Oscar Wilde", "Charles Dickens", 
            "C.S. Lewis", "Victor Hugo", "Mark Twain", "Mary Shelley", "John Steinbeck", "Miguel de Cervantes", "James Joyce", "Sylvia Plath", "Stephen King", "Cormac McCarthy", 
            "Markus Zusak", "Leo Tolstoy", "Bram Stoker", "Kurt Vonnegut", "Paulo Coelho", "Margaret Mitchell", "J.R.R. Tolkien", "Charles Dickens", "Joseph Conrad", "Nathaniel Hawthorne", 
            "Dante Alighieri", "Joseph Heller", "John Steinbeck", "Gabriel García Márquez", "William Golding", "Frances Hodgson Burnett", "Anne Frank", "S.E. Hinton", "Alice Walker", "John Green", 
            "Ernest Hemingway", "F. Scott Fitzgerald", "J.K. Rowling", "Toni Morrison", "J.R.R. Tolkien", "George Orwell", "Haruki Murakami", "J.K. Rowling", "John Green", "Cheryl Strayed", 
            "Paula Hawkins", "Gillian Flynn", "Lisa Jewell", "Taylor Jenkins Reid", "Tana French", "Jodi Picoult", "Markus Zusak", "Jojo Moyes", "Greer Hendricks", "Sarah Pekkanen", 
            "Matthew Quick", "Erin Morgenstern", "Donna Tartt", "Rebecca Serle", "Jeanette Walls", "Lisa See", "Paula McLain", "E. L. James", "Ruth Ware", "Alice Sebold", 
            "Sally Rooney", "Emily Giffin", "Nicholas Sparks", "Patricia Highsmith", "Gillian Flynn", "Catherine Ryan Howard", "William Peter Blatty", "Stephen King", "Shirley Jackson", "Alice Munro", 
            "George R.R. Martin", "Veronica Roth", "Suzanne Collins", "Sophie Kinsella", "Antoine de Saint-Exupéry", "Sherman Alexie", "Catherine Ryan Howard", "Khaled Hosseini", "Ruth Ware", "J.D. Salinger", 
            "Tana French", "George Orwell", "Stephen King", "Emily Brontë", "Pat Conroy", "Stephen King", "Gillian Flynn", "J.R.R. Tolkien", "Margaret Atwood", "Mark Haddon", 
            "Isabel Allende", "Kristin Hannah", "Fredrik Backman", "John Grisham", "David Mitchell", "Zadie Smith", "Jonathan Franzen", "Gabriel García Márquez", "Jodi Picoult", "George R.R. Martin", 
            "J.K. Rowling", "Ken Follett", "Hanya Yanagihara", "Claudia Rankine", "Malcolm Gladwell", "Daphne du Maurier", "Leo Tolstoy", "J.K. Rowling", "F. Scott Fitzgerald", "Margaret Atwood", 
            "J.R.R. Tolkien", "Mitch Albom", "Agatha Christie", "J.R.R. Tolkien", "Dan Brown", "Charles Dickens", "Louisa May Alcott", "C.S. Lewis", "Terry Pratchett", "Stephen King", 
            "John Steinbeck", "Truman Capote", "Ian McEwan", "Mark Twain", "Tom Clancy", "Kurt Vonnegut", "Marcel Proust", "John Grisham", "Paulo Coelho", "William Faulkner", 
            "E. L. James", "John Boyne", "Maggie O'Farrell", "Barbara Kingsolver", "Jane Austen", "Stephen King", "Louise Erdrich", "Roald Dahl", "Margaret Atwood", "Leo Tolstoy", 
            "David Foster Wallace", "Sarah Waters", "Herman Melville", "Jonathan Safran Foer", "Charles Dickens", "Jane Austen", "Hugh Howey", "Suzanne Collins", "Philip K. Dick", "Jean-Paul Sartre", 
            "Haruki Murakami", "Raymond Carver", "Donna Tartt", "J.R.R. Tolkien", "Gabriel García Márquez", "Margaret Mitchell", "J.K. Rowling", "Haruki Murakami", "Emily Dickinson", "Zadie Smith", 
            "Kurt Vonnegut", "Toni Morrison", "J.R.R. Tolkien", "George Orwell", "Markus Zusak", "Haruki Murakami", "F. Scott Fitzgerald", "Franz Kafka", "Virginia Woolf", "J.D. Salinger", 
            "Ken Kesey", "Aldous Huxley", "Ernest Hemingway", "Paulo Coelho", "William Faulkner", "Charlotte Perkins Gilman", "Marilynne Robinson", "Wally Lamb", "Ann Patchett", "J.R.R. Tolkien", 
            "Neil Gaiman", "Suzanne Collins", "Michael Ende", "Stephen King", "Edgar Allan Poe", "Louise Penny", "Christopher Paolini", "Terry Pratchett", "Mark Haddon", "Rick Riordan"
        };
        String[] sampleGenres = {
            "Fiction","Fantasy","Historical Fiction","Dystopian","Romance","Adventure","Horror","Thriller","Young Adult","Coming-of-Age","Science Fiction","Psychological Fiction","Children's Literature",
            "Mystery","Crime","Action","Drama","Humor","Biography","Autobiography","Memoir","Non-fiction","Cookbooks","Self-Help","Philosophy","Psychology","Health","Business","Politics","Economics","Technology",
            "Art","Poetry","Short Stories","Travel","True Crime","Religion","Spirituality","Spiritual Fiction","Graphic Novels","Comic Books","Anthology","Classics","Literary Fiction","Contemporary Fiction","Western",
            "Gothic Fiction","Fairy Tales","Fables","Mythology","Urban Fiction","Historical Romance","Action and Adventure","Young Adult Fiction","Teen Fiction","New Adult","Paranormal Fiction","Magical Realism","Alternate History",
            "Speculative Fiction","Cyberpunk","Steampunk","Space Opera","Superheroes","Supernatural","Military Fiction","Alternate Reality","Environmental Fiction","Cli-Fi","Literary Non-fiction","Journalism","Graphic Memoir"
        };
        for (int i = 0; i < numBooks; i++) {
            // Chọn tên sách ngẫu nhiên từ mảng
            String title = sampleTitles[rand.nextInt(sampleTitles.length)];
            // Chọn tác giả ngẫu nhiên từ mảng
            String author = sampleAuthors[rand.nextInt(sampleAuthors.length)];
            // Chọn thể loại ngẫu nhiên từ mảng
            String genre = sampleGenres[rand.nextInt(sampleGenres.length)];
            //chọn tình trạng ngẫu nhiên từ class enum State
            State state = State.values()[rand.nextInt(2)];
            // Tạo ISBN ngẫu nhiên
            String isbn = "978" + String.format("%09d", rand.nextInt(1000000000));
            // Tạo năm xuất bản ngẫu nhiên trong khoảng từ 1800 đến 2023
            int year = rand.nextInt(224) + 1800;
            addBook(new Book(isbn, title, author, genre, state, year));
        }
        // return books;
    }

    // Tìm kiếm sách theo ISBN
    public Book findBookByIsbn(String isbn) {
        return books.get(isbn);
    }
    // Tìm kiếm sách theo ISBN bằng ArrayList
    public Book findBookByIsbnByArrayList(String isbn) {
        for (Book book : booksByArrayList) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        return null;
    }

    // Xóa sách khỏi thư viện
    public Book removeBook(String isbn) {
        return books.remove(isbn);
    }

    // Hiển thị tất cả sách trong thư viện
    public void listBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available in the library.");
            return;
        }
        System.out.println(books.toString());
    }
    



    @Override
    public void handleLine(String line) {
        StringTokenizer st = new StringTokenizer(line, ",");
        String isbn = st.nextToken().trim();
        String title = st.nextToken().trim();
        String author = st.nextToken().trim();
        String genre = st.nextToken().trim();
        State state = State.valueOf(st.nextToken().trim());
        int year = Integer.parseInt(st.nextToken().trim());
        //kiểm tra số sách có sẵn hay đã mượn
        if(state == State.AVAILABLE){
            availableBooks++;
        }else{
            borrowedBooks++;
        }
        //kiểm tra xem với một thể loại có bao nhiêu sách
        if(bookGenres.containsKey(genre)){
            bookGenres.get(genre).add(title);
        }else{
            ArrayList<String> list = new ArrayList<>();
            list.add(title);
            bookGenres.put(genre, list);
        }
        //kiểm tra xem với một tác giả có bao nhiêu sách
        if(bookAuthors.containsKey(author)){
            bookAuthors.get(author).add(title);
        }else{
            ArrayList<String> list = new ArrayList<>();
            list.add(title);
            bookAuthors.put(author, list);
        }
        //kiểm tra xem với một tên sách có bao nhiêu sách
        if(bookTitles.containsKey(title)){
            bookTitles.get(title).add(title);
        }else{
            ArrayList<String> list = new ArrayList<>();
            list.add(title);
            bookTitles.put(title, list);
        }
        //kiểm tra xem với một tên sách có bao nhiêu quyển sách đã được mượn(not available)
        if(notAvailableBooks.containsKey(title)){
            notAvailableBooks.put(title, notAvailableBooks.get(title) + 1);
        }else{
            notAvailableBooks.put(title, 1);
        }
        addBookByArrayList(new Book(isbn, title, author, genre, state, year));
        addBook(new Book(isbn, title, author, genre, state, year));
    }
    //báo cáo thống kê
    public void report(){
        //tổng số lượng sách 
        System.out.println("\n- Total number of books: " + books.size());
        System.out.println("\n- Number of available books: " + availableBooks);
        System.out.println("\n- Number of borrowed books: " + borrowedBooks);
        //top 5 thể loại sách nhiều nhất
        System.out.println("\n- Top 5 genres with the most books: ");
        bookGenres.entrySet().stream().sorted((e1, e2) -> e2.getValue().size() - e1.getValue().size()).limit(5).forEach(e -> System.out.println("   " + e.getKey() + ": " + e.getValue().size()));
        //top 5 tác giả có nhiều sách nhất
        System.out.println("\n- Top 5 authors with the most books: ");
        bookAuthors.entrySet().stream().sorted((e1, e2) -> e2.getValue().size() - e1.getValue().size()).limit(5).forEach(e -> System.out.println("   " + e.getKey() + ": " + e.getValue().size()));
        //top 5 sách được mượn nhiều nhất
        System.out.println("\n- Top 5 books borrowed the most: ");
        notAvailableBooks.entrySet().stream().sorted((e1, e2) -> e2.getValue() - e1.getValue()).limit(5).forEach(e -> System.out.println("   " + e.getKey() + ": " + e.getValue()));
        //top 5 quyển sách nhiều nhất trong thư viện
        System.out.println("\n- Top 5 books with the most copies in the library: ");
        bookTitles.entrySet().stream().sorted((e1, e2) -> e2.getValue().size() - e1.getValue().size()).limit(5).forEach(e -> System.out.println("   " + e.getKey() + ": " + e.getValue().size()));
    }
    
    
    
}



