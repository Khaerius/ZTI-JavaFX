package example4;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Database {
    private ObservableList<Entry> data;
    private Date currentDate;
    private int currentId;
    private int currentNumber;
    private DateFormat dateFormat;

    public Database() {
        data = FXCollections.observableArrayList();
        dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        currentDate = Calendar.getInstance().getTime();
    }

    public ObservableList<Entry> getData() {
        return data;
    }

    public void add(String content) {
        Date newDate = Calendar.getInstance().getTime();
        if (dateFormat.format(newDate).compareTo(dateFormat.format(currentDate)) == 0) {
            currentNumber += 1;
        } else {
            currentDate = newDate;
            currentNumber = 1;
        }
        data.add(new Entry(currentId, dateFormat.format(currentDate), currentNumber, content));
        currentId += 1;
    }

    public void remove(int index) {
        data.remove(index);
    }

    public void edit(int index, String content) {
        data.get(index).setContent(content);
    }
}
