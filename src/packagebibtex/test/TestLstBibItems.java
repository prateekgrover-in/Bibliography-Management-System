package packagebibtex.test;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import packagebibtex.BibItem;
import packagebibtex.ListBibItems;
public class TestLstBibItems {
    public void addItemsOne(ListBibItems lstBibItems){
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

        authorName = "Cummins, Ronan and O'Riordan, Colm";
        yearPublished = 2004;
        title = "Evolving, Analysing and Improving Global Term-Weighting Schemes in Information Retrieval";
        String institutionName = "National University of Ireland, Galway";
        int datePublished = 111204; 
        lstBibItems.addBibItem(new BibItem(authorName, yearPublished, title, institutionName, datePublished));
    }
    @Test
    public void Case0(){
        ListBibItems lstBibItems = ListBibItems.getInstance();
        addItemsOne(lstBibItems);
        assertEquals(lstBibItems.getBibItem(0).getYearPublished(), 2004);
    }
    @Test
    public void Case1(){
        ListBibItems lstBibItems = ListBibItems.getInstance();
        lstBibItems.removeBibItem("Cummins:2004:111204");
        assertEquals(lstBibItems.getBibItem(0).getYearPublished(), 1993);
    }

    @Test
    public void Case2(){
        ListBibItems lstBibItems = ListBibItems.getInstance();
        String ideal = "Gamma, Erich and Helm, Richard and Johnson, Ralph and Vlissides, John. (1993). Design Patterns: Abstraction and Reuse of Object-Oriented Design. ECOOP' 93 --- Object-Oriented Programming. https://doi.org/10.1007/3-540-47910-4_21.";
        assertEquals(lstBibItems.getBibItem(0).getHarvardFormat(), ideal);
    }
}
