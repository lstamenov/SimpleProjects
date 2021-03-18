public class ID {
    int id = 0;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        setId(id + 1);
        return id;
    }
}
