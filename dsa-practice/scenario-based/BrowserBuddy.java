import java.util.*;

/* Doubly Linked List Node */
class PageNode {
    String page;
    PageNode previous;
    PageNode next;

    PageNode(String page) {
        this.page = page;
    }
}

/* Represents a single browser tab */
class TabSession {

    private PageNode start;
    private PageNode current;

    // Open a new page
    public void openPage(String page) {
        PageNode node = new PageNode(page);

        if (start == null) {
            start = current = node;
        } else {
            // remove forward history
            if (current.next != null) {
                current.next.previous = null;
                current.next = null;
            }

            current.next = node;
            node.previous = current;
            current = node;
        }
        System.out.println("Opened: " + page);
    }

    public void goBack() {
        if (current != null && current.previous != null) {
            current = current.previous;
            System.out.println("Back to: " + current.page);
        } else {
            System.out.println("Cannot go back");
        }
    }

    public void goForward() {
        if (current != null && current.next != null) {
            current = current.next;
            System.out.println("Forward to: " + current.page);
        } else {
            System.out.println("Cannot go forward");
        }
    }

    public void showActivePage() {
        System.out.println(
            current != null ? "Active Page: " + current.page : "No page open"
        );
    }
}

/* Main controller */
public class BrowserBuddy {

    private static Stack<TabSession> closedTabs = new Stack<>();
    private static TabSession activeTab = new TabSession();

    public static void closeCurrentTab() {
        closedTabs.push(activeTab);
        activeTab = new TabSession();
        System.out.println("Tab successfully closed");
    }

    public static void reopenLastTab() {
        if (closedTabs.isEmpty()) {
            System.out.println("No closed tabs available");
            return;
        }
        activeTab = closedTabs.pop();
        System.out.println("Tab restored");
        activeTab.showActivePage();
    }

    public static void main(String[] args) {

        activeTab.openPage("google.com");
        activeTab.openPage("youtube.com");
        activeTab.openPage("leetcode.com");

        activeTab.goBack();
        activeTab.goForward();
        activeTab.goBack();

        activeTab.openPage("github.com");

        closeCurrentTab();
        reopenLastTab();
    }
}
