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
        - Predicate는 Input 파라미터를 받아서 boolean 값을 return하는 Functional Interface
        - Predicate 구현 방법
          ~~~java
          Predicate<Integer> predicate = x -> x > 0;
          ~~~
        - 단 하나의 Predicate를 만들어서 여러가지 함수(negate, or, and)를 사용 가능
            - Predicate.negate(): 결과 not 연산
            - Predicate.or(Predicate2): Predicate | Predicate2 결과
            - Predicate.and(Predicate2): Predicate & Predicate2 결과
    - Comparator
        - Comparator는 오브젝트 비교를 위한 Functional Interface


- Part 5 Method Reference
    - Method Reference
        - 기존에 이미 선언되어있는 메서드를 지정하고 싶을 때
        - :: 오퍼레이터 사용
        - 생략이 많기 때문에 사용할 메서드의 매개변수의 타입과 리턴 타입을 미리 숙지해야함
        - 메서드 레퍼런스의 4가지 케이스
            ~~~java
            // 1. 클래스의 static method를 지정할 때
            ClassName::staticMethodName
          
            // 2. 선언 된 객체의 instance method를 지정할 때
            objectName::instanceMethodName
          
            // 3. 객체의 instance method를 지정할 때
            ClassName::instanceMethodName
          
            // 4. 클래스의 constructor를 지정할 때
            ClassName::new
            ~~~
            -
                1. 클래스의 static method를 지정할 때

                - ClassName::staticMethodName
                - 클래스의 static method(정적 메서드)를 지정할 때
                    ~~~java
                    Function<String, Integer> str2Int = Integer::parseInt;
                    int five = str2Int.apply("5");
                    ~~~
            -
                2. 선언 된 객체의 instance method를 지정할 때

                - objectName::instanceMethodName
                - 이미 선언되어 있는 객체의 instance method를 지정할 때
                    ~~~java
                    String str = "hello";
                    Predicate<String> equalsToHello = str::equals;
                    boolean helloEqualsworld = equalsToHello.test("world");
                    ~~~
    - Method Reference2
        - 3. 객체의 instance method를 지정할 때
            - ClassName::instanceMethodName
            - 클래스의 instance method(인스턴스 메서드)를 지정할 때
                ~~~java
                Function<String, Integer> strLength = String::length;
                System.out.println(strLength.apply("Hello world!"));
          
                BiPredicate<String, String> equalsString = String::equals;
                System.out.println(equalsString.test("Hello", "World"));
  
                printUserFiled(users, (User user) -> user.getId());
                printUserFiled(users, User::getId);
                ~~~
    - Constructor Reference
        - 4. 클래스의 constructor를 지정할 때
            - ClassName::new
                ~~~java
                // BiFunction<Integer, String, User> userCreator = (id, name) -> new User(id, name);
                BiFunction<Integer, String, User> userCreator = User::new;
                ~~~


- Part 6 Stream
    - 스트림이란?
        - 데이터의 흐름
        - 컬렉션(Collection) 형태로 구성된 데이터를 람다를 이용해 간결하고 직관적으로 프로세스 하게 해줌
        - for, while 등을 이용하던 기존 loop을 대체
        - 손쉽게 병렬 처리를 할 수 있게 해줌
        - stream to list
            ~~~java
                // stream to list(Collectors.toList())
                // 스트림에 있는 데이터 출력하는 방법(리스트로 변경)
            Stream<String> nameStream = Stream.of("Alice", "Bob", "Charlie");
          
            List<String> nameCollect = nameStream.collect(Collectors.toList());
            System.out.println(nameCollect);
            ~~~
      - array to stream
        ~~~java
        // array to stream(Arrays.stream())
        String[] cityArr = new String[]{"San Jose", "Seoul", "Tokyo"};
        Stream<String> cityStream = Arrays.stream(cityArr);
        
        List<String> cityCollect = cityStream.collect(Collectors.toList());
        System.out.println(cityCollect);
        ~~~
      - collection to stream
        ~~~java
        // collection to stream(Set.stream())
        Set<Integer> numberSet = new HashSet<>(Arrays.asList(3, 5, 7));
        Stream<Integer> numberStream = numberSet.stream();
        
        List<Integer> numberCollect = numberStream.collect(Collectors.toList());
        System.out.println(numberCollect);
        ~~~
    - Filter
        - 만족하는 데이터만 걸러내는데 사용
        - Predicate에 true를 반환하는 데이터만 존재하는 stream을 리턴
            ~~~java
            Stream<T> filter(Predicate<? super T> predicate);
            ~~~
    - Map
        - 데이터를 변형하는데 사용
        - 데이터에 해당 함수가 적용된 결과물을 제공하는 stream을 리턴
            ~~~java
            <R> Stream<R> map(Function<? super T, ? extends R> mapper);
            ~~~
    - Stream의 구성요소
        - 스트림 파이프라인
        - 스트림 구성 요소
            - Source(소스): 컬렉션 배열 등
            - Intermediate Operations(중간 처리): 0개 이상의 filter, map 등의 중간처리
            - Terminal Operation(종결 처리): Collect, reduce 등
        - 여러가지의 중간 처리를 이어 붙이는 것이 가능
    - 데이터의 정렬
        - Sorted
        - 데이터가 순서대로 정렬된 stream을 리턴
        - 데이터의 종류에 따라 Comparator가 필요할 수 있음
            ~~~java
            Stream<T> sorted();
            Stream<T> sorted(Comparator<? super T> comparator);
            ~~~
    - 중복제거
        - Distinct
        - 중복된느 데이터가 제거된 stream을 리턴
            ~~~java
            Stream<T> distinct();
            ~~~
  - FlatMap
      - 스트림의 스트림을 납작하게
      - Map + Flatten
      - 데이터에 함수를 적용한 후 중첩된 stream을 연결하여 하나의 stream으로 리턴
          ~~~java
          <R> Stream<R> flatMap(Function<? super T, ? extends Stream<? extends R>> mapper);
          ~~~


