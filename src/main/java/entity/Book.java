package entity;

public class Book {

    private String title;
    private String author;
    private int numberOfCopy;




    public Book(String  title, String author, int numberOfCopy) {

        this.title = title;
        this.author = author;
        this.numberOfCopy = numberOfCopy;
    }



    public String getFullBookInfo (){

        String text = String.format("%-28s%-15s%-9d%n",title,author,numberOfCopy);
        return text;
    }
    public String getFullBookInfo1 (){

        String text = String.format("%-28s%-15s%n",title,author);
        return text;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getNumberOfCopy() {
        return numberOfCopy;
    }
    public void setNumberOfCopy(int numberOfCopy) {
        this.numberOfCopy = numberOfCopy;
    }

    public void takeOutCopy() {
        numberOfCopy -=1;
    }

    public void returnCopy() {
        numberOfCopy +=1;
    }

}
