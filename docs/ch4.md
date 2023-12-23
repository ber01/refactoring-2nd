# 챕터4

챕터2, 챕터3의 내용은 되게 중요한 이야기를 하지만 아직까지 크게 와닿지는 않는 이론적인 내용

챕터4는 테스트 코드에 관련된 내용이다.

챕터1 리팩터링 하면서 커밋을 수십번 했는데, 할 때 마다 테스트를 돌렸다.

근데, 딱 한 번 테스트 건너 뛰고 커밋을 두 번 연속으로 한 적이 있었는데 그 때 오류가 났음

함수 추출하기 과정에서 `+=` 연산을 해야 되는 걸 `=` 연산을 해서 났던 오류였는데,

작은 단위 커밋 + 테스트 코드가 없었으면 절대 못찾을 오류였을 것

## 이번에 해맸던 점

Producer 클래스의 생성자는 Province와 data를 매개변수로 받는다.

```js
constructor(aProvince, data) { .. }
```

이걸 Province 클래스에서 반복할 때 생성자를 호출한다.

```js
doc.producers.forEach(d -> this.addProducer(new Producer(this, d)));
```

처음에 이 코드를 보고 아래 처럼 이해를 했음

```java
public Producer {
    
    public Producer(Province province, Producer producer) {
        ..
    }
    
}
```

Producer가 생성자에서 Producer를 호출하는 줄 알았는데, 알고보니 JSON 객체의 데이터 일부를 받아오는 거라서 Data 클래스를 하나 생성했음

이런식으로 하니까 시간이 너무 오래걸린다.

일단 계속 해보고 너무 안 되면 자스도 고려해봐야 될 듯 