- Part 7 Optional
    - 있을 수도 있고 없을 수도 있다
    - Null일수도, 아닐수도있는 object를 담는 상자
        ~~~java
        java.util.Optional<T>
      
        Optional<String> maybeString = Optional.of("Hello world");
        String string = maybeString.get();
        ~~~
    - Optional
        - 안에 있는 값을 확인하고 꺼내는 법
            ~~~java
            // 안의 오브젝트가 null인지 아닌지 체크, Null이 아닐 시 true
            public boolean isPresent();
          
            // Optional 안의 값을 추출. Null이라면 에러
            public T get();
          
            // Optional이 null이 아니라면 Optional안의 값을, null이라면 other로 공급된 값을 리턴
            public T orElse(T other);
          
            // Optional이 null이 아니라면 Optional안의 값을, null이라면 supplier로 공급된 값을 리턴
            public T orElseGet(Supplier<? extends T> supplier);
          
            // Optional이 null이 아니라면 Optional안의 값을, null이라면 exceptionSupplier로 공급된 exception을 던짐
            public <X extends Throwable> T orElseThrow(Supplier<? extends X> exceptionSupplier) throws X;
            ~~~
        - Optional 응용
            ~~~java
            // Optional이 null이 아니라면 action을 실행
            public void ifPresent(Consumer<? super T> action);
          
            // Optional이 null이 아니라면 mapper를 적용
            public <U> Optional<U> map(Function<? super T, ? extends U> mapper);
          
            // mapper의 리턴 값이 또 다른 Optional이라면 한 단계의 Optional이 되도록 납작학 ㅔ해줌
            public <U> Optional<U> flatMap(Function<? super T, ? extends Optional<? extends U>> mapper);
            ~~~


