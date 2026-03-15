// Member class represents a library user
// It stores member details and number of borrowed items

public class Member {

    // Private attributes (Encapsulation)
    private String memberId;
    private String memberName;
    private int borrowedCount;

    // Constructor to initialize member details
    public Member(String memberId, String memberName) {
        this.memberId = memberId;
        this.memberName = memberName;
        this.borrowedCount = 0;
    }

    // Getter for member ID
    public String getMemberId() {
        return memberId;
    }

    // Setter for member ID
    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    // Getter for member name
    public String getMemberName() {
        return memberName;
    }

    // Setter for member name
    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    // Getter for borrowed item count
    public int getBorrowedCount() {
        return borrowedCount;
    }

    // Setter for borrowed item count
    public void setBorrowedCount(int borrowedCount) {
        this.borrowedCount = borrowedCount;
    }

    // Method to display member information
    public void displayMemberInfo() {
        System.out.println("Member ID: " + memberId);
        System.out.println("Member Name: " + memberName);
        System.out.println("Borrowed Items: " + borrowedCount);
        System.out.println("---------------------");
    }
}