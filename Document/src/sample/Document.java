package sample;

import javafx.collections.FXCollections;

import java.util.Date;

public class Document {
    String category;
    String topic;
    String tag;
    String fileName;
   // String comments;
    String DocumentNumber;
    String entryDate;
    String docs;
   String username;

    public Document(String username,String category, String topic, String tag, String fileName, String entryDate,String docs) {
       this.username=username;
        this.category = category;
        this.topic = topic;
        this.tag = tag;
        this.fileName = fileName;

        this.entryDate = entryDate;
        this.docs=docs;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCategory() {
        return category;
    }

    public String getTopic() {
        return topic;
    }

    public String getTag() {
        return tag;
    }

    public String getFileName() {
        return fileName;
    }


    public String getEntryDate() {
        return entryDate;
    }

    public String getDocumentNumber() {
        return DocumentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        DocumentNumber = documentNumber;
    }

    public String getDocs() {
        return docs;
    }

    public void setDocs(String docs) {
        this.docs = docs;
    }
}
