public class NumeralItem implements Item{
    private int value;
	public NumeralItem(){
		value = 0;
	}
    public NumeralItem(int value){
		this.value = value;
    }
	public NumeralItem(NumeralItem n){
		value = n.value;
	}
    public Item clone(){
		return new NumeralItem(value);
    }
    public String toString(){
		return " " + value;
    }
    public boolean equals(Item item){
		return(this.value == value);
    }
}