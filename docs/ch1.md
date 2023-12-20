# 챕터1

블로그에 쓰기엔 내용이 너무 장황하고 정리가 안 되서 `docs` 만들어서 써야겠다.

## JS → JAVA

자스를 자바로 변경하는 게 별거 아닐 줄 알았는데, 진짜 힘들었다.

```js
function statement(param1, param2) {
    
    function function1(param1, param2) {
        // 구현 생략
    }
    
    function function2(param1, param2) {
        // 구현 생략
    }
    
}

```

```js
class Statement {
    
    constructor(param1, param2) {
        this.param1 = param1;
        this.param2 = param2;
    }

    function1() {
        // this.param1, this.param2 사용
    }

    function2() {
        // this.param1, this.param2 사용
    }
    
}
```

위 두 구조는 비슷하니까 자바로 바꾸기 위해 `statement()` 메서드를 처음에 `Statement` 클래스로 생성하고 시작했다가 `Plays` 추출하는 과정에서 한 번 갈아엎었다.

실습하면서 자스니까 되는 일부 문법들이 유연해 보였다. 자바가 구린걸까 자스가 유연한 걸까

애초에 시작을 클래스로 할 수 있을 거 같은데, 뭔가 실습을 위해 일부로 함수로 시작한 거 같은 느낌이 든다.

## for 문

인상 깊었던 점은 for문 추출하는 과정

```java
for (String str : strArray) {
    result1 += logic1();
    result2 += logic2();
}
```

위 코드를

```java
for (String str : strArray) {
    result1 += logic1();
}
```

```java
for (String str : strArray) {
    result2 += logic1();
}
```

두 개로 추출할 때, 처음에 이게 뭐하는 짓이지? 싶었다.

그 다음 페이지에 나오는 글이 참 인상 깊었는데, 

> 반복문을 쪼개서 성능이 느려지지 않을까 걱정할 수 있다.
> 
> 리팩터링이 성능에 상당한 영향을 주기도 한다. 그런 경우라도 나는 개의치 않고 리팩터링 한다.

결론적으로 반복문을 쪼개면서 새로운 클래스도 생성하고 다형성을 통해 확장을 할 수 있었다.

Big-O가 어쩌니, 메모리가 어쩌니 하는 호들갑은 접어둬도 괜찮을 듯

애초에 요즘 컴퓨터가 너무 좋다.

## 변수 인라인 하기

이것도 첨에 뭐하는 거지? 싶었던 것 중 하나

```java
Performance performance = playFor(perf, Plays);
if (performace.type == Type.COMEDY) { .. }
```

```java
if (playFor(perf, Plays) == Type.COMEDY) { .. }
```

처음에는 `performance` 객체 만들어 두고 필드에 접근하는 게 아무리 봐도 나아 보이는데,

이게 가독성이 좋나? 생각이 들고 대체 왜 함수를 n번 호출하는지 이해가 가지 않았음. 

결국 이것도 지역 변수를 제거 하면서 클래스로 추출하는걸 보고 신기했음

## 다형성

OCP 원칙을 지키는 코드로 리팩터링 하는 과정인데, 혼자서 이렇게 코드 짤 수 있을까? 싶었음

마틴 파울러도 처음부터 다형성을 이용해서 코드를 작성하지 않고

1. 일단 절차지향으로 짜고
2. 함수로 쪼개고
3. 클래스로 분리하고
4. 다형성을 활용하고

단계를 거치며 리팩토링 할 것 같으니까 책을 천천히 읽어보며 이해하는 과정을 거쳐야겠다.

## 끝

책을 언제 다 읽을지 모르겠는데, 다 읽고 챕터 1을 다시 보면 쉬웠으면 좋겠다!