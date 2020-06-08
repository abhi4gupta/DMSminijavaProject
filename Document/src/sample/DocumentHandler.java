package sample;

import com.sun.source.tree.Tree;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class DocumentHandler {
ArrayList<Document> documents=new ArrayList<>();



    public ArrayList<Document> getDocuments() {
        return documents;
    }


    public void addDocument(String username,String filename,String category,String topic,String tag,String text){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate localDate = LocalDate.now();
     Document tempdoc=new Document(username,category,topic,tag,filename,dtf.format(localDate),text);
            documents.add(tempdoc);
    }
   /*//* public String getProperties(String fileName){
     //this will return properties of the document
        Iterator it=documents.iterator();
        String s="";
        Document temp;
       // ArrayList<String> templist=new ArrayList<>();
        while(it.hasNext()){
            temp=(Document)it.next();
            if(fileName.equals(temp.getFileName())){
               // ret
                s+="File Name-> ";
                s+=temp.getFileName() ;
                s+="";
                s+="Document number-> ";
                s+=temp.getDocumentNumber() ;
                s+="  ";
                s+="Entry Date-> ";
                s+=temp.getEntryDate().toString() ;
                s+="\n";
                s+="Category-> ";
                s+=temp.getCategory() ;
                s+="\n";
                s+="Topic-> ";
                s+=temp.getTopic() ;
                s+="\n";
                s+="Tag-> ";
                s+=temp.getTag() ;
                s+="\n";


            }

        }
        return s;

    }
   /* public  Document getDocumentViaFileName(String fileName){
        //this will give the contents of Document of given fileName (return false if file not found)
         return new Document("jkhdjs","kjghfds","jsdjfv","dhjgf","jhvfbhd"," ");
    }*//*
    public ArrayList<String> getDocumentViaCategory(String category){
        //this will give the arraylist of document of same category
        Iterator it=documents.iterator();
        Document temp;
        ArrayList<String> templist=new ArrayList<>();
        while(it.hasNext()){
            temp=(Document) it.next();
            if(category.equals(temp.getCategory())){
                templist.add(temp.getFileName());
            }

        }
        return templist;
    }
    public  ArrayList<String> getDocumentViaTag(String tag){
        //this will give the arraylist of document of same tag
        Iterator it=documents.iterator();
        Document temp;
        ArrayList<String> templist=new ArrayList<>();
        while(it.hasNext()){
            temp=(Document)it.next();
            if(tag.equals(temp.getTag())){
                templist.add(temp.getFileName());
            }

        }
        return templist;
    }
    public  ArrayList<String> getDocumentViaTopic(String topic) {
        //this will give the arraylist of document of same tag
        Iterator it=documents.iterator();
        Document temp;
        ArrayList<String> templist=new ArrayList<>();
        while(it.hasNext()){
            temp=(Document)it.next();
            if(topic.equals(temp.getTopic())){
                templist.add(temp.getFileName());
            }

        }
        return templist;
    }

    public boolean deleteDocument(String fileName){
        //delete  a Document of given fileName (return true on success)
     return true;
    }
    */
    public Document getDocument(String user,String fileName) {

        for(int i=0;i<documents.size();i++)
        {
            if(documents.get(i).getUsername().compareTo(user)==0&&documents.get(i).getFileName().compareTo(fileName)==0)
                return documents.get(i);
        }
        return documents.get(0);
    }

        public ArrayList<String> userfilenames(String user)
        {    ArrayList<String > hh=new ArrayList<>();
           for(int i=0;i<documents.size();i++)
           {
                if(documents.get(i).getUsername().compareTo(user)==0)
                    hh.add(documents.get(i).getFileName());
           }
      return hh;

        }
        public void deletedoc(String user,String filename)
        {
            for(int i=0;i<documents.size();i++)
            {
                if(documents.get(i).getUsername().compareTo(user)==0&&documents.get(i).getFileName().compareTo(filename)==0)
                    documents.remove(documents.get(i));
            }
        }
        public ArrayList<Document> searchviaTag(String tg)
        {            ArrayList<Document> jj=new ArrayList<>();
            for(int i=0;i<documents.size();i++)
            {
                if(documents.get(i).getTag().compareTo(tg)==0)
                    jj.add(documents.get(i));
            }
            return jj;
        }
    public ArrayList<Document> searchviaCategry(String catg)
    {            ArrayList<Document> jj=new ArrayList<>();
        for(int i=0;i<documents.size();i++)
        {
            if(documents.get(i).getCategory().compareTo(catg)==0)
                jj.add(documents.get(i));
        }
        return jj;
    }
    public ArrayList<Document> searchviaTopic(String topic)
    {            ArrayList<Document> jj=new ArrayList<>();
        for(int i=0;i<documents.size();i++)
        {
            if(documents.get(i).getTopic().compareTo(topic)==0)
                jj.add(documents.get(i));
        }
        return jj;
    }
    public String searchanything(String filen)
    {            String jj="";
          int f=0;
        for(int i=0;i<documents.size();i++)
        {
            if(documents.get(i).getTag().compareTo(filen)==0) {
                f=1;
                jj+=documents.get(i).fileName+"\n"; }
        }
        if(f==1)
        return jj;
        for(int i=0;i<documents.size();i++)
        {
            if(documents.get(i).getCategory().compareTo(filen)==0) {
                f=1;
                jj+=documents.get(i).fileName+"\n"; }
        }
        if(f==1)
            return jj;
        for(int i=0;i<documents.size();i++)
        {
            if(documents.get(i).getTopic().compareTo(filen)==0) {
                f=1;
                jj+=documents.get(i).fileName+"\n"; }
        }
        if(f==1)
            return jj;
        return jj;
    }

      /*  public void userdeldoc(String user,String filename) {
            ArrayList<Document> jj = userdoc.get(user);
            for (int i = 0; i < jj.size(); i++) {
                if (jj.get(i).getFileName().compareTo(filename) == 0)
                    jj.remove(jj.get(i));
            }
        }
        // return new Document("hvb","lkhjv","lkj","","");
        //modify  Document of given fileName(return false if file not found)
*/
    }



