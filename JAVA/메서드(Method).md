## 메서드(Method)



## 👉 클래스 메서드(static 메서드)와 인스턴스 메서드

> 1. 멤버 변수 중, 모든 인스턴스에 공통으로 사용하는 것에는 `static`을 붙인다.
> 2. 클래스 변수(`static` 변수)는 인스턴스(객체)를 생성하지 않아도 사용할 수 있다.
> 3. 클래스 메서드(`static` 메서드)에서는 인스턴스 변수를 사용할 수 없다.
> 4. 메서드 중 인스턴스 변수나 인스턴스 메서드를 사용하지 않는 메서드에는 `static`을 붙일 것을 고려한다.

#### 클래스 메서드, 인스턴스 메서드 예시

```java
class MyMath {
	int a, b;					//인스턴스 변수 a, b
	static int x, y;				//클래스 변수 x, y 
    
	//인스턴스 메서드
	int add() {return a+b;}				//a, b는 인스턴스 변수
	int add2() {return k+l;}
	
	//클래스(static) 메서드
	//static int add() {return a+b;};	//클래스(static) 메서드 안에서는 인스턴스 변수를 사용할 수 없음
	static int add1() {return x+y;};	//클래스 변수는 클래스/인스턴스 메서드 안에서 모두 사용 가능
	static int add(int a, int b) {return a+b;}	//여기서 a, b는 (인스턴스 변수가 아닌) 지역변수
}

public class MyMathTest {
	public static void main(String[] args) {
		System.out.println(MyMath.add(1, 2));	//클래스 메서드 호출: 인스턴스(객체) 생성 없이 호출이 가능
		
		MyMath mm = new MyMath();		//인스턴스 메서드는 객체 생성 이후에만 호출이 가능함
		mm.a = 3;
		mm.b = 6;
		System.out.println(mm.add());		

	}
}
```

------



## 👉 클래스 멤버와 인스턴스 멤버

```java
class Call {
	int iv = 10;			//인스턴스 변수
	static int cv = 20;		//클래스 변수
	
	int iv2 = cv;			//*가능-인스턴스 멤버가 존재하는 시점에 클래스 멤버는 항상 존재함
	//static int cv2 = iv;		//*불가능-클래스 멤버가 존재하는 시점에 인스턴스 멤버가 존재하지 않을 수도 있음(객체를 생성하지 않은 경우)
	static int cv2 = new Call().iv;	//이처럼 객체를 생성해야 가능
	
	static void staticMethod1() {
		System.out.println(cv);
		//System.out.print(iv);	//에러. 클래스 메서드에서는 인스턴스 변수를 사용할 수 없음
		
		//클래스 메서드 안에서 인스턴스 변수를 사용하기 위해서는 객체를 생성해야 함
		Call c = new Call();
		System.out.println(c.iv);//객체 생성 후 인스턴스 변수의 참조 가능
	}
	
	void instanceMethod1() {
		System.out.println(cv);
		System.out.println(iv);	//인스턴스 메서드 안에서는 클래스 변수, 인스턴스 변수 모두 사용 가능
	}
	
	static void staticMethod2() {
		staticMethod1();
		//instanceMethod1();	//객체 생성 후 인스턴스 메서드 호출 가능
		Call c = new Call();
		c.instanceMethod1();	
	}
	
	void instanceMethod2() {
		staticMethod1();
		instanceMethod1();
	}
}
```

#### ✨ 이것만은 알아두자!

> **인스턴스 멤버가 존재하는 시점에 클래스 멤버는 항상 존재**한다. 그러나 클래스 멤버가 존재하는 시점에 인스턴스 멤버가 존재하지 않을 수도 있다. 왜냐하면 **클래스 멤버는 별도의 인스턴스를 생성하지 않고도 참조 또는 호출이 가능**하기 때문이다!