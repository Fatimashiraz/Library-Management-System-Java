import java.util.ArrayList;
import java.util.Scanner;

// Main class to run the Library Management System
public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // ArrayLists to store library items and members
        ArrayList<LibraryItem> items = new ArrayList<>();
        ArrayList<Member> members = new ArrayList<>();

        int choice;

        do {
            // Display menu
            System.out.println("\n===== LIBRARY MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Book");
            System.out.println("2. Add Magazine");
            System.out.println("3. Add Member");
            System.out.println("4. Display All Items");
            System.out.println("5. Issue Item");
            System.out.println("6. Return Item");
            System.out.println("7. Delete Item");
            System.out.println("8. Display Members");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = input.nextInt();
            input.nextLine(); // Clear buffer

            switch (choice) {
                case 1:
                    // Add Book
                    System.out.print("Enter Book ID: ");
                    String bookId = input.nextLine();

                    System.out.print("Enter Book Title: ");
                    String bookTitle = input.nextLine();

                    System.out.print("Enter Author Name: ");
                    String author = input.nextLine();

                    System.out.print("Enter Number of Pages: ");
                    int pages = input.nextInt();
                    input.nextLine();

                    Book book = new Book(bookId, bookTitle, author, pages);
                    items.add(book);

                    System.out.println("Book added successfully.");
                    break;

                case 2:
                    // Add Magazine
                    System.out.print("Enter Magazine ID: ");
                    String magazineId = input.nextLine();

                    System.out.print("Enter Magazine Title: ");
                    String magazineTitle = input.nextLine();

                    System.out.print("Enter Issue Number: ");
                    int issueNumber = input.nextInt();
                    input.nextLine();

                    System.out.print("Enter Publisher: ");
                    String publisher = input.nextLine();

                    Magazine magazine = new Magazine(magazineId, magazineTitle, issueNumber, publisher);
                    items.add(magazine);

                    System.out.println("Magazine added successfully.");
                    break;

                case 3:
                    // Add Member
                    System.out.print("Enter Member ID: ");
                    String memberId = input.nextLine();

                    System.out.print("Enter Member Name: ");
                    String memberName = input.nextLine();

                    Member member = new Member(memberId, memberName);
                    members.add(member);

                    System.out.println("Member added successfully.");
                    break;

                case 4:
                    // Display all items
                    if (items.isEmpty()) {
                        System.out.println("No items available in the library.");
                    } else {
                        System.out.println("\n--- Library Items ---");
                        for (LibraryItem item : items) {
                            item.displayInfo(); // Runtime polymorphism
                        }
                    }
                    break;

                case 5:
                    // Issue item to member
                    System.out.print("Enter Item ID to issue: ");
                    String issueId = input.nextLine();

                    System.out.print("Enter Member ID: ");
                    String issueMemberId = input.nextLine();

                    LibraryItem itemToIssue = null;
                    Member memberToIssue = null;

                    for (LibraryItem item : items) {
                        if (item.getItemId().equalsIgnoreCase(issueId)) {
                            itemToIssue = item;
                            break;
                        }
                    }

                    for (Member m : members) {
                        if (m.getMemberId().equalsIgnoreCase(issueMemberId)) {
                            memberToIssue = m;
                            break;
                        }
                    }

                    if (itemToIssue == null) {
                        System.out.println("Item not found.");
                    } else if (memberToIssue == null) {
                        System.out.println("Member not found.");
                    } else if (itemToIssue.isIssued()) {
                        System.out.println("This item is already issued.");
                    } else {
                        itemToIssue.setIssued(true);
                        memberToIssue.setBorrowedCount(memberToIssue.getBorrowedCount() + 1);
                        System.out.println("Item issued successfully to " + memberToIssue.getMemberName() + ".");
                    }
                    break;

                case 6:
                    // Return item from member
                    System.out.print("Enter Item ID to return: ");
                    String returnId = input.nextLine();

                    System.out.print("Enter Member ID: ");
                    String returnMemberId = input.nextLine();

                    LibraryItem itemToReturn = null;
                    Member memberToReturn = null;

                    for (LibraryItem item : items) {
                        if (item.getItemId().equalsIgnoreCase(returnId)) {
                            itemToReturn = item;
                            break;
                        }
                    }

                    for (Member m : members) {
                        if (m.getMemberId().equalsIgnoreCase(returnMemberId)) {
                            memberToReturn = m;
                            break;
                        }
                    }

                    if (itemToReturn == null) {
                        System.out.println("Item not found.");
                    } else if (memberToReturn == null) {
                        System.out.println("Member not found.");
                    } else if (!itemToReturn.isIssued()) {
                        System.out.println("This item is not currently issued.");
                    } else {
                        itemToReturn.setIssued(false);

                        if (memberToReturn.getBorrowedCount() > 0) {
                            memberToReturn.setBorrowedCount(memberToReturn.getBorrowedCount() - 1);
                        }

                        System.out.println("Item returned successfully from " + memberToReturn.getMemberName() + ".");
                    }
                    break;

                case 7:
                    // Delete item
                    System.out.print("Enter Item ID to delete: ");
                    String deleteId = input.nextLine();

                    boolean removed = false;

                    for (int i = 0; i < items.size(); i++) {
                        if (items.get(i).getItemId().equalsIgnoreCase(deleteId)) {
                            items.remove(i);
                            removed = true;
                            System.out.println("Item deleted successfully.");
                            break;
                        }
                    }

                    if (!removed) {
                        System.out.println("Item not found.");
                    }
                    break;

                case 8:
                    // Display all members
                    if (members.isEmpty()) {
                        System.out.println("No members found.");
                    } else {
                        System.out.println("\n--- Member Information ---");
                        for (Member m : members) {
                            m.displayMemberInfo();
                        }
                    }
                    break;

                case 0:
                    System.out.println("Exiting Library Management System...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 0);

        input.close();
    }
}