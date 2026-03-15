public abstract class LibraryItem {
    private String itemId;
    private String title;
    private boolean isIssued;

    public LibraryItem(String itemId, String title) {
        this.itemId = itemId;
        this.title = title;
        this.isIssued = false;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isIssued() {
        return isIssued;
    }

    public void setIssued(boolean issued) {
        isIssued = issued;
    }

    public abstract void displayInfo();
}