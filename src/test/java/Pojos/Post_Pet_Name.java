package Pojos;

public class Post_Pet_Name {


    private int id;
    private String name;
    private Post_Pet_Photo photo;

    Post_Pet_Name(){
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Post_Pet_Photo getPhoto() {
        return photo;
    }

    public void setPhoto(Post_Pet_Photo photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "Post_Pet_Name{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", photo=" + photo +
                '}';
    }
}
