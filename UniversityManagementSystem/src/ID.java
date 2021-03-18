public class ID {
    int id = 0;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        increaseId();
        return id;
    }

    public void increaseId(){
        setId(id + 1);
    }
}
