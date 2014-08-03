public interface Item{
	public abstract Item clone();
    public abstract String toString();
    public abstract boolean equals(Item item);
}