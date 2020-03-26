/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookMVC;

/**
 *
 * @author fokpoonkai
 */
public class Books {
    public int id;
    public String title;
    public String description;
    public String author;
    public String ISBN;
    public String Publisher;

    public Books() {
    }

    public Books(String title, String description, String author, String ISBN, String Publisher) {
        this.title = title;
        this.description = description;
        this.author = author;
        this.ISBN = ISBN;
        this.Publisher = Publisher;
    }

    public Books(int id, String title, String description, String author, String ISBN, String Publisher) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.author = author;
        this.ISBN = ISBN;
        this.Publisher = Publisher;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getPublisher() {
        return Publisher;
    }

    public void setPublisher(String Publisher) {
        this.Publisher = Publisher;
    }
    
    public String toString(){
        String results ="Title : " + title + "\nDescription: " + description + 
                 "\nAuthor: " + author + "\nISBN: " + ISBN  + "\nPublisher: " + Publisher +"\n";
        
        return results;
    }
    
}
