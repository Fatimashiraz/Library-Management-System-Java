// Magazine class inherits from LibraryItem
// It represents magazines stored in the library

public class Magazine extends LibraryItem {

    // Private attributes (Encapsulation)
    private int issueNumber;
    private String publisher;

    // Constructor to initialize magazine details
    public Magazine(String itemId, String title, int issueNumber, String publisher) {
        // Call constructor of the parent class (LibraryItem)
        super(itemId, title);
        this.issueNumber = issueNumber;
        this.publisher = publisher;
    }

    // Getter for issue number
    public int getIssueNumber() {
        return issueNumber;
    }

    // Setter for issue number
    public void setIssueNumber(int issueNumber) {
        this.issueNumber = issueNumber;
    }

    // Getter for publisher
    public String getPublisher() {
        return publisher;
    }

    // Setter for publisher
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    // Overriding the abstract method from LibraryItem
    // This demonstrates polymorphism
    @Override
    public void displayInfo() {
        System.out.println("Magazine ID: " + getItemId());
        System.out.println("Title: " + getTitle());
        System.out.println("Issue Number: " + issueNumber);
        System.out.println("Publisher: " + publisher);
        System.out.println("Issued: " + isIssued());
        System.out.println("---------------------");
    }
}