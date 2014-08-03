public class StringItem implements Item{
    private String value;
	public StringItem(){
		value = null;
	}
    public StringItem(String value){
		this.value = value;
    }
	public StringItem(StringItem s){
		value = s.value;
	}
    public Item clone(){
		return new StringItem(value);
    }
    public String toString(){
		return " " + value;
    }
    public boolean equals(Item item){
		return(this.value == value);
    }
}