public class Book extends LibraryItem {

    private String author;
    private int pages;

    public Book(String itemId, String title, String author, int pages) {
        super(itemId, title);
        this.author = author;
        this.pages = pages;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    @Override
    public void displayInfo() {
        System.out.println("Book ID: " + getItemId());
        System.out.println("Title: " + getTitle());
        System.out.println("Author: " + author);
        System.out.println("Pages: " + pages);
        System.out.println("Issued: " + isIssued());
        System.out.println("---------------------");
    }
}