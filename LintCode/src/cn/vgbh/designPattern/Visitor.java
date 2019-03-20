package cn.vgbh.designPattern;

/*
 * ������ģʽ
 * 
 * ͼ����
 * 						Visitor
 * 						/      \
 * 					   /        \
 * 			LibraryVisitor     LibraryNums
 * 			     |        		  /    \               
 * 			   	 |		         /      \  
 *   LibraryVisitorOfSum       Book    Article
 * 
 * 
 * 
 * 
 */

public class Visitor {
	
}

class Library {
	
}

class LibraryVisitor extends Library{
	
}

class LibraryVisitorOfSum extends LibraryVisitor {
	
}

class LibraryNums extends Library {
	
}

class Book extends LibraryNums {
	
}

class Article extends LibraryNums {
	
}