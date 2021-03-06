# PrepareStatement

**`table 생성`**

![zz.png](https://github.com/kcy97328/Multicampus/blob/main/JDBC/zz.png?raw=true)

### `BookDTO`

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


### `BookTest`

```java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BookTest {
public static void main(String[] args) {
	ArrayList<BookDTO> list = new ArrayList<BookDTO>();
	list.add(new BookDTO(91424,"Java Basic","김하나","Jaen.kr",15000,"Java 기본 문법"));
	list.add(new BookDTO(93455,"JDBC Pro   ","김철수","Jaen.kr",23000," "));
	list.add(new BookDTO(95355,"Servlet/JSP","박자바","Jaen.kr",41000,"Model2기반"));
	list.add(new BookDTO(95332,"Android App","홍길동","Jaen.kr",25000,"Lightweight Framework"));
	list.add(new BookDTO(95356,"OOAD분석,설계","소나무","Jaen.kr",30000," "));
	
	BookTest bt = new BookTest();
	for(BookDTO book : list) {
		try {
			bt.insertStudent(book);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	try {
		bt.printAllBooks();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

public void insertStudent(BookDTO book) throws ClassNotFoundException, SQLException {
	//테이블에 5권의 책정보 삽입
	//테이블이 존재, 컨넥션 정보 있어야 한다.
	Connection con = this.getConnection();
	String sql = "insert into book values (?,?,?,?,?,?)";
	PreparedStatement pstmt = con.prepareStatement(sql);
	pstmt.setInt(1, book.getIsbn());
	pstmt.setString(2, book.getTitle());
	pstmt.setString(3, book.getAuthor());
	pstmt.setString(4, book.getPublisher());
	pstmt.setInt(5, book.getPrice());
	pstmt.setString(6, book.getDescription());
	int affectedCount = pstmt.executeUpdate();
	if(affectedCount>0) {
		System.out.println("success");
	} else {
		System.out.println("fails");
	}
	pstmt.close();
	con.close();
}

public void printAllBooks() throws ClassNotFoundException, SQLException {
  		// 컨넥션 취득(메소드 이용)
	Connection con = this.getConnection();
    	// 쿼리 작성
	String sql = "select * from book";
    	// 쿼리 요청 통로 생성
	PreparedStatement pstmt = con.prepareStatement(sql);
   	 	// 쿼리 요청 및 결과 취득
	ResultSet rs = pstmt.executeQuery();
  
	ArrayList<BookDTO> list = new ArrayList<BookDTO>();
	BookDTO book = null;
    
	while(rs.next()) {
		book = new BookDTO(rs.getInt("isbn"),rs.getString("title"),
				rs.getString("author"),rs.getString("publisher"),
				rs.getInt("price"),rs.getString("description"));
		list.add(book);
	}
	rs.close();
	pstmt.close();
	con.close();
    
	System.out.println("-----------------------도서정보-----------------------");
	for(BookDTO temp: list) {
		System.out.println(temp);
	}
}

public Connection getConnection() throws ClassNotFoundException, SQLException {
	Connection con = null;
    	// 오라클에 접속한다고 알려줌 @자신의 IP주소:포트번호:DB이름
	String jdbcURL = "jdbc:oracle:thin:@localhost:1521:xe";
	String driver = "oracle.jdbc.OracleDriver";
    	// 접속할 계정명
	String id = "hr";
    	// 계정의 비밀번호
	String pwd = "1234";
	// JDBC 드라이버(ojdbc6.jar)를 로딩하는 부분
	Class.forName(driver);
    	// 입력된 오라클의 계정, 비밀번호, 주소를 바탕으로 오라클에 접속
	con = DriverManager.getConnection(jdbcURL,id,pwd);
	// 자원을 닫아
	return con;
}
}
```

