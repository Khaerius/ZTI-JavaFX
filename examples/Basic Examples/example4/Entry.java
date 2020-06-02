package example4;

public class Entry {
    private int id;
    private String date;
    private int number;
    private String content;

    public Entry(int id) {
        this.id = id;
    }

    public Entry(int id, String date, int number, String content) {
        this.id = id;
        this.date = date;
        this.number = number;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String newDate) {
        date = newDate;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int newNumber) {
        number = newNumber;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String newContent) {
        content = newContent;
    }
}
