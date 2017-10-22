
public class Node {
	public Comparable<String> data;
	public Node left;
	public Node right;
	
	public Node(){
		
	}
	
	public Comparable<String> getData(){
		return data;
	}
	
	public Node getLeft(){
		return left;
	}
	
	public Node getRight(){
		return right;
	}
	
	public void setData(Comparable<String> content){
		data = content;
	}
	
	public void setLeft(Node givenNode){
		left = givenNode;
	}
	
	public void setRight(Node givenNode){
		right = givenNode;
	}
	
}
