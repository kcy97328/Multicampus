## JAVA

1. 아래의 출력을 참고하여 클래스를 작성. 클래스 이름은 **`BookDTO`**로 한다.
2. Book 정보를 저장할 클래스에 **생성자**와 **`Encapsulation(캡슐화)`**를 적용하여 생성
   (isbn, title, author, public, price, desc )
3. BookDTO 클래스가 가지고 있는 정보를 문자열로 리턴 시켜주는 **`toString()`**을 출력을 참고하여 작성
4. BookDTO 객체 생성할 **`BookTest`** 클래스 작성. BookTest 결과 화면이 다음과 같이 출력되도록 **`BookDTO 클래스 객체 생성하여 toString()를 호출`**하는 main()를 작성하시오.
<img src="https://github.com/kcy97328/Multicampus/blob/main/JAVA/%EC%BA%A1%EC%B2%98.PNG" alt="캡처" style="zoom:150%;" />


### BookDTO

```java
public class BookDTO {
	private int isbn;	// private를 사용하여 접근을 제한(캡슐화)
	private String title;	// 같은 클래스 내부에서만 접근가능
	private String author;
	private String publisher;
	private int price;
	private String description;
	
	// 생성자
	public BookDTO(int isbn,String title,String author,String publisher,int price,String description) {
		this.isbn = isbn;							
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.price = price;
		this.description = description;
	}
	
	// 값을 얻는 get()메소드  
	// 값을 지정하는 set()메소드
	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override			// toString() -기본 동작: 객체의 해시코드 출력
	public String toString() {	// override 목적: 객체의 정보를 문자열 형태로 표현하고자 할 때		
		String info = String.format("|%d|%s\t|%s|%s|%d|%s",
            		  	this.isbn ,this.title, this.author, this.publisher, this.price, this.description );

		return info;
	}
}
```


### BookTest

import java.util.ArrayList;

public class BookTest {

	public static void main(String[] args) {
		System.out.println("*************************** 도서 목록***************************");
		
        // ArrayList는 크기가 가변적으로 변함
		ArrayList<BookDTO> list = new ArrayList<BookDTO>();		// 타입 지정
		list.add(new BookDTO(21424,"Java Basic","김하나","Jaen.kr",15000,"Java 기본 문법"));	// 값 대입
		list.add(new BookDTO(33455,"JDBC Pro   ","김철수","Jaen.kr",23000,""));
		list.add(new BookDTO(55355,"Servlet/JSP","박자바","Jaen.kr",41000,"Model2기반"));
		list.add(new BookDTO(35332,"Android App","홍길동","Jaen.kr",25000,"Lightweight Framework"));
		list.add(new BookDTO(35355,"OOAD분석,설계","소나무","Jaen.kr",30000,""));
		
		for(BookDTO book : list) {
			System.out.println(book);
		}
	}

}