- Part 8 Advanced Stream
    - 여러가지 종결처리
        - Max / Min / Count
            - Stream 안의 데이터의 최대값 / 최소값 / 개수
                ~~~java
                // max - Stream안의 데이터 중 최대값을 반환, Stream이 비어있다면 Optional을 반환
                Optional<T> max(Comparator<? super T> comparator);
              
                // min - Stream안의 데이터 중 최소값을 반환, Stream이 비어있다면 Optional을 반환
                Optional<T> min(Comparator<? super T> comparator);
              
                // count - Stream 안의 데이터 개수를 반환
                long count();
                ~~~
        - allMatch / anyMatch
            ~~~java
            // allMatch - Stream 안의 모든 데이터가 predicate을 만족하면 true
            boolean allMatch(Predicate<? super T> predicate);
          
            // anyMatch - Stream 안의 데이터 중 하나라도 predicate을 만족하면 true
            boolean allMatch(Predicate<? super T> predicate);
            ~~~
        - findFirst / findAny
            ~~~java
            // findFirst - Stream 안의 첫번째 데이터를 반환. Stream이 비어있다면 비어있는 Optional을 반환
            Optional<T> findFirst();
          
            // findAny - Stream 안의 아무 데이터나 반환. 순서가 중요하지 않고 Parallel Stream을 사용할 때 최적화를 할 수 있다. 마찬가지로 Stream이 비어있다면 비어있는 Optional을 반환
            Optional<T> findAny();
            ~~~
        - Reduce
            - 주어진 함수를 반복 적용해 Stream안의 데이터를 하나의 값으로 합치는 작업
            - Max / Min / Count도 사실 reduce의 일종
                ~~~java
                // reduce1 - 주어진 accumulator를 이용해 데이터를 합침. Stream이 비어있을 경우 빈 Optional을 반환
                Optional<T> reduce(BinaryOperator<T> accumulator);
              
                // reduce2 - 주어진 초기값과 accumulator를 이용. 초기값이 있기 때문에 항상 반환값이 존재
                T reduce(T identity, BinaryOperator<T> accumulator);
              
                // reduce3 - 합치는 과정에서 타입이 바뀔 경우 사용. Map + reduce로 대체 가능
                <U> U reduce<U identity, BiFunction<U, ? super T, U> accumulator, BinaryOperator<U> combiner);
                ~~~
        - Collectors
            ~~~java
            // Collectors.toList()
            List<Integer> numberList = Stream.of(3, 5, -3, 3, 4, 5)
            .collect(Collectors.toList());
      
            // Collectors.toSet()
            Set<Integer> numberSet = Stream.of(3, 5, -3, 3, 4, 5)
            .collect(Collectors.toSet());
      
            // Collectors.mapping()
            List<Integer> numberList2 = Stream.of(3, 5, -3, 3, 4, 5)
            .collect(Collectors.mapping(x -> Math.abs(x), Collectors.toList()));
      
            // Collectors.mapping()
            Set<Integer> numberSet2 = Stream.of(3, 5, -3, 3, 4, 5)
            .collect(Collectors.mapping(x -> Math.abs(x), Collectors.toSet()));
      
            // Collectors.reducing()
            Integer sum = Stream.of(3, 5, -3, 3, 4, 5)
            .collect(Collectors.reducing(0, (x, y) -> x + y));
            ~~~
        - toMap
            ~~~java
            public static <T, K, U> Collector<T, ?, Map<K, U>> toMap(
                Function<? super T, ? extends K> keyMapper,
                Function<? super T, ? extends U> valueMapper
            ) 
            ~~~
            - Stream 안의 데이터를 map의 형태로 반환해주는 collector
            - keyMapper - 데이터를 map의 key로 변환하는 Function
            - valueMapper - 데이터를 map의 value로 변환하는 Function
        - Grouping By
            ~~~java
            public static <T, K> Collector<T, ?, Map<K, List<T>>>
                groupingBy(Function<? super T, ? extends K> classifier)
            ~~~
            - Stream안의 데이터에 classifier를 적용했을 때 결과값이 같은 값끼리 List로 모아서 Map의 형태로 반환해주는 collector 이 때 key는 classifier의 결과값, value는 그 결과값을 갖는 데이터들.
            - 예를 들어 stream에 {1, 2, 5, 7, 9, 12, 13}이 있을 때 classifier가 x -> x % 3이라면 반환되는 map은 {0 = [9, 12], 1 = [1, 7, 13], 2 = [2, 5]}
        - Partitioning By
            ~~~java
            public static <T>
                Collector<T, ?, Map<Boolean, List<T>>> partitioningBy(
                    Predicate<? super T> predicate)
          
            public static <T, D, A>
                Collector<T, ?, Map<Boolean, D>> partitioningBy(
                    Predicate<? super T> predicate,
                    Collector<? super T, A, D> downstream)
            ~~~
            - GroupingBy와 유사하지만 Function 대신 Predicate을 받아 true와 false 두 key가 존재하는 map을 반환하는 collector
            - 마찬가지로 downstream collector를 넘겨 List 이외의 형태로 map의 value를 만드는 것 역시 가능
        - For Each
            ~~~java
            void forEach(Consumer<? super T> action);
            ~~~
            - 제공된 action을 Stream의 각 데이터에 적용해주는 종결 처리 메서드
            - java의 iterable 인터페이스에도 forEach가 있기 때문에 Stream의 중간 처리가 필요없다면 iterable collection(Set, List 등)에서 바로 쓰는 것도 가능
        - Parallel Stream
            ~~~java
            List<Integer> numbers = Arrays.asList(1, 2, 3);
            Stream<Integer> parallelStream = numbers.parallelStream();
            Stream<Integer> parallelStream2 = numbers.stream().parallel();
            ~~~
            - 여러개의 스레드를 사용하여 stream의 처리 과정을 병렬화(parallelize)
            - 중간 과정은 병렬처리 되지만 순서가 있는 Stream의 경우 종결 처리 했을때의 결과물이 기존의 순차적 처리와 일치하도록 종결 처리과정에서 조정된다
            - 즉 List로 collect한다면 순서가 항상 올바르게 나온다는 것.
            - 장점
                - 굉장히 간단하게 병렬 처리를 사용할 수 있게 해준다.
                - 속도가 비약적으로 빨라 질 수 있다.
            - 단점
                - 항상 속도가 빨라지는 것은 아니다.
                - 공통으로 사용하는 리소스가 있을 경우 잘못된 결과가 나오거나 아예 오류가 날 수 있다(Deadlock)
                - 이를 막기 위해 mutex, semaphore등 병럴 처리 기술을 이용하면 순차처리보다 느려질수있다.
        