package sample;

import java.util.ArrayList;
import java.util.Iterator;

public class UserHandler {
    ArrayList<User> users;

    public UserHandler() {
        this.users=new ArrayList<>();
    }
    public boolean checkUser(String userName,String password){
        User temp;
        boolean flag=false;
        Iterator it =users.iterator();
        while(it.hasNext()){
            temp=(User)it.next();
            if(userName.equalsIgnoreCase(temp.getUserName())&& password.equals(temp.getPassword())){
                flag=true;
                break;

            }
        }
        return flag;

    }

    public ArrayList<User> getUsers() {
        return users;
    }
    public User finduser(String us,String ps){
        User temp;

        Iterator it =users.iterator();
        while(it.hasNext()){
            temp=(User)it.next();
            if(us.equalsIgnoreCase(temp.getUserName())&& ps.equals(temp.getPassword())){

                return temp;
            }
        }
        return new User(";flkjv","fkjhbvf","fjdhvv","fjhvb");
    }
    public boolean addUser(User temp){
        System.out.println("hello");
        if(users.contains(temp))
            return false;
           // Document dd=new Document("","","","","");
            DocumentHandler gg=new DocumentHandler();

        users.add(temp);

        return  true;
    }

}
