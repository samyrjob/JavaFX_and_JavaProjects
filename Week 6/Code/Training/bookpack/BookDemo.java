package bookpack;

class Book {
    private String author;
    private String title;
    private int pubDate;

    Book(String a, String t, int p){
        author = a;
        title = t;
        pubDate = p;
    }

    void show(){
        System.out.println(this.author);
        System.out.println(this.title);
        System.out.println(this.pubDate);
        System.out.println();
    }
}

class BookDemo {

    public static void main(String[] args) {
        Book book = new Book("Orwell", "1984", 1948);
        book.show();
    }
}
