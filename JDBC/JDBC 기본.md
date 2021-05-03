### JDBC `[ Java DataBase Connectivity ]`

* **`JAVA에 Oracle 연결`**

> <img src="https://github.com/kcy97328/Multicampus/blob/main/JDBC/%EC%97%B0%EA%B2%B01.PNG" alt="연결1" style="zoom: 67%;" />	



> <img src="https://github.com/kcy97328/Multicampus/blob/main/JDBC/%EC%97%B0%EA%B2%B02.PNG" alt="연결2" style="zoom:67%;" />	


* **`연결 및 출력 코드`**
``` java
String url = "jdbc:oracle:thin:@호스트 이름(ip주소):포트번호/서비스(DB)이름
String sql = "select * from table";
String id = "hr"
String pwd = "1234";

Class.forName("oracle.jdbc.driver.OracleDriver");
Connection con = DriverManager.getConnection(url, hr, 1234);
Statement st = con.createStatement();
ResultSet rs = st.executeQuery(sql);

while(rs.next()){
    String DB필드1 = rs.getString("DB필드1");
    int DB필드2 = rs.getint("DB필드2");
	System.out.println(%s, %d);
}

// 자원 반납
rs.close();
st.close();
con.close();
```
```
결과 화면

DB필드1, DB필드2

```

|설명			     |				코드				  	  |
| ---------------------------- | --------------------------------------------------------------------|
| 드라이버 로드                 | Class.forName("oracle.jdbc.driver.OracleDriver");            	|
| 연결                         | Connection con = DriverManager.getConnection(주소, 아이디, 비밀번호); |
| 실행                         | Statement st = con.createStatement();                        	   |
| 결과 받는 빈 공간을 만들어줌   | ResultSet rs = st.executeQuery(sql);                         	   |
| 결과를 빈공간에 삽입           | rs.next();                                                   	      |
| "DB 필드"" 결과 출력          | String DB 필드 = rs.getString("DB 필드");                    	     |



* **`PreparedStatement`**

* statement를 상속받는 인터페이스로 SQL구문을 실행시키는 기능을 갖는 객체
* PreCompiled된 SQL문을 표현 즉, statement객체는 실행시 sql명령어를 지정하여 여러 sql구문을 하나의 statement객체로 수행이 가능하다.(재사용 가능)  하지만, preparedStatement는 객체 생성시에 지정된 sql명령어만을 실행할수 있다.  (다른 sql구문은 실행못함 ->재사용 못함)
* 동일한 sql구문을 반복 실행한다면 preparedStatement가 성능면에서 빠름.
* SQL문에서 변수가 들어갈 자리는 ' ? ' 로 표시한다. , 실행시에 ?에 대응되는 값을 지정할때 setString(int parameterIndex, String X)이나 setInt(int parameterIndex, int x)와 같이  setXXX메소드를 통해 설정한다.
그리고  PreparedStatement 는 SQL문에서 Like키워드를 사용할경우 사용할수없다.


* Connection 객체의 prepareStatement(String query)를 통해 생성된다.
* PreparedStatement객체를 생성할때 SQL문이 인자로 주어진다.
* SQL문에 매개변수를 사용하고, 실행전에 값을 지정할수있다.
* SQL 문을 실행할때 execute(), executeQuery()또는 executeUpdate()를 사용한다.
* PreparedStatement가 제공하는 메소드는 Statement가 제공하는 메소드와 거의 같다.


