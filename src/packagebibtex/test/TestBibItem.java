package packagebibtex.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import packagebibtex.BibItem;

public class TestBibItem {
    @Test
    public void Case0_Book(){

        String authorName = "Hawking, Stephen";
        int yearPublished = 1988;
        String title = "A Brief History of Time: From the Big Bang to Black Holes";
        String publisherName = "Bantam";

        BibItem currBibItem = new BibItem(authorName, yearPublished, title, publisherName); 
        String ideal = "@book{hawking1988, author = \"Hawking, Stephen\", title = \"A Brief History of Time: From the Big Bang to Black Holes\", year = \"1988\", publisher = \"Bantam\"}";
        assertEquals(currBibItem.getBibTexFormat(), ideal);
    }

    @Test
    public void Case1_Article(){

        String authorName = "Gamma, Erich and Helm, Richard and Johnson, Ralph and Vlissides, John";
        int yearPublished = 1993;
        String title = "Design Patterns: Abstraction and Reuse of Object-Oriented Design";
        String journalName = "ECOOP' 93 --- Object-Oriented Programming";
        String DOILink = "https://doi.org/10.1007/3-540-47910-4_21";

        BibItem currBibItem = new BibItem(authorName, yearPublished, title, journalName, DOILink); 
        String ideal = "@article{gamma93ecoop, author = \"Gamma, Erich and Helm, Richard and Johnson, Ralph and Vlissides, John\", title = \"Design Patterns: Abstraction and Reuse of Object-Oriented Design\", year = \"1993\", journal = \"ECOOP\' 93 --- Object-Oriented Programming\", doi = \"https://doi.org/10.1007/3-540-47910-4_21\"}";
        assertEquals(currBibItem.getBibTexFormat(), ideal);
    }

    @Test
    public void Case2_TechReport(){

        String authorName = "Cummins, Ronan and O'Riordan, Colm";
        int yearPublished = 2004;
        String title = "Evolving, Analysing and Improving Global Term-Weighting Schemes in Information Retrieval";
        String institutionName = "National University of Ireland, Galway";
        int datePublished = 111204; 

        BibItem currBibItem = new BibItem(authorName, yearPublished, title, institutionName, datePublished); 
        String ideal = "@techreport{Cummins:2004:111204, author = \"Cummins, Ronan and O\'Riordan, Colm\", title = \"Evolving, Analysing and Improving Global Term-Weighting Schemes in Information Retrieval\", year = \"2004\", institution = \"National University of Ireland, Galway\"}";
        assertEquals(currBibItem.getBibTexFormat(), ideal);
    }

}
