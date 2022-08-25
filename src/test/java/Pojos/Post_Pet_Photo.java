package Pojos;

import java.util.ArrayList;

public class Post_Pet_Photo {

    private ArrayList<String> photoUrls;

    Post_Pet_Photo(){
    }

    public ArrayList<String> getPhotoUrls() {
        return photoUrls;
    }

    public void setPhotoUrls(ArrayList<String> photoUrls) {
        this.photoUrls = photoUrls;
    }


    @Override
    public String toString() {
        return "Post_Pet_Photo{" +
                "photoUrls=" + photoUrls +
                '}';
    }
}
