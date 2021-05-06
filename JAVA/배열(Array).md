## 배열(Array)



### 👉 배열의 활용 - 버블 정렬🎈

> 길이가 5인 배열에 임의의 값(0 ~ 4)으로 채운 후, **버블 정렬 알고리즘**을 통해 **크기 순으로 정렬**해보자.

```java
int[] numArr = new int[5];
for(int i=0; i<numArr.length; i++)
	System.out.print((numArr[i] = (int)(Math.random() * 10))+ " ");
    System.out.println();
	
for(int i=0; i<numArr.length-1; i++) {
	boolean changed = false;
	for(int j=0; j<numArr.length-1-i; j++) {
		if(numArr[j] > numArr[j+1]) {
			int temp = numArr[j];
			numArr[j] = numArr[j+1];
			numArr[j+1] = temp;
			changed = true;	//자리 바꿈이 생기면 true
		}
	} //end for j
    if(!changed) break; //자리바꿈이 없으면 반복문을 벗어난다
} //end for i

for(int k=0; k<numArr.length; k++) //결과 출력
	System.out.print(numArr[k] + " ");
```

### **✔ 이중 for문 이해하기!**

![img](https://media.vlpt.us/images/eunseo-kim/post/361f7e6a-c3b5-455a-baa6-71c73c0a85e8/image.png)

- **배열의 마지막 요소**인 가장 오른쪽 값은 (비교한 값들 중에서) **최대값**이다.
- 따라서 버블 정렬의 비교 작업을 반복할 수록 **비교 범위는 하나씩 줄어든다.**
- 그래서 안쪽 for문의 반복 횟수가 `numArr.length-1-i` 인 것이다.

------



## 👉 String 배열

### **✔ String 배열의 초기화**

```java
//방법 1
String[] name = new String[3];
name[0] = "Kim";
name[1] = "Park";
name[2] = "Lee";
//방법 2
String[] name = new String[] {"Kim", "Park", "Lee"};
//방법 3 - String 클래스에 한해서 new String[]를 생략할 수 있음
String[] name = {"Kim", "Park", "Lee"}; 
```

### **✔ String 클래스의 메서드**

> - `charAt()` : 문자열에서 지정된 index에 있는 한 문자를 가져온다.
>
> ```java
> String str = "ABCDE";
> char ch = str.charAt(3);
> ```

> - `substring()` : 문자열의 일부를 추출한다.
>   단, 주의할 점은 `substring(1, 4)`에서 범위의 끝인 `4`는 포함되지 않는다.
>
> ```java
> String str = "012345";
> String tmp = str.substring(1, 4); //str에서 해당 범위의 문자들을 반환
> System.out.println(tmp);	  //"123"이 출력됨
> ```

> - `toCharArray()` : String을 `char[]`으로 변환한다.
>
> ```java
> char[] chArr = {'A', 'B', 'C'};
> String str = new String(chArr);	//char배열을 String으로
> char[] tmp = str.toCharArray();	//String을 char 배열로
> ```

------

### **✔ 다차원 배열**

> - 다차원 배열의 생성과 초기화
>
> ```java
> int[][] score = new int[4][3]; //2차원 배열의 생성
> int[][] arr = new int[][] {{1, 2, 3}, {2, 3, 4}, {3, 4, 5}};
> int[][] arr = {{1, 2, 3}, {2, 3, 4}, {3, 4, 5}}; //new int 생략 가능
> ```

> - 가변 배열
>
> ```java
> int[][] score = new int[3][];	//두번째 차원의 길이를 지정하지 않는다.
> score[0] = new int[3];		//각 행마다 다른 길이의 배열을 생성하는 것이 가능하다.
> score[1] = new int[5];
> score[2] = new int[7];
> ```
>
> ![img](https://media.vlpt.us/images/eunseo-kim/post/273a24c6-b43d-41a1-b59b-1607e4f814c7/image.png)