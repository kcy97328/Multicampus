## ๋ฐฐ์ด(Array)



### ๐ ๋ฐฐ์ด์ ํ์ฉ - ๋ฒ๋ธ ์ ๋ ฌ๐

> ๊ธธ์ด๊ฐ 5์ธ ๋ฐฐ์ด์ ์์์ ๊ฐ(0 ~ 4)์ผ๋ก ์ฑ์ด ํ, **๋ฒ๋ธ ์ ๋ ฌ ์๊ณ ๋ฆฌ์ฆ**์ ํตํด **ํฌ๊ธฐ ์์ผ๋ก ์ ๋ ฌ**ํด๋ณด์.

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
			changed = true;	//์๋ฆฌ ๋ฐ๊ฟ์ด ์๊ธฐ๋ฉด true
		}
	} //end for j
    if(!changed) break; //์๋ฆฌ๋ฐ๊ฟ์ด ์์ผ๋ฉด ๋ฐ๋ณต๋ฌธ์ ๋ฒ์ด๋๋ค
} //end for i

for(int k=0; k<numArr.length; k++) //๊ฒฐ๊ณผ ์ถ๋ ฅ
	System.out.print(numArr[k] + " ");
```

### **โ ์ด์ค for๋ฌธ ์ดํดํ๊ธฐ!**

![img](https://github.com/kcy97328/Multicampus/blob/main/JAVA/%EB%B0%B0%EC%97%B4%20for.png)

- **๋ฐฐ์ด์ ๋ง์ง๋ง ์์**์ธ ๊ฐ์ฅ ์ค๋ฅธ์ชฝ ๊ฐ์ (๋น๊ตํ ๊ฐ๋ค ์ค์์) **์ต๋๊ฐ**์ด๋ค.
- ๋ฐ๋ผ์ ๋ฒ๋ธ ์ ๋ ฌ์ ๋น๊ต ์์์ ๋ฐ๋ณตํ  ์๋ก **๋น๊ต ๋ฒ์๋ ํ๋์ฉ ์ค์ด๋ ๋ค.**
- ๊ทธ๋์ ์์ชฝ for๋ฌธ์ ๋ฐ๋ณต ํ์๊ฐ `numArr.length-1-i` ์ธ ๊ฒ์ด๋ค.

------



## ๐ String ๋ฐฐ์ด

### **โ String ๋ฐฐ์ด์ ์ด๊ธฐํ**

```java
//๋ฐฉ๋ฒ 1
String[] name = new String[3];
name[0] = "Kim";
name[1] = "Park";
name[2] = "Lee";
//๋ฐฉ๋ฒ 2
String[] name = new String[] {"Kim", "Park", "Lee"};
//๋ฐฉ๋ฒ 3 - String ํด๋์ค์ ํํด์ new String[]๋ฅผ ์๋ตํ  ์ ์์
String[] name = {"Kim", "Park", "Lee"}; 
```

### **โ String ํด๋์ค์ ๋ฉ์๋**

> - `charAt()` : ๋ฌธ์์ด์์ ์ง์ ๋ index์ ์๋ ํ ๋ฌธ์๋ฅผ ๊ฐ์ ธ์จ๋ค.
>
> ```java
> String str = "ABCDE";
> char ch = str.charAt(3);
> ```

> - `substring()` : ๋ฌธ์์ด์ ์ผ๋ถ๋ฅผ ์ถ์ถํ๋ค.
>   ๋จ, ์ฃผ์ํ  ์ ์ `substring(1, 4)`์์ ๋ฒ์์ ๋์ธ `4`๋ ํฌํจ๋์ง ์๋๋ค.
>
> ```java
> String str = "012345";
> String tmp = str.substring(1, 4); //str์์ ํด๋น ๋ฒ์์ ๋ฌธ์๋ค์ ๋ฐํ
> System.out.println(tmp);	  //"123"์ด ์ถ๋ ฅ๋จ
> ```

> - `toCharArray()` : String์ `char[]`์ผ๋ก ๋ณํํ๋ค.
>
> ```java
> char[] chArr = {'A', 'B', 'C'};
> String str = new String(chArr);	//char๋ฐฐ์ด์ String์ผ๋ก
> char[] tmp = str.toCharArray();	//String์ char ๋ฐฐ์ด๋ก
> ```

------

### **โ ๋ค์ฐจ์ ๋ฐฐ์ด**

> - ๋ค์ฐจ์ ๋ฐฐ์ด์ ์์ฑ๊ณผ ์ด๊ธฐํ
>
> ```java
> int[][] score = new int[4][3]; //2์ฐจ์ ๋ฐฐ์ด์ ์์ฑ
> int[][] arr = new int[][] {{1, 2, 3}, {2, 3, 4}, {3, 4, 5}};
> int[][] arr = {{1, 2, 3}, {2, 3, 4}, {3, 4, 5}}; //new int ์๋ต ๊ฐ๋ฅ
> ```

> - ๊ฐ๋ณ ๋ฐฐ์ด
>
> ```java
> int[][] score = new int[3][];	//๋๋ฒ์งธ ์ฐจ์์ ๊ธธ์ด๋ฅผ ์ง์ ํ์ง ์๋๋ค.
> score[0] = new int[3];		//๊ฐ ํ๋ง๋ค ๋ค๋ฅธ ๊ธธ์ด์ ๋ฐฐ์ด์ ์์ฑํ๋ ๊ฒ์ด ๊ฐ๋ฅํ๋ค.
> score[1] = new int[5];
> score[2] = new int[7];
> ```
>
> ![img](https://github.com/kcy97328/Multicampus/blob/main/JAVA/%EA%B0%80%EB%B3%80%20%EB%B0%B0%EC%97%B4.png)
