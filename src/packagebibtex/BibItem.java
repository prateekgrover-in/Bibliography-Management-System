package packagebibtex;

public class BibItem implements Comparable<BibItem> {

    private String authorName;
    private int yearPublished;
    private String title;
    private String publisherName;
    private String journalName;
    private String DOILink;
    private String institutionName;
    private int datePublished;
    private String HarvardFormat;
    private String BibTexFormat;
    private String citeKey;
    
    /** 
     * Constructor for creation of default BibItem using Common Attributes of each type.
     * 
     * @param authorName
     * contains name of the author of the BibItem.
     * 
     * @param yearPublished
     * contains year of publication of the BibItem.
     * 
     * @param title
     * contains title of the BibItem
     */
    public BibItem(String authorName, int yearPublished, String title){
        setBasicInputs(authorName, yearPublished, title);
    }

    /** 
     * Overloaded Constructor for creation of Book-Specific BibItem using Common Attributes, as well as Book-Specific attributes.
     * 
     * @param authorName
     * contains name of the author of the Book.
     * 
     * @param yearPublished
     * contains year of publication of the Book.
     * 
     * @param title
     * contains title of the Book.
     * 
     * @param publisherName
     * contains name of publisher of the Book.
     */
    public BibItem(String authorName, int yearPublished, String title, String publisherName){
        setBasicInputs(authorName, yearPublished, title);
        this.publisherName = publisherName;
        String[] partsName = authorName.split(",");
        this.citeKey = partsName[0].toLowerCase() + yearPublished;
        constructHarvardFormat(publisherName);
        constructBibTexFormat(publisherName, this.citeKey);
    }

    /** 
     * Overloaded Constructor for creation of Article-Specific BibItem using Common Attributes, as well as Article-Specific attributes.
     * 
     * @param authorName
     * contains name of the author of the Article.
     * 
     * @param yearPublished
     * contains year of publication of the Article.
     * 
     * @param title
     * contains title of the Article.
     * 
     * @param journalName
     * contains name of the Journal of the Article
     * 
     * @param DOILink
     * contains DOI Link for the Article.
     */
    public BibItem(String authorName, int yearPublished, String title, String journalName, String DOILink){
        setBasicInputs(authorName, yearPublished, title);
        this.journalName = journalName;
        this.DOILink = DOILink;
        String[] partsName = authorName.split(",");
        String[] partsJournal = journalName.split("'");
        yearPublished = yearPublished%100;
        this.citeKey = partsName[0].toLowerCase() + yearPublished + partsJournal[0].toLowerCase();
        constructHarvardFormat(journalName, DOILink);
        constructBibTexFormat(journalName, DOILink, this.citeKey);
    }

    /** 
     * Overloaded Constructor for creation of TechReport-Specific BibItem using Common Attributes, as well as TechReport-Specific attributes.
     * 
     * @param authorName
     * contains name of the author of the Technical Report.
     * 
     * @param yearPublished
     * contains year of publication of the Technical Report.
     * 
     * @param title
     * contains title of the Technical Report.
     * 
     * @param institutionName
     * contains name of the institution where Technical Report was created.
     * 
     * @param datePublished
     * contains date when the Technical Report was submitted.
     */
    public BibItem(String authorName, int yearPublished, String title, String institutionName, int datePublished){
        setBasicInputs(authorName, yearPublished, title);
        this.citeKey = authorName + yearPublished;
        this.institutionName = institutionName;
        this.datePublished = datePublished;
        String[] partsName = authorName.split(",");
        this.citeKey = partsName[0] + ":" + yearPublished + ":" + datePublished;
        constructHarvardFormat(institutionName, datePublished);
        constructBibTexFormat(institutionName, datePublished, this.citeKey);
    }

    
    /** 
     * sets Common Attributes of each type of BibItem to the values provided.
     * 
     * @param authorName
     * contains name of the author of the BibItem.
     * 
     * @param yearPublished
     * contains year of publication of the BibItem.
     * 
     * @param title
     * contains title of the BibItem.
     */
    public void setBasicInputs(String authorName, int yearPublished, String title){
        this.authorName = authorName;
        this.yearPublished = yearPublished;
        this.title = title;
    }
    

    
    /** 
     * constructs the common prefix of BibTex Format for each type of Bibliographic Item
     * 
     * @param type
     * contains the type of BibItem, can be either "book", "article" or "techreport".
     * 
     * @param citeKey
     * contains the citation key of the BibItem.
     * 
     * @param authorName
     * contains the name of the author of the BibItem.
     * 
     * @param yearPublished
     * contains the year published of the BibItem.
     * 
     * @param title
     * contains the title of the BibItem.
     * 
     * @return String
     * returns the String containing common Prefix of BibTeX-Style format for each type.
     */
    public String constructBasicBibTexFormat(String type, String citeKey, String authorName, int yearPublished, String title){
        String currBibTexFormat = "@" + type + "{" + citeKey + ", author = \"" + authorName;
        currBibTexFormat += "\", title = \"" + title + "\", year = \"" + yearPublished + "\"";
        return currBibTexFormat;
    }
    
    
    /** 
     * constructs the common prefix of Harvard Format for each type of Bibliographic Item, and returns the same.
     * 
     * @param authorName
     * contains the name of the author of the BibItem.
     * 
     * @param yearPublished
     * contains the year published of the BibItem.
     * 
     * @param title
     * contains the title of the BibItem.
     * 
     * @return String
     * returns the String containing common Prefix of Harvard - Style format for each type.
     */
    public String constructBasicHarvardFormat(String authorName, int yearPublished, String title){
        String currHarvardFormat = authorName + ". (" + yearPublished + "). ";
        currHarvardFormat += title + ". ";
        return currHarvardFormat;
    }


    
    /** 
     * appends suffix of Book Bibliographic Item to the common Harvard prefix, and sets the value of Book BibItem's Harvard Format to the same.
     * 
     * @param publisherName
     * contains name of the publisher of the book.
     */
    public void constructHarvardFormat(String publisherName){
        String currHarvardFormat = constructBasicHarvardFormat(this.authorName, this.yearPublished, this.title);
        currHarvardFormat += publisherName + ".";
        this.HarvardFormat = currHarvardFormat;
    }
    

