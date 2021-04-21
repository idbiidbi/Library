package controller;

import entity.Reader;

import java.util.ArrayList;

public class Registration {

    private ArrayList<Reader> readers = new ArrayList<Reader>();
    private String reader;

    public Registration() {
        addDefaultReader();
    }

    public String setActiveReader(String reader) {

        this.reader = reader;
        return  reader + " you are currently an active user\n";

    }

    public String addReader(Reader newReader) {
        readers.add(newReader);
        return "Reader " + newReader.getName() + " created successfully";
    }

    public ArrayList<Reader> getAllReaders() {
        int counter = 1;
        for (Reader reader:readers) {
            System.out.println(counter + ". " + reader.getName());
            counter++;
        }
        return readers;
    }

    public void addDefaultReader() {

        Reader rd1 = new Reader();
        rd1.setName("Lera");
        readers.add(rd1);

        Reader rd2 = new Reader();
        rd2.setName("Alex");
        readers.add(rd2);
    }

    public ArrayList<Reader> findReader(String readerName) {
        ArrayList<Reader> foundReader = new ArrayList<>();
        for (Reader reader: readers) {
            if (reader.getName().trim().contains(readerName)) {
                foundReader.add(reader);
            }
        }
        return foundReader;
    }
}


