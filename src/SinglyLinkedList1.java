

public class SinglyLinkedList1<E> {

	/**
	 * @param args
	 */
	
	private E data;
	public SinglyLinkedList1<E> link;
	
	public SinglyLinkedList1 (E calcData, SinglyLinkedList1<E> calcLink)
	{
		this.data = calcData;
		this.link = calcLink;
	}
	
	public void addNode(E value)
	{
		link = new SinglyLinkedList1<E>(value, link);
	}
	
	public E getData()
	{
		return this.data;
	}
	
	public SinglyLinkedList1<E> getLink()
	{
		return this.link;
	}
	
	public void setData(E newData)
	{
		this.data = newData;
	}
	
	public void setLink(SinglyLinkedList1<E> newLink)
	{
		this.link = newLink;
	}
	
	public void removeNode()
	{
		this.link = link.link;
	}
	

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
