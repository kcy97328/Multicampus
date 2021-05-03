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
    String DB필드 = rs.getString("DB필드1");
    int DB필드 = rs.getint("DB필드2");
	System.out.println(%s, %d);
}

// 자원 반납
rs.close();
st.close();
con.close();
```

|설명			     |				코드				  	  |
| ---------------------------- | --------------------------------------------------------------------|
| 드라이버 로드                 | Class.forName("oracle.jdbc.driver.OracleDriver");            	|
| 연결                         | Connection con = DriverManager.getConnection(주소, 아이디, 비밀번호); |
| 실행                         | Statement st = con.createStatement();                        	   |
| 결과 받는 빈 공간을 만들어줌   | ResultSet rs = st.executeQuery(sql);                         	   |
| 결과를 빈공간에 삽입           | rs.next();                                                   	      |
| "DB 필드"" 결과 출력          | String DB 필드 = rs.getString("DB 필드");                    	     |



