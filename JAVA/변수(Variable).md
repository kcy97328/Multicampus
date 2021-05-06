## 변수(Variable)



### 👉 자료형

✔ **자료형**은 '**기본형**'과 '**참조형**'으로 나눌 수 있다.

- **기본형**: 논리형(boolean), 문자형(char), 정수형, 실수형 등 **계산을 위한 실제 값을 저장한다.**
- **참조형**: **객체의 주소를 저장한다.** 기본형(8가지)을 제외한 나머지 타입들이다.

✔ **참조형 변수(참조변수)** 를 선언할 때는 변수의 타입으로 클래스의 이름을 사용하므로, **클래스의 이름이 참조변수의 타입이 된다**. 예를 들어, Date 클래스 타입의 참조변수 today를 선언하면 다음과 같다.

```java
//Date 객체를 생성하여 그 주소를 참조변수 today에 저장
Date today = new Date();
```



## 👉 상수와 리터럴 (constant & literal)

✔ **상수**: 값을 저장할 수 있는 공간이다. 단, **변수와 달리 한번 값을 저장하면 다른 값으로 변경할 수 없다**. 상수를 선언하는 방법은 변수와 동일하며, 단지 변수의 타입 앞에 **키워드 'final'**을 붙여주면 된다. **상수는 반드시 선언과 동시에 초기화해야 한다.**

```java
final int MAX_SPEED = 100;
//final int MAX_SPEED;[X] > WRONG! 선언과 동시에 초기화 시키지 않았음
//MAX_SPEED = 200;[X] > WRONG! 상수의 값은 한번 지정하면 변경이 불가능함
```

✔ **리터럴**: 리터럴은 우리가 흔히 알고 있는 상수값을 의미한다. 앞에서 '상수'를 '저장공간'이라고 정의하였으므로, 저장된 값 자체를 의미하는 용어가 바로 '리터럴(literal)'이다.

```java
final int MAX_SPEED = 100;
// 위의 코드에서 MAX_SPEED가 상수이고, 100이 리터럴이다.
```



## 👉 화면에서 입력 받기 - Scanner

```java
import java.util.*; //Scanner 클래스를 사용하기 위해 추가
public class scannerEx {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in); //Scanner 클래스의 객체를 생성
		String input = scanner.nextLine(); 	  //엔터키(Enter)를 누르면 입력한 내용이 문자열로 반환되어 input에 저장됨
	}
}
```

> ### 😮 **+ 자바에서의 형변환**
>
> - String을 Int 타입의 정수로 변환: Integer.parseInt()
>
> ```java
> int num = Integer.parseInt(input); //input은 입력 받은 문자열
> ```
