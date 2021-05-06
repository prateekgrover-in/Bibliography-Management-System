package packagebibtex;

import java.util.ArrayList;
import java.util.Collections;
import java.io.PrintWriter;
import java.io.FileWriter;

public class ListBibItems implements BibFileReader {
    
    private static ListBibItems singleInstance = null;

    private ArrayList<BibItem> lstBibItems;
    
    /** 
     * Constructor for generating Unique Instance of Singleton Class
     *
     * @return singleInstance 
     */
    private ListBibItems() {
        lstBibItems = new ArrayList<BibItem>();
    }
  
    /** 
     * returns unique instance of Singleton Class
     *
     * @return singleInstance 
     */
    public static ListBibItems getInstance() {
        if (singleInstance == null)
            singleInstance = new ListBibItems();
        return singleInstance;
    }
    
    /** 
     * returns element on index i of the private attribute ArrayList of Bibliographic Items
     * 
     * @param i
     *  
     * @return BibItem
     */
    public BibItem getBibItem(int i){
        return lstBibItems.get(i);
    }

    /** 
     * adds Bibliographic Item created into ArrayList of Bibliographic Items in Recent - First Order using sort() function. 
     * 
     * @param newCreated
     * contains BibItem to be added into the ArrayList
     */
    public void addBibItem(BibItem newCreated){
        this.lstBibItems.add(newCreated);
        System.out.println("Element was added with Cite-Key : " + newCreated.getCiteKey() + " successfully. ");
        Collections.sort(lstBibItems, Collections.reverseOrder());
    }

    /** 
     * removes Bibliographic Item with provided Citation Key taken from Console.
     * 
     * @param toDeleteCiteKey
     * contains citation key of the BibItem that needs to be deleted from the ArrayList
     */
    public void removeBibItem(String toDeleteCiteKey){
        int toDeleteIndex = -1;
        for (int i = 0; i < lstBibItems.size(); i++) {
            if (lstBibItems.get(i).getCiteKey().equals(toDeleteCiteKey)){
                toDeleteIndex = i;
                break;
            }
        }
        if (toDeleteIndex == -1){
            System.out.println("Given Cite-Key " + toDeleteCiteKey + " could not be found in Database.");
        }
        else{
            lstBibItems.remove(toDeleteIndex);
            // System.out.println("Given Cite-Key " + toDeleteCiteKey + " was deleted successfully. ");
        }
    }

    /** 
     * Prints the Harvard-Style Format of all the items of the ArrayList of Bibliographic Items, in Recent-First Order.
     *
     */
    public void viewAllBibItems(){
        for (int i = 0; i < lstBibItems.size(); i++) {
            System.out.println(lstBibItems.get(i).getHarvardFormat());
            System.out.println("");
        }
    }

    /** 
     * Saves BibTeX-Style Format for all the items of ArrayList of Bibliographic Items, in Recent-First Order in given fileName.bib
     * 
     * @param fileName
     * contains file name of the file into which entries need ot be saved.
     */
    public void saveToFile(String fileName){
        try(PrintWriter writer = new PrintWriter(new FileWriter(fileName + ".bib"))) {
            for (int i = 0; i < lstBibItems.size(); i++){
                writer.append(lstBibItems.get(i).getBibTexFormat());
                writer.append("\n\n");
            }
            // System.out.println("Contents were saved to File Successfully.");
        } catch (Exception e) {
            System.out.println("Exception occured while saving to File.");
        }
    }
    
    /** 
     * Function to read Bibliographic Items from a given .bib file, extracting the type as well as attributes of the same. Currently Not Implemented.
     * 
     * @param fileName
     * contains file name of the file from which entries need to be loaded.
     */
    public void readFromFile(String fileName){
        // Function not Implemented
    }
}