    /** 
     * appends suffix of Article Bibliographic Item to the common Harvard prefix, and sets the value of Article BibItem's Harvard Format to the same.
     * 
     * @param journalName
     * contains name of the journal of article.
     * 
     * @param DOILink
     * contains the DOI Link of the article.
     * 
     */
    public void constructHarvardFormat(String journalName, String DOILink){
        String currHarvardFormat = constructBasicHarvardFormat(this.authorName, this.yearPublished, this.title);
        currHarvardFormat += journalName + ". " + DOILink + ".";
        this.HarvardFormat = currHarvardFormat;
    }

    
    /** 
     * appends suffix of Technical Report Bibliographic Item to the common Harvard prefix, and sets the value of Technical Report BibItem's Harvard Format to the same.
     * 
     * @param institutionName
     * contains name of institution where technical report was created.
     * 
     * @param datePublished
     * contains date of submission of technical report.
     */
    public void constructHarvardFormat(String institutionName, int datePublished){
        String currHarvardFormat = constructBasicHarvardFormat(this.authorName, this.yearPublished, this.title);
        currHarvardFormat += institutionName + ".";
        this.HarvardFormat = currHarvardFormat;
    }


    
    /** 
     * appends suffix of Book Bibliographic Item to the common BibTeX prefix, and sets the value of Book BibItem's BibTex Format to the same.
     * 
     * @param publisherName
     * contains name of publisher of the book.
     * 
     * @param citeKey
     * contains citation key of the book.
     */
    public void constructBibTexFormat(String publisherName, String citeKey){
        String currBibTexFormat = constructBasicBibTexFormat("book", citeKey, this.authorName, this.yearPublished, this.title);
        currBibTexFormat += ", publisher = \"" + publisherName + "\"}";
        this.BibTexFormat = currBibTexFormat;
    }

    
    /** 
     * appends suffix of Article Bibliographic Item to the common BibTeX prefix, and sets the value of Article BibItem's BibTex Format to the same.
     * 
     * @param journalName
     * contains name of the journal where article was published.
     * 
     * @param DOILink
     * contains DOI Link of the article.
     * 
     * @param citeKey
     * contains citation key of the article.
     */
    public void constructBibTexFormat(String journalName, String DOILink, String citeKey){
        String currBibTexFormat = constructBasicBibTexFormat("article", citeKey, this.authorName, this.yearPublished, this.title);
        currBibTexFormat += ", journal = \"" + journalName + "\", doi = \"" + DOILink + "\"}"; 
        this.BibTexFormat = currBibTexFormat;
    }

    
    /** 
     * appends suffix of Technical Report Bibliographic Item to the common BibTeX prefix, and sets the value of Technical Report BibItem's BibTex Format to the same.
     * 
     * @param institutionName
     * contains name of institution where technical report was created.
     * 
     * @param datePublished
     * contains date of submission of technical report.
     * 
     * @param citeKey
     * contains citation key of the technical report.
     */
    public void constructBibTexFormat(String institutionName, int datePublished, String citeKey){
        String currBibTexFormat = constructBasicBibTexFormat("techreport", citeKey, this.authorName, this.yearPublished, this.title);
        currBibTexFormat += ", institution = \"" + institutionName + "\"}"; 
        this.BibTexFormat = currBibTexFormat;
    }
    
    /**
     * @return String
     * returns the private attribute authorName
     */
    public String getAuthorName(){
        return this.authorName;
    }

    
    /** 
     * 
     * @return int
     * returns the private attribute yearPublished
     */
    public int getYearPublished(){
        return this.yearPublished;
    }

    
    /** 
     * 
     * @return String
     * returns the private attribute title
     */
    public String getTitle(){
        return this.title;
    }

    
    /** 
     * 
     * @return String
     * returns the private attribute citeKey
     */
    public String getCiteKey(){
        return this.citeKey;
    }
    
    
    /** 
     * 
     * @return String
     * returns the private attribute HarvardFormat, containing Bibliography in Harvard - Style.
     */
    public String getHarvardFormat(){
        return this.HarvardFormat;
    }

    
    /** 
     * 
     * @return String
     * returns the private attribute BibTexFormat, containing Bibliography in BibTex - Style.
     */
    public String getBibTexFormat(){
        return this.BibTexFormat;
    }
    
    /** 
     * Overrides default compareTo method, such that BibItems are sorted based on their year of publication.
     * 
     * @param bibItemObject
     * contains BibItem to which current BibItem will be compared with.
     * 
     * @return int
     * returns 1 if current BibItem's year of publication is greater than passed BibItem's year of publication, returns -1 otherwise.
     */
    @Override 
    public int compareTo(BibItem bibItemObject) {
        if (this.yearPublished > bibItemObject.yearPublished) {
            return 1;
        }
        else {
            return -1;
        }
    }
}
