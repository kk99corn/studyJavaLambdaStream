# studyJavaLambdaStream

## Java Lambda & Stream

- 기간: 2022.10.11 ~
- 프로젝트 구성
    - Java 18
- 강의자료: https://github.com/haedalfamily/fastcampus-stream

---------------

## Study Notes

- Part 1 강의소개
    - 강의 목적
        - 함수형 프로그래밍(Functional Programming)이 무엇이고 왜 쓰는가?
        - Lambda Expression & Stream 사용법 및 유스케이스
    - 강의 선행 조건
        - Java 기본 문법 숙지
        - OOP에 대한 기본적인 이해
        - 컬렉션(List, Map, Set 등) 자료구조에 대한 이해
    - 강의 환경
        - Java 8 이상 환경


- Part 2 함수형 프로그래밍
    - 합수형 프로그래밍이란?
        - 명령형 프로그래밍(Imperative Programming)
            - OOP(객체 지향 프로그래밍)
            - How to do?(어떻게 해야 하는가? 중점)
        - 선언형 프로그래밍(Declarative Programming)
            - Functional Programming(함수형 프로그래밍)
            - What to do?(무엇을 해야 하는가? 중점)
    - 1급 시민으로서의 함수(Function as First-Class Citizen)
        - 1급 시민의 조건
            - 함수/메서드의 매개변수(parameter)로서 전달할 수 있는가?
            - 함수/메서드의 반환값(return)이 될 수 있는가?
            - 변수에 담을 수 있는가?

              -> 함수 자체를 Object 형태로 나타낸다면?? 위에 언급한 모든것들이 가능해짐
    - 왜 이걸 알아야 하는가?
        - 함수형 프로그래밍을 통해 우리가 얻는 것들
            - 역할에 충실한 코드
                - 가독성 좋은 코드
                - 유지/보수에 용이
                - 버그로부터 안전
                - 확정성에 용이
            - 패러다임의 전환
                - Stream, Optional 등을 활용하여, 깔끔하고 간결한 코드 작성이 가능


- Part 3 람다 표현식(Lambda Expression)
    - Function Interface
        - java.util.function
          ~~~java
          // T: apply parameter type
          // R: apply return type
          @FunctionalInterface
          public interface Function<T, R> {
                R apply(T t);
          }
          ~~~
    - 한 걸음씩 람다로
        - 함수(function)의 구성 요소
            - 함수의 이름
            - 반환값의 타입(return type)
            - 매개변수(parameters)
            - 함수의 내용(body{})
        - 람다 표현식(Lambda Expression)의 구성 요소
            - 이름이 없는 함수(익명 함수: Anonymous function)
                ~~~java
                (Integer x) -> {
                    return x + 10;
                }
                ~~~
            - 더 단순하게
                - 매개변수의 타입이 유추 가능할 경우 타입 생략 가능
                - 매개변수가 하나일 경우 괄호 생략 가능
                - 바로 리턴하는 경우 중괄호 생략 가능
                    ~~~java
                    x -> x + 10;
                    ~~~
    - BiFunction Interface
        - 매개변수가 두 개일 때
          ~~~java
          // T: apply parameter type
          // U: apply parameter type
          // R: apply return type
          @FunctionalInterface
          public interface BiFunction<T, U, R> {
                R apply(T t, U u);
          }
          ~~~
            ~~~java
            BiFunction<Integer, Integer, Integer> add = (Integer x, Integer y) -> {
                return x + y;
            };
            
            BiFunction<Integer, Integer, Integer> add = (x, y) -> x + y;
            ~~~
    - Functional Interface
        - 매개변수가 3개 이상 필요한 경우, 직접 interface를 만들어 구현이 가능하다.
          ~~~java
          @FunctionalInterface
          public interface TriFunction<T, U, V, R> {
            R apply(T t, U u, R r);
          }
          ~~~


- Part 4 Functional Interface
    - Supplier
        - Supplier는 Input 파라미터 없이 무언가를 return하기만 하는 Functional Interface
        - Supplier 구현 방법
          ~~~java
          // 문자열을 반환하는 Supplier
          Supplier<String> myStringSupplier = () -> "hello word";
          
          // 랜덤한 더블을 반환하는 Supplier
          Supplier<Double> myRandomSupplier = Math::random;
          ~~~
        - Supplier를 파라미터 인자로 사용하는 법
          ~~~java
          public static void printRandomDoubles(Supplier<Double> randomSup, int count) {
            for (int i = 0; i < count; i++) {
                System.out.println(randomSup.get());
             }
          }
          ~~~
    - Consumer
        - Consumer는 Supplier와 반대로 무언가를 input으로 받기만하고 return이 없는 Functional Interface
        - Consumer 구현 방법
            ~~~java
            Consumer<Double> doubleConsumer = x -> System.out.println("Processing double: " + x);
            ~~~
    - BiConsumer
        - 2개의 타입 인자를 받는 Consumer
    - Predicate
    - Comparator