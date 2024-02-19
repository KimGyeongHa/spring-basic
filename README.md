# spring 기본


## 생성자 주입을 위한 기본

	  DI 의존관계 주입, 의존성 주입
	  
	  DIP를 지키기위하여 
	  설정을위한 class를 따로 만들어 관리
	  애플리케이션의 실제동작에 필요한 구현객체를 생성
	  
	  생성한 객체 인스턴스의 참조를 생성자 주입을 통해 연결
	  
	  인터페이스에만 의존하여 구현객체에 대한 값은 설정을 위한 class에서만 전담
	  생성자 주입을 통하여 생성 된 인터페이스로 실행에만 집중
	  
	  bean생성
	  
	  @Configuration
	  설정정보로 인식하며,
	  미사용시 스프링에서 제공하는 singleton패턴을 사용하지 못한다.
	  
	  @Bean으로 등록
	  
	  @Bean으로 적힌 메서드를 모두 호출 후 반환 된 
	  객체를 스프링컨테이너에 등록한다
	  
	  bean이름은 메서드명 값은 return값이 스프링 컨테이너에 등록
	  
	  동일한 bean은 bean name을 다르게 설정하여 오류해결할 수 있다.
	  동일한 bean 조회시 beanOfType으로 조회
	  
	  부모 타입으로 조회시 자식이 둘 이상이면 중복오류
	  bean이름으로 지정하여 해결
	  
	  ApplicationContext기능 beanfactory의 하위객체로서 인터페이스이다.
	  
	  1. 메시지소스를 활용한 국제화기능
	  2. 환경변수
	  3. 애플리케이션 이벤트
	  4. 편리한 리소스조회
	  
	  spring definition으로 spring bean의 메타정보로 추상화한다.
	  
	  @ComponentScan
	  
	  @Componet가 붙은 어노테이션은 다 bean으로 등록
	  
	  생성자 주입은 @Autowired 
	  
	  싱글톤 컨테이너
	  
	  bean내에서 private전역변수를 사용하는대신 지역변수를 통해 개발하여
	  변수 값이 덮어씌어지는 상황을 방지하자
	  
	  수동 빈 등록시 자동빈 등록을 오버라이딩한다.
  

***

## 의존관계 자동 주입

	  생성자 주입을 사용
	  
	  필드주입 시 테스트코드를 작성할 떄마다 새롭게 생성해주어야하며
	  수정자 주입 시 setter를 개방하여 오류에 취약할 수 있다.
	  생성자 주입을 하게된다면 기존 자바소스로도 테스트코드를 작성할 수 있고 final키워드를 통하여 
	  누락을 방지할 수 있다.
	  
	  여러개의 Bean등록
	  여러개의 구현체객체에 @Component로 Bean에 등록시 오류
	  
	  @Autowired
	  타입 매칭의 결과가 두개 이상일 경우 필드명, 파라미터 명으로 빈이름 매칭
	  
	  @Qualifier 의존관계주입이름 설정
	  
	  @Primary 해당 어노테이션이 붙은 필드인식
	  
	  @Qualifier @Primary 중 우선순위는 @Qualifier가 더 높다. 
	  
	  spring은 자동보다는 수동, 넓은 선택범위보다는 좁은 범위가 우선 선택권을 가진다.
	  
	  
	   new AnnotationConfigApplicationContext()의 생성자에 매개변수로 클래스 정보를 넘겨주면 해당 클래스도 스프링 빈으로 등록
	  
	  동적으로 빈을 사용시 Map또는 List로 받아 사용할 수 있다.
	  
	  기술 지원 객체를 스프링 빈은 수동으로 등록하여 명확하게 들어내는 것이 좋다.

***

# 빈생명주기 콜백

	  스프링 빈의 이벤트 라이프사이클 
	  
	  1. 스프링 컨테이너 생성
	  
	  2. 스프링 빈 생성
	  
	  3. 의존관계 주입
	  
	  4. 초기화 콜백
	  
	  5. 사용
	  
	  6. 소멸전 콜백
	  
	  7. 스프링종료
	  
	  스프링은 의존관계 주입이 완료되어야 필요한데이터를
	  사용할 수 있다. 그래서
	  초기화 작업은 의존관계 주입이 모두 완료되고
	  실행하여야 한다.
	  
	  빈 주입이 완료되었을 때
	  InitializingBean
	  
	  빈 생명주기가 종료될 떄
	  DisposalbeBean
	  
	  
	  외부라이브러리에 초기화 혹은 종료를 해야하면
	  
	  @Bean(initMethod = "함수명", distroyMethod = "함수명")
	  distoryMethod는 bean으로 등록하는 값이
	  생명주기를 소멸하는 인스턴스가 close or shutdown이라면 자동으로 처리해준다.
	  
	  
	  아니라면 초기화메서드와 종료메서드에 해당 어노테이션기입
	  
	  @PostConstruct
	  
	  @PreDestory
	  
	  AutoCloseable

***

## 빈스코프

	  빈이 존재할 수 있는 범위
	  
	  스코프 타입 
	  
	  싱글톤 : 기본 스코프, 컨테이너 시작과 종료까지 유지되는 스코프

---
	 
	  프로토타입 : 생성과 의존관계 주입까지만 관여하는 스코프
	  
	  항상 새로운 bean을 생성해서 반환
	  
	  @PreDestory같은 종료메서드가 호출되지않는다.
	  
	  스코프 빈은 조회할 떄 생성되고 초기화
	  
	  싱글톤 스코프 안에서 프로토타입 스코프를
	  주입받을 경우 프로토타입 스코프가 싱글톤 스코프처럼
	  동작한다.
	  
	  직접찾는것 Dependency Lookup(DL) 을 사용하여 DI
	  
	  ObejectProvider로 DL 가능
	  ObejectProvider는 
	  
	  spring bean을 일시적으로
	  조회해주기 위한 수단으로 활용
	  
	  ObjectProvider or jsr 330(외부 library)
	  
	  스프링 DL시에는 ObjectProvider
	  외부컨테이너 DL시에는 JSR330사용
---
	웹스코프
	
	고객의 요청이 들어올 떄마다 새로운 빈이 생성된다.
	
	request : http요청 하나가 들어오고 나갈떄 까지 유지되는 스코프
	각각의 요청마다 관리
	
	session : http session과 동일한 생명주기를 가지는 스코프
	
	application : 서블릿컨텍스트와 동일한 생명주기를 가진다
	
	websocket : 웹소켓과 동일한 생명주기를
	
	provider를 통하여 반환받지 않으면 스프링 컨테이너 실행 시 
	생성자를 통해 웹스코프를 호출 시 에러
	
	provider를 통해 빈 객체를 생성해 놓고 요청이 있을 시 반환받는 것
	을 목표로한다.
	
	프록시객체를 사용하여 singleton처럼 받아 사용할 수 있다.
	가짜객체를 컨테이너에 주입 후 필요한 시점에 웹스코프를 호출하여 사용하는 전략
