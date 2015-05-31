

####Type-safe Querying using Querydsl

-type-safe 란?
    어떠한 오퍼레이션(연산)도 정의되지 않은 결과를 내놓지 않는것, 즉, 예측불가능한 결과를 내지 않는것을 뜻한다.
    예를 들면, 
    1 + 1 = 2 이지만, 1 + "1" 의 연산에 대해서는 결과를 알 수 없다. 
    Type-Safe하다고 알려진 언어에서는 이를 에러처리를 해주지만, 
    Type-Safe하지 않은 언어, 예를 들어 자바스크립트같은 언어에서는 이것을 "11" 로 처리한다. 
    그래서 Javascript는 Type-Safe하다고 하지 않는다.
    일반적으로, 많이 들었겠지만, c# / java 와 같은 언어들을 일반적으로 type-safe 하다라고 한다.


Query 의 문제점?
- Query는 문자, Type-check 불가능.
- 실행해 보기 전까지 작동여부확인 불가.

QueryDSL-SQL
- SQL을 JAVA로 type-safe하게 개발 할 수 있는 프레임워크
- JPA, JDO, SQL 같은 Backends를 위해 Type-safe SQL을 만드는 프레임워크
- 즉, Querydsl은 JPQL(HQL)을 typesafe 하게 작성하기 위해 만들어짐.

JPA에서 Query방법은 크게 3가지
- JPQL
- Criteria API
- MetaModel Criteria API(type-safe)


DSL
- 도메인 + 특화 + 언어
- 특정한 도메인에 초점을 맞춘 제한적인 표현력을 가진 컴퓨터 프로그래밍 언어
- 특징 : 단순,간결, 유창
- 다양한 저장소 조회 기능 통합

####querydsl의 일반 용법
    from: 쿼리 소스를 추가한다. 첫 번째 인자는 메인 소스가 되고, 나머지는 변수로 취급한다.
    where: 쿼리 필터를 추가한다. 가변인자나 and/or 메서드를 이용해서 필터를 추가한다.
    groupBy: 가변인자 형식의 인자를 기준으로 그룹을 추가한다.
    having: Predicate 표현식을 이용해서 "group by" 그룹핑의 필터를 추가한다.
    orderBy: 정렬 표현식을 이용해서 정렬 순서를 지정한다. 숫자나 문자열에 대해서는 asc()나 desc()를 사용하고, OrderSpecifier에 접근하기 위해 다른 비교 표현식을 사용한다.
    limit, offset, restrict: 결과의 페이징을 설정한다. limit은 최대 결과 개수, offset은 결과의 시작 행, restrict는 limit과 offset을 함께 정의한다.


---

http://www.slideshare.net/timowestkamper
https://github.com/spring-projects/spring-data-book/tree/master/querydsl
http://aeternum.egloos.com/2954659
http://www.querydsl.com/static/querydsl/3.6.3/reference/ko-KR/html_single/

참고 동영상 : https://www.youtube.com/watch?v=ho0fQt8v_HA
