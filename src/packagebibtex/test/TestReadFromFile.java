package packagebibtex.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import packagebibtex.BibItem;
import packagebibtex.ListBibItems;

public class TestReadFromFile {
    ListBibItems lstBibItems = ListBibItems.getInstance();
    public void readFromFile(String fileName){
        // Let file contain two BibTeX formatted BibItems.
        String authorName = "Hawking, Stephen";
        int yearPublished = 1988;
        String title = "A Brief History of Time: From the Big Bang to Black Holes";
        String publisherName = "Bantam";
        lstBibItems.addBibItem(new BibItem(authorName, yearPublished, title, publisherName));

        authorName = "Gamma, Erich and Helm, Richard and Johnson, Ralph and Vlissides, John";
        yearPublished = 1993;
        title = "Design Patterns: Abstraction and Reuse of Object-Oriented Design";
        String journalName = "ECOOP' 93 --- Object-Oriented Programming";
        String DOILink = "https://doi.org/10.1007/3-540-47910-4_21";
        lstBibItems.addBibItem(new BibItem(authorName, yearPublished, title, journalName, DOILink));
    }

    @Test
    public void Case0(){
        readFromFile("currInput");
        assertEquals(lstBibItems.getBibItem(0).getYearPublished(), 1993);
    }
}
